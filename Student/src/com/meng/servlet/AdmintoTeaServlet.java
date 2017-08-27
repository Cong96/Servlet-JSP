package com.meng.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meng.bean.TeacherBean;
import com.meng.model.AdmintoTeaDao;

/**
 * Servlet implementation class AdmintoTeaServlet
 */
@WebServlet("/AdmintoTeaServlet")
public class AdmintoTeaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdmintoTeaServlet() {
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
		AdmintoTeaDao asd = new AdmintoTeaDao();
		System.out.println(type);
		if (type.equals("del")) {
			int id = Integer.parseInt(request.getParameter("id"));
			asd.DeleteTeaInfo(id);

			request.getRequestDispatcher("ShowTeaInfo.jsp").forward(request,
					response);

		} else if (type.equals("update")) {
			TeacherBean sb = new TeacherBean();
			int sid = Integer.parseInt(request.getParameter("id"));
			sb.setId(sid);
			sb.setName(request.getParameter("tname"));
			int sage = Integer.parseInt(request.getParameter("tage"));
			sb.setAge(sage);
			sb.setPassword(request.getParameter("tpass"));
			asd.UpdateTeaInfo(sb);

			request.getRequestDispatcher("ShowTeaInfo.jsp").forward(request,
					response);
		} else if (type.equals("add")) {
			TeacherBean sb = new TeacherBean();
			int sid = Integer.parseInt(request.getParameter("id"));
			sb.setId(sid);
			sb.setName(request.getParameter("name"));
			int sage = Integer.parseInt(request.getParameter("age"));
			sb.setAge(sage);
			sb.setPassword(request.getParameter("password"));

			asd.InsertTeaInfo(sb);

			request.getRequestDispatcher("ShowTeaInfo.jsp").forward(request,
					response);
		}
	}
}
