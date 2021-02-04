
public class ATM implements Runnable{
	private int money = 20000; // 통장잔액
	
	public ATM() {
		
	}
	//스레드 처리 - 출금
	// synchronized : 스레드의 동기화 (스레드가 구현되는 동안 다른 스레드는 대기하고 있어야 한다.)
	// 1. run() 메소드에 반환형 왼쪽에 synchronized 키 추가
//	public synchronized void run() {
	public void run() {
		//2. run() 메소드 실행부에 동기화 방법
		synchronized(this) {
			for(int i = 1; i<=10; i++) {
				getCash(1000);
				//동기화 및 동기화 해제
				if(money%2000==0) {
					// 동기화 해제
					try {
						this.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
					// 동기화
					this.notify(); // 동기화 해제 했으면 다시 실행 해줘야 한다
				}
			}
		}
	}
	
	// 출금처리 메소드
	public void getCash(int cash) {
		if(money>0) {
			money -=cash;
			System.out.println(Thread.currentThread().getName()+"잔액-->"+money);
		} else {
			System.out.println("잔액이 부족합니다");
		}
	}
	
	public static void main(String[] args) {
		ATM atm = new ATM();
		
		Thread t1 = new Thread(atm,"mother"); // 엄마 스레드
		Thread t2 = new Thread(atm,"son"); // 아들 스레드
		
		t1.start();
		t2.start();
	}

}
