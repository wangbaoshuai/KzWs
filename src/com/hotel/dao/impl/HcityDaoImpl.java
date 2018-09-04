package com.hotel.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.hotel.dao.HcityDao;
import com.hotel.entity.Hcity;

public class HcityDaoImpl extends HibernateDaoSupport implements HcityDao {

	@Override
	public List<Hcity> findAll() throws Exception {
		// TODO Auto-generated method stub
		String sql = "from Hcity";
		Query query = this.getSession().createQuery(sql);
		return query.list();
	}

}
