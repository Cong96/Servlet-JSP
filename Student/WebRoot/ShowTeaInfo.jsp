<%@ page language="java" import="java.util.*,com.meng.model.*,com.meng.bean.*"  contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	
int PageNow=1;
AdmintoTeaDao atd=new AdmintoTeaDao();
String str_PageNow=request.getParameter("j_pagenow");
if(str_PageNow!=null)
{
	PageNow=Integer.parseInt(str_PageNow);	
}
int pageCount=atd.getPageCount();
ArrayList<TeacherBean> al=atd.getTeaInfoByPage(PageNow);
%>
<h1 align="center">教师信息表</h1>



<form action="AdmintoTeaServlet?type=update" method="post">
<table align="center" border="1">
<tr><td>老师ID</td><td>老师姓名</td><td>老师年龄</td><td>老师密码</td><td>&nbsp;&nbsp;</td><td>&nbsp;&nbsp;</td></tr>
<%
for(TeacherBean sb:al)
{
	%>
	<tr><td><%=sb.getId() %></td>
	<td><%=sb.getName() %></td>
	<td><%=sb.getAge() %></td>
	<td><%=sb.getPassword() %></td>
	
	<td><a href="UpdateTeainfo.jsp?id=<%=sb.getId()%>">修改老师信息</a></td>
	<td><a href="DeleteTeainfo.jsp?j_pagenow=<%=PageNow %>&id=<%=sb.getId()%>">删除老师信息</a></td></tr>

	<% 	
}

%>
<tr align="center" height="50"><td align="center" colspan="6"><a href="AddTea.jsp">增加老师信息</a></td></tr>

<tr>
    <td colspan="6" align="center">
	<% 
	if(PageNow==1)
	{

		for(int i=1;i<=pageCount;i++)
		{
			%><a href="ShowTeaInfo.jsp?j_pagenow=<%=i%>">【<%=i %>】</a>
			<%
		}
		%><a href="ShowTeaInfo.jsp?j_pagenow=<%=PageNow+1 %>">下一页</a><% 
	}
	else if(PageNow==pageCount)
	{
		%>
		<a href="ShowTeaInfo.jsp?j_pagenow=<%=PageNow-1 %>">上一页</a>
		<%
		for(int i=1;i<=pageCount;i++)
		{
			%>
			<a href="ShowTeaInfo.jsp?j_pagenow=<%=i %> ">【<%=i %>】</a>
			<% 
		}
			
		
	}
	else 
	{
		%><a href="ShowTeaInfo.jsp?j_pagenow=<%=PageNow-1 %>">上一页</a><% 
		for(int i=1;i<=pageCount;i++)
	{
			%>
		
		
		<a href="ShowTeaInfo.jsp?j_pagenow=<%=i %>">【<%=i %>】</a>
		
		<% 
	}
	%>	<a href="ShowTeaInfo.jsp?j_pagenow=<%=PageNow+1%>">下一页</a>
	<% 
	}
	
	
	%>
	
	</td>
	</tr>

</table>
</form>

</body>

</html>