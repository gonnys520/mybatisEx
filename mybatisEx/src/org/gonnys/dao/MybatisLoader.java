package org.gonnys.dao;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.gonnys.domain.BoardVO;

public class MybatisLoader {

	static SqlSessionFactory sqlSessionFactory;

	static{
		try {
			String resource = "mybatis-config.xml";
	         InputStream inputStream = Resources.getResourceAsStream(resource);
	          sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		}catch(Exception e) {
		e.printStackTrace();
	}
	}

	public static void main(String[] args) throws Exception {
		String prefix = "org.gonnys.mapper.boardMapper";

		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		System.out.println(sqlSessionFactory);

		// true == auto commit
		SqlSession session = sqlSessionFactory.openSession(true);

//		현재 시간		
//		String now = session.selectOne("org.gonnys.mapper.timeMapper.getTime");
//		System.out.println(now);
//		session.close();

//		10개만 추출
		List<BoardVO> list = session.selectList(prefix + ".select10");
		System.out.println(list);

//		INSERT 하기		
//		BoardVO vo = new BoardVO();
//		vo.setTitle("제목");
//		vo.setContent("내용");
//		vo.setWriter("gonnys");
//		
//		session.insert("org.gonnys.mapper.boardMapper.create", vo);

//		REMOVE 하기
//		int count = session.delete("org.gonnys.mapper.boardMapper.remove", 5701796);
//		System.out.println(count);

//		page
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("page", 2);
		paramMap.put("size", 20);

		List<BoardVO> list2 = session.selectList(prefix + ".selectPage", paramMap);

		System.out.println(list2);

	}
}
