import java.util.Arrays;

public class Reference {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int ia[]=new int[] {1,8,9,4,5};
		Arrays.sort(ia);
		int index=Arrays.binarySearch(ia, 8);
		System.out.println("4索引的位置是："+index);

	}

}
