package edu.hit1160300610.experiment1;

import java.util.Scanner;

public class ControlStrcutureTest1 {
	public static void guessNumber() {
		System.out.println("给你一个1至100之间的整数，请猜测这个数");
		for (int k = 0;; k++) {
			int realNumber = (int) (Math.random() * 100) + 1;
			int yourGuess = 0;
			int i = 1;
			@SuppressWarnings("resource")
			Scanner in = new Scanner(System.in);
			System.out.println("请输入您的猜测：");
			yourGuess = in.nextInt();
			while (yourGuess < 1 || yourGuess > 100) {
				System.out.println("请输入大于等于1且小于等于100的整数，谢谢！");
				yourGuess = in.nextInt();
			}
			while (yourGuess != realNumber) {
				i++;
				if (yourGuess > realNumber) {
					System.out.println("大了，请再猜");
					yourGuess = in.nextInt();
					while (yourGuess < 1 || yourGuess > 100) {
						System.out.println("请输入大于等于1且小于等于100的整数，谢谢！");
						yourGuess = in.nextInt();
					}
				} else if (yourGuess < realNumber) {
					System.out.println("猜小了，请再猜");
					yourGuess = in.nextInt();
					while (yourGuess < 1 || yourGuess > 100) {
						System.out.println("请输入大于等于1且小于等于100的整数，谢谢！");
						yourGuess = in.nextInt();
					}
				}

			}

			System.out.println("恭喜！猜对了！");
			System.out.println("你一共猜了" + i + "次呢~，继续努力吧！");
			System.out.println("多好的游戏再来一局吧，继续玩输入1，不玩了输入0");
			int u = in.nextInt();
			if (u == 0) {
				break;
			}
			if (u == 1) {
				continue;
			} else {
				System.out.println("看不懂要求？？？不让你玩了");
				break;
			}
		}
	}

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		guessNumber();

	}

}
