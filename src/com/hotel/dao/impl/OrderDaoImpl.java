package com.hotel.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.hotel.dao.OrderDao;
import com.hotel.entity.Hcomment;
import com.hotel.entity.Horder;
import com.hotel.entity.Luser;

public class OrderDaoImpl extends HibernateDaoSupport implements OrderDao {

	@Override
	public int add(Horder order) throws Exception {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(order);
		return 1;
	}

	@Override
	public int delete(Integer id) throws Exception {
		// TODO Auto-generated method stub
		String sql = " from Horder ho where ho.OId="+id;
		List<Horder> orderList = (List<Horder>) this.getHibernateTemplate()
				.find(sql);
		if (orderList.size() > 0)
			this.getHibernateTemplate().delete(orderList.get(0));
		return 1;
	}

	@Override
	public int update(Horder order) throws Exception {
		// TODO Auto-generated method stub
		Horder horder=(Horder)this.getHibernateTemplate().get(Horder.class,order.getOId());
		if(order.getOStatus()!=null&&!"".equals(order.getOStatus()))
			horder.setOStatus(order.getOStatus());
		this.getHibernateTemplate().update(horder);
		return 1;
	}

	@Override
	public Horder findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		String sql = "from Horder ho left join fetch ho.room left join fetch ho.luser where ho.OId=" + id;
		List<Horder> orderList = (List<Horder>) this.getHibernateTemplate()
				.find(sql);
		if (orderList.size() > 0)
			return orderList.get(0);
		return null;
	}

	@Override
	public List<Horder> findByPage(Integer page) throws Exception {
		// TODO Auto-generated method stub
		String sql = "from Horder ho left join fetch ho.room left join fetch ho.luser where 1=1";
		Query query = this.getSession().createQuery(sql);
		query.setFirstResult((page - 1) * 6);
		query.setMaxResults(6);
		List<Horder> orderList = query.list();
		return orderList;

	}

	@Override
	public int findOrderPage() throws Exception {
		// TODO Auto-generated method stub
		String sql = "select count(ho) from Horder ho";
		Query query = this.getSession().createQuery(sql);
		Object rowsObj = query.uniqueResult();
		Integer rows = Integer.parseInt(rowsObj.toString());
		if (rows % 6 == 0)
			return rows / 6;
		else
			return rows / 6 + 1;

	}

	@Override
	public List<Horder> findByUId(Integer uid) throws Exception {
		// TODO Auto-generated method stub
		String sql = "from Horder ho where ho.OId=" + uid;
		List<Horder> orderList = (List<Horder>) this.getHibernateTemplate()
				.find(sql);
		return orderList;
	}

	@Override
	public Horder findOrder(String ostatus) throws Exception {
		// TODO Auto-generated method stub
		String sql = "from Horder ho left join fetch ho.room left join fetch ho.luser where ho.OStatus="
				+ ostatus;
		List<Horder> orderList = (List<Horder>) this.getHibernateTemplate()
				.find(sql);
		if (orderList.size() > 0)
			return orderList.get(0);
		return null;
	}

	@Override
	public List<Horder> findByUserAndPage(Luser user, Integer nowpage)
			throws Exception {
		// TODO Auto-generated method stub
		String sql = " from Horder ho left join fetch ho.room left join fetch ho.luser where ho.luser.UId="
				+ user.getUId();
		Query query = this.getSession().createQuery(sql);
		query.setFirstResult((nowpage - 1) * 6);
		query.setMaxResults(6);
		List<Horder> orderList = query.list();
		return orderList;
	}

	@Override
	public int findPageByUser(Luser user) throws Exception {
		// TODO Auto-generated method stub
		String sql = "select count(ho) from Horder ho where ho.luser.UId="
				+ user.getUId();
		Query query = this.getSession().createQuery(sql);
		Object rowsObj = query.uniqueResult();
		Integer rows = Integer.parseInt(rowsObj.toString());
		if (rows % 6 == 0)
			return rows / 6;
		else
			return rows / 6 + 1;
	}

	@Override
	public List<Horder> findByduo(Horder order, Integer nowpage)
			throws Exception {
		// TODO Auto-generated method stub
		String sql = "from Horder ho left join fetch ho.room left join fetch ho.luser where 1=1";
		if (order != null) {
			if (order.getOStatus() != null && !"".equals(order.getOStatus()))
				sql += " and ho.OStatus='" + order.getOStatus() + "'";
			if (order.getRoom().getHotel() != null
					&& order.getRoom().getHotel().getHId() != -1)
				sql += " and ho.room.hotel.HId="
						+ order.getRoom().getHotel().getHId();
			if (order.getYDate() != null && !"".equals(order.getYDate()))
				sql += " and ho.YDate='"+ order.getYDate()+"'";
		}
		Query query = this.getSession().createQuery(sql);
		query.setFirstResult((nowpage - 1) * 6);
		query.setMaxResults(6);
		List<Horder> orderList = query.list();
		return orderList;
	}

	@Override
	public int findPageByduo(Horder order) throws Exception {
		// TODO Auto-generated method stub
		String sql = "select count(ho) from Horder ho where 1=1";
		if (order != null) {
			if (order.getOStatus() != null && !"".equals(order.getOStatus()))
				sql += " and ho.OStatus='" + order.getOStatus() + "'";
			if (order.getRoom().getHotel() != null
					&& order.getRoom().getHotel().getHId() != -1)
				sql += " and ho.room.hotel.HId="
						+ order.getRoom().getHotel().getHId();
			if (order.getYDate() != null && !"".equals(order.getYDate()))
				sql += " and ho.YDate='"+ order.getYDate()+"'";
		}
		Query query = this.getSession().createQuery(sql);
		Object rowsObj = query.uniqueResult();
		Integer rows = Integer.parseInt(rowsObj.toString());
		if (rows % 6 == 0)
			return rows / 6;
		else
			return rows / 6 + 1;
	}
}
