

import java.util.Scanner;

public class Login {
	Scanner scan = new Scanner(System.in);
	private final static String ID = "admin";
	private final static String PWD = "1234";
	public static String id;
	public static String pwd;
	public static boolean check = true;

	public Login() {		
		for(int i=0; i<3; i++) {
			// 아이디, 패스워드 체크
			// 접속 로그인
			System.out.println("|========================================도서관리 프로그램======================================");
			System.out.print("| 아이디 입력 = ");
			id = scan.nextLine();
			System.out.print("| 비밀번호 입력 = ");
			pwd = scan.nextLine();
			System.out.println("|===============================================================================================");
			
			if(id == "" || pwd == "") System.out.println("| 아이디 / 비밀번호를 입력하셔야 합니다");
			else {
				if(!id.equals(ID)) {System.out.println("| 아이디를 잘못 입력하셨습니다");}
				else if(!pwd.equals(PWD)) {System.out.println("| 비밀번호를 잘못 입력하셨습니다");}
				else { System.out.println("| 도서관리 프로그램에 접속합니다.");
				System.out.println("|===============================================================================================");					break;
				}
			}
			// 3회 틀릴경우 종료시킨다.
			System.out.println("| 3회 틀릴 경우 종료,"+ (i+1)+"회 틀렸습니다..");
			if(i == 2) {
				check = false;
				break;
			}
			
		}
	}

}
