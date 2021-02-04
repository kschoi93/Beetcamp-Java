import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterTest {

	public FileWriterTest() {
		try {
			File f = new File("D://io/test_file.txt");
			FileWriter fw = new FileWriter(f);
			String txt = "자바에서 문자열을 파일로 쓰기 연습중!!!!!";
			
			//1. 배열로 저장
			// 문자열을 char배열로 생성
			
			char c[] = txt.toCharArray();
			fw.write(c, 5, c.length-5); // c, index ~ 부터 어디까지
			fw.flush();
			
			//2. 문자열로 쓰기
			fw.write(txt,0,txt.length());
			fw.flush();
			
			
			fw.close();
			
		} catch(IOException e) {
			e.printStackTrace();
			System.out.println("파일....");
		}
		System.out.println("end......");
	}

	public static void main(String[] args) {
		new FileWriterTest();

	}

}
