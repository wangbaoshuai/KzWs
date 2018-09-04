<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <title>My JSP 'register.jsp' starting page</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1">
    <link type="text/css" rel="stylesheet" href="css/login.css">
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
function checkyhm(loginname){
		
			var tsobj=document.getElementById("errorloginname");
			var getyhm=document.getElementById("loginname").value;
			var firstchar=getyhm.charAt(0);
			var firstreg=/^\d?$/;
		if(getyhm==""){
			tsobj.className="cw";
			tsobj.innerHTML="不能为空";
			return false;
			}
		if(firstreg.test(firstchar)){
			tsobj.className="cw";
			tsobj.innerHTML="首字母不能为数字";
			return false;
			}
		var reg=/^\w+$/;
		if(!reg.test(getyhm)){
			tsobj.className="cw";
			tsobj.innerHTML="只能包含数字、字母、下划线";
			return false;
			}
		if(getyhm.length>16||getyhm.length<4){
				tsobj.className="cw";
				tsobj.innerHTML="用户名为4-16字符";
				return false;
		}else{
			$.ajax({
				type : "post",
				data : "user.ULoginname=" +loginname,
				url : "addAjaxUser.action",
				datatype : "html",
				success : function(resu) {
					if(resu=="该姓名已经存在，请重新填写"){
						tsobj.innerHTML="该姓名已经存在，请重新填写";
						tsobj.className="cw";
					}
					else{
						tsobj.innerHTML="输入正确";
						tsobj.className="cg";
					}
				},
				error : function() {
					alert("错误")
				}
				});	
				if(tsobj.innerHTML=="该姓名已经存在，请重新填写"){
					return false;
				}else{
					return true;
				}
			}  
	}
	function checkemail(){
			var tsobj = document.getElementById("erroremail");
			var emailstr = document.getElementById("email").value;
			var filter  = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
 			if (filter.test(emailstr)) {
 				tsobj.innerHTML = "格式正确";
 				tsobj.className = "cg";
 				return true;
 			}
 			else {
 				tsobj.className="cw";
 				tsobj.innerHTML = "输入的邮箱格式错误";
 				return false;
 			}
		}
		
		function checkpwd(){
			var tsobj=document.getElementById("errorpass");
			var pwdstr=document.getElementById("loginpass").value;
			if(pwdstr.length>16||pwdstr.length<6){
				tsobj.className="cw";
				tsobj.innerHTML="密码长度为6-16位";
				return false;
			}else{
				tsobj.innerHTML="输入正确";
				tsobj.className="cg";
				return true;
			}
		}
		
		function checkrepass(){
			
			var tsobj=document.getElementById("error_repass");
			
			var pwdstr=document.getElementById("loginpwd").value;
		
			var pwdstr2=document.getElementById("loginpass").value;
			
			if(pwdstr!=pwdstr2){
				tsobj.innerHTML="密码不一致";
				return false;
			}else{
				var aa = pwdstr.toString();
				if(aa.length!=0){
				tsobj.innerHTML="输入正确";
				tsobj.className="cg";
					return true;
				}else{
					tsobj.className="cw";	
					tsobj.innerHTML="确认密码不能为空";
					return false;	
				}
			}
				
		}
		
		function checkphone(){
			var tsobj=document.getElementById("errorphone");
			var reg=/^1\d{10}$/;
			var phonestr=document.getElementById("tel").value;
			if(!reg.test(phonestr)){
				tsobj.className="cw";	
				tsobj.innerHTML="格式不对";
				return false;
			}
			else{
				tsobj.innerHTML="输入正确";
				tsobj.className="cg";
				return true;
			}
		}
		
		function checkpicture(){	
			var tsobj = document.getElementById("errorpicture");
			var picturestr = document.getElementById("picture").value;
			if(picturestr!=""){
				tsobj.className="cg";	
				tsobj.innerHTML="文件已选择";
				
				return true;
			}else{
				tsobj.className="cw";	
				tsobj.innerHTML="文件未选择";
				return false;
			}
		}
		function checktiaokuan(){
			var tsobj = document.getElementById("tiaokuan");
			if(document.getElementById("inlineCheckbox1").checked){
				tsobj.className="gx";
				tsobj.innerHTML = "已勾选";
				return true;
			}else{
				
				tsobj.className="wgx";
				tsobj.innerHTML = "未勾选，需要勾选";
				return false;
			}
		}
		function checkall(){
		var loginname = document.getElementById("loginname").value;
		if(checkpicture()&&checkpwd()&&checkemail()&&checkphone()&&checkyhm(loginname)&&checkrepass()&&checktiaokuan()){
				alert("恭喜您，注册成功！")
			document.addUser.action.submit;
			}
			else {
				alert("输入有错误");
			    return false;
			}
		}

