/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.db2;import java.util.*;

import java.sql.*;
import oracle.jdbc.pool.*;
import oracle.jdbc.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author liahill
 */

public class Schedule {
    
    // Data Fields
    public static OracleDataSource oDS;
    public static Connection jsqlConn;
    public static PreparedStatement jsqlStmt;
    public static ResultSet jsqlResults;
    
    public int scheduleID;
    private Course course;
    private Faculty faculty;
    private Semester semester;
   
    public List<Course> allCourses = new ArrayList<>();
    public List<Schedule> allSchedules = new ArrayList<>();
    public List<Semester> allSemesters = new ArrayList<>();
    //enrollment to hold multiple students
    //create association bet
    // Constructors
    
    public Schedule() {
        this.faculty = null;
        this.course = null;
        this.semester = null;
        this.scheduleID = App.getSchedID();
    }
    
    public Schedule(Faculty faculty, Course course, Semester semester) {
        this.faculty = faculty;
        this.course = course;
        this.semester = semester;
        this.scheduleID = App.getSchedID();
    }

    
    // Getters 
    public Faculty getFaculty(){
      return this.faculty;
  }
    public int getScheduleID(){
      return this.scheduleID;
  }
    public Semester getSemester(){
      return this.semester;
  } 
    // Setters
    public Faculty setFaculty(Faculty faculty){
      return this.faculty = faculty;
  }
    public Semester setSemester(Semester semester){
      return this.semester = semester;
  }
    // Member Methods
    public void assignSemester(Schedule schedule, Semester semester){
        schedule.faculty = faculty;
        schedule.semester = semester;
        allSchedules.add(schedule);
    }
    
    // Change class faculty can teach
    public void setCourseAtIndex(Course course, int index){
      for (int i = 0; i < allCourses.size(); i++){
          if (i == index){
              allCourses.set(index, course);
          }
      }
  }
    
   public void addCourse(Course course){
      allCourses.add(course);
  } 
    public String getAllInSemester(Semester semester, Faculty faculty){
        String result = "";
        for (int s = 0; s < allSchedules.size(); s++){
        for (int i = 0; i < allCourses.size(); i++){ // for every element in the personal course list
        Schedule schedule = allSchedules.get(s);
        if (schedule.getSemester().equals(semester)) { // check if the semester matches 
            
            // Build the insert query for the current course
            String query = "INSERT INTO REPORT2 (CourseID, SemesterID) VALUES (" + allCourses.get(i).getID() + "," 
                    + allSchedules.get(s).getSemester().getID() + ")";
            // Execute the query
            System.out.println(query);
            runDBQuery(query, 'c');
            
            result += allCourses.get(i).getPrefix() + " " + allCourses.get(i).getNum() 
                    + " " + allSchedules.get(s).getSemester().getPeriod() + " "
                    + allSchedules.get(s).getSemester().getYear() + "| \n"; //Return the courses name and given semester
            }
        }
        }
        return "Faculty member " + faculty.getFullName() + " is associated with: " + result;
    }
   //TESTING PURPOSES
//    public String allCourse(){
//        String result = "";
//        for (Course c : allCourses){
//            result += c.getName() + " " + c.getPrefix() + "\n";
//        }
//        return result;
//    }
    
//    public String checkAll(){
//        String result = "";
//        for (int i = 0; i < allSchedules.size(); i++){
//            if (allSchedules.get(i) != null)
//                result += allSchedules.get(i);
//        }
//      return result;
//    }


public String describeSched() {
    String describe = "";
    for(int i = 0; i < this.allCourses.size(); i++)
    {
        describe += this.allCourses.get(i).getPrefix() + this.allCourses.get(i).getNum() +
                " for " + this.semester.getPeriod() + " " + this.semester.getYear() + "\n";
    }
    return this.scheduleID + ": " + this.faculty.getFullName() + " is assigned to " +
            describe;
}

@Override
public String toString() {
    return "Schedule ID: " + this.scheduleID;
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
    
//return String.format(this.faculty.getFullName() + " is assigned to " + this.course.getPrefix() +
//            this.course.getNum() + " for " + this.semester.getPeriod() + " " + this.semester.getYear());
