package com.mycompany.project2_report;

import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {
    
    //DO NOT RECREATE THESE VARIABLES IN FINAL ITERATION
    List<Faculty> facultyArray = new ArrayList<Faculty>();    
    List<Student> studentArray = new ArrayList<Student>();
    List<Course> courseArray = new ArrayList<Course>();
    Course currCourse = new Course();
    List<Semester> semesterArray = new ArrayList<Semester>();
    Semester currSem = new Semester();
    List<Schedule> scheduleArray = new ArrayList<Schedule>();
    List<Enrollment> enrollArray = new ArrayList<Enrollment>();
    
    int choice = 0; //keep track of report choice
    @Override
    public void start(Stage stage) {
        
        //Testing Below: DO NOT INCLUDE SECTION IN FINAL ITERATION
        Faculty faculty1 = new Faculty();
        faculty1.setFullName("Pargas");
        Faculty faculty2 = new Faculty();
        faculty1.setFullName("Liu");
        
        
        Course course1 = new Course("CIS", 301, "Wed/Thurs", "5:00pm",
            "6:00pm", 3, "Cloud Computing");
          Course course2 = new Course("CIS", 454, "Wed/Thurs", "2:00pm",
            "4:00pm", 4, "Systems Analysis");
          courseArray.add(course1);
          courseArray.add(course2);
          
          
          Semester sem1 = new Semester("Fall", "2024");
          Semester sem2 = new Semester("Winter", "2024");
          semesterArray.add(sem1);
          semesterArray.add(sem2);
          
          
          Student stu1 = new Student();
          stu1.setFullName("Lia");
          Student stu2 = new Student();
          stu2.setFullName("Valerie");
          
          Schedule schedule1 = new Schedule();
          schedule1.assignSemester(faculty1, sem1);
          //schedule1.addCourse(course1);
          sem1.assignCourses(course1);
          sem1.assignCourses(course2);
          
          Enrollment enroll = new Enrollment(stu1,
          sem1, course1);
          enroll.setEnrollID(12);
          enrollArray.add(enroll);
          
          Enrollment enroll2 = new Enrollment(stu2,
          sem1, course1);
          enroll2.setEnrollID(13);
          enrollArray.add(enroll2);
          course1.addStudent(stu2);
          course1.addStudent(stu1);
        //End Testing
        
        //Controls
          Label header = new Label("Choose what report you want to create: ");
          Label semesterLbl = new Label("Choose a Semester");
          Label courseLbl = new Label("Choose a Course");
          Label studentLbl = new Label("Choose a Student");
          Label facultyLbl = new Label("Choose a Faculty");
          Label scheduleLbl = new Label("Choose a Schedule");
          Label enrollLbl = new Label("Choose an Enrollment Form");
          ChoiceBox dropdown = new ChoiceBox(); // Create dropdown menu
          ChoiceBox dropdownSemester = new ChoiceBox(); //for Semesters
          ChoiceBox dropdownCourse = new ChoiceBox(); //for Courses
          ChoiceBox dropdownStudent = new ChoiceBox(); //for Students
          ChoiceBox dropdownFaculty = new ChoiceBox(); //for Faculty
          ChoiceBox dropdownSchedule = new ChoiceBox(); //for Schedule
          ChoiceBox dropdownEnroll = new ChoiceBox(); //for Enroll forms
          TextArea output = new TextArea();
          Button generate = new Button("Generate Report");
          
          // all courses in a semester (needs semester)
          dropdown.getItems().add("Generate all courses in a semester"); 
          //courses taught by faculty in a semester (sched, sem, fac)
          dropdown.getItems().add("Generate all courses in a semester by a selected faculty member"); 
          //Your system must show all Courses a Student is enrolled in for a single Semester. (stu, sem, enroll)
          dropdown.getItems().add("Generate all courses in a semester for a selected student");
          //Your system must show all students enrolled in a single Course in a certain Semester (course semester)
          dropdown.getItems().add("Generate all students enrolled in a course for a selected semester"); 
          
          //YOU MAY NOT NEED TO ADD THIS BLOCK OF CODE TO FINAL ITERATION 
          //These methods should already be in the assign/faculty tab
          for (Semester s : semesterArray){
                dropdownSemester.getItems().add(s.getPeriod() + " " + s.getYear()); 

          }
          for (Course c : courseArray){
                dropdownCourse.getItems().add(c.getPrefix() + " " + c.getNum()); 

          }
          //Pane
          GridPane primePane = new GridPane();
          primePane.add(header, 0, 0);
          primePane.add(dropdown, 1, 0);
          primePane.add(semesterLbl, 0, 1);          
          primePane.add(dropdownSemester, 1, 1);
          primePane.add(dropdownCourse, 1, 2);
          primePane.add(courseLbl, 0, 2);
          primePane.add(dropdownStudent, 1, 3);
          primePane.add(studentLbl, 0, 3);
          primePane.add(dropdownFaculty, 1, 4);
          primePane.add(facultyLbl, 0, 4);
          primePane.add(dropdownSchedule, 1, 5);
          primePane.add(scheduleLbl, 0, 5);
          primePane.add(dropdownEnroll, 1, 6);
          primePane.add(enrollLbl, 0, 6);
          primePane.add(output, 0, 8);
          primePane.add(generate, 1, 8);
          
          primePane.setHgap(10);
          primePane.setVgap(10);
          
          //Scene
          Scene primeScene = new Scene(primePane, 500, 300);

          
          //Stage
          dropdownSemester.setVisible(false);
          dropdownCourse.setVisible(false);
          dropdownStudent.setVisible(false);
          dropdownFaculty.setVisible(false);
          dropdownSchedule.setVisible(false);
          dropdownEnroll.setVisible(false);
          stage.setScene(primeScene);
          stage.setTitle("Report Tab");
          stage.show();
          
          //Event Handle
          dropdown.setOnAction(e -> {
          //code in here
          Object selection = dropdown.getSelectionModel().getSelectedItem(); //grab selection
          //Reset
          dropdownSemester.setVisible(false);
          dropdownCourse.setVisible(false);
          dropdownStudent.setVisible(false);
          dropdownFaculty.setVisible(false);
          dropdownSchedule.setVisible(false);
          dropdownEnroll.setVisible(false);
          
          if(selection.toString().equals("Generate all courses in a semester")){ //sem
              dropdownSemester.setVisible(true);
              choice = 1;
              System.out.println(choice);
              
          } else if(selection.toString().equals("Generate all courses in a semester "
                  + "by a selected faculty member")){             
              dropdownSchedule.setVisible(true);
              dropdownSemester.setVisible(true);
              dropdownFaculty.setVisible(true);
              choice = 2;
              
              
          } else if(selection.toString().equals("Generate all courses in a semester "
                  + "for a selected student")){ //(stu, sem, enroll)
                dropdownStudent.setVisible(true);
                dropdownSemester.setVisible(true);
                dropdownEnroll.setVisible(true);
                choice = 3;

          } else if(selection.toString().equals("Generate all students enrolled in a course "
                  + "for a selected semester")){
              dropdownSemester.setVisible(true);
              dropdownCourse.setVisible(true);
              choice = 4;
              System.out.println(choice);
          }
          
          });
          
          dropdownSemester.setOnAction(e -> {
          //code in here
          Object selection = dropdownSemester.getSelectionModel().getSelectedItem(); //grab selection
          //dropdownSemester
          for (Semester s : semesterArray){
                  if((s.getPeriod() + " " + s.getYear()).equals(selection.toString())){
                    currSem = s;                 
                    System.out.println(currSem.getPeriod() + " " + currSem.getYear());
                    
                  }
              }
           });
          
          dropdownCourse.setOnAction(e -> {
          //code in here
          Object selection = dropdownCourse.getSelectionModel().getSelectedItem(); //grab selection
          if (selection != null){
              for (Course c : courseArray){
                if ((c.getPrefix() + " " + c.getNum()).equals(selection.toString())){
                currCourse = c; 
                
                }
                    
                
              }
          }
          });
          
          //Generate button
          generate.setOnAction(e -> {
              System.out.println(currSem.getPeriod() + " " + currCourse.getPrefix());
              switch(choice){
                  case 1:
                    //code in here
                    if(currSem != null){
                    output.setText(currSem.listAssignedCourses()); //test
                    
                    
                    } else{
                        output.setText("");
                    } 

                    break;
                  case 4:
                      
                    for (Enrollment form : enrollArray){
                        if (form.getSemester() == currSem && 
                        form.getCourse().equals(currCourse)){
                            for (Course course : courseArray) {
                                for (int i = 0; i < course.assignedStudents.size(); i++){
                                    output.setText(course.assignedStudents.get(i).getFullName() + "\n");
                        }
                    
                    break;
                    }
                }
            }
                         
              }
          
              
            choice = 0;
            currSem = null;
            currCourse = null;
            dropdownSemester.setValue(null);
            dropdownCourse.setValue(null);
          });
          
          
    }

    public static void main(String[] args) {
        launch();
    }

    
}
