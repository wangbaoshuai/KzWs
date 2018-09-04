package com.hotel.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.hotel.dao.MenuTypeDao;
import com.hotel.entity.Menutype;

public class MenuTypeDaoImpl extends HibernateDaoSupport implements MenuTypeDao {

	@Override
	public int addMenuType(Menutype mt) throws Exception {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(mt);
		return 1;
	}

	@Override
	public int deleteMenuType(Integer mtid) throws Exception {
		// TODO Auto-generated method stub
		String sql = "delete from Menutype mt where mt.mtId=" + mtid;
		List<Menutype> mtyLsit = (List<Menutype>) this.getHibernateTemplate()
				.find(sql);
		if (mtyLsit.size() > 0)
			this.getHibernateTemplate().delete(mtyLsit.get(0));
		return 1;
	}

	@Override
	public int updateMenuType(Menutype mt) throws Exception {
		// TODO Auto-generated method stub
		Menutype mnty = (Menutype) this.getHibernateTemplate().get(
				Menutype.class, mt.getMtId());

		if (mt.getMtName() != null && !"".equals(mt.getMtName()))
			mnty.setMtName(mt.getMtName());
		this.getHibernateTemplate().update(mnty);
		return 1;
	}

	@Override
	public List<Menutype> findAll() throws Exception {
		// TODO Auto-generated method stub
		String sql = " from Menutype";
		List<Menutype> mtyLsit = (List<Menutype>) this.getHibernateTemplate()
				.find(sql);
		return mtyLsit;
	}

}
