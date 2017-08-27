<%@page import="com.meng.model.AdmintoStuDao"%>

<%@ page language="java"  import="java.util.*,com.meng.model.*,com.meng.bean.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<%
	//String name=(String)request.getAttribute("adminname");
int PageNow=1;
AdmintoStuDao asd=new AdmintoStuDao();
String str_PageNow=request.getParameter("j_pagenow");
String flag=(String)request.getAttribute("flag");
if(flag!=null)
{
	PageNow=(Integer)request.getAttribute("pagenow");	
}
if(str_PageNow!=null)
{
	PageNow=Integer.parseInt(str_PageNow);
}
int pageCount=asd.getPageCount();
ArrayList<StudentBean> al=asd.getStuInfoByPage(PageNow);
%>
<h1>学生信息表</h1>




<table align="center" border="1" width=300>
<tr><td>学生id</td><td>学生姓名</td><td>学生密码</td><td>学生性别</td><td>学生生日</td><td>学院</td><td>班级</td><td>专业</td><td>籍贯</td><td>&nbsp;&nbsp;</td><td>&nbsp;&nbsp;</td></tr>
<%
for(StudentBean sb:al)
{
	%>
	<tr><td><%=sb.getId() %></td>
	<td><%=sb.getName() %></td>
	<td><%=sb.getPassword() %></td>
	<td><%=sb.getSex() %></td>
	<td><%=sb.getBirthday() %></td>
	<td><%=sb.getDepartment() %></td>
	<td><%=sb.getStuclass() %></td>
	<td><%=sb.getMajor() %></td>
	<td><%=sb.getOrigin() %></td>
	<td><a href="UpdateStuinfo.jsp?j_pagenow=<%=PageNow %>&id=<%=sb.getId()%>">修改学生信息</a></td>
	<td><a href="DeleteStuinfo.jsp?j_pagenow=<%=PageNow %>&id=<%=sb.getId()%>">删除学生信息</a></td></tr>

	<% 	
}

%>
<tr align="center" height="50"><td align="center" colspan="11"><a href="AddStu.jsp">增加学生信息</a></td></tr>

<tr>
    <td colspan="11" align="center">
	<% 
	if(PageNow==1)
	{

		for(int i=1;i<=pageCount;i++)
		{
			%><a href="ShowStudentInfo.jsp?j_pagenow=<%=i%>">【<%=i %>】</a>
			<%
		}
		%><a href="ShowStudentInfo.jsp?j_pagenow=<%=PageNow+1 %>">下一页</a><% 
	}
	else if(PageNow==pageCount)
	{
		%>
		<a href="ShowStudentInfo.jsp?j_pagenow=<%=PageNow-1 %>">上一页</a>
		<%
		for(int i=1;i<=pageCount;i++)
		{
			%>
			<a href="ShowStudentInfo.jsp?j_pagenow=<%=i %> ">【<%=i %>】</a>
			<% 
		}
			
		
	}
	else 
	{
		%><a href="ShowStudentInfo.jsp?j_pagenow=<%=PageNow-1 %>">上一页</a><% 
		for(int i=1;i<=pageCount;i++)
	{
			%>
		
		
		<a href="ShowStudentInfo.jsp?j_pagenow=<%=i %>">【<%=i %>】</a>
		
		<% 
	}
	%>	<a href="ShowStudentInfo.jsp?j_pagenow=<%=PageNow+1%>">下一页</a>
	<% 
	}
	
	
	%>
	
	</td>
	</tr>

</table>

</body>
</html>