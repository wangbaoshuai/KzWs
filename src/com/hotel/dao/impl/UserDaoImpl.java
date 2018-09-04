package com.hotel.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.hotel.dao.UserDao;
import com.hotel.entity.Luser;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

	@Override
	public int addUser(Luser user) throws Exception {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(user);
		return 1;
	}

	@Override
	public List<Luser> findUser() throws Exception {
		// TODO Auto-generated method stub
		String sql = "from Luser";
		List<Luser> userList = (List<Luser>) this.getHibernateTemplate().find(
				sql);
		return userList;
	}

	@Override
	public int updateUser(Luser user) throws Exception {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(user);
		return 1;
	}

	@Override
	public int deleteUserById(Integer uid) throws Exception {
		// TODO Auto-generated method stub
		String sql = "delete from Luser lu where lu.UId=" + uid;
		List<Luser> userList = (List<Luser>) this.getHibernateTemplate().find(
				sql);
		if (userList.size() > 0)
			this.getHibernateTemplate().delete(userList.get(0));
		return 1;
	}

	@Override
	public Luser findUserByUnameandUpass(String uname, String upass)
			throws Exception {
		// TODO Auto-generated method stub
		String sql = "from Luser lu where lu.ULoginname=:uname and lu.ULoginpass=:upass";
		Query query = this.getSession().createQuery(sql);
		query.setString("uname", uname);
		query.setString("upass", upass);
		List<Luser> userList = query.list();
		if (userList.size() > 0) {
			return userList.get(0);// 获取单个对象，尽量不要使用唯一结果的方法,因为可能查出来的有空值
		}
		return null;

	}

	@Override
	public int findUserPages() throws Exception {
		// TODO Auto-generated method stub
		String sql = "select count(*) from Luser lu ";
		Query query = this.getSession().createQuery(sql);
		Object rowsObj = query.uniqueResult();
		Integer rows = Integer.parseInt(rowsObj.toString());
		if (rows % 8 == 0)
			return rows / 8;
		else
			return rows / 8 + 1;

	}

	@Override
	public List<Luser> findUserByPage(Integer page, Luser user)
			throws Exception {
		// TODO Auto-generated method stub
		String sql = "from Luser lu where 1=1";
		if (user != null) {
			if (user.getUSex() != null && !"".equals(user.getUSex()))
				sql += " and lu.USex='" + user.getUSex() + "'";
			if (user.getUType() != null && !"-1".equals(user.getUType()))
				sql += " and lu.UType='" + user.getUType() + "'";
			if (user.getMaxUScore() != null && user.getMaxUScore() != 0)
				sql += " and lu.UScore<=" + user.getMaxUScore();
			if (user.getUScore() != null && user.getUScore() != 0)
				sql += " and lu.UScore>=" + user.getUScore();
			if (user.getUStatus() != null && !"".equals(user.getUStatus()))
				sql += " and lu.UStatus='" + user.getUStatus() + "'";
		}
		Query query = this.getSession().createQuery(sql);
		query.setFirstResult((page - 1) * 8);
		query.setMaxResults(8);
		List<Luser> userList = query.list();
		return userList;
	}

	@Override
	public Luser findLuserById(Integer uid) throws Exception {
		// TODO Auto-generated method stub
		String sql = "from Luser lu where lu.UId=" + uid;
		List<Luser> userList = (List<Luser>) this.getHibernateTemplate().find(
				sql);
		if (userList.size() > 0)
			return userList.get(0);
		return null;
	}

	@Override
	public List<Luser> findByPage(Integer nowpage) throws Exception {
		// TODO Auto-generated method stub
		String sql = "from Luser lu";
		Query query = this.getSession().createQuery(sql);
		query.setFirstResult((nowpage - 1) * 8);
		query.setMaxResults(8);
		List<Luser> userList = query.list();
		return userList;
	}

	@Override
	public int findPagesByUser(Luser user) throws Exception {
		// TODO Auto-generated method stub
		String sql = "select count(*) from Luser lu where 1=1";
		if (user != null) {
			if (user.getUSex() != null && !"".equals(user.getUSex()))
				sql += " and lu.USex='" + user.getUSex() + "'";
			if (user.getUType() != null && !"".equals(user.getUType()))
				sql += " and lu.UType='" + user.getUType() + "'";
			if (user.getMaxUScore() != null && user.getMaxUScore() != 0)
				sql += " and lu.UScore<=" + user.getMaxUScore();
			if (user.getUScore() != null && user.getUScore() != 0)
				sql += " and lu.UScore>=" + user.getUScore();
			if (user.getUStatus() != null && !"".equals(user.getUStatus()))
				sql += " and lu.UStatus='" + user.getUStatus() + "'";
		}
		Query query = this.getSession().createQuery(sql);
		Object rowsObj = query.uniqueResult();
		Integer rows = Integer.parseInt(rowsObj.toString());
		if (rows % 8 == 0)
			return rows / 8;
		else
			return rows / 8 + 1;

	}

	@Override
	public Luser findUserByLoginname(String loginname) throws Exception {
		// TODO Auto-generated method stub
		String sql = "from Luser  where ULoginname='" + loginname + "'";
		List<Luser> userList = (List<Luser>) this.getHibernateTemplate().find(
				sql);
		if (userList.size() > 0)
			return userList.get(0);
		return null;
	}

}
