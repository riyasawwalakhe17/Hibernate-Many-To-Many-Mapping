package com.mapping;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.mapping.Entity.Answer;
import com.mapping.Entity.Question;
import com.mapping.Utility.HibernateUtility;

public class AppGetUpdateData {

	public static void main(String[] args) {
		// Get Update data
		SessionFactory factory = HibernateUtility.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		// To update the data First fetch it and then set the values

		Question que = session.find(Question.class, 2);
		// update question
		que.setQuestion("Where are you from ");

		Answer ans = session.find(Answer.class, 3);
		// update ans
		ans.setAnswer("I live in mumbai");

		que.getAnswerList().add(ans);

		ans.getQuestionList().add(que);

		transaction.commit();
		session.close();

		System.out.println("Updated ");

	}
}
