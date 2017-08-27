<%@page import="com.meng.model.TeacherDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor="pink" topmargin="160">
<% int courseid=(Integer)request.getAttribute("courseid"); %>
<form action="/InputScoreServlet" method="post" id="" name="">
<table align="center" border="1">

<tr ><%=new TeacherDao().GetCouNameById(courseid) %></tr>
<tr>学生id：<input type="text" name="stuid"/></tr>

<tr>分数：<input type="text" name="score"/></tr>
<tr><input type="hidden" name="courseid" value="<%=courseid%>"/></tr>
<!--<input onclick="delAll()" type="button" name="button" id="button" value="删除全部书籍" />
<link rel="stylesheet" type="text/css" href="css/my.css">
	<script type="text/javascript">
	<!-- 
		//响应删除全部书籍
		function delAll(){
			window.open("ShoppingClServlet?type=delAll","_self");
		}
	
	

	</script>


  -->
<tr><input type="submit" value="提交"/></tr>
<tr><a href="Teacherdo.jsp">返回上一层</a></tr>
</table>
</form>
</body>
</html>