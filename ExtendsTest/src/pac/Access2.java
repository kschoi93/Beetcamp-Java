package pac;

public class Access2 {
	int i = 100;
	String acTest = "Test1";
	private String acTest1 = "Test2";
	
	public Access2() {
		System.out.println("\nAccess2 Print Test");
	}
	
	public void privateTest() {
		System.out.println("Access2 privateTest"+acTest + " / " + acTest1);
	}

	public int getNum() {
		return this.i;
	}
	
	public void setNum(int i) {
		this.i = i;
	}
}
