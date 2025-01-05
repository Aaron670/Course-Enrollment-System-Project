package enrollmentSystem;
import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class NestedScrollPaneExample {
    public static void main(String[] args) throws SQLException {
        // Create a JFrame
        JFrame frame = new JFrame("Nested JScrollPane Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        
        // Create the outer JPanel
        JPanel coursesPanel = new JPanel();
        coursesPanel.setLayout(new BorderLayout());
        
        coursesPanel.setPreferredSize(new Dimension(2,900));
        
        
        // Create the inner JPanel with BoxLayout
        JPanel Courses = new JPanel();
        Courses.setLayout(new BoxLayout(Courses, BoxLayout.Y_AXIS));
        
        // Add multiple box-shaped components to the Courses
        String[][] course = getResult.getCourses();
        int x=0;
        while(x!=course[0].length+4) {
        	System.out.println(course[0].length);
        	JPanel courseBox = new JPanel( new BorderLayout());
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
        
        // Add the Courses to the coursesPanel inside a JScrollPane
        JScrollPane scrollPane = new JScrollPane(Courses);
        
        // Add the scrollPane to the coursesPanel
        coursesPanel.add(scrollPane, BorderLayout.CENTER);
        
        // Add the coursesPanel to the frame
        frame.add(coursesPanel);
        
        // Make the frame visible
        frame.setVisible(true);
    }
}
