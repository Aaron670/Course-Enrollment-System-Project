package enrollmentSystem;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/*
 * 		SQL Library for Course Enrollment System 
 * 
 * 		Sample Queries:
 * 
 * 		Example INSERT
				f= String.format("INSERT INTO STUDENTS(Fname,Lname,Email,ContactNumber,EnrollmentDate,CourseEnrolled) 
				VALUES('%s','%s','%s','%s','%s',%d)",fname,lname,email,CNumber,enrollmentDate,CourseEN);
				
				
		Example Retrieval of Enrolled Student Data
		
				String run = 	"SELECT Students.Fname, Students.Lname, Courses.CourseName FROM Students JOIN Courses ON 
								Students.CourseEnrolled = Courses.Course_ID";
								
				This Retrieval should be paired with a and Query such as: 
				//SELECT student.Student_name, Courses.CName FROM student JOIN Courses ON student.dept_id = Courses.course_id;
				
				and method that gets the Results using import sql.ResultSet
				
				Code as follows:
				
				
				
				public void showEnrolledJoin() throws Throwable{
			
					String run = "SELECT Students.Fname, Students.Lname, Courses.CourseName FROM Students JOIN Courses ON Students.CourseEnrolled = Courses.Course_ID";
					ResultSet rs= SQLConnector.queryData(run);
					System.out.println("===============================");
					while(rs.next()) {
						
						System.out.println("--------------------------------");
						System.out.println("First Name: "+rs.getString("Fname"));
						System.out.println("Course: "+rs.getString("CourseName"));
						System.out.println("--------------------------------");
					}
					System.out.println("===============================");
				}
		
 * 
 * */
public class SQLConnector {
	String FileName;
	//Example Filepath "jdbc:sqlite:sample.db";
	
	// this is kinda useless since nag close ung db kada method kaya kailangan mo uli i-connect kada run ng method...
	Connection conn;
	Statement cur;
	
	
	//Initializes the Tables needed if it does not currently exist; Students, Courses.
	// Takes parameter Filepath. default filepath is: 'jdbc:sqlite:sample.db'
	
	public void close() throws SQLException {
		this.cur.close();
		this.conn.close();
		System.out.println("Database Successfully Closed.");
	}
	public void overrideSQLConnector() {
		
		try(Connection connx = DriverManager.getConnection(this.FileName)){
			if(connx!=null) {
				
				this.conn=connx;
				this.cur=this.conn.createStatement();
				
				//this.debaddCourses();
				
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

						System.out.println("Database Opened.");
				}
			}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	SQLConnector(){
		this.FileName="jdbc:sqlite:MainDatabase.db";
		this.overrideSQLConnector();
	}
	
	
	// ACCEPTS SQL STATMENTS ex. executeThis = "INSERT INTO TABLE() VALUES(?,?,?,?)"
	public void insertToTable(String executeThis) {
		try {
			this.conn=DriverManager.getConnection(this.FileName);
			
			this.cur=this.conn.createStatement();
			this.cur.execute(executeThis);
			System.out.println("Yays");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("di nagana");
		}
		
	}
	
	// used to return data na inoutput nung SQL ie: SELECT na mga Query
	public ResultSet queryData(String executeThis) throws SQLException {
		
		this.conn=DriverManager.getConnection(this.FileName);
		this.cur=this.conn.createStatement();
		
		ResultSet r =this.cur.executeQuery(executeThis);
		
		return r;
	}
	
	
	
	//ONLY FOR DEBUGGING METHODS FOLLOW/////
	
	public void debaddCourses() throws SQLException {
		
		String r ="INSERT INTO Courses(CourseName,CourseDesc) VALUES('BS Computer Science','The Bachelor of Science in Computer Science (BSCS) is a four-year degree course, which focuses on the study of concepts and theories, algorithmic foundations, implementation and application of information and computing solutions.')";
		this.insertToTable(r);
		r= ("INSERT INTO Courses(CourseName,CourseDesc) VALUES('BS Information Technology','The Bachelor of Science in Information Technology (BSIT) program is a four-year degree program which focuses on the study of computer utilization and computer software to plan, install, customize, operate, manage, administer and maintain information technology infrastructure.')");
		this.insertToTable(r);
		r= ("INSERT INTO Courses(CourseName,CourseDesc) VALUES('BA Medical Technology','The BSMT program covers a wide range of topics in laboratory medicine, including anatomy, physiology, biochemistry, microbiology, hematology, immunology, and parasitology. Students also learn how to operate laboratory equipment, perform clinical tests, and interpret results.')");
		this.insertToTable(r);
		r=("INSERT INTO Courses(CourseName,CourseDesc) VALUES('BS International Studies','Short Description Here')");
		this.insertToTable(r);

		
		//r="DELETE FROM Courses";
		//this.insertToTable(r);
	}
}
