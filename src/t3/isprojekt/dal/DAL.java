
package t3.isprojekt.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

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
	private String sGrade;
	// JDBC driver name and database URL

	static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	static final String DB_URL = "jdbc:sqlserver://localhost;Databasname=IsProjekt";

	// Database credentials
	static final String USER = "root";
	static final String PASS = "root";

	public static void main(String[] args) {

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = null;
			Statement stmt = null;
			stmt = conn.createStatement();

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
			Statement stmt = null;
			stmt = conn.createStatement();
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

	/***************************************
	 * Search methods
	 **************************************/
	// Finds a student with a sPnr input.
	public Student findStudent(String sPnr) throws SQLException {
		String findStudentSQL = "SELECT * FROM Student WHERE sPnr= '" + sPnr + "'";
		Connection conn = null;
		Statement stmt = null;
		stmt = conn.createStatement();
		ResultSet rset = stmt.executeQuery(findStudentSQL);

		rset.next();
		sPnr = rset.getString(1);
		sName = rset.getString(2);
		sAdress = rset.getString(3);
		sTfn = rset.getString(4);

		student = new Student(sPnr, sName, sAdress, sTfn);

		return student;
		stmt.close();
	}

	// Finds all courses and returns a list.
	public String[] findAllCourses() throws SQLException {
		ArrayList<Course> courseList = new ArrayList<Course>();
		String findAllCoursesSQL = "Select* FROM Course;";
		Connection conn = null;
		Statement stmt = null;
		stmt = conn.createStatement();
		ResultSet rset = stmt.executeQuery(findAllCoursesSQL);
		while (rset.next()) {
			course = new Course(rset.getString(1), rset.getString(2), rset.getInt(3));
			courseList.add(course);
		}
		int i = 0;
		String[] clist = new String[courseList.size()];
		for (Course c : courseList) {
			clist[i] = c.getcCode();
			i++;
		}
		return clist;
		stmt.close();
	}

	// Finds a Course with a cCode input.
	public Course findCourse(String cCode) throws SQLException {
		String findCourseSQL = "SELECT * FROM Course;";
		Connection conn = null;
		Statement stmt = null;
		stmt = conn.createStatement();
		ResultSet rset = stmt.executeQuery(findCourseSQL);

		rset.next();
		cCode = rset.getString(1);
		cDescription = rset.getString(2);
		hp = Integer.valueOf(rset.getString(3));

		course = new Course(cCode, cDescription, hp);

		return course;
		stmt.close();
	}

	// Finds a Students result on a specific Course with a cCode input.
	public ArrayList<Student> findResultOnCourse(String cCode) throws SQLException {
		ArrayList<Student> resultList = new ArrayList<Student>();

		String findResultOnCourseSQL = "SELECT c.cCode, sPnr, sGrade FROM Student sa JOIN Studied s ON s.sPnr=sa.sPnr WHERE c.cCode = '"
				+ cCode + "'";
		Connection conn = null;
		Statement stmt = null;
		stmt = conn.createStatement();
		ResultSet rset = stmt.executeQuery(findResultOnCourseSQL);

		while (rset.next()) {
			student = new Student(rset.getString(1), rset.getString(2), rset.getString(3), rset.getString(4));
			resultList.add(student);
		}
		return resultList;
		stmt.close();
	}

	// Finds a specific Students result.
	public ArrayList<Studied> findStudentResult(String cCode, String sPnr) throws SQLException {
		ArrayList<Studied> studiedList = new ArrayList<Studied>();

		String findStudentResultSQL = "SELECT s.sPnr, cCode, sGrade FROM Studied WHERE sPnr='" + sPnr + "'and cCode='"
				+ cCode + "'";
		Connection conn = null;
		Statement stmt = null;
		stmt = conn.createStatement();
		ResultSet rset = stmt.executeQuery(findStudentResultSQL);

		while (rset.next()) {
			if (rset.getString(2) != null) {
				studied = new Studied(rset.getString(1), rset.getString(2), rset.getString(3));
				studiedList.add(studied);
			}
			return studiedList;
		}
		stmt.close();
	}

	// Calculates how many percent of the Students got an A on a specific
	// Course.
	public String findPercentageGradeA(String cCode, String sGrade) throws SQLException {
		String findPercentageGradeASQL = "SELECT sGrade, (COUNT(sGrade))*100 / (SELECT COUNT(*) FROM Studied WHERE cCode='"
				+ cCode + "')) AS GradePercentage" + "FROM Studied GROUP BY cCode, sGrade HAVING cCode='" + cCode
				+ "' AND sGrade'A'";
		String gradePercent;

		Connection conn = null;
		Statement stmt = null;
		stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery(findPercentageGradeASQL);

		while (rs.next()) {
			gradePercent = rs.getString(2);
		}
		return gradePercent;
		stmt.close();
	}

	// Finds all Students reading a specific course.
	public ArrayList<Student> findAllStudetsReadingCourse(String cCode) throws SQLException {
		ArrayList<Student> currentlyReadingList = new ArrayList<Student>();

		String findAllStudentsReadingCourseSQL = "SELECT s.sPnr, s.sName, s.sAdress, s.sTfn  FROM Studies e INNER JOIN Student ON e.sPnr=s.sPnr WHERE e.cCode='"
				+ cCode + "';";

		Connection conn = null;
		Statement stmt = null;
		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(findAllStudentsReadingCourseSQL);

		while (rs.next()) {
			student = new Student(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
			currentlyReadingList.add(student);
		}
		return currentlyReadingList;
		stmt.close();
	}

	/*****************************************
	 * Manage database
	 *********************************/
	// Adds a Student to the database.
	public boolean addStudent(String sPnr, String sName, String sAdress, String sTfn) throws SQLException {
		String addStudentSQL = "INSERT INTO Student " + "values('" + sPnr + "', '" + sName + "', '" + sAdress + "', "
				+ sTfn + ")";
		Connection conn = null;
		Statement stmt = null;
		stmt = conn.createStatement();

		stmt.executeUpdate(addStudentSQL);
		stmt.close();
	}

	// Adds a Course to the database.
	public boolean addCourse(String cCode, String cDescription, int hp) throws SQLException {

		String addCourseSQL = "INSERT INTO Course " + "values('" + cCode + "', '" + cDescription + "', '" + hp + "')";
		Connection conn = null;
		Statement stmt = null;
		stmt = conn.createStatement();

		stmt.executeUpdate(addCourseSQL);
		stmt.close();
	}

	// Deletes a Student from the database.
	public boolean deleteStudent(String sPnr) throws SQLException {

		String deleteStudentSQL = "DELETE FROM Student WHERE sPnr='" + sPnr + "'";
		Connection conn = null;
		Statement stmt = null;
		stmt = conn.createStatement();

		stmt.executeUpdate(deleteStudentSQL);
		stmt.close();
	}

	// Deletes a Course from the database.
	public boolean deleteCourse(String cCode) throws SQLException {

		String deleteCourseSQL = "DELETE FROM Course WHERE cCode='" + cCode + "'";
		Connection conn = null;
		Statement stmt = null;
		stmt = conn.createStatement();

		stmt.executeUpdate(deleteCourseSQL);
		stmt.close();
	}

	// Adds a Student to studies.
	public boolean addStudentToStudies(String sPnr, String cCode) throws SQLException {
		String addStudentToStudiesSQL = "INSERT INTO Studies " + "values(" + sPnr + ", " + cCode + ")";
		Connection conn = null;
		Statement stmt = null;
		stmt = conn.createStatement();

		stmt.executeUpdate(addStudentToStudiesSQL);
		stmt.close();
	}

	// Adds a Course to Studied.
	public boolean addStudentToStudied(String cCode, String sPnr, String sGrade) throws SQLException {
		String addStudentToStudiedSQL = "INSERT INTO Studied " + "values(" + cCode + ", " + sPnr + ", " + sGrade + ")";
		Connection conn = null;
		Statement stmt = null;
		stmt = conn.createStatement();

		stmt.executeUpdate(addStudentToStudiedSQL);
		stmt.close();
	}

	// Adds a Course
	public boolean deleteStudentFromStudies(String sPnr, String cCode) throws SQLException {
		String deleteStudentFromStudiesSQL = "DELETE Student FROM Studies WHERE sPnr='" + sPnr + "' AND cCode='" + cCode
				+ "';";
		Connection conn = null;
		Statement stmt = null;
		stmt = conn.createStatement();

		stmt.executeUpdate(deleteStudentFromStudiesSQL);
		stmt.close();
	}
	// Deletes Student from Studies.

	// Handles exceptions from the SQLmethods.
	}catch(

	SQLException se3)

	{

		se3.printStackTrace();
	} finally

	{
		  System.out.println();

}
}}