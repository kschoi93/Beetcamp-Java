package apiClass;

public class StringBufferTest {

	public StringBufferTest() {
//String Buffer 문자열을 비동기식으로 처리, 문자열이 자주 바뀌는 경우 유용
StringBuffer sb = new StringBuffer();
// StringBuffr는 기본 16자리가 할당되어 있다
System.out.println("capacity->"+ sb.capacity());
// String Buffer는 입력, 따로 변수에 넣지 않아도 된다
sb.append(true);
sb.append("Spring");
sb.append(44.89);
//문자열 중간에 삽입
sb.insert(6, " Insert ");
// 01234567890123456789012
// trueSp Insert ring44.89
// delete
sb.delete(4, 10); // 4부터 10앞까지 문자열 삭제
// trueert ring44.89
// reverse
sb.reverse();
// 98.44gnir treeurt
System.out.println("sb->"+sb);
// char가 16자리에서 넘게되어 자동으로 확장된걸 확인할수 있다
System.out.println("capacity->"+ sb.capacity());
	}
	
	////////////////////////////////////////////
	public static void main(String[] args) {
		new StringBufferTest();

	}

}
