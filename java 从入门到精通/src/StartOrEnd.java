
public class StartOrEnd {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		String num1 = "456789";
		String num2 = "789456";
		boolean a1 = num1.startsWith("45");
		boolean a2 = num1.endsWith("89");
		boolean b1 = num2.startsWith("44");
		boolean b2 = num2.equals("11");
		System.out.println("字符串num1是以'45'开始的吗？" + a1);
		System.out.println("字符串num1是以'89'结束的吗？" + a2);
		System.out.println("字符串num1是以'44'开始的吗？" + b1);
		System.out.println("字符串num1是以'11'结束的吗？" + b2);
	}

}
