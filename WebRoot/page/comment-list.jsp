<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'comment-list.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link type="text/css" rel="stylesheet" href="resource/css/framework.css" />
    <link type="text/css" rel="stylesheet" href="resource/css/main.css" />
    <script type="text/javascript">
	 function deletecomment(id){
	   if(confirm("是否确认要删除？"))
	   location.href="deleteComment.action?id="+id;
	   }
	</script>
	<style type="text/css">
	#com{float:right;}
	.pagelist li{float:left;list-style:none;}
	</style>
</head>
<body>
<div class="page">
<!--header begin-->
<header>
	<div class="bigcontainer">
		<div id="log">
			<a href="./"></a>
		</div>
		<div class="user">
			<div class="ui compact notif menu">
			  <a class="item">
				<i class="mail large icon"></i>
				<span class="circular floating ui small red label">3</span>
			  </a>
			</div>
			<div class="ui inline labeled icon top right pointing dropdown">
			<img class="ui avatar image" src="user_images/${loginUser.UImage}" >欢迎，${loginUser.ULoginname}
			<i class="dropdown icon"></i>
				<div class="menu">
					<a class="item" href="http://www.yeelink.net"><i class="reply mail icon"></i>返回首页</a>
					<a class="item" href="/user/logout"><i class="sign out icon"></i>注销登录</a>
				</div>
			</div>
		</div>
	</div>
</header>
<!-- the main menu-->
<div class="ui teal inverted menu">
	<div class="bigcontainer">
		<div class="right menu">
			<a class="active item" href="page/hotelone.jsp"><i class="home icon"></i>酒店首页</a>
			<a class="item" href="findByPageRoom.action?nowpage=1"><i class="sitemap icon"></i>客房</a>
			<a class="item" href="findNew.action?nowpage=1"><i class="cloud icon"></i>新闻</a>
			<a class="item" href="page/login.jsp"><i class="info icon"></i>注销</a>
		</div>
	</div>
</div>
<!--the main content begin-->
	<div class="container">
	<!--the content-->
		<div class="ui grid">
			<!--the vertical menu-->
			<div class="four wide column">
				<div class="verticalMenu">
					<div class="ui vertical pointing menu fluid">
  						 <a class="item" href="page/hotelnice.jsp">
							<i class="edit icon"></i>基本信息
  						</a>
  						<a class="item" href="page/user-modify.jsp">
							<i class="edit icon"></i>账户设置
  						</a>
						<a class="item" href="findByUserAndPageOrder.action?user.UId=${loginUser.UId}&nowpage=1">
							<i class="key icon"></i>管理订单
						</a>
  						<a class="item" href="page/chang-password.jsp">
    						<i class="lock icon"></i> 修改密码
  						</a>
						<a class="active teal item" href="findByPageAndUserComment.action?user.UId=${loginUser.UId}&nowpage=1">
    						<i class="chat icon"></i> 评论队列
  						</a>
  						<a class="item" href="findByPageAndUserMessage.action?user.UId=${loginUser.UId}&nowpage=1">
    						<i class="chat icon"></i> 消息队列
  						</a>
					</div>
				</div>
			</div>
			<div class="twelve wide column">
				<div class="pageHeader">
					<div class="segment">
						<h3 class="ui dividing header">
  							<i class="large chat icon"></i>
  							<div class="content">
    							我发表的评论
    							<div class="sub header">我的系统消息以及评论</div>
  							</div>
						</h3>
					</div>
				</div>
				<!--notifications feed-->
				<div class="ui vertical feed segment">
				  
				<c:forEach var="comment" items="${commtList}">
					<div class="event">
						<div class="label">
						  <img src="user_images/${loginUser.UImage}">
						</div>
						<div class="content">
							  <div class="date">
								${comment.CDate}
							  </div>
							  <div class="summary">
								 我 <a>评论</a>${comment.hotel.HName}：
							  </div>
							  <div class="extra text">&nbsp;<img src="images/back.gif" alt="" >&nbsp;
								<c:if test="${comment.CContent.length() >= 20 }">${comment.CContent.substring(0,20)}...</c:if>
					            <c:if test="${comment.CContent.length() <20 }">${comment.CContent}</c:if>
								
								<span id="com"><a href="javascript:deletecomment(${comment.CId})"><img src="images/defind.gif" alt="" width="25" height="25"></a></span>
							  </div>
							  
						</div>
					</div>
					</c:forEach>
					
					<div class="pagelist">
				    <center>
				     <div style="margin-left:250px";>
						<ul>
						   <c:forEach var="i" step="1" begin="1" end="${pages}">
							
							<li class="active"><a href="findByPageAndUserComment.action?user.UId=${loginUser.UId}&nowpage=${i}">${i}&nbsp;</a></li>
							
							</c:forEach>
							
						</ul>
						</div>
						</center>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!--footer begin-->
<footer>
	<div id="copyrights">
		<div class="inset">
			<div class="bigcontainer">
				<div class="fl">
					<div class="log"></div>
					<p><h1>TengLongDaJiuDian &copy; 腾龙大酒店欢迎您的光临</h1><a target="_blank" href="http://www.chinatenglong.com/"></a></p></div>
			</div>
		</div>
	</div>
</footer>

<script type="text/javascript" src="resource/javascript/jquery.min.js"></script>
<script type="text/javascript" src="resource/javascript/framework.js"></script>
<script type="text/javascript">
	$('.ui.dropdown')
	.dropdown();
</script>
</body>
</html>
