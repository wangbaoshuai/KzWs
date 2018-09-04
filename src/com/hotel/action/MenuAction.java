package com.hotel.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.hotel.biz.MenuBiz;
import com.hotel.entity.Hmenu;
import com.hotel.entity.Room;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class MenuAction extends ActionSupport {
	private MenuBiz menuBiz;
	private Hmenu menu;
	private Integer mid;
	private String type;

	private Integer nowpage;// 记录请求的页数
	private Integer backpage;// 上一页
	private Integer nextpage;// 下一页
	private Integer pages;// 总页数
	// 封装上传的图片信息
	private File img;
	private String imgContentType;
	private String imgFileName;

	public String add() throws Exception {
		try {

			Map<String, Object> session = ActionContext.getContext()
					.getSession();
			menu.setMImg(imgFileName);// 封装上传的图片
			// 调用添加的方法
			int num = menuBiz.addMenu(menu);
			String path = ServletActionContext.getRequest().getRealPath(
					"/menu_images/" + imgFileName);
			// 通过文件流的方式，把上传的图片放到menu
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
			int num = menuBiz.deleteMenu(mid);
			if (num > 0) {
				return "delete_success";
			}
			return "delete_error";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "exception";
	}

	public String update() throws Exception {
		try {
			Map<String, Object> session = ActionContext.getContext()
					.getSession();
			menu.setMImg(imgFileName);// 封装上传的图片
			// 调用修改的方法
			int num = menuBiz.updateMenu(menu);
			String path = ServletActionContext.getRequest().getRealPath(
					"/menu_images/" + imgFileName);
			// 通过文件流的方式，把上传的图片放到menu
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
			if(num > 0) {
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
			Hmenu menu = menuBiz.findMenuById(mid);
			if (menu != null) {
				session.remove(menu);
				session.put("menu", menu);
			}
			session.put("menu", menu);
			return "findone_success";
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
			pages = menuBiz.findMenuPages(menu);
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
			List<Hmenu> menuList = menuBiz.findMenuByPage(nowpage, menu);
			if (menuList.size() > 0) {
				session.remove(menuList);
				session.put("menuList", menuList);
			} else {
				session.put("menuList", menuList);
			}
			if ("houtai".equals(type)) {
				return "findAllhoutai_success";
			}
			   return "findAll_success";
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
			pages = menuBiz.findPages();
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
			List<Hmenu> menuList = menuBiz.findHmenuByPage(nowpage);
			if (menuList.size() > 0) {
				session.remove(menuList);
				session.put("menuList", menuList);
			} else {
				session.put("menuList", menuList);
			}
			if ("houtai".equals(type)) {
				return "findByPagehoutai_success";
			}

			return "findByPage_success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "exception";
	}

	public MenuBiz getMenuBiz() {
		return menuBiz;
	}

	public void setMenuBiz(MenuBiz menuBiz) {
		this.menuBiz = menuBiz;
	}

	public Hmenu getMenu() {
		return menu;
	}

	public void setMenu(Hmenu menu) {
		this.menu = menu;
	}

	public Integer getMid() {
		return mid;
	}

	public void setMid(Integer mid) {
		this.mid = mid;
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

}
