package com.hotel.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.hotel.dao.RtypeDao;
import com.hotel.entity.Rtype;

public class RtypeDaoImpl extends HibernateDaoSupport implements RtypeDao {

	@Override
	public List<Rtype> findAll() throws Exception {
		// TODO Auto-generated method stub
		String sql = "from Rtype";
		List<Rtype> rtypeList = (List<Rtype>) this.getHibernateTemplate().find(
				sql);
		return rtypeList;
	}

}
