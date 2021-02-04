class PrivateChild extends PrivateParent{
	PrivateChild(){
		//private 접근제어자가 있는 멤버변수는 상속되지 않는다
//		System.out.println("num="+num);
		setNum();
	}
	//오버라이딩 override 반환형, 메소드명, 매개변수가 같은 것을 재정의하는 것
	private void setNum() {
		age += 2;
	}
}
//////////////////////////////////////////
public class PravateMain {

	public PravateMain() {

	}

	public static void main(String[] args) {
		PrivateChild pc = new PrivateChild();
		System.out.println("pc.getNum()->"+pc.age);
		//					private 객체명을 통한 접근이 불가능하다.
		//System.out.println("pc.num ->"+ pc.num);
	}

}
