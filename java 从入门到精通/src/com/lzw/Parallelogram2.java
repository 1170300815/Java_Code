package com.lzw;
class Quadrangle2{
	public static void draw(Quadrangle2 q) {
		//SomeSentence
	}
}
class Square2 extends Quadrangle2{
	//SomeSentence
}
class Angthing2{
	//SomeSentence
}
public class Parallelogram2 extends Quadrangle2 {
	public static void main(String[] args) {
		Quadrangle2 q= new Quadrangle2();//实例化父类对象
		if(q instanceof Parallelogram2) {
			Parallelogram2 p=(Parallelogram2)q;// 向下转型操作
		}
		if(q instanceof Square2) {
			Square2 s=(Square2)q;   //进行向下转型操作
		}
		//由于q对象不为Anything类的对象，所以这条语句是错误的
		//System.out.println(q instanceof Anything);
	}

}
