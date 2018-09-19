package org.gonnys.dao;

import org.apache.ibatis.session.SqlSession;

public class TimeDAO {

	private final String prefix = "org.gonnys.mapper.timeMapper";

	public String getTime() {
		try (SqlSession session = MybatisLoader.sqlSessionFactory.openSession(true)) {
			return session.selectOne(prefix + ".getTime");

		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
		return null;
	}
}
