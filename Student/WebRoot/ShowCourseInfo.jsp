<%@ page language="java"  import="java.util.*,com.meng.model.*,com.meng.bean.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	//String name=(String)request.getAttribute("adminname");
int PageNow=1;
AdmintoCouDao asd=new AdmintoCouDao();
String str_PageNow=request.getParameter("j_pagenow");

if(str_PageNow!=null)
{
	PageNow=Integer.parseInt(str_PageNow);
}
int pageCount=asd.getPageCount();
ArrayList<CourseBean> al=asd.getCouInfoByPage(PageNow);
%>
<h1 align="center">课程信息表</h1>




<table align="center" border="1" width=300>
<tr><td>课程id</td><td>课程名</td><td>老师id</td><td>老师姓名</td><td>成绩表</td><td>&nbsp;&nbsp;</td><td>&nbsp;&nbsp;</td></tr>
<%
for(CourseBean sb:al)
{
	%>
	<tr><td><%=sb.getCid() %></td>
	<td><%=sb.getCname() %></td>
	<td><%=sb.getTid() %></td>
	<td><%=sb.getTid() %></td>
	<td><%=sb.getTablename() %></td>
	
	<td><a href="UpdateCouinfo.jsp?j_pagenow=<%=PageNow %>&id=<%=sb.getCid()%>">修改学生信息</a></td>
	<td><a href="DeleteCouinfo.jsp?j_pagenow=<%=PageNow %>&id=<%=sb.getCid()%>">删除学生信息</a></td></tr>

	<% 	
}

%>
<tr align="center" height="50"><td align="center" colspan="7"><a href="AddCou.jsp">增加课程信息</a></td></tr>

<tr>
    <td colspan="7" align="center">
	<% 
	if(PageNow==1)
	{

		for(int i=1;i<=pageCount;i++)
		{
			%><a href="ShowCourseInfo.jsp?j_pagenow=<%=i%>">【<%=i %>】</a>
			<%
		}
		%><a href="ShowCourseInfo.jsp?j_pagenow=<%=PageNow+1 %>">下一页</a><% 
	}
	else if(PageNow==pageCount)
	{
		%>
		<a href="ShowCourseInfo.jsp?j_pagenow=<%=PageNow-1 %>">上一页</a>
		<%
		for(int i=1;i<=pageCount;i++)
		{
			%>
			<a href="ShowCourseInfo.jsp?j_pagenow=<%=i %> ">【<%=i %>】</a>
			<% 
		}
			
		
	}
	else 
	{
		%><a href="ShowCourseInfo.jsp?j_pagenow=<%=PageNow-1 %>">上一页</a><% 
		for(int i=1;i<=pageCount;i++)
	{
			%>
		
		
		<a href="ShowCourseInfo.jsp?j_pagenow=<%=i %>">【<%=i %>】</a>
		
		<% 
	}
	%>	<a href="ShowCourseInfo.jsp?j_pagenow=<%=PageNow+1%>">下一页</a>
	<% 
	}
	
	
	%>
	
	</td>
	</tr>

</table>

</body>
</html>