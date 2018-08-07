package edu.hit1160300610.experiment2;

public class BMI3 {
	public static void sortByids(String ids[]) {
		int sortedIndex[] = new int[ids.length];
		for (int h = 0; h < ids.length; h++) {
			sortedIndex[h] = h;
		}
		for (int i = 1; i < ids.length; i++) {
			for (int j = 0; j < ids.length - i; j++) {
				if (ids[j].compareTo(ids[j + 1]) < 0) {
					String temp = new String(ids[j]);
					ids[j] = ids[j + 1];
					ids[j + 1] = temp;
					int temp1 = j;
					sortedIndex[j] = sortedIndex[j + 1];
					sortedIndex[j + 1] = temp1;
				}
			}
		}
	}

	public static void sortByname(String name[]) {
		int sortedIndex[] = new int[name.length];
		for (int h = 0; h < name.length; h++) {
			sortedIndex[h] = h;
		}
		for (int i = 1; i < name.length; i++) {
			for (int j = 0; j < name.length - i; j++) {
				if (name[j].compareTo(name[j + 1]) < 0) {
					String temp = new String(name[j]);
					name[j] = name[j + 1];
					name[j + 1] = temp;
					int temp1 = j;
					sortedIndex[j] = sortedIndex[j + 1];
					sortedIndex[j + 1] = temp1;
				}
			}
		}
	}

	public static void sortByheight(float heights[]) {
		int sortedIndex[] = new int[heights.length];
		for (int h = 0; h < heights.length; h++) {
			sortedIndex[h] = h;
		}
		for (int i = 1; i < heights.length; i++) {
			for (int j = 0; j < heights.length - 1; j++) {
				if (heights[j] > heights[j + 1]) {
					float temp = heights[j];
					heights[j] = heights[j + 1];
					heights[j + 1] = temp;
					int temp1 = j;
					sortedIndex[j] = sortedIndex[j + 1];
					sortedIndex[j + 1] = temp1;
				}
			}
		}
	}

	public static void sortByweight(float weights[]) {
		int sortedIndex[] = new int[weights.length];
		for (int h = 0; h < weights.length; h++) {
			sortedIndex[h] = h;
		}
		for (int i = 1; i < weights.length; i++) {
			for (int j = 0; j < weights.length - 1; j++) {
				if (weights[j] > weights[j + 1]) {
					float temp = weights[j];
					weights[j] = weights[j + 1];
					weights[j + 1] = temp;
					int temp1 = j;
					sortedIndex[j] = sortedIndex[j + 1];
					sortedIndex[j + 1] = temp1;
				}
			}
		}
	}

	public static void sortBybmi(float bmis[]) {
		int sortedIndex[] = new int[bmis.length];
		for (int h = 0; h < bmis.length; h++) {
			sortedIndex[h] = h;
		}
		for (int i = 1; i < bmis.length; i++) {
			for (int j = 0; j < bmis.length - 1; j++) {
				if (bmis[j] > bmis[j + 1]) {
					float temp = bmis[j];
					bmis[j] = bmis[j + 1];
					bmis[j + 1] = temp;
					int temp1 = j;
					sortedIndex[j] = sortedIndex[j + 1];
					sortedIndex[j + 1] = temp1;
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
