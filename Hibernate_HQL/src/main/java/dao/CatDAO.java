package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Cat;
import util.HibernateUtil;

public class CatDAO implements DAOInterface<Cat> {

    @Override
    public List<Cat> selecAll() {
        List<Cat> list = new ArrayList<>();
        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            if (sessionFactory != null) {
                Session session = sessionFactory.openSession();
                Transaction tr = session.beginTransaction();
                // Thuc thi cau lenh HQL
                String hql = "FROM Cat";
                Query query = session.createQuery(hql);
                list = query.getResultList();
                tr.commit();
                session.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Cat selectById(Cat t) {
        List<Cat> list = new ArrayList<>();
        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            if (sessionFactory != null) {
                Session session = sessionFactory.openSession();
                Transaction tr = session.beginTransaction();
                // Thuc thi cau lenh HQL
                String hql = "FROM Cat WHERE id = :id";
                Query query = session.createQuery(hql);
                query.setParameter("id", t.getId());
                list = query.getResultList();
                tr.commit();
                session.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (list.size()) > 0 ? list.get(0) : null;
    }

    @Override
    public boolean insert(Cat t) {
        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            if (sessionFactory != null) {
                Session session = sessionFactory.openSession();
                Transaction tr = session.beginTransaction();
                // Tien hanh insert
                //save or saveOrUpdate
                session.save(t);
                tr.commit();
                session.close();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Cat t) {
        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            if (sessionFactory != null) {
                Session session = sessionFactory.openSession();
                Transaction tr = session.beginTransaction();
                // Tien hanh insert
                session.update(t);
                tr.commit();
                session.close();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Cat t) {
        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            if (sessionFactory != null) {
                Session session = sessionFactory.openSession();
                Transaction tr = session.beginTransaction();
                // Tien hanh insert
                //save or saveOrUpdate
                session.delete(t);
                tr.commit();
                session.close();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
