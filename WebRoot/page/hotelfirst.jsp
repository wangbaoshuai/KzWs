<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags"  prefix="s"%>
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
    
    <title>My JSP 'hotelfirst.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  <link href="css/style.css" rel="stylesheet" type="text/css"  media="all" />
  <script src="js/jquery-1.8.3.min.js"></script>
  <script type="text/javascript">
function move(){
	var daobj=document.getElementById("dadiv");
	var xiaobj=document.getElementById("xiao1div");
	daobj.scrollTop++;
	if(daobj.scrollTop>xiaobj.offsetHeight)
	daobj.scrollTop=0;
	}
	var temp_inter=setInterval("move()",5);
	function moveStop(){
		clearInterval(temp_inter);
		}
	function moveStart(){
		temp_inter=setInterval("move()",5);
		}	
    </script>
  <style type="text/css">
		.pagelist {padding:10px 0; text-align:center;}
		.pagelist ul li{float:left;}
		.pagelist span,.pagelist a{ border-radius:3px; border:1px solid #397BEA;display:inline-block; padding:5px 12px;}
		.pagelist a{ margin:0 3px;}
		.pagelist span.current{ background:#09F; color:#FFF; border-color:#09F; margin:0 2px;}
		.pagelist a:hover{background:#09F; color:#900; border-color:#09F; }
		.pagelist label{ padding-left:15px; color:#999;}
		.pagelist label b{color:red; font-weight:normal; margin:0 3px;}
		
		.gallery-grid h5{color: #900;font-weight: 300;}
		.gallery-grid a{border-radius:0px; border:2px solid #FF8000;display:inline-block; padding:0px 1px;}
		 .services h3{color: #FFF;font-weight: 300;}
		</style>
	<style type="text/css">
   	  #dadiv{ width:400px; height:510px; border:solid 0px #999999; overflow:hidden}
   </style>
   <style type="text/css">
body{
	background: url(images/bg.jpg) ;
	
}
</style>
</head>
<body>
		<!---start-Wrap--->
			<!---start-header--->
			<div class="header">
				<div class="wrap" >
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
							<li><a href="findByPageRoom.action?nowpage=1">客房信息</a></li>
							<li><a href="findByPageMenu.action?nowpage=1">菜系信息</a></li>
							<li><a href="findNew.action?nowpage=1">新闻中心</a></li>
							<li><a href="page/hotelfour.jsp">留言中心</a></li>
							<li><a href="findByPageHotel.action?nowpage=1">评论中心</a></li>
							<li><a href="page/hotelnice.jsp">个人中心</a></li>
							<div class="clear"> 
							</div>
						</ul>
					</div>
				</div>
			</div>
			<!---End-header--->
			<div class="clear"> </div>
			<!---start-content----->
			<div class="content" >
				<div class="wrap">
					<!-----start--services------>
					<div class="services">
						<div class="service-content">
							<h3>腾龙集团旗下的所有的连锁酒店</h3>
							<ul>
							<c:forEach var="hotel" items="${hotelList }">
								<li ><span width="300" height="150" ></span></li>
								<li><img src="hotel_images/${hotel.HImage}" alt="" width="300" height="150" style="float: left;">
								<p align="left" style="padding-left: 70px;float: left;"><a href="findByPageAndhotelComment.action?hotel.HId=${hotel.HId}&nowpage=1">${hotel.HName}&nbsp; <img src="images/gif-0257.gif" alt="" ><img src="images/gif-0257.gif" alt="" ><img src="images/gif-0257.gif" alt="" ><img src="images/gif-0257.gif" alt="" ><img src="images/gif-0257.gif" alt="" ><img src="images/gif-0257.gif" alt="" ></a><br/>
								                     酒&nbsp;店&nbsp;服&nbsp;务&nbsp;热&nbsp;线:&nbsp;${hotel.HTelephone}<br/> 酒&nbsp;店&nbsp;简&nbsp;介:&nbsp;${hotel.HContent}
								     <br>酒&nbsp;店&nbsp;地&nbsp;址:&nbsp;${hotel.HAddress}<div align="right"> <a href="findByPageAndhotelComment.action?hotel.HId=${hotel.HId}&nowpage=1" style="background: url(images/u17.png) repeat-x;">酒店&评论</a></div></p>
								     <div align="right" style="padding-top:90px;"><a href="findByPageAndHotelRoom.action?hotel.HId=${hotel.HId}&nowpage=1" style="background: url(images/u15.png) repeat-x;">预订&客房</a></div>
						         
						         
								</li>
								<div class="clear"><hr/> </div>
							</c:forEach>
							</ul>
						
						    
					 <div class="pagelist">
				     <div style="margin-left:500px";>
						<ul>
						   <c:forEach var="i" step="1" begin="1" end="${pages}">
							<li class="active"><a href="findByPageHotel.action?nowpage=${i}">${i}</a></li>
							</c:forEach>
						</ul>
					</div>
					</div>
						</div>
						<div class="services-sidebar">
						<h3>网友评论&nbsp;&nbsp;<img src="images/u66.png" width="45" height="35" title="logo" /></h3>
					<div id="dadiv"  onmouseover="moveStop()" onmouseout="moveStart()">
						 <div class="book_class" id="xiao1div">
							 <ul>
							 <c:forEach var="comment" items="${commtList}">
							  	<li><a>${comment.hotel.HName}------------------------酒店评分:${comment.CScore}</a><br/>
							  	<a href="findByPageAndhotelComment.action?hotel.HId=${comment.hotel.HId}&nowpage=1" style="color:#FF8000;">
							  	<img src="images/pic23.gif" alt="" >
							  	<c:if test="${comment.CContent.length() >= 20 }">${comment.CContent.substring(0,20)}...</c:if>
						        <c:if test="${comment.CContent.length() <20 }">${comment.CContent}</c:if>
							  	
							  	</a>
							  	</li>
							  
							 </c:forEach>
					 		 </ul>
					 	</div>
					    <div class="book_class" id="xiao2div">
					 		 <ul>
							 <c:forEach var="comment" items="${commtList}">
							  	<li><a>${comment.hotel.HName}------------------------酒店评分:${comment.CScore}</a><br/>
							  	<a href="findByPageAndhotelComment.action?hotel.HId=${comment.hotel.HId}&nowpage=1" style="color:#FF8000;">
							  	<img src="images/pic23.gif" alt="" >
							  	<c:if test="${comment.CContent.length() >= 20 }">${comment.CContent.substring(0,20)}...</c:if>
						        <c:if test="${comment.CContent.length() <20 }">${comment.CContent}</c:if>
							  
							  	</a>
							  	</li>
							  
							 </c:forEach>
					 		 </ul>
					 	</div>
					</div>
						<h3>最近活动</h3>
					 		 <ul>
					 		 	<li><a href="findByPageHotel.action?nowpage=1">JAN, 2017公司上个月组织了一次年会</a></li>
					 		 	<li><a href="findByPageHotel.action?nowpage=1">FEB, 2017公司最近有推出了最新的菜系</a></li>
					 		 	<li><a href="findByPageHotel.action?nowpage=1">MAR, 2017北京腾龙店组织了一次员工晚会</a></li>
					 		 	<li><a href="findByPageHotel.action?nowpage=1">APRIL, 2017上海腾龙店又进行了规模的扩建</a></li>
					 		 	<li><a href="findByPageHotel.action?nowpage=1">MAR, 2017公司上个月组织了一次年会</a></li>
					 		 	<li><a href="findByPageHotel.action?nowpage=1">APRIL, 2017公司上个月组织了一次年会</a></li>
					 		 </ul>
					  </div>
						<div class="clear"> </div>
					</div>
					<!-----End--services------>
				</div>
				<div class="clear"> </div>
				
			<!---start-box---->
		</div>
		<!---start-copy-Right----->
		<div class="copy-tight" style="background-color:#C5C5C5;">
			<p>TengLongDaJiuDian &copy; 腾龙大酒店欢迎您的光临<a target="_blank" href="http://www.chinatenglong.com/"></a></p>
		</div>
		<!---End-copy-Right----->
			</div>
			<!---End-content----->
		</div>
		<!---End-Wrap--->
	<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</body>
</html>

