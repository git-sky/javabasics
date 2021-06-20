package cn.com.todo.test_datecalendar;
import java.text.SimpleDateFormat;
import java.util.Date;

public class testDateTime {

	/**
	 * ʱ���5����
	 */
	public static void main(String[] args) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		for (int i = 0; i < 2; i++) {
			
			Date a=new Date(date.getTime());
			
			System.out.println(sdf.format(date));

			long beforeTime = (date.getTime() / 1000) + 60 * 5;
			date.setTime(beforeTime * 1000);
			//System.out.println(date.getTime());
			System.out.println(sdf.format(date));
			
			Date b=new Date(date.getTime());
			
			//System.out.println(a);
			//System.out.println(b);
			//System.out.println(date.getTime());
			
			//System.out.println(date.getTime()+String.valueOf(Math.round(Math.random()*899999+100000)));
	
		}
	}

}
