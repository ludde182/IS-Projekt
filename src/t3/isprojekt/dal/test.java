package t3.isprojekt.dal;

//STEP 1. Import required packages
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import t3.isprojekt.controller.Controller;
import t3.isprojekt.model.Student;

public class test {
	private Student student;
	private Controller controller;
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	static final String DB_URL = "jdbc:sqlserver://localhost;Databasname=IsProjekt";

	// Database credentials
	static final String USER = "root";
	static final String PASS = "root";

	public static void main(String[] args) throws Throwable {
		Connection conn = null;
		Statement stmt = null;

		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

		System.out.println("Connecting to database...");
		conn = DriverManager.getConnection(DB_URL, USER, PASS);

		System.out.println("Creating statement...");
	}

	public Student findStudent(String pnr) throws SQLException {
		student = controller.findStudent(pnr);
		return student;

	}

}