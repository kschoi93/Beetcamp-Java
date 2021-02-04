import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;

public class ObjectOutputStreamTest {

	public ObjectOutputStreamTest() {
		//ObjectOutputStream : 객체를 파일로 쓰기
		//                     객체를 직렬화 하여야 한다
		
		Calendar now = Calendar.getInstance();
		FileCopy fc = new FileCopy();
		ArrayList lst = new ArrayList();
		lst.add(new String("홍길동"));
		lst.add(now);
		lst.add(fc);
		
		DataVO vo = new DataVO();
		vo.setNum(1234);
		vo.setName("세종대왕");
		vo.setTel("010-1111-2222");
		vo.setEmail("goguma777@nate.com");
		
		// 객체를 파일로 쓰기
		try {
			File f = new File("d://javaIO/Object.txt");
			FileOutputStream fos = new FileOutputStream(f);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			oos.writeObject(lst);
			oos.writeObject(vo);
			
			oos.flush();
			oos.close();
			
			
		} catch(IOException ioe) {
			ioe.printStackTrace();
		} 
		
		System.out.println("객체 저장이 완료 되었습니다.");
		
	}

	public static void main(String[] args) {
		new ObjectOutputStreamTest();
	}

}
