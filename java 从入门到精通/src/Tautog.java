
public class Tautog {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int arr2[][]= {{4,3},{1,2}};
		System.out.println("数组中的元素是： ");
		for(int x[]:arr2) {
			for(int e:x) {
				if(e==x.length) {
					System.out.print(e);
				}else
					System.out.print(e+"、");
			}
		}

	}

}
