package com.hotel.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.hotel.dao.HotelDao;
import com.hotel.entity.Hcity;
import com.hotel.entity.Hnew;
import com.hotel.entity.Hotel;

public class HotelDaoImpl extends HibernateDaoSupport implements HotelDao {

	@Override
	public int addHotel(Hotel hotel) throws Exception {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(hotel);
		return 1;
	}

	@Override
	public int deleteHotel(Integer hid) throws Exception {
		// TODO Auto-generated method stub
		String sql = "from Hotel h where h.HId=" + hid;
		System.out.println("sql:" + sql);
		List<Hotel> hotelList = (List<Hotel>) this.getHibernateTemplate().find(
				sql);
		if (hotelList.size() > 0)
			this.getHibernateTemplate().delete(hotelList.get(0));
		return 1;
	}

	@Override
	public int updateHotel(Hotel hotel) throws Exception {
		// TODO Auto-generated method stub
		Hotel hotels = (Hotel) this.getHibernateTemplate().get(Hotel.class,
				hotel.getHId());
		if (hotel.getHcity() != null && !"".equals(hotel.getHcity())) {
			hotels.setHcity(hotel.getHcity());
		}
		if (hotel.getHName() != null && !"".equals(hotel.getHName())) {
			hotels.setHName(hotel.getHName());
		}
		if (hotel.getHZip() != null && !"".equals(hotel.getHZip())) {
			hotels.setHZip(hotel.getHZip());
		}
		if (hotel.getHContent() != null && !"".equals(hotel.getHContent())) {
			hotels.setHContent(hotel.getHContent());

		}
		if (hotel.getHTelephone() != null && !"".equals(hotel.getHTelephone())) {
			hotels.setHTelephone(hotel.getHTelephone());
		}
		if(hotel.getHImage() !=null && !"".equals(hotel.getHImage())){
			hotels.setHImage(hotel.getHImage());
		}
		this.getHibernateTemplate().update(hotels);

		return 1;

	}

	@Override
	public List<Hotel> findHotels() throws Exception {
		// TODO Auto-generated method stub
		String sql = "from Hotel";
		List<Hotel> hotelList = (List<Hotel>) this.getHibernateTemplate().find(
				sql);

		return hotelList;
	}

	@Override
	public Hotel findByhid(Integer hid) throws Exception {
		// TODO Auto-generated method stub
		String sql = "from Hotel h where h.HId=" + hid;
		List<Hotel> hotelList = (List<Hotel>) this.getHibernateTemplate().find(
				sql);
		if (hotelList.size() > 0)
			return hotelList.get(0);
		return null;
	}

	@Override
	public Hotel findByCity(Hcity hcity) throws Exception {
		// TODO Auto-generated method stub
		String sql = "from Hotel h where h.hcity.cityId=" + hcity.getCityId();
		List<Hotel> hotelList = (List<Hotel>) this.getHibernateTemplate().find(
				sql);
		if (hotelList.size() > 0)
			return hotelList.get(0);
		return null;
	}

	@Override
	public List<Hotel> findHotelsByPage(Integer nowpage) throws Exception {
		// TODO Auto-generated method stub
		String sql = "from Hotel h where 1=1";
		Query query = this.getSession().createQuery(sql);
		query.setFirstResult((nowpage - 1) * 5);
		query.setMaxResults(5);
		List<Hotel> hotelList = query.list();
		return hotelList;

	}

	@Override
	public int findPages() throws Exception {
		// TODO Auto-generated method stub
		String sql = "select count(h) from Hotel h";
		Query query = this.getSession().createQuery(sql);
		Object rowsObj = query.uniqueResult();
		Integer rows = Integer.parseInt(rowsObj.toString());
		if (rows % 5 == 0)
			return rows / 5;
		else
			return rows / 5 + 1;

	}

	@Override
	public Hotel findByHotel(Hotel hotel) throws Exception {
		// TODO Auto-generated method stub
		String sql = "from Hotel h left join fetch h.hcomments where h.HId="
				+ hotel.getHId();
		List<Hotel> hotelList = (List<Hotel>) this.getHibernateTemplate().find(
				sql);
		if (hotelList.size() > 0)
			return hotelList.get(0);
		return null;
	}

}
