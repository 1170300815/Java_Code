import java.util.Arrays;

public class Cope {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int arr[]=new int[] {23,42,12};
		int newarr[]=Arrays.copyOf(arr, arr.length);
		for(int i:newarr) {
			System.out.println(i);
		}
	}

}
