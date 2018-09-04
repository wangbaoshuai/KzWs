package com.hotel.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.hotel.biz.UserBiz;
import com.hotel.entity.Luser;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
	private UserBiz userBiz;
	private Luser user;
	private String msg;
	private Integer uid;
	private String type;
	private String UStatus;
	private Integer MaxUScore;
	private String beforepwd;

	private Integer nowpage;// 记录请求的页数
	private Integer backpage;// 上一页
	private Integer nextpage;// 下一页
	private Integer pages;// 总页数

	private File img; // 封装上传的图片信息
	private String imgContentType;
	private String imgFileName;
	private String m;

	public String login() throws Exception {
		try {
			Map<String, Object> session = ActionContext.getContext()
					.getSession();
			Luser loginUser = userBiz.findUserByUnameandUpass(
					user.getULoginname(), user.getULoginpass());

			if (loginUser != null) {
				if ("冻结".equals(loginUser.getUStatus())) {
					m = "尊敬的用户，您已经被冻结，请及时联系客服";  
					return "login_error";
				}
				session.put("loginUser", loginUser);// 保存登录用户
		   if (1==loginUser.getUIsadmin()) {

					return "admin_success";
				}else{
				    return "login_success";
			}
		   
			}
			     return "login_error";

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "exception";
	}

	public String add() throws Exception {
		try {
			System.out.println("进入add的方法中");
			Map<String, Object> session = ActionContext.getContext()
					.getSession();
			user.setUImage(imgFileName);// 封装上传的图片
			int num = userBiz.addUser(user);
			String path = ServletActionContext.getRequest().getRealPath(
					"/user_images/" + imgFileName);
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
			if (num == 0) {
				msg = "用户名已存在！";
				return "add_error";
			}
			return "add_success";

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "exception";

	}

	public String addAjax() throws Exception {
		try {

			HttpServletRequest req = ServletActionContext.getRequest();
			HttpServletResponse resp = ServletActionContext.getResponse();
			req.setCharacterEncoding("utf-8");
			String loginname = user.getULoginname();
			Luser temp_user = userBiz.findUserByLoginname(loginname);
			if (temp_user != null) {
				String info = "该姓名已经存在，请重新填写";

				resp.setContentType("text/html;charset=UTF-8");
				PrintWriter out = resp.getWriter();
				out.print(info);
				out.flush();
				out.close();
				return "register_error";
			} else {
				String info = "成功";
				resp.setContentType("text/html;charset=UTF-8");
				PrintWriter out = resp.getWriter();
				out.print(info);
				out.flush();
				out.close();
				return "register_error";
			}

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
			pages = userBiz.findPagesByUser(user);
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
			if (MaxUScore == null)
				user.setMaxUScore(user.getMaxUScore());
			List<Luser> userList = userBiz.findUserByPage(nowpage, user);
			session.put("userList", userList);

			return "findByPageAndUser_success";

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
			pages = userBiz.findUserPages();
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
			List<Luser> userList = userBiz.findByPage(nowpage);
			session.put("userList", userList);

			return "findByPage_success";

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "exception";
	}

	public String findone() throws Exception {
		try {
			Map<String, Object> session = ActionContext.getContext()
					.getSession();
			Luser luser = userBiz.findLuserById(uid);
			if (luser != null) {
				session.remove(luser);
				session.put("luser", luser);
			}
			session.put("luser", luser);
			return "findone_success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "exception";
	}

	public String update() throws Exception {
		try {
			Map<String, Object> session = ActionContext.getContext()
					.getSession();
			if ("admin".equals(type)) {
				Luser luser = userBiz.findLuserById(uid);

				if ("正常".equals(luser.getUStatus())) {
					luser.setUStatus("冻结");
				} else {
					luser.setUStatus("正常");
				}
				userBiz.updateUser(luser);
				return "adminupdate_success";
			}

			Luser luser2 = userBiz.findLuserById(uid);
			if (user.getULoginname() != null
					&& !"".equals(user.getULoginname()))
				luser2.setULoginname(user.getULoginname());
			if (user.getUSex() != null && !"".equals(user.getUSex()))
				luser2.setUSex(user.getUSex());
			if (user.getUIdcard() != null && !"".equals(user.getUIdcard()))
				luser2.setUIdcard(user.getUIdcard());
			if (user.getUScore() != null && !"".equals(user.getUScore()))
				luser2.setUScore(user.getUScore());
			if (user.getUAddress() != null && !"".equals(user.getUAddress()))
				luser2.setUAddress(user.getUAddress());
			if (user.getUTelephone() != null
					&& !"".equals(user.getUTelephone()))
				luser2.setUTelephone(user.getUTelephone());
			if (user.getUEmail() != null && !"".equals(user.getUEmail()))
				luser2.setUEmail(user.getUEmail());
			if (user.getUImage() != null && !"".equals(user.getUImage()))
				luser2.setUImage(user.getUImage());
			int nu = userBiz.updateUser(luser2);

			return "update_success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "exception";
	}

	public String change() {
		// 根据用户id判断原先id是否正确
		try {
			Luser lu = userBiz.findLuserById(uid);
			if (lu.getULoginpass().equals(beforepwd)) {
				lu.setULoginpass(user.getULoginpass());
				userBiz.updateUser(lu);

				return "changepwd_success";
			} else {
				return "changepwd_error";
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return "exception";
		}
	}

	public UserBiz getUserBiz() {
		return userBiz;
	}

	public void setUserBiz(UserBiz userBiz) {
		this.userBiz = userBiz;
	}

	public Luser getUser() {
		return user;
	}

	public void setUser(Luser user) {
		this.user = user;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public String getUStatus() {
		return UStatus;
	}

	public void setUStatus(String uStatus) {
		UStatus = uStatus;
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

	public String getBeforepwd() {
		return beforepwd;
	}

	public void setBeforepwd(String beforepwd) {
		this.beforepwd = beforepwd;
	}

	public Integer getMaxUScore() {
		return MaxUScore;
	}

	public void setMaxUScore(Integer maxUScore) {
		MaxUScore = maxUScore;
	}

	public String getM() {
		return m;
	}

	public void setM(String m) {
		this.m = m;
	}

}
