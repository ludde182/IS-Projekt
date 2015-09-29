package t3.isprojekt.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import t3.isprojekt.dal.DAL;
import t3.isprojekt.model.Course;
import t3.isprojekt.model.Student;
import t3.isprojekt.model.Studied;
import t3.isprojekt.model.Studies;

public class Controller {
	private Course course;
	private Student student;
	private Studied studied;
	private Studies studies;
	private DAL dataAccessLayer;
	private ArrayList<Student> studentList = new ArrayList<Student>();
	private ArrayList<Studied> studiedList = new ArrayList<Studied>();
	private ArrayList<Studies> studiesList = new ArrayList<Studies>();

	public Controller() {
		dataAccessLayer = new DAL();
	}

	public boolean addStudent(String pnr, String name, String adress, String tel)
			throws SQLException {
		return dataAccessLayer.addStudent(pnr, name, adress, tel);

	}

	public boolean addCourse(String cCode, String cDescription, int hp)
			throws SQLException {
		return dataAccessLayer.addCourse(cCode, cDescription, hp);
	}

	public Student findStudent(String pnr) throws SQLException {
		student = dataAccessLayer.findStudent(pnr);
		return student;
	}

	public Course findCourse(String cCode) throws SQLException {
		course = dataAccessLayer.findCourse(cCode);
		return course;
	}

	public boolean removeCourse(String cCode) throws SQLException {
		return dataAccessLayer.deleteCourse(cCode);
	}

	public boolean removeStudent(String pnr) throws SQLException {
		return dataAccessLayer.deleteStudent(pnr);
	}

	public boolean addStudentToStudied(String cCode, String sPnr, String sGrade)
			throws SQLException {
		return dataAccessLayer.addStudentToStudied(cCode, sPnr, sGrade);
	}

	public boolean addCourseToStudies(String sPnr, String cCode)
			throws SQLException {
		return dataAccessLayer.addCourseToStudies(sPnr, cCode);
	}

	public boolean removeStudentFromStudies(String sPnr, String cCode)
			throws SQLException {
		return dataAccessLayer.deleteStudentFromStudies(sPnr, cCode);
	}

	public ArrayList<Studied> findResultOnCourse(String cCode)
			throws SQLException {
		studiedList = dataAccessLayer.findResultOnCourse(cCode);
		return studiedList;
	}

	public ArrayList<Studied> findStudentResult(String pnr, String cCode)
			throws SQLException {
		studiedList = dataAccessLayer.findStudentResult(cCode, pnr);
		return studiedList;
	}

	public String findPrecentageGrade(String cCode, String sGrade)
			throws SQLException {
		String percent = dataAccessLayer.findPercentageGradeA(cCode, sGrade);
		return percent;
	}

	public ArrayList<Course> findAllCourses() throws SQLException {
		return dataAccessLayer.findAllCourses();
	}

	public ArrayList<Student> findAllStudies(String cCode) throws SQLException {
		return dataAccessLayer.findAllStudentsReadingCourse(cCode);
	}

	public ArrayList<Studied> findAllStudied(String cCode) throws SQLException {
		return dataAccessLayer.findResultOnCourse(cCode);
	}

	public Vector<Vector<String>> findAllStudentsResultsOnCourseVector(
			String code) throws SQLException {
		return dataAccessLayer.getStudensFromVector(code);
	}
}
