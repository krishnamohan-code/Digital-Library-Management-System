package dao;

import java.sql.SQLException;

import model.Books;
import model.Users;

public interface UserDaoInterface {
	int signUp(Users user);
	int addBooks(Books book);
	boolean loginUser(Users user);
}