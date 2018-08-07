package com.lzw;

public class Quizchar {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Character char1 = new Character('a');
		Character char2 = new Character('A');
		if (char1.equals(char2) == true) {
			System.out.println("两个char型对象相等");
		} else {
			System.out.println("两个char型对象不相等");
		}
		Character newchar1 = char1.toLowerCase(char1);
		Character newchar2 = char2.toLowerCase(char2);
		if (newchar1.equals(newchar2)==true) {
			System.out.println("两个char型对象相等");
		} else {
			System.out.println("两个char型对象不相等");
		}

	}

}
