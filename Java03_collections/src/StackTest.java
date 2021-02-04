import java.util.Stack;

public class StackTest {

	public StackTest() {
		// F.I.L.O : 먼저 추가된 객체 제일 마지막에 얻어진다.
		Stack<Integer> st = new Stack<Integer>();
	
		st.push(100);
		st.push(200);
		st.push(300);
		st.push(400);
		
		while(!st.empty()) {
			System.out.println(st.pop());
			System.out.println("남은 객체수-->"+st.size());
		}
		
	}

	public static void main(String[] args) {
		new StackTest();
	}

}
