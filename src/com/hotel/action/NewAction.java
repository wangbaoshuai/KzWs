package com.hotel.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.hotel.biz.NewBiz;
import com.hotel.entity.Hnew;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class NewAction extends ActionSupport {
	private NewBiz newBiz;
	private Hnew news;
	private Integer nid;
	private String type;// 接收不同结果

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
			news.setNImage(imgFileName);// 封装上传的图片
			// 调用添加的方法
			int num = newBiz.addNew(news);
			String path = ServletActionContext.getRequest().getRealPath(
					"/news_images/" + imgFileName);
			// 通过文件流的方式，把上传的图片放到news
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
		return "exception";
	}

	public String delete() throws Exception {

		try {
			int num = newBiz.deleteNew(nid);
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

	public String update() throws Exception {
		try {
			Map<String, Object> session = ActionContext.getContext()
					.getSession();
			news.setNImage(imgFileName);// 封装上传的图片
			// 调用修改的方法
			int num = newBiz.updateNew(news);
			String path = ServletActionContext.getRequest().getRealPath(
					"/news_images/" + imgFileName);
			// 通过文件流的方式，把上传的图片放到news
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
			} else {
				return "update_error";
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
			pages = newBiz.findNewPages();
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
			List<Hnew> newList = newBiz.findNewsByPage(nowpage);
			if (newList != null) {
				session.remove(newList);
				session.put("newList", newList);
			}
			session.put("newList", newList);
			if ("houtai".equals(type)) {
				return "findhoutai_success";
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
			Hnew hnew = newBiz.findNewsByNid(nid);
			if (hnew != null) {
				session.remove(hnew);
				session.put("hnew", hnew);
			}
			session.put("hnew", hnew);
			return "findone_success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "exception";
	}

	public NewBiz getNewBiz() {
		return newBiz;
	}

	public void setNewBiz(NewBiz newBiz) {
		this.newBiz = newBiz;
	}

	public Hnew getNews() {
		return news;
	}

	public void setNews(Hnew news) {
		this.news = news;
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

	public Integer getNid() {
		return nid;
	}

	public void setNid(Integer nid) {
		this.nid = nid;
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

}
