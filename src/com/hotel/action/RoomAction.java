package com.hotel.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

import org.apache.struts2.ServletActionContext;

import com.hotel.biz.RoomBiz;
import com.hotel.entity.Hotel;
import com.hotel.entity.Room;
import com.hotel.entity.Rtype;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class RoomAction extends ActionSupport {
	private RoomBiz roomBiz;
	private Room room;
	private Hotel hotel;
	private Rtype rtype;
	private Integer rid;
	private String rstate;

	private Integer nowpage;// 记录请求的页数
	private Integer backpage;// 上一页
	private Integer nextpage;// 下一页
	private Integer pages;// 总页数

	private String type;
	// 封装上传的图片信息
	private File img;
	private String imgContentType;
	private String imgFileName;

	public String find() throws Exception {
		try {
			Map<String, Object> session = ActionContext.getContext()
					.getSession();
			List<Room> roomList = (List<Room>) roomBiz.findRoomById(room
					.getRId());
			if (roomList != null) {
				session.remove(roomList);
				session.put("roomList", roomList);
			} else {
				session.put("roomList", roomList);
			}
			return "find_success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "exeception";
	}

	public String findAll() throws Exception {
		try {
			if (nowpage == null || nowpage == 0) {
				nowpage = 1;
			}
			pages = roomBiz.findRoomPages(room);
			backpage = nowpage - 1;
			if (backpage == 0) {
				backpage = 1;
			}
			nextpage = nowpage + 1;
			if (nextpage > pages) {
				nextpage = pages;
			}
			Map<String, Object> session = ActionContext.getContext()
					.getSession();
			List<Room> roomList = roomBiz.findRoomByPage(nowpage, room);
			session.put("roomList", roomList);

			if ("houtai".equals(type)) {
				return "findAllhoutai_success";
			}
			return "findAll_success";

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "exeception";
	}

	public String findByPage() throws Exception {
		try {
			if (nowpage == null || nowpage == 0) {
				nowpage = 1;
			}
			pages = roomBiz.findPages();
			backpage = nowpage - 1;
			if (backpage == 0) {
				backpage = 1;
			}
			nextpage = nowpage + 1;
			if (nextpage > pages) {
				nextpage = pages;
			}
			Map<String, Object> session = ActionContext.getContext()
					.getSession();
			List<Room> roomList = roomBiz.findRoomsByPage(nowpage);
			session.put("roomList", roomList);
			if ("houtai".equals(type)) {
				return "findByPagehoutai_success";
			}
			return "findByPage_success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "exception";
	}

	public String findByPageAndHotel() throws Exception {
		try {

			if (nowpage == null || nowpage == 0) {
				nowpage = 1;
			}
			pages = roomBiz.findPageByHotel(hotel);
			backpage = nowpage - 1;
			if (backpage == 0) {
				backpage = 1;
			}
			nextpage = nowpage + 1;
			if (nextpage > pages) {
				nextpage = pages;
			}
			Map<String, Object> session = ActionContext.getContext()
					.getSession();
			List<Room> roomList = roomBiz
					.findRoomByHotelAndPage(hotel, nowpage);
			session.put("roomList", roomList);
			session.put("hol", hotel);
System.out.println(hotel.getHId());
			return "findByPageAndHotel_success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "exception";
	}

	// 根据酒店和客房状态查询客房
	public String findRoomDuo() throws Exception {
		try {
			if (nowpage == null || nowpage == 0) {
				nowpage = 1;
			}
			pages = roomBiz.findPage(hotel, rstate);
			backpage = nowpage - 1;
			if (backpage == 0) {
				backpage = 1;
			}
			nextpage = nowpage + 1;
			if (nextpage > pages) {
				nextpage = pages;
			}
			Map<String, Object> session = ActionContext.getContext()
					.getSession();
			List<Room> roomList = roomBiz.findRoomDuo(hotel, rstate, nowpage);
			if (roomList != null) {
				session.remove(roomList);
				session.put("roomList", roomList);
			} else {
				session.put("roomList", roomList);
			}
			return "findRoomDuo_success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "exception";
	}
	// 多条件查询客房
		public String findByduo() throws Exception {
			try {
				System.out.println("进入action的方法:"+room.getHotel().getHId());
				if (nowpage == null || nowpage == 0) {
					nowpage = 1;
				}
				pages = roomBiz.findpages(room);
				backpage = nowpage - 1;
				if (backpage == 0) {
					backpage = 1;
				}
				nextpage = nowpage + 1;
				if (nextpage > pages) {
					nextpage = pages;
				}
				Map<String, Object> session = ActionContext.getContext()
						.getSession();
				List<Room> roomList = roomBiz.findByDuo(room, nowpage);
				if (roomList != null) {
					session.remove(roomList);
					session.put("roomList", roomList);
				} else {
					session.put("roomList", roomList);
				}
				return "findByduo_success";
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "exception";
		}

	// 添加的方法
	public String add() throws Exception {
		try {

			Map<String, Object> session = ActionContext.getContext()
					.getSession();
			room.setRImg(imgFileName);// 封装上传的图片
			// 调用添加的方法
			int num = roomBiz.addRoom(room);
			String path = ServletActionContext.getRequest().getRealPath(
					"/room_images/" + imgFileName);
			// 通过文件流的方式，把上传的图片放到room
			FileInputStream fis = new FileInputStream(img);
			FileOutputStream fos = new FileOutputStream(path);
			byte[] temp = new byte[1024];
			int size = -1;
			do {
				size = fis.read(temp);
				if (size != -1)
					fos.write(temp, 0, size);
			} while (size != -1);
			fos.flush();
			fos.close();
			fis.close();
			if (num > 0) {
				return "add_success";
			}
			return "add_error";

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "exeception";

	}

	// 删除的方法
	public String delete() throws Exception {
		try {
			int num = roomBiz.deleteRoom(rid);
			if (num > 0) {
				return "delete_success";
			}
			return "delete_error";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "exeception";
	}

	// 更新的方法
	public String update() throws Exception {
		try {
			Map<String, Object> session = ActionContext.getContext()
					.getSession();
			room.setRImg(imgFileName);// 封装上传的图片
			// 调用修改的方法
			int num = roomBiz.updateRoom(room);
			String path = ServletActionContext.getRequest().getRealPath(
					"/room_images/" + imgFileName);
			// 通过文件流的方式，把上传的图片放到room
			FileInputStream fis = new FileInputStream(img);
			FileOutputStream fos = new FileOutputStream(path);
			byte[] temp = new byte[1024];
			int size = -1;
			do {
				size = fis.read(temp);
				if (size != -1)
					fos.write(temp, 0, size);
			} while (size != -1);
			fos.flush();
			fos.close();
			fis.close();
			if (num > 0) {
				return "update_success";
			}
			return "update_error";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "exeception";

	}

	public String findone() throws Exception {
		try {
			Map<String, Object> session = ActionContext.getContext()
					.getSession();
			Room room = roomBiz.findRoomById(rid);
			if (room != null) {
				session.remove(room);
				session.put("room", room);
			}
			session.put("room", room);
			if ("add".equals(type)) {
				return "findadd_success";
			} else {
				return "findone_success";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "exception";
	}

	public RoomBiz getRoomBiz() {
		return roomBiz;
	}

	public void setRoomBiz(RoomBiz roomBiz) {
		this.roomBiz = roomBiz;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Integer getNowpage() {
		return nowpage;
	}

	public void setNowpage(Integer nowpage) {
		this.nowpage = nowpage;
	}

	public Integer getBackpage() {
		return backpage;
	}

	public void setBackpage(Integer backpage) {
		this.backpage = backpage;
	}

	public Integer getNextpage() {
		return nextpage;
	}

	public void setNextpage(Integer nextpage) {
		this.nextpage = nextpage;
	}

	public Integer getPages() {
		return pages;
	}

	public void setPages(Integer pages) {
		this.pages = pages;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public File getImg() {
		return img;
	}

	public void setImg(File img) {
		this.img = img;
	}

	public String getImgContentType() {
		return imgContentType;
	}

	public void setImgContentType(String imgContentType) {
		this.imgContentType = imgContentType;
	}

	public String getImgFileName() {
		return imgFileName;
	}

	public void setImgFileName(String imgFileName) {
		this.imgFileName = imgFileName;
	}

	public Integer getRid() {
		return rid;
	}

	public void setRid(Integer rid) {
		this.rid = rid;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public Rtype getRtype() {
		return rtype;
	}

	public void setRtype(Rtype rtype) {
		this.rtype = rtype;
	}

	public String getRstate() {
		return rstate;
	}

	public void setRstate(String rstate) {
		this.rstate = rstate;
	}

}
