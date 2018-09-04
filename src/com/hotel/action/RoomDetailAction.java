package com.hotel.action;

import java.util.Map;

import com.hotel.biz.RoomDetailBiz;
import com.hotel.entity.Roomdetail;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class RoomDetailAction extends ActionSupport {
	private RoomDetailBiz roomdetailBiz;
	private Roomdetail roomdetail;
	private Integer rid;
	private String type;

	public String add() throws Exception {
		try {
			int num = roomdetailBiz.add(roomdetail);
			if (num > 0) {
				return "add_success";
			}
			return "add_error";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "exception";
	}

	public String find() throws Exception {
		try {

			Map<String, Object> session = ActionContext.getContext()
					.getSession();
			Roomdetail roomdetail = roomdetailBiz.findByRid(rid);
			if (roomdetail != null) {
				session.remove(roomdetail);
				session.put("roomdetail", roomdetail);
			}
			session.put("roomdetail", roomdetail);
			if ("add".equals(type)) {

				return "findadd_success";
			}
			    return "find_success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "exception";
	}
	public String findd() throws Exception {
		try {

			Map<String, Object> session = ActionContext.getContext()
					.getSession();
			Roomdetail romdetail = roomdetailBiz.findByRid(rid);
			if (romdetail != null) {
				session.remove(romdetail);
				session.put("romdetail", romdetail);
			}
			session.put("romdetail", romdetail);
			
			    return "finddetail_success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "exception";
	}
	public String delete() throws Exception {
		try {
			System.out.println("进入删除的方法 " +rid);
			int num = roomdetailBiz.deleteRoomDeatilByRid(rid);
			System.out.println(num);
			if (num > 0) {
				return "delete_success";
			}
			    return "delete_error";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "exception";
	}

	public RoomDetailBiz getRoomdetailBiz() {
		return roomdetailBiz;
	}

	public void setRoomdetailBiz(RoomDetailBiz roomdetailBiz) {
		this.roomdetailBiz = roomdetailBiz;
	}

	public Roomdetail getRoomdetail() {
		return roomdetail;
	}

	public void setRoomdetail(Roomdetail roomdetail) {
		this.roomdetail = roomdetail;
	}

	public Integer getRid() {
		return rid;
	}

	public void setRid(Integer rid) {
		this.rid = rid;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
