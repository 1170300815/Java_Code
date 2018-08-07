import java.util.Scanner;

public class 截取字符串并判断是否相等 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		System.out.println("请输出两个字符串");
		Scanner in = new Scanner(System.in);
		String str1 = in.nextLine();
		String str2 = in.nextLine();
		System.out.println("请输出你要截取第一个字符串的位置");
		int a1 = in.nextInt();
		int a2 = in.nextInt();
		System.out.println("请输入你要截取的第二个字符串的位置");
		int b1 = in.nextInt();
		int b2 = in.nextInt();
		String str11 = str1.substring(a1, a2);
		String str22 = str2.substring(b1, b2);
		if (str11.equalsIgnoreCase(str22)) {
			System.out.println("两个子串相同");
		} else {
			System.out.println("两个子串不同");
		}

	}

}
