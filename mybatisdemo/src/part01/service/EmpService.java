package part01.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import common.SqlSessionTemplate;
import part01.dao.EmployeesDAO;
import part01.dto.EmpDTO;

public class EmpService {

	private EmployeesDAO dao;
	private SqlSession sqlSession;
	public EmpService() {
		dao = new EmployeesDAO();

	}

	public int countProcess() {
		int chk = 0;
		try {
		sqlSession = SqlSessionTemplate.getSqlSession();
		chk = dao.countMethod(sqlSession);
		sqlSession.commit();
		
		}catch(Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
		}finally {
			sqlSession.close();
		}
		return chk;
	}//end countProcess
	
	public List<EmpDTO> getAllListProcess(){
		List<EmpDTO> aList = null;
		try {
			sqlSession = SqlSessionTemplate.getSqlSession();
			aList = dao.getAllListMethod(sqlSession);
			sqlSession.commit();
		}catch(Exception ex){
			sqlSession.rollback();
		}finally {
			sqlSession.close();
		}
		return aList;
		
	}//getAllListProcess()


}// end class
