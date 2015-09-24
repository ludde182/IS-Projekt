package t3.isprojekt.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import t3.isprojekt.controller.Controller;
import t3.isprojekt.model.Course;
import t3.isprojekt.model.Student;

public class GUI {

	private JFrame frame;
	private JTextField textsName;
	private JTextField textsPnr;
	private JTextField textsAdress;
	private JTextField textsTele;
	private JComboBox comboBox;

	private JScrollPane spStudentDetails;
	private JScrollPane spStudent;
	private JTable tblOrder;
	private DefaultTableModel dtmOrder;
	private JTable tblOrderLine;
	private DefaultTableModel dtmOrderLine;
	private JTextField textcCode;
	private JTextField textcDescription;
	private JTextField textHP;
	private JTextField textCourseRegister;
	private JTextField textPnrRegister;
	private Controller controller;
	private Course course;
	private JTextField textsPnr_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
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
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws SQLException
	 */
	private void initialize() throws SQLException {
		frame = new JFrame();
		frame.setBounds(100, 100, 700, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		// TABBS
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(18, 17, 664, 639);
		frame.getContentPane().add(tabbedPane);

		// STUDENT
		JPanel student = new JPanel();
		tabbedPane.addTab("Student", null, student, null);
		student.setLayout(null);

		JLabel lblsName = new JLabel("Namn: ");
		lblsName.setBounds(56, 70, 61, 16);
		student.add(lblsName);

		JLabel lblsAdress = new JLabel("Adress:");
		lblsAdress.setBounds(56, 106, 61, 16);
		student.add(lblsAdress);

		JLabel lblsTele = new JLabel("Tele:");
		lblsTele.setBounds(56, 146, 61, 16);
		student.add(lblsTele);

		textsName = new JTextField();
		textsName.setBounds(155, 64, 134, 28);
		student.add(textsName);
		textsName.setColumns(10);

		textsPnr = new JTextField();
		textsPnr.setBounds(155, 25, 134, 28);
		student.add(textsPnr);
		textsPnr.setColumns(10);

		textsAdress = new JTextField();
		textsAdress.setBounds(155, 100, 134, 28);
		student.add(textsAdress);
		textsAdress.setColumns(10);

		textsTele = new JTextField();
		textsTele.setBounds(155, 140, 134, 28);
		student.add(textsTele);
		textsTele.setColumns(10);

		JButton btnAddCustomer = new JButton("L\u00E4gg till");
		btnAddCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textsName.getText();
				String pnr = textsPnr.getText();
				String adress = textsAdress.getText();
				String tele = textsTele.getText();
				try {
					controller.addStudent(pnr, name, adress, tele);
					textsPnr.setText("StudentAdded");
					textsName.setText("");
					textsAdress.setText("");
					textsTele.setText("");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					textsPnr.setText("StudentNotAdded");
					textsName.setText("");
					textsAdress.setText("");
					textsTele.setText("");
				}
			}
		});
		btnAddCustomer.setBounds(42, 180, 117, 29);
		student.add(btnAddCustomer);

		JButton btnSearch = new JButton("S\u00F6k");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pnr = textsPnr.getText();
				Student student;
				try { // WHAT
					student = controller.findStudent(pnr);
					textsName.setText(student.getsName());
					textsAdress.setText(student.getsAdress());
					textsTele.setText(student.getsTfn());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					textsPnr.setText("NoStudentFound");
					textsName.setText("");
					textsAdress.setText("");
					textsTele.setText("");
				}

			}
		});
		btnSearch.setBounds(165, 180, 117, 29);
		student.add(btnSearch);

		JButton btnRemoveCustomer = new JButton("Ta bort");
		btnRemoveCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					controller.removeStudent(textsPnr.getText());
					textsPnr.setText("StudentRemoved");
					textsName.setText("");
					textsAdress.setText("");
					textsTele.setText("");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					textsPnr.setText("NoStudentFound");
					textsName.setText("");
					textsAdress.setText("");
					textsTele.setText("");
				}
			}
		});
		btnRemoveCustomer.setBounds(294, 180, 117, 29);
		student.add(btnRemoveCustomer);

		JLabel lblCourseStudent = new JLabel("Kurs:");
		lblCourseStudent.setBounds(56, 354, 61, 16);
		student.add(lblCourseStudent);

		JButton btnRegistrera = new JButton("Registrera");
		btnRegistrera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pnr = textsPnr_1.getText();
				String cCode = comboBox.getSelectedItem().toString();
				try {
					controller.addCourseToStudies(pnr, cCode);
					textsPnr_1.setText("CourseReg");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					textsPnr_1.setText("NoCourseReg");
				}
			}
		});
		btnRegistrera.setBounds(42, 382, 117, 29);
		student.add(btnRegistrera);

		JButton btnAvregistrera = new JButton("Avregistrera");
		btnAvregistrera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					controller.removeStudentFromStudies(textsPnr.getText(),
							comboBox.getSelectedItem().toString());
					textsPnr.setText("Removed");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					textsPnr.setText("NotRemoved");
				}

			}
		});
		btnAvregistrera.setBounds(172, 382, 117, 29);
		student.add(btnAvregistrera);

		JLabel lblsPnr_1 = new JLabel("Pnr:");
		lblsPnr_1.setBounds(56, 316, 61, 16);
		student.add(lblsPnr_1);

		textsPnr_1 = new JTextField();
		textsPnr_1.setBounds(155, 310, 134, 28);
		student.add(textsPnr_1);
		textsPnr_1.setColumns(10);

		JLabel lblRegistreraPKurs = new JLabel("Registrera p\u00E5 kurs");
		lblRegistreraPKurs.setBounds(56, 283, 141, 16);
		student.add(lblRegistreraPKurs);

		comboBox = new JComboBox(controller.findAllCourses());
		comboBox.setBounds(155, 350, 134, 27);
		student.add(comboBox);

		JLabel lblBetyg = new JLabel("Betyg:");
		lblBetyg.setBounds(315, 316, 61, 16);
		student.add(lblBetyg);

		String[] aList;
		aList = new String[6];
		aList[0] = "U";
		aList[1] = "E";
		aList[2] = "D";
		aList[3] = "C";
		aList[4] = "B";
		aList[5] = "A";
		final JComboBox comboBox_1 = new JComboBox(aList);
		comboBox_1.setBounds(369, 312, 134, 27);
		student.add(comboBox_1);

		JButton btnAvsluta = new JButton("Avsluta");
		btnAvsluta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String grade = comboBox_1.getSelectedItem().toString();
				String pnr = textsPnr_1.getText();
				String cCode = comboBox.getSelectedItem().toString();
				try {
					controller.removeStudentFromStudies(pnr, cCode);
					controller.addCourseToStudied(cCode, pnr, grade);
					textsPnr_1.setText("CourseReg");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					textsPnr_1.setText("NoCourseReg");
				}

			}
		});
		btnAvsluta.setBounds(294, 382, 117, 29);
		student.add(btnAvsluta);

		JLabel lblendastVidAvsluta = new JLabel("(endast vid avsluta kurs)");
		lblendastVidAvsluta.setBounds(325, 344, 161, 16);
		student.add(lblendastVidAvsluta);

		JLabel lblsPnr = new JLabel("Pnr:*");
		lblsPnr.setBounds(56, 31, 61, 16);
		student.add(lblsPnr);

		// KURS
		JPanel course = new JPanel();
		tabbedPane.addTab("Kurs", null, course, null);
		course.setLayout(null);

		JLabel lblcCode = new JLabel("Kurskod:");
		lblcCode.setBounds(43, 47, 61, 16);
		course.add(lblcCode);

		JLabel lblcDescription = new JLabel("Beskrivning:");
		lblcDescription.setBounds(43, 85, 94, 16);
		course.add(lblcDescription);

		JLabel lblHgskolepong = new JLabel("H\u00F6gskolepo\u00E4ng:");
		lblHgskolepong.setBounds(43, 125, 132, 16);
		course.add(lblHgskolepong);

		textcCode = new JTextField();
		textcCode.setBounds(192, 41, 134, 28);
		course.add(textcCode);
		textcCode.setColumns(10);

		textcDescription = new JTextField();
		textcDescription.setBounds(192, 79, 134, 28);
		course.add(textcDescription);
		textcDescription.setColumns(10);

		textHP = new JTextField();
		textHP.setBounds(192, 119, 134, 28);
		course.add(textHP);
		textHP.setColumns(10);

		JButton btnAddCourse = new JButton("L\u00E4gg till");
		btnAddCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cCode = textcCode.getText();
				String cDescription = textcDescription.getText();
				int hp = Integer.parseInt(textHP.getText());
				try {
					controller.addCourse(cCode, cDescription, hp);
					textcCode.setText("CourseAdded");
					textcDescription.setText("");
					textHP.setText("");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					textcCode.setText("CourseNotAdded");
					textcDescription.setText("");
					textHP.setText("");
				}
			}
		});
		btnAddCourse.setBounds(43, 172, 117, 29);
		course.add(btnAddCourse);

		JButton btnRemoveCourse = new JButton("Ta bort");
		btnRemoveCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cCode = textcCode.getText();
				try {
					controller.removeCourse(cCode);
					textcCode.setText("CourseRemoved");
					textcDescription.setText("");
					textHP.setText("");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					textcCode.setText("NoCourseRemoved");
					textcDescription.setText("");
					textHP.setText("");
				}

			}
		});
		btnRemoveCourse.setBounds(192, 172, 117, 29);
		course.add(btnRemoveCourse);

		JButton btnSearchCourse = new JButton("S\u00F6k");
		btnSearchCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cCode = textcCode.getText();
				try {
					Course course = controller.findCourse(cCode);
					textcDescription.setText(course.getcDescription());
					int hp = course.getHp();
					String shp = Integer.toString(hp);
					textHP.setText(shp);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					textcCode.setText("NoCourseFound");
					textcDescription.setText("");
					textHP.setText("");
				}
			}
		});
		btnSearchCourse.setBounds(341, 172, 117, 29);
		course.add(btnSearchCourse);

		// REGISTER
		JPanel register = new JPanel();
		tabbedPane.addTab("Register", null, register, null);
		register.setLayout(null);

		String[] orderLine = new String[] { "Product name:", "Amount:",
				"Price:" };
		dtmOrderLine = new DefaultTableModel();
		dtmOrderLine.setColumnIdentifiers(orderLine);
		tblOrderLine = new JTable(dtmOrderLine);
		spStudentDetails = new JScrollPane(tblOrderLine);
		spStudentDetails.setBounds(277, 167, 267, 258);
		register.add(spStudentDetails);

		String[] order = new String[] { "Order number:", "Price:" };
		dtmOrder = new DefaultTableModel();
		dtmOrder.setColumnIdentifiers(order);
		tblOrder = new JTable(dtmOrder);
		spStudent = new JScrollPane(tblOrder);
		spStudent.setBounds(38, 167, 227, 258);
		register.add(spStudent);

		JButton btnShowDetails = new JButton("Show Details");
		btnShowDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dtmOrderLine.setRowCount(0);
				int i = tblOrder.getSelectedRow();
				// String oNbr = dtmOrder.getValueAt(i, 0).toString();
				// String cNbr = textCNumber.getText();
				// Customer c = controller.searchCustomer(cNbr);
				// Order o = controller.findOrder(c, oNbr);
				// for (OrderLine ol : o.getOrderLineList()) {
				// Object[] oa = new Object[] { ol.getProduct().getName(),
				// ol.getAmount(),
				// ol.getAmount() * ol.getProduct().getPrice() };
				// dtmOrderLine.addRow(oa);
				// }
			}
		});
		btnShowDetails.setBounds(38, 437, 117, 29);
		register.add(btnShowDetails);

		JLabel lblKursnr = new JLabel("Kursnr:");
		lblKursnr.setBounds(38, 39, 61, 16);
		register.add(lblKursnr);

		textCourseRegister = new JTextField();
		textCourseRegister.setBounds(111, 33, 134, 28);
		register.add(textCourseRegister);
		textCourseRegister.setColumns(10);

		JLabel lblPnr = new JLabel("Pnr:");
		lblPnr.setBounds(38, 75, 61, 16);
		register.add(lblPnr);

		textPnrRegister = new JTextField();
		textPnrRegister.setBounds(111, 69, 134, 28);
		register.add(textPnrRegister);
		textPnrRegister.setColumns(10);

		JButton btnSearchRegister = new JButton("S\u00F6k");
		btnSearchRegister.setBounds(38, 116, 117, 29);
		register.add(btnSearchRegister);

		JLabel lblGradeRegister = new JLabel("Betyg:");
		lblGradeRegister.setBounds(277, 75, 61, 16);
		register.add(lblGradeRegister);

		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(356, 71, 117, 27);
		register.add(comboBox_2);

		JRadioButton rdbtnLst = new JRadioButton("L\u00E4st");
		rdbtnLst.setBounds(307, 35, 141, 23);
		register.add(rdbtnLst);

		JRadioButton rdbtnLser = new JRadioButton("L\u00E4ser");
		rdbtnLser.setBounds(403, 35, 141, 23);
		register.add(rdbtnLser);

	}
}
