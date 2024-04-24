
package Project1;

import java.util.ArrayList;


public class Course {
    
    // Data Fields
    public String coursePrefix;
    public String name;
    public int courseNum;
    public String daysTaught;
    public String startTime;
    public String endTime;
    public int credits;
    public Semester[] semesters = new Semester[100];
    
    //faculty
    
    //ID
    ArrayList<Student> assignedStudents;
    private Course[] allCourses = new Course[30];
    // Constructors 
    
    public Course() {
        
        this.coursePrefix = "n/a";
        this.courseNum = 0;
        this.daysTaught = "n/a";
        this.startTime = "n/a";
        this.endTime = "n/a";
        this.credits = 0;
        this.name = "";
        assignedStudents = new ArrayList<>();

    }
    
    public Course(String coursePrefix, int courseNum, String daysTaught, String startTime,
            String endTime, int credits, String name) {
        
        this.coursePrefix = coursePrefix;
        this.courseNum = courseNum;
        this.daysTaught = daysTaught;
        this.startTime = startTime;
        this.endTime = endTime;
        this.credits = credits;
        semesters = new Semester[4];
        assignedStudents = new ArrayList<>();
        this.name = name;
        
    }

  
 // All Getters
  public int getCredits(){
      return credits;
  }
  public String getPrefix(){
      return coursePrefix;
  }
  public int getNum(){
      return courseNum;
  }
  public String getDaysTaught(){
      return daysTaught;
  }
  public String getStartTime(){
      return startTime;
  }
  public String getEndTime(){
      return endTime;
  }
  public String getName(){
      return name;
  }
  
  public Semester[] getSemesters(){
      return this.semesters;
  }
  // All Setters
  public void setCredits(int credits){
      this.credits = credits;
  }
  public void setPrefix(String prefix){
      this.coursePrefix = prefix;
  }
  public void setNum(int courseNum){
      this.courseNum = courseNum;
  }
  public void setDaysTaught(String daysTaught){
      this.daysTaught = daysTaught;
  }
  public void setStartTime(String startTime){
      this.startTime = startTime;
  }
  public void setEndTime(String endTime){
      this.endTime = endTime;
  }
  public void setName(String name){
      this.name = name;
  }

  public void assignSemester(Semester semester){
      int count = 0;
      this.semesters[count++] = semester;
  }
  
  public void addCourse(Course course){
      int count = 0; //May reset to zero
      allCourses[count++] = course;
  }
  
  public String listAllCourses(){
      String result = "";
      for (Course course : allCourses){
          result += course.getName() + "\n";
      }
      
      return result;
  }
  //Print semesters in given course
  public String semesterInCourse(){
      String result = "";
      for(Semester semester : this.semesters){
       result += semester.toString() +" " + getName();
      }
      return result;
  }
  
  public void addStudent(Student student){
      assignedStudents.add(student);
  }
}
