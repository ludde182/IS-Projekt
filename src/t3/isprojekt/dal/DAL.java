
package t3.isprojekt.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import t3.isprojekt.model.Course;
import t3.isprojekt.model.Student;
import t3.isprojekt.model.Studied;

public class DAL {

	private Student student;
	private Course course;
	private Studied studied;
	private DAL dataBaseAccesLayer;

	private String sPnr;
	private String sName;
	private String sAdress;
	private String sTfn;

	private String cCode;
	private String cDescription;
	private int hp;

	static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	static final String DB_URL = "jdbc:sqlserver://localhost;Databasname=IsProjekt";
	// JDBC driver name and database URL

	static final String USER = "root";
	static final String PASS = "root";

	// Database credentials
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

	// Connects to the database.

	public Student findStudent(String sPnr) throws SQLException {
		String findStudentSQL = "SELECT * FROM Student WHERE sPnr= '" + sPnr + "'";
		Connection conn = null;
		PreparedStatement stmt = null;
		stmt = conn.prepareStatement(null);
		ResultSet rset = stmt.executeQuery(findStudentSQL);

		rset.next();
		sPnr = rset.getString(1);
		sName = rset.getString(2);
		sAdress = rset.getString(3);
		sTfn = rset.getString(4);

		student = new Student(sPnr, sName, sAdress, sTfn);

		return student;
	}

	// Finds a student with a sPnr input.

	public Course findCourse(String cCode) throws SQLException {
		String findCourseSQL = "SELECT * FROM Course WHERE cCode= '" + cCode + "'";
		Connection conn = null;
		PreparedStatement stmt = null;
		stmt = conn.prepareStatement(null);
		ResultSet rset = stmt.executeQuery(findCourseSQL);

		rset.next();
		cCode = rset.getString(1);
		cDescription = rset.getString(2);
		hp = Integer.valueOf(rset.getString(3));

		course = new Course(cCode, cDescription, hp);

		return course;
	}

	// Finds a Course with a cCode input.

	public ResultSet findResultOnCourse(int cCode) throws SQLException {
		String findResultOnCourseSQL = "SELECT c.cCode, sPnr, sGrade FROM Course c JOIN Studied s ON c.cCode=s.cCode WHERE c.cCode=?;";
		Connection conn = null;
		PreparedStatement stmt = null;
		stmt = conn.prepareStatement(null);
		ResultSet rset = stmt.executeQuery(findResultOnCourseSQL);

		return rset;
	}
	// Finds a Students result on a specific Course with a cCode input.

	public ResultSet findStudentResult(int sGrade, int sPnr) throws SQLException {
		String findStudentResultSQL = "SELECT s.sPnr, cCode, sGrade FROM Student s JOIN Studied st ON s.sPnr=st.sPnr WHERE s.sPnr=?;";
		Connection conn = null;
		PreparedStatement stmt = null;
		stmt = conn.prepareStatement(null);
		ResultSet rset = stmt.executeQuery(findStudentResultSQL);

		return rset;

	}

	public void addStudent(int spnr, int name) throws SQLException {
		String addStudentSQL = "INSERT INTO Student " + "values(" + spnr + ", " + name + ")";
		Connection conn = null;
		PreparedStatement stmt = null;
		stmt = conn.prepareStatement(null);

		stmt.executeUpdate(addStudentSQL);
	}
	// Adds a Student to the database.

	public void addCourse(String cCode, String cDescription, int hp) throws SQLException {
		String addCourseSQL = "INSERT INTO Course " + "values(" + cCode + ", " + cDescription + ", " + hp + ")"; // attribut
		Connection conn = null;
		PreparedStatement stmt = null;
		stmt = conn.prepareStatement(null);

		stmt.executeUpdate(addCourseSQL);
	}
	// Adds a Course to the database.

	public void deleteStudent(String sPnr) throws SQLException {

		String deleteStudentSQL = "DELETE FROM Student WHERE sPnr =?";
		Connection conn = null;
		PreparedStatement stmt = null;
		stmt = conn.prepareStatement(null);

		stmt.executeUpdate(deleteStudentSQL);
	}
	// Deletes a Student from the database.

	public void deleteCourse(String cCode) throws SQLException {

		String deleteCourseSQL = "DELETE FROM Course WHERE cCode =?";
		Connection conn = null;
		PreparedStatement stmt = null;
		stmt = conn.prepareStatement(null);

		stmt.executeUpdate(deleteCourseSQL);
	}
	// Deletes a Course from the database.

	public void addStudentToStudies(int sPnr, String cCode) throws SQLException {
		String addStudentToStudiesSQL = "INSERT INTO Studies " + "values(" + sPnr + ", " + cCode + ")";
		Connection conn = null;
		PreparedStatement stmt = null;
		stmt = conn.prepareStatement(null);

		stmt.executeUpdate(addStudentToStudiesSQL);
	}
	// Adds a Student to studies.

	public void addCourseToStudied(String cCode, int sPnr, int sGrade) throws SQLException {
		String addCourseToStudiedSQL = "INSERT INTO Studied " + "values(" + cCode + ", " + sPnr + ", " + sGrade + ")";
		Connection conn = null;
		PreparedStatement stmt = null;
		stmt = conn.prepareStatement(null);

		stmt.executeUpdate(addCourseToStudiedSQL);
	}

	// Adds a Course
	public void deleteStudentFromStudies(int sPnr) throws SQLException {
		String deleteStudentFromStudiesSQL = "DELETE Student FROM Studies WHERE sPnr=? ";
		Connection conn = null;
		PreparedStatement stmt = null;
		stmt = conn.prepareStatement(null);
		
		stmt.executeUpdate(deleteStudentFromStudiesSQL);
	}try
	// Deletes Student from Studies.

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