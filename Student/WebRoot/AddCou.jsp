<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="pink" topmargin="160">

<form action="AdmintoCouServlet?type=add" method="post">
<table align="center" border="1">
<tr align="center" height="20"><td>课程ID</td><td><input name="cid" type="text"  /></td></tr>
<tr align="center" height="20"><td>课程名</td><td><input name="cname" type="text" /></td></tr>
<tr align="center" height="20"><td>教师id</td><td><input name="ctid" type="text"  /></td></tr>
<tr align="center" height="20"><td>教师姓名</td><td><input name="ctname" type="text"  /></td></tr>
<tr align="center" height="20"><td>成绩表</td><td><input name="ctablename" type="text"  /></td></tr>

<tr><td align="center"><input type="submit" value="确认添加"   name="button" > </td></tr>
</table>
</form>





</body>
</html>