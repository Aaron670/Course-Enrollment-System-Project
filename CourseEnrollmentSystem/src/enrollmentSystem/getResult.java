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
	
	public static void addPeople() throws Exception{

		SQLConnector sql = new SQLConnector();
		String run = "INSERT INTO Students(Fname,Lname,Email,ContactNumber,EnrollmentDate,CourseEnrolled) VALUES('John', 'Doe', 'john.doe@example.com', '09123456789', '2025-01-01', 2),('None', 'Doe', 'john.doe@example.com', '09123456789', '2025-01-01', 2), ('Jane', 'Smith', 'jane.smith@example.com', '09234567890', '2025-02-01', 3), ('Alex', 'Johnson', 'alex.johnson@example.com', '09345678901', '2025-03-01', 1), ('Emily', 'Brown', 'emily.brown@example.com', '09456789012', '2025-04-01', 4), ('Chris', 'Davis', 'chris.davis@example.com', '09567890123', '2025-05-01', 5), ('Michael', 'Taylor', 'michael.taylor@example.com', '09678901234', '2025-06-01', 1), ('Sarah', 'Williams', 'sarah.williams@example.com', '09789012345', '2025-07-01', 2), ('David', 'Miller', 'david.miller@example.com', '09890123456', '2025-08-01', 3), ('Laura', 'Martinez', 'laura.martinez@example.com', '09901234567', '2025-09-01', 4), ('Daniel', 'Hernandez', 'daniel.hernandez@example.com', '09012345678', '2025-10-01', 5)";
				;
		sql.insertToTable(run);
		sql.close();
	}
}