package com.hotel.dao;

import java.util.List;

import com.hotel.entity.Hcity;

public interface HcityDao {
	// 遍历所有的城市
	public List<Hcity> findAll() throws Exception;
}
