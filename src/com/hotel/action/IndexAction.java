package com.hotel.action;

import java.util.List;
import java.util.Map;

import com.hotel.biz.CommentBiz;
import com.hotel.biz.HcityBiz;
import com.hotel.biz.HotelBiz;
import com.hotel.biz.MenuBiz;
import com.hotel.biz.MenuTypeBiz;
import com.hotel.biz.MessageBiz;
import com.hotel.biz.NewBiz;
import com.hotel.biz.RoomBiz;
import com.hotel.biz.RtypeBiz;
import com.hotel.biz.UserBiz;
import com.hotel.entity.Hcity;
import com.hotel.entity.Hcomment;
import com.hotel.entity.Hmenu;
import com.hotel.entity.Hmessage;
import com.hotel.entity.Hnew;
import com.hotel.entity.Hotel;
import com.hotel.entity.Luser;
import com.hotel.entity.Menutype;
import com.hotel.entity.Room;
import com.hotel.entity.Rtype;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class IndexAction extends ActionSupport {

	private NewBiz newBiz;
	private RoomBiz roomBiz;
	private UserBiz userBiz;
	private HotelBiz hotelBiz;
	private MenuBiz menuBiz;
	private MenuTypeBiz metyBiz;
	private MessageBiz messageBiz;
	private HcityBiz hctBiz;
	private CommentBiz commentBiz;
	private RtypeBiz rtypeBiz;

	public String init() throws Exception {
		try {
			Map<String, Object> session = ActionContext.getContext()
					.getSession();
			List<Hotel> hoteList = hotelBiz.findHotels();
			List<Hnew> newsList = newBiz.findNews();
			List<Room> roomList = roomBiz.findRooms();
			List<Luser> userList = userBiz.findUser();
			List<Hmenu> menuList = menuBiz.findMenus();
			List<Menutype> metyList = metyBiz.findAll();
			List<Hmessage> messageList = messageBiz.findMessages();
			List<Hcity> hcityList = hctBiz.findAll();
			List<Hcomment> commtList = commentBiz.findComments();
			List<Rtype> rtypeList = rtypeBiz.findAll();
			if (hoteList != null) {
				session.remove(hoteList);
				session.put("hoteList", hoteList);
			}
			session.put("hoteList", hoteList);

			if (roomList != null) {
				session.remove(roomList);
				session.put("roomList", roomList);
			}
			    session.put("roomList", roomList);

			if (newsList != null) {
				session.remove(newsList);
				session.put("newsList", newsList);
			}
			session.put("newsList", newsList);

			if (userList != null) {
				session.remove(userList);
				session.put("userList", userList);
			}
			session.put("userList", userList);

			if (metyList != null) {
				session.remove(metyList);
				session.put("metyList", metyList);
			}
			session.put("metyList", metyList);

			if (menuList != null) {
				session.remove(menuList);
				session.put("menuList", menuList);
			}
			session.put("menuList", menuList);

			if (messageList != null) {
				session.remove(messageList);
				session.put("messageList", messageList);
			}
			session.put("messageList", messageList);

			if (hcityList != null) {
				session.remove(hcityList);
				session.put("hcityList", hcityList);
			}
			session.put("hcityList", hcityList);

			if (commtList != null) {
				session.remove(commtList);
				session.put("commtList", commtList);
			}
			   session.put("commtList", commtList);

			if (rtypeList != null) {
				session.remove(rtypeList);
				session.put("rtypeList", rtypeList);
			}
			session.put("rtypeList", rtypeList);
          
			
				return "init_success";
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "exception";
	}

	public HotelBiz getHotelBiz() {
		return hotelBiz;
	}

	public void setHotelBiz(HotelBiz hotelBiz) {
		this.hotelBiz = hotelBiz;
	}

	public NewBiz getNewBiz() {
		return newBiz;
	}

	public void setNewBiz(NewBiz newBiz) {
		this.newBiz = newBiz;
	}

	public RoomBiz getRoomBiz() {
		return roomBiz;
	}

	public void setRoomBiz(RoomBiz roomBiz) {
		this.roomBiz = roomBiz;
	}

	public UserBiz getUserBiz() {
		return userBiz;
	}

	public void setUserBiz(UserBiz userBiz) {
		this.userBiz = userBiz;
	}

	public MenuBiz getMenuBiz() {
		return menuBiz;
	}

	public void setMenuBiz(MenuBiz menuBiz) {
		this.menuBiz = menuBiz;
	}

	public MenuTypeBiz getMetyBiz() {
		return metyBiz;
	}

	public void setMetyBiz(MenuTypeBiz metyBiz) {
		this.metyBiz = metyBiz;
	}

	public MessageBiz getMessageBiz() {
		return messageBiz;
	}

	public void setMessageBiz(MessageBiz messageBiz) {
		this.messageBiz = messageBiz;
	}

	public HcityBiz getHctBiz() {
		return hctBiz;
	}

	public void setHctBiz(HcityBiz hctBiz) {
		this.hctBiz = hctBiz;
	}

	public CommentBiz getCommentBiz() {
		return commentBiz;
	}

	public void setCommentBiz(CommentBiz commentBiz) {
		this.commentBiz = commentBiz;
	}

	public RtypeBiz getRtypeBiz() {
		return rtypeBiz;
	}

	public void setRtypeBiz(RtypeBiz rtypeBiz) {
		this.rtypeBiz = rtypeBiz;
	}

}
