// 트랜잭션, 여러가지의 작업을 모두 완료하는것


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertTest {
	//2. db연결
	//기본작성			ip주소 or localhost    port번호   전역데이터베이스변수
	String url = "jdbc:oracle:thin:@180.233.244.51:1521:xe";
	String userid = "c##scott";
	String userpwd = "tiger";
	Connection conn = null;
	//1. jdbc 드라이브 로딩
	// 멤버 영역에서 실행문 사용법
	static {
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("JDBC드라이브 로딩 되었습니다.");
		} catch(ClassNotFoundException cnfe) {
			System.out.println("JDBC드라이브 로딩 실패하였습니다."+cnfe.getMessage());
		}
	}
	public InsertTest() {
		try {
			
			conn = DriverManager.getConnection(url, userid, userpwd);
			conn.setAutoCommit(false);// 자동 커밋을 막아준다
			
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			
			do {
				System.out.print("이름=");
				String username = br.readLine();
				System.out.print("연락처=");
				String tel = br.readLine();
				System.out.print("이메일=");
				String email = br.readLine();
				System.out.print("주소=");
				String addr = br.readLine();
				
				//3. preparedStatement를 생성  ( 쿼리문 생성 )
				String sql = "insert into member(num, username, tel, email, addr, writedate) "
						+ " values(memsq.nextval,?,?,?,?,sysdate)";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				// ?에 값을 셋팅
				pstmt.setString(1, username);
				pstmt.setString(2, tel);
				pstmt.setString(3, email);
				pstmt.setString(4, addr);
				
				//4. 실행
				int result = pstmt.executeUpdate();
				
//				sql = "insert into member(num,username,tel,email,addr,writedate) "
//						+ "Values(memsq.nextval, ?,?,?,?, sysdate)";
//				pstmt = conn.prepareStatement(sql);
//				pstmt.setString(1, "aaaaaaaa");
//				pstmt.setString(2, "010-8989-2342");
//				pstmt.setString(3, "ababa@naver.com");
//				pstmt.setString(4, "서울시 강서구");
				
				int result2 = pstmt.executeUpdate();
				
				
				if(result > 0 /*&& result2>0*/) {
					System.out.println("회원등록 되었습니다.");
					conn.commit();
				} 
			}while(true);
			
			
		}catch(Exception e) {
			//예외발생하면 먼저 정상실행된 쿼리 실행문 취소
			try {
				conn.rollback();
			}catch(SQLException se) {
				se.printStackTrace();
			}
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new InsertTest();
	}

}
