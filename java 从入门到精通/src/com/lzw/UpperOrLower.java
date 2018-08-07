package com.lzw;

public class UpperOrLower {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Character mychar1=new Character('b');
		Character mychar2=new Character('a');
		System.out.println(mychar1+"是大写字母吗？"
				+Character.isUpperCase(mychar1));
		System.out.println(mychar2+"是小写字母吗？"+
				Character.isLowerCase(mychar2));

	}

}
