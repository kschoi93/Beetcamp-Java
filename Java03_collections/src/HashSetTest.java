import java.util.HashSet;
import java.util.Iterator;

public class HashSetTest {

	public HashSetTest() {
		// Set : 입력순서 유지하지 않음, 중복데이터 허용하지 않음.
		int numData[] = {10,50,30,40,20,50,60,30,40,40};
		String strData[] = {"홍길동","이순신","세종대왕","홍길동","이순신","세종대왕","김두한"};
		
		HashSet<Integer> hs1 = new HashSet<Integer>();
		HashSet<String> hs2 = new HashSet<String>();
		
		for(int n : numData) {
			hs1.add(n);
		}
		
		for(String n : strData) {
			hs2.add(n);
		}
		System.out.println("hs1의 객체수="+hs1.size());
		System.out.println("hs2의 객체수="+hs2.size());
		System.out.println(hs2.clone());
		Iterator<Integer> i = hs1.iterator();
		
		while(i.hasNext()) {
			int iTest = i.next();
			if(iTest == 10 || iTest == 20) {
				i.remove();
				System.out.println("이것은 삭제 돼부렀엉");
			}
			System.out.println("hs1 --->"+ iTest);

		}
		Iterator<String> s = hs2.iterator();
		while(s.hasNext()) {
			System.out.println("hs2 --->"+ s.next());
		}
	}

	public static void main(String[] args) {
		new HashSetTest();

	}

}
