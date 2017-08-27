<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor="pink" topmargin="160">
<%int id=Integer.parseInt(request.getParameter("id"));
	int PageNow=Integer.parseInt(request.getParameter("j_pagenow"));
	String type="del";
	
%>
<form action="AdmintoCouServlet" method="post">
<table align="center" border="1" >
<tr align="center" height="50"><td>您确定要删除id为<%=id %>的课程信息么</td></tr>
<tr>
<input type="hidden" name="id" value="<%=id%>"/>
<input type="hidden" name="dpagenow" value="<%=PageNow %>"/>
<input type="hidden" name="type" value="<%=type%>"/>
<td>
<input type="submit" name="button" id="button3" value="删除 信息" >
</td>
</tr>
</table>
</form>
</body>
</html>