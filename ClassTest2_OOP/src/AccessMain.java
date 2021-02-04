// public 다른 팩키지, 같은 클래스, 모두 사용이 가능하다
// protected 같은 클래스와, 다른 팩키지가 상속되었을 때 사용 가능하다
// default 같은 패키지에서만 사용 가능하다
// private 같은 클래스에서만 사용 가능하다
/*
 class : public, (default)
 Class or Instance variable : protected, (default), private
 Local Variable : 사용하지 않는다
 */

import pac.Access2; // 다른 패키지에 있으면 import 해야한다
public class AccessMain{
	public AccessMain() {
	}
	public void start() {
		// 객체 생성
		Access1 a1 = new Access1();
		System.out.println("a1.userid="+a1.userid);
		System.out.println("a1.userid="+a1.userpwd);
		System.out.println(Access1.test);
//		System.out.println("a1.pitest"+a1.pitest); // private는 같은 클래스에서만 사용가능
		a1.printData();
		System.out.println("\n");
		
		// 객체 생성 // 다른 패키지를 상속받기 위해서는 import 해야한다
		Access2 a2 = new Access2(); // 팩키지가 다르다, 접근제어자가 default면 못불러온다
		//System.out.println("a2.num="+a2.num); // 변수에는 public을 거의 붙이지 않는다
		//System.out.println("a2.name="+a2.name); // 고로 아래 a2.getName처럼 하면된다
		//System.out.println(Access2.test); // static을 붙여도 안된다
		System.out.println("a2.getName="+a2.getName());
		System.out.println("a2.getNum="+a2.getNum()); // private여도 클래스를 만들면 가져올 수 있다
		a2.setNum(200);// 외부에서 접근해서 값을 바꿔서 밑에 다시 출력 할 수 있다.
		System.out.println("a2.setNum="+a2.getNum());
		a2.setNum(300);// num == 200 정해진 값일 때만 바뀌도록 정할 수도 있다.
		System.out.println("a2.setNum="+a2.getNum());
	}
	
	
	/////////////////////////////////////////
	public static void main(String[] args) {
		new AccessMain().start();
	}

}
