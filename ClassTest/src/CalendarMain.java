import java.util.Calendar;

public class CalendarMain {
 public static void main(String[] args) {
	 Calendar cl = Calendar.getInstance();
	 int week = cl.get(Calendar.DAY_OF_WEEK);
	 
	 System.out.print(cl);
	 
	 
 }
}
