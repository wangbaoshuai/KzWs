<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 1.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'hotelmap.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<link href="css/zzsc.css" media="screen" rel="stylesheet" type="text/css">
  </head>
  
  <body>
  <!-- 代码 开始 -->
<div>
	<dl id="gmap">
		<dt><a id="title2" href="#nogo"></a></dt>
		<dd><a id="xj" title="新疆" href="findByPageHotel.action?nowpage=1" target="_blank">新疆</a></dd>	
		<dd><a id="xz" title="西藏" href="findByPageHotel.action?nowpage=1" target="_blank">西藏</a></dd>
		<dd><a id="qh" title="青海" href="findByPageHotel.action?nowpage=1" target="_blank">青海</a></dd>		
		<dd><a id="gs" title="甘肃" href="findByPageHotel.action?nowpage=1" target="_blank">甘肃</a></dd>
		<dd><a id="lmg" title="内蒙古" href="findByPageHotel.action?nowpage=1" target="_blank">内蒙古</a></dd>
		<dd><a id="hlj" title="黑龙江" href="findByPageHotel.action?nowpage=1" target="_blank">黑龙江</a></dd>	
		<dd><a id="jl" title="吉林" href="findByPageHotel.action?nowpage=1" target="_blank">吉林</a></dd>
		<dd><a id="ln" title="辽宁" href="findByPageHotel.action?nowpage=1" target="_blank">辽宁</a></dd>
		<dd><a id="sd" title="山东" href="findByPageHotel.action?nowpage=1" target="_blank">山东</a></dd>
		<dd><a id="hb" title="河北" href="findByPageHotel.action?nowpage=1" target="_blank">河北</a></dd>
		<dd><a id="sx" title="山西" href="findByPageHotel.action?nowpage=1" target="_blank">山西</a></dd>
		<dd><a id="bj" title="北京" href="findByPageHotel.action?nowpage=1" target="_blank">北京</a></dd>
		<dd><a id="tj" title="天津" href="findByPageHotel.action?nowpage=1" target="_blank">天津</a></dd>
		<dd><a id="shx" title="陕西" href="findByPageHotel.action?nowpage=1" target="_blank">陕西</a></dd>		
		<dd><a id="nx" title="宁夏" href="findByPageHotel.action?nowpage=1" target="_blank">宁夏</a></dd>	
		<dd><a id="hn" title="河南" href="findByPageHotel.action?nowpage=1" target="_blank">河南</a></dd>	
		<dd><a id="js" title="江苏" href="findByPageHotel.action?nowpage=1" target="_blank">江苏</a></dd>
		<dd><a id="ah" title="安徽" href="findByPageHotel.action?nowpage=1" target="_blank">安徽</a></dd>
		<dd><a id="sh" title="上海" href="findByPageHotel.action?nowpage=1" target="_blank">上海</a></dd>
		<dd><a id="zj" title="浙江" href="findByPageHotel.action?nowpage=1" target="_blank">浙江</a></dd>	
		<dd><a id="jx" title="江西" href="findByPageHotel.action?nowpage=1" target="_blank">江西</a></dd>
		<dd><a id="hj" title="福建" href="findByPageHotel.action?nowpage=1" target="_blank">福建</a></dd>
		<dd><a id="gd" title="广东" href="findByPageHotel.action?nowpage=1" target="_blank">广东</a></dd>
		<dd><a id="hl" title="海南" href="findByPageHotel.action?nowpage=1" target="_blank">海南</a></dd>
		<dd><a id="gx" title="广西" href="findByPageHotel.action?nowpage=1" target="_blank">广西</a></dd>	
		<dd><a id="gz" title="贵州" href="findByPageHotel.action?nowpage=1" target="_blank">贵州</a></dd>
		<dd><a id="yn" title="云南" href="findByPageHotel.action?nowpage=1" target="_blank">云南</a></dd>	
		<dd><a id="sc" title="四川" href="findByPageHotel.action?nowpage=1" target="_blank">四川</a></dd>
		<dd><a id="cq" title="重庆" href="findByPageHotel.action?nowpage=1" target="_blank">重庆</a></dd>
		<dd><a id="hun" title="湖南" href="findByPageHotel.action?nowpage=1" target="_blank">湖南</a></dd>		
		<dd><a id="hub" title="湖北" href="findByPageHotel.action?nowpage=1" target="_blank">湖北</a></dd>
		<dd><a id="tw" title="台湾" href="findByPageHotel.action?nowpage=1" target="_blank">台湾</a></dd>
		<!--<dd><a id="xg" title="香港" href="http://www.quickui.net/" target="_blank">香港</a></dd>
		<dd><a id="am" title="澳门" href="http://www.quickui.net/" target="_blank">澳门</a></dd>	
		-->		
	</dl>
</div>
<!-- 代码 结束 -->
<div style="text-align:center;margin:50px 0">
<div style="text-align:center;clear:both">
</div>
<p style="margin:20px 0"></p>
</div>
  </body>
</html>
