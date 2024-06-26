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
//		Test selectall
//		CatDAO cd = new CatDAO();
//		List<Cat> list = cd.selecAll();
//		for(Cat c : list) {
//			System.out.println(c.toString());
//		}

//		Test selectbyid
//		CatDAO cd = new CatDAO();
//		Cat find = new Cat();
//		find.setId(1);
//		Cat c = cd.selectById(find);
//		System.out.println(c);

		//Test insert
//		CatDAO cd = new CatDAO();
//		Cat c = new Cat("Moon", Date.valueOf("2004-12-12"), false);
//		cd.insert(c);

		//Test update Moon -> Mon
//		CatDAO cd = new CatDAO();
//		Cat c = new Cat("Mon", Date.valueOf("2004-12-12"), false);
//		c.setId(5);
//		cd.update(c);

		//Test delete Jerry id 4
		CatDAO cd = new CatDAO();
		Cat c = new Cat();
		c.setId(4);
		cd.delete(c);
	}
}