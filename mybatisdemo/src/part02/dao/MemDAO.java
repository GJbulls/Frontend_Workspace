package part02.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import part02.dto.MemDTO;

public class MemDAO {
	
	public List<MemDTO> getAllListmethod(SqlSession sqlSession){
		return sqlSession.selectList("mem.list");
	}
	public int setInsertMethod(SqlSession sqlSession, MemDTO dto) {
		return sqlSession.insert("mem.memInsert",dto);
	}
	
	
}
