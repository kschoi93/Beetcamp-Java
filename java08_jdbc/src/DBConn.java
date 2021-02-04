import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConn {
	//1. 드라이브 로딩
	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch(Exception e) {
			System.out.println("드라이브 로딩 에러발생-->"+e.getMessage());
		}
	}
	Connection conn=null;
	PreparedStatement pstmt =null;
	ResultSet rs =null;
	String sql = null;
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String username = "c##scott";
	String userpwd = "tiger";
	
	public DBConn() {
	}
	//DB연결
	public void getConn() {
		try {
			conn = DriverManager.getConnection(url,username,userpwd);
		}catch(Exception e) {
			System.out.println("DB연결 에러발생-->"+e.getMessage());
		}
	}
	//DB접속 종료
	// DB를 다른사람이 사용하려면 종료를 해줘야 한다
	public void dbClose() {
		try {
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(conn!=null)conn.close();
		}catch(Exception e) {
			System.out.println("DB종료 에러발생-->"+e.getMessage());
		}
	}
}
