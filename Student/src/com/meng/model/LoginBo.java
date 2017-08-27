package com.meng.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 
 * 项目名称：StuInfoManage 类名称：LoginBo 类描述：登陆判断 创建人：wangcc 创建时间：2016-8-3 下午2:42:24
 * 修改备注：
 * 
 * @version
 * 
 */

public class LoginBo {
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	private Connection conn = null;
	private String sql = null;
	private String n_password;
	private String n_id;
	private String tablename;
	private int flagtype;

	public LoginBo() {
	}

	public LoginBo(String type) {
		if (type.equals("学生")) {
			this.n_id = "stu_id";
			this.n_password = "stu_password";
			this.tablename = "student_wangcc";
			this.flagtype = 0;
		} else if (type.equals("老师")) {
			this.n_id = "tea_id";
			this.n_password = "tea_password";
			this.tablename = "teacher_wangcc";
			this.flagtype = 1;

		} else {
			this.n_id = "a_id";
			this.n_password = "a_password";
			this.tablename = "admin_wangcc";
			this.flagtype = 2;
		}

	}

	/**
	 * @Title: Checklogin
	 * @Description: TODO(登陆判断)
	 * @param name
	 * @param password
	 * @return boolean 返回类型
	 * @throws
	 */

	public boolean Checklogin(int u, String password) {
		boolean flag = false;
		try {
			sql = "select  " + n_password + "  from " + tablename + "  where  "
					+ n_id + "=?";
			conn = DbHelper.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, u);
			rs = ps.executeQuery();
			while (rs.next()) {

				if (rs.getString(1).equals(password)) {
					flag = true;
				}
			}

		} catch (Exception e) {

		} finally {
			this.close();
		}

		return flag;
	}

	public int gettype() {
		return flagtype;
	}

	/**
	 * @Title: ModifyPass
	 * @Description: TODO(修改密码)
	 * @param id
	 * @param password
	 * @return boolean 返回类型
	 * @throws
	 */

	public boolean ModifyPass(int id, String password) {

		boolean flag = false;
		try {
			sql = "update " + tablename + " set " + n_password + "=? where "
					+ n_id + "=?";
			conn = DbHelper.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, password);
			ps.setInt(2, id);
			if (ps.executeUpdate() > 0)
				flag = true;
		} catch (Exception e) {
		} finally {
			this.close();
		}

		return flag;
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
