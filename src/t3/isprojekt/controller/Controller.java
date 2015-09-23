package t3.isprojekt.controller;

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

}
