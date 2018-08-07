package com.lzw;

public class Book {
	private String name;
//	定义一个String型的成员变量
	
	public String getName() {
//		定义一个getName（）的方法
		int id=0;
//		局部变量
		setName("java");
//		调用类中其他方法
		return id+this.name;
//		设置方法返回值
	}
	private void setName(String name) {
//		定义一个setName（）方法
		this.name=name;
//		将参数值赋予类中的成员变量
	}
	public Book getBook() {
		return this;
	}

}
