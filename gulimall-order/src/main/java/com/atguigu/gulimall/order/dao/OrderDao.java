package com.atguigu.gulimall.order.dao;

import com.atguigu.gulimall.order.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author ideapad300-win7
 * @email 361763560@qq.com
 * @date 2021-01-06 21:45:11
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
