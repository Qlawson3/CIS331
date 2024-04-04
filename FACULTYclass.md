
package Project1;

import java.util.*;


public class Faculty {
    
    // Data Fields
    public int facultyID;
    public String fullName;
    public String email;
    public String building;
    public int officeNum;
    public String phoneNum;
    public Department dept;
    public String position;
    public Course[] assignedCourses;
    public int numAssignedTo;
    
    public List<Course> allCourses;
    public List<Semester> allSemester;
    // Constructors
    
    public Faculty() {
        
        this.facultyID = 0;
        this.fullName = "n/a";
        this.email = "n/a";
        this.building = "n/a";
        this.officeNum = 0;
        this.phoneNum = "n/a";
        this.dept = null;
        this.position = "n/a";
        this.assignedCourses = new Course[8];
        this.numAssignedTo = 0;
        
    }
    
    public Faculty(int facultyID, String fullName, String email, String building, int officeNum,
            String phoneNum, Department dept, String position) {
        
        this.facultyID = facultyID;
        this.fullName = fullName;
        this.email = email;
        this.building = building; 
        this.officeNum = officeNum;
        this.phoneNum = phoneNum;
        this.dept = dept;
        this.position = position;
        this.assignedCourses = new Course[8];
        this.numAssignedTo = 0;
    }
    
    // Member Methods
    
    public Department getDepartment() {
        return dept;
    }
    
    public void assignCourse(Course course) {
        
        if (numAssignedTo < assignedCourses.length)
        {
            assignedCourses[numAssignedTo++] = course;
        }
        
    }
    
    //add faculty to a course list
    public void addCourse(Course course){
        allCourses.add(course);
    }
    
    public void addSemester(Semester semester){
        allSemester.add(semester);
    }
    
    //print all Courses in a given semester associated with a faculty member
    public String getAllInSemester(Semester semester){
        String result = "";
        for (Course course : allCourses){
            if(course.getSemesters().equals(semester)){
                result += course.getName() + " " + semester.toString() + "\n";
            }
            
        }
        
        return result;
    }
    
//    public int facultyID;
//    public String fullName;
//    public String email;
//    public String building;
//    public int officeNum;
//    public String phoneNum;
//    public Department dept;
//    public String position;
//    public Course[] assignedCourses;
//    public int numAssignedTo;
    public int getfacultyID(){
      return this.facultyID;
  }
    public String getFullName(){
      return this.fullName;
  }
    
}
