
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
    //OHN: move below code into app association should be stored in app
    //Reference schedule objects
    public List<String> allCoursesSemester = new ArrayList<String>();
    public List<Semester> allSemester = new ArrayList<Semester>();
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

    }
    
    public int getfacultyID(){
      return this.facultyID;
  }
    public String getFullName(){
      return this.fullName;
  }
    // Member Methods
    
    public Department getDepartment() {
        return dept;
    }


    
}
