package com.meng.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meng.bean.StudentBean;
import com.meng.model.AdmintoStuDao;

/**
 * Servlet implementation class AdmintoStuServlet
 */
@WebServlet("/AdmintoStuServlet")
public class AdmintoStuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdmintoStuServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		response.setContentType("Text/html");
		request.setCharacterEncoding("UTF-8");

		String type = request.getParameter("type");
		AdmintoStuDao asd = new AdmintoStuDao();
		System.out.println(type);
		if (type.equals("del")) {
			int id = Integer.parseInt(request.getParameter("id"));
			asd.DeleteStuInfo(id);
			int ddpagenow = Integer.parseInt(request.getParameter("dpagenow"));
			request.setAttribute("pagenow", ddpagenow);
			request.getRequestDispatcher("ShowStudentInfo.jsp").forward(
					request, response);

		} else if (type.equals("update")) {
			StudentBean sb = new StudentBean();
			int sid = Integer.parseInt(request.getParameter("id"));
			sb.setId(sid);
			sb.setName(request.getParameter("sname"));
			sb.setSex(request.getParameter("ssex"));
			sb.setPassword(request.getParameter("spass"));
			sb.setDepartment(request.getParameter("sdep"));
			sb.setMajor(request.getParameter("smajor"));
			sb.setBirthday(request.getParameter("sbirth"));
			sb.setStuclass(request.getParameter("sclass"));
			sb.setOrigin(request.getParameter("sorigin"));
			asd.UpdateStuInfo(sb);

			// }

			// int PageNow =
			// Integer.parseInt(request.getParameter("j_pagenow"));
			// System.out.println(PageNow);
			// request.setAttribute("p", PageNow);
			// request.setAttribute("pagenow", PageNow);
			// request.setAttribute("flag", "ok");
			// request.setAttribute("t", 1);
			request.getRequestDispatcher("ShowStudentInfo.jsp").forward(
					request, response);
		} else if (type.equals("add")) {
			StudentBean sb = new StudentBean();
			int sid = Integer.parseInt(request.getParameter("id"));
			sb.setId(sid);
			sb.setName(request.getParameter("name"));
			sb.setSex(request.getParameter("sex"));
			sb.setPassword(request.getParameter("pass"));
			sb.setDepartment(request.getParameter("dep"));
			sb.setMajor(request.getParameter("major"));
			sb.setBirthday(request.getParameter("birth"));
			sb.setStuclass(request.getParameter("class"));
			sb.setOrigin(request.getParameter("origin"));
			asd.InsertStuInfo(sb);
			request.getRequestDispatcher("ShowStudentInfo.jsp").forward(
					request, response);
		}
	}
}
