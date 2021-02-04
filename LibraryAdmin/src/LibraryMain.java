import java.util.Iterator;

import java.util.Scanner;
import java.util.Set;

import attach.DatabaseData;
import attach.DatabaseVO;
import book.Book;
import book.BookListVO;

public class LibraryMain {
	Scanner scan = new Scanner(System.in);
	boolean retry = true;
	public LibraryMain(){
		DatabaseData.setDbList();
		Book.BookList();
		while(true) {
			try {
				// 로그인, 로그아웃 체크
				if(retry) {
					new Login();
					retry = false;
				}
				// 3회 틀릴경우 프로그램 종료
				if(Login.check == false) {
					System.out.println("| 비밀번호가 3회 틀려 프로그램이 종료됩니다");
					System.out.println("| =======================================================================================");
					break;
				}	
				
				// 입력값에 의해 출력
				String num = Input();
				// 1. 회원목록
				if(num.equals("1")) { // 회원관리 등록, 목록, 정보처리
					String select = DataScanner("| [1.회원목록, 2.회원등록, 3.회원검색, 4.정보수정, 5.삭제, 6.취소]");
					if(select.equals("1")) {DatabasePrint();}
					else if(select.equals("2")) {DatabaseInput();}
					else if(select.equals("3")) {DatabaseCheck();}
					else if(select.equals("4")) {DataEdit();} 
					else if(select.equals("5")) {DataDelete();}
					else if(select.equals("6")) {continue;}
				} else if(num.equals("2")) { // 도서대여 목록 및 수정
					String select = DataScanner("| [1.도서목록, 2.도서등록 3.도서별 대여 확인 4.대여수정, 5.삭제, 6.취소]");
					if(select.equals("1")) {BookPrint();}
					else if(select.equals("2")) {BookInput();}
					else if(select.equals("3")) {BookCheck();}
					else if(select.equals("4")) {BookListEdit();}
					else if(select.equals("5")) {BookDelete();}
					else if(select.equals("6")) {continue;}
				} else if(num.equals("3")) { // 로그아웃 및 재 로그인
					if(retry().equals("y")) retry = true;
					else break;
				} else if(num.equals("4")) { break;	} // 종료
				else {
					System.out.println("| 해당되는 번호가 없습니다.");
					continue;
				}
			}catch(Exception e) {
				System.out.println("| 잘못된 입력은 용납하지 않습니다!!\n"
						+ "| 프로그램을 다시 시작합니다");
			}
		}
	}
///////////////////////////////////회원정보 구간 시작///////////////////////////////////
	// 회원목록 출력
	public void DatabasePrint() {
		System.out.println("| ==============================================================================================");
		System.out.println("| 번호\t| 이름\t\t| 전화번호\t\t| 주소\t\t\t\t| 주민번호");
		System.out.println("| ==============================================================================================");
		Set<Integer> keyList = DatabaseData.hm.keySet();
		Iterator<Integer> i = keyList.iterator();
		while(i.hasNext()) {
			DatabaseVO vo = DatabaseData.hm.get(i.next());
			System.out.printf("| %-5s\t| %-7s\t| %-15s\t| %-18s\t| %-15s\n",vo.getNumber(),vo.getName(),
					vo.getTel(),vo.getAdress(),vo.getRrNum());
		}
		System.out.println("| ==============================================================================================");
		
	}
	
	// 회원등록 데이터 베이스 입력
	public void DatabaseInput() {
		String number;
		// 동록되어 있는 번호면 알려줘
		replay : while(true) {
			number = DataScanner("| 번호");
			Set<Integer> set = DatabaseData.hm.keySet();
			Iterator<Integer> i = set.iterator();	
			while(i.hasNext()) { // 등록되어 있는 번호는 다시 적게하시오
				DatabaseVO dataNumber = DatabaseData.hm.get(i.next());
				if(dataNumber.getNumber() == Integer.parseInt(number)) {
					System.out.println("| 현재 등록되어 있는 번호 입니다");
					continue replay;
				} 
			}
			try {if(!(Integer.parseInt(number)>0)) {} // 숫자가 아닌 문자 입력확인
			} catch(NumberFormatException n) {
				System.out.println("| 숫자 정수를 입력해주세요");
				continue replay; 
			}
			break;
		}
		String name = DataScanner("| 이름");
		String tel = DataScanner("| 전화번호"); 
		String adress = DataScanner("| 주소");
		String rrNum = DataScanner("| 주민번호");
		int num = Integer.parseInt(number);
		DatabaseData.hm.put(num, new DatabaseVO(num, name,tel,adress,rrNum));
	}
	
	// 회원 검색
	public void DatabaseCheck() {
		System.out.println("| ==============================================================================================");
		String check = DataScanner("| 확인할 회원 이름");
		Set<Integer> keyset = DatabaseData.hm.keySet();
		Iterator<Integer> key = keyset.iterator();
		System.out.println("| ==============================================================================================");
		System.out.println("| 번호\t| 이름\t\t| 전화번호\t\t| 주소\t\t\t\t| 주민번호");
		System.out.println("| ==============================================================================================");
		while(key.hasNext()) {
			DatabaseVO vo = DatabaseData.hm.get(key.next());
			String dataName = vo.getName();
			
			if(dataName.indexOf(check)!=-1){
				System.out.printf("| %-5s\t| %-7s\t| %-15s\t| %-18s\t| %s\n",vo.getNumber(),vo.getName(),
						vo.getTel(),vo.getAdress(),vo.getRrNum());
			}
		}
		System.out.println("| ==============================================================================================");
	}
	
