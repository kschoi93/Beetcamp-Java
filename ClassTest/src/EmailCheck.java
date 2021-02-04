//최경식

import java.util.Scanner;

public class EmailCheck {


	// 이메일 입력 및 오류조사
	public String getInputEmail() {
		Scanner scan = new Scanner(System.in);
		String emailCheck = "";
		// 이메일 체크
		boolean clear = true;
		while(clear) {
			System.out.print("이메일 입력 = ");
			emailCheck = scan.next();
			if(emailCheck.indexOf("@") == -1 // "@" 문자가 없는지 체크
				|| period(emailCheck) == true // 앞단과 뒷단의 .의 올바름 여부를 확인한다
				|| specialCharacter(emailCheck) == 0) { // 특수문자 여부체크..
				System.out.println(emailCheck + "는 잘못입력된 메일입니다....");
			} else {
				clear = false; // 잘 입력했으면 빠져 나가~!
			}
		}
		return emailCheck; 
	}

	// . 마침표 검사!!!
	public Boolean period(String email) {
		String spl[] = email.split("@");
		int num = spl[1].lastIndexOf(".") - spl[1].indexOf(".") ; // indexof와 lastindexof의 값의 차이를 구한다
		
		boolean clear = false;
		
		// "@"의 앞단 "." 있는지 확인
		if(spl[0].indexOf(".") == -1) ;
		else clear = true;
		
		// "@"의 뒷단 도메인 부분의 "." 들의 간격이  4칸이상 멀어지면 .com .co.kr 이 아니다의 여부 확인
		if(num < 4) ;
		else clear = true;
		
		return clear;
		
	}
	
	// 이메일 특수문자 입력 여부 조사...
	public int specialCharacter(String email) {
		String text[] = { "#", "!","$","%","^","&","*","(",")","-",
				"_","+","=",",","[","]","{","}",":",";","'","?","<",">"};
		int specialCharacterTest = 0;
		for(int i = 0; i<text.length;i++) { // 23번? 특수문자들을 다 돌며 있는지 확인한다
			if(email.indexOf(text[i]) == -1) {
				specialCharacterTest = 1;
			} else {
				specialCharacterTest = 0;
				break;
			}
		}
		return specialCharacterTest; 
	}


	// EmailCheck 실행
	public EmailCheck() {

		while(true) {
			String email = getInputEmail().toLowerCase();
			// "@" 기준으로 id, domain 분리만한다 ! 
			// 왜냐? 이미 email에서 다 검사했으니까~
			String idDomain[] = email.split("@"); 
			
			// id, domain 입력
			String id = idDomain[0];
			System.out.println("아이디 = " + id);
			String domain = idDomain[1];
			System.out.println("도메인 = " + domain);
		}
	}




	
	
	///////////////////////////////////////////
	public static void main(String[] args) {
		new EmailCheck();
	}

}