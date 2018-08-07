package com.lzw;

public class Quiz1lei {
	private String a;
	public void Fuzhi(String a) {
		this.a=a;
	}
	public String Huozhi() {
		return this.a;
	}
	public static void main(String[] args) {
		
		Quiz1lei u=new Quiz1lei();
		u.Fuzhi("123");
		System.out.println(u.Huozhi());
		}

}
