import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapTest {
	public TreeMapTest() {
		//TreeMap : Key, value를 가진다. key기준으로 정렬한다
		TreeMap<String,Member> ht = new TreeMap<String,Member>();
		Member m1 = new Member(100,"홍길동", "010-1111-2222", "서울시 중구");
		ht.put("홍길동", m1);
		ht.put("세종대왕", new Member(200,"세종대왕","010-2222-3333","서울시 영등포구"));
		ht.put("이순신",new Member(300,"이순신","010-7777-8888","서울시 남구"));
		ht.put("김정희", new Member(400, "김정희","010-5555-6666","서울시 종로구"));
		ht.put("세종대왕2", new Member(500,"세종대왕2","010-2222-3333","서울시 영등포구"));
		ht.put("이순신2",new Member(600,"이순신2","010-7777-8888","서울시 남구"));
		ht.put("김정희2", new Member(700, "김정희2","010-5555-6666","서울시 종로구"));
		
		Member m = ht.get("이순신");
		m.memberPrn();
		System.out.println("------------KeySet 으로 목록구하기-----------------");
		Set<String> set =ht.keySet();
		Iterator<String> ii = set.iterator();
		while(ii.hasNext()) {
			Member mm = ht.get(ii.next());
			mm.memberPrn();
		}
		System.out.println("---------------- desendingKeySet()-----");
		NavigableSet<String> descKey = ht.descendingKeySet();
		Iterator<String> iii = descKey.iterator();
		while(iii.hasNext()) {
			Member mm = ht.get(iii.next());
			mm.memberPrn();
		}
		System.out.println("------------------Value를 이용한 목록구하기");
		Collection<Member> value = ht.values();
		Iterator<Member> iiii = value.iterator();
		while(iiii.hasNext()) {
			Member mm = iiii.next();
			mm.memberPrn();
		}
	}
	
	public static void main(String[] args) {
		new TreeMapTest();
	}
}
