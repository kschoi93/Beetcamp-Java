import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class CalendarTest {

	public CalendarTest() {
		GregorianCalendar now = new GregorianCalendar();
		now.setTimeZone(TimeZone.getTimeZone("America/Chicago"));
		
		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH)+1;
		int date = now.get(Calendar.DATE);
		
		int h = now.get(Calendar.HOUR);
		int m = now.get(Calendar.MINUTE);
		int s = now.get(Calendar.SECOND);
		
		System.out.println(year+"��"+month+"��"+date+"��");
		System.out.println(h+"��"+m+"��"+s+"��");
		
		Calendar cal = Calendar.getInstance();
		String [] local = TimeZone.getAvailableIDs();
		for(int i =0; i<local.length;i++) {
			System.out.println(local[i]);
		}
	}
	public static void main(String[]args) {
		new CalendarTest();
	}
}
