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
    
    <title>My JSP 'hotelnice.jsp' starting page</title>
    
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
			<a class="item" href="page/login.jsp"><i class="info icon"></i>注销</a></div>
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
					    <a class="active teal item" href="page/hotelnice.jsp">
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
						<a class="item" href="findByPageAndUserComment.action?user.UId=${loginUser.UId}&nowpage=1">
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
  							<i class="large edit icon"></i>
  							<div class="content">
    							基本信息
    							<div class="sub header">我的个人账户信息</div>
  							</div>
						</h3>
					</div>
				</div>
				<!--the user_profile form-->
				<div class="ui form vertical segment">
					<form action="#" name="form" method="post">
					  <input type="hidden" name="uid" value="${ loginUser.UId}">
						<div class="two fields">
							<div class="field">
								<label>我的用户名</label>
								<div class="ui left labeled icon input">
									<input type="text" id="username" name="user.ULoginname" value="${loginUser.ULoginname}" readonly="readonly" >
									<i class="user icon"></i>
									<div class="ui corner label"></div>
								</div>
							</div>
                        </div>
                        <div class="two fields">
							<div class="field">
								<label>我的性别</label>
								<div class="ui left labeled icon input">
									<input type="text" id="username" name="user.USex" value="${loginUser.USex}" readonly="readonly">
									<i class="user icon"></i>
									<div class="ui corner label"></div>
								</div>
							</div>
                        </div>
                        <div class="two fields">
							<div class="field">
								<label>我的积分</label>
								<div class="ui left labeled icon input">
									<input type="text" id="username" name="user.UScore" value="${loginUser.UScore}" readonly="readonly">
									<i class="user icon"></i>
									<div class="ui corner label"></div>
								</div>
							</div>
                        </div>
                        <div class="two fields">
							<div class="field">
								<label>我的证件</label>
								<div class="ui left labeled icon input">
									<input type="text" id="username" name="user.UIdcard" value="${loginUser.UIdcard}" readonly="readonly">
									<i class="user icon"></i>
									<div class="ui corner label"></div>
								</div>
							</div>
                        </div>
                        <div class="two fields">
							<div class="field">
								<label>我的电话</label>
								<div class="ui left labeled icon input">
									<input type="text" id="username" name="user.UTelephone" value="${loginUser.UTelephone}" readonly="readonly">
									<i class="user icon"></i>
									<div class="ui corner label"></div>
								</div>
							</div>
                        </div>
                        <div class="two fields">
							<div class="field">
								<label>我的地址</label>
								<div class="ui left labeled icon input">
									<input type="text" id="username" name="user.UAddress" value="${loginUser.UAddress}" readonly="readonly">
									<i class="user icon"></i>
									<div class="ui corner label"></div>
								</div>
							</div>
                        </div>
                        <div class="two fields">
				            <div class="field">
								<label>电子邮箱</label>
								<div class="ui left labeled icon input">
								<input type="text" id="useremail" name="user.UEmail" value="${loginUser.UEmail}" readonly="readonly">
								<i class="mail icon"></i>
								</div>
				            </div>
						</div>
					
					</form>
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
					<p><h1>TengLongDaJiuDian &copy; 腾龙大酒店欢迎您的光临</h1><a target="_blank" href="http://www.chinatenglong.com/"></a></p>
				</div>
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
