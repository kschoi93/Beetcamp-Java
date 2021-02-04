package attach;

public class DatabaseVO {
	private int number;
	private String name;
	private String tel;
	private String adress;
	private String rrNum;
	
	public DatabaseVO() {}
	
	public DatabaseVO(int number, String name, String tel, String adress, String rrNum) {
		this.number = number;
		this.name = name;
		this.tel = tel;
		this.adress = adress;
		this.rrNum = rrNum;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getRrNum() {
		return rrNum;
	}

	public void setRrNum(String rrNum) {
		this.rrNum = rrNum;
	}


}
