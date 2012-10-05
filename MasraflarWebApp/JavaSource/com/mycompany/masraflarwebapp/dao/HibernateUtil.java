package com.mycompany.masraflarwebapp.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public  class HibernateUtil {

	private static final SessionFactory sessionFactory;

	static {
		try {
			// Create the SessionFactory from standard (hibernate.cfg.xml)
			// config file.
			sessionFactory = new Configuration().configure("hibernate.cfg.xml")
					.buildSessionFactory();
		} catch (Throwable ex) {
			// Log the exception.
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}	
	

	public void save(Object clazz) {
		// TODO Auto-generated method stub
		try {

			GetBeginTransaction();
			sessionFactory.getCurrentSession().save(clazz);
			TarnsactionCommit();
			TransactionClose();
		} catch (RuntimeException re) {
			throw re;
		}

	}

	public void delete(Object clazz) {
		// TODO Auto-generated method stub
		try {

			GetBeginTransaction();
			sessionFactory.getCurrentSession().delete(clazz);
			TarnsactionCommit();
			TransactionClose();
		} catch (RuntimeException re) {
			throw re;
		}

	}

	private void TransactionClose() {
		sessionFactory.getCurrentSession().close();
	}

	private void TarnsactionCommit() {
		sessionFactory.getCurrentSession().getTransaction().commit();
	}

	private void GetBeginTransaction() {
		sessionFactory.getCurrentSession().beginTransaction();
	}
	
	
}
