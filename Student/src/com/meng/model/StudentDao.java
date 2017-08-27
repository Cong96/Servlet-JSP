package com.meng.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.meng.bean.StudentBean;

public class StudentDao {
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	private Connection conn = null;
	private String sql = null;

	public StudentBean getSingleInfo(int id) {

		StudentBean ub = new StudentBean();
		try {
			sql = "select * from student_wangcc where stu_id=? ";
			conn = DbHelper.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				ub.setId(rs.getInt(1));
				ub.setName(rs.getString(2));
				ub.setPassword(rs.getString(3));
				ub.setSex(rs.getString(4));
				ub.setBirthday(rs.getString(5));
				ub.setDepartment(rs.getString(6));
				ub.setStuclass(rs.getString(7));
				ub.setMajor(rs.getString(8));
				ub.setOrigin(rs.getString(9));

			}
		} catch (Exception e) {
		} finally {
			this.close();
		}
		return ub;
	}

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
