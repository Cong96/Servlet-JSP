package com.meng.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.meng.bean.StudentBean;

/**
 * 
 * ��Ŀ���ƣ�StuInfoManage �����ƣ�AdmintoStuDao �������� �����ˣ�wangcc ����ʱ�䣺2016-8-3 ����2:12:49
 * �޸ı�ע��
 * 
 * @version
 * 
 */

public class AdmintoStuDao {

	private PreparedStatement ps = null;
	private ResultSet rs = null;
	private Connection conn = null;
	private String sql = null;
	private int PageSize = 5;

	/**
	 * @Title: getPageCount
	 * @Description: TODO(�õ�ѧ����Ϣչʾ��ҳ��)
	 * @return int ��������
	 * @throws
	 */

	public int getPageCount() {
		int PageCount = 0;
		int rowcount = 0;
		try {
			sql = "select count(*) from student_wangcc";
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
	 * �õ�ÿҳ������
	 */

	/**
	 * @Title: getUserInfoByPage
	 * @Description: TODO(��ҳ����ѧ����Ϣ)
	 * @param PageNow
	 * @return ArrayList<StudentBean> ��������
	 * @throws
	 */

	public ArrayList<StudentBean> getStuInfoByPage(int PageNow) {
		ArrayList<StudentBean> al = new ArrayList<StudentBean>();
		try {
			sql = "select * from(select * from  student_wangcc where stu_id not in(select stu_id from student_wangcc where rownum<=?))where rownum<=?";
			conn = DbHelper.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, (PageNow - 1) * PageSize);
			ps.setInt(2, PageSize);
			rs = ps.executeQuery();
			while (rs.next()) {
				StudentBean ub = new StudentBean();
				ub.setId(rs.getInt(1));
				ub.setName(rs.getString(2));
				ub.setPassword(rs.getString(3));
				ub.setSex(rs.getString(4));
				ub.setBirthday(rs.getString(5));
				ub.setDepartment(rs.getString(6));
				ub.setStuclass(rs.getString(7));
				ub.setMajor(rs.getString(8));
				ub.setOrigin(rs.getString(9));
				al.add(ub);

			}

		} catch (Exception e) {
		} finally {
			this.close();
		}
		return al;
	}

	/**
	 * @Title: DeleteStuInfo
	 * @Description: TODO(ɾ��ѧ��Ϊid��ѧ����Ϣ)
	 * @param id
	 * @return boolean ��������
	 * @throws
	 */

	public boolean DeleteStuInfo(int id) {
		boolean flag = false;
		try {
			sql = "delete from student_wangcc where stu_id=? ";
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
	 * @Title: InsertStuInfo
	 * @Description: TODO(����ѧ����Ϣ)
	 * @param id
	 * @param name
	 * @param password
	 * @param sex
	 * @param birthday
	 * @param department
	 * @param stuclass
	 * @param major
	 * @param origin
	 * @return boolean ��������
	 * @throws
	 */
	public boolean InsertStuInfo(StudentBean sb) {

		boolean flag = false;
		try {
			sql = "insert into student_wangcc(stu_id,stu_name,stu_password,stu_sex,stu_birth,stu_dep,stu_class,stu_major,stu_origin) values(?,?,?,?,?,?,?,?,?)";
			conn = DbHelper.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, sb.getId());
			ps.setString(2, sb.getName());
			ps.setString(3, sb.getPassword());
			ps.setString(4, sb.getSex());
			ps.setString(5, sb.getBirthday());
			ps.setString(6, sb.getDepartment());
			ps.setString(7, sb.getStuclass());
			ps.setString(8, sb.getMajor());
			ps.setString(9, sb.getOrigin());
			System.out.println(sb.getId());
			if (ps.executeUpdate() > 0) {
				flag = true;
			}

		} catch (Exception e) {
		} finally {
			this.close();
		}
		return flag;
	}

	// public boolean InsertStuInfo(int id, String name, String password,
	// String sex, String birthday, String department, String stuclass,
	// String major, String origin) {
	//
	// boolean flag = false;
	// try {
	// sql =
	// "insert into student_wangcc(stu_id,stu_name,stu_password,stu_sex,stu_birth,stu_dep,stu_class,stu_major,stu_origin) values(?,?,?,?,?,?,?,?,?);";
	// conn = DbHelper.getConnection();
	// ps = conn.prepareStatement(sql);
	// ps.setInt(1, id);
	// ps.setString(2, name);
	// ps.setString(3, password);
	// ps.setString(4, sex);
	// ps.setString(5, birthday);
	// ps.setString(6, department);
	// ps.setString(7, stuclass);
	// ps.setString(8, major);
	// ps.setString(9, origin);
	// if (ps.executeUpdate() > 0) {
	// flag = true;
	// }
	// } catch (Exception e) {
	// } finally {
	// this.close();
	// }
	// return flag;
	// }

	/**
	 * @Title: UpdateStuInfo
	 * @Description: TODO(������һ�仰�����������������)
	 * @param sb
	 * @return boolean ��������
	 * @throws
	 */

	public boolean UpdateStuInfo(StudentBean sb) {
		boolean flag = false;
		try {
			sql = " update  student_wangcc set stu_id=? ,stu_name=?,stu_password=?,stu_sex=?,stu_birth=?,stu_dep=?,stu_class=?,stu_major=?,stu_origin=? where stu_id=?";
			conn = DbHelper.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, sb.getId());
			ps.setString(2, sb.getName());
			ps.setString(3, sb.getPassword());
			ps.setString(4, sb.getSex());
			ps.setString(5, sb.getBirthday());
			ps.setString(6, sb.getDepartment());
			ps.setString(7, sb.getStuclass());
			ps.setString(8, sb.getMajor());
			ps.setString(9, sb.getOrigin());
			ps.setInt(10, sb.getId());
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
	 * @Title: UpdateStuInfo
	 * @Description: TODO(����ѧ����Ϣ)
	 * @param id
	 * @param name
	 * @param password
	 * @param sex
	 * @param birthday
	 * @param department
	 * @param stuclass
	 * @param major
	 * @param origin
	 * @return boolean ��������
	 * @throws
	 */
	// public boolean UpdateStuInfo(int id, String name, String password,
	// String sex, String birthday, String department, String stuclass,
	// String major, String origin) {
	// boolean flag = false;
	// try {
	// sql =
	// " update  student_wangcc set stu_id=? stu_name=?,stu_password=?,stu_sex=?,stu_birth=?,stu_dep=?,stu_class=?,stu_major=?,stu_origin=? where tea_id=?;";
	// conn = DbHelper.getConnection();
	// ps = conn.prepareStatement(sql);
	// ps.setInt(1, id);
	// ps.setString(2, name);
	// ps.setString(3, password);
	// ps.setString(4, sex);
	// ps.setString(5, birthday);
	// ps.setString(6, department);
	// ps.setString(7, stuclass);
	// ps.setString(8, major);
	// ps.setString(9, origin);
	// ps.setInt(10, id);
	// if (ps.executeUpdate() > 0) {
	// flag = true;
	// }
	// } catch (Exception e) {
	// } finally {
	// this.close();
	// }
	// return flag;
	// }

	/**
	 * @Title: QuerySingleInfo
	 * @Description: TODO(��ѯ����ѧ����Ϣ)
	 * @param id
	 * @return StudentBean ��������
	 * @throws
	 */

	public StudentBean QuerySingleInfo(int id) {

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

	public String GetStuNameById(int id) {
		String name = null;
		try {
			sql = "select stu_name from student_wangcc where stu_id=? ";
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
	 * @Description: TODO(�ر���Դ����) void ��������
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
