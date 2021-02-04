import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataInputOutputStreamTest {

	public DataInputOutputStreamTest() {
		// 원래 데이터 타입으로 저장하기, 불러오기
		// DataInputStream, DataOutputStream
		try {
			File file = new File("d://io", "data.txt");
			FileOutputStream fos = new FileOutputStream(file);
			DataOutputStream dos = new DataOutputStream(fos);
			
			int num = 123456;
			char str = 'Z';
			double num2 = 254836.3254;
			boolean boo = true;
			
			dos.writeInt(num);
			dos.writeChar(str);
			dos.writeDouble(num2);
			dos.writeBoolean(boo);			
			dos.close();
			
			//읽어오기
			FileInputStream fis = new FileInputStream(file);
			DataInputStream dis = new DataInputStream(fis);
			
			int numIn = dis.readInt();
			char charIn = dis.readChar();
			double num2In = dis.readDouble();
			boolean booIn = dis.readBoolean();
			
			System.out.println("numIn="+ numIn);
			System.out.println("charIn="+charIn);
			System.out.println("num2In="+num2In);
			System.out.println("booIn="+booIn);
			
		} catch (FileNotFoundException fnfe) {
			System.out.println("파일이 존재하지 않습니다.");
		} catch (IOException ie) {
			System.out.println("쓰기에러");
		}
	}

	public static void main(String[] args) {
		new DataInputOutputStreamTest();

	}

}
