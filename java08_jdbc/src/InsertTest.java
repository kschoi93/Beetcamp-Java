// Ʈ�����, ���������� �۾��� ��� �Ϸ��ϴ°�


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertTest {
	//2. db����
	//�⺻�ۼ�			ip�ּ� or localhost    port��ȣ   ���������ͺ��̽�����
	String url = "jdbc:oracle:thin:@180.233.244.51:1521:xe";
	String userid = "c##scott";
	String userpwd = "tiger";
	Connection conn = null;
	//1. jdbc ����̺� �ε�
	// ��� �������� ���๮ ����
	static {
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("JDBC����̺� �ε� �Ǿ����ϴ�.");
		} catch(ClassNotFoundException cnfe) {
			System.out.println("JDBC����̺� �ε� �����Ͽ����ϴ�."+cnfe.getMessage());
		}
	}
	public InsertTest() {
		try {
			
			conn = DriverManager.getConnection(url, userid, userpwd);
			conn.setAutoCommit(false);// �ڵ� Ŀ���� �����ش�
			
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			
			do {
				System.out.print("�̸�=");
				String username = br.readLine();
				System.out.print("����ó=");
				String tel = br.readLine();
				System.out.print("�̸���=");
				String email = br.readLine();
				System.out.print("�ּ�=");
				String addr = br.readLine();
				
				//3. preparedStatement�� ����  ( ������ ���� )
				String sql = "insert into member(num, username, tel, email, addr, writedate) "
						+ " values(memsq.nextval,?,?,?,?,sysdate)";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				// ?�� ���� ����
				pstmt.setString(1, username);
				pstmt.setString(2, tel);
				pstmt.setString(3, email);
				pstmt.setString(4, addr);
				
				//4. ����
				int result = pstmt.executeUpdate();
				
//				sql = "insert into member(num,username,tel,email,addr,writedate) "
//						+ "Values(memsq.nextval, ?,?,?,?, sysdate)";
//				pstmt = conn.prepareStatement(sql);
//				pstmt.setString(1, "aaaaaaaa");
//				pstmt.setString(2, "010-8989-2342");
//				pstmt.setString(3, "ababa@naver.com");
//				pstmt.setString(4, "����� ������");
				
				int result2 = pstmt.executeUpdate();
				
				
				if(result > 0 /*&& result2>0*/) {
					System.out.println("ȸ����� �Ǿ����ϴ�.");
					conn.commit();
				} 
			}while(true);
			
			
		}catch(Exception e) {
			//���ܹ߻��ϸ� ���� �������� ���� ���๮ ���
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
