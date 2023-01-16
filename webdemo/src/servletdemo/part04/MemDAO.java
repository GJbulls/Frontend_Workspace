package servletdemo.part04;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MemDAO {

	private MemDAO() {
	}

	private static MemDAO dao = new MemDAO();

	public static MemDAO getInstance() {
		return dao;
	}

	public List<MemDTO> getListMethod(Connection conn) {
		List<MemDTO> aList = new ArrayList<MemDTO>();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			
			stmt = conn.createStatement();

			String sql = "SELECT * FROM mem ORDER BY num DESC";
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				MemDTO dto = new MemDTO();
				dto.setNum(rs.getInt("num"));
				dto.setName(rs.getString("name"));
				dto.setAge(rs.getInt("age"));
				dto.setLoc(rs.getString("loc"));
				aList.add(dto);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(stmt);
		}
		return aList;
	}// end getListMethod()
	
	public int insertMethod(Connection conn, MemDTO dto) {
		PreparedStatement pstmt = null;
		int chk = 0;
		
		try {
			String sql = "INSERT INTO mem(num,name,age,loc) VALUES(mem_num_seq.nextval,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setInt(2, dto.getAge());
			pstmt.setString(3, dto.getLoc());
			chk = pstmt.executeUpdate(); //insert,update, delete
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcTemplate.close(pstmt);
		}
		
		return chk;
	}//insertMethod()
	
	public int updateMethod(Connection conn, HashMap <String,Object> map) {
		System.out.printf("%s, %s ,%s, %s\n",map.get("name").toString(),
											 map.get("age").toString(),
											 map.get("loc").toString(),
											 map.get("num").toString());
		int chk = 0;
		PreparedStatement pstmt = null;
		
		
		try {
			String sql = "UPDATE mem SET name=?,age = ?, loc = ? WHERE num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, map.get("name").toString());
			pstmt.setInt(2, Integer.parseInt(map.get("age").toString()));
			pstmt.setString(3, map.get("loc").toString());
			pstmt.setInt(4, Integer.parseInt(map.get("num").toString())); //String -> int값 변경
			chk = pstmt.executeUpdate();
			JdbcTemplate.commit(conn);
		} catch (SQLException e) {
			e.printStackTrace();
			JdbcTemplate.rollback(conn);
		}finally {
			JdbcTemplate.close(pstmt);
		}
		return chk;
		
	}//end updateMethod()
	
	public int deleteMethod(Connection conn,int num) {
		int chk = 0;
		PreparedStatement pstmt = null;
		
		try {
			String sql = "DELETE FROM mem WHERE num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			chk = pstmt.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			JdbcTemplate.close(pstmt);
		}
		
		
		return chk;
	}
	
}//end class
































