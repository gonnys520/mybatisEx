package org.gonnys.test;

import org.gonnys.dao.TimeDAO;
import org.junit.Test;


public class DAOTest {
	
	@Test
	public void testGetTime() {
		System.out.println(new TimeDAO().getTime());
		
	}
}
