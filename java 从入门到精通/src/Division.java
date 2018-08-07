
public class Division {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		String str = new String("abc,def,ghi,gkl");
		String[] newstr = str.split(",");
		for (int i = 0; i < newstr.length; i++) {
			System.out.println(newstr[i]);
		}
		String[] newstr2 = str.split(",",2);
		for (int j = 0; j < newstr2.length; j++) {
			System.out.println(newstr2[j]);
		}

	}

}
