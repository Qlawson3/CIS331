
package Project1;


public class Course {
    
    // Data Fields
    public String coursePrefix;
    public String name;
    public int courseNum;
    public String daysTaught;
    public String startTime;
    public String endTime;
    public int credits;
    public Semester semester;
    // define same semester array from semesters class
    Semester[] allSemesters;
    // get the semester count so course can update it properly
    int semCount;
    
    public static int courseCount = 0;
    private static Course[] allCourses = new Course[8];
    
    
    // Constructors 
    
    public Course() {
        
        this.coursePrefix = "n/a";
        this.courseNum = 0;
        this.daysTaught = "n/a";
        this.startTime = "n/a";
        this.endTime = "n/a";
        this.credits = 0;
        this.semester = null;
        allSemesters = Semester.getSemester();
        semCount = Semester.getSemCount();
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
        allSemesters = Semester.getSemester();
        semCount = Semester.getSemCount();
       
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
  
//  public Semester[] getSemesters(){
//      return this.semesters;
//  }
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
  
  public int getCourseCount() {
      return courseCount;
  }
  
  public void setCourseCount(int courseCount) {
      Course.courseCount = courseCount;
  }
 
  public void assignSemester(Semester semester){
      
      this.semester = semester;
  }
  
  //Print semesters in given course
  public String semesterInCourse(){
      String result = "";
      for(Semester semester : this.allSemesters){
       result += semester.toString() + " " + getName();
      }
      return result;
  }
  
  public void addCourse(Course course) 
  {
      allCourses[courseCount++] = course;
  }
  
  public static Course[] getCourses() {
      return allCourses;
  }
  
  public static void setCourses(Course[] allCourses) {
      Course.allCourses = allCourses;
  }
}
