
package t3.isprojekt.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import t3.isprojekt.model.Course;
import t3.isprojekt.model.Student;
import t3.isprojekt.model.Studied;

public class DAL {

	private Student student;
	private Course course;
	private Studied studied;
	// private DAL dataBaseAccesLayer;

	// private String sPnr;
	private String sName;
	private String sAdress;
	private String sTfn;

	// private String cCode;
	private String cDescription;
	private int hp;
	// private String sGrade;
	// JDBC driver name and database URL

	// Database credentials

	private static String connStr = "jdbc:sqlserver://Localhost;Databases=IsProjekt;user=root;password=root;";

	public static Connection getConn() throws SQLException {
		return DriverManager.getConnection(connStr);
	}

	/***************************************
	 * Search methods
	 **************************************/
	// Finds a student with a sPnr input.
	public Student findStudent(String sPnr) {
		String findStudentSQL = "SELECT * FROM Student WHERE sPnr= '" + sPnr + "'";
		Statement stmt = null;

		try {
			stmt = getConn().createStatement();
			ResultSet rset = stmt.executeQuery(findStudentSQL);

			while (rset.next()) {
				rset.next();
				sPnr = rset.getString(1);
				sName = rset.getString(2);
				sAdress = rset.getString(3);
				sTfn = rset.getString(4);

				student = new Student(sPnr, sName, sAdress, sTfn);

				stmt.close();
				rset.close();
				getConn().close();
			}
		} catch (SQLException se) {
			se.printStackTrace();

		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return student;
	}

	// Finds all courses and returns a list.
	public String[] findAllCourses() throws SQLException {
		String findAllCoursesSQL = "Select* FROM Course;";
		Statement stmt = null;
		ArrayList<Course> courseList = new ArrayList<Course>();
		String[] clist = new String[courseList.size()];

		try {
			stmt = getConn().createStatement();
			ResultSet rset = stmt.executeQuery(findAllCoursesSQL);
			while (rset.next()) {
				course = new Course(rset.getString(1), rset.getString(2), rset.getInt(3));
				courseList.add(course);
			}
			int i = 0;

			for (Course c : courseList) {
				clist[i] = c.getcCode();
				i++;
			}

			rset.close();
			stmt.close();
			getConn().close();

		} catch (SQLException se) {
			se.printStackTrace();

		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}

		return clist;
	}

	// Finds a Course with a cCode input.
	public Course findCourse(String cCode) throws SQLException {
		String findCourseSQL = "SELECT * FROM Course;";
		Statement stmt = null;

		try {

			stmt = getConn().createStatement();
			ResultSet rset = stmt.executeQuery(findCourseSQL);

			rset.next();
			cCode = rset.getString(1);
			cDescription = rset.getString(2);
			hp = Integer.valueOf(rset.getString(3));

			course = new Course(cCode, cDescription, hp);

			rset.close();
			stmt.close();
			getConn().close();

		} catch (SQLException se) {
			se.printStackTrace();

		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}
		return course;
	}

	// Finds a Students result on a specific Course with a cCode input.
	public ArrayList<Student> findResultOnCourse(String cCode) throws SQLException {
		String findResultOnCourseSQL = "SELECT c.cCode, sPnr, sGrade FROM Student sa JOIN Studied s ON s.sPnr=sa.sPnr WHERE c.cCode = '"
				+ cCode + "'";
		ArrayList<Student> resultList = new ArrayList<Student>();
		Statement stmt = null;

		try {
			stmt = getConn().createStatement();
			ResultSet rset = stmt.executeQuery(findResultOnCourseSQL);

			while (rset.next()) {
				student = new Student(rset.getString(1), rset.getString(2), rset.getString(3), rset.getString(4));
				resultList.add(student);
			}

			rset.close();
			stmt.close();
			getConn().close();
		} catch (SQLException se) {
			se.printStackTrace();

		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}
		return resultList;
	}

	// Finds a specific Students result.
	public ArrayList<Studied> findStudentResult(String cCode, String sPnr) throws SQLException {
		String findStudentResultSQL = "SELECT s.sPnr, cCode, sGrade FROM Studied WHERE sPnr='" + sPnr + "'and cCode='"
				+ cCode + "'";
		ArrayList<Studied> studiedList = new ArrayList<Studied>();
		Statement stmt = null;

		try {

			stmt = getConn().createStatement();
			ResultSet rset = stmt.executeQuery(findStudentResultSQL);

			while (rset.next()) {
				if (rset.getString(2) != null) {
					studied = new Studied(rset.getString(1), rset.getString(2), rset.getString(3));
					studiedList.add(studied);
				}
			}

			rset.close();
			stmt.close();
			getConn().close();
		} catch (SQLException se) {
			se.printStackTrace();

		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}
		return studiedList;
	}

	// Calculates how many percent of the Students got an A on a specific
	// Course.
	public String findPercentageGradeA(String cCode, String sGrade) throws SQLException {
		String findPercentageGradeASQL = "SELECT sGrade, (COUNT(sGrade))*100 / (SELECT COUNT(*) FROM Studied WHERE cCode='"
				+ cCode + "')) AS GradePercentage" + "FROM Studied GROUP BY cCode, sGrade HAVING cCode='" + cCode
				+ "' AND sGrade'A'";

		Statement stmt = null;
		String gradePercent = null;

		try {
			stmt = getConn().createStatement();

			ResultSet rs = stmt.executeQuery(findPercentageGradeASQL);

			while (rs.next()) {
				gradePercent = rs.getString(2);
			}

			rs.close();
			stmt.close();
			getConn().close();

		} catch (SQLException se) {
			se.printStackTrace();

		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}
		return gradePercent;
	}

	// Finds all Students reading a specific course.
	public ArrayList<Student> findAllStudetsReadingCourse(String cCode) throws SQLException {
		String findAllStudentsReadingCourseSQL = "SELECT s.sPnr, s.sName, s.sAdress, s.sTfn  FROM Studies e INNER JOIN Student ON e.sPnr=s.sPnr WHERE e.cCode='"
				+ cCode + "';";

		ArrayList<Student> currentlyReadingList = new ArrayList<Student>();
		Statement stmt = null;

		try {

			stmt = getConn().createStatement();
			ResultSet rs = stmt.executeQuery(findAllStudentsReadingCourseSQL);

			while (rs.next()) {
				student = new Student(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
				currentlyReadingList.add(student);
			}
			rs.close();
			stmt.close();
			getConn().close();
		} catch (SQLException se) {
			se.printStackTrace();

		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}
		return currentlyReadingList;
	}

	/*****************************************
	 * Manage database
	 *********************************/
	// Adds a Student to the database.
	public boolean addStudent(String sPnr, String sName, String sAdress, String sTfn) throws SQLException {
		String addStudentSQL = "INSERT INTO Student " + "values('" + sPnr + "', '" + sName + "', '" + sAdress + "', "
				+ sTfn + ")";

		Statement stmt = null;
		boolean updateStatus = false;
		try {
			stmt = getConn().createStatement();

			stmt.executeUpdate(addStudentSQL);
			stmt.close();
			getConn().close();
			updateStatus = true;
		} catch (SQLException se) {
			se.printStackTrace();

		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}
		return updateStatus;
	}

	// Adds a Course to the database.
	public boolean addCourse(String cCode, String cDescription, int hp) throws SQLException {
		String addCourseSQL = "INSERT INTO Course " + "values('" + cCode + "', '" + cDescription + "', '" + hp + "')";

		Statement stmt = null;
		boolean updateStatus = false;

		try {

			stmt = getConn().createStatement();

			stmt.executeUpdate(addCourseSQL);
			stmt.close();
			getConn().close();
			updateStatus = true;
		} catch (SQLException se) {
			se.printStackTrace();

		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}
		return updateStatus;
	}

	// Deletes a Student from the database.
	public boolean deleteStudent(String sPnr) throws SQLException {
		String deleteStudentSQL = "DELETE FROM Student WHERE sPnr='" + sPnr + "'";

		Statement stmt = null;
		boolean updateStatus = false;

		try {

			stmt = getConn().createStatement();

			stmt.executeUpdate(deleteStudentSQL);
			stmt.close();
			getConn().close();
			updateStatus = true;
		} catch (SQLException se) {
			se.printStackTrace();

		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}
		return updateStatus;
	}

	// Deletes a Course from the database.
	public boolean deleteCourse(String cCode) throws SQLException {
		String deleteCourseSQL = "DELETE FROM Course WHERE cCode='" + cCode + "'";

		Statement stmt = null;
		boolean updateStatus = false;

		try {

			stmt = getConn().createStatement();

			stmt.executeUpdate(deleteCourseSQL);
			stmt.close();
			getConn().close();

			updateStatus = true;

		} catch (SQLException se) {
			se.printStackTrace();

		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}
		return updateStatus;
	}

	// Adds a Student to studies.
	public boolean addStudentToStudies(String sPnr, String cCode) throws SQLException {
		String addStudentToStudiesSQL = "INSERT INTO Studies " + "values(" + sPnr + ", " + cCode + ")";
		Statement stmt = null;
		boolean updateStatus = false;

		try {

			stmt = getConn().createStatement();

			stmt.executeUpdate(addStudentToStudiesSQL);
			stmt.close();
			getConn().close();

			updateStatus = true;

		} catch (SQLException se) {
			se.printStackTrace();

		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}
		return updateStatus;
	}

	// Adds a Course to Studied.
	public boolean addStudentToStudied(String cCode, String sPnr, String sGrade) throws SQLException {
		String addStudentToStudiedSQL = "INSERT INTO Studied " + "values(" + cCode + ", " + sPnr + ", " + sGrade + ")";

		Statement stmt = null;
		boolean updateStatus = false;
		try {

			stmt = getConn().createStatement();

			stmt.executeUpdate(addStudentToStudiedSQL);
			stmt.close();
			getConn().close();
			updateStatus = true;

		} catch (SQLException se) {
			se.printStackTrace();

		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}
		return updateStatus;
	}

	// Adds a Course
	public boolean deleteStudentFromStudies(String sPnr, String cCode) throws SQLException {
		String deleteStudentFromStudiesSQL = "DELETE Student FROM Studies WHERE sPnr='" + sPnr + "' AND cCode='" + cCode
				+ "';";

		Statement stmt = null;
		boolean updateStatus;

		try {
			stmt = getConn().createStatement();

			stmt.executeUpdate(deleteStudentFromStudiesSQL);
			stmt.close();
			getConn().close();
			updateStatus = true;

		} catch (SQLException se) {
			se.printStackTrace();

			updateStatus = false;

		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}

		return updateStatus;
	}
}
