package com.hotel.action;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

import com.hotel.biz.RoomBiz;
import com.hotel.entity.Room;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AjaxAction extends ActionSupport {
	private String result;
	private RoomBiz roomBiz;
	private Integer hid;
	private Integer rid;
	
	public String findRoom() throws Exception {
		try {
			Map<String, Object> session = ActionContext.getContext()
					.getSession();
			List<Room> roomList = roomBiz.findRoomByHotelAndRtype(hid, rid);
			// 设置过滤的属性
			JsonConfig jc = new JsonConfig();
			jc.setExcludes(new String[] { "hotel", "rtype", "rooms",
					"hcomments", "horders", "roomdetails", });
			result = JSONArray.fromObject(roomList, jc).toString();

			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "exception";
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public RoomBiz getRoomBiz() {
		return roomBiz;
	}

	public void setRoomBiz(RoomBiz roomBiz) {
		this.roomBiz = roomBiz;
	}

	public Integer getHid() {
		return hid;
	}

	public void setHid(Integer hid) {
		this.hid = hid;
	}

	public Integer getRid() {
		return rid;
	}

	public void setRid(Integer rid) {
		this.rid = rid;
	}
	
}
