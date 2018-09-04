package com.hotel.biz.impl;

import java.util.List;

import com.hotel.biz.MessageBiz;
import com.hotel.dao.MessageDao;
import com.hotel.entity.Hmessage;
import com.hotel.entity.Luser;

public class MessageBizImpl implements MessageBiz {
	private MessageDao mesgDao;

	@Override
	public int update(Hmessage message) throws Exception {
		// TODO Auto-generated method stub
		return mesgDao.update(message);
	}

	@Override
	public int deleteMessageByMid(Integer mid) throws Exception {
		// TODO Auto-generated method stub
		return mesgDao.deleteMessageByMid(mid);
	}

	@Override
	public List<Hmessage> findMessages() throws Exception {
		// TODO Auto-generated method stub
		return mesgDao.findMessages();
	}

	@Override
	public Hmessage findMessageByMid(Integer mid) throws Exception {
		// TODO Auto-generated method stub
		return mesgDao.findMessageByMid(mid);
	}

	@Override
	public int addMessage(Hmessage message) throws Exception {
		// TODO Auto-generated method stub
		return mesgDao.addMessage(message);
	}

	@Override
	public int findMessagePages() throws Exception {
		// TODO Auto-generated method stub
		return mesgDao.findMessagePages();
	}

	@Override
	public List<Hmessage> findMessageByPage(Integer page) throws Exception {
		// TODO Auto-generated method stub
		return mesgDao.findMessageByPage(page);
	}

	@Override
	public List<Hmessage> findMessageByPage(Integer page, Hmessage message)
			throws Exception {
		// TODO Auto-generated method stub
		return mesgDao.findMessageByPage(page, message);
	}

	public MessageDao getMesgDao() {
		return mesgDao;
	}

	public void setMesgDao(MessageDao mesgDao) {
		this.mesgDao = mesgDao;
	}

	@Override
	public int findMessagePages(Hmessage message) throws Exception {
		// TODO Auto-generated method stub
		return mesgDao.findMessagePages(message);
	}

	@Override
	public int findPageByUser(Luser user) throws Exception {
		// TODO Auto-generated method stub
		return mesgDao.findPageByUser(user);
	}

	@Override
	public List<Hmessage> findMessageByUserAndPage(Integer nowpage, Luser user)
			throws Exception {
		// TODO Auto-generated method stub
		return mesgDao.findMessageByUserAndPage(nowpage, user);
	}

}
