package com.hotel.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.hotel.dao.MenuDao;
import com.hotel.entity.Hmenu;
import com.hotel.entity.Hnew;

public class MenuDaoImpl extends HibernateDaoSupport implements MenuDao {

	@Override
	public int addMenu(Hmenu menu) throws Exception {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(menu);
		return 1;
	}

	@Override
	public int deleteMenu(Hmenu menu) throws Exception {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(menu);
		return 1;
	}

	@Override
	public int updateMenu(Hmenu menu) throws Exception {
		// TODO Auto-generated method stub
		Hmenu hmenu = (Hmenu) this.getHibernateTemplate().get(Hmenu.class,
				menu.getMId());

		if (menu.getMTitle() != null && !"".equals(menu.getMTitle())) {
			hmenu.setMTitle(menu.getMTitle());
		}
		if (menu.getMPrice() != null && !"".equals(menu.getMPrice())) {
			hmenu.setMPrice(menu.getMPrice());
		}
		if (menu.getMenutype() != null && !"".equals(menu.getMenutype())) {
			hmenu.setMenutype(menu.getMenutype());
		}
		if (menu.getMImg() != null && !"".equals(menu.getMImg())) {
			hmenu.setMImg(menu.getMImg());
		}

		this.getHibernateTemplate().update(hmenu);
		return 1;
	}

	@Override
	public List<Hmenu> findMenus() throws Exception {
		// TODO Auto-generated method stub
		String sql = " from Hmenu ";
		List<Hmenu> menuList = (List<Hmenu>) this.getHibernateTemplate().find(
				sql);
		return menuList;
	}

	@Override
	public Hmenu findMenuById(Integer mid) throws Exception {
		// TODO Auto-generated method stub
		String sql = "from Hmenu hm  where hm.MId=" + mid;
		List<Hmenu> menuList = (List<Hmenu>) this.getHibernateTemplate().find(
				sql);
		if (menuList.size() > 0)
			return menuList.get(0);
		return null;
	}

	@Override
	public List<Hmenu> findMenuByPage(Integer page, Hmenu menu)
			throws Exception {
		// TODO Auto-generated method stub
		String sql = " from Hmenu hm left join fetch hm.menutype  where 1=1";
		if (menu != null) {
			if (menu.getMTitle() != null && !"".equals(menu.getMTitle()))
				sql += " and hm.MTitle='" + menu.getMTitle() + "'";
			if (menu.getBig_price() != null && !"".equals(menu.getBig_price()))
				sql += " and hm.MPrice <=" + menu.getBig_price();
			if (menu.getMPrice() != null && !"".equals(menu.getMPrice()))
				sql += " and hm.MPrice >=" + menu.getMPrice();
			if (menu.getMenutype() != null
					&& menu.getMenutype().getMtId() != -1)
				sql += " and hm.menutype.mtId=" + menu.getMenutype().getMtId();
		}
		Query query = this.getSession().createQuery(sql);
		query.setFirstResult((page - 1) * 9);
		query.setMaxResults(9);
		List<Hmenu> menuList = query.list();
		return menuList;
	}

	@Override
	public int findMenuPages(Hmenu menu) throws Exception {
		// TODO Auto-generated method stub
		String sql = "select count(hm) from Hmenu hm  where 1=1";
		if (menu != null) {
			if (menu.getMTitle() != null && !"".equals(menu.getMTitle()))
				sql += " and hm.MTitle='" + menu.getMTitle() + "'";
			if (menu.getBig_price() != null && !"".equals(menu.getBig_price()))
				sql += " and hm.MPrice <=" + menu.getBig_price();
			if (menu.getMPrice() != null && !"".equals(menu.getMPrice()))
				sql += " and hm.MPrice >=" + menu.getMPrice();
			if (menu.getMenutype() != null
					&& menu.getMenutype().getMtId() != -1)
				sql += " and hm.menutype.mtId=" + menu.getMenutype().getMtId();
		}
		Query query = this.getSession().createQuery(sql);
		Object rowsObj = query.uniqueResult();
		Integer rows = Integer.parseInt(rowsObj.toString());
		if (rows % 9 == 0)
			return rows / 9;
		else
			return rows / 9 + 1;

	}

	@Override
	public List<Hmenu> findHmenuByPage(Integer page) throws Exception {
		// TODO Auto-generated method stub
		String sql = "from Hmenu hm left join fetch hm.menutype order by hm.MId";
		Query query = this.getSession().createQuery(sql);
		query.setFirstResult((page - 1) * 9);
		query.setMaxResults(9);
		List<Hmenu> menuList = query.list();
		return menuList;
	}

	@Override
	public int findPages() throws Exception {
		// TODO Auto-generated method stub
		String sql = "select count(*) from Hmenu";
		Query query = this.getSession().createQuery(sql);
		Object rowsObj = query.uniqueResult();
		Integer rows = Integer.parseInt(rowsObj.toString());
		if (rows % 9 == 0)
			return rows / 9;
		else
			return rows / 9 + 1;

	}

}
