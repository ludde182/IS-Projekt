package t3.isprojekt.controller;

import java.sql.SQLException;

import t3.isprojekt.dal.DAL;
import t3.isprojekt.model.Course;
import t3.isprojekt.model.Student;
import t3.isprojekt.model.Studied;

public class Controller {
	private Course course;
	private Student student;
	private Studied studied;
	private DAL dataAccessLayer;

	public Controller() {
		dataAccessLayer = new DAL();
	}

	public void addStudent(String pnr, String name, String adress, String tel)
			throws SQLException {
		dataAccessLayer.addStudent(pnr, name, adress, tel);

	}

	public void addCourse(String cCode, String cDescription, int hp)
			throws SQLException {
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

	public void addCourseToStudied(String cCode, String sPnr, String sGrade)
			throws SQLException {
		dataAccessLayer.addCourseToStudied(cCode, sPnr, sGrade);
	}

	public void addCourseToStudies(String sPnr, String cCode)
			throws SQLException {
		dataAccessLayer.addStudentToStudies(sPnr, cCode);
	}
}
