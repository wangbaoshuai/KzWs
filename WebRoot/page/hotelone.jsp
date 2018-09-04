<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 3.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

 <!--  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 5.01 Transitional//EN">
 -->
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'hotelone.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="css/style.css" rel="stylesheet" type="text/css"  media="all" />
	<link rel="stylesheet" href="css/responsiveslides.css">
	<script src="js/jquery-1.8.3.min.js"></script>
	<script src="js/responsiveslides.min.js"></script>
	<script language="javascript" src="js/jquery.js"></script>
	<script src="js/jquery-1.9.0.min.js"></script>
	 <script type="text/javascript">
	 // You can also use "$(window).load(function() {"
	$(function () {
	 // Slideshow 1
		$("#sliderq1").responsiveSlides({
	  maxwidth: 1600,
	    speed: 600
			    });
			});
	//滚动
	</script>
<script type="text/javascript">
function move(){
	var daobj=document.getElementById("dadiv");
	var xiaobj=document.getElementById("xiao1div");
	daobj.scrollTop++;
	if(daobj.scrollTop>xiaobj.offsetHeight)
	daobj.scrollTop=0;
	}
	var temp_inter=setInterval("move()",10);
	function moveStop(){
		clearInterval(temp_inter);
		}
	function moveStart(){
		temp_inter=setInterval("move()",10);
		}	
    </script>
    <script type="text/javascript">
	function mend(id){
	 location.href="findByHcityHotel.action?hcity.cityId="+id;
	
	}
	</script>
	<script type="text/javascript">
	function getroom(rid) {
		//alert("参数rtid=" + rid+"rt=${hotel.HId}");
		if (rid == "")
			return;
		$.ajax({
			type: "post",
			data: "rid="+ rid+"&hid="+${hotel.HId},
			url: "ajax/findRoomAjax.action",
			datatype: "html",
			success: function(resu) { 
				//alert("resu:" + resu);
					var rooms = eval("(" + resu + ")");
				var roomSele = document.getElementById("rom");//获取下拉框对象
				roomSele.options.length = 0;
				for (var i = 0; i < rooms.length; i++) {
					var room = rooms[i];
					var op = new Option(room.RTitle, room.RId);
					roomSele.options.add(op);
					}	
			},
			error: function() {
				alert("出错了");
		}
		});
		
	}
