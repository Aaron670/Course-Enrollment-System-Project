package enrollmentSystem;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class CourseEnrollmentConsole {
	String f = "jdbc:sqlite:MainDatabase.db";
	
	SQLConnector SqlConn = new SQLConnector();


	public void showEnrolledJoin() throws Throwable{
		//SELECT student.Student_name, Courses.CName FROM student JOIN Courses ON student.dept_id = Courses.course_id;
		String run = "SELECT Students.Student_ID, Students.ContactNumber, Students.Fname, Students.Lname, Students.EnrollmentDate, Courses.CourseName FROM Students JOIN Courses ON Students.CourseEnrolled = Courses.Course_ID";
		ResultSet rs= this.SqlConn.queryData(run);
		System.out.println("=============================================================");
		while(rs.next()) {
			
			System.out.println("---------------------------------------");
			System.out.println(rs.getInt("Student_ID")+". Name: "+rs.getString("Fname") +" "+rs.getString("Lname"));
			System.out.println("   Contact Number: "+rs.getString("ContactNumber"));
			System.out.println("   Course Enrolled: "+rs.getString("CourseName"));
			System.out.println("   Enrolled Date: "+rs.getString("EnrollmentDate"));	
			System.out.println("***************************************");
		}
		System.out.println("=============================================================");
	}
	
	public void showCourses() throws Throwable {
		f = "SELECT * FROM Courses";
		
		ResultSet rs = this.SqlConn.queryData(f);
		
		while(rs.next()) {
			System.out.println("Course ID: "+rs.getString("Course_ID"));
			System.out.println("Course Name: "+rs.getString("CourseName"));
			System.out.println("Course desc: "+rs.getString("CourseDesc"));
		}
		
	}
	public void addStudent(String execute) {
		this.SqlConn.insertToTable(execute);
		
	}
	
	public void addCourses(String execute) {
		this.SqlConn.insertToTable(execute);
		
	}
	
	
	public void initializeCourses() throws Throwable{
		SqlConn.debaddCourses();
	}
	
	public static void clearLine() {
		for(int i=0;i<100;i++) {
			System.out.println("");
		}
	}
	
	
	public static void main(String[] args) throws Throwable {
		
		CourseEnrollmentConsole Enroll = new CourseEnrollmentConsole();
		boolean check = true;
		Scanner sc = new Scanner(System.in);
		String f;
		
		
		
		
		while(check==true) {
			System.out.println("------------------------------");
			System.out.println("Course Enrollment System");
			System.out.println("------------------------------");
			System.out.print("1.Show Enrolled Students \n2. Show Courses \n3.Enroll Student to a Course \n4. Add more Courses \n>>> ");
			
		
			
			int a = sc.nextInt();
			
			switch(a){
				case 1:
					
					Enroll.showEnrolledJoin();
					break;
				
				case 3:
					System.out.println("Input fname, lname, email, ContactNumber, enrollmentdate(2024-12-2), Course Enrolled ");
					String fname = sc.nextLine();
					System.out.print(">>  ");
					fname = sc.nextLine();
					String lname = sc.nextLine();
					System.out.print(">> ");
					String email = sc.nextLine();
					System.out.print(">> ");
					String CNumber = sc.nextLine();
					System.out.print(">> ");
					String enrollmentDate = sc.nextLine();
					System.out.print(">> ");
					int CourseEN = sc.nextInt();
					
					
					f= String.format("INSERT INTO Students(Fname,Lname,Email,ContactNumber,EnrollmentDate,CourseEnrolled) VALUES('%s','%s','%s','%s','%s',%d)",fname,lname,email,CNumber,enrollmentDate,CourseEN);
					
					System.out.println(f);
					Enroll.addStudent(f);
					break;
					
				case 2:
					Enroll.showCourses();
					break;
				
				case 4:
					System.out.println("Input Course Name and Course Description");
					
					
					
					System.out.print("Courses: >> ");
					String CourseName	= sc.nextLine();
					CourseName = sc.nextLine();
					System.out.print("Desc: >> ");
					String CourseDesc 	= sc.nextLine();
					
					System.out.println("WOW");
					f=String.format("INSERT INTO Courses(CourseName, CourseDesc) VALUES('%s','%s')",CourseName,CourseDesc);
					Enroll.addCourses(f);
					break;
				case 5:
					Enroll.initializeCourses();
				
				default:
					System.out.println("Breaking off....");
					check= false;		
			}			
		}
		
		
	}
}
