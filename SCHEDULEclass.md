
package Project1;

import java.util.*;


public class Schedule {
    
    // Data Fields
    public int scheduleID;
    private Course course;
    private Faculty faculty;
    private Semester semester;
   
    public List<Course> allCourses = new ArrayList<Course>();
    public List<Schedule> allSchedules = new ArrayList<Schedule>();
    public List<Semester> allSemester = new ArrayList<Semester>();
    //enrollment to hold multiple students
    //create association bet
    // Constructors
    
    public Schedule() {
        this.faculty = null;
        this.semester = null;
    }

    
    // Getters 
    public Faculty getFaculty(){
      return this.faculty;
  }
    public Semester getSemester(){
      return this.semester;
  } 
    // Setters
    public Faculty setFaculty(Faculty faculty){
      return this.faculty = faculty;
  }
    public Semester setSemester(Semester semester){
      return this.semester = semester;
  }
    // Member Methods
    public void assignSemester(Faculty faculty, Semester semester){
        Schedule schedule = new Schedule();
        schedule.setFaculty(faculty);
        schedule.setSemester(semester);
        allSchedules.add(schedule);
    }
    
    // Change class faculty can teach
    public void setCourseAtIndex(Course course, int index){
      for (int i = 0; i < allCourses.size(); i++){
          if (i == index){
              allCourses.set(index, course);
          }
      }
  }
    
   public void addCourse(Course course){
      allCourses.add(course);
  } 
    public String getAllInSemester(Semester semester, Faculty faculty){
        String result = "";
        for (int s = 0; s < allSchedules.size(); s++){
        for (int i = 0; i < allCourses.size(); i++){ // for every element in the personal course list
        Schedule schedule = allSchedules.get(s);
        if (schedule.getSemester().equals(semester)) { // check if the semester matches 
            result += allCourses.get(i).getName() + " " + allCourses.get(i).getPrefix() 
                    + " " + allSchedules.get(s).getSemester().getPeriod() + " "
                    + allSchedules.get(s).getSemester().getYear() + "| \n"; //Return the courses name and given semester
            }
            }
        }
        return "Faculty member " + faculty.getFullName() + " is associated with: " + result;
    }
   //TESTING PURPOSES
//    public String allCourse(){
//        String result = "";
//        for (Course c : allCourses){
//            result += c.getName() + " " + c.getPrefix() + "\n";
//        }
//        return result;
//    }
    
//    public String checkAll(){
//        String result = "";
//        for (int i = 0; i < allSchedules.size(); i++){
//            if (allSchedules.get(i) != null)
//                result += allSchedules.get(i);
//        }
//      return result;
//    }

    
}
