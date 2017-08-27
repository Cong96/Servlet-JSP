package com.meng.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meng.model.LoginBo;

/**
 * Servlet implementation class CheckLoginServlet
 */
@WebServlet("/CheckLoginServlet")
public class CheckLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public CheckLoginServlet() {
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
		// PrintWriter out = response.getWriter();
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		String typestr = request.getParameter("type");

		int u = Integer.parseInt(request.getParameter("userid"));
		String p = request.getParameter("passwd");
		LoginBo lb = new LoginBo(typestr);
		int type = lb.gettype();
		System.out.println(type);
		if (lb.Checklogin(u, p)) {
			switch (type) {
			case 0:
				request.getSession().setAttribute("id", u);
				request.getSession().setAttribute("password", p);
				request.getSession().setAttribute("type", type);
				// request.getSession().setAttribute("typestr", typestr);
				request.getRequestDispatcher("showsingleStuinfo.jsp").forward(
						request, response);
				break;
			case 1:
				request.getSession().setAttribute("id", u);
				request.getSession().setAttribute("password", p);
				request.getSession().setAttribute("type", type);
				request.getRequestDispatcher("Teacherdo.jsp").forward(request,
						response);
				break;
			case 2:
				request.getSession().setAttribute("id", u);
				request.getSession().setAttribute("password", p);
				request.getSession().setAttribute("type", type);
				request.getRequestDispatcher("Admindo.jsp").forward(request,
						response);
				break;

			}
		}

		else {
			response.sendRedirect("index.jsp");
		}

	}
}
