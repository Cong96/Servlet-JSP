<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>

<body topmargin="170px" bgcolor="pink">

<form action="CheckLoginServlet" method="post">
<table  width="40%" border="1" align="center" >

<th colspan="2" align="center" height="50">学生信息管理系统</th>
<tr align="center" height="40">
<td><span>&nbsp;&nbsp;&nbsp;&nbsp;用户类型:</span></td>
                            <td>
                                <select id="type" name="type">
                                    <option value="学生" selected="">学生</option>
                                    <option value="管理员">管理员</option>
                                    <option value="老师">老师</option>
                                   
                                </select>
                            </td>    
	</tr>
<tr height="50"  ><td align="right" width="30%">登陆账号：</td><td align="center" width="70%"><input type="text" name="userid" id="userid" /></td></tr>
<tr height="50"  ><td align="right" width="30%">&nbsp;&nbsp;密码：</td><td align="center" width="70%"><input type="password"  name="passwd" id="passwd" /></td></tr>
 <tr>
        <td colspan="2" align="center">
         
            <input type="submit" name="button" id="button" width="20" value="登录" />
          
          &nbsp;&nbsp;&nbsp;
		<input type="submit" name="button2" id="button2" width="20" value="注册" />
</tr>
</table>
</form>
</body>
</html>ssssss