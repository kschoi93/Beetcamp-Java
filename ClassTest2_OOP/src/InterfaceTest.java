import java.util.List;

public interface InterfaceTest {
	// static 멤버변수들
	public static String global = "seoul";
	public static final int MAX = 100; // 상수화된 변수 : 100이외의 값은 대입 할 수 없다
	//추상메소드들을 정의
	public void print();
	public int[] recordAll(int num);
	public String total(int max);
}
