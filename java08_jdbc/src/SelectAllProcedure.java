import java.sql.CallableStatement;
import java.sql.ResultSet;

import oracle.jdbc.OracleTypes;

public class SelectAllProcedure extends DBConn{

	public SelectAllProcedure() {
		
	}
	
	public void start(){
		try {
			getConn();
			//모든 레코드를 선택하라. member
			sql = "{call mem_all(?)}";
			CallableStatement cstmt = conn.prepareCall(sql);
			cstmt.registerOutParameter(1, OracleTypes.CURSOR);
			
			cstmt.executeQuery();// 실행
			
			rs = (ResultSet)cstmt.getObject(1);
			while(rs.next()) {
				System.out.println(rs.getInt(1)+", "+rs.getString(2)+", "+rs.getString(3)+", "+ rs.getString(4) +", "+ rs.getString(5)+", "+ rs.getString(6));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
	}
	public static void main(String[] args) {
		new SelectAllProcedure().start();
	}
}
