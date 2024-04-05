
package Project1;

import java.util.*;

public class Semester {
    
    // Data Fields
    
    public String period;
    public String year;
    public int numCourses = 0;
    public Course[] coursesTaught;
    public Semester[] semesters;
    
    // Constructors
    
    public Semester() {
        
        this.period = "n/a";
        this.year = "";
        this.coursesTaught = new Course[30];
        this.semesters = new Semester[30];
    }
    
    public Semester(String period, String year) {
        
        this.period = period;
        this.year = year;
        this.coursesTaught = new Course[30];
        this.semesters = new Semester[30];
    }
    
    //Getters
    public String getYear(){
      return this.year;
    }
    public String getPeriod (){
      return this.period;
    }
    public Semester[] getSemester(){
      return this.semesters;
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
          result += c.getName() + " " + c.getPrefix() + "\n";
          } else{
              result += "";
          }
      }
      return result;
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
