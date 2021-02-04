import java.util.LinkedList;

public class LinkedListTest {

	public LinkedListTest() {
		// List 
		// Queue : 객체를 한쪽에서 추가하고 다른쪽에서 제거
		// deque : 객체를 양쪽에서 추가, 제거 할 수 있다
		// 객체 get() 하면 컬렉션에서 객체가 지워진다
		LinkedList<String> ll = new LinkedList<String>();
		
		//데이터 추가
		ll.offer("홓길동");
		ll.offer("세종대왕");
		ll.offer("이순신");
		ll.offer("김정희");
		ll.offerFirst("Hong");
		
		// 제일 마지막 객체를 pop 하고싶다
		System.out.println(ll.pollLast());
		System.out.println(ll.get(1)); // 객체가 지워지지 않는다
		
		while(!ll.isEmpty()) { // 컬렉션이 비어있는지 확인 후 true, false 리턴
			System.out.println(ll.pop());
		}
		
		//객체수
		System.out.println("size()->"+ ll.size());
		
		for(int i =0; i<=ll.size(); i++) {
			System.out.println(ll);
			
		}
	}

	public static void main(String[] args) {
		new LinkedListTest();
	}

}
