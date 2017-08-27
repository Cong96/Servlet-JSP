<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body topmargin="170px" bgcolor="pink">
<form action="CheckLoginServlet" method="post">
<table  width="40%" border="1" align="center" >
<th  align="center" height="50">管理员操作界面</th>
<tr height="50"  ><td align="center" >管理员&nbsp;${sessionScope.id}&nbsp;您好</td></tr>
<tr height="50"  ><td align="center" ><a href="ShowStudentInfo.jsp">学生操作</a></td></tr>
<tr height="50"  ><td align="center" ><a href="ShowTeaInfo.jsp">教师操作</a></td></tr>
<tr height="50"  ><td align="center" ><a href="ShowCourseInfo.jsp">课程操作</a></td></tr>
<tr height="50"  ><td align="center" ><a href="testmodify.jsp">修改密码</a></td></tr>
</table>
</form>
</body>
</html>