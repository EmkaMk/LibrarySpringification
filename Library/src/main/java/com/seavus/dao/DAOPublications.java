package com.seavus.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.seavus.entities.BasicEntity;
import com.seavus.entities.Book;
import com.seavus.entities.Magazine;
import com.seavus.entities.Member;
import com.seavus.entities.Publication;

public class DAOPublications implements PublicationsDAO {
	SessionFactory sessionFactory;

	public DAOPublications(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	public void insert(Publication p) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(p);
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		} finally {
			session.close();
		}

	}

	public void update(Book b) {

		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery("UPDATE Publication set title = :title WHERE isbn = :isbn");
			query.setParameter("title", b.getTitle());
			query.setParameter("isbn", b.getIsbn());
			query.executeUpdate();
			transaction.commit();

		} catch (RuntimeException e) {
			if (transaction != null) {
				transaction.rollback();
			}

		} finally {
			session.close();
		}

	}

	public void update(Magazine m) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery("UPDATE Publication set title = :title WHERE issn = :issn");
			query.setParameter("title", m.getTitle());
			query.setParameter("issn", m.getIssn());
			query.executeUpdate();

		} catch (RuntimeException e) {
			if (transaction != null) {
				transaction.rollback();
			}

		} finally {
			session.close();
		}

	}

	public void delete(Book b) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery("DELETE FROM Book WHERE isbn = :isbn");
			query.setParameter("isbn", b.getIsbn());
			int result = query.executeUpdate();
			System.out.println("Rows affected: " + result);

			transaction.commit();

		} catch (RuntimeException e) {
			if (transaction != null) {
				transaction.rollback();
			}

		} finally {
			session.close();
		}

	}

	public void deleteMagazine(Long issn) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery("DELETE FROM Publication WHERE issn = :issn");
			query.setParameter("issn", issn);
			int result = query.executeUpdate();
			System.out.println("Rows affected: " + result);

			transaction.commit();

		} catch (RuntimeException e) {
			if (transaction != null) {
				transaction.rollback();
			}

		} finally {
			session.close();
		}

	}

	public void deleteBook(Long isbn) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery("DELETE FROM Publication WHERE isbn = :isbn");
			query.setParameter("isbn", isbn);
			int result = query.executeUpdate();
			System.out.println("Rows affected: " + result);

			transaction.commit();

		} catch (RuntimeException e) {
			if (transaction != null) {
				transaction.rollback();
			}

		} finally {
			session.close();
		}

	}

	public ArrayList<Publication> list() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();

		Query query = session.createQuery("from Publication"); // se raboti so
																// klasi
		ArrayList<Publication> list = (ArrayList<Publication>) query.list();
		return list;
	}
	
	public Publication getByID(String id)
	{
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		transaction = session.beginTransaction();
		Publication p=session.get(Publication.class, id);
		transaction.commit();
		return p;
	}

}
