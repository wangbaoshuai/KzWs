package com.hotel.biz.impl;

import java.util.List;

import com.hotel.biz.CommentBiz;
import com.hotel.dao.CommentDao;
import com.hotel.entity.Hcomment;
import com.hotel.entity.Hotel;
import com.hotel.entity.Luser;

public class CommentBizImpl implements CommentBiz {
	private CommentDao comDao;

	@Override
	public int addComment(Hcomment comment) throws Exception {
		// TODO Auto-generated method stub
		return comDao.addComment(comment);
	}

	@Override
	public int deleteComment(Integer cid) throws Exception {
		// TODO Auto-generated method stub
		return comDao.deleteComment(cid);
	}

	@Override
	public int updateComment(Hcomment comment) throws Exception {
		// TODO Auto-generated method stub
		return comDao.updateComment(comment);
	}

	@Override
	public List<Hcomment> findComments() throws Exception {
		// TODO Auto-generated method stub
		return comDao.findComments();
	}

	@Override
	public Hcomment findHcommentById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return comDao.findHcommentById(id);
	}

	public CommentDao getComDao() {
		return comDao;
	}

	public void setComDao(CommentDao comDao) {
		this.comDao = comDao;
	}

	@Override
	public int findCommentPages() throws Exception {
		// TODO Auto-generated method stub
		return comDao.findCommentPages();
	}

	@Override
	public List<Hcomment> findCommentsByPage(Integer page) throws Exception {
		// TODO Auto-generated method stub
		return comDao.findCommentsByPage(page);
	}

	@Override
	public int findPageByHotel(Hotel hotel) throws Exception {
		// TODO Auto-generated method stub
		return comDao.findPageByHotel(hotel);
	}

	@Override
	public List<Hcomment> findByPageAndHotel(Integer nowpage, Hotel hotel)
			throws Exception {
		// TODO Auto-generated method stub
		return comDao.findByPageAndHotel(nowpage, hotel);
	}

	@Override
	public int findPageByUser(Luser user) throws Exception {
		// TODO Auto-generated method stub
		return comDao.findPageByUser(user);
	}

	@Override
	public List<Hcomment> findByPageAndUser(Integer nowpage, Luser user)
			throws Exception {
		// TODO Auto-generated method stub
		return comDao.findByPageAndUser(nowpage, user);
	}

}
