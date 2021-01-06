package com.atguigu.gulimall.member.dao;

import com.atguigu.gulimall.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author ideapad300-win7
 * @email 361763560@qq.com
 * @date 2021-01-06 21:32:18
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
