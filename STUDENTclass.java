
package com.mycompany.universityapp;

public class Student {
    
    // Data Fields
    
    
public String fullName;
public int studentID;
private String ssn;
private String homeAddress;
public String email;
private double gpa;

// Emergency Contact Data Fields
private String emergencyName;
private String emergencyEmail;
private String emergencyPhoneNum;





// Constructors

public Student() {
    this.fullName = "n/a";
    // get ID from method that produces unique IDs
    this.studentID = App.getStudID();
    this.ssn = "n/a";
    this.homeAddress = "n/a";
    this.email = "n/a";
    this.gpa = 0.0;
    this.emergencyName = "n/a";
    this.emergencyEmail = "n/a";
    this.emergencyPhoneNum = "n/a";
    //this.courses = new Course[8];
    //this.numEnrolledIn = 0;
    
}

public Student(String fullName, String ssn, String homeAddress, String email, double gpa,
        String emergencyName, String emergencyEmail, String emergencyPhoneNum) {
    
    this.fullName = fullName;
    this.studentID = App.getStudID(); // assign unique ID
    this.ssn = ssn;
    this.homeAddress = homeAddress;
    this.email = email;
    this.gpa = gpa;
    this.emergencyName = emergencyName;
    this.emergencyEmail = emergencyEmail;
    this.emergencyPhoneNum = emergencyPhoneNum;
    //this.courses = new Course[8];
    //this.numEnrolledIn = 0;
}

// Getters and Setters
public int getID(){
    return this.studentID;
}

public String getEmail(){
    return this.email;
}


public String getSSN() {
    return this.ssn;
}

public String getFullName() {
    return this.fullName;
}

public void setSSN(String ssn) {
    this.ssn = ssn;
}

public String getAddress() {
    return this.homeAddress;
}

public void setAddress(String homeAddress) {
    this.homeAddress = homeAddress;
}

public double getGPA() {
    return this.gpa;
}

public void setGPA(double gpa) {
    this.gpa = gpa;
}
public void setID(int studentID) {
    this.studentID = studentID;
}
public void setEmail(String email) {
    this.email = email;
}
public void setFullName(String fullName) {
    this.fullName = fullName;
}
public String getEmergencyName() {
    return this.emergencyName;
}

public void setEmergencyName(String emergencyName) {
    this.emergencyName = emergencyName;
}

public String getEmergencyEmail() {
    return this.emergencyEmail;
}

public void setEmergencyEmail(String emergencyEmail) {
    this.emergencyEmail = emergencyEmail;
}

public String getEmergencyPhone() {
    return this.emergencyPhoneNum;
}

public void setEmergencyPhone(String emergencyPhone) {
    this.emergencyPhoneNum = emergencyPhone;
}
        

// Member Methods

public void addEmergencyContact(String name, String email, String phoneNum) {
    
    this.emergencyName = name;
    this.emergencyEmail = email;
    this.emergencyPhoneNum = phoneNum;
}

@Override
public String toString() {
    return this.getID() + ": " + this.getFullName();
}

public String describeStudent() {
    return String.format("%-15s%-15d%-15s%-25s%-20s%-7.2f%-15s%-25s%-15s", 
            this.fullName, this.studentID, this.ssn, this.homeAddress,
            this.email, this.gpa, this.emergencyName, this.emergencyEmail,
            this.emergencyPhoneNum);
}


}
