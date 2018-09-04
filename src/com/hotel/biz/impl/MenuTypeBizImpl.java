package com.hotel.biz.impl;

import java.util.List;

import com.hotel.biz.MenuTypeBiz;
import com.hotel.dao.MenuTypeDao;
import com.hotel.entity.Menutype;

public class MenuTypeBizImpl implements MenuTypeBiz {
	private MenuTypeDao mntyDao;

	@Override
	public int addMenuType(Menutype mt) throws Exception {
		// TODO Auto-generated method stub
		return mntyDao.addMenuType(mt);
	}

	@Override
	public int deleteMenuType(Integer mtid) throws Exception {
		// TODO Auto-generated method stub
		return mntyDao.deleteMenuType(mtid);
	}

	@Override
	public int updateMenuType(Menutype mt) throws Exception {
		// TODO Auto-generated method stub
		return mntyDao.updateMenuType(mt);
	}

	@Override
	public List<Menutype> findAll() throws Exception {
		// TODO Auto-generated method stub
		return mntyDao.findAll();
	}

	public MenuTypeDao getMntyDao() {
		return mntyDao;
	}

	public void setMntyDao(MenuTypeDao mntyDao) {
		this.mntyDao = mntyDao;
	}

}
