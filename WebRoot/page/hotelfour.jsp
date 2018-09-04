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
    
    <title>My JSP 'hotelfour.jsp' starting page</title>
    
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
   function mouseOver(){
   var obj=document.getElementById("nub").value;
   if(obj==""){
      if(confirm("系统检测到您还没有登录,会影响您下单！是否要先登录？"))
	   location.href="page/login.jsp";
   }

    }
 
   function checkALL(){
   var gg=document.getElementById("me").value;
   var nn=document.getElementById("mee").value;
 
   if(gg==""){
   alert("请您填写留言主题")
   return false;
   }
  if(nn==""){
   alert("请您填写留言内容")
   return false;
   }
   alert("留言信息填写完整")
   alert("您的留言已提交成功！")
   return true;
   
   }
   
</script>
<style type="text/css">
body{
	background: url(images/nk.png) ;
	
}
.company_address p{color: #FF0;font-weight: 300;font-size:18px;}
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
							<li><a href="page/hotelone.jsp">酒店首页</a></li>
							<li><a href="findByPageHotel.action?nowpage=1">订房中心</a></li>
							<li><a href="findByPageRoom.action?nowpage=1">客房信息</a></li>
							<li><a href="findByPageMenu.action?nowpage=1">菜系信息</a></li>
							<li><a href="findNew.action?nowpage=1">新闻中心</a></li>
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
					<!-------start-contatct------>
					<div class="contact">
				<div class="section group">				
				<div class="col span_1_of_3">
					<div class="contact_info">
			    	 	<h3>公司位置</h3>
			    	 		<div class="map">
			    	 		<img src="images/hotel.jpg" title="image-name" width="350"height="200"/>
					   			</div>
      				</div>
      			<div class="company_address">
				     	<h3>公司总部信息 :</h3>
						    	<p>公司地址: 公司总部位于北京市海淀区</p>
						   		<p>公司总揽: 全国性的餐饮娱乐服务公司</p>
						   		<p>公司电话: 0800-888999</p>
				   		        <p>公司传真: fox-231643876148</p>
				   		        <p>公司邮箱: tenglong@88888.com</p>
				 	 	        <p>公司网址: www.tenglongcc.com</p>
				   		        
				   </div>
				</div>				
				<div class="col span_2_of_3">
				  <div class="contact-form">
				  	<h3>留言给我们</h3>
					    <form method="post" action="addMessage.action" onsubmit="return checkALL()">
					    	<div>
						    	<span><label>留言Id：</label></span>
						    	<span><input name="message.luser.UId" type="text" id="nub" class="textbox" value="<s:property value='#session.loginUser.UId'/>" onfocus="mouseOver()"></span>
						    </div>
						    <div>
						    	<span><label>留言者：</label></span>
						    	<span><input name="message.luser.ULoginname" type="text" class="textbox" readonly="readonly" value="<s:property value='#session.loginUser.ULoginname'/>"></span>
						    </div>
						    <div>
						     	<span><label>留言主题：</label></span>
						    	<span><input name="message.MTitle" type="text" class="textbox" id="me" placeholder="在这里输入...."></span>
						    </div>
					
						    <div>
						    	<span><label>留言内容：</label></span>
						    	<span><textarea type="text" name="message.MContent"  id="mee"  placeholder="在这里输入内容"/> </textarea></span>
						    </div>
						   <div>
						   		<span><input type="submit" id="submit" value="确认留言" ></span>
						  </div>
					    </form>

				    </div>
  				</div>				
			  </div>
			</div>
					<!-------start-contatct------>
				</div>
				<div class="clear"> </div>
				
		<!---start-copy-Right----->
		<div class="copy-tight">
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
