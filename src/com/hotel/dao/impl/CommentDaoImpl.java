package com.hotel.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.hotel.dao.CommentDao;
import com.hotel.entity.Hcomment;
import com.hotel.entity.Hotel;
import com.hotel.entity.Luser;
import com.hotel.entity.Room;

public class CommentDaoImpl extends HibernateDaoSupport implements CommentDao {

	@Override
	public int addComment(Hcomment comment) throws Exception {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(comment);
		return 1;
	}

	@Override
	public int deleteComment(Integer cid) throws Exception {
		// TODO Auto-generated method stub
		String sql = " from Hcomment hc where hc.CId="+cid;
		List<Hcomment> commentList = (List<Hcomment>) this
				.getHibernateTemplate().find(sql);
		if (commentList.size() > 0)
			this.getHibernateTemplate().delete(commentList.get(0));
		return 1;
	}

	@Override
	public int updateComment(Hcomment comment) throws Exception {
		// TODO Auto-generated method stub
		Hcomment hcomment = (Hcomment) this.getHibernateTemplate().get(
				Hcomment.class, comment.getCId());
		if (comment.getCScore() != null && !"".equals(comment.getCScore()))
			hcomment.setCScore(comment.getCScore());
		if (comment.getHotel() != null && !"".equals(comment.getHotel()))
			hcomment.setHotel(comment.getHotel());
		if (comment.getCContent() != null && !"".equals(comment.getCContent()))
			hcomment.setCContent(comment.getCContent());
		this.getHibernateTemplate().update(hcomment);
		return 1;
	}

	@Override
	public List<Hcomment> findComments() throws Exception {
		// TODO Auto-generated method stub
		String sql = "from Hcomment";
		List<Hcomment> commentList = (List<Hcomment>) this
				.getHibernateTemplate().find(sql);
		return commentList;
	}

	@Override
	public Hcomment findHcommentById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		String sql = "from Hcomment hc where hc.CId=id";
		List<Hcomment> commentList = (List<Hcomment>) this
				.getHibernateTemplate().find(sql);
		if (commentList.size() > 0)
			return commentList.get(0);
		return null;
	}

	@Override
	public int findCommentPages() throws Exception {
		// TODO Auto-generated method stub
		String sql = "select count(hc) from Hcomment hc ";
		Query query = this.getSession().createQuery(sql);
		Object rowsObj = query.uniqueResult();
		Integer rows = Integer.parseInt(rowsObj.toString());
		if (rows % 6 == 0)
			return rows / 6;
		else
			return rows / 6 + 1;

	}

	@Override
	public List<Hcomment> findCommentsByPage(Integer page) throws Exception {
		// TODO Auto-generated method stub
		String sql = "from Hcomment where 1=1 ";
		Query query = this.getSession().createQuery(sql);
		query.setFirstResult((page - 1) * 6);
		query.setMaxResults(6);
		List<Hcomment> commentList = query.list();
		return commentList;
	}

	@Override
	public int findPageByHotel(Hotel hotel) throws Exception {
		// TODO Auto-generated method stub
		String sql = "select count(hc) from Hcomment hc where hc.hotel.HId="
				+ hotel.getHId();
		Query query = this.getSession().createQuery(sql);
		Object rowsObj = query.uniqueResult();
		Integer rows = Integer.parseInt(rowsObj.toString());
		if (rows % 6 == 0)
			return rows / 6;
		else
			return rows / 6 + 1;

	}

	@Override
	public List<Hcomment> findByPageAndHotel(Integer nowpage, Hotel hotel)
			throws Exception {
		// TODO Auto-generated method stub
		String sql = "from Hcomment h where  h.hotel.HId=" + hotel.getHId();
		Query query = this.getSession().createQuery(sql);
		query.setFirstResult((nowpage - 1) * 6);
		query.setMaxResults(6);
		List<Hcomment> commentList = query.list();
		return commentList;
	}

	@Override
	public int findPageByUser(Luser user) throws Exception {
		// TODO Auto-generated method stub
		String sql = "select count(hc) from Hcomment hc where hc.luser.UId="
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
	public List<Hcomment> findByPageAndUser(Integer nowpage, Luser user)
			throws Exception {
		// TODO Auto-generated method stub
		String sql = "from Hcomment h where  h.luser.UId=" + user.getUId();
		Query query = this.getSession().createQuery(sql);
		query.setFirstResult((nowpage - 1) * 6);
		query.setMaxResults(6);
		List<Hcomment> commentList = query.list();
		return commentList;

	}

}
