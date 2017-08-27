<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body topmargin="170px" bgcolor="pink">
<%
String avgscore=(String) request.getAttribute("avgscore");
//int avgscore=Integer.parseInt(avgscorestr);
String coursename=(String) request.getAttribute("coursename");
String maxid=(String) request.getAttribute("maxid");
String maxscore=(String) request.getAttribute("maxscore");
String minid=(String) request.getAttribute("minid");
String minscore=(String) request.getAttribute("minscore");
%>
<table  width="60%" border="1" align="center" top>

<th colspan="6" align="center" height="50">课程详情表</th>
<tr height="50"  align="center"><td >课程名</td><td >平均分</td><td >最高分</td><td>学号</td><td>最低分</td><td>学号</td></tr>
<tr height="50" align="center"><td><%=coursename %></td><td><%=avgscore %></td><td><%=maxscore %></td><td><%=maxid %></td><td><%=minscore %></td><td><%=minid %></td></tr>
<tr height="50" align="center"><td colspan="3" align="center"><a href=" ">继续查询</a><td colspan="3" align="center"><a href=" ">返回上一层</a></td></tr>
</table>
</body>
</html>