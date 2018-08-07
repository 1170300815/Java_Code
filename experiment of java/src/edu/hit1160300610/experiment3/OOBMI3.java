package edu.hit1160300610.experiment3;

import java.util.*;
import java.util.Scanner;

public class OOBMI3 {
	public static void inputStudent() {
		System.out.println("从键盘输入学生信息");
		Scanner in = new Scanner(System.in);
		System.out.println("輸入學生學號");
		String id = in.nextLine();
		System.out.println("輸入學生姓名");
		String name = in.nextLine();
		System.out.println("輸入學生身高(m)");
		double height = in.nextDouble();
		System.out.println("輸入學生體重(kg)");
		double weight = in.nextDouble();
		OOBMI3 on = new OOBMI3();
		Student on1 = on.new Student(id, name, height, weight);
		students.add(on1);
	}

	class Student{ 
		   private String id; //10 digital charactors, like 1160611003
		   private String name;
		   private double weight; //in kilograms
		   private double height; //in meters
		   private double bmi;

		public Student(String id, String name, double height, double weight) {
				this.id=id;
				this.name=name;
				this.height=height;
				this.weight=weight;
			}

	}

	static ArrayList<Student> students = new ArrayList<>();

	public static void main(String[] args) {
		int choice = 1;
		for (; choice == 1;) {
			inputStudent();
			System.out.println("是否繼續輸入學生信息，是：1；不是：2");
			Scanner in = new Scanner(System.in);
			choice = in.nextInt();
		}

	}

}
