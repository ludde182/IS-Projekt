package t3.isprojekt.controller;

import java.sql.SQLException;
import java.util.ArrayList;

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

	public void addStudent(String pnr, String name, String adress, String tel) throws SQLException {
		dataAccessLayer.addStudent(pnr, name, adress, tel);

	}

	public void addCourse(String cCode, String cDescription, int hp) throws SQLException {
		dataAccessLayer.addCourse(cCode, cDescription, hp);
	}

	public Student findStudent(String pnr) throws SQLException {
		student = dataAccessLayer.findStudent(pnr);
		return student;
	}

	public Course findCourse(String cCode) throws SQLException {
		course = dataAccessLayer.findCourse(cCode);
		return course;
	}

	public void removeCourse(String cCode) throws SQLException {
		dataAccessLayer.deleteCourse(cCode);
	}

	public void removeStudent(String pnr) throws SQLException {
		dataAccessLayer.deleteStudent(pnr);
	}

	public void addStudentToStudied(String cCode, String sPnr, String sGrade) throws SQLException {
		dataAccessLayer.addStudentToStudied(cCode, sPnr, sGrade);
	}

	public void addCourseToStudies(String sPnr, String cCode) throws SQLException {
		dataAccessLayer.addStudentToStudies(sPnr, cCode);
	}

	public void removeStudentFromStudies(String sPnr, String cCode) throws SQLException {
		dataAccessLayer.deleteStudentFromStudies(sPnr, cCode);
	}

	public ArrayList<Student> findResultOnCourse(String cCode) throws SQLException {
		studentList = dataAccessLayer.findResultOnCourse(cCode);
		return studentList;
	}

	public ArrayList<Studied> findStudentResult(String pnr, String cCode) throws SQLException {
		studiedList = dataAccessLayer.findStudentResult(cCode, pnr);
		return studiedList;
	}

	public String findPrecentageGrade(String cCode, String sGrade) throws SQLException {
		String percent = dataAccessLayer.findPercentageGradeA(cCode, sGrade);
		return percent;
	}

	public String[] findAllCourses() throws SQLException {
		return dataAccessLayer.findAllCourses();
	}
}
