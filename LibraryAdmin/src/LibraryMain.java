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
				// �α���, �α׾ƿ� üũ
				if(retry) {
					new Login();
					retry = false;
				}
				// 3ȸ Ʋ����� ���α׷� ����
				if(Login.check == false) {
					System.out.println("| ��й�ȣ�� 3ȸ Ʋ�� ���α׷��� ����˴ϴ�");
					System.out.println("| =======================================================================================");
					break;
				}	
				
				// �Է°��� ���� ���
				String num = Input();
				// 1. ȸ�����
				if(num.equals("1")) { // ȸ������ ���, ���, ����ó��
					String select = DataScanner("| [1.ȸ�����, 2.ȸ�����, 3.ȸ���˻�, 4.��������, 5.����, 6.���]");
					if(select.equals("1")) {DatabasePrint();}
					else if(select.equals("2")) {DatabaseInput();}
					else if(select.equals("3")) {DatabaseCheck();}
					else if(select.equals("4")) {DataEdit();} 
					else if(select.equals("5")) {DataDelete();}
					else if(select.equals("6")) {continue;}
				} else if(num.equals("2")) { // �����뿩 ��� �� ����
					String select = DataScanner("| [1.�������, 2.������� 3.������ �뿩 Ȯ�� 4.�뿩����, 5.����, 6.���]");
					if(select.equals("1")) {BookPrint();}
					else if(select.equals("2")) {BookInput();}
					else if(select.equals("3")) {BookCheck();}
					else if(select.equals("4")) {BookListEdit();}
					else if(select.equals("5")) {BookDelete();}
					else if(select.equals("6")) {continue;}
				} else if(num.equals("3")) { // �α׾ƿ� �� �� �α���
					if(retry().equals("y")) retry = true;
					else break;
				} else if(num.equals("4")) { break;	} // ����
				else {
					System.out.println("| �ش�Ǵ� ��ȣ�� �����ϴ�.");
					continue;
				}
			}catch(Exception e) {
				System.out.println("| �߸��� �Է��� �볳���� �ʽ��ϴ�!!\n"
						+ "| ���α׷��� �ٽ� �����մϴ�");
			}
		}
	}
