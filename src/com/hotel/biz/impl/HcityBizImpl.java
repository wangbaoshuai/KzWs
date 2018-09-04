package com.hotel.biz.impl;

import java.util.List;

import com.hotel.biz.HcityBiz;
import com.hotel.dao.HcityDao;
import com.hotel.entity.Hcity;

public class HcityBizImpl implements HcityBiz {
	private HcityDao hctDao;

	@Override
	public List<Hcity> findAll() throws Exception {
		// TODO Auto-generated method stub
		return hctDao.findAll();
	}

	public HcityDao getHctDao() {
		return hctDao;
	}

	public void setHctDao(HcityDao hctDao) {
		this.hctDao = hctDao;
	}

}
