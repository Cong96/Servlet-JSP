package com.meng.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meng.bean.CourseBean;
import com.meng.model.AdmintoCouDao;

/**
 * Servlet implementation class AdmintoCouServlet
 */
@WebServlet("/AdmintoCouServlet")
public class AdmintoCouServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdmintoCouServlet() {
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
		AdmintoCouDao asd = new AdmintoCouDao();
		System.out.println(type);
		if (type.equals("del")) {
			int id = Integer.parseInt(request.getParameter("id"));
			asd.DeleteCourse(id);
			// int ddpagenow =
			// Integer.parseInt(request.getParameter("dpagenow"));
			// request.setAttribute("pagenow", ddpagenow);
			request.getRequestDispatcher("ShowCouInfo.jsp").forward(request,
					response);

		} else if (type.equals("update")) {
			CourseBean sb = new CourseBean();
			int sid = Integer.parseInt(request.getParameter("id"));
			sb.setCid(sid);
			sb.setCname(request.getParameter("ccname"));
			sb.setTid(Integer.parseInt(request.getParameter("ctid")));
			sb.setTname(request.getParameter("ctname"));
			// sb.setTablename(request.getParameter("ctablename"));

			// asd.UpdateCourse(sb);
			asd.UpdateCourseTest(sb);
			request.getRequestDispatcher("ShowCouInfo.jsp").forward(request,
					response);
		} else if (type.equals("add")) {
			CourseBean sb = new CourseBean();

			int sid = Integer.parseInt(request.getParameter("cid"));
			sb.setCid(sid);
			sb.setCname(request.getParameter("cname"));
			sb.setTid(Integer.parseInt(request.getParameter("ctid")));
			sb.setTname(request.getParameter("ctname"));
			// String tablename = asd.getTablename(request
			// .getParameter("ctablename"));
			// sb.setTablename(tablename);
			//
			// asd.InsertCourse(sb);
			asd.InsertCourseTest(sb);

			request.getRequestDispatcher("ShowCouInfo.jsp").forward(request,
					response);
		}
	}

}
