package enrollmentSystem;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NestedScrollPaneExample {

    public static void main(String[] args) {
        // Main Frame
        JFrame frame = new JFrame();
        frame.setTitle("Enrollment Management");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1250, 800);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.getContentPane().setBackground(Color.decode("#225932"));

        // Left Panel
        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(Color.decode("#225932"));
        leftPanel.setBounds(0, 0, 250, 800);
        leftPanel.setLayout(null);

        JLabel sub = new JLabel("Course Enrollment System");
        sub.setBounds(30, 20, 250, 30);
        sub.setForeground(Color.WHITE);
        sub.setFont(new Font("Arial", Font.BOLD, 15));

        JButton enrollButton = new JButton("Enrollment");
        enrollButton.setBounds(30, 175, 200, 40);
        enrollButton.setFocusable(false);
        enrollButton.setForeground(Color.WHITE);
        enrollButton.setBackground(Color.decode("#63a163"));

        JButton viewCoursesButton = new JButton("View Available Courses");
        viewCoursesButton.setBounds(30, 275, 200, 40);
        viewCoursesButton.setFocusable(false);
        viewCoursesButton.setForeground(Color.WHITE);
        viewCoursesButton.setBackground(Color.decode("#63a163"));

        JButton addCourseButton = new JButton("Add a Course");
        addCourseButton.setBounds(30, 375, 200, 40);
        addCourseButton.setFocusable(false);
        addCourseButton.setForeground(Color.WHITE);
        addCourseButton.setBackground(Color.decode("#63a163"));

        JButton viewStudentsButton = new JButton("View Students Enrolled");
        viewStudentsButton.setBounds(30, 475, 200, 40);
        viewStudentsButton.setFocusable(false);
        viewStudentsButton.setForeground(Color.WHITE);
        viewStudentsButton.setBackground(Color.decode("#63a163"));
        
       

        leftPanel.add(sub);
        leftPanel.add(enrollButton);
        leftPanel.add(viewCoursesButton);
        leftPanel.add(addCourseButton);
        leftPanel.add(viewStudentsButton);
      
        // Right Panel pre
        JPanel rightPanel = new JPanel();
        rightPanel.setBounds(250, 0, 1000, 800);
        rightPanel.setBackground(Color.BLACK);
        rightPanel.setLayout(new CardLayout()); // Set CardLayout for dynamic switching

        //Panel Admin
        
       
        
        
        
        
        // Panel ng Enrollment
        JPanel enrollmentPanel = new JPanel();
        enrollmentPanel.setBackground(Color.decode("#013d21"));
        enrollmentPanel.setLayout(null);

        JLabel enrollTitle = new JLabel("Enrollment Form");
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

  
        String[] Course = {
        	    "Bachelor Of Arts In Journalism",
        	    "Bachelor Of Early Childhood Education",
        	    "Bachelor Of Elementary Education",
        	    "Bachelor Of Science In Business Administration",
        	    "Bachelor Of Science In Computer Science",
        	    "Bachelor Of Science In Entrepreneurship",
        	    "Bachelor Of Science In Hospitality Management",
        	    "Bachelor Of Science In Information Technology",
        	    "Bachelor Of Science In Office Administration",
        	    "Bachelor Of Science In Psychology",
        	    "Bachelor Of Secondary Education"
        	};
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
                
                // Clear the fields after submission
                fnameField.setText("");
                lnameField.setText("");
                emailField.setText("");
                contactField.setText("");
                courseField.setText("");
            }
        });

        // Panel for Viewing Courses
        JPanel coursesPanel = new JPanel();
        coursesPanel.setBackground(Color.LIGHT_GRAY);
        coursesPanel.setLayout(null);

        JLabel coursesTitle = new JLabel("Available Courses");
        coursesTitle.setBounds(100, 50, 250, 30);
        coursesTitle.setFont(new Font("Arial", Font.BOLD, 20));
        coursesPanel.add(coursesTitle);

        // Panel for Adding a Course
        JPanel addCoursePanel = new JPanel();
        JLabel AddCourses = new JLabel("Add Course");
        
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
        
        
        
        
        


        // Panel for Viewing Students
        JPanel studentsPanel = new JPanel();
        studentsPanel.setBackground(Color.decode("#013d21"));
        studentsPanel.setLayout(null);

        JLabel studentsTitle = new JLabel("Students Enrolled");
        studentsTitle.setBounds(100, 50, 250, 30);
        studentsTitle.setFont(new Font("Arial", Font.BOLD, 20));
        studentsPanel.add(studentsTitle);
        
        
        //adminpanel
      
        
        JPanel AdminLogpanel = new JPanel();
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
        
        
        
   
        

        // Add all panels to the rightPanel (CardLayout)
        rightPanel.add(enrollmentPanel, "Enrollment");
        rightPanel.add(coursesPanel, "Courses");
        rightPanel.add(addCoursePanel, "AddCourse"); //eto yung dalwa ahh 1
        rightPanel.add(studentsPanel, "Students"); //2
        rightPanel.add(AdminLogpanel,"admin");
    
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
        
        
        // aaron may  twoo add pa ah di ko magaawa yung backeand ng admin kaya nilagay ko muna dito yung admin yung lalabas sa dalawa (addcourse saka students)
      
        // Add panels to the frame
        frame.add(leftPanel);
        frame.add(rightPanel);
        frame.setVisible(true);
    }
}
