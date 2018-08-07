package edu.hit1160300610.experiment1;

import java.util.Scanner;

public class ControlStrcutureTest2 {
	public static void upper(int N) {
		for (int i = 1; i <= N; i++) {
			for (int j = N; j >= i; j--) {
				System.out.print(" ");
			}
			for (int k = 1; k <= i; k++) {
				System.out.print("*");
			}
			System.out.print("   ");
			for(int a=N;a>=i;a--) {
				System.out.print(" ");
			}
			for(int b=1;b<=i;b++) {
				System.out.print("* ");
			}
			for(int c=N;c>=i;c--) {
				System.out.print(" ");
			}
			System.out.print("   ");
			for(int h=1;h<=i;h++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	public static void lower(int N) {
		for(int i=1;i<=N;i++) {
			for(int k=1;k<=i;k++) {
				System.out.print(" ");
			}
			for(int j=N;j>=i;j--) {
				System.out.print("*");
			}
			System.out.print("   ");
			for(int a=1;a<=i;a++) {
				System.out.print(" ");
			}
			for(int b=N;b>=i;b--) {
				System.out.print("* ");
			}
			for(int c=1;c<=i;c++) {
				System.out.print(" ");
			}
			System.out.print("   ");
			for(int h=N;h>=i;h--) {
				System.out.print("*");
			}
			System.out.println();	
		}
	}

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		System.out.println("请输入数N");
		@SuppressWarnings("resource")
		Scanner in=new Scanner(System.in);
		int N=in.nextInt();
		upper(N);
		System.out.printf("\n\n");
		lower(N);

	}

}
