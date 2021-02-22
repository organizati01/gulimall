package com.atguigu.gulimall.product.controller;

import com.atguigu.common.utils.R;
import com.atguigu.gulimall.product.entity.CategoryEntity;
import com.atguigu.gulimall.product.utils.MinIoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.UUID;

/**
 * Created by dch on 2021/2/21.
 */

@RestController
@RequestMapping("product/")
public class FileController {

    @Value("${minio.bucketImageName}")
    private String bucketImageName;
    @Value("${minio.serviceName}")
    private String serviceName;

    @Autowired
    private MinIoUtil minIoUtil;

    @PostMapping("/upload")
    public R info(@RequestParam(value = "file",required = true) MultipartFile file){
        if (file.getSize() == 0 || file.isEmpty()) {
            return R.error("没有文件");
        }
        try {
            if (!minIoUtil.bucketExists(bucketImageName)) {
                return R.error("桶不存在, 请创建");
            }
            // 获取文件全名称
            String originalFilename = file.getOriginalFilename();
            // 获取文件类型
            String contentType = file.getContentType();
            // 获取输入流
            InputStream inputStream = file.getInputStream();
            // 存储文件名称
            assert originalFilename != null;
            String newFileName = serviceName
                    + "/"
                    + UUID.randomUUID().toString().replaceAll("-", "")
                    + originalFilename.substring(originalFilename.lastIndexOf("."));

            minIoUtil.putObject(bucketImageName, newFileName, contentType, inputStream);
            inputStream.close();
            // 获取访问url路径
            String objectUrl = minIoUtil.getObjectUrl(bucketImageName, newFileName);
            return R.ok().put("objectUrl",objectUrl);
        } catch (Exception e) {
            e.printStackTrace();
            return R.error(e.getMessage());
        }
    }
}
