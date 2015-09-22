package t3.isprojekt.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class GUI {

	private JFrame frame;
	private JTextField textsName;
	private JTextField textsPnr;
	private JTextField textsAdress;
	private JTextField textsTele;
	private JComboBox comboBox;

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
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 700, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		// TABBS
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(18, 17, 664, 639);
		frame.getContentPane().add(tabbedPane);

		JPanel student = new JPanel();
		tabbedPane.addTab("Student", null, student, null);
		student.setLayout(null);

		JLabel lblsName = new JLabel("Namn: ");
		lblsName.setBounds(56, 64, 61, 16);
		student.add(lblsName);

		JLabel lblsPnr = new JLabel("Pnr:");
		lblsPnr.setBounds(56, 92, 61, 16);
		student.add(lblsPnr);

		JLabel lblsAdress = new JLabel("Adress:");
		lblsAdress.setBounds(56, 118, 61, 16);
		student.add(lblsAdress);

		JLabel lblsTele = new JLabel("Tele:");
		lblsTele.setBounds(56, 146, 61, 16);
		student.add(lblsTele);

		textsName = new JTextField();
		textsName.setBounds(155, 58, 134, 28);
		student.add(textsName);
		textsName.setColumns(10);

		textsPnr = new JTextField();
		textsPnr.setBounds(155, 86, 134, 28);
		student.add(textsPnr);
		textsPnr.setColumns(10);

		textsAdress = new JTextField();
		textsAdress.setBounds(155, 112, 134, 28);
		student.add(textsAdress);
		textsAdress.setColumns(10);

		textsTele = new JTextField();
		textsTele.setBounds(155, 140, 134, 28);
		student.add(textsTele);
		textsTele.setColumns(10);

		JButton btnAddCustomer = new JButton("L\u00E4gg till");
		btnAddCustomer.setBounds(42, 180, 117, 29);
		student.add(btnAddCustomer);

		JButton btnSearch = new JButton("S\u00F6k");
		btnSearch.setBounds(165, 180, 117, 29);
		student.add(btnSearch);

		JButton btnRemoveCustomer = new JButton("Ta bort");
		btnRemoveCustomer.setBounds(294, 180, 117, 29);
		student.add(btnRemoveCustomer);

		JPanel course = new JPanel();
		tabbedPane.addTab("Kurs", null, course, null);
		course.setLayout(null);

		JComboBox comboBoxGrade = new JComboBox();
		comboBoxGrade.setBounds(155, 221, 134, 27);
		student.add(comboBoxGrade);

		JLabel lblCourseStudent = new JLabel("Kurs:");
		lblCourseStudent.setBounds(56, 225, 61, 16);
		student.add(lblCourseStudent);

		JButton btnRegistrera = new JButton("Registrera");
		btnRegistrera.setBounds(42, 260, 117, 29);
		student.add(btnRegistrera);

		JButton btnAvregistrera = new JButton("Avregistrera");
		btnAvregistrera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAvregistrera.setBounds(165, 260, 117, 29);
		student.add(btnAvregistrera);

		JButton btnAvsluta = new JButton("Avsluta");
		btnAvsluta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAvsluta.setBounds(294, 260, 117, 29);
		student.add(btnAvsluta);

	}
}