///////////////////////////////////ȸ������ ���� ����///////////////////////////////////
	// ȸ����� ���
	public void DatabasePrint() {
		System.out.println("| ==============================================================================================");
		System.out.println("| ��ȣ\t| �̸�\t\t| ��ȭ��ȣ\t\t| �ּ�\t\t\t\t| �ֹι�ȣ");
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
	
	// ȸ����� ������ ���̽� �Է�
	public void DatabaseInput() {
		String number;
		// ���ϵǾ� �ִ� ��ȣ�� �˷���
		replay : while(true) {
			number = DataScanner("| ��ȣ");
			Set<Integer> set = DatabaseData.hm.keySet();
			Iterator<Integer> i = set.iterator();	
			while(i.hasNext()) { // ��ϵǾ� �ִ� ��ȣ�� �ٽ� �����Ͻÿ�
				DatabaseVO dataNumber = DatabaseData.hm.get(i.next());
				if(dataNumber.getNumber() == Integer.parseInt(number)) {
					System.out.println("| ���� ��ϵǾ� �ִ� ��ȣ �Դϴ�");
					continue replay;
				} 
			}
			try {if(!(Integer.parseInt(number)>0)) {} // ���ڰ� �ƴ� ���� �Է�Ȯ��
			} catch(NumberFormatException n) {
				System.out.println("| ���� ������ �Է����ּ���");
				continue replay; 
			}
			break;
		}
		String name = DataScanner("| �̸�");
		String tel = DataScanner("| ��ȭ��ȣ"); 
		String adress = DataScanner("| �ּ�");
		String rrNum = DataScanner("| �ֹι�ȣ");
		int num = Integer.parseInt(number);
		DatabaseData.hm.put(num, new DatabaseVO(num, name,tel,adress,rrNum));
	}
	
	// ȸ�� �˻�
	public void DatabaseCheck() {
		System.out.println("| ==============================================================================================");
		String check = DataScanner("| Ȯ���� ȸ�� �̸�");
		Set<Integer> keyset = DatabaseData.hm.keySet();
		Iterator<Integer> key = keyset.iterator();
		System.out.println("| ==============================================================================================");
		System.out.println("| ��ȣ\t| �̸�\t\t| ��ȭ��ȣ\t\t| �ּ�\t\t\t\t| �ֹι�ȣ");
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
	
	// ȸ�� ����
	public void DataEdit() {
		String databaseNum = DataScanner("| ������ ȸ����ȣ");
		DatabaseVO vo = DatabaseData.hm.get(Integer.parseInt(databaseNum));
		if(vo == null) {
			System.out.println("| �������� �ʴ� ȸ�� �Դϴ�");
		} else {
			System.out.println("| ==============================================================================================");
			String subMenu = DataScanner("| ������ �׸�[1.��ȭ��ȣ, 2.�ּ�]");
			if(subMenu.equals("1")) {
				while(true) {
					String phone = DataScanner("| ��ȭ��ȣ");
					if(phone.indexOf("-")!=-1 && phone.length()>12) {
						vo.setTel(phone);
						break;
					} else { System.out.println("| ��ȭ��ȣ�� ��Ȯ�� �Է��Ͻñ� �ٶ��ϴ�");
						continue;
					}
				}
			} else if(subMenu.equals("2")) {
				String rrNum = DataScanner("| �ּ�");
				vo.setAdress(rrNum);
			}
		}
	}
	
	// ������ ����
	public void DataDelete() {
			String data = DataScanner("| ������ ȸ����ȣ");
			DatabaseData.hm.remove(Integer.parseInt(data));
		}
		

//////////////////////////////ȸ������ ���� ������ ////////////////////////////////
	
///////////////////////////////������� ���� ���� /////////////////////////////////
	// ���� ��� ���
	public void BookPrint() {
		Set<Integer> set = Book.tm.keySet();
		Iterator<Integer> i = set.iterator();
		System.out.println("| ==============================================================================================");
		System.out.println("| ��ȣ\t | ����\t\t\t\t\t\t| �뿩����\t\t| �뿩��");
		System.out.println("| ==============================================================================================");
		while(i.hasNext()) {
			BookListVO bl = Book.tm.get(i.next());
			bl.BookPrn();
		}
		System.out.println("| ==============================================================================================");
	}
	
	// ���� ���
	public void BookInput() {
		String number;
		
		// ���ϵǾ� �ִ� ��ȣ�� �˷���
		replay2 : while(true) {
			number = DataScanner("| ��ȣ");
			Set<Integer> set = Book.tm.keySet();
			Iterator<Integer> i = set.iterator();	
			while(i.hasNext()) { // ��ϵǾ� �ִ� ��ȣ�� �ٽ� �����Ͻÿ�
				BookListVO list = Book.tm.get(i.next());
				if(list.getNumber() == Integer.parseInt(number)) {
					System.out.println("| ���� ��ϵǾ� �ִ� ��ȣ �Դϴ�");
					continue replay2;
				} 
			}
			try {if(!(Integer.parseInt(number)>0)) {} // ���ڰ� �ƴ� ���� �Է�Ȯ��
			} catch(NumberFormatException n) {
				System.out.println("| ���� ������ �Է����ּ���");
				continue replay2; 
			}
			break;
		}
		String name = DataScanner("| ����");
		String lend = DataScanner("| �뿩����"); 
		String rrNum = DataScanner("| �뿩��");
		int num = Integer.parseInt(number);
		Book.tm.put(num, new BookListVO(num, name, lend, rrNum));
	}
	
	// ���� ��� �������� Ȯ��
	public void BookCheck() {
		System.out.println("| ==============================================================================================");
		String check = DataScanner("| Ȯ���� å �̸� �Է�");
		Set<Integer> keyset = Book.tm.keySet();
		Iterator<Integer> key = keyset.iterator();
		System.out.println("| ==============================================================================================");
		System.out.println("| ��ȣ\t | ����\t\t\t\t\t\t| �뿩����\t\t| �뿩��");
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
	
	// ���� ��� ����
	public void BookListEdit() {
		System.out.println("| ==============================================================================================");
		String ListEdit = DataScanner("| ������ �뿩 ��� ��ȣ");
		BookListVO vo = Book.tm.get(Integer.parseInt(ListEdit));
		if(vo == null) {
			System.out.println("| �������� �ʴ� ���� �Դϴ�");
		} else {
			System.out.println("| ������ �׸�[�뿩����, �뿩��]");
			final String data = DataScanner("| �뿩����");
				vo.setLendDate(data);
			final String name = DataScanner("| �뿩��");
				vo.setLendName(name);
		}
	}	
		
	// ���� ��� ����
	public void BookDelete() {
		String del = DataScanner("| ������ å ��ȣ");
		Book.tm.remove(Integer.parseInt(del));
	}
	
	
/////////////////////////////////������� ���� ������ //////////////////////////////
	

	
///////////////////////////////// ���� �޼ҵ� /////////////////////////////////////
	
	// ������ �Է� ����
	public String DataScanner(String msg){
		System.out.print(msg+" = ");
		return scan.nextLine();
	}

	// �α׾ƿ� �� ��α��� ���� Ȯ��
	public String retry(){
		System.out.println("| �α׾ƿ� �Ǿ����ϴ�.");
		System.out.print("| ��α��� �Ͻðڽ��ϱ�? [y] =");
		return scan.nextLine();
	}
	
	// �������� ���α׷� �޴�
	public String Input(){ 
		System.out.print("| [1.ȸ������, 2.��������, 3.�α׾ƿ�, 4.����]=");
		return scan.nextLine();
	}
///////////////////////////////////////////////////////////////////////////////
	// ���θ޼ҵ�
	public static void main(String[] args) {
		new LibraryMain();
		System.out.println("| ���α׷��� ����˴ϴ�");
	}
}
