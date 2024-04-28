package com.mycompany.project2_assign;

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
    
     List<Faculty> facultyArray = new ArrayList<Faculty>();
     List<Course> courseArray = new ArrayList<Course>();
     List<Semester> semesterArray = new ArrayList<Semester>();
     List<Schedule> scheduleArray = new ArrayList<Schedule>();
     Course currCourse = new Course();
     Semester currSemester = new Semester();
     Faculty currFaculty = new Faculty();
     
     
     
    @Override
    public void start(Stage stage) {
        
          //TESTING BELOW: IGNORE DURING ACTUAL IMPLEMENTATION
          
          //populate courses for testing
          Course course1 = new Course("CIS", 301, "Wed/Thurs", "5:00pm",
            "6:00pm", 3, "Cloud Computing");
          Course course2 = new Course("CIS", 454, "Wed/Thurs", "2:00pm",
            "4:00pm", 4, "Systems Analysis");
          courseArray.add(course1);
          courseArray.add(course2);
          //populate semesters for testing
          Semester sem1 = new Semester("Fall", "2024");
          Semester sem2 = new Semester("Winter", "2024");
          semesterArray.add(sem1);
          semesterArray.add(sem2);
          //populate faculty
          Faculty faculty1 = new Faculty();
          Faculty faculty2 = new Faculty();
          faculty1.setFullName("Ezell");
          faculty2.setFullName("Pargas");          
          facultyArray.add(faculty1);
          facultyArray.add(faculty2);

          
          //end testing: IGNORE
          
          //Controls
          Label header = new Label("Assign faculty to a course in a particular semester : ");
          ChoiceBox dropdownCourse = new ChoiceBox(); // Create dropdown menu
          ChoiceBox dropdownSemester = new ChoiceBox(); // Create dropdown menu of members
          ChoiceBox dropdownFaculty = new ChoiceBox(); // Create dropdown menu of members
          
          //IGNORE DURING ACTUAL IMPLEMENTATION
          for (Course c : courseArray){
          dropdownCourse.getItems().add(c.getPrefix() + " " + c.getNum());
          }
          
          for (Semester s : semesterArray){
          dropdownSemester.getItems().add(s.getPeriod() + " " + s.getYear());
          }
          
          for (Faculty f : facultyArray){
          dropdownFaculty.getItems().add(f.getFullName() + " ID: " + f.getfacultyID());
          }
          //IGNORE
          
          
          Label courseLbl = new Label("Choose a course");
          Label semesterLbl = new Label("Choose a semester");
          Label facultyLbl = new Label("Choose a faculty member");

          Button assignBtn = new Button("Assign");
          
          //Pane
          GridPane primePane = new GridPane();
          primePane.add(header, 0, 0);
          primePane.add(courseLbl, 0, 1);
          primePane.add(dropdownCourse, 1, 1);
          primePane.add(semesterLbl, 0, 2);
          primePane.add(dropdownSemester, 1, 2);
          primePane.add(facultyLbl, 0, 3);
          primePane.add(dropdownFaculty, 1, 3);
          
          primePane.add(assignBtn, 1, 4);
          //label

          

          primePane.setHgap(10);
          primePane.setVgap(10);
          primePane.setAlignment(Pos.CENTER);
          
          //Scene
          Scene primeScene = new Scene(primePane, 500, 300);

          
          //Stage
          stage.setScene(primeScene);
          stage.setTitle("Assign Tab");
          stage.show();
          //Event Handle
          
          //DROPDOWN
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
          
          dropdownSemester.setOnAction(e -> {
          //code in here
          Object selection = dropdownSemester.getSelectionModel().getSelectedItem(); //grab selection
          if (selection != null){
              for (Semester s : semesterArray){
                if ((s.getPeriod() + " " + s.getYear()).equals(selection.toString())){
                currSemester = s;    
                }
                    
                
              }
          }
          });
          
          dropdownFaculty.setOnAction(e -> {
          //code in here
          Object selection = dropdownFaculty.getSelectionModel().getSelectedItem(); //grab selection
          if (selection != null){
              for (Faculty f : facultyArray){
                if ((f.getFullName() + " ID: " + f.getfacultyID()).equals(selection.toString())){
                currFaculty = f;    
                }
                    
                
              }
          }
          });
          
          assignBtn.setOnAction(e -> {
          //code in here
          Schedule schedule1 = new Schedule();
          System.out.println("Faculty: " + currFaculty.getFullName() + " Semester: " + currSemester.getPeriod() 
                  + currSemester.getYear() + " Course: " + currCourse.getPrefix() + currCourse.getNum()); //for testing
          schedule1.assignSemester(currFaculty, currSemester);
          schedule1.addCourse(currCourse);
          currSemester.assignCourses(currCourse);
          });
    }

    public static void main(String[] args) {
        launch();
    }

}
