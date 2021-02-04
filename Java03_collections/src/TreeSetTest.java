import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetTest {

	public TreeSetTest() {
		//TreeSet : 중복허용하지 않음, 입력순서 유지하지 않음, 크기 순서대로 정렬됨
		int numData[] = {10,50,30,40,20,50,60,30,40,40};
		String strData[] = {"홍길동","이순신","세종대왕","홍길동","이순신","세종대왕","김두한"};
		TreeSet<Integer> ts = new TreeSet<Integer>();
		for(int n : numData) {
			ts.add(n);
		}
		TreeSet<String> ts2 = new TreeSet<String>();
		for(String name : strData) {
			ts2.add(name);
		}
		
		Iterator<Integer> ii = ts.iterator(); // 오름차순
		while(ii.hasNext()) {
			System.out.println("ts-->"+ii.next());
		}
		Iterator<Integer> iii = ts.descendingIterator(); // 내림차순
		while(iii.hasNext()) {
			System.out.println("tes---->"+iii.next());
		}
		Iterator<String> ss = ts2.iterator();
		while(ss.hasNext()) {
			System.out.println("ss-->"+ss.next());
		}
	}

	public static void main(String[] args) {
		new TreeSetTest();

	}

}
