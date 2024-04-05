package Project1;

import java.util.ArrayList;
import java.util.List;

public class Enrollment {

// Data Fields
// Course Enrollment Data Fields
public List<Course> courses = new ArrayList<Course>();
public int numEnrolledIn = 0;

private Student student;
private Course course;
private Semester semester;

// Constructors

public Enrollment() {
    this.student = null;
    //this.course = null;
    this.semester = null;
}

public Enrollment(Student student, Semester semester) {
    this.student = student;
    //this.course = course;
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

public void courseEnrollment(Course course) {
    
    if(numEnrolledIn <= 30){
        courses.add(course);
        numEnrolledIn++;
        System.out.println("Added");
    } else{
        System.out.println("Courses full.");
    }

}
////What does this class do
//public int enrollStudent(Student student, Course course, int enrollCount) {
//    
//    if (student != null) 
//    {
//        if (enrollCount < courses.size() && enrollCount >= 0) 
//        {
//            courseEnrollment(course);
//            System.out.println(courses[enrollCount].coursePrefix + 
//                    courses[enrollCount].courseNum);
//            System.out.println("Student has been successfully enrolled!");
//            enrollCount++;
//        }
//        else if (enrollCount >= courses.length)
//            System.out.println("You have reached enrollment limit and "
//                    + " may not enroll in anymore courses.");
//    }
//    else
//        System.out.println("Error: Student doesn't exist");
//    
//    return enrollCount;
//}


public String listStudentSchedule(Student student, Semester semester) {
  String result = "";
    if (student != null && courses != null) {
        
        //boolean foundCourses = false;
        for (int i = 0; i < courses.size(); i++) 
        {
            if (getSemester().equals(semester))
            {
                //foundCourses = true;
                result += "COURSE " + i + ": " + courses.get(i).getPrefix() +
                        courses.get(i).getNum() + ", \n" + courses.get(i).getDaysTaught() +
                        ", " + courses.get(i).getStartTime() + " - " + courses.get(i).getEndTime()
                        + "\n";
            }
        
        }
//        if(!foundCourses)
//        {
//            result = student.fullName + " is currently enrolled in 0 courses for " +
//                    semester.period + " " + semester.year;
//           
//        }
        
    }
    return result;
}
}
