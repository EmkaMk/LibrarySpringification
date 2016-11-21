package com.seavus.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.seavus.entities.Book;

public class JDBCDao {

	Book book;
	Connection con = null;

	public void connectToBase() {

		try {
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/library", "postgres", "Password1");
			System.out.println("DB connected");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void register(Book b) throws SQLException {
		PreparedStatement statement = null;

		statement = (PreparedStatement) con.prepareStatement("insert into book (isbn, title) values(?,?)");
		
		statement.setLong(1, b.getIsbn());
		statement.setString(2, b.getTitle());
		statement.executeUpdate();
		statement.close();

	}

	public void listRegisteredBooks() throws SQLException {
	

		Statement statement=con.createStatement();
		ResultSet books=statement.executeQuery("select * from book");
		while(books.next())
		{
			long id=books.getLong("id");
			long isbn=books.getLong("isbn");
			String title=books.getString("title");
			System.out.println("Id "+id+",isbn: "+isbn+",title: "+title);
		}
		statement.close();

	}
	
	public void updateTitle(Book b,String title) throws SQLException
	{
		Long id=b.getId();
		PreparedStatement statement=(PreparedStatement) con.prepareStatement("update book set title=? where id=?");
		statement.setString(1, title);
		statement.setLong(2, id);
		statement.executeUpdate();
		statement.close();
	}
	
	public void unregisterBook(long id) throws SQLException
	{
		
		PreparedStatement statement=con.prepareStatement("DELETE FROM book WHERE id=?");
		statement.setLong(1, id);
		statement.executeUpdate();
		statement.close();
	}
	

}
