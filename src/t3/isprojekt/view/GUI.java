package t3.isprojekt.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

		// STUDENT
		JPanel student = new JPanel();
		tabbedPane.addTab("Student", null, student, null);
		student.setLayout(null);

		JLabel lblsName = new JLabel("Namn: ");
		lblsName.setBounds(56, 31, 61, 16);
		student.add(lblsName);

		JLabel lblsPnr = new JLabel("Pnr:");
		lblsPnr.setBounds(56, 70, 61, 16);
		student.add(lblsPnr);

		JLabel lblsAdress = new JLabel("Adress:");
		lblsAdress.setBounds(56, 106, 61, 16);
		student.add(lblsAdress);

		JLabel lblsTele = new JLabel("Tele:");
		lblsTele.setBounds(56, 146, 61, 16);
		student.add(lblsTele);

		textsName = new JTextField();
		textsName.setBounds(155, 25, 134, 28);
		student.add(textsName);
		textsName.setColumns(10);

		textsPnr = new JTextField();
		textsPnr.setBounds(155, 64, 134, 28);
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
		btnAddCustomer.setBounds(42, 180, 117, 29);
		student.add(btnAddCustomer);

		JButton btnSearch = new JButton("S\u00F6k");
		btnSearch.setBounds(165, 180, 117, 29);
		student.add(btnSearch);

		JButton btnRemoveCustomer = new JButton("Ta bort");
		btnRemoveCustomer.setBounds(294, 180, 117, 29);
		student.add(btnRemoveCustomer);

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

		String[] orderLine = new String[] { "Product name:", "Amount:",
				"Price:" };
		dtmOrderLine = new DefaultTableModel();
		dtmOrderLine.setColumnIdentifiers(orderLine);
		tblOrderLine = new JTable(dtmOrderLine);
		spStudentDetails = new JScrollPane(tblOrderLine);
		spStudentDetails.setBounds(285, 301, 267, 204);
		student.add(spStudentDetails);

		String[] order = new String[] { "Order number:", "Price:" };
		dtmOrder = new DefaultTableModel();
		dtmOrder.setColumnIdentifiers(order);
		tblOrder = new JTable(dtmOrder);
		spStudent = new JScrollPane(tblOrder);
		spStudent.setBounds(42, 301, 227, 204);
		student.add(spStudent);

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
		btnShowDetails.setBounds(56, 517, 117, 29);
		student.add(btnShowDetails);

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
		btnAddCourse.setBounds(43, 172, 117, 29);
		course.add(btnAddCourse);

		JButton btnRemoveCourse = new JButton("Ta bort");
		btnRemoveCourse.setBounds(192, 172, 117, 29);
		course.add(btnRemoveCourse);

		JButton btnSearchCourse = new JButton("S\u00F6k");
		btnSearchCourse.setBounds(341, 172, 117, 29);
		course.add(btnSearchCourse);
	}
}
