package edu.hit1160300610.experiment1;


import java.util.Scanner;
  
public class ControlStrcutureTset3 {
	public static void main(String[] args) {
		  final int ROW = 5;// 指定杨辉三角形的行数
		  int a[][] = new int[ROW + 1][];
		  for (int i = 0; i <= ROW; i++) {
		   a[i] = new int[i + 1]; // 指定每行的列数
		  }
		  for (int i = 0; i <= ROW; i++)
		   for (int j = 0; j <= a[i].length - 1; j++) {
		       if (i == 0 || j == 0 || j == a[i].length - 1)
		        a[i][j] = 1;
		       else
		        a[i][j] = a[i-1][j-1] + a[i-1][j];
		   }
		  //输出杨辉三角形
		    for (int i = 0; i <= ROW; i++) {
		     for (int j = 0; j <= ROW-i; j++)
		      System.out.print(" ");
		     for (int j = 0; j <= a[i].length - 1; j++)
		      System.out.print(a[i][j]+" ");
		     System.out.println();
		    }
		 }
}

