
package Project1;


public class Semester {
    
    // Data Fields
    
    public String period;
    public int year;
    public int numCourses;
    public Course[] coursesTaught;
    
    // Constructors
    
    public Semester() {
        
        this.period = "n/a";
        this.year = 0;
        this.numCourses = 0;
        this.coursesTaught = new Course[300];
    }
    
    public Semester(String period, int year, int numCourses) {
        
        this.period = period;
        this.year = year;
        this.numCourses = numCourses;
        this.coursesTaught = new Course[300];
    }
    
    // Member Methods
    
    public void listCourses(Course course) {
        // add course to array
        coursesTaught[numCourses++] = course;
        
    }
    
}
