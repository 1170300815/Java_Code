
public class 打印菱形 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		for (int i = 1; i <= 7; i += 2) {
			for (int kong = 7; kong >= i; kong--) {
				System.out.print(" ");
			}
			for (int  xing = 1; xing <= i; xing++) {
				System.out.print("* ");
			}
			System.out.println();
		}
		for(int j=1;j<=5;j+=2) {
			for(int kong=1;kong<j+3;kong++) {
				System.out.print(" ");
			}
			for(int xing=5;xing>=j;xing--) {
				System.out.print("* ");
			}
			System.out.println();
		}

	}

}
