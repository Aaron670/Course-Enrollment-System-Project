package enrollmentSystem;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;

import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Gui {
	SQLConnector sql = new SQLConnector();
	String[] columnNames = { "ID", "First Name", "Last Name","Contact Number","Date","Course "};
    String[][] result;
    
	
	JFrame frame = new JFrame();
	JPanel leftPanel = new JPanel();
	JLabel sub = new JLabel("Course Enrollment System");
	JButton enrollButton = new JButton("Enrollment");
	JButton viewCoursesButton = new JButton("View Available Courses");
	JButton addCourseButton = new JButton("Add a Course");
	JButton viewStudentsButton = new JButton("View Students Enrolled");
	JPanel rightPanel = new JPanel();
	JPanel enrollmentPanel = new JPanel();
	JLabel enrollTitle = new JLabel("Enrollment Form");
	JLabel fnameLabel = new JLabel("First Name:");
     
    JPanel coursesPanel = new JPanel();
    JPanel addCoursePanel = new JPanel();
    JPanel studentsPanel = new JPanel();
    
    
    
    JTable table = new JTable(2,1);
    //SET NYA UNG result Var
    private void getString() throws SQLException {
    	this.result =this.resultDataToArray();
    }
	private String[][] resultDataToArray() throws SQLException {
		
		
		String run = "SELECT Students.Student_ID, Students.ContactNumber, Students.Fname, Students.Lname, Students.EnrollmentDate, Courses.CourseName FROM Students JOIN Courses ON Students.CourseEnrolled = Courses.Course_ID";
		ResultSet rs= this.sql.queryData(run);
		
		int rowCount=0;
		while (rs.next()) { rowCount++; }
		
		rs= this.sql.queryData(run);
		
		String[][] data = new String[rowCount][100];
		int x=0;
		while(rs.next()) {
			
			data[x][0]=rs.getString("Student_ID");
			data[x][1]=rs.getString("Fname");
			data[x][2]=rs.getString("Lname");
			data[x][3]=rs.getString("ContactNumber");
			data[x][4]=rs.getString("EnrollmentDate");
			data[x][5]=rs.getString("CourseName");
			x++;
		}
		
		return data;
	
	}
	
	//DI NAGANA
	private void updatetable() throws Exception{
		System.out.println();
		studentsPanel.remove(table);
		this.getString();
		this.table= new JTable(this.result,this.columnNames);
		studentsPanel.add(table);
		
		
	}
	
	private void createEnrollmentPanel() {
		
		// Panel ng Enrollment
        
        enrollmentPanel.setBackground(Color.DARK_GRAY);
        enrollmentPanel.setLayout(null);

        
        enrollTitle.setBounds(100, 50, 250, 30);
        enrollTitle.setForeground(Color.WHITE);
        enrollTitle.setFont(new Font("Arial", Font.BOLD, 20));
        enrollmentPanel.add(enrollTitle);
        
        //  SaFirst Name
        fnameLabel.setBounds(50, 80, 100, 30);
        fnameLabel.setForeground(Color.WHITE);
        enrollmentPanel.add(fnameLabel);

        JTextField fnameField = new JTextField();
        fnameField.setBounds(160, 80, 200, 30);
        enrollmentPanel.add(fnameField);

        // Last Name
        JLabel lnameLabel = new JLabel("Last Name:");
        lnameLabel.setBounds(50, 130, 100, 30);
        lnameLabel.setForeground(Color.WHITE);
        enrollmentPanel.add(lnameLabel);

        JTextField lnameField = new JTextField();
        lnameField.setBounds(160, 130, 200, 30);
        enrollmentPanel.add(lnameField);

        // Email
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(50, 180, 100, 30);
        emailLabel.setForeground(Color.WHITE);
        enrollmentPanel.add(emailLabel);

        JTextField emailField = new JTextField();
        emailField.setBounds(160, 180, 200, 30);
        enrollmentPanel.add(emailField);

        // Contact Number
        JLabel contactLabel = new JLabel("Contact Number:");
        contactLabel.setBounds(50, 230, 120, 30);
        contactLabel.setForeground(Color.WHITE);
        enrollmentPanel.add(contactLabel);

        JTextField contactField = new JTextField();
        contactField.setBounds(160, 230, 200, 30);
        enrollmentPanel.add(contactField);

        // Enrollment Date (Set default date)
        JLabel dateLabel = new JLabel("Enrollment Date:");
        dateLabel.setBounds(50, 280, 120, 30);
        dateLabel.setForeground(Color.WHITE);
        enrollmentPanel.add(dateLabel);

        JTextField dateField = new JTextField("2024-12-02");
        dateField.setBounds(160, 280, 200, 30);
        dateField.setEditable(false); // Default date, not editable
        enrollmentPanel.add(dateField);

        // Course Enrolled
        JLabel courseLabel = new JLabel("Course Enrolled:");
        courseLabel.setBounds(50, 330, 120, 30);
        courseLabel.setForeground(Color.WHITE);
        enrollmentPanel.add(courseLabel);

        JTextField courseField = new JTextField();
        courseField.setBounds(160, 330, 200, 30);
        enrollmentPanel.add(courseField);

        // Submit Button
        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(160, 380, 100, 40);
        submitButton.setFocusable(false);
        submitButton.setForeground(Color.WHITE);
        submitButton.setBackground(Color.GRAY);
        enrollmentPanel.add(submitButton);

        // Submit Button Action Listener
        submitButton.addActionListener(e -> {
            String fname = fnameField.getText();
            String lname = lnameField.getText();
            String email = emailField.getText();
            String contact = contactField.getText();
            String enrollmentDate = dateField.getText();
            String course = courseField.getText();

            if (fname.isEmpty() || lname.isEmpty() || email.isEmpty() || contact.isEmpty() || course.isEmpty()) {
                JOptionPane.showMessageDialog(enrollmentPanel, "All fields are required!", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(enrollmentPanel, 
                    "Enrollment Successful!\n" +
                    "Name: " + fname + " " + lname + "\n" +
                    "Email: " + email + "\n" +
                    "Contact: " + contact + "\n" +
                    "Enrollment Date: " + enrollmentDate + "\n" +
                    "Course Enrolled: " + course, 
                    "Success", JOptionPane.INFORMATION_MESSAGE);
                	String f= String.format("INSERT INTO Students(Fname,Lname,Email,ContactNumber,EnrollmentDate,CourseEnrolled) VALUES('%s','%s','%s','%s','%s',%s)",fname,lname,email,contact,enrollmentDate,course);
                	System.out.println(f);
                	this.sql.insertToTable(f);
                
                // Clear the fields after submission
                fnameField.setText("");
                lnameField.setText("");
                emailField.setText("");
                contactField.setText("");
                courseField.setText("");
            }
        });		
	}
	private void createViewCourse() {
		// Panel for Viewing Courses
        
        coursesPanel.setBackground(Color.LIGHT_GRAY);
        coursesPanel.setLayout(null);

        JLabel coursesTitle = new JLabel("Available Courses");
        coursesTitle.setBounds(100, 50, 250, 30);
        coursesTitle.setFont(new Font("Arial", Font.BOLD, 20));
        coursesPanel.add(coursesTitle);
		
	}
	private void addCourse() {
			 // Panel for Adding a Course
		    addCoursePanel.setBackground(Color.DARK_GRAY);
		    addCoursePanel.setLayout(null);
		
		    JLabel addCourseTitle = new JLabel("Add a New Course");
		    addCourseTitle.setBounds(100, 50, 250, 30);
		    addCourseTitle.setForeground(Color.WHITE);
		    addCourseTitle.setFont(new Font("Arial", Font.BOLD, 20));
		    addCoursePanel.add(addCourseTitle);
		    
	}
	private void viewStudent() throws SQLException {
		// Panel for Viewing Students
        studentsPanel.setBackground(Color.GRAY);
        studentsPanel.setLayout(null);

        JLabel studentsTitle = new JLabel("Students Enrolled");
        studentsTitle.setBounds(100, 50, 250, 30);
        studentsTitle.setFont(new Font("Arial", Font.BOLD, 20));
        studentsPanel.add(studentsTitle);
        
        try {
			this.result = this.resultDataToArray();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
        //ung mga data na kinukuha nung table
        this.getString();
        
        table = new JTable(this.result, columnNames);
        DefaultTableCellRenderer center = new DefaultTableCellRenderer();
        center.setHorizontalAlignment(SwingConstants.CENTER);
        
      //  table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.setDefaultEditor(Object.class, null);
        table.setDefaultRenderer(Object.class, center);
        table.getTableHeader().setReorderingAllowed(false);
        
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(150, 150, 700, 300);
 
        studentsPanel.add(scrollPane);
        
	}
	
	private void editButtons() {
		// Add Action Listeners for Buttons
        enrollButton.addActionListener(e -> {
            CardLayout cl = (CardLayout) rightPanel.getLayout();
            cl.show(rightPanel, "Enrollment");
          
				// TODO Auto-generated catch block
			
        });

        viewCoursesButton.addActionListener(e -> {
            CardLayout cl = (CardLayout) rightPanel.getLayout();
            cl.show(rightPanel, "Courses");
        });

        addCourseButton.addActionListener(e -> {
            CardLayout cl = (CardLayout) rightPanel.getLayout();
            cl.show(rightPanel, "AddCourse");
        });

        viewStudentsButton.addActionListener(e -> {
            CardLayout cl = (CardLayout) rightPanel.getLayout();
           
            cl.show(rightPanel, "Students");
           
			try {
				this.updatetable();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				
			
        });

	}
	
	public void CreateGUI()	{
		
        frame.setTitle("Enrollment Management");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1250, 800);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.getContentPane().setBackground(Color.BLACK);

        // Left Panel
        
        leftPanel.setBackground(new Color(50, 50, 50));
        leftPanel.setBounds(0, 0, 250, 800);
        leftPanel.setLayout(null);

       
        sub.setBounds(30, 20, 250, 30);
        sub.setForeground(Color.WHITE);
        sub.setFont(new Font("Arial", Font.BOLD, 15));

       
        enrollButton.setBounds(30, 175, 200, 40);
        enrollButton.setFocusable(false);
        enrollButton.setForeground(Color.WHITE);
        enrollButton.setBackground(Color.GRAY);

       
        viewCoursesButton.setBounds(30, 275, 200, 40);
        viewCoursesButton.setFocusable(false);
        viewCoursesButton.setForeground(Color.WHITE);
        viewCoursesButton.setBackground(Color.GRAY);

        
        addCourseButton.setBounds(30, 375, 200, 40);
        addCourseButton.setFocusable(false);
        addCourseButton.setForeground(Color.WHITE);
        addCourseButton.setBackground(Color.GRAY);

        
        viewStudentsButton.setBounds(30, 475, 200, 40);
        viewStudentsButton.setFocusable(false);
        viewStudentsButton.setForeground(Color.WHITE);
        viewStudentsButton.setBackground(Color.GRAY);

        leftPanel.add(sub);
        leftPanel.add(enrollButton);
        leftPanel.add(viewCoursesButton);
        leftPanel.add(addCourseButton);
        leftPanel.add(viewStudentsButton);

        // Right Panel pre
       
        rightPanel.setBounds(250, 0, 1000, 800);
        rightPanel.setBackground(Color.BLACK);
        rightPanel.setLayout(new CardLayout()); // Set CardLayout for dynamic switching

        // Add all panels to the rightPanel (CardLayout)
        rightPanel.add(enrollmentPanel, "Enrollment");
        rightPanel.add(coursesPanel, "Courses");
        rightPanel.add(addCoursePanel, "AddCourse");
        rightPanel.add(studentsPanel, "Students");
        
        try {
        this.createEnrollmentPanel();
        this.createViewCourse();	
        this.addCourse();
        this.viewStudent();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

       

        this.editButtons();
        // Add panels to the frame
        frame.add(leftPanel);
        frame.add(rightPanel);
        frame.setVisible(true);
	}
    
	
	public static void main(String[] args) {
        
    	SwingUtilities.invokeLater(new Gui()::CreateGUI);
    	
       
    }
}
