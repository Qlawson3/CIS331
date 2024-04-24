
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
    public String dept; //may create class later, is not necessary for this project
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
            String phoneNum, String dept, String position) {
        
        this.facultyID = facultyID;
        this.fullName = fullName;
        this.email = email;
        this.building = building; 
        this.officeNum = officeNum;
        this.phoneNum = phoneNum;
        this.dept = dept;
        this.position = position;

    }
    // Getters
    public int getfacultyID(){
      return this.facultyID;
  }
    public String getFullName(){
        return this.fullName;
    }
    public String getBuilding(){
      return this.building;
  }
    public String getDept() {
        return this.dept;
    }
    
    public int getOfficeNum(){
        return this.officeNum;
    }
    
    public String getPosition(){
        return this.position;
    }
    
    public String getPhoneNum(){
        return this.phoneNum;
    }
    
    public String getEmail(){
        return this.email;
    }
    // Setters
    public void setFullName(String fullName){
      this.fullName = fullName;
  }
    public void setEmail(String email){
      this.email = email;
  }
    public void setBuilding(String building){
      this.building = building;
  }
    public void setOfficeNum(int officeNum){
      this.officeNum = officeNum;
  }
    public void setPhoneNum(String phoneNum){
      this.phoneNum = phoneNum;
  }
    public void setDept(String dept){
      this.dept = dept;
  }
    public void setPosition(String position){
      this.position = position;
  }
    // Member Methods
    
    


    
}
