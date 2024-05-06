/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.universityapp;

/**
 *
 * @author liahill
 */
public class Semester {
    
    // Data Fields

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
    
public String listAssignedCourses(){
  String result = "";
  for(Course c : coursesTaught){
      if(c != null){
      result += c.getPrefix() + " " + c.getNum() + "\n";
      } else{
          result += "";
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
}
