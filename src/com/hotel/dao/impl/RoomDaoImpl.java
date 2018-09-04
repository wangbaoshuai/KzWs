package com.hotel.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.hotel.dao.RoomDao;
import com.hotel.entity.Hotel;
import com.hotel.entity.Room;
import com.hotel.entity.Rtype;

public class RoomDaoImpl extends HibernateDaoSupport implements RoomDao {

	@Override
	public int addRoom(Room room) throws Exception {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(room);
		return 1;
	}

	@Override
	public int updateRoom(Room room) throws Exception {
		// TODO Auto-generated method stub
		Room rom = (Room) this.getHibernateTemplate().get(Room.class,
				room.getRId());
		if(room.getRId() !=null && !"".equals(room.getRId())){
			rom.setRId(room.getRId());
		}
		if (room.getRTitle() != null && !"".equals(room.getRTitle())) {
			rom.setRTitle(room.getRTitle());
		}
		if (room.getRBednumber() != null && !"".equals(room.getRBednumber())) {
			rom.setRBednumber(room.getRBednumber());
		}
		if (room.getRtype() != null && !"".equals(room.getRtype())) {
			rom.setRtype(room.getRtype());
		}
		if (room.getRState() != null && !"".equals(room.getRState())) {
			rom.setRState(room.getRState());
		}
		if (room.getRdTotal() != null && !"".equals(room.getRdTotal())) {
			rom.setRdTotal(room.getRdTotal());
		}
		if (room.getRImg() != null && !"".equals(room.getRImg())) {
			rom.setRImg(room.getRImg());
		}
		if (room.getRFloor() != null && !"".equals(room.getRFloor())) {
			rom.setRFloor(room.getRFloor());
		}
		if (room.getHotel() != null && !"".equals(room.getHotel())) {
			rom.setHotel(room.getHotel());
		}
		this.getHibernateTemplate().update(rom);
		return 1;
	}

	@Override
	public int deleteRoom(Integer rid) throws Exception {
		// TODO Auto-generated method stub
		String sql = "delete from Room r where r.RId=" + rid;
		List<Room> roomList = (List<Room>) this.getHibernateTemplate()
				.find(sql);
		if (roomList.size() > 0)
			this.getHibernateTemplate().delete(roomList.get(0));
		return 1;
	}

	@Override
	public List<Room> findRooms() throws Exception {
		// TODO Auto-generated method stub
		String sql = " from Room";
		List<Room> roomList = (List<Room>) this.getHibernateTemplate()
				.find(sql);
		return roomList;
	}

	@Override
	public List<Room> findRoomByPage(Integer page, Room room) throws Exception {
		// TODO Auto-generated method stub
		String sql = "from Room r left join fetch r.rtype  where 1=1";
		if (room != null) {
			if (room.getRtype() != null && room.getRtype().getRtId() != -1)
				sql += " and r.rtype.id=" + room.getRtype().getRtId();
			if (room.getHotel() != null && room.getHotel().getHId() != -1)
				sql += " and r.hotel.HId=" + room.getHotel().getHId();
		}
		Query query = this.getSession().createQuery(sql);
		query.setFirstResult((page - 1) * 9);
		query.setMaxResults(9);
		List<Room> roomList = query.list();
		return roomList;

	}

