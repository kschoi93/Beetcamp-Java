
public class StringTest {

	public StringTest() {
		String test = "test!@#$%^^&0123456:;<=ABCDEF^+'dkjf{|;";
		char alpha;
		int code;
		for(int i=0; i<test.length(); i++) {
			alpha = test.charAt(i);
			code = (int)alpha;
			System.out.println("alpha="+alpha+", code ="+ code);
			if(code>=0 && code<=32 || code>=36 && code<=47 || code>=58 && code<=63 || code>=91 && code <=96 || code>=123 && code <= 126) {
				
			}
		}
	}

	public static void main(String[] args) {
		new StringTest();
	}
}
