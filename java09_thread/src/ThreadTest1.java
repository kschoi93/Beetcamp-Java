
// Thread ������ ���μ����� �ϳ��� ���� �����ϳ� �����带 ���� ������ �ð��� �ο��Ͽ� �������� ���μ����� ����� �� �ֵ��� �Ѵ�.
// 1. Thread class extends
public class ThreadTest1  extends Thread{
	String title;
	public ThreadTest1(String title) {
		this.title = title;
	}
	public ThreadTest1() {}
	//2. run()�޼ҵ� �������̵�
	public void run() {
		for(int i=1;;i++) {
			System.out.println(title+"="+i);
			try {Thread.sleep(500);}catch(Exception e) {}
		}
	}
	public static void main(String[] args) {
		ThreadTest1 tt1 = new ThreadTest1("ù��° ������");
		ThreadTest1 tt2 = new ThreadTest1("�ι�° ������");
		//3. ������ ���
		tt1.start();
		tt2.start();
	}

}
