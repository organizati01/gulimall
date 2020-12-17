package com.atguigu.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.common.utils.PageUtils;
import com.atguigu.gulimall.product.entity.SkuInfoEntity;

import java.util.Map;

/**
 * sku信息
 *
 * @author lantian
 * @email lantian@lantianmail.com
 * @date 2020-12-17 10:10:35
 */
public interface SkuInfoService extends IService<SkuInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

