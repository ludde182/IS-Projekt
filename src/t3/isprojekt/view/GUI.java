package t3.isprojekt.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import t3.isprojekt.controller.Controller;
import t3.isprojekt.model.Course;
import t3.isprojekt.model.Student;
import t3.isprojekt.model.Studied;

public class GUI {

	private JFrame frame;
	private JTextField textsPnr;
	private JTextField textsName;
	private JTextField textsAdress;
	private JTextField textsTel;
	private DefaultTableModel dtm;
	private Controller controller;
	private JTable tableStudent;
	private JTable table_1;
	private JTextField textCourseCode;
	private JTextField textcDescription;
	private JTextField textHP;
	private JTextField textrAddPnr;
	private JTextField textrAddName;
	private JTextField textrAdress;
	private JTextField textTelnr;
	private JTextField textrCode;
	private JTextField textrNAme;
	private JTextField textrHP;
	private JTextField textrrPnr;
	private JTextField textrCcode;
	private JTextField textrrrPnr;
	private JTextField textRemovePnr;
	private JTextField textRemoveCode;
	private JComboBox<String> comboBoxGrade;
	private JTextField textStudentOnCourse;
	private JComboBox comboBox = new JComboBox();
	private JPanel register = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 * @throws SQLException
	 */

	public GUI() throws SQLException {
		initialize();
		this.controller = new Controller();
		use();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws SQLException
	 */
	private void initialize() throws SQLException {
		frame = new JFrame();
		frame.setBounds(100, 100, 831, 551);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		// TABBS

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(18, 17, 789, 491);

		frame.getContentPane().add(tabbedPane);

		// STUDENT
		final JPanel student = new JPanel();
		tabbedPane.addTab("Student", null, student, null);
		student.setLayout(null);
		// Labels
		JLabel lblsPnr = new JLabel("Pnr:");
		lblsPnr.setBounds(31, 44, 61, 16);
		student.add(lblsPnr);

		JLabel lblsName = new JLabel("Name:");
		lblsName.setBounds(31, 100, 61, 16);
		student.add(lblsName);

		JLabel lblsAdress = new JLabel("Adress:");
		lblsAdress.setBounds(31, 153, 61, 16);
		student.add(lblsAdress);

		JLabel lblsTel = new JLabel("Tel:");
		lblsTel.setBounds(31, 211, 61, 16);
		student.add(lblsTel);
		// Texts
		textsPnr = new JTextField();
		textsPnr.setBounds(104, 38, 134, 28);
		student.add(textsPnr);
		textsPnr.setColumns(10);

		textsName = new JTextField();
		textsName.setEditable(false);
		textsName.setBounds(104, 94, 134, 28);
		student.add(textsName);
		textsName.setColumns(10);

		textsAdress = new JTextField();
		textsAdress.setEditable(false);
		textsAdress.setBounds(104, 147, 134, 28);
		student.add(textsAdress);
		textsAdress.setColumns(10);

		textsTel = new JTextField();
		textsTel.setEditable(false);
		textsTel.setBounds(104, 205, 134, 28);
		student.add(textsTel);
		textsTel.setColumns(10);

		textStudentOnCourse = new JTextField();
		textStudentOnCourse.setEditable(true);
		textStudentOnCourse.setBounds(104, 255, 134, 28);
		textStudentOnCourse.setColumns(10);

		final JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(121, 295, 117, 29);

		JLabel lblCourse = new JLabel("Course:");
		lblCourse.setBounds(31, 261, 61, 16);

		JButton btnsSearch = new JButton("Search student");
		btnsSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pnr = textsPnr.getText();
				try {
					Student students = controller.findStudent(pnr);
					if (students != null) {
						textsName.setText(students.getsName());
						textsAdress.setText(students.getsAdress());
						textsTel.setText(students.getsTfn());
						textStudentOnCourse.setEditable(true);
						student.add(btnSearch);
						student.add(textStudentOnCourse);
						student.add(lblCourse);
					} else {
						textsPnr.setText("NoStudent");
					}
				} catch (SQLException e1) {
					textsPnr.setText("NoConnection");
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnsSearch.setBounds(485, 256, 117, 29);
		student.add(btnsSearch);

		// Table
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(263, 38, 339, 206);
		student.add(scrollPane);

		tableStudent = new JTable(row, column);
		tableStudent.setBounds(75, 154, 1, 1);
		student.add(tableStudent);

		// COURSE
		JPanel course = new JPanel();
		tabbedPane.addTab("Course", null, course, null);
		course.setLayout(null);

		// Labels
		JLabel lblCoursecode = new JLabel("Coursecode:");
		lblCoursecode.setBounds(34, 37, 98, 16);
		course.add(lblCoursecode);

		JLabel lblcDescription = new JLabel("Description:");
		lblcDescription.setBounds(34, 95, 98, 16);
		course.add(lblcDescription);

		JLabel lblcHp = new JLabel("HP:");
		lblcHp.setBounds(34, 153, 61, 16);
		course.add(lblcHp);

		// Text
		textCourseCode = new JTextField();
		textCourseCode.setBounds(124, 31, 134, 28);
		course.add(textCourseCode);
		textCourseCode.setColumns(10);

		textcDescription = new JTextField();
		textcDescription.setEditable(false);
		textcDescription.setBounds(124, 89, 134, 28);
		course.add(textcDescription);
		textcDescription.setColumns(10);

		textHP = new JTextField();
		textHP.setEditable(false);
		textHP.setBounds(124, 147, 134, 28);
		course.add(textHP);
		textHP.setColumns(10);
		// Table
		JScrollPane scrollPaneC = new JScrollPane();
		scrollPaneC.setBounds(288, 19, 324, 206);
		course.add(scrollPaneC);

		JTable tableC = new JTable();
		scrollPaneC.setViewportView(tableC);

		JTable tableCourse = new JTable();
		tableCourse.setBounds(75, 154, 1, 1);
		course.add(tableCourse);

		JButton btnSearchCourse = new JButton("Search Course");
		btnSearchCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cCode = textCourseCode.getText();
				try {
					Course course = controller.findCourse(cCode);
					if (course != null) {
						textcDescription.setText(course.getcDescription());
						textHP.setText(Integer.toString(course.getHp()));
					} else {
						textCourseCode.setText("NoCourse");
						textcDescription.setText("");
						textHP.setText("");
					}
				} catch (SQLException e1) {
					textCourseCode.setText("NoConnection");
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnSearchCourse.setBounds(280, 237, 117, 29);
		course.add(btnSearchCourse);

		JButton btnStudentsOnCourse = new JButton("Studied");
		btnStudentsOnCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String code = textCourseCode.getText();
				String[] col = new String[3];
				col[0] = "Pnr";
				col[1] = "Grade";
				double sum = 0;
				ArrayList<Studied> studied = new ArrayList<Studied>();
				try {
					studied = controller.findAllStudied(code);
					String[][] rad = new String[2][studied.size()];
					int i = 0;
					for (Studied s : studied) {
						rad[0][i] = s.getsPnr();
						rad[1][i] = s.getsGrade();
						if (s.getsGrade().equals("A")) {
							sum++;
						}
					}
					JLabel labelPercent = new JLabel(+100
							* (sum / studied.size()) + "%");
					labelPercent.setBounds(551, 272, 61, 16);
					course.add(labelPercent);
				} catch (SQLException e2) {
					textCourseCode.setText("NoConnection");
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}

				dtm = new DefaultTableModel();
				tableStudent.removeAll();
				tableStudent.setModel(dtm);

			}
		});
		btnStudentsOnCourse.setBounds(392, 237, 111, 29);
		course.add(btnStudentsOnCourse);

		JButton btnStudied_1 = new JButton("Studing");
		btnStudied_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String code = textCourseCode.getText();
				String[] col = new String[2];
				col[0] = "Pnr";
				col[1] = "Name";

				try {

					String[][] rad = new String[2][controller.findAllStudies(
							code).size()];
					for (int i = 0; i < controller.findAllStudies(code).size(); i++) {
						rad[0][i] = controller.findAllStudies(code).get(i)
								.getsPnr();
						rad[1][i] = controller.findAllStudies(code).get(i)
								.getsName();
					}
				} catch (SQLException e2) {
					textCourseCode.setText("NoConnection");
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}

				dtm = new DefaultTableModel();
				tableStudent.setModel(dtm);
			}
		});
		btnStudied_1.setBounds(497, 237, 117, 29);
		course.add(btnStudied_1);

		// REGISTER
		tabbedPane.addTab("Register", null, register, null);
		register.setLayout(null);

		JLabel lblAddStudent = new JLabel("Add student");
		lblAddStudent.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblAddStudent.setBounds(27, 38, 102, 16);
		register.add(lblAddStudent);

		textrAddPnr = new JTextField();
		textrAddPnr.setBounds(89, 66, 134, 28);
		register.add(textrAddPnr);
		textrAddPnr.setColumns(10);

		textrAddName = new JTextField();
		textrAddName.setBounds(89, 107, 134, 28);
		register.add(textrAddName);
		textrAddName.setColumns(10);

		JLabel lblrPnr = new JLabel("Pnr:");
		lblrPnr.setBounds(16, 72, 61, 16);
		register.add(lblrPnr);

		JLabel lblrName = new JLabel("Name:");
		lblrName.setBounds(16, 113, 61, 16);
		register.add(lblrName);

		JLabel lblrAdress = new JLabel("Adress:");
		lblrAdress.setBounds(16, 155, 61, 16);
		register.add(lblrAdress);

		textrAdress = new JTextField();
		textrAdress.setBounds(89, 147, 134, 28);
		register.add(textrAdress);
		textrAdress.setColumns(10);

		JLabel lblrTelnr = new JLabel("Telnr:");
		lblrTelnr.setBounds(16, 195, 61, 16);
		register.add(lblrTelnr);

		textTelnr = new JTextField();
		textTelnr.setBounds(89, 189, 134, 28);
		register.add(textTelnr);
		textTelnr.setColumns(10);
		comboBox = new JComboBox();
		comboBox.setBounds(553, 109, 134, 27);
		register.add(comboBox);

		JLabel lblAddCourse = new JLabel("Add course");
		lblAddCourse.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblAddCourse.setBounds(286, 38, 102, 16);
		register.add(lblAddCourse);

		JLabel lblrCode = new JLabel("Code:");
		lblrCode.setBounds(265, 72, 61, 16);
		register.add(lblrCode);

		JLabel lblrcName = new JLabel("Name:");
		lblrcName.setBounds(265, 113, 61, 16);
		register.add(lblrcName);

		JLabel lblrHp = new JLabel("HP:");
		lblrHp.setBounds(265, 155, 61, 16);
		register.add(lblrHp);

		textrCode = new JTextField();
		textrCode.setBounds(317, 66, 134, 28);
		register.add(textrCode);
		textrCode.setColumns(10);

		textrNAme = new JTextField();
		textrNAme.setBounds(317, 107, 134, 28);
		register.add(textrNAme);
		textrNAme.setColumns(10);

		textrHP = new JTextField();
		textrHP.setBounds(317, 149, 134, 28);
		register.add(textrHP);
		textrHP.setColumns(10);

		JLabel lblRegisterOnCourse = new JLabel("Finish course");
		lblRegisterOnCourse
				.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblRegisterOnCourse.setBounds(501, 260, 134, 16);
		register.add(lblRegisterOnCourse);

		JLabel lblrrPnr = new JLabel("Pnr:");
		lblrrPnr.setBounds(486, 288, 61, 16);
		register.add(lblrrPnr);

		textrrPnr = new JTextField();
		textrrPnr.setBounds(553, 282, 134, 28);
		register.add(textrrPnr);
		textrrPnr.setColumns(10);

		JLabel lblCode = new JLabel("Code:");
		lblCode.setBounds(486, 327, 61, 16);
		register.add(lblCode);

		textrCcode = new JTextField();
		textrCcode.setBounds(553, 321, 134, 28);
		register.add(textrCcode);
		textrCcode.setColumns(10);

		JLabel lblcrGrade = new JLabel("Grade:");
		lblcrGrade.setBounds(486, 369, 61, 16);
		register.add(lblcrGrade);

		String[] gradeList = new String[6];
		gradeList[0] = "A";
		gradeList[1] = "B";
		gradeList[2] = "C";
		gradeList[3] = "D";
		gradeList[4] = "E";
		gradeList[5] = "U";
		comboBoxGrade = new JComboBox<String>(gradeList);
		comboBoxGrade.setBounds(553, 365, 134, 27);
		register.add(comboBoxGrade);

		JButton btnAddStudent = new JButton("Add");
		btnAddStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pnr = textrAddPnr.getText();
				String name = textrAddName.getText();
				String adress = textrAdress.getText();
				String tel = textTelnr.getText();
				try {
					boolean b = controller.addStudent(pnr, name, adress, tel);
					if (b == true) {
						textrAddPnr.setText("Added");
						textrAddName.setText("");
						textrAdress.setText("");
						textTelnr.setText("");
					} else {
						textrAddPnr.setText("NotAdded");
						textrAddName.setText("");
						textrAdress.setText("");
						textTelnr.setText("");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					textrAddPnr.setText("NoConnection");
					textrAddName.setText("");
					textrAdress.setText("");
					textTelnr.setText("");
					e1.printStackTrace();
				}

			}
		});
		btnAddStudent.setBounds(106, 221, 117, 29);
		register.add(btnAddStudent);

		JButton btnAddCourse = new JButton("Add");
		btnAddCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String code = textrCode.getText();
				String name = textrNAme.getText();
				int HP = Integer.parseInt(textrHP.getText());
				try {
					boolean b = controller.addCourse(code, name, HP);
					if (b == true) {
						textrCode.setText("Added");
						textrNAme.setText("");
						textrHP.setText("");
						comboBox.addItem(code);
					} else {
						textrCode.setText("NotAdded");
						textrNAme.setText("");
						textrHP.setText("");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					textrCode.setText("NoConnection");
					textrNAme.setText("");
					textrHP.setText("");
					e1.printStackTrace();
				}

			}
		});
		btnAddCourse.setBounds(334, 182, 117, 29);
		register.add(btnAddCourse);

		JButton btnFinish = new JButton("Finish");
		btnFinish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pnr = textrrPnr.getText();
				String code = textrCcode.getText();
				String grade = comboBoxGrade.getSelectedItem().toString();
				try {
					boolean b1 = controller.addStudentToStudied(code, pnr,
							grade);
					boolean b2 = controller.removeStudentFromStudies(pnr, code);
					if (b1 == true && b2 == true) {
						textrrPnr.setText("Finished");
						textrCcode.setText("");
					} else {
						textrrPnr.setText("FailedToDelete");
						textrCcode.setText("");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					textrrrPnr.setText("NoConnection");
					textrCcode.setText("");
				}
			}
		});
		btnFinish.setBounds(570, 404, 117, 29);
		register.add(btnFinish);

		JLabel lblAddStudentTo = new JLabel("Add student to course");
		lblAddStudentTo.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblAddStudentTo.setBounds(501, 38, 165, 16);
		register.add(lblAddStudentTo);

		JLabel lblPnr = new JLabel("Pnr:");
		lblPnr.setBounds(486, 72, 61, 16);
		register.add(lblPnr);

		textrrrPnr = new JTextField();
		textrrrPnr.setBounds(553, 66, 134, 28);
		register.add(textrrrPnr);
		textrrrPnr.setColumns(10);

		JLabel lblKurs = new JLabel("Kurs:");
		lblKurs.setBounds(486, 113, 61, 16);
		register.add(lblKurs);

		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pnr = textrrrPnr.getText();

				String course = comboBox.getSelectedItem().toString();
				try {
					boolean b = controller.addCourseToStudies(pnr, course);
					if (b == true) {
						textrrrPnr.setText("Added");

					} else {
						textrrrPnr.setText("FailedToAdd");
					}
				} catch (SQLException e1) { // TODO Auto-generated catch block
					e1.printStackTrace();
					textrrrPnr.setText("NoConnection");
				}
			}
		});
		btnAdd.setBounds(570, 150, 117, 29);
		register.add(btnAdd);

		JLabel lblRemoveStudent = new JLabel("Remove student");
		lblRemoveStudent.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblRemoveStudent.setBounds(27, 260, 117, 16);
		register.add(lblRemoveStudent);

		JLabel lblPnr_1 = new JLabel("Pnr:");
		lblPnr_1.setBounds(16, 288, 61, 16);
		register.add(lblPnr_1);

		textRemovePnr = new JTextField();
		textRemovePnr.setBounds(89, 282, 134, 28);
		register.add(textRemovePnr);
		textRemovePnr.setColumns(10);

		JButton btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pnr = textRemovePnr.getText();
				try {
					boolean b = controller.removeStudent(pnr);
					if (b == true) {
						textRemovePnr.setText("Removed");
					} else {
						textRemovePnr.setText("FailedToRemove");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					textRemovePnr.setText("NoConnection");
				}
			}
		});
		btnRemove.setBounds(106, 322, 117, 29);
		register.add(btnRemove);

		JLabel lblRemoveCourse = new JLabel("Remove course");
		lblRemoveCourse.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblRemoveCourse.setBounds(286, 260, 165, 16);
		register.add(lblRemoveCourse);

		JLabel lblCode_1 = new JLabel("Code:");
		lblCode_1.setBounds(265, 288, 61, 16);
		register.add(lblCode_1);

		textRemoveCode = new JTextField();
		textRemoveCode.setBounds(317, 282, 134, 28);
		register.add(textRemoveCode);
		textRemoveCode.setColumns(10);

		JButton btnRemove_1 = new JButton("Remove");
		btnRemove_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String code = textRemoveCode.getText();
				try {
					boolean b = controller.removeCourse(code);
					if (b == true) {
						textRemoveCode.setText("Removed");
					} else {
						textRemoveCode.setText("FailedToRemove");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					textRemoveCode.setText("NoConnection");
					e1.printStackTrace();
				}
			}
		});
		btnRemove_1.setBounds(334, 322, 117, 29);
		register.add(btnRemove_1);

	}

	public void use() {
		// int i = 0;
		// String[] cList;
		try {
			String[] array = new String[controller.findAllCourses().size()];
			System.out.println(controller.findAllCourses().size());
			for (int i = 0; i < array.length; i++) {
				String s = controller.findAllCourses().get(i).getcCode();
				comboBox.addItem(s);
			}
			// cList = new String[controller.findAllCourses().size()];

			// for (Course c : controller.findAllCourses()) {
			// cList[i] = c.getcCode();
			// i++;
			// }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}