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
    
    <title>My JSP 'comment-list2.jsp' starting page</title>
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
   function mouseOver(){
   var obj=document.getElementById("mnu").value;
  if(obj==""){
    if(confirm("系统检测到您还没有登录,会影响您发表评论！是否要先登录？"))
	   location.href="page/login.jsp";
   }
 }
 function check(){
   var hh=document.getElementById("com").value;
   var aa=document.getElementById("comm").value;
   var bb=document.getElementById("come").value;
   var reg=/^[\u4e00-\u9fa5]+$/;
   if(hh==-1){
   alert("请选择酒店")
    return false;
   }
   if(aa==-1){
   alert("请选择评分")
    return false;
   }
   if(bb==""){
   alert("请填写评论内容")
   return false;
   }
   if(!reg.test(bb)){
	alert("评论内容应该为中文汉字！！！")
	return false;
   }
   alert("评论成功，恭喜您获得10积分！")
   return true;
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
   	<!--控制左右-->  
   	.service-content{
	float:right;
	width: 66.5%;
}
.service-content ul{
	padding-bottom:5px;
}
.services-sidebar{
	float:left;
	width:33%;
}
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
							<li class="active"><a href="findByPageRoom.action?nowpage=1">客房信息</a></li>
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
					<div class="services" >
						<div class="service-content" >
							<h3>客户评论中心</h3>
							<ul>
							<c:forEach var="hcom" items="${commentList}" varStatus="i">
							 <c:if test="${i.index <6}">
								<li><span width="100" height="100" ></span></li>
								<li><img src="user_images/${hcom.luser.UImage}" alt="" width="80" height="80" style="float: left;">
								<p><a href="findByPageHotel.action?nowpage=1" style="color:#FF8000;">${hcom.luser.ULoginname}&nbsp;&nbsp;评论&nbsp;&nbsp;${hcom.hotel.HName}&nbsp;<img src="images/ts.gif" alt="" ></a>酒店评分:&nbsp;&nbsp;${hcom.CScore}分<img src="images/pic23.gif" alt="" ><br/>     
								       评论内容:&nbsp;&nbsp;
								       <c:if test="${hcom.CContent.length() >= 26 }">${hcom.CContent.substring(0,26)}...</c:if>
					                  <c:if test="${hcom.CContent.length() <26 }">${hcom.CContent}</c:if>
								       &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a style="padding-left:620px;font-size:14px;">${hcom.CDate}</a>
								</p>
								</li>
								<div class="clear"></div>
							</c:if>
							</c:forEach>
							</ul>
							<div class="pagelist">
				     <center>
				     <div style="margin-left:500px";>
						<ul>
						  
						   <c:forEach var="i" step="1" begin="1" end="${pages}">
							<li class="active"><a href="findByPageAndhotelComment.action?nowpage=${i}&hotel.HId=${hot_second.HId}">${i}</a></li>
							</c:forEach>
							
						</ul>
					</div>
						</center>
					</div>
						</div>
						<div class="services-sidebar">
							<h3>客户评论中心</h3>
							<div id="dadiv"  onmouseover="moveStop()" onmouseout="moveStart()">
						 <div class="book_class" id="xiao1div">
							 <ul>
							 <c:forEach var="comment" items="${commtList}">
							  	<li><a href="findByPageAndhotelComment.action?hotel.HId=${comment.hotel.HId}&nowpage=1" style="color:#242424;">${comment.hotel.HName}&nbsp;&nbsp;
							  	<img src="images/gif-0257.gif" alt="" ><img src="images/gif-0257.gif" alt="" ><img src="images/gif-0257.gif" alt="" ><img src="images/gif-0257.gif" alt="" ><img src="images/gif-0257.gif" alt="" ><img src="images/gif-0257.gif" alt="" >
							  	</a>
							  	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="findByPageAndhotelComment.action?hotel.HId=${comment.hotel.HId}&nowpage=1" style="color:#FF8080;"><img src="images/back.gif" alt="" >
							  	<c:if test="${comment.CContent.length() >= 20 }">${comment.CContent.substring(0,20)}...</c:if>
					            <c:if test="${comment.CContent.length() <20 }">${comment.CContent}</c:if>
							  	</a></li>
							  </c:forEach>
					 		 </ul>
					 		 </div>
					    <div class="book_class" id="xiao2div">
					 		  <ul>
							 <c:forEach var="comment" items="${commtList}">
							  	<li><a href="findByPageAndhotelComment.action?hotel.HId=${comment.hotel.HId}&nowpage=1" style="color:#242424;">${comment.hotel.HName}&nbsp;&nbsp;
							  	<img src="images/gif-0257.gif" alt="" ><img src="images/gif-0257.gif" alt="" ><img src="images/gif-0257.gif" alt="" ><img src="images/gif-0257.gif" alt="" ><img src="images/gif-0257.gif" alt="" ><img src="images/gif-0257.gif" alt="" >
							  	</a>
							  	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="findByPageAndhotelComment.action?hotel.HId=${comment.hotel.HId}&nowpage=1" style="color:#FF8080;"><img src="images/back.gif" alt="" >
							  	<c:if test="${comment.CContent.length() >= 20 }">${comment.CContent.substring(0,20)}...</c:if>
					            <c:if test="${comment.CContent.length() <20 }">${comment.CContent}</c:if>
					
							  	</a></li>
							  </c:forEach>
					 		 </ul>
					 	</div>
					</div>
					 		 <h3>我要评论</h3><br/>
					 		<form action="addComment.action" method="post" onsubmit="return check()">
					 		 <input type="hidden" name="comment.luser.UId" value="${loginUser.UId}" id="mnu"/>
					 		 选择酒店:&nbsp;<SELECT class=text  name="comment.hotel.HId" id="com" onclick="mouseOver()">
                            <OPTION selected value="-1" >请选择酒店</OPTION>
                            <s:iterator var="hote" value="#session.hoteList">
                              <OPTION selected value="<s:property value="#hote.HId"/>"><s:property value="#hote.HName"/></OPTION>
                            </s:iterator>
                            </SELECT> <br/><br/>
					 		 酒店评分:&nbsp;
					 		       <select class=text name="comment.CScore" id="comm">
					 		       <OPTION selected value="-1" >请选择酒店评分</OPTION>
					 		       <OPTION  value="5">5</OPTION>
					 		       <OPTION  value="6">6</OPTION>
					 		       <OPTION  value="7">7</OPTION>
					 		       <OPTION  value="8">8</OPTION>
					 		       <OPTION  value="9">9</OPTION>
					 		       <OPTION  value="10">10</OPTION>
					 		      </select>
					 		 <br/><br/>
					 		 评论内容:&nbsp;<textarea type="text" name="comment.CContent" cols="20" rows="3" id="come" placeholder="在这里输入内容"></textarea><br/><br/>
					 		 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					 		 <input type="submit" value="提交评论"/>
					 		</form>
						</div>
						
						 
						<div class="clear"> </div>
						
					</div><br/><br/>
					<!-----End--services------>
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

