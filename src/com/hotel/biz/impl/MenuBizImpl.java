package com.hotel.biz.impl;

import java.util.List;

import com.hotel.biz.MenuBiz;
import com.hotel.dao.MenuDao;
import com.hotel.entity.Hmenu;

public class MenuBizImpl implements MenuBiz {
	private MenuDao menuDao;

	@Override
	public int addMenu(Hmenu menu) throws Exception {
		// TODO Auto-generated method stub
		return menuDao.addMenu(menu);
	}

	@Override
	public int deleteMenu(Integer mid) throws Exception {
		Hmenu menu = menuDao.findMenuById(mid);
		return menuDao.deleteMenu(menu);
	}

	@Override
	public int updateMenu(Hmenu menu) throws Exception {
		// TODO Auto-generated method stub
		return menuDao.updateMenu(menu);
	}

	@Override
	public List<Hmenu> findMenus() throws Exception {
		// TODO Auto-generated method stub
		return menuDao.findMenus();
	}

	@Override
	public Hmenu findMenuById(Integer mid) throws Exception {
		// TODO Auto-generated method stub
		return menuDao.findMenuById(mid);
	}

	public MenuDao getMenuDao() {
		return menuDao;
	}

	public void setMenuDao(MenuDao menuDao) {
		this.menuDao = menuDao;
	}

	@Override
	public List<Hmenu> findMenuByPage(Integer page, Hmenu menu)
			throws Exception {
		// TODO Auto-generated method stub
		return menuDao.findMenuByPage(page, menu);
	}

	@Override
	public int findMenuPages(Hmenu menu) throws Exception {
		// TODO Auto-generated method stub
		return menuDao.findMenuPages(menu);
	}

	@Override
	public List<Hmenu> findHmenuByPage(Integer page) throws Exception {
		// TODO Auto-generated method stub
		return menuDao.findHmenuByPage(page);
	}

	@Override
	public int findPages() throws Exception {
		// TODO Auto-generated method stub
		return menuDao.findPages();
	}

}
