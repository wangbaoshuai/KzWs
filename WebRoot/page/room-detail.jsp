<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!--  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
-->
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'room-detail.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
   <link href="css/style.css" rel="stylesheet" type="text/css"  media="all" />
   <style type="text/css">
     table {
      width:500px; 
      height:300px;
      border:1px;
      border-color:#900;
      color:#FFF;
     }
      .about h3{color: #FFF;font-weight: 300;}
      .about form{color: #300;font-weight: 300;}
      #rom{color: #8080FF;font-weight: 300;font-size:23px;}
      .about-grid a{border-radius:0px; border:4px solid #FFF;display:inline-block; padding:0px 1px;}
      .about form a{border-radius:0px; border:0px solid #FFF;display:inline-block; padding:0px 1px;}
      .about-grid p{color: #BC7676;font-weight: 300;font-size:26px;}
      
     body{
	background: url(images/bg.jpg) ;
   </style>
</head>
	<body>
		<!---start-Wrap--->
			<!---start-header--->
			<div class="header">
				<div class="wrap">
					<div class="header-top">
						<div class="logo">
							<a href="index.html"><img src="images/logo2.png" title="logo" /></a>
						</div>
						<div class="contact-info">
							<p class="phone">服务热线 : <a href="#">800-020-12345</a></p>
							<p class="gpa">定位服务 : <a href="page/map.jsp">View map</a></p>
							<p class="phone1"><a href="page/login.jsp">登录</a> &nbsp;&nbsp;&nbsp;
                            <a href="page/register.jsp">注册</a></p>
						</div>
						<div class="clear"> </div>
					</div>
				</div>
				<div class="header-top-nav">
					<div class="wrap">
						<ul>
						   <li><a href="findByPageHotel.action?nowpage=1">订房中心</a></li>
							<li><a href="findByPageRoom.action?nowpage=1">客房信息</a></li>
							<li><a href="findByPageMenu.action?nowpage=1">菜系信息</a></li>
							<li><a href="findNew.action?nowpage=1">新闻中心</a></li>
							<li><a href="page/hotelfour.jsp">留言中心</a></li>
							<li><a href="page/hotelnice.jsp">个人中心</a></li>
							<div class="clear"> </div>
						</ul>
					</div>
				</div>
			</div>
			<!---End-header--->
			<div class="clear"> </div>
			<!---start-content----->
			<div class="content" >
				<div class="wrap">
				<!---start-about---->
				<div class="about">
				<div class="about-grids">
					<div class="about-grid">
						<h3>客房介绍信息<img src="images/next.png" alt="" height="24" width="30"></h3>
						
						<p>客房标价：${romdetail.rdPrice}元</p>
						<p>客房折扣价：${romdetail.rdDiscount}元</p>
						<p>每小时消费价：${romdetail.rdPerhourprice}元</p>
						<p>客房电话：${romdetail.rdTelephone}</p>
						
						
					</div>
					<div class="about-grid center-grid1">
						<h3>客房图片信息<img src="images/next.png" alt="" height="24" width="30"></h3>
						<img src="room_images/${romdetail.room.RImg}" alt="最新" width="400" height="220">
	                     
						
				</div>
					<div class="about-grid last-grid">
						<h3>客房描述信息<img src="images/next.png" alt="" height="24" width="30"></h3>
						<p>客房主题：${romdetail.room.RTitle}</p>
						<span id="rom">客房介绍：${romdetail.rdContent}</span>
					</div>
					<div class="clear"> </div>
				</div>
			</div>
			</div>
				<!---End-about---->
				<div class="clear"> </div>
				
			<!---start-box---->
		</div>
		<!---start-copy-Right----->
		<div class="copy-tight">
			</div>
		<!---End-copy-Right----->
			</div>
			<!---End-content----->
		</div>
		<!---End-Wrap--->
	<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</body>
</html>

	