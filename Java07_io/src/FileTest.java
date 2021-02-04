import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class FileTest {

	public FileTest() {
		//File 객체 생성 : 드라이브명, 폴더명, 파일명 반드시 절대 주소
		File f1 = new File("d://javaIO");
		File f2 = new File("d://io/oracle.sql");
		File f3 = new File(f1,"test.txt");
		
		//폴더 생성하기
		///exits() : 폴더 또는 파일이 존재하는지 여부 확인 (true : 있다, false : 없다);
		if(!f1.exists()) {//폴더가 없으면
			if(f1.mkdirs()) {
				System.out.println("폴더가 생성됨...");
			} else {
				System.out.println("폴더가 미생성됨...");
			}
		}
		//파일 생성
		if(!f3.exists()) {
			try {
				if(f3.createNewFile()) {
					System.out.println("파일이 생성됨...");
				} else {
					System.out.println("파일생성 실패...");
				}
			} catch(IOException e) {
				System.out.println("파일생성에러 발생-->"+e.getMessage());
			}
		}

		//마지막 수정일 얻어오기
		long lastDate  = f3.lastModified(); // 밀리초로 구해진다.
		System.out.println("lastDate="+lastDate);
		
		//밀리초를 날짜로 변환
		Calendar now = Calendar.getInstance();
		now.setTimeInMillis(lastDate);//밀리초를 Calendar 셋팅
		// 2021-01-12 오후 03:01
		SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-DD a hh:mm");
		String lastDateStr = format.format(now.getTime());
		System.out.println(lastDateStr);
		
		// 파일의 상태를 확인
		System.out.println("canExecute="+ f2.canExecute());
		System.out.println("canRead="+ f2.canRead());
		System.out.println("conWrite="+f2.canWrite());
		System.out.println("isFile="+ f2.isFile());
		System.out.println("isDirectory="+ f2.isDirectory());
		System.out.println("--------------------------------------");
		
		// 특정 드라이브 또는 특정 폴더의 폴더 목록, 파일 목록을 구한다.
		File f4 = new File("C://");
		File file[]= f4.listFiles();
		// getPath() : 드라이브명, 경로, 파일명 확인
		// getName() : 파일명만 확인
		// getAbsoluteName() : 드라이브명, 경로, 파일명
		// getParent() : 드라이브명, 경로
		for(File f : file) {
			if(f.isDirectory()) {
				if(f.isHidden()) {
				System.out.println(f.getPath()+"[숨김폴더]"); 
				} else {
					System.out.println(f.getPath()+"[폴더]");
				}
			} else if(f.isFile()) {
				if(f.isHidden()) {
				System.out.println(f.getPath()+"[파일]");
				} else {
					System.out.println(f.getPath()+"[파일]");
				}
				
			}
		}
		System.out.println("------------------------------------");
		// 현재 컴퓨터의 드라이브 목록
		File drive[] = File.listRoots();
		for(File f:drive) {
			System.out.println(f.getPath());
		}
		// 파일크기(Byte)
		long size = f3.length();
		System.out.println("file size ->" + size+"byte");
		
		//파일삭제
		f3.delete();
		System.out.println("파일이 삭제됨");
	}

	
	public static void main(String[] args) {
		new FileTest();
	}

}
