package com.hotel.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.hotel.dao.MessageDao;
import com.hotel.entity.Hcomment;
import com.hotel.entity.Hmessage;
import com.hotel.entity.Luser;
import com.hotel.entity.Room;

public class MessageDaoImpl extends HibernateDaoSupport implements MessageDao {

	@Override
	public int addMessage(Hmessage message) throws Exception {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(message);
		return 1;
	}

	@Override
	public int deleteMessageByMid(Integer mid) throws Exception {
		// TODO Auto-generated method stub
		String sql = " from Hmessage hm where hm.MId=" + mid;
		List<Hmessage> messageList = (List<Hmessage>) this
				.getHibernateTemplate().find(sql);
		if (messageList.size() > 0)
			this.getHibernateTemplate().delete(messageList.get(0));
		return 1;
	}

	@Override
	public int update(Hmessage message) throws Exception {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(message);
		return 1;
	}

	@Override
	public List<Hmessage> findMessages() throws Exception {
		// TODO Auto-generated method stub
		String sql = "from Hmessage";
		List<Hmessage> messageList = (List<Hmessage>) this
				.getHibernateTemplate().find(sql);
		return messageList;
	}

	@Override
	public Hmessage findMessageByMid(Integer mid) throws Exception {
		// TODO Auto-generated method stub
		String sql = " from Hmessage hm where hm.MId=" + mid;
		List<Hmessage> messageList = (List<Hmessage>) this
				.getHibernateTemplate().find(sql);
		if (messageList.size() > 0)
			return messageList.get(0);
		return null;
	}

	@Override
	public int findMessagePages() throws Exception {
		// TODO Auto-generated method stub
		String sql = "select count(hm) from Hmessage hm";
		Query query = this.getSession().createQuery(sql);
		Object rowsObj = query.uniqueResult();
		Integer rows = Integer.parseInt(rowsObj.toString());
		if (rows % 6 == 0)
			return rows / 6;
		else
			return rows / 6 + 1;

	}

	@Override
	public List<Hmessage> findMessageByPage(Integer page) throws Exception {
		// TODO Auto-generated method stub
		String sql = "from Hmessage hm where 1=1";
		Query query = this.getSession().createQuery(sql);
		query.setFirstResult((page - 1) * 6);
		query.setMaxResults(6);
		List<Hmessage> messageList = query.list();
		return messageList;

	}

	@Override
	public List<Hmessage> findMessageByPage(Integer page, Hmessage message)
			throws Exception {
		// TODO Auto-generated method stub
		String sql = " from  Hmessage hm left join fetch hm.luser where 1=1";
		if (message != null) {
			if (message.getMTitle() != null)
				sql += " and hm.MTitle like '%" + message.getMTitle() + "%'";
			if (message.getMDate() != null)
				sql += " and hm.MDate='" + message.getMDate() + "'";
			if (message.getMReply() != null)
				sql += " and hm.MReply='" + message.getMReply() + "'";
		}
		Query query = this.getSession().createQuery(sql);
		query.setFirstResult((page - 1) * 6);
		query.setMaxResults(6);
		List<Hmessage> messageList = query.list();
		return messageList;
	}

	@Override
	public int findMessagePages(Hmessage message) throws Exception {
		// TODO Auto-generated method stub
		String sql = " select count(*) from  Hmessage hm left join fetch hm.luser where 1=1";
		if (message != null) {
			if (message.getMTitle() != null)
				sql += " and hm.MTitle like '%" + message.getMTitle() + "%'";
			if (message.getMDate() != null)
				sql += " and hm.MDate='" + message.getMDate() + "'";
			if (message.getMReply() != null)
				sql += " and hm.MReply='" + message.getMReply() + "'";
		}
		Query query = this.getSession().createQuery(sql);
		Object rowsObj = query.uniqueResult();
		Integer rows = Integer.parseInt(rowsObj.toString());
		if (rows % 6 == 0)
			return rows / 6;
		else
			return rows / 6 + 1;
	}

	@Override
	public int findPageByUser(Luser user) throws Exception {
		// TODO Auto-generated method stub
		String sql = "select count(*) from  Hmessage hm where hm.luser.UId="
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
	public List<Hmessage> findMessageByUserAndPage(Integer nowpage, Luser user)
			throws Exception {
		// TODO Auto-generated method stub
		String sql = "from  Hmessage hm where hm.luser.UId=" + user.getUId();
		Query query = this.getSession().createQuery(sql);
		query.setFirstResult((nowpage - 1) * 6);
		query.setMaxResults(6);
		List<Hmessage> messageList = query.list();
		return messageList;
	}

}
