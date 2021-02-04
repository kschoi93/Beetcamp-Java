import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConn {
	//1. ����̺� �ε�
	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch(Exception e) {
			System.out.println("����̺� �ε� �����߻�-->"+e.getMessage());
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
	//DB����
	public void getConn() {
		try {
			conn = DriverManager.getConnection(url,username,userpwd);
		}catch(Exception e) {
			System.out.println("DB���� �����߻�-->"+e.getMessage());
		}
	}
	//DB���� ����
	// DB�� �ٸ������ ����Ϸ��� ���Ḧ ����� �Ѵ�
	public void dbClose() {
		try {
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(conn!=null)conn.close();
		}catch(Exception e) {
			System.out.println("DB���� �����߻�-->"+e.getMessage());
		}
	}
}
