package com.hotel.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.hotel.dao.NewDao;
import com.hotel.entity.Hnew;

public class NewDaoImpl extends HibernateDaoSupport implements NewDao {

	@Override
	public int addNew(Hnew news) throws Exception {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(news);
		return 1;
	}

	@Override
	public int deleteNew(Integer nid) throws Exception {
		// TODO Auto-generated method stub
		String sql = "from Hnew hn where hn.NId=" + nid;
		List<Hnew> newList = (List<Hnew>) this.getHibernateTemplate().find(sql);
		if (newList.size() > 0) {
			this.getHibernateTemplate().delete(newList.get(0));
			return 1;

		}

		return 0;
	}

	@Override
	public int updateNew(Hnew news) throws Exception {
		// TODO Auto-generated method stub
		Hnew hnews = (Hnew) this.getHibernateTemplate().get(Hnew.class,
				news.getNId());

		if (news.getNTitle() != null && !"".equals(news.getNTitle())) {
			hnews.setNTitle(news.getNTitle());
		}
		if (news.getNContent() != null && !"".equals(news.getNContent())) {
			hnews.setNContent(news.getNContent());
		}
		if(news.getNImage() !=null && !"".equals(news.getNImage())){
			hnews.setNImage(news.getNImage());
		}
		this.getHibernateTemplate().update(hnews);

		return 1;

	}

	@Override
	public List<Hnew> findNews() throws Exception {
		// TODO Auto-generated method stub
		String sql = " from Hnew ";
		List<Hnew> newList = (List<Hnew>) this.getHibernateTemplate().find(sql);
		return newList;
	}

	@Override
	public Hnew findNewsByNid(Integer nid) throws Exception {
		// TODO Auto-generated method stub
		String sql = " from Hnew hn where hn.NId=" + nid;
		List<Hnew> newList = (List<Hnew>) this.getHibernateTemplate().find(sql);
		if (newList.size() > 0) {
			return newList.get(0);
		}
		return null;
	}

	@Override
	public int findNewPages() throws Exception {
		// TODO Auto-generated method stub
		String sql = "select count(hn) from Hnew hn";
		Query query = this.getSession().createQuery(sql);
		Object rowsObj = query.uniqueResult();
		Integer rows = Integer.parseInt(rowsObj.toString());
		if (rows % 6 == 0)
			return rows / 6;
		else
			return rows / 6 + 1;

	}

	@Override
	public List<Hnew> findNewsByPage(Integer page) throws Exception {
		// TODO Auto-generated method stub
		String sql = "from Hnew hn where 1=1";
		Query query = this.getSession().createQuery(sql);
		query.setFirstResult((page - 1) * 6);
		query.setMaxResults(6);
		List<Hnew> newList = query.list();
		return newList;
	}

}
