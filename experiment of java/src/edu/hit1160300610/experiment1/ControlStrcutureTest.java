package edu.hit1160300610.experiment1;

import java.util.Scanner;

public class ControlStrcutureTest {
	// public static void printLeapYears(int beginyear, int endyear) {
	// int flag = 0;
	// for (int i = beginyear; i <= endyear && flag == 0; i++) {
	// if (checkLeapYear(i) == true) {
	// System.out.println(i);
	// flag = 1;
	// }
	// }
	//
	// }

	public static void printLeapYears(int beginyear, int endyear) {
		for (int i = beginyear; i <= endyear; i++) {
			if (checkLeapYear(i) == true) {
				System.out.println(i);
			}
		}

	}

	public static boolean checkLeapYear(int year) {
		if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) {
			return true;
		} else
			return false;
	}

	// public static void main(String[] args) {
	// TODO 自动生成的方法存根
	// System.out.println("請輸入年份");
	// Scanner in=new Scanner(System.in);
	// int Year=in.nextInt();
	// if(checkLeapYear(Year)==true) {
	// System.out.println("真的是閏年呦");
	// }
	// else {
	// System.out.println("對不起，不是閏年");
	// }
	//
	// }

	// public static void main(String[] args) {
	// printLeapYears(2001, 2050);
	// }

	public static void main(String[] args) {
		printLeapYears(2001, 2050);

	}

}
