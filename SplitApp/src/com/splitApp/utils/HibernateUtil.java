package com.splitApp.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {
	
	private static final SessionFactory sessionFactory = buildSessionFactory();
	
	private static SessionFactory buildSessionFactory(){
		
		try{
			Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
			return configuration.buildSessionFactory();
			
		}catch(Exception e){
			System.out.println(e);
			throw new IndexOutOfBoundsException(e.getMessage());
		}	
	}
	
	
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}

}
