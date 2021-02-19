import java.sql.CallableStatement;

public class UpdateProcedure extends DBConn{
	
	public UpdateProcedure() {
		try {
			getConn();
			
			sql = "{call mem_update(?,?,?,?)}";
			CallableStatement cstmt = conn.prepareCall(sql);
			
			cstmt.setString(1, "고구마");
			cstmt.setString(2, "010-0000-0000");
			cstmt.setString(3, "test1234@naver.com");
			cstmt.setString(4, "서울특별시 마포구");
			
			int r = cstmt.executeUpdate();
			
			if(r>0) {
				System.out.println("회원정보가 업데이트 되었습니다.");
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
	}
	
	public static void main(String[] args) {
		new UpdateProcedure();
	}
}
