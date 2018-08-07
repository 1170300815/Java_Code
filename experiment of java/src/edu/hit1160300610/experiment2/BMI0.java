package edu.hit1160300610.experiment2;

import java.util.Scanner;

public class BMI0 {
	public static void input() {
		System.out.println("请输入学生的学号、姓名、身高(米)、体重(公斤)");
		Scanner in=new Scanner(System.in);
		int ids=in.nextInt();
		in.nextLine();
		String name=in.nextLine();
		float height=in.nextFloat();
		int weight=in.nextInt();
		float height1=height*100;
		float bmi=weight/(height*height);
		System.out.println("学号:"+ids+","+"姓名："+name+","
		+"身高:"+height1+"厘米,"+"体重"+weight+"斤,"+"BMI:"+bmi);
	}

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		input();
	}

}
