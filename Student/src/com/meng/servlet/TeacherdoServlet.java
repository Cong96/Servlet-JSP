package com.meng.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meng.bean.CourseBean;
import com.meng.model.TeacherDao;

@WebServlet("/TeacherdoServlet")
public class TeacherdoServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public TeacherdoServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		this.doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String str1 = request.getParameter("button1");
		String str2 = request.getParameter("button2");
		TeacherDao td = new TeacherDao();
		if (str1 == null && str2.equals("录入分数")) {
			int courseid = Integer.parseInt(request.getParameter("course_id"));
			request.setAttribute("courseid", courseid);
			request.getRequestDispatcher("InputScore.jsp").forward(request,
					response);
		} else if (str2 == null && str1.equals("查询课程")) {
			int courseid = Integer.parseInt(request.getParameter("course_id"));

			CourseBean cb = td.GetCourseInfo(courseid);

			request.setAttribute("courseinfo", cb);
			int AvgScore = td.QueryAvgScore(courseid);
			ArrayList<Integer> MaxScoreL = td.QueryMaxScore(courseid);
			ArrayList<Integer> MinScoreL = td.QueryMinScore(courseid);
			int maxscore = MaxScoreL.get(0);
			int maxid = MaxScoreL.get(1);
			int minscore = MinScoreL.get(0);
			int minid = MinScoreL.get(1);
			String coursename = td.GetCouNameById(courseid);
			request.setAttribute("coursename", coursename);
			request.setAttribute("maxscore", maxscore);
			request.setAttribute("maxid", maxid);
			request.setAttribute("minscore", minscore);
			request.setAttribute("minid", minid);
			request.setAttribute("avgscore", AvgScore);
			request.getRequestDispatcher("ShowCourseDetail.jsp").forward(
					request, response);
		} else {
			request.getRequestDispatcher("failed.jsp").forward(request,
					response);
		}
	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
