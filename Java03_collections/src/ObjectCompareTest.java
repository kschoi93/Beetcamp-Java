import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ObjectCompareTest {

	public ObjectCompareTest() {
		//객체내의 특정 필드로 정렬하기
		List<Member> lst = new ArrayList<Member>();
		
		lst.add(new Member(4,"홍길동","010-1111-1234","강원도 춘천시"));
		lst.add(new Member(3,"이순신","010-1234-6564","부산광역시"));
		lst.add(new Member(1,"장영실","010-5673-5454","경기도 수원시"));
		lst.add(new Member(2,"신사임당","010-8981-1794","전라북도 청주시"));
		lst.add(new Member(5,"김정희","010-6761-3024","광주광역시"));
		
		System.out.println("========== 정렬전 ===========");
		for(Member mem : lst) {
			mem.memberPrn();
		}
		System.out.println("========== 이름을 이용한 내림차순 정렬");
		//정렬하기
		Collections.sort(lst, new CompareNameDesc());
		for(Member mem : lst) {
			mem.memberPrn();
		}
		System.out.println("========== 이름을 이용한 오름차순 정렬");
		Collections.sort(lst, new CompareNameDescAsc());
		for(Member mem : lst) {
			mem.memberPrn();
		}
		System.out.println("========== 번호를 이용한 오름차순 정렬");
		Collections.sort(lst, new CompareNoAsc());
		for(Member mem : lst) {
			mem.memberPrn();
		}
		System.out.println("========== 번호를 이용한 내림차순 정렬");
		Collections.sort(lst, new CompareNoDesc());
		for(Member mem : lst) {
			mem.memberPrn();
		}
		
//		System.out.println(lst.size());
//		
//		
//		System.out.println(lst.equals(lst));
//		
//		lst.clear();
//		System.out.println(lst.size());
		
	}
	// 번호를 내림차순으로 정렬하는 내부 클래스
	class CompareNoDesc implements Comparator<Member>{
		public int compare(Member m1, Member m2) {
			return (m1.getNo() < m2.getNo())? 1 : (m1.getNo() == m2.getNo())? 0:-1;
		}
	}
	// 번호를 오름차순으로 정렬하는 내부 클래스
	class CompareNoAsc implements Comparator<Member>{
		public int compare(Member m1, Member m2) {
			// m1 : 작으면 -1, 같으면 0, 크면 1 return
			return (m1.getNo() < m2.getNo())? -1 : (m1.getNo() == m2.getNo())? 0:1;
		}
	}
	// 이름을 오름차순으로 정렬하는 내부 클래스
	class CompareNameDescAsc implements Comparator<Member>{
		// int의 리턴값은 음수, 0, 양수 -> 음수 : 오른쪽 객체가 크다 (m2), 0 : 같다, 양수 : 왼쪽이 크다 (m1)
		public int compare(Member m1, Member m2) {
			return  m1.getUsername().compareTo(m2.getUsername());
		}
	}
	// 이름을 내림차순으로 정렬하는 내부클래스
	// ** Comparator를 인터페이스를 상속받아 compare 메소드를 오버라이딩.
	class CompareNameDesc implements Comparator<Member>{
		// int의 리턴값은 음수, 0, 양수 -> 음수 : 오른쪽 객체가 크다 (m2), 0 : 같다, 양수 : 왼쪽이 크다 (m1)
		public int compare(Member m1, Member m2) {
			return m2.getUsername().compareTo(m1.getUsername()); // 1-0
		}
	}
	
	public static void main(String[] args) {
		new ObjectCompareTest();

	}

}
