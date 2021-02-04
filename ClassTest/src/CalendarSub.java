import java.util.Calendar;
import java.util.Scanner;

public class CalendarSub {
	//콘솔에서 정수를 입력받는 메소드 생성
	public int getInput(String msg) {
		Scanner scan = new Scanner(System.in);
		System.out.print(msg + "=");
		return scan.nextInt();
	}
	
	// 입력받은 년월과 1일 Calendar 객체로 만들어 리턴하기
	public Calendar getCalendar(int y, int m) {
		Calendar now = Calendar.getInstance();
		now.set(y, m, 1);
		return now;
	}
	
	//제목출력
	public void titlePrint(int y, int m) {
		System.out.println("\t\t"+y+"년 "+ m + "월");
		System.out.println("일\t월\t화\t수\t목\t금\t토");
	}
	
	//공백출력
	public void spacePrint(int w) {
		for(int i=1; i<w; i++) {
			System.out.print("\t");
		}
	}
	
	public void dayPrint(int lastDay,int week) {
		for(int i=1; i<=lastDay; i++) {
			System.out.print(i+"\t");
			if( (i+week-1) %7 == 0) {
				System.out.println("");
			}
		}
	}
	
	
	public void start() {
		//년도
		int year = getInput("년도");
		int month = getInput("월");
		//1일의 요일
		Calendar modifyCalendar = getCalendar(year,month-1);
		int week = modifyCalendar.get(Calendar.DAY_OF_WEEK);
		int lastDay = modifyCalendar.getActualMaximum(Calendar.DAY_OF_MONTH);
				
		titlePrint(year,month);
		spacePrint(week);
		dayPrint(lastDay,week);
	}
}
