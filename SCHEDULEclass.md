
package Project1;


public class Schedule {
    
    // Data Fields
    public int scheduleID;
    private Course course;
    private Faculty faculty;
    private Semester semester;
    
    // Constructors
    
    public Schedule() {
        
        this.scheduleID = 0;
        this.course = null;
        this.faculty = null;
        this.semester = null;
    }
    
    public Schedule(int scheduleID, Course course, Faculty faculty, Semester semester) {
        
        this.scheduleID = scheduleID;
        this.course = course;
        this.faculty = faculty;
        this.semester = semester;
    }
    
    // Getters and Setters
    
    
  
    
}
