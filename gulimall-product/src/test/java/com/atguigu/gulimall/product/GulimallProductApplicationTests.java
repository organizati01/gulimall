package com.atguigu.gulimall.product;

import com.atguigu.gulimall.product.entity.BrandEntity;
import com.atguigu.gulimall.product.service.BrandService;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Iterator;
import java.util.List;

@SpringBootTest
class GulimallProductApplicationTests {

	@Autowired
	BrandService brandService;

	@Test
	void contextLoads() {
//		BrandEntity brandEntity = new BrandEntity();
//		brandEntity.setName("华为");
//		brandService.save(brandEntity);

//		brandEntity.setBrandId(1L);
//		brandEntity.setName("小米");
//		brandEntity.setDescript("小米品牌");
//		brandService.updateById(brandEntity);

		/*List<BrandEntity> brand_id = brandService.list(new QueryWrapper<BrandEntity>().eq("brand_id", 1L));
		Iterator<BrandEntity> iterator = brand_id.iterator();
		while (iterator.hasNext()){
			BrandEntity next = iterator.next();
			System.out.println(next);
		}
		System.out.println("保存成功");*/
	}

}
