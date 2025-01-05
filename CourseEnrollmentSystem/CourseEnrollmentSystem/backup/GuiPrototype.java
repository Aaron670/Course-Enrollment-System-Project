package enrollmentSystem;

import java.awt.BorderLayout;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

public class GuiPrototype {
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

	public  void createGUI() throws SQLException {
		
        String[][] data = this.resultDataToArray();
        String[] columnNames = { "ID", "First Name", "Last Name","Contact Number","Date","Course "};
        
        
        JFrame frame = new JFrame();
        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        

        JLabel label = new JLabel("Enrolled Students");
        
        
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(label, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        
        frame.add(panel);
        
        // Set frame properties
        frame.setSize(600, 400);
        frame.setTitle("Prorotype Table GUi");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
