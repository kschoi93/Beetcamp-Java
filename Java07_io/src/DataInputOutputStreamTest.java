import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataInputOutputStreamTest {

	public DataInputOutputStreamTest() {
		// ���� ������ Ÿ������ �����ϱ�, �ҷ�����
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
			
			//�о����
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
			System.out.println("������ �������� �ʽ��ϴ�.");
		} catch (IOException ie) {
			System.out.println("���⿡��");
		}
	}

	public static void main(String[] args) {
		new DataInputOutputStreamTest();

	}

}
