// update : �����ϴ°�
// dbconn �� ����Ǿ� �־� �ڵ��� ����ȭ�� �Ǿ��ִ�
public class UpdateTest extends DBConn{

	public UpdateTest() {
		// TODO Auto-generated constructor stub
	}
	public void setUpdate() {
		try {
			getConn();
			sql = "update member set tel=? where username=?";
			
			pstmt =  conn.prepareStatement(sql);
			pstmt.setString(1, "010-5555-5555");
			pstmt.setString(2, "�念��");
			
			int result = pstmt.executeUpdate();
			
			if(result>0) {
				System.out.println(result+"���� ���ڵ尡 �����Ǿ����ϴ�");
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		} 
	}
	public static void main(String[] args) {
		new UpdateTest().setUpdate();
	}
}
