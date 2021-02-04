
public class DeleteTest extends DBConn {

	public DeleteTest() {
		
	}
	
	public void setDelete() {
		try {
			getConn();
			
			sql = "delete from member where num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 29);
			
			int result = pstmt.executeUpdate();
			if(result > 0) {
				System.out.println(result+"���� ���ڵ尡 �����Ǿ����ϴ�.");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
	}
	
	public static void main(String[]args) {
		new DeleteTest().setDelete();
	}

}