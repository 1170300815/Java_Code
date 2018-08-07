package edu.hit1160300610.experiment2;

import java.util.Scanner;

public class BMI2 {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		System.out.println("请输入你要记录的学生人数");
		int stunumber=in.nextInt();
		String ids[]=new String[stunumber];
		String names[]=new String[stunumber];
		float heights[]=new float[stunumber];
		float weights[]=new float[stunumber];
		float bmis[]=new float[10000];
		System.out.println("请依次输入各个学生的学号、姓名、身高(m)、体重(kg)");
		for(int i=0;i<stunumber;i++) {
			ids[i]=in.nextLine();
			in.nextLine();
			names[i]=in.nextLine();
			heights[i]=in.nextFloat();
			weights[i]=in.nextFloat();
			bmis[i]=weights[i]/(heights[i]*heights[i]);
		}
		

	}

}
