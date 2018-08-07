package com.lzw;

public class Quizfulei {
	public void method1() {
		System.out.println("父类的第一个方法");
	}
	public void method2() {
		System.out.println("父类的第二个方法");
	}

	public static void main(String[] args) {
		Quizfulei a=new Zilei();
		a.method2();
	}
}
class Zilei extends Quizfulei{
	public void method2() {
		System.out.println("已经把父类的第二个方法重写");
	}
}


