package enrollmentSystem;

import java.awt.BorderLayout;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;

import javax.swing.*;

public class GuiPrototype {
	JFrame frame = new JFrame();
	JPanel[] panels;
	
	SQLConnector sql = new SQLConnector();
	
	public String[][] resultDataToArray() throws SQLException {
		String[][] data = new String[100][100];
		
		String run = "SELECT Students.Student_ID, Students.ContactNumber, Students.Fname, Students.Lname, Students.EnrollmentDate, Courses.CourseName FROM Students JOIN Courses ON Students.CourseEnrolled = Courses.Course_ID";
		ResultSet rs= this.sql.queryData(run);
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
	
	private void switchPanel(JPanel panel) {
		System.out.println("HI"+panel);
		frame.getContentPane().removeAll();
		frame.getContentPane().add(panel);
		frame.repaint();
		frame.revalidate();
	}

	public  void createGUI() throws SQLException {
		
        String[][] data = this.resultDataToArray();
        String[] columnNames = { "ID", "First Name", "Last Name","Contact Number","Date","Course "};
        
        // Frame Stuff
	        
	        frame.setSize(600, 400);
	        frame.setTitle("Prorotype Table GUi");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        // Create Panels and Buttons
	        JPanel panel1 = new JPanel();
	        String[] buttons = {"View Enrolled Students", "View Available Courses","Enroll Students"};
	        JPanel[] panels= new JPanel[100];
	        JButton returnButton = new JButton("Return");
	        returnButton.addActionListener(e -> switchPanel(panel1));
	        
	        for(int i =0; i<buttons.length; i++) {
	        	panels[i] = new JPanel();
	        }
	        
	        
	        for(int i =0; i<buttons.length; i++) {
	        	int x = i;
	        	JButton	button= new JButton(buttons[i]);
	        	
	        	button.addActionListener(e -> switchPanel(panels[x]));
	        	panel1.add(button, BorderLayout.NORTH);
	        }
	        
	        
	
	        
	        //Enrolled Student Panel
		        JTable table = new JTable(data, columnNames);
		        JScrollPane scrollPane = new JScrollPane(table);
		        JLabel label = new JLabel("Enrolled Students");
		 
		        
		        panels[0].setLayout(new BorderLayout());
		        panels[0].add(label, BorderLayout.NORTH);
		        panels[0].add(returnButton, BorderLayout.WEST);
		        panels[0].add(scrollPane, BorderLayout.CENTER);
		        
		   //View Courses
	        
	        
	        
		frame.add(panel1);    
        frame.setVisible(true);
		
	}
	public static void main(String[] args) {
		GuiPrototype pr= new GuiPrototype();
		try {
			pr.createGUI();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
