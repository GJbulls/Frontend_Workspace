package common;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionTemplate {
	
	private static SqlSessionFactory factory=null;
	
	private SqlSessionTemplate() {
		 
	}
	
	public static SqlSessionFactory setsqlSessionFactory() {
		
		
		
		//1.트랜잭션이 설정되어 있는 파일의 경로를 정의한다.
		String resource = "common/config/configuration.xml";
		
		//2.설정 파일을 로딩하기 위해 입출력 스트림과 연결한다.
		try(Reader reader = Resources.getResourceAsReader(resource)){
			
			//3.설정파일을 저장하기 위한 팩토리를 생성해 줄 수 있는 빌더를 생성한다.
			SqlSessionFactoryBuilder sqlBuilder = new SqlSessionFactoryBuilder();
			
			//4.설정파일의 정보를 읽어와 sqlBuilder에 생성한다.
			factory = sqlBuilder.build(reader);
			
//			reader.close(); try resource를 사용했기때문에 따로 닫아주지 않아도 됌
			
			
			
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		
		return factory;
	}//end setSqlSessionFactory()
	
		public static SqlSession getSqlSession() {
			if(setsqlSessionFactory() == null) {
				factory = setsqlSessionFactory();
				}
			
			//5. 쿼리문에 접근할 수 있도록 sqlSession객체를 리턴한다.
			//openSession()의 기본값은 false이다.
			//자동 커밋을 설정하고 싶으면 openSession(true)로 설정한다.
			//실무에서는 자동커밋을 사용하지 않는다.
			return factory.openSession(false);
			
		}//endSqlSession
	
	
	
}//end class
