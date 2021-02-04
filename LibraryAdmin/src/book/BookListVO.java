package book;

public class BookListVO {
	int number;
	String bookName;
	String lendName;
	String lendDate;
	
	public BookListVO() {}
	
	public BookListVO(int number, String bookName,String lendDate, String lendName) {
		this.number = number;
		this.bookName = bookName;
		this.lendDate = lendDate;
		this.lendName = lendName;
	}
	
	public void BookPrn() {
		System.out.printf("| %-5s\t |%-35s\t| %-15s\t| %-5s\n",number, bookName,lendDate,lendName);

	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getLendName() {
		return lendName;
	}

	public void setLendName(String lendName) {
		this.lendName = lendName;
	}

	public String getLendDate() {
		return lendDate;
	}

	public void setLendDate(String lendDate) {
		this.lendDate = lendDate;
	}



}
