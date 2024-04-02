
package Project1;


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
    
    
    
    
}
