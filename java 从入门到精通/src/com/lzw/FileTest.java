package com.lzw;

import java.io.File;

public class FileTest {    //創建類FileTest

	public static void main(String[] args) { //主方法
		File file=new File("word.txt");      //創建文件對象
		if(file.exists()) {                  //如果該文件存在
			file.delete();                   //將文件刪除
			System.out.println("文件已刪除");    //輸出的提示信息
		}
		else {                               //如果文件不存在
			try {                            //try語句駃捕捉可能出現的异常
			file.createNewFile();            //创建该文件
			System.out.println("文件已經創建");   //输出提示信息
			}
			catch(Exception e) { 
			e.printStackTrace();}
			
		}

	}

}
