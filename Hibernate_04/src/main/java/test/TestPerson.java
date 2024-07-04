package test;

import model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.sql.Date;
import java.util.List;
import java.util.Objects;

public class TestPerson {
    public static void main(String[] args) {
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction tr = session.beginTransaction();
                /*Person p1 = new Person(1, "Nguyen Van A", Date.valueOf("1999-02-03"), null);
                session.save(p1);*/

				/*Person p1 = session.find(Person.class, 1L);
				Person p2 = new Person(2, "Tran Thi B", Date.valueOf("2000-10-11"), p1);
				session.save(p2);*/

				/*Person p1 = session.find(Person.class, 1L);
				Person p2 = session.find(Person.class, 2L);
				p1.setSpouse(p2);
				session.saveOrUpdate(p1);*/

				String hql = "SELECT p.name, p.spouse.name FROM Person p";
				List<Object[]> results = session.createQuery(hql).list();
				for(Object[] rs : results){
					String name = rs[0] + "";
					String spouseName = rs[1] + "";
					System.out.println(name + " da ket hon voi " + spouseName);
				}
				tr.commit();
				session.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
