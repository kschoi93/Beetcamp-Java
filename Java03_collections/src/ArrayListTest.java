import java.util.ArrayList;

public class ArrayListTest {

	public ArrayListTest() {
		ArrayList<String> list = new ArrayList<String>();
		
		list.add("이것은");
		list.add("ArrayList");
		list.add("예제");
		list.add("입니다");
		
		for(int i =0; i<list.size();i++) {
			System.out.println("ArrayList["+i+"]-->"+list.get(i));
		}

		System.out.println("ArrayList[toString]-->"+list.toString());
		System.out.println("ArrayList[indexOf]-->"+list.indexOf("예제"));
		System.out.println("ArrayList[All]-->"+list);
		
		System.out.println("-------------------------------------------");
		System.out.println("ArrayList[set]"+list.set(1, "인덱스 지정하여 수정,삭제"));
		System.out.println("ArrayList[remove]-->"+list.remove(0)); // 인덱스 삭제
		System.out.println("ArrayList[toString]-->"+list.toString());
		
	}

	public static void main(String[] args) {
		new ArrayListTest();

	}

}
