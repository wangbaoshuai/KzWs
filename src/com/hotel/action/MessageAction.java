package com.hotel.action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.mail.Session;

import com.hotel.biz.MessageBiz;
import com.hotel.entity.Hcomment;
import com.hotel.entity.Hmessage;
import com.hotel.entity.Luser;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class MessageAction extends ActionSupport {
	private MessageBiz messageBiz;
	private Hmessage message;
	private Integer mid;
	private String mreply;
	private Luser user;
	private String type;

	private Integer nowpage;// 记录请求的页数
	private Integer backpage;// 上一页
	private Integer nextpage;// 下一页
	private Integer pages;// 总页数

	public String add() throws Exception {
		try {
			message.setMDate(new Date());

			int num = messageBiz.addMessage(message);
			if (num > 0) {
				return "add_success";
			}
			return "add_error";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "exception";
	}

	public String delete() throws Exception {
		try {
			
			int num = messageBiz.deleteMessageByMid(mid);
			Map<String, Object> session = ActionContext.getContext()
					.getSession();
			user=(Luser)session.get("loginUser");
			int nowpage=1;
			List<Hmessage> messageList = messageBiz.findMessageByUserAndPage(
					nowpage, user);

			if (messageList != null) {
				session.remove(messageList);
				session.put("messageList", messageList);
			}
			session.put("messageList", messageList);
			if (num > 0) {
				
			if("add".equals(type)){
				return "deleteadd_success";
			}
				return "delete_success";
				
			}else{
			return "delete_error";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "exception";
	}

	// 回复的方法
	public String update() throws Exception {
		try {

			Hmessage message = messageBiz.findMessageByMid(mid);
			message.setMReply(mreply);
			int num = messageBiz.update(message);
			if (num > 0) {
				return "update_success";
			}
			return "update_error";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "exception";
	}

	public String findone() throws Exception {
		try {

			Map<String, Object> session = ActionContext.getContext()
					.getSession();
			Hmessage message = messageBiz.findMessageByMid(mid);
			if (message != null) {
				session.remove(message);
				session.put("message", message);
			}
			session.put("message", message);
			return "findone_success";

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "exception";
	}

	public String findByPage() throws Exception {
		try {
			if (nowpage == null || nowpage == 0) {
				nowpage = 1;
			}
			pages = messageBiz.findMessagePages();
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
			List<Hmessage> messageList = messageBiz.findMessageByPage(nowpage);
			if (messageList != null) {
				session.remove(messageList);
				session.put("messageList", messageList);
			}
			session.put("messageList", messageList);

			return "findByPage_success";

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "exception";
	}

	public String findByPageAndUser() throws Exception {
		try {
			if (nowpage == null || nowpage == 0) {
				nowpage = 1;
			}
			pages = messageBiz.findPageByUser(user);
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
			List<Hmessage> messageList = messageBiz.findMessageByUserAndPage(
					nowpage, user);

			if (messageList != null) {
				session.remove(messageList);
				session.put("messageList", messageList);
			}
			session.put("messageList", messageList);

			return "findByPageAndUser_success";

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "exception";
	}

	public String findAll() throws Exception {
		try {
			if (nowpage == null || nowpage == 0) {
				nowpage = 1;
			}
			pages = messageBiz.findMessagePages(message);
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
			List<Hmessage> messageList = messageBiz.findMessageByPage(nowpage,
					message);
			if (messageList != null) {
				session.remove(messageList);
				session.put("messageList", messageList);
			}
			session.put("messageList", messageList);

			return "findAll_success";

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "exception";
	}

	public MessageBiz getMessageBiz() {
		return messageBiz;
	}

	public void setMessageBiz(MessageBiz messageBiz) {
		this.messageBiz = messageBiz;
	}

	public Hmessage getMessage() {
		return message;
	}

	public void setMessage(Hmessage message) {
		this.message = message;
	}

	public Integer getMid() {
		return mid;
	}

	public void setMid(Integer mid) {
		this.mid = mid;
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

	public String getMreply() {
		return mreply;
	}

	public void setMreply(String mreply) {
		this.mreply = mreply;
	}

	public Luser getUser() {
		return user;
	}

	public void setUser(Luser user) {
		this.user = user;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
