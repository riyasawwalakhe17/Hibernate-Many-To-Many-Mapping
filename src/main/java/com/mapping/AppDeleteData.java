package com.mapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.mapping.Entity.Question;
import com.mapping.Utility.HibernateUtility;

public class AppDeleteData {

	
	public static void main(String[] args) {
		//Delete data
		SessionFactory factory = HibernateUtility.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		Question delId = session.find(Question.class, 2);
		session.remove(delId);

		transaction.commit();
		session.close();
	}
}
