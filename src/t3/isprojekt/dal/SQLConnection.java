package t3.isprojekt.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLConnection {

	public static void main(String[] args) {
		try {
			Connection con;
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url = "jdbc:sqlserver://localhost:1433;database=isprojekt;user=root;password=root;";

			con = DriverManager.getConnection(url);
			System.out.println("Det lyckades!!");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
}
