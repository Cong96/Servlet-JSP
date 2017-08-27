package com.meng.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.meng.bean.CourseBean;

public class AdmintoCouDao {
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	private Connection conn = null;
	private String sql = null;
	private String tablename;
	private int PageSize = 5;

	public String getTablename(String str) {
		String tablename = "stu_score_" + str;
		tablename = tablename + "_wangcc";
		return tablename;
	}

	/**
	 * @Title: getPageCount
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @return int 返回类型
	 * @throws
	 */

	public int getPageCount() {
		int PageCount = 0;
		int rowcount = 0;
		try {
			sql = "select count(*) from course_wangcc";
			conn = DbHelper.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				rowcount = rs.getInt(1);

			}

			if (rowcount % PageSize == 0) {
				PageCount = rowcount / PageSize;
			} else
				PageCount = (rowcount / PageSize) + 1;

		} catch (Exception e) {

		} finally {
			this.close();
		}

		return PageCount;
	}

	/*
	 * 得到每页的数据
	 */

	/**
	 * @Title: getUserInfoByPage
	 * @Description: TODO(分页返回学生信息)
	 * @param PageNow
	 * @return ArrayList<StudentBean> 返回类型
	 * @throws
	 */

	public ArrayList<CourseBean> getCouInfoByPage(int PageNow) {
		ArrayList<CourseBean> al = new ArrayList<CourseBean>();
		try {
			sql = "select * from(select * from  course_wangcc where c_id not in(select c_id from course_wangcc where rownum<=?))where rownum<=?";
			conn = DbHelper.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, (PageNow - 1) * PageSize);
			ps.setInt(2, PageSize);
			rs = ps.executeQuery();
			while (rs.next()) {
				CourseBean ub = new CourseBean();
				ub.setCid(rs.getInt(1));
				ub.setCname(rs.getString(2));
				ub.setTid(rs.getInt(3));
				ub.setTname(rs.getString(4));
				ub.setTablename(rs.getString(5));

				al.add(ub);

			}

		} catch (Exception e) {
		} finally {
			this.close();
		}
		return al;
	}

	/**
	 * @Title: InsertCourse
	 * @Description: TODO(增加新的课程)
	 * @param cid
	 * @param cname
	 * @param tid
	 * @param iname
	 * @param str
	 * @return boolean 返回类型
	 * @throws
	 */

	public boolean InsertCourse(CourseBean cb) {
		boolean flag = false;

		try {
			sql = "insert into course_wangcc (course_id,course_name,course_teaid,course_tea,c_tablename) values(?,?,?,?,?)";
			conn = DbHelper.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, cb.getCid());
			ps.setString(2, cb.getCname());
			ps.setInt(3, cb.getTid());
			ps.setString(4, cb.getTname());
			ps.setString(5, cb.getTablename());
			String tablename = cb.getTablename();
			if (ps.executeUpdate() > 0) {

				if (CreateCourse(tablename))
					flag = true;
			}
		} catch (Exception e) {

		} finally {
			this.close();
		}
		return flag;

	}

	/**
	 * @Title: CreateCourse
	 * @Description: TODO(为新课程创建一个相关的表)
	 * @param tablename
	 * @return boolean 返回类型
	 * @throws
	 */

	public boolean CreateCourse(String tablename) {
		boolean flag = false;

		try {
			sql = "create table "
					+ tablename
					+ " (stu_id number(5),stu_name varchar2(20),course_id number(10), tea_id number(4),course_name varchar2(20),stu_score number(3))";
			conn = DbHelper.getConnection();
			ps = conn.prepareStatement(sql);
			if (!ps.execute()) {
				flag = true;
			}
		} catch (Exception e) {
		} finally {
			this.close();
		}
		return flag;
	}

	// public String gettablename() {
	// return tablename;
	// }

	public CourseBean QueryCourse(int cid) {
		CourseBean cb = new CourseBean();
		try {
			sql = "select * from course_wangcc where course_id=?";
			conn = DbHelper.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, cid);
			rs = ps.executeQuery();
			while (rs.next()) {
				cb.setCid(rs.getInt(1));
				cb.setCname(rs.getString(2));
				cb.setTid(rs.getInt(3));
				cb.setTname(rs.getString(4));
				cb.setTablename(rs.getString(5));
			}

		} catch (Exception e) {
		} finally {
			this.close();
		}

		return cb;
	}

	public boolean UpdateCourse(CourseBean cb) {
		boolean flag = false;
		try {
			sql = " update  course_wangcc set course_id=?,course_name=?,course_teaid=?,course_tea=?,c_tablename where course_id=?";
			conn = DbHelper.getConnection();
			ps = conn.prepareStatement(sql);

			ps.setInt(1, cb.getCid());
			ps.setString(2, cb.getCname());
			ps.setInt(3, cb.getTid());
			ps.setString(4, cb.getTname());
			ps.setString(5, cb.getTablename());
			ps.setInt(6, cb.getCid());
			String tablename = cb.getTablename();
			if (ps.executeUpdate() > 0) {
				CreateCourse(tablename);
				flag = true;
			}
		} catch (Exception e) {
		} finally {
			this.close();
		}
		return flag;
	}

	/**
	 * @Title: DeleteCourse
	 * @Description: TODO(删除一个课程)
	 * @param cid
	 * @return boolean 返回类型
	 * @throws
	 */

	public boolean DeleteCourse(int cid) {
		boolean flag = false;
		try {
			sql = "delete from course_wangcc where course_id=?";
			conn = DbHelper.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, cid);
			if (!ps.execute()) {
				// String table = Querytablename(cid);
				// if (DeleteScoreTable(table)) {
				flag = true;

			}
		} catch (Exception e) {
		} finally {
			this.close();
		}
		return flag;
	}

	/**
	 * @Title: Querytablename
	 * @Description: TODO(查询到相应的成绩表)
	 * @param cid
	 * @return String 返回类型
	 * @throws
	 */

	public String Querytablename(int cid) {
		String str = null;
		try {
			sql = "select c_tablename from course_wangcc where course_id=?";
			conn = DbHelper.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, cid);
			rs = ps.executeQuery();
			while (rs.next()) {
				str = rs.getString(1);
			}
		} catch (Exception e) {
		} finally {
			this.close();
		}
		return str;

	}

	/**
	 * @Title: DeleteScoreTable
	 * @Description: TODO(删除成绩表)
	 * @param table
	 * @return boolean 返回类型
	 * @throws
	 */

	public boolean DeleteScoreTable(String table) {
		boolean flag = false;
		try {
			sql = "drop table " + table;
			conn = DbHelper.getConnection();
			ps = conn.prepareStatement(sql);
			if (!ps.execute()) {
				flag = true;
			}

		} catch (Exception e) {
		} finally {
			this.close();
		}
		return flag;
	}

	public boolean InsertCourseTest(CourseBean cb) {
		boolean flag = false;
		try {
			sql = "insert into course_wangcc(course_id,course_name,course_teaid,course_tea) values(?,?,?,?) ";
			conn = DbHelper.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, cb.getCid());
			ps.setString(2, cb.getCname());
			ps.setInt(3, cb.getTid());
			ps.setString(4, cb.getTname());
			if (ps.executeUpdate() > 0) {
				flag = true;
			}
		} catch (Exception e) {

		} finally {
			this.close();
		}
		return flag;
	}

	public boolean UpdateCourseTest(CourseBean cb) {
		boolean flag = false;
		try {
			sql = "update course_wangcc set course_id=?,course_name=?,course_teaid=?,course_tea=? where cousre_id=? ";
			conn = DbHelper.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, cb.getCid());
			ps.setString(2, cb.getCname());
			ps.setInt(3, cb.getTid());
			ps.setString(4, cb.getTname());
			ps.setInt(5, cb.getCid());
			if (ps.executeUpdate() > 0) {
				flag = true;
			}
		} catch (Exception e) {

		} finally {
			this.close();
		}
		return flag;
	}

	public boolean DeleteCourseTest(int cid) {
		boolean flag = false;
		try {
			sql = "delete from course_wangcc  where cousre_id=? ";
			conn = DbHelper.getConnection();
			ps = conn.prepareStatement(sql);

			if (ps.executeUpdate() > 0) {
				flag = true;
			}
		} catch (Exception e) {

		} finally {
			this.close();
		}
		return flag;
	}

	public ArrayList<CourseBean> FindAllCourse() {
		ArrayList<CourseBean> al = new ArrayList<CourseBean>();
		try {
			sql = "select * from course_wangcc ";
			conn = DbHelper.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				CourseBean cb = new CourseBean();
				cb.setCid(rs.getInt(1));
				cb.setCname(rs.getString(2));
				cb.setTid(rs.getInt(3));
				cb.setTname(rs.getString(4));
				al.add(cb);

			}

		} catch (Exception e) {
		} finally

		{
			this.close();
		}
		return al;
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
	 * @Description: TODO(关闭资源函数) void 返回类型
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
