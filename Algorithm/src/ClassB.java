class ClassA{
	public int getValue() {
		int value=0;
		boolean setting = true;
		String title="Hello";
		if(value ==0 || (setting && title == "Hello")) {return 1;}
		if(value ==1 & title.equals("Hello")) {return 2;}
		return 0;
	}
}

public class ClassB {
	public static void main(String[] args) {
		ClassA a = new ClassA();
		a.getValue();
	}
}