</script>
<script type="text/javascript">
 function mouseOver(){
   var obj=document.getElementById("mnu").value;
   var ojb=document.getElementById("nmu").value;
  if(obj==""){
     alert("尊敬的用户您好：您需要在右上方定位您目的地城市！")
   }
   if(ojb==""){
      if(confirm("系统检测到您没有登录,您将不能下单成功！是否要先登录？"))
	   location.href="page/login.jsp";
   }

 }
 </script>
 <script type="text/javascript">
 function checkn(){
  var h=document.getElementById("rtyp").value;
   if(h==-1){
	alert("请重新选择客房类型！");
	 return false;
    }else{
   
     return true;
     }
 }
  function checkn2(){
 var j=document.getElementById("rom").value;
   if(j==-1){
	 alert("请重新选择客房！");
	 return false;
   }else{
   
     return true;
     }
 }
 function checkName(){
   var reg=/^(?:(?!0000)[0-9]{4}-(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-8])|(?:0[13-9]|1[0-2])-(?:29|30)|(?:0[13578]|1[02])-31)|(?:[0-9]{2}(?:0[48]|[2468][048]|[13579][26])|(?:0[48]|[2468][048]|[13579][26])00)-02-29)$/;
   var fff=document.getElementById("odate").value;
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
   var hhh=document.getElementById("bdate").value;
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
   function checkyhn(){
			var getyhxm=document.getElementById("oname").value;
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
   function checkphone(){
			var reg=/^1\d{10}$/;
			var phonestr=document.getElementById("otel").value;
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
       if(checkn()&&checkn2()&&checkName()&&checkName2()&&checkyhn()&&checkphone()&&chexk()){
        alert("您的订单填写正确！")
        alert("OK，您的订单即将提交。预订成功您将获得20积分！")
			return true;
		
    }else{
      return false;
    }
    
     }
		
</script>

   <style type="text/css">
   	 .book_class{
	clear:both;
	margin:0px 5px 0px 5px;
	}
		  
		 #dadiv{ width:350px; height:268px; border:solid 0px #900; overflow:hidden}
		 #express li{
	height:25px;
	border-bottom:dashed 1px #999;
	margin:0px 5px 0px 5px;
	line-height:28px;
	font-size: 16px; color: #900; 
	}
   </style>
   
	</head>
	<body>
		<!---start-Wrap--->
			<!---start-header--->
			<div class="header">
				<div class="wrap">
					<div class="header-top">
						<div class="logo">
							<a href="page/hotelone.jsp"><img src="images/logo2.png" title="logo" /></a>
						</div>
						<div class="contact-info">
							<p class="phone">服务热线: <a href="#">800-020-12345</a></p>
							<p class="gpa">定位城市 : <SELECT class=text name="hotel.hcity.cityId" onchange="mend(this.value)">
                             <OPTION selected value="-1">-请选择城市-</OPTION>
                                <s:iterator var="hcity" value="#session.hcityList">
                           <OPTION  value="<s:property value="#hcity.cityId"/>"><s:property value="#hcity.cityName"/></OPTION>
                              </s:iterator>
                           </SELECT></p>
                           <p class="phone1"><a href="page/login.jsp">登录</a> &nbsp;&nbsp;&nbsp;
                           <a href="page/register.jsp">注册</a>&nbsp;&nbsp; </p>
						</div>
						<div class="clear"> </div>
					</div>
				</div>
				<div class="header-top-nav">
					<div class="wrap">
						<ul>
							<li><a href="findByPageHotel.action?nowpage=1">订房中心</a></li>
							<li><a href="findByPageRoom.action?nowpage=1">客房中心</a></li>
							<li><a href="findByPageMenu.action?nowpage=1">菜系中心</a></li>
							<li><a href="findNew.action?nowpage=1">新闻中心</a></li>
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
			<!--start-image-slider---->
					<div class="image-slider" >
						<!-- Slideshow 1 -->
						    <ul class="rslides" id="sliderq1">
						      <li><img src="images/slider3.jpg" alt=""></li>
						      <li><img src="images/slider1.jpg" alt=""></li>
						      <li><img src="images/slider3.jpg" alt=""></li>
						    </ul>
						 <!-- Slideshow 2 -->
					</div>
					<!--End-image-slider---->
			<!---start-content----->
			<div class="content">
				
					<div class="content-grids">
						<div class="wrap">
						<div class="content-grid" >
							<div class="content-grid-pic">
								<a href="findByPageMenu.action?nowpage=1"><img src="images/sliderq.jpg" title="image-name" width="180px" heiget="200px"/></a>
							</div>
							<div class="content-grid-info">
								<h3>特色菜系应有尽有</h3>
								<p>我们这里汇集了全国各种有名的特色菜系，包括各种以辣为主的川菜，重庆火锅，山西面食，鲁菜，徽菜等等，来到我们酒店您将享受到我们对您的特殊招待。在这里您可以随心所欲的点您爱吃的美味佳肴。</p>
								<a href="findByPageMenu.action?nowpage=1">Read More</a>
							</div>
							<div class="clear"> </div>
						</div>
						<div class="content-grid">
							<div class="content-grid-pic">
								<a href="findByPageHotel.action?nowpage=1"><img src="images/sll.jpg" title="image-name" width="180px" heiget="200px" /></a>
							</div>
							<div class="content-grid-info">
								<h3>24小时在线预订</h3>
								<p>我们的酒店将会一天24小时为您提供服务，您可以通过我们的预订热线或者是我们的官网来进行您的需求服务，无论您身在何处，只要您告知我们的您的需求，我们将会在第一时间为您提供最好的服务。</p>
								<a href="findByPageHotel.action?nowpage=1">Read More</a>
							</div>
							<div class="clear"> </div>
						</div>
						<div class="content-grid">
							<div class="content-grid-pic">
								<a href="findByPageRoom.action?nowpage=1"><img src="images/ser_pic3.jpg" title="image-name" width="180px" heiget="200px"/></a>
							</div>
							<div class="content-grid-info">
								<h3>最好的客房服务</h3>
								<p>在世界各大国际机场和各大城市的中心地带、金融商务区，都可以看到希尔顿酒店的身影。而无论在哪里的希尔顿酒店都会让顾客有“似曾相识”的感觉，比如房间的设置都会被划分为办公区、放松区和盥洗区等。 </p>
								<a href="findByPageRoom.action?nowpage=1">Read More</a>
							</div>
							<div class="clear"> </div>
						</div>
						
						<div class="clear"> </div>
					</div>
				</div>
				<div class="clear"> </div>
				<div class="content-box" style="background-color:#0FF;border-color:#900;">
					<div class="wrap">
					<div class="content-box-left">
						<div class="content-box-left-topgrid">
							<h3 style="color:#FF0;">客房预订快捷通道</h3>
					<form action="addOrder.action" method="post"  onsubmit="return checkall()" >
					<input type="hidden" id="nmu" value="${loginUser.UId}" name="order.luser.UId"/>
					<input type="hidden" id="mnu" name="mn" value="${hotel.HId}" readonly="readonly">
					       客房类型 :<SELECT class=text name="rid" id="rtyp" onchange="getroom(this.value)" onmouseover="mouseOver()" onblur="checkn()" style="width:130px;">
                             <OPTION  value="-1">----请选择客房类型---</OPTION>
                          <s:iterator var="rty" value="#session.rtypeList">
                             <OPTION  value="<s:property value="#rty.rtId"/>"><s:property value="#rty.trName"/></OPTION>
                          </s:iterator>
                            </SELECT>
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;
					      客房主题:<SELECT class=text id="rom" name="order.room.RId" onblur="checkn2()" style="width:130px;">
                            <OPTION selected value="-1">---请 选 择 客 房---</OPTION>
                            </SELECT> <br/><br/>
                                 
					      入住日期:<input type="text"  name="order.ODate" placeholder="2017-01-01" id="odate" onblur="checkName()" size="18px"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					          
					      退房日期:<input type="text"  name="order.BDate" placeholder="2017-01-01" id="bdate" onblur="checkName2()" size="18px"/><br/><br/>
					      入住姓名:<input type="text" name="order.OName" placeholder="请输入入住人姓名" id="oname" onblur="checkyhn()" size="18px"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					      联系电话:<input type="text" name="order.OTelphone" placeholder="请输入本人11位手机号码" id="otel" onblur="checkphone()" size="18px"/>&nbsp;&nbsp;
							<input type="checkbox" id="tiaokuan">我接受<a href="page/intruduce.jsp" >《酒店客房预订须知》</a>
							<input type="submit" value="确认预订" />
							       
				</form>
							<span style="color:#FF0;">您的心满意足，是我们不懈的追求！</span>
						</div>
						<div class="content-box-left-bootomgrids">
							<div class="content-box-left-bootomgrid">
								<h3 style="color:#F0F;">总统套房</h3>
								<p>以“总统”冠名，总让人在顶级奢华享受的同时，还能显现出高贵、威严、神秘。对住客而言，入住总统房，只要客人愿意出几千元甚至数万元一晚的房费，就是平民百姓也照样享受“总统级”的待遇。</p>
								<a href="findByPageRoom.action?nowpage=1"><img src="images/timg.jpg" title="image-name" width="300"height="150"/></a>
							</div>
							<div class="content-box-left-bootomgrid">
								<h3 style="color:#F0F;">商务客房</h3>
								<p>商务客房是专门为商务人士配备的房间，一切皆为领导服务，客房中都有一些专门的办公设备、宽带接口、专门的浴室等等,商业人士可以随时随地办公，而且客房奢华、大气、舒适，绝对是商业精英的首选。</p>
								<a href="findByPageRoom.action?nowpage=1"><img src="images/timk.jpg" title="image-name" width="300"height="150"/></a>
							</div>
							<div class="content-box-left-bootomgrid lastgrid">
								<h3 style="color:#F0F;">情侣套房</h3>
								<p>以“爱情”为主题的客房。在这里，一切皆为爱情服务，体会初恋的悸动，感悟爱情的坚定，感受最终的幸福！
