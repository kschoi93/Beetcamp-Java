import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

class FileTest  {
	public FileTest() {
		try {
			File file = new File("d://io", "data.txt");
			FileOutputStream fos = new FileOutputStream(file);
			DataOutputStream dos = new DataOutputStream(fos);
			
			int num = 123456;
			char str = 'Z';
			double num2 = 2345.634;
			boolean boo = true;
			
			dos.writeInt(num);
			dos.writeChar(str);
			dos.writeDouble(num2);
			dos.writeBoolean(boo);
			
			FileInputStream	fis = new FileInputStream(file);
			DataInputStream dis = new DataInputStream(fis);
			
			int numIn = dis.readInt();
			char strIn = dis.readChar();
			double num2In = dis.readDouble();
			boolean booIn = dis.readBoolean();
			
			
			System.out.println("numIn="+numIn);
			System.out.println("strIn="+strIn);
			System.out.println("num2In="+num2In);
			System.out.println("booIn="+booIn);
			
			
			
			
		}catch(Exception e) {
			System.out.println("¿¡·¯");
		}
	}
	
	public static void main(String[]args) {
		new FileTest();
	}
}