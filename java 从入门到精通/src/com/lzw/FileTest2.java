package com.lzw;

import java.io.File;

public class FileTest2 {            //创建类

	public static void main(String[] args) {
		File file=new File("word.txt");      //创建文件对象
		if(file.exists()) {                  //如果文件存在
			String name =file.getName();     //获取文件名称
			long length=file.length();       //获取文件长度
			boolean hidden=file.isHidden();  //判断文件是否是隐藏文件
			System.out.println("文件名： "+name);//输出提示信息
			System.out.println("文件長度是： "+length);
			System.out.println("該文件是隱藏文件嗎？"+hidden);
		}else {                              //如果文件不存在
			System.out.println("該文件不存在");   //输出信息
		}
	}

}
