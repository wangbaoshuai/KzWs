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
    
    <title>My JSP 'hotelsix.jsp' starting page</title>
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
 <script src="js/responsiveslides.min.js"></script>
<style>
#m { top:980px; left:1320px}
#s { top:980px; left:1350px}
#n { top:980px; left:1380px}
#iimg{width:400px; height:200px; border:#09F solid 1px; }
.btn{cursor:hand; width:31px; height:27px; background-image:url(images/btn-blue.gif); position:absolute; line-height:27px; text-align:center}
</style>
<SCRIPT src="jquery.js"></SCRIPT>
<SCRIPT>
var num=1;
var time;
$(document).ready(function(){imgchange();$(".btn").bind("mouseout", function(){time=setTimeout("imgchange()",1500);});});
var imgg=new Array();
imgg[1]="n";imgg[2]="s";imgg[3]="m";
function imgchange()
{	
	$(".btn").css("background-image","url(images/btn-blue.gif)");	
	$("#iimg").css("background-image","url(images/"+imgg[num]+".jpg)");
	$("#"+imgg[num]+"").css("background-image","url(images/btn-green.gif)");	
	num++;
	if(num==4){num=1;}
	time=setTimeout("imgchange()",1500);
}

function changeimg(id)
{
	clearTimeout(time);
	$(".btn").css("background-image","url(images/btn-blue.gif)");
	$("#"+id+"").css("background-image","url(images/btn-green.gif)");
	$("#iimg").fadeOut("slow",function(){$("#iimg").css("background-image","url(images/"+id+".jpg)");});
	$("#iimg").fadeIn("slow");								 
}

</SCRIPT>
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
   	  #dadiv{ width:400px; height:520px; border:solid 0px #999999; overflow:hidden}
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
						    <li><a href="page/hotelone.jsp">酒店首页</a></li>
						    <li><a href="findByPageHotel.action?nowpage=1">订房中心</a></li>
							<li><a href="findByPageRoom.action?nowpage=1">客房信息</a></li>
							<li><a href="findByPageMenu.action?nowpage=1">菜系信息</a></li>
							<li><a href="page/hotelfour.jsp">留言中心</a></li>
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
			<div class="content" style="background-color:#8080FF;">
				<div class="wrap">
					<!-----start--services------>
					<div class="services">
						<div class="service-content">
							<h3>腾龙酒店最新新闻</h3>
							<ul>
							<c:forEach var="news" items="${newList }">
								<li><span width="260" height="120" ></span></li>
								<li><img src="news_images/${news.NImage}" alt="" width="260" height="120" style="float: left;">
								<p align="left" style="padding-left: 60px;float: left;"><a href="findNew.action?nowpage=1"><img src="images/gif-0257.gif" alt="" >&nbsp;${news.NTitle} </a><br/>
								<img src="images/ts.gif" alt="" >&nbsp;新&nbsp;闻&nbsp;内&nbsp;容&nbsp;:
								<c:if test="${news.NContent.length() >= 25 }">${news.NContent.substring(0,25)}...</c:if>
						        <c:if test="${news.NContent.length() <25 }">${news.NContent}</c:if>
								<br/> 
								     </p>    
								</li>
								<div class="clear"><hr/> </div>
							</c:forEach>
							</ul>
						<br/>
						    
					 <div class="pagelist">
				     <div style="margin-left:500px";>
						<ul>
						   <c:forEach var="i" step="1" begin="1" end="${pages}">
							<li class="active"><a href="findNew.action?nowpage=${i}">${i}</a></li>
							</c:forEach>
						</ul>
					</div>
					</div>
						</div>
						<div class="services-sidebar">
						<h3>新闻纵览 &nbsp;<img src="images/u70.png" width="45" height="35" title="logo" /></h3>
					<div id="dadiv"  onmouseover="moveStop()" onmouseout="moveStart()">
						 <div class="book_class" id="xiao1div">
							 <ul>
							 <c:forEach var="nes" items="${newsList}">
							  	<li>${nes.NTitle}&nbsp;<img src="images/ts.gif" alt="" ><a href="findNew.action?nowpage=1"><img src="images/pic23.gif" alt="" >
							  	<c:if test="${nes.NContent.length() >= 18 }">${nes.NContent.substring(0,18)}...</c:if>
						        <c:if test="${nes.NContent.length() <18 }">${nes.NContent}</c:if>
							  	</a></li>
							  
							 </c:forEach>
					 		 </ul>
					 	</div>
					    <div class="book_class" id="xiao2div">
					 		 <ul>
							 <c:forEach var="nes" items="${newsList}">
							  <li>${nes.NTitle}&nbsp;<img src="images/ts.gif" alt="" ><a href="findNew.action?nowpage=1"><img src="images/pic23.gif" alt="" >
							    <c:if test="${nes.NContent.length() >= 18 }">${nes.NContent.substring(0,18)}...</c:if>
						        <c:if test="${nes.NContent.length() <18 }">${nes.NContent}</c:if>
							  	</a></li>
							 </c:forEach>
					 		 </ul>
					 	</div>
					</div>
						<h3>欣赏一角</h3>
					 <div class="btn" id="m" onmouseover="changeimg(id)">1</div>
                     <div class="btn" id="s" onmouseover="changeimg(id)">2</div>
                     <div class="btn" id="n" onmouseover="changeimg(id)">3</div>
                     <div id="iimg"></div>
					  </div>
						<div class="clear"> </div>
					</div>
					<!-----End--services------>
				</div>
				<div class="clear"> </div>
				
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

