package com.meng.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 
 * ��Ŀ���ƣ�StuInfoManage �����ƣ�LoginBo ����������½�ж� �����ˣ�wangcc ����ʱ�䣺2016-8-3 ����2:42:24
 * �޸ı�ע��
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
		if (type.equals("ѧ��")) {
			this.n_id = "stu_id";
			this.n_password = "stu_password";
			this.tablename = "student_wangcc";
			this.flagtype = 0;
		} else if (type.equals("��ʦ")) {
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
	 * @Description: TODO(��½�ж�)
	 * @param name
	 * @param password
	 * @return boolean ��������
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
	 * @Description: TODO(�޸�����)
	 * @param id
	 * @param password
	 * @return boolean ��������
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
	 * @Description: TODO(�ر���Դ) void ��������
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
