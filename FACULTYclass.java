/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.universityapp;

/**
 *
 * @author liahill
 */

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
        
        this.facultyID = App.getFacID();
        this.fullName = "n/a";
        this.email = "n/a";
        this.building = "n/a";
        this.officeNum = 0;
        this.phoneNum = "n/a";
        this.dept = null;
        this.position = "n/a";

        
    }
    
    public Faculty(String fullName, String email, String building, int officeNum,
            String phoneNum, String dept, String position) {
        
        this.facultyID = App.getFacID();
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
    public int getID(){
        return this.facultyID;
    }
    
    // Setters
    public void setFullName(String fullName){
      this.fullName = fullName;
  }
    public void setID(int ID){
        this.facultyID = ID;
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
    
@Override
public String toString() {
    return this.getID() + ": " + this.getFullName();
}
public String describeFaculty() {
    return String.format("%-15d%-20s%-25s%-20s%-10d%-15s%-15s%-15s", 
            this.facultyID, this.fullName, this.email,
            this.building, this.officeNum, this.phoneNum, this.dept, this.position);
}


    
}
