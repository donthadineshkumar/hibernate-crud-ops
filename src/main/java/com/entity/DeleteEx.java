package com.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class DeleteEx {

	public static void main(String[] args) {
		
		Configuration cfg  = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
		
		SessionFactory factory = cfg.buildSessionFactory(registry);
		Session session = factory.openSession();
		
		Transaction tx = session.beginTransaction();
		
		Student st = new Student();
		st.setId(3);
		
		session.delete(st);
		tx.commit();
		
		factory.close();
		
		
	}
	
}
