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
    
    <title>My JSP 'hotelseven.jsp' starting page</title>
    
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
      #rom{color: #8080FF;font-weight: 300;font-size:16px;}
      .about-grid a{border-radius:0px; border:4px solid #FFF;display:inline-block; padding:0px 1px;}
      .about form a{border-radius:0px; border:0px solid #FFF;display:inline-block; padding:0px 1px;}
      .about-grid p{color: #BC7676;font-weight: 300;font-size:16px;}
     body{
	background: url(images/bg.jpg) ;
   </style>
   <script type="text/javascript">
   function mouseOver(){
   var ojb=document.getElementById("dname").value;
   if(ojb==""){
      if(confirm("系统检测到您还没有登录,会影响您下单！是否要先登录？"))
	   location.href="page/login.jsp";
	   }
  
 }
 function checkyhn(){
			var getyhxm=document.getElementById("xname").value;
			var reg=/^[\u4e00-\u9fa5]+$/;
			if(getyhxm==""){
			  alert("入住人姓名不能为空！")
			  return false;
			}
			if(!reg.test(getyhxm)){
				alert("请您输入您的中文汉字姓名！！！")
				return false;
			}else{
			 
				return true;
			}
			}
 function checkName(){
   var reg=/^(?:(?!0000)[0-9]{4}-(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-8])|(?:0[13-9]|1[0-2])-(?:29|30)|(?:0[13578]|1[02])-31)|(?:[0-9]{2}(?:0[48]|[2468][048]|[13579][26])|(?:0[48]|[2468][048]|[13579][26])00)-02-29)$/;
   var fff=document.getElementById("xdate").value;
   if(fff==""){
			   alert("请您填写入住日期！");
			   return false;
			}
   if(!reg.test(fff)){
			alert("日期格式不正确！")
			  return false;
			}
			
			return true;
   }
   function checkName2(){
   var reg=/^(?:(?!0000)[0-9]{4}-(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-8])|(?:0[13-9]|1[0-2])-(?:29|30)|(?:0[13578]|1[02])-31)|(?:[0-9]{2}(?:0[48]|[2468][048]|[13579][26])|(?:0[48]|[2468][048]|[13579][26])00)-02-29)$/;
   var hhh=document.getElementById("ndate").value;
   if(hhh==""){
			  alert("请您填写退房日期！")
			  return false;
			}
   if(!reg.test(hhh)){
			alert("日期格式不正确！")
			  return false;
			}
			
			return true;
   }
   
   function checkphone(){
			var reg=/^1\d{10}$/;
			var phonestr=document.getElementById("xtel").value;
			if(phonestr==""){
			  alert("手机号码不能为空！")
			  return false;
			}
			if(!reg.test(phonestr)){
				alert("您的手机号码格式不对")
				return false;
			}
			else{
				
				return true;
			}
		}
function chexk(){
        if(document.getElementById("tiaokuan").checked){
            return true;
            }else{
			 alert("客房预订须知未勾选！")
			return false;
			}
			
		}
		
function checkall(){
       if(checkName()&&checkName2()&&checkyhn()&&checkphone()&&chexk()){
        alert("您的订单填写正确！")
        alert("OK，您的订单即将提交。预订成功您将获得20积分！")
			return true;
		
    }else{
      return false;
    }
    
     }


</script>
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
						<h3>${roomdetail.room.RTitle}<img src="images/next.png" alt="" height="24" width="30"></h3>
						<img src="room_images/${roomdetail.room.RImg}" alt="最新" width="380" height="180">
						<span id="rom">客房介绍：${roomdetail.rdContent}</span>
						<p>客房标价：${roomdetail.rdPrice}元</p>
						<p>客房折扣价：${roomdetail.rdDiscount}元</p>
						<p>每小时消费价：${roomdetail.rdPerhourprice}元</p>
						<p>客房电话：${roomdetail.rdTelephone}</p>
						
					</div>
					<div class="about-grid center-grid1">
						<h3>请您完善相关信息<img src="images/next.png" alt="" height="24" width="30"></h3>
			<form action="addOrder.action" method="post" onsubmit="return checkall()">
		       <input type="hidden" name="order.luser.UId"  value="<s:property value="#session.loginUser.UId"/>" id="dname"/>
		客房编号:<input type="text" name="order.room.RId" value="<s:property value="#session.roomdetail.room.RId"/>" readonly="readonly" size="40" /></br></br></br>
		入住姓名:<input type="text" name="order.OName" placeholder="请输入入住人姓名" size="40" id="xname" onfocus="mouseOver()" onblur="checkyhn()"/></br></br></br>
		入住日期:<input type="text" name="order.ODate" placeholder="2017-01-01" size="40" id="xdate" onblur="checkName()"/></br></br></br>
	           离开日期:<input type="text" name="order.BDate" placeholder="2017-01-01" size="40" id="ndate" onblur="checkName2()"/></br></br></br>        
	           联系电话:<input type="text" name="order.OTelphone" placeholder="请输入本人电话" size="40" id="xtel" onblur="checkphone()"/></br></br></br>
			   &nbsp;&nbsp;<input type="checkbox" id="tiaokuan">我接受<a href="page/intruduce.jsp">《酒店客房预订须知》</a>的相关条例</br></br>
			   &nbsp;&nbsp;&nbsp;&nbsp;
			   <input type="submit" value="book now" style="width: 282px; height:30px; background-color:#0FF;">
				</form>
				</div>
					<div class="about-grid last-grid">
						<h3>您的订单信息<img src="images/next.png" alt="" height="24" width="30"></h3>
						<table border="1" width="200" height="500">
						 <tr><td>订单编号:</td><td>${order.OId}</td></tr>
						 <tr><td>订单日期:</td><td>${order.YDate}</td></tr>
						 <tr><td>预订用户:</td><td>${order.OName}</td></tr>
						 <tr><td>房间编号:</td><td>${order.room.RId}</td></tr>
						 <tr><td>房间类型:</td><td>${order.room.rtype.trName}</td></tr>
						 <tr><td>所在酒店:</td><td>${order.room.hotel.HName}</td></tr>
						 <tr><td>入住日期:</td><td>${order.ODate}</td></tr>
						 <tr><td>退房日期:</td><td>${order.BDate}</td></tr>
						</table>
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

	