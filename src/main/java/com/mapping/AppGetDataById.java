package com.mapping;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.mapping.Entity.Answer;
import com.mapping.Entity.Question;
import com.mapping.Utility.HibernateUtility;

public class AppGetDataById {

	public static void main(String[] args) {
		//Get Data By Id
		SessionFactory factory = HibernateUtility.getSessionFactory();
	    Session session = factory.openSession();
	    Transaction transaction = session.beginTransaction();

	    Question dataId = session.find(Question.class, 3);
	    System.out.println(dataId.getQuestion());
	    
	    System.out.println("Question ID : " + dataId.getId());
	    System.out.println("Question: " + dataId.getQuestion());
	    
	    List<Answer> ansList = dataId.getAnswerList();
	    System.out.println("Answers: ");
	    ansList.stream().forEach(a -> System.out.println(a.toString()));
	    
	    transaction.commit();
	    session.close();
	}
}
