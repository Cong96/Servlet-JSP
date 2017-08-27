<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script language="JavaScript"> 
function update(){ 
	if(window.document.userLoginForm.newPassWord.value != window.document.userLoginForm.againPassWord.value) 
	{ alert("两次密码输入不一致，请重新输入"); return false; } 
	else
		{
	window.document.userLoginForm.action="ModifyPassServlet"; 
	window.document.userLoginForm.submit();
		}
		} 
	
	</script> 
<body bgcolor="pink" topmargin="160">
<!--
	function back() {
		window.document.userLoginForm.action="./module.do?method=Find"; 
		window.document.userLoginForm.submit(); }
	-->
<form id="userLoginForm" name="userLoginForm" method="post">
 <table width="300" align="center" border="1"> 
 <tr> <td width="35%">原始密码：</td>   <td> <input type="password" name="oldPassWord"><font color="#FF0000">*</font></td> </tr> 
 <tr> <td width="35%">新密码：  </td> <td>  <input type="password" name="newPassword"><font color="#FF0000">*</font></td> </tr> 
 <tr> <td width="35%">验证新密码：</td><td><input type="password" name="againPassWord"><font color="#FF0000">*</font></td> </tr> 

 
  <tr> <td>         <input type="button" value="修  改" onclick="update()">    </td>      </tr> 
 </table>
 </form>
</body>
</html>