package com.hotel.action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.mail.Session;

import com.hotel.biz.OrderBiz;
import com.hotel.biz.RoomBiz;
import com.hotel.biz.UserBiz;
import com.hotel.entity.Hnew;
import com.hotel.entity.Horder;
import com.hotel.entity.Hotel;
import com.hotel.entity.Luser;
import com.hotel.entity.Room;
import com.hotel.entity.Rtype;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class OrderAction extends ActionSupport {
	private OrderBiz orderBiz;
	private RoomBiz roomBiz;
	private UserBiz userBiz;
	private Horder order;
	private Integer oid;
	private String type;
	private Integer uid;
	private String ostatus;
	private Luser user;
	private Room room;

	private Integer nowpage;// 记录请求的页数
	private Integer backpage;// 上一页
	private Integer nextpage;// 下一页
	private Integer pages;// 总页

	public String add() throws Exception {
		try {
			Map<String, Object> session = ActionContext.getContext()
					.getSession();
			order.setOStatus("0");
			order.setYDate(new Date());
			int num = orderBiz.add(order);
			Luser loginUser=(Luser)session.get("loginUser");
			if(loginUser.getUScore()==null){
				loginUser.setUScore(100);
			}else{
				loginUser.setUScore(loginUser.getUScore()+20);
			}
			userBiz.updateUser(loginUser);
			session.put("loginUser", loginUser);
			
			if (num > 0) {
				return "add_success";
			} else {
				return "add_error";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "exception";
	}

	public String delete() throws Exception {
		try {
			int num = orderBiz.delete(oid);
			System.out.println("num="+num);
			if (num > 0) {
				if("houtai".equals(type)){
				return "deletehoutai_success";
				}
				return "delete_success";
			} else {
				return "delete_error";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "exception";
	}

	public String update() throws Exception {
		try {
			int num = orderBiz.update(order);
			
			String hor=order.getOStatus();
		
			int rid=order.getRoom().getRId();
			Room rom=roomBiz.findRoomById(rid);
			if("1".equals(hor)){
				
				rom.setRState("入住");
				roomBiz.updateRoom(rom);
			}
			
			if (num > 0) {
				return "update_success";
			} else {
				return "update_error";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "exception";
	}

	public String findone() throws Exception {
		try {
			Map<String, Object> session = ActionContext.getContext()
					.getSession();
			Horder order = orderBiz.findById(oid);
			if (order != null) {
				session.remove(order);
				session.put("order", order);
			}
			session.put("order", order);

			return "findone_success";

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "exception";
	}

	public String find() throws Exception {
		try {
			if (nowpage == null || nowpage == 0) {
				nowpage = 1;
			}
			pages = orderBiz.findOrderPage();
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
			List<Horder> orderList = orderBiz.findByPage(nowpage);
			if (orderList != null) {
				session.remove(orderList);
				session.put("orderList", orderList);
			}
			   session.put("orderList", orderList);

			return "find_success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "exception";
	}

	// 根据用户id查找相关订单
	public String find1() throws Exception {
		try {
			Map<String, Object> session = ActionContext.getContext()
					.getSession();
			List<Horder> orderList = orderBiz.findByUId(uid);
			if (orderList != null) {
				session.remove(orderList);
				session.put("orderList", orderList);
			}
			session.put("orderList", orderList);

			return "find1_success";

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "exception";
	}
	//根据状态查询订单
	public String findByStatus() throws Exception {
		try {
			Map<String, Object> session = ActionContext.getContext()
					.getSession();
			Horder order = orderBiz.findOrder(ostatus);
			if (order != null) {
				session.remove(order);
				session.put("order", order);
			}
			session.put("order", order);

			return "findByStatus_success";

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "exception";
	}
	//根据用户分页查询
	public String findByUserAndPage()throws Exception{
		try{
			Map<String,Object> session1=ActionContext.getContext().getSession();
			user=(Luser)session1.get("loginUser");
			if (nowpage == null || nowpage == 0) {
				nowpage = 1;
			}
			pages = orderBiz.findPageByUser(user);
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
			List<Horder> orderList = orderBiz.findByUserAndPage(user, nowpage);
			if (orderList != null) {
				session.remove(orderList);
				session.put("orderList", orderList);
			}
			session.put("orderList", orderList);

			return "findByUserAndPage_success";
		}catch(Exception e){
			e.printStackTrace();
		}
		return "exception";
	} 
	//多条件分页查询
		public String findByduo()throws Exception{
			try{
				System.out.println("进入多条件的action方法");
				if (nowpage == null || nowpage == 0) {
					nowpage = 1;
				}
				pages = orderBiz.findPageByduo(order);
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
				List<Horder> orderList = orderBiz.findByduo(order, nowpage);
				if (orderList != null) {
					session.remove(orderList);
					session.put("orderList", orderList);
				}
				session.put("orderList", orderList);

				return "findByduo_success";
			}catch(Exception e){
				e.printStackTrace();
			}
			return "exception";
		} 
	public OrderBiz getOrderBiz() {
		return orderBiz;
	}

	public void setOrderBiz(OrderBiz orderBiz) {
		this.orderBiz = orderBiz;
	}

	public Horder getOrder() {
		return order;
	}

	public void setOrder(Horder order) {
		this.order = order;
	}

	public Integer getOid() {
		return oid;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
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

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getOstatus() {
		return ostatus;
	}

	public void setOstatus(String ostatus) {
		this.ostatus = ostatus;
	}

	public Luser getUser() {
		return user;
	}

	public void setUser(Luser user) {
		this.user = user;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
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

}
