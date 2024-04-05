
package Project1;


public class Enrollment {
   
    // Data Fields
    
    private Student student;
    private Course course;
    private Semester semester;
    
    // Constructors
    
    public Enrollment() {
        this.student = null;
        this.course = null;
        this.semester = null;
    }
    
    public Enrollment(Student student, Course course, Semester semester) {
        this.student = student;
        this.course = course;
        this.semester = semester;
    }
    
    // Getters and Setters
    
    public Student getStudent() {
        return this.student;
    }
    
    public void setStudent(Student student) {
        this.student = student;
    }
    
    public Course getCourse() {
        return this.course;
    }
    
    public void setCourse(Course course) {
        this.course = course;
    }
    
    public Semester getSemester() {
        return this.semester;
    }
    
    public void setSemester(Semester semester) {
        this.semester = semester;
    }
    
    // Member Methods
    
    public static int enrollStudent(Student student, Course course, int enrollCount) {
        
        if (student != null) 
        {
            if (enrollCount < student.courses.length && enrollCount >= 0) 
            {
                student.courses[enrollCount] = course;
                System.out.println(student.courses[enrollCount].coursePrefix + 
                        student.courses[enrollCount].courseNum);
                System.out.println("Student has been successfully enrolled!");
                enrollCount++;
            }
            else if (enrollCount >= student.courses.length)
                System.out.println("You have reached enrollment limit and "
                        + " may not enroll in anymore courses.");
        }
        else
            System.out.println("Error: Student doesn't exist");
        
        return enrollCount;
    }
    
    
    public static void listStudentSchedule(Student student, Semester semester) {
      
        if (student != null && student.courses != null) {
            
            boolean foundCourses = false;
            for (int i = 0; i < student.courses.length; i++) 
            {
                if (student.courses[i] != null) {
                if (student.courses[i].semester.equals(semester))
                {
                    foundCourses = true;
                    System.out.println("COURSE " + i + ": " + student.courses[i].coursePrefix +
                            student.courses[i].courseNum + ", \n" + student.courses[i].daysTaught +
                            ", " + student.courses[i].startTime + " - " + student.courses[i].endTime);
                    System.out.println();
                }
            }
            }
            if (!foundCourses)
            {
                System.out.println(student.fullName + " is currently enrolled in 0 courses for " +
                        semester.period + " " + semester.year);
            }
        }
        
    }
    
    
    
}
