package Project1;

import java.util.ArrayList;
import java.util.List;

public class Enrollment {

// Data Fields
// Course Enrollment Data Fields
public List<Course> courses = new ArrayList<Course>();
public int numEnrolledIn = 0;
public int enrollID = 0;
private Student student;
private Course course;
private Semester semester;

// Constructors

public Enrollment() {
    this.student = null;
    this.semester = null;
    course.addStudent(this.student);
    this.course = null;
}

public Enrollment(Student student, Semester semester, Course course) {
    this.student = student;
    this.course = course;
    course.addStudent(student);
    this.semester = semester;
}

// Getters and Setters
public void setEnrollID(int enrollID){
    this.enrollID = enrollID;
}
public Student getStudent() {
    return this.student;
}
public int getEnrollID() {
    return this.enrollID;
}
public void setStudent(Student student) {
    this.student = student;
}

public Course getCourse() {
    return this.course;
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
//Your system must show all students enrolled in a single Course in a certain
//Semester.
//public void allStudentsInCourse(Course course, Semester semester){
//    for (Course course : courses) {
//        System.out.println("Students enrolled in " + course.getPrefix() + " " + course.getNum() + " for " 
//                + semester.getPeriod() + " " + semester.getYear() + ":");
//        //one student only enrolled in 1 semester anyway
//        
//        //if this.getCourse = course > then print name if this.
//        for (Student student : assignedStudents) {
//            if (student != null){
//            System.out.println(student.fullName + " - " + student.studentID);  
//            }
//        }
//
//        
//    }
//}

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
