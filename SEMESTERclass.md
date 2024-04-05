
package Project1;


public class Semester {
    
    // Data Fields

public String period;
public int year;
public int numCourses = 0;
public Course[] coursesTaught;
public static Semester[] allSemesters = new Semester[30];
public static int semCount;



// Constructors

public Semester() 
{
    this.period = "n/a";
    this.year = 0;
}

public Semester(String period, int year) {
    
    this.period = period;
    this.year = year;
}

//Getters
public int getYear(){
  return this.year;
}
public String getPeriod (){
  return this.period;
}
public static Semester[] getSemester(){
  return allSemesters;
}
//Setters
public void setYear(int year){
  this.year = year;
}
public void setPeriod (String period){
  this.period = period;
}
public void addSemester(Semester semester){
  allSemesters[semCount++] = semester;
}
// Member Methods

public void listCourses(Course course) {
    // add course to array
    coursesTaught[numCourses++] = course; 
}

public static int getSemCount() {
    return semCount;
}

public static void setSemCount(int semCount) {
    Semester.semCount = semCount;
}

//list all semesters
public String toString(){
   String str = "";
   for(Semester semester : allSemesters){
       str += semester.getPeriod() + semester.getYear() + "\n";
   }
   return str; 
}
    
}
