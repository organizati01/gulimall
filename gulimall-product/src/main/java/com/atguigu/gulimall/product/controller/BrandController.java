package com.atguigu.gulimall.product.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import com.atguigu.common.valid.UpdateStatusGroup;
//import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.atguigu.gulimall.product.entity.BrandEntity;
import com.atguigu.gulimall.product.service.BrandService;
import com.atguigu.common.utils.PageUtils;
import com.atguigu.common.utils.R;

import javax.validation.Valid;


/**
 * 品牌
 *
 * @author lantian
 * @email lantian@lantianmail.com
 * @date 2020-12-17 10:53:21
 */
@RestController
@RequestMapping("product/brand")
public class BrandController {
    @Autowired
    private BrandService brandService;

    //只拦截当前类发生的异常
    /*@ExceptionHandler(Exception.class)
    @ResponseBody
    public void error3(Exception e){

        System.out.println("发生了异常 error3 "+e);
    }*/

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("product:brand:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = brandService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{brandId}")
    //@RequiresPermissions("product:brand:info")
    public R info(@PathVariable("brandId") Long brandId){
		BrandEntity brand = brandService.getById(brandId);

        return R.ok().put("brand", brand);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("product:brand:save")
    public R save(@Valid @RequestBody BrandEntity brand){
        //如果校验发生错误
        /*if(bindingResult.hasErrors()){
            Map<String,String> map = new HashMap<>();
            bindingResult.getFieldErrors().forEach(item->{
                String field = item.getField();
                String message = item.getDefaultMessage();
                map.put(field,message);
            });
            return R.error(400,"提交的数据不合法").put("data",map);
        }else{
            brandService.save(brand);
            return R.ok();
        }*/
        brandService.save(brand);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("product:brand:update")
    public R update(@RequestBody BrandEntity brand){
		brandService.updateById(brand);

        return R.ok();
    }
    /**
     * 修改状态
     */
    @RequestMapping("/update/status")
    //@RequiresPermissions("product:brand:update")
    public R updateStatus( @RequestBody BrandEntity brand){
        brandService.updateById(brand);
        return R.ok();
    }
    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("product:brand:delete")
    public R delete(@RequestBody Long[] brandIds){
		brandService.removeByIds(Arrays.asList(brandIds));

        return R.ok();
    }

}
