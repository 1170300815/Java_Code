package com.lzw;

public class Quizfl {
	public void methodoffulei() {
		
	}
	Quizfl() {
		System.out.println("在调用子类成员方法之前");
		methodoffulei();
		System.out.println("在调用子类成员方法之后");
	}
	public static void main(String[] args) {
		new Quizzl();
	}

}
class Quizzl extends Quizfl{
	private int i=1;
	public void methodoffulei() {
		System.out.println("methodofzilei()"+i);
	}
	Quizzl(){
		System.out.println(i);
	}
}
