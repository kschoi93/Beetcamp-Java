import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class FileTest {

	public FileTest() {
		//File ��ü ���� : ����̺��, ������, ���ϸ� �ݵ�� ���� �ּ�
		File f1 = new File("d://javaIO");
		File f2 = new File("d://io/oracle.sql");
		File f3 = new File(f1,"test.txt");
		
		//���� �����ϱ�
		///exits() : ���� �Ǵ� ������ �����ϴ��� ���� Ȯ�� (true : �ִ�, false : ����);
		if(!f1.exists()) {//������ ������
			if(f1.mkdirs()) {
				System.out.println("������ ������...");
			} else {
				System.out.println("������ �̻�����...");
			}
		}
		//���� ����
		if(!f3.exists()) {
			try {
				if(f3.createNewFile()) {
					System.out.println("������ ������...");
				} else {
					System.out.println("���ϻ��� ����...");
				}
			} catch(IOException e) {
				System.out.println("���ϻ������� �߻�-->"+e.getMessage());
			}
		}

		//������ ������ ������
		long lastDate  = f3.lastModified(); // �и��ʷ� ��������.
		System.out.println("lastDate="+lastDate);
		
		//�и��ʸ� ��¥�� ��ȯ
		Calendar now = Calendar.getInstance();
		now.setTimeInMillis(lastDate);//�и��ʸ� Calendar ����
		// 2021-01-12 ���� 03:01
		SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-DD a hh:mm");
		String lastDateStr = format.format(now.getTime());
		System.out.println(lastDateStr);
		
		// ������ ���¸� Ȯ��
		System.out.println("canExecute="+ f2.canExecute());
		System.out.println("canRead="+ f2.canRead());
		System.out.println("conWrite="+f2.canWrite());
		System.out.println("isFile="+ f2.isFile());
		System.out.println("isDirectory="+ f2.isDirectory());
		System.out.println("--------------------------------------");
		
		// Ư�� ����̺� �Ǵ� Ư�� ������ ���� ���, ���� ����� ���Ѵ�.
		File f4 = new File("C://");
		File file[]= f4.listFiles();
		// getPath() : ����̺��, ���, ���ϸ� Ȯ��
		// getName() : ���ϸ� Ȯ��
		// getAbsoluteName() : ����̺��, ���, ���ϸ�
		// getParent() : ����̺��, ���
		for(File f : file) {
			if(f.isDirectory()) {
				if(f.isHidden()) {
				System.out.println(f.getPath()+"[��������]"); 
				} else {
					System.out.println(f.getPath()+"[����]");
				}
			} else if(f.isFile()) {
				if(f.isHidden()) {
				System.out.println(f.getPath()+"[����]");
				} else {
					System.out.println(f.getPath()+"[����]");
				}
				
			}
		}
		System.out.println("------------------------------------");
		// ���� ��ǻ���� ����̺� ���
		File drive[] = File.listRoots();
		for(File f:drive) {
			System.out.println(f.getPath());
		}
		// ����ũ��(Byte)
		long size = f3.length();
		System.out.println("file size ->" + size+"byte");
		
		//���ϻ���
		f3.delete();
		System.out.println("������ ������");
	}

	
	public static void main(String[] args) {
		new FileTest();
	}

}
