package com.lzw;

public class AnyThting {
	public AnyThting() {
//		定义无参构造方法
		this("this 调用有参构造方法");
//		使用this调用有参构造方法
		System.out.println("无参构造方法");
	}
	public AnyThting(String name) {
//		定义有参构造方法
		System.out.println("有参构造方法");
	}

}
