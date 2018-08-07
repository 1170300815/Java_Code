package edu.hit1160300610.experiment3;

import java.util.*;

public class OOBMI4 {
	public Student[] genStudents(int n) {
		Student students[]=new Student[n];
		Random r=new Random();
		double x=0.0,y=0.0;
		for(int i=0;i<200;i++) {
			x=r.nextGaussian();
			Student st=new Student(String.format("%04d", i),
					genRandomString(6),(1.75+x*0.1),(60.0+y*5));
		}
		return students;
	}

	public String genRandomString(int length) {
		String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int number = random.nextInt(26);
			sb.append(str.charAt(number));
		}
		return sb.toString();
	}
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
	
	public static void main(String[] args) {
		
	}

}
