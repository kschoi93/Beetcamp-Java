class Test{}
public class Ex1 extends Test{
	
	public static void main(String[] args) {
		Test t1 = new Test();
		Ex1 e1 = new Ex1();
		Object o1=(Object)t1;
		Test t2=(Test)e1;
		System.out.println(t2);
	}
}