import java.util.Date;

public class GetDate {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Date date =new Date();
		String hour=String.format("%tH", date);
		String minute=String.format("%tM", date);
		String second =String.format("%tS", date);
		System.out.println("现在是："+hour+"时"+minute+"分"+second+"秒");

	}

}
