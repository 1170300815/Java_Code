import java.util.Arrays;

public class Repeat {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int arr[]=new int[] {23,42,12,84,10};
		int newarr[]=Arrays.copyOfRange(arr, 0, 5);
		for(int i:newarr) {
			System.out.println(i);
		}

	}

}
