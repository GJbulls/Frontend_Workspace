package part01.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import common.SqlSessionTemplate;
import part01.dto.EmpDTO;

public class EmployeesDAO {
	
	
	
	/*
	 * apache.org => iBatis => jdk1.4이상
	 * google.com => myBatis => jdk1.5이상
	 * 
	 */
	
	public int countMethod(SqlSession sqlSession) {
									//namespace.id
		return sqlSession.selectOne("emp.cnt");
		
	}
	public List<EmpDTO> getAllListMethod(SqlSession sqlSession){
		
		return sqlSession.selectList("emp.list");
	}
	
	
	
}//end class














