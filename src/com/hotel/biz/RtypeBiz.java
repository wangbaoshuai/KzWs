package com.hotel.biz;

import java.util.List;

import com.hotel.entity.Rtype;

public interface RtypeBiz {
	// 遍历所有的客房类型
	public List<Rtype> findAll() throws Exception;
}
