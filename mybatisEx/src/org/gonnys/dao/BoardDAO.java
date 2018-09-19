package org.gonnys.dao;

import org.apache.ibatis.session.SqlSession;

public class BoardDAO {
	
	private String preFix =  "org.gonnys.mapper.boardMapper";		
	
	public void create(BoardDAO vo) {
		
		try(SqlSession session = MybatisLoader.sqlSessionFactory.openSession(true)){
			session.insert(preFix + ".crate", vo);
			
			
		}catch(Exception e) {
			e.printStackTrace();
	}
		
	

	}
}
