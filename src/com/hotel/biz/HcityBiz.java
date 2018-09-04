package com.hotel.biz;

import java.util.List;

import com.hotel.entity.Hcity;

public interface HcityBiz {
	// 遍历所有的城市
	public List<Hcity> findAll() throws Exception;
}
