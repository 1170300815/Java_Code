import java.util.Scanner;

public class 判断奇偶性 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		System.out.println("请输入一个数");
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		int shu = in.nextInt();
		if(shu%2==0) {
			System.out.println("这个数为偶数");
		}
		else {
			System.out.println("这个数为奇数");
		}
	

	}

}
