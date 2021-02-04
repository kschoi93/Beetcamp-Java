package pac;

public class Access2 {
	private int num = 100;
	String name = "홍길동";
	static String test = "Access2.static";
	public Access2() {
		
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	// getter, setter
	public int getNum() {
		return this.num;
	}
	public void setNum(int num) {
		if(num==200) {
			this.num = num;
		}
	}
}
