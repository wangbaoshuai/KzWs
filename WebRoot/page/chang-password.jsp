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
    
    <title>My JSP 'chang-password.jsp' starting page</title>
    
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
function showmess3(){
	       document.getElementById("mm").className="xianshi";
	       document.getElementById("mm").innerHTML="密码长度为6-16位";
	   } 
       function checkpwd(){
		  var upass=document.getElementById("pas").value;
		   alert("upass"+upass);
		   if(upass==""){
			   document.getElementById("mm").className="yanzh";
			   document.getElementById("mm").innerHTML="密码不能为空!请输入密码";
			  return false;
			 }
			 return true;
		}
function checkcfpwd(){
		   var upass=document.getElementById("password1").value;
		   var upwd=document.getElementById("password2").value;
		   if(upwd==""){
			    document.getElementById("cmm").className="yanzh";
			    document.getElementById("cmm").innerHTML="确认密码不能为空!请输入密码";
			  return false;
			 }
		   if(upass!=upwd){
			   document.getElementById("cmm").className="yanzh";
			   document.getElementById("cmm").innerHTML="两次输入的密码不一致，请重新输入";
			   return false;
			 }else{
		        document.getElementById("cmm").className="yanzh";
			    document.getElementById("cmm").innerHTML="两次密码输入正确";
				return false;
				 }
		   return true;
		}

</script>
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
					    <a class="item" href="page/hotelnice.jsp">
							<i class="edit icon"></i>基本信息
  						</a>
  						<a class="item" href="page/user-modify.jsp">
							<i class="edit icon"></i>账户设置
  						</a>
						<a class="item" href="findByUserAndPageOrder.action?user.UId=${loginUser.UId}&nowpage=1">
							<i class="key icon"></i>管理订单
						</a>
  						<a class="active teal item" href="page/chang-password.jsp">
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
						<h3 class="ui dividing  header">
  							<i class="large unlock alternate icon"></i>
  							<div class="content">
    							修改密码
  							</div>
						</h3>
					</div>
				</div>
				<!--the form-->
                <form class="ui form vertical segment" action="changeUser.action" name="fname" onsubmit="return checkForm()" method="post">
                         <input type="hidden" name="uid" value="${loginUser.UId}"/>
                    <div class="two fields">
                        <div class="field">
                            <label>原密码</label>
                            <div class="ui small left icon input">
                              <input type="password" id="password" name="beforepwd" size="30">
                              <i class="lock icon"></i>
                            </div>
                        </div>
                    </div>
                    <div class="two fields">
                    	<div class="field">
                        	<label>新密码</label>
                            <div class="ui small left icon input">
                            	<input type="password" id="password1" name="user.ULoginpass" size="30" onblur="checkpwd()" onfocus="showmess3()">
                                <i class="lock icon"></i><span class="" id="mm"></span>
                            </div>
                        </div>
                    </div>
                    <div class="two fields">
                    	<div class="field">
                        	<label>确认新密码</label>
                            <div class="ui small left icon input">
                            	<input type="password" id="password2" name="password2" size="30" onblur="checkcfpwd()" onfocus="">
                                <i class="lock icon"></i><span class="yanzh" id="cmm"></span>
                            </div>
                        </div>
                    </div>
                    <input class="ui small blue submit button" type="submit" value="保存">
                    <input class="ui small basic button" type="reset" value="取消">
                </form>
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
