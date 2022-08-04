package managerBoundary;

//Java program to implement
//a Simple Registration Form
//using Java Swing

import javax.swing.*;

import customerControl.CustomerLogic;
import customerEntity.Customer;
import managerControl.ManagerLogic;
import managerEntity.Employee;
import managerEntity.FlightAttendants;

import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class addEmployee extends ManagerRootLayout implements ActionListener {

	// Components of the Form
	private Container c;
	private JLabel title;
	private JLabel lblFirstName;
	private JTextField tfFirstName;
	private JLabel lblPassport;
	private JTextField tfPassport;
	private ButtonGroup gengp;
	private JLabel dob;
	private JComboBox date;
	private JComboBox month;
	private JComboBox year;
	private JCheckBox term;
	private JButton sub;
	private JButton reset;
	private JTextArea tout;
	private JLabel res;
	private JTextArea resadd;

	private String dates[]
		= { "1", "2", "3", "4", "5",
			"6", "7", "8", "9", "10",
			"11", "12", "13", "14", "15",
			"16", "17", "18", "19", "20",
			"21", "22", "23", "24", "25",
			"26", "27", "28", "29", "30",
			"31" };
	private String[] months
		= { "Jan", "feb", "Mar", "Apr",
			"May", "Jun", "July", "Aug",
			"Sup", "Oct", "Nov", "Dec" };
	private String years[]
		= { "1995", "1996", "1997", "1998",
			"1999", "2000", "2001", "2002",
			"2003", "2004", "2005", "2006",
			"2007", "2008", "2009", "2010",
			"2011", "2012", "2013", "2014",
			"2015", "2016", "2017", "2018",
			"2019","2020","2021","2022"};
	private JTextField tfLastName;
	
	//Driver Code
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addEmployee frame = new addEmployee();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// constructor, to initialize the components
	// with default values.
	public addEmployee()
	{
		setTitle("Registration Form");
		setBounds(300, 90, 900, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);

		c = getContentPane();
		c.setLayout(null);

		title = new JLabel("Add Employee");
		title.setFont(new Font("Arial", Font.PLAIN, 30));
		title.setSize(300, 30);
		title.setLocation(300, 30);
		c.add(title);

		lblFirstName = new JLabel("First Name");
		lblFirstName.setFont(new Font("Arial", Font.PLAIN, 20));
		lblFirstName.setSize(100, 20);
		lblFirstName.setLocation(100, 100);
		c.add(lblFirstName);

		tfFirstName = new JTextField();
		tfFirstName.setFont(new Font("Arial", Font.PLAIN, 15));
		tfFirstName.setSize(190, 23);
		tfFirstName.setLocation(200, 100);
		c.add(tfFirstName);

		lblPassport = new JLabel("ID");
		lblPassport.setFont(new Font("Arial", Font.PLAIN, 20));
		lblPassport.setSize(100, 20);
		lblPassport.setLocation(100, 184);
		c.add(lblPassport);

		tfPassport = new JTextField();
		tfPassport.setFont(new Font("Arial", Font.PLAIN, 15));
		tfPassport.setSize(150, 30);
		tfPassport.setLocation(201, 186);
		c.add(tfPassport);

		gengp = new ButtonGroup();

		dob = new JLabel("RecruitmentStartDate");
		dob.setFont(new Font("Arial", Font.PLAIN, 20));
		dob.setSize(200, 20);
		dob.setLocation(90, 248);
		c.add(dob);

		date = new JComboBox(dates);
		date.setFont(new Font("Arial", Font.PLAIN, 15));
		date.setSize(50, 20);
		date.setLocation(200, 277);
		c.add(date);

		month = new JComboBox(months);
		month.setFont(new Font("Arial", Font.PLAIN, 15));
		month.setSize(60, 20);
		month.setLocation(260, 277);
		c.add(month);

		year = new JComboBox(years);
		year.setFont(new Font("Arial", Font.PLAIN, 15));
		year.setSize(70, 20);
		year.setLocation(330, 277);
		c.add(year);

		term = new JCheckBox("Accept Terms And Conditions.");
		term.setFont(new Font("Arial", Font.PLAIN, 15));
		term.setSize(250, 20);
		term.setLocation(150, 319);
		c.add(term);

		sub = new JButton("Submit");
		sub.setFont(new Font("Arial", Font.PLAIN, 15));
		sub.setSize(100, 20);
		sub.setLocation(150, 372);
		sub.addActionListener(this);
		c.add(sub);

		reset = new JButton("Reset");
		reset.setFont(new Font("Arial", Font.PLAIN, 15));
		reset.setSize(100, 20);
		reset.setLocation(280, 372);
		reset.addActionListener(this);
		c.add(reset);

		tout = new JTextArea();
		tout.setFont(new Font("Arial", Font.PLAIN, 15));
		tout.setSize(300, 400);
		tout.setLocation(500, 100);
		tout.setLineWrap(true);
		tout.setEditable(false);
		c.add(tout);

		res = new JLabel("");
		res.setFont(new Font("Arial", Font.PLAIN, 20));
		res.setSize(500, 25);
		res.setLocation(100, 500);
		c.add(res);

		resadd = new JTextArea();
		resadd.setFont(new Font("Arial", Font.PLAIN, 15));
		resadd.setSize(200, 75);
		resadd.setLocation(580, 175);
		resadd.setLineWrap(true);
		c.add(resadd);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Arial", Font.PLAIN, 20));
		lblLastName.setBounds(100, 131, 100, 20);
		getContentPane().add(lblLastName);
		
		tfLastName = new JTextField();
		tfLastName.setFont(new Font("Arial", Font.PLAIN, 15));
		tfLastName.setBounds(200, 134, 190, 30);
		getContentPane().add(tfLastName);

		setVisible(true);
	}

	// method actionPerformed()
	// to get the action performed
	// by the user and act accordingly
	public void actionPerformed(ActionEvent e)
	{
		SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
		if (e.getSource() == sub) {
			if (term.isSelected()) {
				String firstName = tfFirstName.getText();
				String lastName = tfLastName.getText();
				long id =  Long.parseLong(tfPassport.getText());
				List list = (List) (Arrays.asList(months));
				ArrayList<String> arrayList = new ArrayList<>();
				arrayList.addAll(list);
				int index = arrayList.indexOf((String)month.getSelectedItem())+1;
				String indexString;
				if(index < 10) {
					indexString = "0"+index;
				} else {
					indexString = String.valueOf(index);
				}
				String dob = (String)year.getSelectedItem()+"-"+indexString+"-"+
						(String)date.getSelectedItem();
				Date RecruitmentStartDate = null;
				try {
					RecruitmentStartDate = (Date) parser.parse(dob);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				String string = "id: "+id+" firstName: "+firstName+" lastName: "+lastName+
						" RecruitmentStartDate: "+RecruitmentStartDate.toString();
				tout.setText(string);
				tout.setEditable(false);
				ManagerLogic.getInstance().addAttendants(id, firstName,
						lastName, RecruitmentStartDate);
				res.setText("Registration Successfully..");
			}
			else {
				tout.setText("");
				resadd.setText("");
				res.setText("Please accept the"
							+ " terms & conditions..");
			}
		}

		else if (e.getSource() == reset) {
			String def = "";
			tfFirstName.setText(def);
			tfPassport.setText(def);
			res.setText(def);
			tout.setText(def);
			term.setSelected(false);
			date.setSelectedIndex(0);
			month.setSelectedIndex(0);
			year.setSelectedIndex(0);
			resadd.setText(def);
		}
	}
}
