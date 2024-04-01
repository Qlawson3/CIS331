
package Project1;


public class Student {
    
    // Data Fields
    public String fullName;
    public int studentID; 
    private int ssn;
    private String homeAddress;
    public String email;
    private double GPA;
   
    // Emergency Contact Data Fields
    public String emergencyName;
    public String emergencyEmail;
    public String emergencyPhoneNum;
    
    // Course Enrollment Data Fields
    public Course[] courses;
    public int numEnrolledIn;
    
    
    
    // Constructors
    
    public Student() {
        this.fullName = "n/a";
        this.studentID = 0;
        this.ssn = 0;
        this.homeAddress = "n/a";
        this.email = "n/a";
        this.GPA = 0.0;
        this.emergencyName = "n/a";
        this.emergencyEmail = "n/a";
        this.emergencyPhoneNum = "n/a";
        this.courses = new Course[8];
        this.numEnrolledIn = 0;
        
    }
    
    public Student(String fullName, int studentID, int ssn, String homeAddress, String email, double GPA,
            String emergencyName, String emergencyEmail, String emergencyPhoneNum) {
        
        this.fullName = fullName;
        this.studentID = studentID;
        this.ssn = ssn;
        this.homeAddress = homeAddress;
        this.email = email;
        this.GPA = GPA;
        this.emergencyName = emergencyName;
        this.emergencyEmail = emergencyEmail;
        this.emergencyPhoneNum = emergencyPhoneNum;
        this.courses = new Course[8];
        this.numEnrolledIn = 0;
    }
    
    // Getters and Setters
    
    
    // Member Methods
    
    public void addEmergencyContact(String name, String email, String phoneNum) {
        
        this.emergencyName = name;
        this.emergencyEmail = email;
        this.emergencyPhoneNum = phoneNum;
    }
   
    public void courseEnrollment(Course course) {
        
        if (numEnrolledIn < courses.length) {
            courses[numEnrolledIn++] = course;
        }
        else
            System.out.println("You have reached course enrollment limit.");
    }
     
}