浪漫，是香闺围笼里的暧昧，是灯火迷离，泪眼婆裟的唯美，是杨柳岸、晓风残月中的无语凝噎……</p>
								<a href="findByPageRoom.action?nowpage=1"><img src="images/timf.jpg" title="image-name" width="300"height="150"/></a>
							</div>
							<div class="clear"> </div>
						</div>
						<div class="clear"> </div>
					</div>
					<div class="content-box-right">
						<div class="content-box-right-topgrid">
							<h3 style="color:#FF0;">酒店信息 </h3>
							<a href="findByPageHotel.action?nowpage=1"><img src="hotel_images/<s:property value="#session.hotel.HImage"/>" width="400" height="150" title="imnage-name" /></a>
							<h4><s:property value="#session.hotel.HName"/>&nbsp;&nbsp;<a><img src="images/gif-0257.gif" alt="" ><img src="images/gif-0257.gif" alt="" ><img src="images/gif-0257.gif" alt="" ><img src="images/gif-0257.gif" alt="" ><img src="images/gif-0257.gif" alt="" ><img src="images/gif-0257.gif" alt="" ><img src="images/gif-0257.gif" alt="" ><img src="images/gif-0257.gif" alt="" >
							</a></h4>
							<p><s:property value="#session.hotel.HContent"/></p>
							<p>预订热线：<s:property value="#session.hotel.HTelephone"/>
							<a href="findByPageHotel.action?nowpage=1">查看详情</a>
						</div>
						<div class="content-box-right-bottomgrid">
							<h3 style="color:#FF0;">酒店最新新闻</h3>
							<div id="dadiv"  onmouseover="moveStop()" onmouseout="moveStart()">
					<div class="book_class" id="xiao1div">
					<ul id="express">
					<c:forEach var="news" items="${newsList}">
					<li><a href="findNew.action?nowpage=1">
						<c:if test="${news.NContent.length() >= 12 }">${news.NContent.substring(0,12)}...</c:if>
						<c:if test="${news.NContent.length() <12 }">${news.NContent}</c:if>
						</a>
					</li>
					</c:forEach>
					</ul>
				    </div>
					<div class="book_class" id="xiao2div">
					<ul id="express">
					<c:forEach var="news" items="${newsList}">
						<li><a href="findNew.action?nowpage=1">
						<c:if test="${news.NContent.length() >= 12 }">${news.NContent.substring(0,12)}...</c:if>
						<c:if test="${news.NContent.length() <12 }">${news.NContent}</c:if>
						</a>
					</li>
					</c:forEach>
					</ul>
					</div>
				</div>
						</div>
					</div>
					<div class="clear"> </div>
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

	