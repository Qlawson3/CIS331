
package Project1;


public class Course {
    
    // Data Fields
    public String coursePrefix;
    public int courseNum;
    public String daysTaught;
    public String startTime;
    public String endTime;
    public int credits;
    public Semester semester;
    private Student[] assignedStudents;
    private int enrollLimit; 
    private Course[] courses;
    
    
    // Constructors 
    
    public Course() {
        
        this.coursePrefix = "n/a";
        this.courseNum = 0;
        this.daysTaught = "n/a";
        this.startTime = "n/a";
        this.endTime = "n/a";
        this.credits = 0;
        this.semester = null;
        this.assignedStudents = new Student[30];
        this.enrollLimit = 30;
        this.courses = new Course[5];
    }
    
    public Course(String coursePrefix, int courseNum, String daysTaught, String startTime,
            String endTime, int credits, Semester semester) {
        
        this.coursePrefix = coursePrefix;
        this.courseNum = courseNum;
        this.daysTaught = daysTaught;
        this.startTime = startTime;
        this.endTime = endTime;
        this.credits = credits;
        this.semester = semester;
        this.assignedStudents = new Student[30];
        this.enrollLimit = 30;
        this.courses = new Course[5];
        
    }
    
    // Member Methods
    
    public void assignSemester(Semester semester) {
        this.semester = semester;
    }
    
    public void addCourse(Course course, Student student) {
        
        
    }
    
    public void countStudents(Student studentEnrolled) {
        
        
    }
    
}
