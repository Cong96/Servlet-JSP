<%@ page language="java" import="java.util.*,com.meng.model.*,com.meng.bean.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="pink" topmargin="160">
<%
int id=Integer.parseInt(request.getParameter("id"));
AdmintoCouDao atd=new AdmintoCouDao();
CourseBean cb=atd.QueryCourse(id);
%>
<form action="AdmintoTeaServlet?type=update" method="post">
<table align="center" border="1" >
<tr align="center" height="50"><td colspan="2">您确定要更改id为<%=id %>的老师信息么</td></tr>
<tr>
<td><input type="hidden" name="id" value="<%=id%>"/></td></tr>
<tr align="center" height="20"><td>课程名</td><td><input type="text" name="ccname" value="<%=cb.getCname()%>"/></td></tr>
<tr align="center" height="20"><td>老师id</td><td><input type="text" name="ctid" value="<%=cb.getTid() %>"/></td></tr>
<tr align="center" height="20"><td>老师姓名</td><td><input type="text" name="ctname" value="<%=cb.getTname() %>"  /></td></tr>
<tr align="center" height="20"><td>成绩表</td><td><input type="text" name="ctablename" value="<%=cb.getTablename()%>"/></td></tr>
<tr>
<td colspan="2">
<input type="submit" name="button" id="button6" value="更改信息" >
</td>
</tr>
</table>
</form>


</body>
</html>