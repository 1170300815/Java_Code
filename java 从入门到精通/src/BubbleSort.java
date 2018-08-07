
public class BubbleSort {

	public static void main(String[] args) {
//		创建一个数组，这个数组是乱序的
		int array[]= {63,4,24,1,3,15};
//		创建冒泡排序的对象
		BubbleSort sorter=new BubbleSort();
//		调用排序方法将数组排序
		sorter.sort(array);

	}
	public void sort(int array[]) {
		for(int i=1;i<array.length;i++) {
			for(int j=0;j<array.length-i;j++) {
				if(array[j]>array[j+1]) {
					int temp=array[j];
					array[j]=array[j+1];
					array[j+1]=temp;
				}
			}
		}
		showArray(array);
	}
	public void showArray(int array[]) {
		for(int i:array) {
			System.out.print(" >"+i);
		}
		System.out.println();
	}

}
