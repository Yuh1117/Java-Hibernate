package test;


import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Cat;
import util.HibernateUtil;

public class TestCat {
	public static void main(String[] args) {
		try {
			SessionFactory sessionFactory  = HibernateUtil.getSessionFactory();
			if(sessionFactory!=null) {
				Session session = sessionFactory.openSession();
				try {
					Transaction tr = session.beginTransaction();
					Cat cat1 = new Cat();
					cat1.setName("Tom");
					cat1.setSex(true);
					cat1.setDateOfBirth(Date.valueOf("1999-01-03"));
					session.save(cat1); 
					tr.commit();
				} finally {
					session.close();
				}
			}
		} catch (Exception e) {
			
		}
	}
}