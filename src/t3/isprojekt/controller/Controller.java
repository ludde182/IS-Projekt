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


	public void addStudent(String pnr, String name, String adress, String tel) {
		// dataAccessLayer.addStudent(pnr, name);
	}
	public void addCourse()

	public Student findStudent(String pnr) throws SQLException {
		student = dataAccessLayer.findStudent(pnr);
		return student;
	}

	public Course findCourse(String cCode) throws SQLException {
		course = dataAccessLayer.findCourse(cCode);
		return course;
	}

}
