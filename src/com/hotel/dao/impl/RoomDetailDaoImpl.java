package com.hotel.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.hotel.dao.RoomDetailDao;
import com.hotel.entity.Roomdetail;

public class RoomDetailDaoImpl extends HibernateDaoSupport implements
		RoomDetailDao {

	@Override
	public int add(Roomdetail rmd) throws Exception {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(rmd);
		return 1;
	}

	@Override
	public Roomdetail findByRid(Integer rid) throws Exception {
		// TODO Auto-generated method stub
		String sql = " from Roomdetail rd left join fetch rd.room where rd.room.RId="
				+ rid;
		List<Roomdetail> rmdList = (List<Roomdetail>) this
				.getHibernateTemplate().find(sql);
		if (rmdList.size() > 0)
			return rmdList.get(0);
		return null;
	}

	@Override
	public int deleteRoomDeatilByRid(Integer rid) throws Exception {
		// TODO Auto-generated method stub
		String sql = " from Roomdetail rd where rd.rdId=" + rid;
		List<Roomdetail> rmdList = (List<Roomdetail>) this.getHibernateTemplate().find(sql);
		if (rmdList.size() > 0)
			this.getHibernateTemplate().delete(rmdList.get(0));
		return 1;
	}
      
}
