package com.hotel.dao;

import java.util.List;

import com.hotel.entity.Rtype;

public interface RtypeDao {
	// 遍历所有的客房类型
	public List<Rtype> findAll() throws Exception;

}
