package edu.hit1160300610.experiment2;

import java.util.Scanner;

public class BMI1 {
	public static String checkHealth(float bmi) {
		if(bmi<=18.5) {
			return("Underweight");
		}
		else if(bmi>18.5&&bmi<=23) {
			return("Normal Range");
		}
		else if(bmi>23&&bmi<=25) {
			return("Overweight--At Risk");
		}
		else if(bmi>25&&bmi<=30) {
			return("Overweight--Moderately Obese");
		}
		else {
			return("Overweight--Severely Obese");
		}
	}
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
		System.out.println(checkHealth(bmi));
	}
	

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		input();

	}

}
