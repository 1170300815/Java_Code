package edu.hit1160300610.experiment3;

import java.util.ArrayList;
import java.util.Scanner;

import edu.hit1160300610.experiment3.OOBMI3.Student;

public class OOBMI2 {
	public static Student inputStudent() {
		System.out.println("从键盘输入学生信息");
		Scanner in = new Scanner(System.in);
		System.out.println("輸入學生學號");
		String id = in.nextLine();
		System.out.println("輸入學生姓名");
		String name = in.nextLine();
		System.out.println("輸入學生身高");
		double height = in.nextDouble();
		System.out.println("輸入學生體重");
		double weight = in.nextDouble();
		OOBMI2 on = new OOBMI2();
		Student on1 = on.new Student(id, name, height, weight);
		return on1;
	}

	class Student {
		private String id; // 10 digital charactors, like 1160611003
		private String name;
		private double weight; // in kilograms
		private double height; // in meters
		private double bmi;

		public Student(String id, String name, double height, double weight) {
			this.id = id;
			this.name = name;
			this.height = height;
			this.weight = weight;
		}
	}

	ArrayList<Student> students = new ArrayList<>();

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
