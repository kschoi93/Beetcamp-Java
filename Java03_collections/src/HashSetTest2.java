import java.util.HashSet;
import java.util.Iterator;

public class HashSetTest2 {
	public HashSetTest2() {
		int numData[] = {1,5,776,54,3,23,6,8556,4,5 ,1,4,5,4,5,};
		String strData[] = {"홍길동","이순신","세종대왕","홍길동","이순신","세종대왕","김두한"};
		
		HashSet<Integer> hs1 = new HashSet<Integer>();
		HashSet<String> hs2 = new HashSet<String>();
		
		for(int n : numData) { // numData 안의 값을 hs1에 넣는다
			hs1.add(n);
		}
		
		for(String n : strData) {
			hs2.add(n);
		}
		
		System.out.println("hs1의 객체수=" + hs1.size());
		System.out.println("hs2의 객체수=" + hs2.size());
		Iterator<Integer> i = hs1.iterator();
		
		while(i.hasNext()) {
			System.out.println("hs1--->"+i.next());
		}
		Iterator<String> s = hs2.iterator();
		while(s.hasNext()) {
			System.out.println("hs2--->"+s.next());
		}
	}
	
	public static void main(String[]args) {
		new HashSetTest2();
	}
}
