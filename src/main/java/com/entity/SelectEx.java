package com.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class SelectEx {
	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
		SessionFactory factory = cfg.buildSessionFactory(registry);
		Session session = factory.openSession();
		

		Student st  = (Student) session.get(Student.class, 1);
		System.out.println(st.getId());
		//for load: eager - Fires the select on db as soon as get is called
		System.out.println(st.getName());
		
		
		//for select op I dont need a transaction
		/*
		Student st  = (Student) session.load(Student.class, 1);
		System.out.println(st.getId());
		//for load: lazy - fires the select - when a non-pk is queried
		System.out.println(st.getName());
		*/
		
		
		
		factory.close();
		
		
	}

}
