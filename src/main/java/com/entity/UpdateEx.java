package com.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class UpdateEx {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
		
		SessionFactory factory = cfg.buildSessionFactory(registry);
		
		Session session = factory.openSession();
		/*
		 * When you query the Student object and then update the student
		 * object - it gives NonUniqueObjectException
		 * so instead use Merge
		 */
		
		Student stu = (Student) session.get(Student.class, 2);
		System.out.println(stu.getEmail());
		
		Student st = new Student();
		st.setId(1); 
		st.setName("dinesh");
		st.setEmail("dinesh@gm.com");
		
		Transaction tx = session.beginTransaction();
		
		/*		session.update(st);	*/
		session.merge(st);
		
		tx.commit();		
		factory.close();
	}
	
}
