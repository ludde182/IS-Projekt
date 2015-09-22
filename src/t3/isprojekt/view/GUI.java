package t3.isprojekt.view;

import java.awt.EventQueue;

import javax.swing.JButton;
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
		btnAddCustomer.setBounds(42, 206, 117, 29);
		student.add(btnAddCustomer);

		JButton btnSearch = new JButton("S\u00F6k");
		btnSearch.setBounds(172, 206, 117, 29);
		student.add(btnSearch);

		JButton btnRemoveCustomer = new JButton("Ta bort");
		btnRemoveCustomer.setBounds(301, 206, 117, 29);
		student.add(btnRemoveCustomer);

		JPanel course = new JPanel();
		tabbedPane.addTab("Kurs", null, course, null);
		course.setLayout(null);
	}
}
