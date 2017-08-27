<%@ page language="java" import="java.util.*,com.meng.model.*,com.meng.bean.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor="pink" topmargin="160">
<%
int id=Integer.parseInt(request.getParameter("id"));
StudentDao std=new StudentDao();
StudentBean sb=std.getSingleInfo(id);
%>
<form action="AdmintoStuServlet?type=update" method="post">
<table align="center" border="1" >
<tr align="center" height="50"><td colspan="2">您确定要更改id为<%=id %>的老师信息么</td></tr>
<tr>
<td><input type="hidden" name="id" value="<%=id%>"/></td></tr>

<tr align="center" height="20"><td>学生姓名</td><td><input type="text" name="sname" value="<%=sb.getName()%>"/></td></tr>
<tr align="center" height="20"><td>学生密码</td><td><input type="text" name="spass" value="<%=sb.getPassword() %>" /></td></tr>
<tr align="center" height="20"><td>学生性别</td><td><input type="text" name="ssex" value="<%=sb.getSex() %>" /></td></tr>
<tr align="center" height="20"><td>学生生日</td><td><input type="text" name="sbirth"value="<%=sb.getBirthday() %>"/></td></tr>
<tr align="center" height="20"><td>学生院系</td><td><input type="text" name="sdep"value="<%=sb.getDepartment() %>"/></td></tr>
<tr align="center" height="20"><td>学生班级</td><td><input type="text" name="sclass"value="<%=sb.getStuclass() %>"/></td></tr>
<tr align="center" height="20"><td>学生专业</td><td><input type="text" name="smajor" value="<%=sb.getMajor() %>"/></td></tr>
<tr align="center" height="20"><td>学生籍贯</td><td><input type="text" name="sorigin" value="<%=sb.getOrigin() %>"/></td></tr>
<tr>
<td colspan="2">
<input type="submit" name="button" id="button6" value="更改信息" >
</td>
</tr>
</table>
</form>


</body>
</html>