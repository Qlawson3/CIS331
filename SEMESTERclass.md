
package Project1;

import java.util.*;

public class Semester {
    
    // Data Fields
    
    public String period;
    public int year;
    public int numCourses;
    public Course[] coursesTaught;
    public Semester[] semesters;
    
    // Constructors
    
    public Semester() {
        
        this.period = "n/a";
        this.year = 0;
        this.numCourses = 0;
        this.coursesTaught = new Course[30];
        this.semesters = new Semester[30];
    }
    
    public Semester(String period, int year, int numCourses) {
        
        this.period = period;
        this.year = year;
        this.numCourses = numCourses;
        this.coursesTaught = new Course[30];
        this.semesters = new Semester[30];
    }
    
    //Getters
    public int getYear(){
      return this.year;
    }
    public String getPeriod (){
      return this.period;
    }
    public Semester[] getSemester(){
      return this.semesters;
    }
    //Setters
    public void setYear(int year){
      this.year = year;
    }
    public void setPeriod (String period){
      this.period = period;
    }
    public void addSemester(Semester semester){
      int count = 0;
      semesters[count++] = semester;
    }
    // Member Methods
    
    public void listCourses(Course course) {
        // add course to array
        coursesTaught[numCourses++] = course; 
    }
    
    //list all semesters
    public String toString(){
       String str = "";
       for(Semester semester : semesters){
           str += semester.getPeriod() + semester.getYear() + "\n";
       }
       return str; 
    }
    
}
