
package com.mycompany.db2;
import java.util.ArrayList;
import java.util.List;

import java.sql.*;
import oracle.jdbc.pool.*;
import oracle.jdbc.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Enrollment {


// Data Fields
    public static OracleDataSource oDS;
    public static Connection jsqlConn;
    public static PreparedStatement jsqlStmt;
    public static ResultSet jsqlResults;
// Course Enrollment Data Fields
public List<Course> courses = new ArrayList<Course>();
public int numEnrolledIn = 0;

public int enrollID;

private Student student;
private Course course;
private Semester semester;

// Constructors

public Enrollment() {
    this.student = null;
    this.semester = null;
    this.enrollID = App.getEnrollID();
    course.addStudent(this.student);
    this.course = null;
}

public Enrollment(Student student, Semester semester, Course course) {
    this.enrollID = App.getEnrollID();
    this.student = student;
    this.course = course;
    this.semester = semester;
}

// Getters and Setters

public Student getStudent() {
    return this.student;
}
public int getID() {
    return this.enrollID;
}
public void setStudent(Student student) {
    this.student = student;
}

public Course getCourse() {
    return this.course;
}
public int getNumEnrolled() {
    return this.numEnrolledIn;
}
public Semester getSemester() {
    return this.semester;
}

public void setSemester(Semester semester) {
    this.semester = semester;
}

// Member Methods

public void courseEnrollment(Course course) {
    
    if(numEnrolledIn <= 30){
        courses.add(course);
        numEnrolledIn++;
        
    //    System.out.println("Added");
 //  } else{
    //    System.out.println("Courses full.");
  //  }

}
}


public String listStudentSchedule(Student student, Semester semester) {
  String result = "";
    if (student != null && courses != null) {
        
        //boolean foundCourses = false;
        for (int i = 0; i < courses.size(); i++) 
        {
            if (getSemester().equals(semester))
            {
            // Build the insert query for the current course
            String query = "INSERT INTO REPORT3 (CoursesID, StudentID) VALUES (" + courses.get(i).getID() + "," 
                    + this.student.getID() + ")";
            // Execute the query
            System.out.println(query);
            runDBQuery(query, 'c');
                
                //foundCourses = true;
                result += "COURSE " + i + ": " + courses.get(i).getPrefix() +
                        courses.get(i).getNum() + ", \n" + courses.get(i).getDaysTaught() +
                        ", " + courses.get(i).getStartTime() + " - " + courses.get(i).getEndTime()
                        + "\n";
            }
        
        }
//        if(!foundCourses)
//        {
//            result = student.fullName + " is currently enrolled in 0 courses for " +
//                    semester.period + " " + semester.year;
//           
//        }
        
    }
    return result;
}

public String describeEnroll() {
    String describe = "";
    for(int i = 0; i < this.courses.size(); i++)
    {
        describe += this.courses.get(i).getPrefix() + " " + this.courses.get(i).getNum() + " " +
                this.semester.getPeriod() + this.semester.getYear() + "\n";
    }
   
    return this.enrollID + ": " + this.student.fullName + " is enrolled in " +
            describe;
           
}

@Override
public String toString() {
    return "Enroll ID: " + this.enrollID;
}

public static void runDBQuery(String query, char queryType)
    {
        // queryType - Using the C.R.U.D. acronym
        // 'r' - SELECT
        // 'c', 'u', or 'd' - UPDATE, INSERT, DELETE
        
        try
        {
            String URL = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
            String user = "javauser"; // From setup instructions
            String pass = "javapass"; // From setup instructions

            oDS = new OracleDataSource();
            oDS.setURL(URL);
            
            jsqlConn = oDS.getConnection(user, pass);
            jsqlStmt = jsqlConn.prepareStatement(
                    query, 
                    ResultSet.TYPE_SCROLL_INSENSITIVE, 
                    ResultSet.CONCUR_READ_ONLY);
            
            if (queryType == 'r')
                jsqlResults = jsqlStmt.executeQuery();
            else
                jsqlStmt.executeUpdate();
        }
        catch (SQLException sqlex)
        {
            System.out.println(sqlex.toString());
        }
    } // End of runDBQuery() method
}

//
//return this.enrollID + ": " + this.student.fullName + " enrolled in " +
//            this.course.coursePrefix + " " + this.course.courseNum + " for " + this.semester.period
//            + this.semester.year;
