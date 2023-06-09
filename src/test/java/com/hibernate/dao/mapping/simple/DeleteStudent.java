package com.hibernate.dao.mapping.simple;

import com.hibernate.model.simple.SimpleStudent;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudent {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(SimpleStudent.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {								
			int studentId = 7;
			
			// now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retrieve student based on the id: primary key
			System.out.println("\nGetting student with id: " + studentId);
			
			SimpleStudent myStudent = session.get(SimpleStudent.class, studentId);
			
			// delete the student using delete method
			// System.out.println("Deleting student: " + myStudent);
			// session.delete(myStudent);
			
			// delete student id=2
			System.out.println("Deleting student id = 2");
			
			session.createQuery("delete from Student where id=2").executeUpdate();
			
			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

}





