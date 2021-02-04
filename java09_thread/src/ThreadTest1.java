
// Thread 원래의 프로세스는 하나만 실행 가능하나 스레드를 통해 각각의 시간을 부여하여 여러개의 프로세스가 실행될 수 있도록 한다.
// 1. Thread class extends
public class ThreadTest1  extends Thread{
	String title;
	public ThreadTest1(String title) {
		this.title = title;
	}
	public ThreadTest1() {}
	//2. run()메소드 오버라이딩
	public void run() {
		for(int i=1;;i++) {
			System.out.println(title+"="+i);
			try {Thread.sleep(500);}catch(Exception e) {}
		}
	}
	public static void main(String[] args) {
		ThreadTest1 tt1 = new ThreadTest1("첫번째 스레드");
		ThreadTest1 tt2 = new ThreadTest1("두번째 스레드");
		//3. 스레드 등록
		tt1.start();
		tt2.start();
	}

}
