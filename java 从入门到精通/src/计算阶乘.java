
public class 计算阶乘 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int i=1;
		double temp1,sum=0,temp=1;
		while(i<=20){
			temp=temp*i;
			temp1=1/temp;
			sum=sum+temp1;
			i++;
		}
		System.out.println(sum);
	}

}