	@Override
	public int findRoomPages(Room room) throws Exception {
		// TODO Auto-generated method stub
		String sql = " select count(*) from Room r  where 1=1";
		if (room != null) {
			if (room.getRtype() != null && room.getRtype().getRtId() != -1)
				sql += " and r.rtype.id=" + room.getRtype().getRtId();
			if (room.getHotel() != null && room.getHotel().getHId() != -1)
				sql += " and r.hotel.HId=" + room.getHotel().getHId();
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
	public Room findRoomById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		String sql = "from Room r where r.RId=" + id;
		List<Room> roomList = (List<Room>) this.getHibernateTemplate()
				.find(sql);
		if (roomList.size() > 0)
			return roomList.get(0);
		return null;
	}

	@Override
	public List<Room> findRoomsByPage(Integer page) throws Exception {
		// TODO Auto-generated method stub
		String sql = "from Room";
		Query query = this.getSession().createQuery(sql);
		query.setFirstResult((page - 1) * 9);
		query.setMaxResults(9);
		List<Room> roomList = query.list();
		return roomList;
	}

	@Override
	public int findPages() throws Exception {
		// TODO Auto-generated method stub
		String sql = "select count(*) from Room";
		Query query = this.getSession().createQuery(sql);
		Object rowsObj = query.uniqueResult();
		Integer rows = Integer.parseInt(rowsObj.toString());
		if (rows % 9 == 0)
			return rows / 9;
		else
			return rows / 9 + 1;

	}

	@Override
	public List<Room> findRoomByHotelAndRtype(Integer hid, Integer rid)
			throws Exception {
		// TODO Auto-generated method stub
		String sql = "from Room r where r.hotel.HId='" + hid
				+ "'and r.rtype.rtId='" + rid + "' and r.RState='空闲'";
		List<Room> roomList = (List<Room>) this.getHibernateTemplate()
				.find(sql);
		System.out.println("roomList" + roomList.size());
		return roomList;

	}

	@Override
	public List<Room> findRoomByHotelAndPage(Hotel hotel, Integer nowpage)
			throws Exception {
		// TODO Auto-generated method stub
		String sql = "from Room r where  r.hotel.HId=" + hotel.getHId();
		Query query = this.getSession().createQuery(sql);
		query.setFirstResult((nowpage - 1) * 9);
		query.setMaxResults(9);
		List<Room> roomList = query.list();
		return roomList;

	}

	@Override
	public int findPageByHotel(Hotel hotel) throws Exception {
		// TODO Auto-generated method stub
		String sql = "select count(*) from Room  r where r.hotel.HId="
				+ hotel.getHId();
		Query query = this.getSession().createQuery(sql);
		Object rowsObj = query.uniqueResult();
		Integer rows = Integer.parseInt(rowsObj.toString());
		if (rows % 9 == 0)
			return rows / 9;
		else
			return rows / 9 + 1;

	}

	@Override
	public List<Room> findRoomDuo(Hotel hotel, String rstate, Integer nowpage)
			throws Exception {
		// TODO Auto-generated method stub
		String sql = "from Room  r where r.hotel.HId='" + hotel.getHId()
				+ "'and r.RState='" + rstate + "'";
		Query query = this.getSession().createQuery(sql);
		query.setFirstResult((nowpage - 1) * 9);
		query.setMaxResults(9);
		List<Room> roomList = query.list();
		return roomList;

	}

	@Override
	public int findPage(Hotel hotel, String rstate) throws Exception {
		// TODO Auto-generated method stub
		String sql = "select count(*) from Room  r where r.hotel.HId='"
				+ hotel.getHId() + "'and r.RState='" + rstate + "'";
		Query query = this.getSession().createQuery(sql);
		Object rowsObj = query.uniqueResult();
		Integer rows = Integer.parseInt(rowsObj.toString());
		if (rows % 9 == 0)
			return rows / 9;
		else
			return rows / 9 + 1;
	}

	@Override
	public List<Room> findByDuo(Room room, Integer nowpage) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("进入到的方法");
		String sql = "from Room r left join fetch r.rtype  where 1=1";
		if (room != null) {
			if(room.getHotel()!=null&&room.getHotel().getHId()!=-1)
				sql += " and r.hotel.HId=" + room.getHotel().getHId();
			if (room.getRTitle() != null && !"".equals(room.getRTitle()))
				sql += " and r.RTitle='" + room.getRTitle() + "'";
			if (room.getRtype() != null && room.getRtype().getRtId() != -1)
				sql += " and r.rtype.id=" + room.getRtype().getRtId();
			if (room.getRState() != null && !"".equals(room.getRState()))
				sql += " and r.RState='" + room.getRState() + "'";
			if (room.getRBednumber() != null
					&& !"".equals(room.getRBednumber()))
				sql += " and r.RBednumber='" + room.getRBednumber() + "'";
			if (room.getRdBigTotal() != null
					&& !"".equals(room.getRdBigTotal()))
				sql += " and r.rdBigTotal<=" + room.getRdBigTotal();
			if (room.getRdTotal() != null && !"".equals(room.getRdTotal()))
				sql += " and r.rdTotal>=" + room.getRdTotal();
		}
		Query query = this.getSession().createQuery(sql);
		query.setFirstResult((nowpage - 1) * 9);
		query.setMaxResults(9);
		List<Room> roomList = query.list();
		return roomList;

	}

	@Override
	public int findpages(Room room) throws Exception {
		// TODO Auto-generated method stub
		String sql = " select count(*) from Room r  where 1=1";
		if (room != null) {
			if(room.getHotel()!=null&&room.getHotel().getHId()!=-1)
				sql += " and r.hotel.HId=" + room.getHotel().getHId();
			if (room.getRTitle() != null && !"".equals(room.getRTitle()))
				sql += " and r.RTitle='" + room.getRTitle() + "'";
			if (room.getRtype() != null && room.getRtype().getRtId() != -1)
				sql += " and r.rtype.id=" + room.getRtype().getRtId();
			if (room.getRState() != null && !"".equals(room.getRState()))
				sql += " and r.RState='" + room.getRState() + "'";
			if (room.getRBednumber() != null
					&& !"".equals(room.getRBednumber()))
				sql += " and r.RBednumber='" + room.getRBednumber() + "'";
			if (room.getRdBigTotal() != null
					&& !"".equals(room.getRdBigTotal()))
				sql += " and r.rdBigTotal<=" + room.getRdBigTotal();
			if (room.getRdTotal() != null && !"".equals(room.getRdTotal()))
				sql += " and r.rdTotal>=" + room.getRdTotal();
		}
		Query query = this.getSession().createQuery(sql);
		Object rowsObj = query.uniqueResult();
		Integer rows = Integer.parseInt(rowsObj.toString());
		if (rows % 9 == 0)
			return rows / 9;
		else
			return rows / 9 + 1;
	}

}
