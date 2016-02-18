package com.caicf.test;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.caicf.model.vo.Grade;
import com.caicf.model.vo.Student;
import com.caicf.utils.HibernateSessionFactory;

public class Many2OneTest {

	private Session session=null;
	private Transaction transaction=null;
	
	@Before
	public void setUp() throws Exception {
		session=HibernateSessionFactory.getSession();
		transaction=session.beginTransaction();
	}

	@After
	public void tearDown() throws Exception {
		session.close();
	}

	@Test
	public void test() {
		
		Grade g=new Grade();
		g.setGname("Java班");
		g.setGdesc("软件开发工程师Java");
		
		Student student1=new Student(g, "caicf", "男");
		Student student2=new Student(g, "fxd", "nv");
		
		session.save(g);
		session.save(student1);
		session.save(student2);
		
		transaction.commit();
			
	}

}
