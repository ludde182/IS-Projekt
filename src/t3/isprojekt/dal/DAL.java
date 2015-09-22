
package t3.isprojekt.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAL {
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	static final String DB_URL = "jdbc:sqlserver://localhost;Databasname=IsProjekt";
	// 3306,3305

	// Database credentials
	static final String USER = "root";
	static final String PASS = "root";

	public static void main(String[] args) {

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = null;
			PreparedStatement stmt = null;
			stmt = conn.prepareStatement(null);

			// Open a connection
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (SQLException se) {
			se.printStackTrace();
		} // Handle errors for JDBC

		catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// close resources
			Connection conn = null;
			PreparedStatement stmt = null;
			stmt = conn.prepareStatement(null);
			try {
				if (stmt != null)
					stmt.close();
			}

			catch (SQLException se2) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
	}

	public ResultSet findStudent(int spnr) throws SQLException {
		String findStudentSQL = "SELECT * FROM Student WHERE spnr=?";
		Connection conn = null;
		PreparedStatement stmt = null;
		stmt = conn.prepareStatement(null);
		ResultSet rset = stmt.executeQuery(findStudentSQL);

		return rset;
	}

	public ResultSet findCourse(String ccode) throws SQLException {
		String findCourseSQL = "SELECT * FROM Course WHERE ccode=?";
		Connection conn = null;
		PreparedStatement stmt = null;
		stmt = conn.prepareStatement(null);
		ResultSet rset = stmt.executeQuery(findCourseSQL);

		return rset;
	}

	public ResultSet findResultOnCourse(int spnr) throws SQLException {
		String findResultOnCourseSQL = "SELECT" + cCode + ", " + sPnr + ", " + Sgrade + " FROM Student INNER JOIN cCO"
				+ "ourse,";
		Connection conn = null;
		PreparedStatement stmt = null;
		stmt = conn.prepareStatement(null);
		ResultSet rset = stmt.executeQuery(findResultOnCourseSQL); // EJKLAR
																	// HJÄLPSNÄLLASLUTA

		return rset;
	}

	public void addStudent(int spnr, int name) throws SQLException {
		String addStudentSQL = "INSERT INTO Student " + "values(" + spnr + ", " + name + ")";
		Connection conn = null;
		PreparedStatement stmt = null;
		stmt = conn.prepareStatement(null);
		stmt.executeUpdate(addStudentSQL);
	}

	public void addCourse(String ccode, String cdescription, int hp) throws SQLException {
		String addCourseSQL = "INSERT INTO Course " + "values(" + ccode + ", " + cdescription + ", " + hp + ")"; // attribut
		Connection conn = null;
		PreparedStatement stmt = null;
		stmt = conn.prepareStatement(null);
		stmt.executeUpdate(addCourseSQL);
	}

	public void deleteStudent(String spnr) throws SQLException {

		String deleteStudentSQL = "DELETE FROM Student WHERE spnr =?";
		Connection conn = null;
		PreparedStatement stmt = null;
		stmt = conn.prepareStatement(null);
		stmt.executeUpdate(deleteStudentSQL);
	}

	public void deleteCourse(String ccode) throws SQLException {

		String deleteCourseSQL = "DELETE FROM Course WHERE ccode =?";
		Connection conn = null;
		PreparedStatement stmt = null;
		stmt = conn.prepareStatement(null); // lägga till catch i
											// felhateringsklass eller
											// motsvarande
		stmt.executeUpdate(deleteCourseSQL);
	}

	public void addStudentToStudies(int sPnr, String cCode) throws SQLException {
		String addStudentToStudiesSQL = "INSERT INTO Studies " + "values(" + sPnr + ", " + cCode + ")";
		Connection conn = null;
		PreparedStatement stmt = null;
		stmt = conn.prepareStatement(null);
		stmt.executeUpdate(addStudentToStudiesSQL);
	}

	public void addCourseToStudied(String cCode, int sPnr, int sGrade) throws SQLException {
		String addCourseToStudiedSQL = "INSERT INTO Studied " + "values(" + cCode + ", " + sPnr + ", " + sGrade + ")";
		Connection conn = null;
		PreparedStatement stmt = null;
		stmt = conn.prepareStatement(null);
		stmt.executeUpdate(addCourseToStudiedSQL);
	}

	public void deleteStudentFromStudies(int spnr) throws SQLException {
		String deleteStudentFromStudiesSQL = "DELETE Student FROM Studies WHERE sPnr=? ";
		Connection conn = null;
		PreparedStatement stmt = null;
		stmt = conn.prepareStatement(null);
		stmt.executeUpdate(deleteStudentFromStudiesSQL);
	}try

	{
		// Handles exceptions from the SQLmethods
	} catch(

	SQLException se3)

	{
			 se3.printStackTrace();
		finally {
		  System.out.

	println(HA det);
}}