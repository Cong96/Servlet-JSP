<%@page import="com.meng.model.*,com.meng.bean.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor="pink" topmargin="160">
<%
	int id=(Integer)session.getAttribute("id");
String password=(String)session.getAttribute("password");
StudentDao sbd=new StudentDao();
StudentBean sb=sbd.getSingleInfo(id);
%>

<table align="center" border="1">
<tr align="center" height="20"><td>学生ID</td><td><%=sb.getId() %></td></tr>
<tr align="center" height="20"><td>学生姓名</td><td><%=sb.getName() %></td></tr>
<tr align="center" height="20"><td>学生密码</td><td><%=sb.getPassword() %></td></tr>
<tr align="center" height="20"><td>学生性别</td><td><%=sb.getSex() %></td></tr>
<tr align="center" height="20"><td>学生生日</td><td><%=sb.getBirthday() %></td></tr>
<tr align="center" height="20"><td>学生院系</td><td><%=sb.getDepartment() %></td></tr>
<tr align="center" height="20"><td>学生班级</td><td><%=sb.getStuclass() %></td></tr>
<tr align="center" height="20"><td>学生专业</td><td><%=sb.getMajor() %></td></tr>
<tr align="center" height="20"><td>学生籍贯</td><td><%=sb.getOrigin() %></td></tr>
<tr><td align="center"><a href="testmodify.jsp">修改密码</a></td></tr>
</table>






</body>
</html>