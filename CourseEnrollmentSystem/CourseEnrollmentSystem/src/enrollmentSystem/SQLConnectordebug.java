package enrollmentSystem;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLConnectordebug {
	String FileName;
	//Example Filepath "jdbc:sqlite:sample.db";
	
	// this is kinda useless since nag close ung db kada method kaya kailangan mo uli i-connect kada run ng method...
	Connection conn;
	Statement cur;
	
	
	//Initializes the Tables needed if it does not currently exist; Students, Course, Enrolled Students.
	SQLConnectordebug(String F){
		
		this.FileName = F;
		try(Connection connx = DriverManager.getConnection(this.FileName)){
			if(connx!=null) {
				
			
				
				this.conn=connx;
				this.cur=this.conn.createStatement();
			
				
				
				
				//Courses
				
				 String createTable = "CREATE TABLE IF NOT EXISTS Courses ("
						+"Course_ID INTEGER PRIMARY KEY AUTOINCREMENT,"
						+"CourseName TEXT,"
						+"CourseDesc TEXT);";
				this.cur.execute(createTable);
				
				//Students 
						createTable = "CREATE TABLE IF NOT EXISTS Students ("
										+"Student_ID INTEGER PRIMARY KEY AUTOINCREMENT,"
										+"Fname TEXT,"
										+"Lname TEXT,"
										+"Email TEXT,"
										+"ContactNumber TEXT,"
										+"EnrollmentDate DATE,"
										+"CourseEnrolled INTEGER,"
										+"FOREIGN KEY(CourseEnrolled) REFERENCES Courses(Course_ID));";
						this.cur.execute(createTable);

						/*Examples INSERT
f= String.format("INSERT INTO STUDENTS(Fname,Lname,Email,ContactNumber,EnrollmentDate,CourseEnrolled) 
				VALUES('%s','%s','%s','%s','%s',%d)",fname,lname,email,CNumber,enrollmentDate,CourseEN);
				*/
				//Enrollment 
						createTable = "CREATE TABLE IF NOT EXISTS Enrollment ("
								+"Enrollment_ID INTEGER PRIMARY KEY AUTOINCREMENT,"
								+"StudentNam TEXT,"
								+"Lname TEXT,"
								+"Email TEXT);";
				this.cur.execute(createTable);

			
			
			
			}}
		catch (SQLException e) {
			e.printStackTrace();
		}


	}
	
	
	// ACCEPTS SQL STATMENTS ex. executeThis = "INSERT INTO TABLE() VALUES(?,?,?,?)"
	public void insertToTable(String executeThis) {
		try {
			this.conn=DriverManager.getConnection(this.FileName);
			
			this.cur=this.conn.createStatement();
			this.cur.execute(executeThis);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	// used to return data na inoutput nung SQL ie: SELECT na mga Query
	public ResultSet queryData(String executeThis) throws SQLException {
		
		this.conn=DriverManager.getConnection(this.FileName);
		this.cur=this.conn.createStatement();
		
		ResultSet r =this.cur.executeQuery(executeThis);
		
		return r;
	}
	
	
	
	//ONLY FOR DEBUGGING METHODS FOLLOWS/////
	
	public void addCourses() throws SQLException {
		
		this.cur.execute("INSERT INTO Courses(CourseName,CourseDesc) VALUES('BS Computer Science','Description')");
		this.cur.execute("INSERT INTO Courses(CourseName,CourseDesc) VALUES('BS Information Technology','Description')");
		this.cur.execute("INSERT INTO Courses(CourseName,CourseDesc) VALUES('BA Medical Technology','Description')");
		this.cur.execute("INSERT INTO Courses(CourseName,CourseDesc) VALUES('BS International Studies','Description')");
		
	}
	
	//Print Query Data in Console
	//ONLY FOR DEBUGGING
	public void PrintQueryData(String executeThis) throws SQLException {
		ResultSet rs=this.queryData(executeThis);
		
		while (rs.next()) {
            System.out.println("ID: " + rs.getInt("Student_ID"));
            System.out.println("Name: " + rs.getString("Fname"));

        }
    
	
	}
	
		
	public void DebugAddStuff() throws Throwable {
		///EXAMPLE TO FOR DEBUGGING PURPOSES ONLY
		this.cur.execute("INSERT INTO Courses(CourseName,CourseDesc) VALUES('ComSci','Nothing')");
		this.cur.execute("INSERT INTO Students(Fname,Lname,Email,EnrollmentDate,CourseEnrolled) VALUES('Aaron','Sosas','aaron@cvsu.edu.ph','2024-12-2',1)");
		
		String querySQL = "SELECT * FROM Students;";
	
		
		
        ResultSet rs = this.cur.executeQuery(querySQL);
        
        // Print the results
        while (rs.next()) {
        	System.out.println("===============================");
            System.out.println("ID: " + rs.getInt("Student_ID"));
            System.out.println("Name: " + rs.getString("Fname") +" "+  rs.getString("Lname"));
            System.out.println("Email: " + rs.getString("Email"));
            System.out.println("EnrollmentDate: " + rs.getString("EnrollmentDate"));
            System.out.println("CourseEnrolled: " + rs.getString("CourseEnrolled"));
            System.out.println("-----------------------------------------");
        }
		
	}
	
	
	public static void main(String[] args) throws SQLException {
		
		String f = "jdbc:sqlite:sample.db";
		
		SQLConnectordebug newConn = new SQLConnectordebug(f);
		
		f="INSERT INTO Students(Fname,Lname,Email,EnrollmentDate,CourseEnrolled) VALUES('John','Donut','john@cvsu.edu.ph','2024-12-3',1)";
		newConn.insertToTable(f);
	
		
		//rs = newConn.queryData(f);
		System.out.print("Success");
	}
	

}
