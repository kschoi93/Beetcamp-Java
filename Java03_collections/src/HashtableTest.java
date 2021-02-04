import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

public class HashtableTest {
	public HashtableTest() {}
	public void start() {
		//Key, Value를 가진다.
		//Hashtable : 동기화 지원
		//Hashmap : 동기화 지원하지 않음
		
		// 회원 정보 4명을 hashtable에 저장
		Hashtable<String,Member> ht = new Hashtable<String,Member>();
		Member m1 = new Member(100,"홍길동", "010-1111-2222", "서울시 중구");
		ht.put("홍길동", m1);
		ht.put("세종대왕", new Member(200,"세종대왕","010-2222-3333","서울시 영등포구"));
		ht.put("이순신",new Member(300,"이순신","010-7777-8888","서울시 남구"));
		ht.put("김정희", new Member(400, "김정희","010-5555-6666","서울시 종로구"));
		ht.put("세종대왕2", new Member(500,"세종대왕","010-2222-3333","서울시 영등포구"));
		ht.put("이순신2",new Member(600,"이순신","010-7777-8888","서울시 남구"));
		ht.put("김정희2", new Member(700, "김정희","010-5555-6666","서울시 종로구"));
		
		// key를 기준으로 가져오기 : key 값을 알고 있을 경우
		Member vo = ht.get("세종대왕");
		vo.memberPrn();
		System.out.println(ht.get("이순신"));
		
		//----------------- Map의 key목록을 구하기 : set으로 리턴된다.
		
		Set<String> keyList= ht.keySet();
		
		Object[] obj = keyList.toArray();
		for(Object o :obj) {
			System.out.println(o);
		}
		
		System.out.println("000000000000000000000000000000");
		Iterator<String> ii = keyList.iterator();
		while(ii.hasNext()) {
//			System.out.println(ii.next());
			Member v = ht.get(ii.next());
			v.memberPrn();
		}
		System.out.println("--------------- 전체 value 목록을 얻어오기");
		
		Collection<Member> value = ht.values();
		Iterator<Member> iii = value.iterator();
		
		while(iii.hasNext()) {
			Member vvv = iii.next();
			vvv.memberPrn();
		}
		
//		Member m = new Member();
//		System.out.println(m.getNo());
//		System.out.println(m.getAddr());
//		System.out.println(m.getTel());
		
	}
	public static void main(String[] args) {
		new HashtableTest().start();
	}
}
