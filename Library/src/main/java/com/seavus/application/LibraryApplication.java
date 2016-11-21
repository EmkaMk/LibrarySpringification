package com.seavus.application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.seavus.controllers.LoanController;
import com.seavus.controllers.MemberController;
import com.seavus.dao.DAOLoan;
import com.seavus.dao.DAOMembers;
import com.seavus.dao.DAOPublications;
import com.seavus.dao.LoanDAO;
import com.seavus.dao.MembershipDAO;
import com.seavus.dao.PublicationsDAO;
import com.seavus.entities.Book;
import com.seavus.entities.Loan;
import com.seavus.entities.Magazine;
import com.seavus.entities.Member;
import com.seavus.service.LoanService;
import com.seavus.service.MemberService;
import com.seavus.service.PublicationsService;
import com.seavus.service.exceptions.NoSuchElementException;

public class LibraryApplication {

	public static void main(String[] args) throws NoSuchElementException {
		// TODO Auto-generated method stub
		Configuration configuration = new Configuration();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		SessionFactory sessionFactory = configuration.addAnnotatedClass(Book.class).addAnnotatedClass(Magazine.class)
				.addAnnotatedClass(Loan.class).addAnnotatedClass(Member.class).buildSessionFactory(serviceRegistry);
		PublicationsDAO dao = new DAOPublications(sessionFactory);
		MembershipDAO mdao = new DAOMembers(sessionFactory);
		LoanDAO ldao = new DAOLoan(sessionFactory);

		/*
		 * PublicationLogic logic=new PublicationLogic(new
		 * PublicationController(new PublicationsService(dao))); logic.run();
		 */
		MemberLogic logic = new MemberLogic(new MemberController(new MemberService(mdao)));
		logic.run();

	}

}
