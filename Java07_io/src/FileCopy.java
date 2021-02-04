
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.Serializable;

//								직렬화를 하여 객체를 파일로 저장하도록 한다.
public class FileCopy implements Serializable{

	public FileCopy() {

		
	}
	public void start() {		
		try {
			//파일 복사
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
