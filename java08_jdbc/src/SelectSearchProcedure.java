import java.sql.CallableStatement;
import java.sql.ResultSet;

import oracle.jdbc.OracleTypes;

public class SelectSearchProcedure  extends DBConn{
	public SelectSearchProcedure() {
		try {
			getConn();
			
			sql="{call mem_search(?,?)}";
			
			CallableStatement cstmt = conn.prepareCall(sql);
			cstmt.setString(1, "naver");
			cstmt.registerOutParameter(2, OracleTypes.CURSOR);
			
			cstmt.executeQuery();
			rs = (ResultSet)cstmt.getObject(2);
			while(rs.next()) {
				System.out.printf("%d, %s, %s, %s, %s, %s\n",
								rs.getInt(1),rs.getString(2),rs.getString(3),
								rs.getString(4),rs.getString(5),rs.getString(6));
			}
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
	}
	public static void main(String[] args) {
		new SelectSearchProcedure();
	}
}
