package com.hibernate.dao.mapping.one.to.one.sharedPK.bi;

import com.hibernate.model.one.to.one.sharedPK.bi.Book;
import com.hibernate.model.one.to.one.sharedPK.bi.Manuscript;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AddManuscriptToBook {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Book.class)
								.addAnnotatedClass(Manuscript.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {

			// start a transaction
			session.beginTransaction();

			// get the product cucumber from database
			int bookId = 2;
			Book tempBook = session.get(Book.class, bookId);

			System.out.println("\nLoaded Car: " + tempBook);

			Manuscript manuscript = new Manuscript("Copy Write");
			manuscript.setBook(tempBook);

			// add manuscript to book (No Need For This Line)
			// tempBook.setManuscript(manuscript);

			// save the manuscript
			System.out.println("\nSaving the Engine ...");

			session.save(manuscript);

			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

}





