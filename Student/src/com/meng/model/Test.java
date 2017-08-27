package com.meng.model;

import java.util.ArrayList;

import com.meng.bean.TeacherBean;

public class Test {
	/**
	 * @Title: main
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param args
	 *            void 返回类型
	 * @throws
	 */

	public static void main(String[] args) {
		// LoginBo lb = new LoginBo("学生");
		// if (lb.Checklogin(3, "232323")) {
		// System.out.println("done!");
		// } else {
		// System.out.println("failed");
		// }
		// AdmintoCouDao acd = new AdmintoCouDao();
		//
		// if (acd.InsertCourse(104, "心理学", 1124, "科比", "pe")) {
		// System.out.println("insert successful!");
		// }
		// String tablename = acd.gettablename();
		//
		// if (acd.CreateCourse(tablename)) {
		// System.out.println("you got it!");
		// }
		// System.out.println(acd.gettablename());
		AdmintoStuDao asd = new AdmintoStuDao();
		// ArrayList<StudentBean> al = asd.getStuInfoByPage(1);
		//
		// for (StudentBean sb : al) {
		// System.out.println(sb.getName());
		// }
		// StudentBean sb = new StudentBean();
		// sb.setId(12334);
		// sb.setName("paul1");
		// sb.setPassword("1111");
		// sb.setSex("男");
		// sb.setBirthday("1996-2-7");
		// sb.setDepartment("dd");
		// sb.setStuclass("gdgd");
		// sb.setMajor("dgdg");
		// sb.setOrigin("dgdg");
		// if (asd.InsertStuInfo(sb)) {
		// System.out.println("done!");
		// }
		AdmintoTeaDao atd = new AdmintoTeaDao();
		ArrayList<TeacherBean> al = atd.getTeaInfoByPage(2);
		for (TeacherBean sb : al) {
			System.out.println(sb.getId());
			System.out.println(sb.getName());
		}
	}
}
