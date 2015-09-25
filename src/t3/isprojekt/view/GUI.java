package t3.isprojekt.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import t3.isprojekt.controller.Controller;
import t3.isprojekt.model.Student;

public class GUI {

	private JFrame frame;
	private JTextField textsPnr;
	private JTextField textsName;
	private JTextField textsAdress;
	private JTextField textsTel;
	private DefaultTableModel tableModelStudents;
	private Controller controller;
	private JTable table;
	private JTable table_1;

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
	 */

	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 831, 462);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		// TABBS
		JTabbedPane tabbedPane = new JTabbedPane(SwingConstants.TOP);
		tabbedPane.setBounds(18, 17, 789, 406);
		frame.getContentPane().add(tabbedPane);

		// STUDENT
		JPanel student = new JPanel();
		tabbedPane.addTab("Student", null, student, null);
		student.setLayout(null);
		// Labels
		JLabel lblsPnr = new JLabel("Pnr:");
		lblsPnr.setBounds(31, 44, 61, 16);
		student.add(lblsPnr);

		JLabel lblsName = new JLabel("Name:");
		lblsName.setBounds(31, 94, 61, 16);
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
		textsName.setBounds(104, 88, 134, 28);
		student.add(textsName);
		textsName.setColumns(10);

		textsAdress = new JTextField();
		textsAdress.setBounds(104, 147, 134, 28);
		student.add(textsAdress);
		textsAdress.setColumns(10);

		textsTel = new JTextField();
		textsTel.setBounds(104, 205, 134, 28);
		student.add(textsTel);
		textsTel.setColumns(10);

		JButton btnsSearch = new JButton("Search");
		btnsSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String pnr = textsPnr.getText();
				try {
					Student student = controller.findStudent(pnr);
					if (student != null) {
						textsName.setText(student.getsName());
						textsAdress.setText(student.getsAdress());
						textsTel.setText(student.getsTfn());
					} else {
						textsPnr.setText("NoStudent");
					}
				} catch (SQLException e1) {
					textsPnr.setText("NO CONNECTION");
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnsSearch.setBounds(285, 275, 117, 29);
		student.add(btnsSearch);
		// Table
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(355, 44, 339, 206);
		student.add(scrollPane);

		table_1 = new JTable();
		scrollPane.setViewportView(table_1);

		table = new JTable();
		table.setBounds(75, 154, 1, 1);
		student.add(table);

		// Course
		JPanel course = new JPanel();
		tabbedPane.addTab("Course", null, course, null);
		course.setLayout(null);

		// Register
		JPanel register = new JPanel();
		tabbedPane.addTab("Register", null, register, null);
		register.setLayout(null);

	}
}
