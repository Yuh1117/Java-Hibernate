package test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.CuocHop;
import model.NhanVien;
import util.HibernateUtil;

public class Test {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		if (sessionFactory != null) {
			Session session = sessionFactory.openSession();
			Transaction tr = session.beginTransaction();
			
//			NhanVien nv1 = new NhanVien("NV1", "LNTung", Date.valueOf("2000-11-12"));
//			session.save(nv1);
			
//			NhanVien nv1 = session.find(NhanVien.class, "NV1");
//			CuocHop ch1 = new CuocHop("Họp Hội đồng quản trị công ty", "Phòng họp 1", Date.valueOf("2003-01-02"));
//			ch1.addNhanVien(nv1);
//			
//			session.save(ch1);
//			
			NhanVien nv1 = session.find(NhanVien.class, "NV1");
			Set<NhanVien> s = new HashSet<NhanVien>();
			s.add(nv1);
			
			CuocHop ch2 = new CuocHop("Thich thi hop", "Phòng họp 2", Date.valueOf("2004-04-01"), s);
			//CuocHop ko can addNhanVien()
			session.save(ch2);
			
			tr.commit();
			session.close();
		}
	}
}
