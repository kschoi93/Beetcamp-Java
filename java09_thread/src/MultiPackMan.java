
public class MultiPackMan {

	public MultiPackMan() {
		
	}
	
	public static void main(String[] args) {
		PackMantest p1 = new PackMantest(1,1,500,500);
		PackMantest p2 = new PackMantest(501,1,500,500);
		
		
		Thread t1 = new Thread(p1);
		Thread t2 = new Thread(p2);
		
		t1.start();
		t2.start();
		
	}

}
