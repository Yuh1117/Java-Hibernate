package test;

import java.sql.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import dao.CatDAO;
import model.Cat;
import util.HibernateUtil;

public class TestCat {
    public static void main(String[] args) {
//		// Transient
//		Cat find = new Cat();
//		find.setId(6);
//
//		try {
//			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//			if (sessionFactory != null) {
//				Session session = sessionFactory.openSession();
//				Transaction tr = session.beginTransaction();
//				// Persistent
//				find = session.get(Cat.class, find.getId());
//				// Detached
//				tr.commit(); // lay ra (select) commit lam gi
//				session.close();
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

        // Transient
        Cat cat_1 = new Cat("Nami", Date.valueOf("2001-12-13"), false);
        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            if (sessionFactory != null) {
                Session session = sessionFactory.openSession();
                Transaction tr = session.beginTransaction();
                // Persistent
                session.save(cat_1); // cat_1 -> persistent day du thong tin roi
                // Detached
                tr.commit();
                // Detached => Persistent
                session.refresh(cat_1);
                session.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(cat_1.toString());
    }
}