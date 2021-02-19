// update : 수정하는것
// dbconn 과 연결되어 있어 코드의 간소화가 되어있다
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
			pstmt.setString(2, "장영실");
			
			int result = pstmt.executeUpdate();
			
			if(result>0) {
				System.out.println(result+"개의 레코드가 수정되었습니다");
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
