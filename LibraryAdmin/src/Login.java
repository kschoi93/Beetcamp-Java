

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
			// ���̵�, �н����� üũ
			// ���� �α���
			System.out.println("|========================================�������� ���α׷�======================================");
			System.out.print("| ���̵� �Է� = ");
			id = scan.nextLine();
			System.out.print("| ��й�ȣ �Է� = ");
			pwd = scan.nextLine();
			System.out.println("|===============================================================================================");
			
			if(id == "" || pwd == "") System.out.println("| ���̵� / ��й�ȣ�� �Է��ϼž� �մϴ�");
			else {
				if(!id.equals(ID)) {System.out.println("| ���̵� �߸� �Է��ϼ̽��ϴ�");}
				else if(!pwd.equals(PWD)) {System.out.println("| ��й�ȣ�� �߸� �Է��ϼ̽��ϴ�");}
				else { System.out.println("| �������� ���α׷��� �����մϴ�.");
				System.out.println("|===============================================================================================");					break;
				}
			}
			// 3ȸ Ʋ����� �����Ų��.
			System.out.println("| 3ȸ Ʋ�� ��� ����,"+ (i+1)+"ȸ Ʋ�Ƚ��ϴ�..");
			if(i == 2) {
				check = false;
				break;
			}
			
		}
	}

}
