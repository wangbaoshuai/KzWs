package com.hotel.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.hotel.biz.HotelBiz;
import com.hotel.entity.Hcity;
import com.hotel.entity.Hnew;
import com.hotel.entity.Hotel;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class HotelAction extends ActionSupport {
	private HotelBiz hotelBiz;
	private Hotel hotel;
	private Integer id;
	private Hcity hcity;
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
			hotel.setHImage(imgFileName);// 封装上传的图片
			//调用修改的方法
			int num = hotelBiz.addHotel(hotel);
			String path = ServletActionContext.getRequest().getRealPath(
					"/hotel_images/" + imgFileName);
			// 通过文件流的方式，把上传的图片放到hotel
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
		System.out.println("jinru");
		try {
			System.out.println("sss:" + id);
			int num = hotelBiz.deleteHotel(id);
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
			hotel.setHImage(imgFileName);// 封装上传的图片
			//调用修改的方法
			int num = hotelBiz.updateHotel(hotel);
			String path = ServletActionContext.getRequest().getRealPath(
					"/hotel_images/" + imgFileName);
			// 通过文件流的方式，把上传的图片放到hotel
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

	public String findone() throws Exception {
		try {
			Map<String, Object> session = ActionContext.getContext()
					.getSession();
			Hotel hotel = hotelBiz.findByhid(id);
			if (hotel != null) {
				session.remove(hotel);
				session.put("hotel", hotel);
			}
			session.put("hotel", hotel);
			return "findone_success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "exception";
	}

	public String findByHcity() throws Exception {
		try {
			Map<String, Object> session = ActionContext.getContext()
					.getSession();
			Hotel hotel = hotelBiz.findByCity(hcity);
			if (hotel != null) {
				session.remove(hotel);
				session.put("hotel", hotel);
			}
			session.put("hotel", hotel);
			return "findByHcity_success";
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
			pages = hotelBiz.findPages();
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
			List<Hotel> hotelList = hotelBiz.findHotelsByPage(nowpage);
			if (hotelList != null) {
				session.remove(hotelList);
				session.put("hotelList", hotelList);
			}
			session.put("hotelList", hotelList);
            if("houtai".equals(type)){
			return "findByPageHoutai_success";
            }
            return "findByPage_success";
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

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Hcity getHcity() {
		return hcity;
	}

	public void setHcity(Hcity hcity) {
		this.hcity = hcity;
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

	@Override
	public String toString() {
		return "HotelAction [hotel=" + hotel + "]";
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
