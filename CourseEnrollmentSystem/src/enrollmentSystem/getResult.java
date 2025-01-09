package enrollmentSystem;

import java.sql.ResultSet;
import java.sql.SQLException;

public class getResult {
	
	public static String[][] getStudents() throws SQLException {
		
		SQLConnector sql = new SQLConnector();
		
		String run = "SELECT Students.Student_ID, Students.ContactNumber, Students.Fname, Students.Lname, Students.EnrollmentDate, Courses.CourseName FROM Students JOIN Courses ON Students.CourseEnrolled = Courses.Course_ID";
		ResultSet rs= sql.queryData(run);
		
		int rowCount=0;
		while (rs.next()) { rowCount++; }
		
		rs= sql.queryData(run);
		
		String[][] data = new String[rowCount][6];
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
		
		sql.close();
		return data;
	
	}
	//OVERLOAD
		
	public static String[][] getCourses() throws SQLException {
		
		SQLConnector sql = new SQLConnector();
		
		String run = "SELECT * FROM Courses";
		ResultSet rs= sql.queryData(run);
		
		int rowCount=0;
		while (rs.next()) { rowCount++; }
		
		rs= sql.queryData(run);
		
		String[][] data = new String[rowCount][3];
		int x=0;
		while(rs.next()) {
			
			data[x][0]=rs.getString("Course_ID");
			data[x][1]=rs.getString("CourseName");
			data[x][2]=rs.getString("CourseDesc");
			x++;
		}
		sql.close();
		return data;
	}
	
	public static void deleteCourse(int courseID) throws Exception{
		
		SQLConnector sql = new SQLConnector();
		String run = String.format("DELETE FROM Students WHERE CourseEnrolled=%d", courseID);
		sql.insertToTable(run);
		
		run = String.format("DELETE FROM Courses WHERE Course_ID=%d", courseID);
		sql.insertToTable(run);
		
		sql.close();
	}
	
}