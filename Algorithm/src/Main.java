import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Student st1 = new Student("손오공","1682");
		Student st2 = new Student("저팔계","1772");
		Student st3 = new Student("사오정","1813");
		
		ArrayList <Student> list = new ArrayList<Student>();
		
		list.add(st1);
		list.add(st2);
		list.add(st3);
		
		for(Student stu:list) {
			System.out.println(stu.getName());
			System.out.println(stu.getNo());
		}
		
		Scanner scan = new Scanner(System.in);
		System.out.println("계속 검색하고 싶으시면 y, 종료하고싶으면 n");
		
		while(true){
			String input = scan.next();
			if(input.equals("y")) {
				
			} else if(input.equals("n")) {
				break;
			}
		}
		
		System.out.println("종료되었습니다.");
	}
}
