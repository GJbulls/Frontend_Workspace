package servletdemo.part04;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public class MemService {
	MemDAO dao =null;
	public MemService() {
	dao = MemDAO.getInstance();
	}

	public List<MemDTO> getMemList() {

		Connection conn = JdbcTemplate.getConnection();
		List<MemDTO> aList = null;
		try {
			conn.setAutoCommit(false); // 자동커밋해제 , default = true
			aList = dao.getListMethod(conn);
			JdbcTemplate.commit(conn);
		} catch (SQLException e) {
			e.printStackTrace();
			JdbcTemplate.rollback(conn);
		} finally {
			JdbcTemplate.close(conn);
		}
		return aList;

	}// getMemList()

	public int getInsert(MemDTO dto) {
		int chk = 0;

		Connection conn  = JdbcTemplate.getConnection();
		
		try {
			conn.setAutoCommit(false);
			chk = dao.insertMethod(conn, dto);
			JdbcTemplate.commit(conn);
			
		} catch (SQLException e) {
			e.printStackTrace();
			JdbcTemplate.rollback(conn);
		} finally {
			JdbcTemplate.close(conn);
		}
			
		return chk;
	}
	
	public int getUpdate(HashMap<String,Object> map) {
		int chk =0;
		Connection conn  = JdbcTemplate.getConnection();
		
		try {
				conn.setAutoCommit(false);
				chk = dao.updateMethod(conn, map);
				JdbcTemplate.commit(conn);
		} catch (SQLException e) {
			
			e.printStackTrace();
			JdbcTemplate.rollback(conn);
		}finally {
			JdbcTemplate.close(conn);
		}
		
		
		
		return chk;
	}//end getUpdate()
	
	public int getDelete(int num) {
		int chk = 0;
		Connection conn  = JdbcTemplate.getConnection();
		
		try {
			conn.setAutoCommit(false);
			chk = dao.deleteMethod(conn, num);
			JdbcTemplate.commit(conn);
		} catch (SQLException e) {
			e.printStackTrace();
			JdbcTemplate.rollback(conn);
		}finally {
			JdbcTemplate.close(conn);
		}
		
		return chk;
	}
	
	
}//end class























