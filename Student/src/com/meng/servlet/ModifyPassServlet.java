package com.meng.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meng.model.LoginBo;

/**
 * Servlet implementation class ModifyPassServlet
 */
@WebServlet("/ModifyPassServlet")
public class ModifyPassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ModifyPassServlet() {
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
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		// String typestr = (String)
		// request.getSession().getAttribute("typestr");
		String oldpasswordinput = request.getParameter("oldpassword");
		String oldpassword = (String) request.getSession().getAttribute(
				"password");
		System.out.println("DB中德密码");
		System.out.println(oldpassword);
		System.out.println("jsp中的密码");
		System.out.println(oldpassword);
		int type = (Integer) request.getSession().getAttribute("type");
		System.out.println("类型");
		System.out.println(type);
		LoginBo lb = new LoginBo();
		if (oldpassword.equals(oldpasswordinput)) {
			String newpassword = request.getParameter("newPassword");
			int id = (Integer) request.getSession().getAttribute("id");
			System.out.println(newpassword);
			System.out.println(id);
			if (lb.ModifyPass(id, newpassword)) {

				switch (type) {
				case 0:
					response.sendRedirect("showsingleStuinfo.jsp");
					break;
				case 1:
					response.sendRedirect("Teacherdo.jsp");
					break;
				case 2:
					response.sendRedirect("Admindo.jsp");
					break;

				}

			}
		} else {
			response.sendRedirect("index.jsp");
		}

	}
}
