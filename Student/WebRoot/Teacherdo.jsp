<%@page import="java.util.ArrayList"%>
<%@page import="com.meng.model.AdmintoCouDao,com.meng.bean.*"%>
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
AdmintoCouDao acd=new AdmintoCouDao();
ArrayList<CourseBean> al=acd.FindAllCourse();
//在这里通过的到tea_id，我们可以得到老师相应的课程，然后我们可以在jsp页面中让教师用户选择下拉框中的课程，再将其课程放入超链接的参数中
//传入下一个页面中
%>
<form action="TeacherdoServlet" method="post" >
<table align="center" border="1">
<!--该行写入一个下拉框，得到到底选择哪种课程。 -->
<tr><td><span>&nbsp;&nbsp;&nbsp;&nbsp;课程名:</span></td>
                            <td>
                                <select id="course_id" name="course_id">
                                    <option value="请选择课程" selected="">请选择课程</option>
                                <% for(CourseBean cb:al) { %>
                                   <option value=<%=cb.getCid() %>><%=cb.getCname() %></option>
                                                           <% } %>            
                                </select>  </td>   </tr>
                                <tr><td colspan="2"><input type="button" name="button1" value="查看分数"></td></tr>
<tr ><td colspan="2"><input type="button" name="button2" value="录入分数"></td></tr>
</table>
</form>
</body>
</html>