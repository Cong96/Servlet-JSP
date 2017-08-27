package com.meng.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.meng.bean.TeacherBean;

/**
 * 
 * 项目名称：StuInfoManage 类名称：AdmintoTeaDao 类描述： 管理员对教师的操作 创建人：wangcc 创建时间：2016-8-3
 * 下午1:46:40 修改备注：
 * 
 * @version
 * 
 */

public class AdmintoTeaDao {
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	private Connection conn = null;
	private String sql = null;
	private int PageSize = 5;

	public TeacherBean getSingleTeaInfo(int id) {

		TeacherBean ub = new TeacherBean();
		try {
			sql = "select * from teacher_wangcc where tea_id=? ";
			conn = DbHelper.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				ub.setId(rs.getInt(1));
				ub.setName(rs.getString(2));
				ub.setAge(rs.getInt(3));
				ub.setPassword(rs.getString(4));

			}
		} catch (Exception e) {
		} finally {
			this.close();
		}
		return ub;
	}

	/**
	 * @Title: getPageCount
	 * @Description: TODO(得到教师的页数)
	 * @return int 返回类型
	 * @throws
	 */

	public int getPageCount() {
		int PageCount = 0;
		int rowcount = 0;
		try {
			sql = "select count(*) from teacher_wangcc";
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

	/**
	 * @Title: getUserInfoByPage
	 * @Description: TODO(将教师信息分页显示)
	 * @param PageNow
	 * @return ArrayList<StudentBean> 返回类型
	 * @throws
	 */

	public ArrayList<TeacherBean> getTeaInfoByPage(int PageNow) {
		ArrayList<TeacherBean> al = new ArrayList<TeacherBean>();
		try {
			sql = "select * from(select * from  teacher_wangcc where tea_id not in(select tea_id from teacher_wangcc where rownum<=?))where rownum<=?";
			conn = DbHelper.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, (PageNow - 1) * PageSize);
			ps.setInt(2, PageSize);
			rs = ps.executeQuery();
			while (rs.next()) {
				TeacherBean ub = new TeacherBean();
				ub.setId(rs.getInt(1));
				ub.setName(rs.getString(2));
				ub.setAge(rs.getInt(3));
				ub.setPassword(rs.getString(4));

				al.add(ub);

			}

		} catch (Exception e) {
		} finally {
			this.close();
		}
		return al;
	}

	/**
	 * @Title: DeleteTeaInfo
	 * @Description: TODO(删除教师号为id的教师信息)
	 * @param id
	 * @return boolean 返回类型
	 * @throws
	 */

	public boolean DeleteTeaInfo(int id) {
		boolean flag = false;
		try {
			sql = "delete from teacher_wangcc where tea_id=? ";
			conn = DbHelper.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			if (ps.execute()) {
				flag = true;
			}
		} catch (Exception e) {

		} finally {
			this.close();

		}

		return flag;

	}

	/**
	 * @Title: InsertTeaInfo
	 * @Description: TODO(插入老师信息)
	 * @param id
	 * @param name
	 * @param age
	 * @param password
	 * @return boolean 返回类型
	 * @throws
	 */

	public boolean InsertTeaInfo(TeacherBean tb) {

		boolean flag = false;
		try {
			sql = " insert into teacher_wangcc(tea_id,tea_name,tea_age,tea_password) values(?,?,?,?)";
			conn = DbHelper.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, tb.getId());
			ps.setString(2, tb.getName());
			ps.setInt(3, tb.getAge());
			ps.setString(4, tb.getPassword());

			if (ps.executeUpdate() > 0) {
				flag = true;
			}
		} catch (Exception e) {
		} finally {
			this.close();
		}
		return flag;
	}

	/**
	 * @Title: UpdateTeaInfo
	 * @Description: TODO(更新教师信息)
	 * @param id
	 * @param name
	 * @param age
	 * @param password
	 * @return boolean 返回类型
	 * @throws
	 */

	public boolean UpdateTeaInfo(TeacherBean tb) {
		boolean flag = false;
		try {
			sql = " update  teacher_wangcc set tea_id=?,tea_name=?,tea_age=?,tea_password=? where tea_id=?";
			conn = DbHelper.getConnection();
			ps = conn.prepareStatement(sql);

			ps.setInt(1, tb.getId());
			ps.setString(2, tb.getName());
			ps.setInt(3, tb.getAge());
			ps.setString(4, tb.getPassword());
			ps.setInt(5, tb.getId());

			if (ps.executeUpdate() > 0) {
				flag = true;
			}
		} catch (Exception e) {
		} finally {
			this.close();
		}
		return flag;
	}

	public String GetTeaNameById(int id) {
		String name = null;
		try {
			sql = "select tea_name from teacher_wangcc where stu_id=? ";
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
