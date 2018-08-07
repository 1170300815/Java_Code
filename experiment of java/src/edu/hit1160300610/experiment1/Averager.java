package edu.hit1160300610.experiment1;

import java.util.Scanner;

public class Averager {
	
	public static void floatAvg() {
		Scanner in=new Scanner(System.in);
		System.out.println("請輸入兩個浮點數");
		float a=in.nextFloat();
		float b=in.nextFloat();
		float aver=(a+b)/2;
		System.out.printf("%.2f",aver);
		
	}
	public static void main(String[] args) {
		floatAvg();
	}

}
