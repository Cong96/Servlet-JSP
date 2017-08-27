package com.meng.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.meng.bean.CourseBean;
import com.meng.bean.ScoreBean;

/**
 * 
 * 项目名称：StuInfoManage 类名称：TeacherDao 类描述： 老师对学生的操作。 创建人:wangcc 创建时间：2016-8-3
 * 下午12:01:05 修改备注：
 * 
 * @version
 * 
 */

public class TeacherDao {
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	private Connection conn = null;
	private String sql = null;

	public CourseBean GetCourseInfo(int courseid) {
		CourseBean cb = new CourseBean();
		try {
			sql = "select * from course_wangcc where course_name=?";
			conn = DbHelper.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, courseid);
			rs = ps.executeQuery();
			while (rs.next()) {
				cb.setCid(rs.getInt(1));
				cb.setCname(rs.getString(2));
				cb.setTid(rs.getInt(3));
				cb.setTname(rs.getString(4));
			}
		} catch (Exception e) {
		} finally {
			this.close();
		}
		return cb;

	}

	//
	// /**
	// * @Title: GetTableName
	// * @Description: TODO(通过查询match表课程名得到对应的课程分数记录表)
	// * @param coursename
	// * @return String 返回类型
	// * @throws
	// */
	//
	// public String GetTableName(String CourseName) {
	// String str = null;
	// try {
	// sql = "select c_tablename from course_wangcc where course_name=?";
	// conn = DbHelper.getConnection();
	// ps = conn.prepareStatement(sql);
	// ps.setString(1, CourseName);
	// rs = ps.executeQuery();
	// while (rs.next()) {
	// str = rs.getString(1);
	// }
	//
	// } catch (Exception e) {
	//
	// } finally {
	// this.close();
	// }
	// return str;
	// }

	/**
	 * @Title: QueryMaxScore
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param courseid
	 * @param @return 设定文件
	 * @return ArrayList<Integer> 返回类型
	 * @throws
	 */
	public ArrayList<Integer> QueryMaxScore(int courseid) {
		ArrayList<Integer> al = new ArrayList<Integer>();

		try {
			sql = "select max(stu_score),stu_id from  score_wangcc where course_id=?";
			conn = DbHelper.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, courseid);
			rs = ps.executeQuery();
			while (rs.next()) {
				int max = rs.getInt(1);
				al.add(max);
				int id = rs.getInt(2);
				al.add(id);
			}
		} catch (Exception e) {
		} finally {
			this.close();
		}

		return al;

	}

	/**
	 * @Title: QueryMinScore
	 * @Description: TODO(查询最低分以及学号)
	 * @param CourseName
	 * @param tablename
	 * @return ArrayList<Integer> 返回类型
	 * @throws
	 */

	public ArrayList<Integer> QueryMinScore(int courseid) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		try {
			sql = "select min(stu_score),stu_id from  scroe_wangcc  where course_id=?";
			conn = DbHelper.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, courseid);
			rs = ps.executeQuery();
			while (rs.next()) {
				int min = rs.getInt(1);
				al.add(min);
				int id = rs.getInt(2);
				al.add(id);
			}
		} catch (Exception e) {
		} finally {
			this.close();
		}

		return al;

	}

	/**
	 * @Title: QueryAvgScore
	 * @Description: TODO(查询平均分)
	 * @param CourseName
	 * @param tablename
	 * @return int 返回类型
	 * @throws
	 */

	public int QueryAvgScore(int courseid) {
		int avg = 0;
		try {
			sql = "select avg(stu_score) from  score_wangcc where course_id=?";
			conn = DbHelper.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, courseid);
			rs = ps.executeQuery();
			while (rs.next()) {
				avg = rs.getInt(1);
			}
		} catch (Exception e) {
		} finally {
			this.close();
		}

		return avg;

	}

	/**
	 * @Title: updateScore
	 * @Description: TODO(录入分数)
	 * @param coursename
	 * @param stuid
	 * @param score
	 * @param tablename
	 * @return boolean 返回类型
	 * @throws
	 */

	public boolean updateScore(int stuid, int score, int courseid) {
		boolean flag = false;
		try {
			sql = "update score_wangcc set stu_score=? where course_id=? and stu_id=? ";
			conn = DbHelper.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, score);
			ps.setInt(2, courseid);
			ps.setInt(3, stuid);
			if (ps.executeUpdate() > 0) {
				flag = true;
			}
		} catch (Exception e) {
		} finally {

		}
		return flag;
	}

	public boolean InsertScore(ScoreBean sb) {
		boolean flag = false;
		try {
			sql = "insert into score_wangcc (stu_id,stu_name,stu_score,course_id,course_name) values(?,?,?,?,?)";
			conn = DbHelper.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, sb.getStuid());
			ps.setString(2, sb.getStuanme());
			ps.setInt(3, sb.getStuscore());
			ps.setInt(4, sb.getCourseid());
			ps.setString(5, sb.getCoursename());
			if (ps.executeUpdate() > 0)
				flag = true;
		} catch (Exception e) {

		} finally {

		}
		return flag;
	}

	public String GetCouNameById(int id) {
		String name = null;
		try {
			sql = "select course_name from course_wangcc where stu_id=? ";
			conn = DbHelper.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				name = rs.getString(1);

			}
		} catch (Exception e) {
		} finally {
			this.close();
		}
		return name;
	}

	/**
	 * @Title: close
	 * @Description: TODO(关闭资源) void 返回类型
	 * @throws
	 */

	public void close() {
		try {
			if (rs != null) {
				rs.close();
				rs = null;
			}
			if (ps != null) {
				ps.close();
				ps = null;
			}
			if (conn != null) {
				conn.close();
				conn = null;
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
