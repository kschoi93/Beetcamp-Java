package emp;

public class Login {
	public static String id;
	public static String pwd;
	public Login() {}
	//�α��� üũ�ϴ� �޼ҵ� (true : ����, false : ����)
	public static boolean loginCheck() {
		if(id == "" || pwd == ""){
			System.out.println("��й�ȣ�� �Է��� �α��� �ϼ���..");
			return false;
		} else {
			if(id.equals("master") && pwd.equals("1234")) {
				return true;
			}else {
				return false;
			}
		}
	}
}
