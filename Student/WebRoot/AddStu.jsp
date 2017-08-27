<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor="pink" topmargin="160">

<form action="AdmintoStuServlet?type=add" method="post">
<table align="center" border="1">
<tr align="center" height="20"><td>学生ID</td><td><input name="id" type="text"  /></td></tr>
<tr align="center" height="20"><td>学生姓名</td><td><input name="name" type="text" /></td></tr>
<tr align="center" height="20"><td>学生密码</td><td><input name="password" type="text"  /></td></tr>
<tr align="center" height="20"><td>学生性别</td><td><input name="sex" type="text"  /></td></tr>
<tr align="center" height="20"><td>学生生日</td><td><input name="birth" type="text"  /></td></tr>
<tr align="center" height="20"><td>学生院系</td><td><input name="dep" type="text"  /></td></tr>
<tr align="center" height="20"><td>学生班级</td><td><input name="class" type="text"  /></td></tr>
<tr align="center" height="20"><td>学生专业</td><td><input name="major" type="text"  /></td></tr>
<tr align="center" height="20"><td>学生籍贯</td><td><input name="orgin" type="text"  /></td></tr>
<tr><td align="center"><input type="submit" value="确认添加"   name="button" > </td></tr>
</table>
</form>





</body>
</html>