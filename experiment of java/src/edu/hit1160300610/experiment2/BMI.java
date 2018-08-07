package edu.hit1160300610.experiment2;

import java.util.Arrays;
import java.util.Scanner;

public final class BMI {
	public static String checkHealth(float bmi) {
		if (bmi <= 18.5) {
			return ("Underweight");
		} else if (bmi > 18.5 && bmi <= 23) {
			return ("Normal Range");
		} else if (bmi > 23 && bmi <= 25) {
			return ("Overweight--At Risk");
		} else if (bmi > 25 && bmi <= 30) {
			return ("Overweight--Moderately Obese");
		} else {
			return ("Overweight--Severely Obese");
		}
	}

	public static void sortByids(String ids[], int sortedIndex[]) {
		String newids[] = Arrays.copyOf(ids, ids.length);
		for (int h = 0; h < ids.length; h++) {
			sortedIndex[h] = h;
		}
		for (int i = 1; i < newids.length; i++) {
			for (int j = 0; j < newids.length - i; j++) {
				if (newids[j].compareTo(newids[j + 1]) > 0) {
					String temp = new String(newids[j]);
					newids[j] = newids[j + 1];
					newids[j + 1] = temp;
					int temp1 = sortedIndex[j];
					sortedIndex[j] = sortedIndex[j + 1];
					sortedIndex[j + 1] = temp1;
				}
			}
		}
	}

	public static void sortByname(String name[], int sortedIndex[]) {
		String newname[] = Arrays.copyOf(name, name.length);
		for (int h = 0; h < name.length; h++) {
			sortedIndex[h] = h;
		}
		for (int i = 1; i < newname.length; i++) {
			for (int j = 0; j < newname.length - i; j++) {
				if (newname[j].compareTo(newname[j + 1]) > 0) {
					String temp = new String(newname[j]);
					newname[j] = newname[j + 1];
					newname[j + 1] = temp;
					int temp1 = sortedIndex[j];
					sortedIndex[j] = sortedIndex[j + 1];
					sortedIndex[j + 1] = temp1;
				}
			}
		}
	}

	public static void sortByheight(float heights[], int sortedIndex[]) {
		float newheights[] = Arrays.copyOf(heights, heights.length);
		for (int h = 0; h < heights.length; h++) {
			sortedIndex[h] = h;
		}
		for (int i = 1; i < newheights.length; i++) {
			for (int j = 0; j < newheights.length - i; j++) {
				if (newheights[j] > newheights[j + 1]) {
					float temp = newheights[j];
					newheights[j] = newheights[j + 1];
					newheights[j + 1] = temp;
					int temp1 = sortedIndex[j];
					sortedIndex[j] = sortedIndex[j + 1];
					sortedIndex[j + 1] = temp1;
				}
			}
		}
	}

	public static void sortByweight(float weights[], int sortedIndex[]) {
		float newweights[] = Arrays.copyOf(weights, weights.length);
		for (int h = 0; h < weights.length; h++) {
			sortedIndex[h] = h;
		}
		for (int i = 1; i < newweights.length; i++) {
			for (int j = 0; j < newweights.length - i; j++) {
				if (newweights[j] > newweights[j + 1]) {
					float temp = newweights[j];
					newweights[j] = newweights[j + 1];
					newweights[j + 1] = temp;
					int temp1 = sortedIndex[j];
					sortedIndex[j] = sortedIndex[j + 1];
					sortedIndex[j + 1] = temp1;
				}
			}
		}
	}

	public static void sortBybmi(float bmis[], int sortedIndex[]) {
		float newbmis[] = Arrays.copyOf(bmis, bmis.length);
		for (int h = 0; h < bmis.length; h++) {
			sortedIndex[h] = h;
		}
		for (int i = 1; i < newbmis.length; i++) {
			for (int j = 0; j < newbmis.length - i; j++) {
				if (newbmis[j] > newbmis[j + 1]) {
					float temp = newbmis[j];
					newbmis[j] = newbmis[j + 1];
					newbmis[j + 1] = temp;
					int temp1 = sortedIndex[j];
					sortedIndex[j] = sortedIndex[j + 1];
					sortedIndex[j + 1] = temp1;
				}
			}
		}
	}

	public static void printStudents(int stunumber, int sortedIndex[], String ids[], String name[], float heights[],
			float weights[], float bmis[]) {
		System.out.println("排序前的结果：");
		for (int i = 0; i < stunumber; i++) {
			System.out.print("学号:" + ids[i] + "\t" + "姓名：" + name[i] + "\t"+ "身高:" + heights[i] * 100 + "厘米" + "\t"
					+ "体重" + weights[i] + "斤" + "\t" + "BMI:" + bmis[i] + "\t" + checkHealth(bmis[i]));
			System.out.println();
		}
		System.out.println("排序后的结果：");
		for (int j = 0; j < stunumber; j++) {
			System.out.print("学号:" + ids[sortedIndex[j]] + "\t" + "姓名：" + name[sortedIndex[j]] +"\t" + "身高:"
					+ heights[sortedIndex[j]] * 100 + "厘米" + "\t" + "体重" + weights[sortedIndex[j]] * 2 + "斤" + "\t"
					+ "BMI:" + bmis[sortedIndex[j]] + "\t" + checkHealth(bmis[sortedIndex[j]]));
			System.out.println();
		}
	}

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		System.out.println("请输入你要记录的学生人数");
		int stunumber = in.nextInt();
		String ids[] = new String[stunumber];
		int sortedIndex[] = new int[stunumber];
		String names[] = new String[stunumber];
		float heights[] = new float[stunumber];
		float weights[] = new float[stunumber];
		float bmis[] = new float[stunumber];
		System.out.println("请依次输入各个学生的学号、姓名、身高(m)、体重(kg)");
		for (int i = 0; i < stunumber; i++) {
			ids[i] = in.next();
			names[i] = in.next();
			heights[i] = in.nextFloat();
			weights[i] = in.nextFloat();
			bmis[i] = weights[i] / (heights[i] * heights[i]);
		}
		System.out.println("请输入排序类型(按学号排序选1，按姓名排序选2，按身高排序选3，按体重排序选4，按BMI排序选5)");
		int choice = in.nextInt();
		if (choice == 1) {
			sortByids(ids, sortedIndex);
			printStudents(stunumber, sortedIndex, ids, names, heights, weights, bmis);
		} else if (choice == 2) {
			sortByname(names, sortedIndex);
			printStudents(stunumber, sortedIndex, ids, names, heights, weights, bmis);
		} else if (choice == 3) {
			sortByheight(heights, sortedIndex);
			printStudents(stunumber, sortedIndex, ids, names, heights, weights, bmis);
		} else if (choice == 4) {
			sortByweight(weights, sortedIndex);
			printStudents(stunumber, sortedIndex, ids, names, heights, weights, bmis);
		} else if (choice == 5) {
			sortBybmi(bmis, sortedIndex);
			printStudents(stunumber, sortedIndex, ids, names, heights, weights, bmis);
		}
	}

}
