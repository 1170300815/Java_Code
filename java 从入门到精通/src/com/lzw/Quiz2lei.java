package com.lzw;

public class Quiz2lei {
	private float height;
	private float width;
	public Quiz2lei(float height,float width){
		this.height=height;
		this.width=width;
	}
	public float square(){
		return height*width;
	}
	public static void main(String args[]){
		Quiz2lei u=new Quiz2lei(3.5f,4.5f);
		System.out.println(u.square());
	}

}
