
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.Serializable;

//								����ȭ�� �Ͽ� ��ü�� ���Ϸ� �����ϵ��� �Ѵ�.
public class FileCopy implements Serializable{

	public FileCopy() {

		
	}
	public void start() {		
		try {
			//���� ����
			File srcFile = new File("d://test.jpg");
			File tarFile = new File("d://io", srcFile.getName());
			
			FileInputStream fi = new FileInputStream(srcFile);
			FileOutputStream fo = new FileOutputStream(tarFile);
	
			while(true) {
				int inData = fi.read();
				if(inData==-1) break;
				fo.write(inData);
			}
			fo.flush();
			fo.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
//	public static void main(String[] args) {
//		new FileCopy();
//
//	}

}
