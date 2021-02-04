import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;

public class ObjectOutputStreamTest {

	public ObjectOutputStreamTest() {
		//ObjectOutputStream : ��ü�� ���Ϸ� ����
		//                     ��ü�� ����ȭ �Ͽ��� �Ѵ�
		
		Calendar now = Calendar.getInstance();
		FileCopy fc = new FileCopy();
		ArrayList lst = new ArrayList();
		lst.add(new String("ȫ�浿"));
		lst.add(now);
		lst.add(fc);
		
		DataVO vo = new DataVO();
		vo.setNum(1234);
		vo.setName("�������");
		vo.setTel("010-1111-2222");
		vo.setEmail("goguma777@nate.com");
		
		// ��ü�� ���Ϸ� ����
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
		
		System.out.println("��ü ������ �Ϸ� �Ǿ����ϴ�.");
		
	}

	public static void main(String[] args) {
		new ObjectOutputStreamTest();
	}

}
