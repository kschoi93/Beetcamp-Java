package book;

import java.util.HashMap;

public class Book {
	public static HashMap<Integer, BookListVO> tm = new HashMap<Integer, BookListVO>();
	public Book() {}
	
	public static void BookList() {
		tm.put(1, new BookListVO(1,"�޷���Ʈ�� �� ��ȭ��", "2021-01-09","������"));
		tm.put(2, new BookListVO(2,"�����ϴٴ� ����", "2021-01-05","�̷��"));
		tm.put(3, new BookListVO(3,"�ڹ��� ����", "2020-12-31","���γ�"));
		tm.put(4, new BookListVO(4,"Ʈ���� �ڸ��� 2021", "",""));
		tm.put(5, new BookListVO(5,"������ 8��Ģ", "2021-01-10","������"));
		tm.put(6, new BookListVO(6,"�޷���Ʈ�� �� ��ȭ��", "",""));
		tm.put(7, new BookListVO(7,"�ڹ��� ����", "2021-01-05","�����"));
		tm.put(8, new BookListVO(8,"�����ϱ�", "2020-12-31","�ڳ���"));
		tm.put(9, new BookListVO(9,"Do it! �ȵ���̵� ��", "",""));
		tm.put(10, new BookListVO(10,"�����ϱ� û���̴�", "",""));
		tm.put(11, new BookListVO(11,"���̾� ��ȭ���� ����", "2021-01-09","�����"));
		tm.put(12, new BookListVO(12,"����� �µ�", "2021-01-05","Mike"));
		tm.put(13, new BookListVO(13,"������ ������", "2020-12-31","�ְ��"));
		tm.put(14, new BookListVO(14,"�ڹ��� ����", "",""));
		tm.put(15, new BookListVO(15,"������ ����", "",""));
	}
}
