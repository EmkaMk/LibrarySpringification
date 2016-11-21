package com.seavus.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.seavus.entities.Member;
import com.seavus.entities.Publication;

public class DAOMembers implements MembershipDAO {

	private SessionFactory sessionFactory;

	public DAOMembers(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void insertMember(Member m) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(m);
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
	public void updateMember(Member m) {
		// TODO Auto-generated method stub

		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery("UPDATE Member set email = :email WHERE userName = :userName");
			query.setParameter("email", m.getEmail());
			query.setParameter("userName", m.getUserName());
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

	@Override
	public void deleteMember(String username) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery("DELETE FROM Member WHERE userName = :userName");
			query.setParameter("userName", username);
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

	public Member getMember(String userName) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		transaction = session.beginTransaction();
		Member m = session.get(Member.class, userName);
		transaction.commit();
		return m;
	}

	@Override
	public List<Member> list() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();

		Query query = session.createQuery("from Member"); // se raboti so
															// klasi
		ArrayList<Member> list = (ArrayList<Member>) query.list();
		return list;

	}

}
