package com.meng.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class QueryStuServlet
 */
@WebServlet("/QueryStuServlet")
public class QueryStuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public QueryStuServlet() {
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
		this.doPost(request, response);
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
		// String CourseName = request.getParameter("course_name");
		// TeacherDao tead = new TeacherDao();
		// String tablename = tead.GetTableName(CourseName);
		// int AvgScore = tead.QueryAvgScore(CourseName, tablename);
		// ArrayList<Integer> MaxScoreL = tead
		// .QueryMaxScore(CourseName, tablename);
		// ArrayList<Integer> MinScoreL = tead
		// .QueryMinScore(CourseName, tablename);
		// int maxscore = MaxScoreL.get(0);
		// int maxid = MaxScoreL.get(1);
		// int minscore = MinScoreL.get(0);
		// int minid = MinScoreL.get(1);
		// request.setAttribute("coursename", CourseName);
		// request.setAttribute("maxscore", maxscore);
		// request.setAttribute("maxid", maxid);
		// request.setAttribute("minscore", minscore);
		// request.setAttribute("minid", minid);
		// request.setAttribute("avgscore", AvgScore);
		// request.getRequestDispatcher("ShowCourseDetail.jsp").forward(request,
		// response);

	}
}
