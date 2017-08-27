package com.meng.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meng.bean.ScoreBean;
import com.meng.model.AdmintoStuDao;
import com.meng.model.TeacherDao;

/**
 * Servlet implementation class InputScoreServlet
 */
@WebServlet("/InputScoreServlet")
public class InputScoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InputScoreServlet() {
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
		PrintWriter out = response.getWriter();
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		ScoreBean sb = new ScoreBean();
		// String stuname = request.getParameter("stu_name");
		int sid = Integer.parseInt(request.getParameter("stuid"));
		sb.setStuid(sid);
		String sname = new AdmintoStuDao().GetStuNameById(sid);
		sb.setStuanme(sname);
		// String CourseName = request.getParameter("course_name");
		int score = Integer.parseInt(request.getParameter("score"));
		sb.setStuscore(score);
		int cid = Integer.parseInt(request.getParameter("courseid"));
		sb.setCourseid(cid);
		TeacherDao icd = new TeacherDao();
		String coursename = icd.GetCouNameById(cid);
		sb.setCoursename(coursename);
		if (icd.InsertScore(sb)) {
			request.getRequestDispatcher("scoreSuccessful.jsp").forward(
					request, response);
		} else {
			request.getRequestDispatcher("scorefail.jsp").forward(request,
					response);
		}
	}
}