	// 회원 수정
	public void DataEdit() {
		String databaseNum = DataScanner("| 수정할 회원번호");
		DatabaseVO vo = DatabaseData.hm.get(Integer.parseInt(databaseNum));
		if(vo == null) {
			System.out.println("| 존재하지 않는 회원 입니다");
		} else {
			System.out.println("| ==============================================================================================");
			String subMenu = DataScanner("| 수정할 항목[1.전화번호, 2.주소]");
			if(subMenu.equals("1")) {
				while(true) {
					String phone = DataScanner("| 전화번호");
					if(phone.indexOf("-")!=-1 && phone.length()>12) {
						vo.setTel(phone);
						break;
					} else { System.out.println("| 전화번호를 정확히 입력하시기 바랍니다");
						continue;
					}
				}
			} else if(subMenu.equals("2")) {
				String rrNum = DataScanner("| 주소");
				vo.setAdress(rrNum);
			}
		}
	}
	
	// 데이터 삭제
	public void DataDelete() {
			String data = DataScanner("| 삭제할 회원번호");
			DatabaseData.hm.remove(Integer.parseInt(data));
		}
		

//////////////////////////////회원정보 구간 마지막 ////////////////////////////////
	
///////////////////////////////도서목록 구간 시작 /////////////////////////////////
	// 도서 목록 출력
	public void BookPrint() {
		Set<Integer> set = Book.tm.keySet();
		Iterator<Integer> i = set.iterator();
		System.out.println("| ==============================================================================================");
		System.out.println("| 번호\t | 도서\t\t\t\t\t\t| 대여일자\t\t| 대여자");
		System.out.println("| ==============================================================================================");
		while(i.hasNext()) {
			BookListVO bl = Book.tm.get(i.next());
			bl.BookPrn();
		}
		System.out.println("| ==============================================================================================");
	}
	
	// 도서 등록
	public void BookInput() {
		String number;
		
		// 동록되어 있는 번호면 알려줘
		replay2 : while(true) {
			number = DataScanner("| 번호");
			Set<Integer> set = Book.tm.keySet();
			Iterator<Integer> i = set.iterator();	
			while(i.hasNext()) { // 등록되어 있는 번호는 다시 적게하시오
				BookListVO list = Book.tm.get(i.next());
				if(list.getNumber() == Integer.parseInt(number)) {
					System.out.println("| 현재 등록되어 있는 번호 입니다");
					continue replay2;
				} 
			}
			try {if(!(Integer.parseInt(number)>0)) {} // 숫자가 아닌 문자 입력확인
			} catch(NumberFormatException n) {
				System.out.println("| 숫자 정수를 입력해주세요");
				continue replay2; 
			}
			break;
		}
		String name = DataScanner("| 도서");
		String lend = DataScanner("| 대여일자"); 
		String rrNum = DataScanner("| 대여자");
		int num = Integer.parseInt(number);
		Book.tm.put(num, new BookListVO(num, name, lend, rrNum));
	}
	
	// 도서 목록 보유여부 확인
	public void BookCheck() {
		System.out.println("| ==============================================================================================");
		String check = DataScanner("| 확인할 책 이름 입력");
		Set<Integer> keyset = Book.tm.keySet();
		Iterator<Integer> key = keyset.iterator();
		System.out.println("| ==============================================================================================");
		System.out.println("| 번호\t | 도서\t\t\t\t\t\t| 대여일자\t\t| 대여자");
		System.out.println("| ==============================================================================================");
		while(key.hasNext()) {
			BookListVO vo = Book.tm.get(key.next());
			String bookName = vo.getBookName();
			
			if(bookName.indexOf(check)!=-1){
				System.out.printf("| %-5s\t| %-35s\t| %-15s\t| %-5s\n",vo.getNumber(),vo.getBookName(),vo.getLendDate(),vo.getLendName());
				
			}
		}
		System.out.println("| ==============================================================================================");
	}
	
	// 도서 목록 수정
	public void BookListEdit() {
		System.out.println("| ==============================================================================================");
		String ListEdit = DataScanner("| 수정할 대여 목록 번호");
		BookListVO vo = Book.tm.get(Integer.parseInt(ListEdit));
		if(vo == null) {
			System.out.println("| 존재하지 않는 도서 입니다");
		} else {
			System.out.println("| 수정할 항목[대여일자, 대여자]");
			final String data = DataScanner("| 대여일자");
				vo.setLendDate(data);
			final String name = DataScanner("| 대여자");
				vo.setLendName(name);
		}
	}	
		
	// 도서 목록 삭제
	public void BookDelete() {
		String del = DataScanner("| 삭제할 책 번호");
		Book.tm.remove(Integer.parseInt(del));
	}
	
	
/////////////////////////////////도서목록 구간 마지막 //////////////////////////////
	

	
///////////////////////////////// 공통 메소드 /////////////////////////////////////
	
	// 데이터 입력 구간
	public String DataScanner(String msg){
		System.out.print(msg+" = ");
		return scan.nextLine();
	}

	// 로그아웃 후 재로그인 여부 확인
	public String retry(){
		System.out.println("| 로그아웃 되었습니다.");
		System.out.print("| 재로그인 하시겠습니까? [y] =");
		return scan.nextLine();
	}
	
	// 도서관리 프로그램 메뉴
	public String Input(){ 
		System.out.print("| [1.회원관리, 2.도서관리, 3.로그아웃, 4.종료]=");
		return scan.nextLine();
	}
///////////////////////////////////////////////////////////////////////////////
	// 메인메소드
	public static void main(String[] args) {
		new LibraryMain();
		System.out.println("| 프로그램이 종료됩니다");
	}
}
