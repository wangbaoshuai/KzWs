<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'manager.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>网站后台管理系统</title>
<script language="javascript" src="js/jquery.js"></script>
<style type="text/css">
<!--
* { 
	margin:0px; 
	padding:0px;
}
html, body{	
	height:100%;
	overflow: hidden;

}
html>body{		/*-- for !IE6.0 --*/
	width: auto;
	height: auto;
	position: absolute;
	top: 0px;
	left: 0px;
	right: 0px;
	bottom: 0px;
	
}
body {
	border:8px solid #ffffff;
	background-color: #ffffff;min-width:230px;
}
#mainDiv {
	width: 100%;
	height: 100%;
    padding:60px 0px 25px 0px;;
	
	
}
#centerDiv{
	width: 100%;
	height: 100%;
	
	padding-left:158px;
}
#mainDiv>#centerDiv{		/*-- for !IE6.0 --*/	
	width: auto;
	height: auto;
	position: absolute;
	top: 56px;
	left: 0px;
	right: 0px;
	bottom: 20px;
	
}
#left{
width:158px;
height:100%;
background:url(images/slide.jpg) repeat-y;
position:absolute;
left:0px;
}
#lhead{
background:url(images/left-head.jpg) left top no-repeat;
height:25px;
	font-size:14px;
	color:#FF9933;
    text-align:center;
	line-height:25px;
}
#right{
width:100%;
height:100%;
background:#ffffff;
position:absolute;
overflow-y:auto;
border:1px #003366 solid;
padding:20px 0 0 10px;
font-size:12px;
font-family:"宋体";
}
#centerDiv>#right{
width:auto;
height:auto;
position:absolute;
top:0px;
right:0px;
left:158px;
bottom:0px;
}
#topDiv{
	width:100%;
	height:56px;
	background:url(images/head-bg.jpg) repeat-x;
	position:absolute;
	top:0px;
	overflow:hidden;
}

#topDiv ul{
list-style:none;
font-size:12px;

width:100%;
margin:0;
padding:0;
}
#topDiv ul li{
float:left;
width:11%
}
#topDiv ul li a {
display:block;
width:100%;
height:25px;
line-height:25px;
background:url(images/menu-bg.jpg) repeat-x;
color:#FFFFFF;
direction:none;
text-align:center;
border-bottom:1px #000066 solid;
border:1px #06597D solid;
}
#topCenter{
with:100%;
position:absolute;
height:20px;
left:45%;
bottom:25px;
}
#tmenu{
width:100%;
position:absolute;
left:0%;
bottom:0;
padding-left:15%;
margin-left:-15%;
}
#current{
background: #FFF;
height:30px;
line-height:24px;
margin:-18px 0 0 -10;
overflow:hidden;
font-size:14px;
}
#bottomDiv{
	width:100%;
	height:20px;
	background:url(images/bottom.jpg) repeat-x;
	position:absolute;
	bottom:0px;
	bottom:-1px;		 /*-- for IE6.0 --*/
}
#left ul{
list-style:none;
font-size:14px;
margin:20px 0 0 8px;
}
#left ul li{
padding:3px 0 1px 0;
}
#left ul li a{
display:block;
width:140px;
height:25px;
line-height:25px;
background:url(images/menu-bg.jpg) 0px 25px;
color:#FFFFFF;
direction:none;
text-align:center;
border-bottom:2px #000066 solid;
border:1px #06597D solid;
}
#left ul li a:hover{

background:url(images/menu-bg.jpg) 0px 25px;
color:#99FFCC;
direction:none;
text-align:center;
border-bottom:1px #000066 solid;
}
#form{
width:100%;
background:url(images/wbs.jpg)  repeat-x;
height:99%;
margin:0 auto;
font-size:60px;
color:#BBB;
}

-->
</style>
</head>
<body>
<div id="mainDiv">
	<div id="topDiv">
	<div id="topCenter">
	 管理员:<s:property value="#session.loginUser.ULoginname"/>您好，欢迎登录管理！
	</div>
	<div id="tmenu">
	<ul>
	<li ><a href="page/manager.jsp">首页</a></li>
	<li ><a href="findByPageUser.action?nowpage=1" target="_blank">用户管理</a></li>
	<li ><a href="findByPageRoom.action?type=houtai&nowpage=1">客房管理</a></li>
	<li ><a href="findByPageMessage.action?nowpage=1">留言管理</a></li>
	<li ><a href="findNew.action?type=houtai&nowpage=1">新闻管理</a></li>
	<li ><a href="findOrder.action?nowpage=1">订单管理</a></li>
	<li ><a href="findComment.action?nowpage=1">评论管理</a></li>
	<li ><a href="page/hotelone.jsp">返回前台</a></li>
	<li ><a href="page/login.jsp">退出</a></li>
	</ul></div></div>
	<div id="centerDiv">
	
	<div id="left">
	<div id="lhead">管理菜单</div>
	<ul>
	<li ><a href="findByPageUser.action?nowpage=1">用户维护</a></li>
	<li ><a href="findByPageRoom.action?type=houtai&nowpage=1">客房维护</a></li>
	<li ><a href="page/roomadd.jsp">添加客房</a></li>
	<li ><a href="page/roomdetailadd.jsp">添加客房详情</a></li>
	<li ><a href="findByPageMenu.action?type=houtai&nowpage=1">菜系维护</a></li>
	<li ><a href="page/menuadd.jsp">添加菜系</a></li>
	<li ><a href="findNew.action?type=houtai&nowpage=1">新闻维护</a></li>
	<li ><a href="page/newadd.jsp">添加新闻</a></li>
	<li ><a href="findOrder.action?nowpage=1">订单维护</a></li>
	<li ><a href="findByPageMessage.action?nowpage=1">留言维护</a></li>
	<li ><a href="findComment.action?nowpage=1">评论维护</a></li>
	<li ><a href="findByPageHotel.action?type=houtai&nowpage=1">酒店维护</a></li>
	<li ><a href="page/hoteladd.jsp">添加酒店</a></li>
	
	</ul>
	</div>
	<div id="right"> 
	<div id="current">&nbsp;&nbsp;&nbsp;&nbsp;当前位置:<<腾龙大酒店管理后台>></div>
<div id="form">
  <center>管理是企业经营之本</center>
</div>
</div></div>
	<div id="bottomDiv"></div>
</div>
<script language="javascript">
$("#test1").toggle(function(){$("#test").slideDown()},function(){$("#test").slideUp()})
</script>
<div style="text-align:center;">
</div>
</body>
</html>