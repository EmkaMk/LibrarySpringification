package com.seavus.dao;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.seavus.entities.Loan;
import com.seavus.entities.Publication;

public class DAOLoan implements LoanDAO {

	private SessionFactory sessionFactory;

	public DAOLoan(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void registerLoan(Loan l) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(l);
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

	@Override
	public ArrayList<Loan> listLoans() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Loan");
		ArrayList<Loan> list = (ArrayList<Loan>) query.list();
		return list;
	}

	public Loan getById(String id) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("FROM Loan where id=:id");
		query.setParameter("id", id);
		return (Loan) query.uniqueResult();
	}

}
