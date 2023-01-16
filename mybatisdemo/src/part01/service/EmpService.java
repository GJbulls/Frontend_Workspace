package part01.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import common.SqlSessionTemplate;
import part01.dao.EmployeesDAO;
import part01.dto.EmpDTO;

public class EmpService {

	private EmployeesDAO dao;
//	private SqlSession sqlSession;
	private SqlSessionFactory factory;
	public EmpService() {
		dao = new EmployeesDAO();
		factory = SqlSessionTemplate.setsqlSessionFactory();
	}

	public int countProcess() {
		int chk = 0;
		SqlSession sqlSession = null;
		try {
//		sqlSession = SqlSessionTemplate.getSqlSession();
		sqlSession = factory.openSession(false);
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
		SqlSession sqlSession = null;
		try {
			sqlSession = factory.openSession(false);
			aList = dao.getAllListMethod(sqlSession);
			sqlSession.commit();
		}catch(Exception ex){
			sqlSession.rollback();
		}finally {
			sqlSession.close();
		}
		return aList;
		
	}//getAllListProcess()

	public List<EmpDTO> getsearchListProcess(String data){
		List<EmpDTO> aList = null;
		SqlSession sqlSession = null;
		try {
			sqlSession = factory.openSession(false);
			aList = dao.getSearchListMethod(sqlSession, data);
			sqlSession.commit();
		}catch(Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
		}finally {
			sqlSession.close();
		}
		
		return aList;
		
		
		
	}
	
	
	
}// end class







