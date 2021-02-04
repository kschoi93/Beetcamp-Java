package book;

import java.util.HashMap;

public class Book {
	public static HashMap<Integer, BookListVO> tm = new HashMap<Integer, BookListVO>();
	public Book() {}
	
	public static void BookList() {
		tm.put(1, new BookListVO(1,"달러구트의 꿈 백화점", "2021-01-09","이지은"));
		tm.put(2, new BookListVO(2,"공정하다는 착각", "2021-01-05","이루다"));
		tm.put(3, new BookListVO(3,"자바의 정석", "2020-12-31","유인나"));
		tm.put(4, new BookListVO(4,"트렌드 코리아 2021", "",""));
		tm.put(5, new BookListVO(5,"광고의 8원칙", "2021-01-10","신혜성"));
		tm.put(6, new BookListVO(6,"달러구트의 꿈 백화점", "",""));
		tm.put(7, new BookListVO(7,"자바의 정석", "2021-01-05","이재용"));
		tm.put(8, new BookListVO(8,"난중일기", "2020-12-31","박나래"));
		tm.put(9, new BookListVO(9,"Do it! 안드로이드 앱", "",""));
		tm.put(10, new BookListVO(10,"아프니까 청춘이다", "",""));
		tm.put(11, new BookListVO(11,"나미야 잡화점의 기적", "2021-01-09","정약용"));
		tm.put(12, new BookListVO(12,"사랑의 온도", "2021-01-05","Mike"));
		tm.put(13, new BookListVO(13,"현명한 투자자", "2020-12-31","최경식"));
		tm.put(14, new BookListVO(14,"자바의 정석", "",""));
		tm.put(15, new BookListVO(15,"월가의 영웅", "",""));
	}
}