</script>
</head>
<body class="login_bj" >

<div class="zhuce_body">
	<div class="logo"></div>
    <div class="zhuce_kong">
    	<div class="zc">
        	<div class="bj_bai">
            <h3>欢迎您注册成为我们的会员</h3>
       	  	  <form action="addUser.action"  method="post" enctype="multipart/form-data" method="post"   onsubmit="return checkall()">
       	  	    <input name="user.UIsadmin" value="0" type="hidden"/>
       	  	    <input name="user.UScore" value="100" type="hidden"/>
       	  	    <input name="user.UStatus" value="正常" type="hidden"/>
                <input name="user.ULoginname" type="password" class="kuang_txt phone" placeholder="用户名：由字母数字下划线组成" id="loginname" onblur="checkyhm(this.value)">
                <span class="form-message" id="errorloginname"></span>
                <input name="user.ULoginpass" type="password" class="kuang_txt possword" placeholder="密码：6-16位数字或字母组成" id="loginpass" onblur="checkpwd()">
                <span class="form-message" id="errorpass"></span>
                <input name="userPwd" type="text" class="kuang_txt possword" placeholder="确认密码：两次密码必须一致" id="loginpwd" onblur="checkrepass()">
                <span class="form-message" id="error_repass"></span><br/>
                &nbsp;&nbsp;&nbsp;&nbsp;
                <input name="user.USex" type="radio" value="男" checked="checked"/>男 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input name="user.USex" type="radio" value="女" />女<br/><br/>
                <input name="user.UTelephone" type="text" class="kuang_txt phone" placeholder="手机号：由11位数字组成,且使用的手机" id="tel" onblur="checkphone()">
                <span class="form-message" id="errorphone"></span>
                <input name="user.UAddress" type="text" class="kuang_txt email" placeholder="地址：比较详细的地址信息,至少包括省市信息">
                <input name="user.UIdcard" type="text" class="kuang_txt possword" placeholder="身份证号：第二代公民身份证号"><br/>
                <select name="user.UType">
               <option value="金领">金领</option>
               <option value="白领">白领</option>
               <option value="蓝领">蓝领</option>
               <option value="学生">学生</option>
               <option value="工程师">工程师</option>
               <option value="教师">教师</option>
               <option value="其他">其他</option>
               </select>
               <br/>
                <input name="user.UEmail" type="text" class="kuang_txt email" placeholder="邮箱：邮箱的格式要注意@符号" id="email" onblur="checkemail()">
                <span class="form-message" id="erroremail"></span>
                <input name="img" type="file" class="kuang_txt yanzm" placeholder="个人头像" onblur="checkpicture()" id="picture">
                <span class="form-message" id="errorpicture"></span>
                <div>
               		<input  type="checkbox" id="inlineCheckbox1" value="agree"  onchange="checktiaokuan()"><span>已阅读并同意<a href="page/intruduce2.jsp" target="_blank"><span class="lan">《用户注册使用协议》</span></a></span>
               <span id="tiaokuan" style="margin-top: 5px"> </span>
                </div><br/>
                <input name="注册" type="submit" class="btn_zhuce" value="注册">
                
                </form><br/>
                <a href="page/login.jsp" style="color:#71D6EA;">我已有账号，我要登录</a>
               <h2>${msg}</h2> 
            </div>
        	
        </div>
       
    </div>

</div>
    
<div style="text-align:center;color:#71D6EA;font-size:28px;">
<p><h1>腾龙大酒店注册中心</h1></p>
</div>

</body>
</html>