package com.hotel.biz.impl;

import java.util.List;

import com.hotel.biz.NewBiz;
import com.hotel.dao.NewDao;
import com.hotel.entity.Hnew;

public class NewBizImpl implements NewBiz {
	private NewDao newDao;

	@Override
	public int addNew(Hnew news) throws Exception {
		// TODO Auto-generated method stub
		return newDao.addNew(news);
	}

	@Override
	public int deleteNew(Integer nid) throws Exception {
		// TODO Auto-generated method stub
		return newDao.deleteNew(nid);
	}

	@Override
	public int updateNew(Hnew news) throws Exception {
		// TODO Auto-generated method stub
		return newDao.updateNew(news);
	}

	@Override
	public List<Hnew> findNews() throws Exception {
		// TODO Auto-generated method stub
		return newDao.findNews();
	}

	@Override
	public Hnew findNewsByNid(Integer nid) throws Exception {
		// TODO Auto-generated method stub
		return newDao.findNewsByNid(nid);
	}

	public NewDao getNewDao() {
		return newDao;
	}

	public void setNewDao(NewDao newDao) {
		this.newDao = newDao;
	}

	@Override
	public int findNewPages() throws Exception {
		// TODO Auto-generated method stub
		return newDao.findNewPages();
	}

	@Override
	public List<Hnew> findNewsByPage(Integer page) throws Exception {
		// TODO Auto-generated method stub
		return newDao.findNewsByPage(page);
	}

}
