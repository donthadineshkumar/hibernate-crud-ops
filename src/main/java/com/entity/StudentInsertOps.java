package com.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class StudentInsertOps {
	
	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
		
		SessionFactory factory = cfg.buildSessionFactory(registry);
		
		Session session = factory.openSession();
		
		Student st = new Student();
		st.setId(2);
		st.setName("Richa");
		st.setEmail("richyricha@gmail.com");
		
		Transaction tx = session.beginTransaction();
		
/*		int pk = (Integer)session.save(st);
		System.out.println("Your primary key is "+ pk);*/
		
		/*session.persist(st);*/
		
		session.saveOrUpdate(st);
		
		tx.commit();		
		
		Student st1 = (Student)session.get(Student.class, 2);
		System.out.println(st1.getName());
		
		
		factory.close();
		
	}

}
