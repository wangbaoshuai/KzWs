package com.hotel.biz.impl;

import java.util.List;

import com.hotel.biz.OrderBiz;
import com.hotel.dao.OrderDao;
import com.hotel.entity.Horder;
import com.hotel.entity.Luser;

public class OrderBizImpl implements OrderBiz {
	private OrderDao orderDao;

	@Override
	public int add(Horder order) throws Exception {
		// TODO Auto-generated method stub
		return orderDao.add(order);
	}

	@Override
	public int delete(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return orderDao.delete(id);
	}

	@Override
	public int update(Horder order) throws Exception {
		// TODO Auto-generated method stub
		return orderDao.update(order);
	}

	@Override
	public Horder findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return orderDao.findById(id);
	}

	@Override
	public List<Horder> findByPage(Integer page) throws Exception {
		// TODO Auto-generated method stub
		return orderDao.findByPage(page);
	}

	@Override
	public int findOrderPage() throws Exception {
		// TODO Auto-generated method stub
		return orderDao.findOrderPage();
	}

	@Override
	public List<Horder> findByUId(Integer uid) throws Exception {
		// TODO Auto-generated method stub
		return orderDao.findByUId(uid);
	}

	public OrderDao getOrderDao() {
		return orderDao;
	}

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	@Override
	public Horder findOrder(String ostatus) throws Exception {
		// TODO Auto-generated method stub
		return orderDao.findOrder(ostatus);
	}

	@Override
	public List<Horder> findByUserAndPage(Luser user, Integer nowpage)
			throws Exception {
		// TODO Auto-generated method stub
		return orderDao.findByUserAndPage(user, nowpage);
	}

	@Override
	public int findPageByUser(Luser user) throws Exception {
		// TODO Auto-generated method stub
		return orderDao.findPageByUser(user);
	}

	@Override
	public List<Horder> findByduo(Horder order, Integer nowpage)
			throws Exception {
		// TODO Auto-generated method stub
		return orderDao.findByduo(order, nowpage);
	}

	@Override
	public int findPageByduo(Horder order) throws Exception {
		// TODO Auto-generated method stub
		return orderDao.findPageByduo(order);
	}

}
