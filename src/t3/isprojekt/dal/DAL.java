
package t3.isprojekt.dal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAL {
	Connection conn;
	Statement stmt;

	public String writeAllStudentNames() throws SQLException {
		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select sname from student");
		while (rs.next()) {
			System.out.println(rs.getString("sname"));
		}
		stmt.close();

		return rs.getString("sname");
	}
}
