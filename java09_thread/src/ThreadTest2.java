//1. runable ���

public class ThreadTest2 implements Runnable{
	String title;
	public ThreadTest2() {
		
	}
	public ThreadTest2(String title) {
		this.title = title;
	}
	//2. ������ ���� �ڵ带 run()�� �����Ѵ�
	public void run() {
		int i=1;
		while(true) {
			System.out.printf("%s--->i=%d\n",title,i++);
			try {Thread.sleep(2000);}catch(Exception e) {}
		}
	}
	
	public static void main(String[] args) {
		ThreadTest2 tt1= new ThreadTest2("ù��° ������");
		ThreadTest2 tt2= new ThreadTest2("�ι�° ������");
		ThreadTest2 tt3= new ThreadTest2("����° ������");
		
		Thread t1 = new Thread(tt1);
		Thread t2 = new Thread(tt2);
		Thread t3 = new Thread(tt3);
		
		t1.start();
		t2.start();
		t3.start();
	}

}
