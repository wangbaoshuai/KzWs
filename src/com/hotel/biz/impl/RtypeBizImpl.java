package com.hotel.biz.impl;

import java.util.List;

import com.hotel.biz.RtypeBiz;
import com.hotel.dao.RtypeDao;
import com.hotel.entity.Rtype;

public class RtypeBizImpl implements RtypeBiz {
	private RtypeDao rtyDao;

	@Override
	public List<Rtype> findAll() throws Exception {
		// TODO Auto-generated method stub
		return rtyDao.findAll();
	}

	public RtypeDao getRtyDao() {
		return rtyDao;
	}

	public void setRtyDao(RtypeDao rtyDao) {
		this.rtyDao = rtyDao;
	}

}
