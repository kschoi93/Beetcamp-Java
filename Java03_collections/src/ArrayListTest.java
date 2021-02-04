import java.util.ArrayList;

public class ArrayListTest {

	public ArrayListTest() {
		ArrayList<String> list = new ArrayList<String>();
		
		list.add("�̰���");
		list.add("ArrayList");
		list.add("����");
		list.add("�Դϴ�");
		
		for(int i =0; i<list.size();i++) {
			System.out.println("ArrayList["+i+"]-->"+list.get(i));
		}

		System.out.println("ArrayList[toString]-->"+list.toString());
		System.out.println("ArrayList[indexOf]-->"+list.indexOf("����"));
		System.out.println("ArrayList[All]-->"+list);
		
		System.out.println("-------------------------------------------");
		System.out.println("ArrayList[set]"+list.set(1, "�ε��� �����Ͽ� ����,����"));
		System.out.println("ArrayList[remove]-->"+list.remove(0)); // �ε��� ����
		System.out.println("ArrayList[toString]-->"+list.toString());
		
	}

	public static void main(String[] args) {
		new ArrayListTest();

	}

}
