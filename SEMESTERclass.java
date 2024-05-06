/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.db2;

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
public class Semester {
    
    // Data Fields
public static OracleDataSource oDS;
    public static Connection jsqlConn;
    public static PreparedStatement jsqlStmt;
    public static ResultSet jsqlResults;
    
public String period;
public String year;
public int semID;
public int numCourses = 0;
public Course[] coursesTaught;
public Semester[] semesters;

// Constructors

public Semester() {
    
    this.period = "n/a";
    this.semID = App.getSemID();
    this.year = "";
    this.coursesTaught = new Course[30];
    this.semesters = new Semester[30];
}

public Semester(String period, String year) {
    
    this.period = period;
    this.year = year;
    this.semID = App.getSemID();
    this.coursesTaught = new Course[30];
    this.semesters = new Semester[30];
   
}

//Getters
public String getYear(){
  return this.year;
}
public int getID() {
    return this.semID;
}
public void setID(int ID) {
    this.semID = ID;
}
public String getPeriod (){
  return this.period;
}
public Semester[] getSemester(){
  return this.semesters;
}
public Semester getASemester(Semester semester, int index){   
  return semester.semesters[index];
}
//Setters
public void setYear(String year){
  this.year = year;
}
public void setPeriod (String period){
  this.period = period;
}
public void addSemester(Semester semester){
  for (int i = 0; i < semesters.length; i++) {
    if (semesters[i] == null) {
        semesters[i] = semester;
        break; 
    }
}
}

// Member Methods

public void assignCourses(Course course) {
    // add course to array
    coursesTaught[numCourses++] = course; 
}
    
public String listAssignedCourses() {
    String result = "";
    // StringBuilder for each INSERT query
    StringBuilder insertQuery = new StringBuilder();

    boolean isFirst = true; // Flag to determine if it's the first iteration
    for (Course c : coursesTaught) {
        if (c != null) {
            // Build the insert query for the current course
            String query = "INSERT INTO REPORT1 (CourseID) VALUES (" + c.getID() + ")";
            // Execute the query
            System.out.println(query);
            runDBQuery(query, 'c');
            // Build the result string
            result += c.getPrefix() + " " + c.getNum() + "\n";
        }
    }

    return result;
}

@Override
public String toString() {
    return this.getID() + ": " + this.getPeriod() + " " + this.getYear();
}
public String describeSemester()
{
   return String.format("%-15d%-10s%-5s", this.getID(), this.period, this.year);
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
