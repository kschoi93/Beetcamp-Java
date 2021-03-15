import java.util.ArrayList;
import java.util.Arrays;

public class pro_Desc {
	public pro_Desc(){
		
		StringBuilder test = new StringBuilder();
		test.append("하이");
		System.out.println(test);
		test.append(" + 헬로우");// 헬로우를 추가한다.
		System.out.println(test);
		test.replace(2, 6, " 테스트 ");// 2번째 자리부터 6번째 앞자리까지 제거 하고 테스트를 넣는다
		System.out.println(test);
		test.deleteCharAt(4); // 4번째 자리에 있는 글자를 삭제한다
		System.out.println(test);
		test.delete(1, 4); // 1번부터 4번째 앞자리까지 삭제한다.
		System.out.println(test);
		test.reverse(); // 반전 시킨다
		System.out.println(test);
	}
	public String test(String s) {
		char[] sol = s.toCharArray();
		Arrays.sort(sol);
		
		return new StringBuilder(new String(sol)).reverse().toString();
	}
	public static void main(String[] args) {
		new pro_Desc();
	}

}
