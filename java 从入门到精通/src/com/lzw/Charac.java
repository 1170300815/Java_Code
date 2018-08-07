package com.lzw;

public class Charac {

	public static void main(String[] args) {
		String str1=Integer.toString(456);
		String str2=Integer.toBinaryString(456);
		String str3=Integer.toHexString(456);
		String str4=Integer.toOctalString(456);
		System.out.println("456的十进制表示： "+str1);
		System.out.println("456的二进制表示： "+str2);
		System.out.println("456的十六进制表示： "+str3);
		System.out.println("456的八进制表示： "+str4);
	}

}
