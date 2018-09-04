package com.hotel.action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.hotel.biz.CommentBiz;
import com.hotel.biz.UserBiz;
import com.hotel.entity.Hcomment;
import com.hotel.entity.Hmenu;
import com.hotel.entity.Hotel;
import com.hotel.entity.Luser;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CommentAction extends ActionSupport {
	private CommentBiz commentBiz;
	private UserBiz userBiz;
	private Hcomment comment;
	private Integer id;
	private Hotel hotel;
	private Luser user;
	private String type;

	private Integer nowpage;// 记录请求的页数
	private Integer backpage;// 上一页
	private Integer nextpage;// 下一页
	private Integer pages;// 总页数

	public String add() throws Exception {
		try {
			comment.setCDate(new Date());
			Map<String, Object> session = ActionContext.getContext()
					.getSession();
			int num = commentBiz.addComment(comment);
			Luser loginUser=(Luser)session.get("loginUser");
			if(loginUser.getUScore()==null){
				loginUser.setUScore(100);
			}else{
				
				loginUser.setUScore(loginUser.getUScore()+10);
			}
			userBiz.updateUser(loginUser);
			session.put("loginUser", loginUser);
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
			int num = commentBiz.deleteComment(id);
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
			int num = commentBiz.updateComment(comment);
			if (num > 0) {
				return "delete_success";
			} else {
				return "delete_error";
			}
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
			pages = commentBiz.findCommentPages();
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
			List<Hcomment> commentList = commentBiz.findCommentsByPage(nowpage);
			if (commentList.size() > 0) {
				session.remove(commentList);
				session.put("commentList", commentList);
			} else {
				session.put("commentList", commentList);
			}
			return "find_success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "exception";
	}

	public String findone() throws Exception {
		try {
			Map<String, Object> session = ActionContext.getContext()
					.getSession();
			Hcomment comment = commentBiz.findHcommentById(id);
			if (comment != null) {
				session.remove(comment);
				session.put("comment", comment);
			}
			session.put("comment", comment);

			return "findone_success";

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "exception";
	}

	public String findByPageAndhotel() throws Exception {
		try {
			Map<String, Object> session = ActionContext.getContext()
					.getSession();
			if(session.get("hot")==null){
				session.put("hot", hotel);
				session.put("hot_second",hotel);
			}
			
			Hotel temp_hotel=(Hotel)session.get("hot");
			System.out.println("id等于+++++++++++"+temp_hotel.getHId());
			if (nowpage == null || nowpage == 0) {
				nowpage = 1;
			}
			pages = commentBiz.findPageByHotel(temp_hotel);
			backpage = nowpage - 1;
			if (backpage == 0) {
				backpage = 1;
			}
			nextpage = nowpage + 1;
			if (nextpage > pages) {
				nextpage = pages;
			}

			List<Hcomment> commentList = commentBiz.findByPageAndHotel(nowpage,
					temp_hotel);
			if (commentList.size() > 0) {
				session.remove(commentList);
				session.put("commentList", commentList);
			} else {
				session.put("commentList", commentList);
			}
			session.remove("hot");
			return "findByPageAndHotel_success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "exception";
	}

	public String findByPageAndUser() throws Exception {
		try {
			Map<String,Object> session1=ActionContext.getContext().getSession();
			user=(Luser)session1.get("loginUser");
			
			if (nowpage == null || nowpage == 0) {
				nowpage = 1;
			}
			pages = commentBiz.findPageByUser(user);
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
			List<Hcomment> commtList = commentBiz.findByPageAndUser(nowpage,
					user);
			if (commtList.size() > 0) {
				session.remove(commtList);
				session.put("commtList", commtList);
			} else {
				session.put("commtList", commtList);
			}
			return "findByPageAndUser_success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "exception";
	}
	public String findAll() throws Exception{
		try {
			Map<String, Object> session = ActionContext.getContext()
					.getSession();
	     List<Hcomment> commtList = commentBiz.findComments();
	     if (commtList != null) {
				session.remove(commtList);
				session.put("commtList", commtList);
			}
			   session.put("commtList", commtList);
			   return "findAll_success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "exception";
	}
	public CommentBiz getCommentBiz() {
		return commentBiz;
	}

	public void setCommentBiz(CommentBiz commentBiz) {
		this.commentBiz = commentBiz;
	}

	public Hcomment getComment() {
		return comment;
	}

	public void setComment(Hcomment comment) {
		this.comment = comment;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
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

	public UserBiz getUserBiz() {
		return userBiz;
	}

	public void setUserBiz(UserBiz userBiz) {
		this.userBiz = userBiz;
	}

}
