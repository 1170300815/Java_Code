package edu.hit1160300610.experiment1;

import java.util.Scanner;

public class ControlStrcutureTest4 {
	public static void ChineseTriangle(int N) {
		int arr[][] = new int[N + 1][];
		for (int i = 0; i < N + 1; i++) {
			arr[i] = new int[i + 1];
		}
		for (int i = 0; i <= N; i++) {
			for (int j = 0; j <= arr[i].length - 1; j++) {
				if (i == 0 || j == 0 || j == arr[i].length - 1)
					arr[i][j] = 1;
				else
					arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
			}
		}
		for (int i = 0; i < N + 1; i++) {
			for (int k = N; k > i; k--) {
				System.out.print("  ");
			}
			for (int k1 = 0; k1 <= i; k1++) {
				System.out.printf("%4d", arr[i][k1]);
			}
			System.out.println();
		}

	}
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		System.out.println("请输入阶数");
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		ChineseTriangle(N);
	}
}
