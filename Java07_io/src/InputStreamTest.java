import java.io.IOException;
import java.io.InputStream;

public class InputStreamTest {

	public InputStreamTest() {

		try {
			//InputStream Class는 추상클래스로서 객체 생성할 수 없다
			//InputStream은 Byte 단위로 입력받는 클래스
			InputStream is = System.in;
			
			System.out.print("입력=");
			
			while(true) {
				//read() -> 입력문자를 1byte씩 읽어온다
				
				int inData = is.read(); // 읽을 데이터ㅏ 없을때 -1입력
				System.out.println(inData+","+(char)inData);
				
				if(inData == -1) {
					break;
				}
				
				
				//read(a[]) : 배열크기큼 한번에 읽어온다
				/*
				byte inData[] = new byte[50]; 
				// byte수      읽은 Byte는 배열에 저장
				int cnt = is.read(inData);
				System.out.println(new String(inData,0,cnt) + "-->"+ cnt);
				if(cnt<=0)break;
				*/
				
				//read(arr[],int,int)
//				byte inData[] = new byte[10];
//				// 읽은 데이터 담을 배열, 배열의 저장위치 index, 읽어올 byte 갯수
//				int cnt = is.read(inData,3,4);
//				for(int i=0; i<inData.length; i++) {
//					System.out.println("확인 ["+i+"]-->"+inData[i]);
//				}
			}
		} catch(IOException e) {
		System.out.println(e.getMessage());
	}
}
	public static void main(String[] args) {
		new InputStreamTest();
	}
}
