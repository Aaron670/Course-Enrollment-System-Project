package enrollmentSystem;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;

import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import enrollmentSystem.getResult;

public class Gui {
	SQLConnector sql = new SQLConnector();
	String[] columnNames = { "ID", "First Name", "Last Name","Contact Number","Date","Course "};
    String[][] enrolledStudent;
    
	
	JFrame frame = new JFrame();
	JPanel leftPanel = new JPanel();
	JLabel sub = new JLabel("Course Enrollment System");
	JButton enrollButton = new JButton("Enrollment");
	JButton viewCoursesButton = new JButton("View Available Courses");
	JButton addCourseButton = new JButton("Add a Course");
	JButton viewStudentsButton = new JButton("View Students Enrolled");
	JPanel rightPanel = new JPanel();
	
	// Panel ng Enrollment
    JPanel enrollmentPanel = new JPanel();
    JLabel enrollTitle = new JLabel("Enrollment Form");
   
    
	JLabel fnameLabel = new JLabel("First Name:");
     
	JPanel studentsPanel = new JPanel();
    JPanel coursesPanel = new JPanel();
    JPanel addCoursePanel = new JPanel();
    JLabel AddCourses = new JLabel("Add Course");
    JPanel AdminLogpanel = new JPanel();
    
    
    

	private void createEnrollmentPanel() throws Exception {
		
		// Panel ng Enrollment
        
		enrollTitle.setBounds(100, 50, 250, 30);
        enrollTitle.setForeground(Color.WHITE);
        enrollTitle.setFont(new Font("Arial", Font.BOLD, 30));
        enrollmentPanel.add(enrollTitle);
        
    //  SaFirst Name
        JLabel fnameLabel = new JLabel("First Name:");
        fnameLabel.setBounds(250, 210, 130, 30);
        fnameLabel.setForeground(Color.WHITE);
        fnameLabel.setFont(new Font("Arial", Font.BOLD, 23));
        enrollmentPanel.add(fnameLabel);

        JTextField fnameField = new JTextField();
        fnameField.setBounds(450, 210, 300, 35);
        enrollmentPanel.add(fnameField);

        // Last Name
        JLabel  lnameLabel = new JLabel("Last Name:");
        lnameLabel.setBounds(250,260, 130, 30);
        
        lnameLabel.setForeground(Color.WHITE);
        lnameLabel.setFont(new Font("Arial", Font.BOLD, 23));
        enrollmentPanel.add(lnameLabel);

        JTextField lnameField = new JTextField();
        lnameField.setBounds(450, 260, 300, 35);
        enrollmentPanel.add(lnameField);

        // Email
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(250,310, 130, 30);
        emailLabel.setFont(new Font("Arial", Font.BOLD, 23));
        emailLabel.setForeground(Color.WHITE);
        enrollmentPanel.add(emailLabel);
        
        

        JTextField emailField = new JTextField();
        emailField.setBounds(450, 310, 300, 35);
        enrollmentPanel.add(emailField);

        // Contact Number
        JLabel contactLabel = new JLabel("Contact Number:");
        contactLabel.setBounds(200, 360, 200, 30);
        contactLabel.setFont(new Font("Arial", Font.BOLD, 23));
        contactLabel.setForeground(Color.WHITE);
        enrollmentPanel.add(contactLabel);

        JTextField contactField = new JTextField();
        contactField.setBounds(450, 360, 300, 35);
        enrollmentPanel.add(contactField);

        // Enrollment Date (Set default date)
        JLabel dateLabel = new JLabel("Enrollment Date:");
        dateLabel.setBounds(200,410,  300, 35);
        dateLabel.setFont(new Font("Arial", Font.BOLD, 23));
        dateLabel.setForeground(Color.WHITE);
        enrollmentPanel.add(dateLabel);

        String[] Month = {"Select Month", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
                
       JComboBox EnrollMonth  = new JComboBox(Month);
        
       EnrollMonth.setBounds(450, 410, 100, 35);
       
       String[] Days = {
    		   "Select Day", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
    		    "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
    		    "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"
    		};
               
      JComboBox EnrollDay  = new JComboBox(Days);
       
      EnrollDay.setBounds(600, 410, 100, 30);
      	enrollmentPanel.add(EnrollDay);
      	
        enrollmentPanel.add(EnrollMonth);
      
        
        JTextField dateField = new JTextField("2024-12-02");
        dateField.setBounds(1000, 280, 200, 30);
        dateField.setEditable(false); // Default date, not editable
        enrollmentPanel.add(dateField);

        // Course Enrolled
        JLabel courseLabel = new JLabel("Course Enrolled:");
        courseLabel.setFont(new Font("Arial", Font.BOLD, 23));
        courseLabel.setBounds(200, 480,  200, 30);
        courseLabel.setForeground(Color.WHITE);
        enrollmentPanel.add(courseLabel);
        
        String[][] courses = getResult.getCourses();
        
        String[] Course = new String[courses.length];
        
        for(int i=0; i<courses.length;i++) {
        	Course[i]=courses[i][1];
        }
        
        JComboBox CourseChoice = new JComboBox(Course);
        
        CourseChoice.setBounds(450, 480,  300, 40);
        
        enrollmentPanel.add(CourseChoice);
      
        
        
        
        JTextField courseField = new JTextField();
        courseField.setBounds(1601, 330, 200, 30);
        enrollmentPanel.add(courseField);

        // Submit Button
        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(350	, 570, 200, 60);
        submitButton.setFont(new Font("Arial", Font.BOLD, 21));
        submitButton.setFocusable(false);
        submitButton.setForeground(Color.WHITE);
        submitButton.setBackground(Color.decode("#d1aa40"));
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
	private void createViewCoursePanel() throws Exception {
		// Panel for Viewing Courses
        
        coursesPanel.setBackground(Color.LIGHT_GRAY);
        
        JLabel coursesTitle = new JLabel("Available Courses");
        coursesTitle.setBorder(new EmptyBorder(50,100,0,750));
        coursesTitle.setFont(new Font("Arial", Font.BOLD, 20));
        coursesPanel.add(coursesTitle);
        
        JPanel courseCanvas = new JPanel(new BorderLayout());
        courseCanvas.setPreferredSize(new Dimension(900,650));
        coursesPanel.add(courseCanvas);
        
        JPanel Courses = new JPanel();
        Courses.setBackground(Color.LIGHT_GRAY);
        Courses.setLayout(new BoxLayout(Courses, BoxLayout.Y_AXIS));
        
        String[][] course = getResult.getCourses();
        
        //DITO UNG MGA COURSES
        
        int x=0;
        while(x!=course.length) {
        	System.out.println(course[0].length);
        	JPanel courseBox = new JPanel( new BorderLayout());
        	courseBox.setPreferredSize(new Dimension(200,100));
            courseBox.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            
            JLabel coursetitle = new JLabel(course[x][1]);
	        coursetitle.setFont(new Font("Arial", Font.BOLD, 20));
	        
	        JLabel coursedesc = new JLabel(course[x][2]);
	        coursedesc.setFont(new Font("Arial", Font.PLAIN, 15));
            
            Courses.add(courseBox);
            Courses.add(Box.createRigidArea(new Dimension(0, 10)));
        
	        
	        
	        courseBox.add(coursetitle,BorderLayout.WEST);
	        courseBox.add(coursedesc,BorderLayout.AFTER_LAST_LINE);
	        Courses.add(courseBox);
	        x++;
        }
        JScrollPane scrollPane = new JScrollPane(Courses);
		
        courseCanvas.add(scrollPane,BorderLayout.CENTER);
        
        
	}
	private void createAddCoursePanel() {
			 // Panel for Adding a Course
		addCoursePanel.setBackground(Color.decode("#013d21"));
        addCoursePanel.setLayout(null);
        
        
        
        
        AddCourses.setBounds(500, 50, 250, 30);
        AddCourses.setForeground(Color.WHITE);
        AddCourses.setFont(new Font("Arial", Font.BOLD, 30));
        addCoursePanel.add(AddCourses);
       
        
        //  Course name
        JLabel CourseName = new JLabel("Course Name: ");
        CourseName.setBounds(250, 210, 200, 30);
        CourseName.setForeground(Color.WHITE);
        CourseName.setFont(new Font("Arial", Font.BOLD, 23));
        addCoursePanel.add(CourseName);

        JTextField CourseField = new JTextField();
        CourseField.setBounds(450, 210, 300, 35);
        addCoursePanel.add( CourseField);

        // password
        JLabel  Description= new JLabel("Description");
        Description.setBounds(250,260, 130, 30);
        
        Description.setForeground(Color.WHITE);
        Description.setFont(new Font("Arial", Font.BOLD, 23));
        addCoursePanel.add(  Description);
        
        JTextField DescripdField = new JTextField();
        DescripdField.setBounds(450,260, 300, 300);
        addCoursePanel.add(DescripdField);
        
        
        //Login button 
        JButton CourseSubmit = new JButton("Login");
        CourseSubmit.setBounds(350	, 570, 200, 60);
        CourseSubmit.setFont(new Font("Arial", Font.BOLD, 21));
        CourseSubmit.setFocusable(false);
        CourseSubmit.setForeground(Color.WHITE);
        CourseSubmit.setBackground(Color.decode("#d1aa40"));
        addCoursePanel.add(CourseSubmit);
		    
	}
	private void createAdminLogPanel() throws SQLException {
		// Panel for Viewing Students
		
        AdminLogpanel.setBackground(Color.decode("#013d21"));
        AdminLogpanel.setLayout(null);
       
        
        JLabel adminTitle = new JLabel("AdminHQ");
        adminTitle.setBounds(500, 50, 250, 30);
        adminTitle.setForeground(Color.WHITE);
        adminTitle.setFont(new Font("Arial", Font.BOLD, 30));
        AdminLogpanel.add(adminTitle);
       
        
        //  username
        JLabel UserName = new JLabel("Username:");
        UserName.setBounds(250, 210, 130, 30);
        UserName.setForeground(Color.WHITE);
        UserName.setFont(new Font("Arial", Font.BOLD, 23));
        AdminLogpanel.add(UserName);

        JTextField UserField = new JTextField();
        UserField.setBounds(450, 210, 300, 35);
        AdminLogpanel.add( UserField);

        // password
        JLabel  Password = new JLabel("Password:");
        Password.setBounds(250,260, 130, 30);
        
        Password.setForeground(Color.WHITE);
        Password.setFont(new Font("Arial", Font.BOLD, 23));
        AdminLogpanel.add(Password);
        
        JTextField PasswordField = new JTextField();
        PasswordField.setBounds(450,260, 300, 35);
        AdminLogpanel.add(PasswordField);
        
        
        //Login button 
        JButton LoginButtons = new JButton("Login");
        LoginButtons.setBounds(350	, 570, 200, 60);
        LoginButtons.setFont(new Font("Arial", Font.BOLD, 21));
        LoginButtons.setFocusable(false);
        LoginButtons.setForeground(Color.WHITE);
        LoginButtons.setBackground(Color.decode("#d1aa40"));
        AdminLogpanel.add(LoginButtons);
        
        LoginButtons.addActionListener(e->{
        	CardLayout cl = (CardLayout) rightPanel.getLayout();
            cl.show(rightPanel, "Students");
        	
        });
        
	}
   private void createViewStudentEnrolledPanel() {
	   
  
        

        //DITO UNG VIEW STUDEnts
	}
	
	private void editButtons() {
		// Add Action Listeners for Buttons
		enrollButton.addActionListener(e -> {
            CardLayout cl = (CardLayout) rightPanel.getLayout();
            cl.show(rightPanel, "Enrollment");
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
            cl.show(rightPanel, "admin");
        });

	}
	
	public void CreateGUI()	{
		
		this.frame.setTitle("Enrollment Management");
        this.frame.setSize(1250, 800);
        this.frame.setLayout(null);
        this.frame.setResizable(false);
        this.frame.getContentPane().setBackground(Color.decode("#225932"));
        
        this.leftPanel.setBackground(Color.decode("#225932"));
        this.leftPanel.setBounds(0, 0, 250, 800);
        this.leftPanel.setLayout(null);

        this.sub.setBounds(30, 20, 250, 30);
        this.sub.setForeground(Color.WHITE);
        this.sub.setFont(new Font("Arial", Font.BOLD, 15));

        this.enrollButton.setBounds(30, 175, 200, 40);
        this.enrollButton.setFocusable(false);
        this.enrollButton.setForeground(Color.WHITE);
        this.enrollButton.setBackground(Color.decode("#63a163"));

        this.viewCoursesButton.setBounds(30, 275, 200, 40);
        this.viewCoursesButton.setFocusable(false);
        this.viewCoursesButton.setForeground(Color.WHITE);
        this.viewCoursesButton.setBackground(Color.decode("#63a163"));

        this.addCourseButton.setBounds(30, 375, 200, 40);
        this.addCourseButton.setFocusable(false);
        this.addCourseButton.setForeground(Color.WHITE);
        this.addCourseButton.setBackground(Color.decode("#63a163"));
        this.viewStudentsButton.setBounds(30, 475, 200, 40);
        this.viewStudentsButton.setFocusable(false);
        this.viewStudentsButton.setForeground(Color.WHITE);
        this.viewStudentsButton.setBackground(Color.decode("#63a163"));
        
        
        this.enrollmentPanel.setBackground(Color.decode("#013d21"));
        this.enrollmentPanel.setLayout(null);
        
        

       
        
        

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
        rightPanel.add(addCoursePanel, "AddCourse"); //eto yung dalwa ahh 1
        rightPanel.add(studentsPanel, "Students"); //2
        rightPanel.add(AdminLogpanel,"admin");
    
        // Add Action Listeners for Buttons
        
        try {
        this.createEnrollmentPanel();
        this.createViewCoursePanel();	
        this.createAddCoursePanel();
        this.createAdminLogPanel();
        this.createViewStudentEnrolledPanel();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
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
