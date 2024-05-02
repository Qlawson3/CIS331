package com.mycompany.project2_integrated;

import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.event.*;
import javafx.geometry.*;
import java.util.*;

//for database
import java.sql.*;
import oracle.jdbc.pool.*;
import oracle.jdbc.*;
import java.util.*;


/**
 * JavaFX App
 */
public class App extends Application {
    
    // Declare Class Level Data Fields
        //for database
    public static OracleDataSource oDS;
    public static Connection jsqlConn;
    public static PreparedStatement jsqlStmt;
    public static ResultSet jsqlResults;
    
        // for Student
        TextField txtStudName;
        TextField txtStudID;
        TextField txtSSN;
        TextField txtHomeAddress;
        TextField txtEmail;
        TextField txtGPA;
        TextField txtEmergName;
        TextField txtEmergEmail;
        TextField txtEmergPhone;
        Label lblStudName;
        Label lblStudID;
        Label lblSSN;
        Label lblHomeAddress;
        Label lblEmail;
        Label lblGPA;
        Label lblEmergName;
        Label lblEmergEmail;
        Label lblEmergPhone;
        
        TextArea txtaStudent;
        
        // for Semester
        TextField txtPeriod;
        TextField txtYear;
        Label lblPeriod;
        Label lblYear;
        
        TextArea txtaSem;
        
        // for Course
        Label lblCoursePrefix;
        TextField txtCoursePrefix;
        Label lblCourseNum;
        TextField txtCourseNum;
        Label lblCourseName;
        TextField txtCourseName;
        Label lblCourseDays;
        TextField txtCourseDays;
        Label lblStartTime;
        TextField txtStartTime;
        Label lblEndTime;
        TextField txtEndTime;
        Label lblCreditHours;
        TextField txtCreditHours;
//      Label lblCourseInst;
//      TextField txtCourseInst;
        TextArea txtaCourse;
        
        // for Faculty
        TextField txtFacID;
        TextField txtFacName;
        TextField txtFEmail;
        TextField txtBuilding;
        TextField txtOffice;
        TextField txtFacPhone;
        TextField txtDept;
        TextField txtPosition;
        
        Label lblFacID;
        Label lblFacName;
        Label lblFEmail;
        Label lblBuilding;
        Label lblOffice;
        Label lblFacPhone;
        Label lblDept;
        Label lblPosition;
        
        TextArea txtaFaculty;
        
        // for Enroll
        Label lblEnrollID;
        Label lblSelectStud;
        Label lblSelectSem;
        Label lblSelectCrs;
        
        TextField txtEnrollID;
        
        TextArea txtaEnroll;
        
        // titles of window kind of
        Label lblEntryStud;
        Label lblEntrySem;
        Label lblEntryCourse;
        Label lblEntryEnroll;
        Label lblEntryFaculty;
        Label lblEntryAssign;
        
        // drop down for create or edit
        ChoiceBox studDropDown;
        ChoiceBox semDropDown;
        ChoiceBox crsDropDown;
        ChoiceBox facDropDown;
        
        
        // buttons to save 
        Button btnSaveStud;
        Button btnSaveSem;
        Button btnSaveCourse;
        Button btnEnroll;
        Button btnSaveFac;
        
        // for Editing
        ComboBox cmboEditStud;
        ComboBox cmboEditSem;
        ComboBox cmboEditCourse;
        ComboBox cmboEditFac;
        
        // comboBoxes for enroll
        ComboBox cmboEnrollStud;
        ComboBox cmboEnrollSem;
        ComboBox cmboEnrollCrs;
        
        // for assign faculty
        ComboBox cmboAssignCrs;
        ComboBox cmboAssignFac;
        ComboBox cmboAssignSem;
        
        TextArea txtaAssign;
        
        Button assignBtn;
        
        // identify selected objects
        Course currCourse = new Course();
        Semester currSemester = new Semester();
        Faculty currFaculty = new Faculty();
        Schedule currSchedule = new Schedule();
        Student currStudent = new Student();
        Enrollment currEnroll = new Enrollment();
        
        
        // lists to store object creations
        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Course> courses = new ArrayList<>();
        ArrayList<Faculty> facultyList = new ArrayList<>();
        ArrayList<Semester> semesters = new ArrayList<>();
        ArrayList<Enrollment> enrollments = new ArrayList<>();
        ArrayList<Schedule> schedules = new ArrayList<>();
        
        //testers
        Course c1 = new Course("CIS", 331, "Tues/Thurs", "3:55pm", "5:10pm", 3, "Java");
        Semester s1 = new Semester("Fall", "2024");
        Student stud1 = new Student("Lia Hill", 113479508, 11223344, "123 Address Ln", "liahill.com",
                4.6, "Cathy Mercil", "cmercil.com", "703-483-3849");
        
        
        int choice = 0; //keep track of report choice

    
        
       

    @Override
    public void start(Stage stage) {
        
        // Instantiate the above data fields within the start() method
        
        btnSaveStud = new Button("Save ->");
        btnSaveSem = new Button("Save ->");
        btnSaveCourse = new Button("Save ->");
        btnEnroll = new Button("Enroll ->");
        btnSaveFac = new Button("Save ->");
        assignBtn = new Button("Assign ->");
        
        cmboEditStud = new ComboBox();
        cmboEditSem = new ComboBox();
        cmboEditCourse = new ComboBox();
        cmboEnrollStud = new ComboBox();
        cmboEnrollSem = new ComboBox();
        cmboEnrollCrs = new ComboBox();
        cmboEditFac = new ComboBox();
        
        
        cmboAssignCrs = new ComboBox();
        cmboAssignFac = new ComboBox();
        cmboAssignSem = new ComboBox();
        
        //testers
        cmboEnrollCrs.getItems().add(c1.getPrefix() + c1.getNum());
        cmboEnrollSem.getItems().add(s1.getPeriod() + s1.getYear());
        cmboEnrollStud.getItems().add(stud1.getFullName());
        
        courses.add(c1);
        students.add(stud1);
        semesters.add(s1);
        
        studDropDown = new ChoiceBox();
        studDropDown.getItems().add("Create Student");
        studDropDown.getItems().add("Edit Student");
        
        semDropDown = new ChoiceBox();
        semDropDown.getItems().add("Create Semester");
        semDropDown.getItems().add("Edit Semester");
        
        crsDropDown = new ChoiceBox();
        crsDropDown.getItems().add("Create Course");
        crsDropDown.getItems().add("Edit Course");
        
        facDropDown = new ChoiceBox();
        facDropDown.getItems().add("Create Faculty");
        facDropDown.getItems().add("Edit Faculty");
        
        lblStudName = new Label("First and Last Name");
        lblStudID = new Label("Student ID");
        lblSSN = new Label("Social Security Number");
        lblHomeAddress = new Label("Home Address");
        lblEmail = new Label("Email Address");
        lblGPA = new Label("GPA");
        lblEmergName = new Label("Emergency Contact Name");
        lblEmergEmail = new Label("Emergency Contact Email Address");
        lblEmergPhone = new Label("Emergency Contact Phone");
        
        txtStudName = new TextField();
        txtStudID = new TextField();
        txtSSN = new TextField();
        txtHomeAddress = new TextField();
        txtEmail = new TextField();
        txtGPA = new TextField();
        txtEmergName = new TextField();
        txtEmergEmail = new TextField();
        txtEmergPhone = new TextField();
        
        txtaStudent = new TextArea();
        
        lblPeriod = new Label("Period (Fall, Spring, etc)");
        lblYear = new Label("Year (YYYY)");
        
        txtPeriod = new TextField();
        txtYear = new TextField();
        
        txtaSem = new TextArea();
        
        lblCoursePrefix = new Label("Course Prefix");
        lblCourseNum = new Label("Course Number");
        lblCourseName = new Label("Course Name");
        lblCourseDays = new Label("Course Days");
        lblStartTime = new Label("Start Time");
        lblEndTime = new Label("End Time");
        lblCreditHours = new Label("Credit Hours");
        //lblCourseInst = new Label("Course Instructor");
        
        txtCoursePrefix = new TextField();
        txtCourseNum = new TextField();
        txtCourseName = new TextField();
        txtCourseDays = new TextField();
        txtStartTime = new TextField();
        txtEndTime = new TextField();
        txtCreditHours = new TextField();
        //txtCourseInst = new TextField();
        
        txtaCourse = new TextArea();
        
        lblFacID = new Label("Faculty ID");
        lblFacName = new Label("First and Last Name");
        lblFEmail = new Label("Email");
        lblBuilding = new Label("Building Name");
        lblOffice= new Label("Office Number");
        lblFacPhone = new Label("Phone Number");
        lblDept = new Label("Department Name");
        lblPosition = new Label("Position");
        
        txtFacID = new TextField();
        txtFacName = new TextField();
        txtFEmail = new TextField();
        txtBuilding = new TextField();
        txtOffice = new TextField();
        txtFacPhone = new TextField();
        txtDept = new TextField();
        txtPosition = new TextField();
        
        txtaFaculty = new TextArea();
        
        
        lblEnrollID = new Label("Enter an Enrollment ID");
        lblSelectStud = new Label("Select a Student");
        lblSelectSem = new Label("Select a Semester");
        lblSelectCrs = new Label("Select a Course");
        
        txtEnrollID = new TextField();
        
        txtaEnroll = new TextArea();
        
        txtaAssign = new TextArea();
        
        lblEntryStud = new Label("Manage Students");
        lblEntrySem = new Label("Manage Semesters");
        lblEntryCourse = new Label("Manage Courses");
        lblEntryEnroll = new Label("Enroll a Student");
        lblEntryFaculty = new Label("Manage Faculty");
        lblEntryAssign = new Label("Assign Faculty to Courses");

        Label courseLbl = new Label("Choose a course");
        Label semesterLbl = new Label("Choose a semester");
        Label facultyLbl = new Label("Choose a faculty member");
          
        //FOR REPORT
         //Controls
          Label header = new Label("Choose what report you want to create: ");
          Label semesterLblReport = new Label("Choose a Semester");
          Label courseLblReport = new Label("Choose a Course");
          Label studentLbl = new Label("Choose a Student");
          Label facultyLblReport = new Label("Choose a Faculty");
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
       
        // for Tabs
        VBox overallVPane = new VBox();
        TabPane tPane = new TabPane();
        Tab tbStudent = new Tab("Student");
        Tab tbFaculty = new Tab("Faculty");
        Tab tbSemester = new Tab("Semester");
        Tab tbCourse = new Tab("Course");
        Tab tbEnroll = new Tab("Enroll a Student");
        Tab tbAssign = new Tab("Assign Faculty to Course");
        Tab tbReport = new Tab("Generate Reports");
        
        
        // add Menu elements
        MenuBar mbarMenu = new MenuBar();
        Menu mApp = new Menu("App");
        MenuItem miQuit = new MenuItem("Quit App");
        
        // create Pane for tabs
        GridPane gStudPane = new GridPane();
        GridPane gFacultyPane = new GridPane();
        GridPane gSemPane = new GridPane();
        GridPane gCoursePane = new GridPane();
        GridPane gEnrollPane = new GridPane();
        GridPane gAssignPane = new GridPane();
        
        GridPane gReportPane = new GridPane();
        gReportPane.add(header, 0, 0);
        gReportPane.add(dropdown, 1, 0);
        gReportPane.add(semesterLblReport, 0, 1);          
        gReportPane.add(dropdownSemester, 1, 1);
        gReportPane.add(dropdownCourse, 1, 2);
        gReportPane.add(courseLblReport, 0, 2);
        gReportPane.add(dropdownStudent, 1, 3);
        gReportPane.add(studentLbl, 0, 3);
        gReportPane.add(dropdownFaculty, 1, 4);
        gReportPane.add(facultyLblReport, 0, 4);
        gReportPane.add(dropdownSchedule, 1, 5);
        gReportPane.add(scheduleLbl, 0, 5);
        gReportPane.add(dropdownEnroll, 1, 6);
        gReportPane.add(enrollLbl, 0, 6);
        gReportPane.add(output, 0, 8);
        gReportPane.add(generate, 1, 8);
        
        // prompt getting of inforrmation
        txtStudName.setPromptText("First and Last Name");
        txtStudID.setPromptText("Student ID");
        txtSSN.setPromptText("Social Security Number");
        txtHomeAddress.setPromptText("Home Address");
        txtEmail.setPromptText("Email Address");
        txtGPA.setPromptText("GPA");
        txtEmergName.setPromptText("Emergency Contact Name");
        txtEmergEmail.setPromptText("Emergency Contact Email Address");
        txtEmergPhone.setPromptText("Emergency Contact Phone Number");
        
        txtPeriod.setPromptText("Period (Fall, Spring, etc)");
        txtYear.setPromptText("Year (YYYY)");
        
        txtCoursePrefix.setPromptText("Course Prefix");
        txtCourseNum.setPromptText("Course Number");
        txtCourseName.setPromptText("Course Name");
        txtCourseDays.setPromptText("Course Days");
        txtStartTime.setPromptText("Start Time");
        txtEndTime.setPromptText("End Time");
        txtCreditHours.setPromptText("Credit Hours");
       // txtCourseInst.setPromptText("Course Instructor: ");
       
       txtFacID.setPromptText("Faculty ID");
       txtFacName.setPromptText("First and Last Name");
       txtFEmail.setPromptText("Email Address");
       txtBuilding.setPromptText("Building Name");
       txtOffice.setPromptText("Office Number");
       txtFacPhone.setPromptText("Phone Number");
       txtDept.setPromptText("Department");
       txtPosition.setPromptText("Position");
       
        
        // have text go to next line if necessary
        lblEntryStud.setWrapText(true);
        lblEntrySem.setWrapText(true);
        lblEntryCourse.setWrapText(true);
        lblEntryEnroll.setWrapText(true);
        lblEntryFaculty.setWrapText(true);
        
        txtEnrollID.setPromptText("Enrollment ID");
        
        // add the titles to the appropriate tab 
        gStudPane.add(lblEntryStud, 0, 0);
        gFacultyPane.add(lblEntryFaculty, 0, 0);
        gSemPane.add(lblEntrySem, 0, 0);
        gCoursePane.add(lblEntryCourse, 0, 0);
        gEnrollPane.add(lblEntryEnroll, 0, 0);
        gAssignPane.add(lblEntryAssign, 0, 0);
        
        // arrange the comboBox and checkBox on one horizontal line
        
        // Student Tab 
        HBox hStudPane = new HBox();
        hStudPane.getChildren().addAll(studDropDown, cmboEditStud);
        // add to student tab 
        gStudPane.add(hStudPane, 2, 1);
        
        // establish everything disabled
        cmboEditStud.setDisable(true);
        cmboEditStud.setVisible(false);
        
        txtStudName.setDisable(true);
        txtStudID.setDisable(true);
        txtSSN.setDisable(true);
        txtHomeAddress.setDisable(true);
        txtEmail.setDisable(true);
        txtGPA.setDisable(true);
        txtEmergName.setDisable(true);
        txtEmergEmail.setDisable(true);
        txtEmergPhone.setDisable(true);
        
        // set on action to enable
        studDropDown.setOnAction(e -> {
            String selectedOption = (String)studDropDown.getValue();
            if (selectedOption.equals("Edit Student")) {
                cmboEditStud.setDisable(false);
                cmboEditStud.setVisible(true);
                
                enableStudentFields();
                
                // clear previous items
                cmboEditStud.getItems().clear();
                
                // repopulate the dropdown
                for(Student s : students) {
                    cmboEditStud.getItems().add(s.getFullName());
                }

                    
                cmboEditStud.setOnAction(event -> {

                       String selectStud = (String)cmboEditStud.getValue();

                       for(Student s : students) {
                        if(selectStud.equals(s.getFullName()))
                        {
                            txtStudName.setText(s.getFullName());
                            txtStudID.setText(String.valueOf(s.getID()));
                            txtSSN.setText(String.valueOf(s.getSSN()));
                            txtEmail.setText(s.getEmail());
                            txtHomeAddress.setText(s.getAddress());
                            txtGPA.setText(String.valueOf(s.getGPA()));
                            txtEmergName.setText(s.getEmergencyName());
                            txtEmergEmail.setText(s.getEmergencyEmail());
                            txtEmergPhone.setText(s.getEmergencyPhone());
                        }
                       }
                        
                    });
                
                clearStudentFields();
                
            }
            else if(selectedOption.equals("Create Student")) 
            {
                cmboEditStud.setDisable(true);
                cmboEditStud.setVisible(false);
                enableStudentFields();
            }
            else if (!selectedOption.equals("Edit Student"))
            {
                txtStudName.setDisable(true);
                txtStudID.setDisable(true);
                txtSSN.setDisable(true);
                txtHomeAddress.setDisable(true);
                txtEmail.setDisable(true);
                txtGPA.setDisable(true);
                txtEmergName.setDisable(true);
                txtEmergEmail.setDisable(true);
                txtEmergPhone.setDisable(true);
            }
            
            clearStudentFields();
            
        });
        
        // Faculty Tab
        HBox hFacPane = new HBox();
        hFacPane.getChildren().addAll(facDropDown, cmboEditFac);
        // add to faculty tab
        gFacultyPane.add(hFacPane, 2, 1);
        
        // set everything as disabled
        cmboEditFac.setDisable(true);
        cmboEditFac.setVisible(false);
        
        txtFacID.setDisable(true);
        txtFacName.setDisable(true);
        txtFEmail.setDisable(true);
        txtBuilding.setDisable(true);
        txtOffice.setDisable(true);
        txtFacPhone.setDisable(true);
        txtDept.setDisable(true);
        txtPosition.setDisable(true);
        
        facDropDown.setOnAction(e -> {
            String selectedOption = (String)facDropDown.getValue();
            if(selectedOption.equals("Edit Faculty"))
            {
                cmboEditFac.setDisable(false);
                cmboEditFac.setVisible(true);
                enableFacultyFields();
                
                // clear previous items
                cmboEditSem.getItems().clear();
                
                // repopulate
                for(Faculty f : facultyList)
                {
                    cmboEditSem.getItems().add(f.getFullName());
                }
                
                cmboEditFac.setOnAction(event -> {
                    String selectFac = (String)cmboEditFac.getValue();
                    
                    for (Faculty f : facultyList)
                    {
                        if(f.getFullName().equals(selectFac))
                        {
                            txtFacID.setText(String.valueOf(f.getfacultyID()));
                            txtFacName.setText(f.getFullName());
                            txtFEmail.setText(f.getEmail());
                            txtBuilding.setText(f.getBuilding());
                            txtOffice.setText(String.valueOf(f.getOfficeNum()));
                            txtFacPhone.setText(f.getPhoneNum());
                            txtDept.setText(f.getDept());
                            txtPosition.setText(f.getPosition());
                        }
                    }
                });
                
                clearFacultyFields();
            }
            else if(selectedOption.equals("Create Faculty"))
            {
                cmboEditFac.setDisable(true);
                cmboEditFac.setVisible(false);
                enableFacultyFields();
            }
            else if (!selectedOption.equals("Edit Student"))
            {
                txtFacID.setDisable(true);
                txtFacName.setDisable(true);
                txtFEmail.setDisable(true);
                txtBuilding.setDisable(true);
                txtOffice.setDisable(true);
                txtFacPhone.setDisable(true);
                txtDept.setDisable(true);
                txtPosition.setDisable(true);
            }
            
            clearFacultyFields();
        });
        
        
        // Semester Tab 
        HBox hSemPane = new HBox();
        hSemPane.getChildren().addAll(semDropDown, cmboEditSem);
        // add to semester tab 
        gSemPane.add(hSemPane, 2, 1);
        
        // set everything as disabled
        cmboEditSem.setDisable(true);
        cmboEditSem.setVisible(false);
        
        txtPeriod.setDisable(true);
        txtYear.setDisable(true);
        
        // FOR REPORT
         // all courses in a semester (needs semester)
          dropdown.getItems().add("Generate all courses in a semester"); 
          //courses taught by faculty in a semester (sched, sem, fac)
          dropdown.getItems().add("Generate all courses in a semester by a selected faculty member"); 
          //Your system must show all Courses a Student is enrolled in for a single Semester. (stu, sem, enroll)
          dropdown.getItems().add("Generate all courses in a semester for a selected student");
          //Your system must show all students enrolled in a single Course in a certain Semester (course semester)
          dropdown.getItems().add("Generate all students enrolled in a course for a selected semester"); 
           for (Semester s : semesters){
                dropdownSemester.getItems().add(s.getPeriod() + s.getYear()); 

          }
          for (Course c : courses){
                dropdownCourse.getItems().add(c.getPrefix() + c.getNum()); 

          }
          for (Student s : students){
                dropdownStudent.getItems().add(s.getFullName()); 

          }
          for (Faculty f : facultyList){
                dropdownFaculty.getItems().add(f.getFullName()); 

          }
          for (Schedule sched : schedules){
                dropdownSchedule.getItems().add(sched.getScheduleID()); 

          }
          for (Enrollment enroll : enrollments){
                dropdownEnroll.getItems().add(enroll.getEnrollID()); 

          }
          //button actions
          semDropDown.setOnAction(e -> {
            String selectedOption = (String)semDropDown.getValue();
            if (selectedOption.equals("Edit Semester"))
                    {
                       cmboEditSem.setDisable(false);
                       cmboEditSem.setVisible(true);
                       enableSemesterFields();
                       
                       // clear previous items
                       cmboEditSem.getItems().clear();
                       
                       // repopulate dropdown
                       for (Semester s : semesters) {
                           cmboEditSem.getItems().add(s.getPeriod() + s.getYear());
                       }
                       
                       cmboEditSem.setOnAction(event -> {
                           String selectSem = (String)cmboEditSem.getValue();
                           
                           for (Semester s : semesters)
                           {
                               if(selectSem.equals(s.getPeriod() + s.getYear()))
                               {
                                   txtPeriod.setText(s.getPeriod());
                                   txtYear.setText(s.getYear());
                               }
                           }
                       });
                       
                       clearSemesterFields();
                    }
            else if(selectedOption.equals("Create Semester"))
            {
                cmboEditSem.setDisable(true);
                cmboEditSem.setVisible(false);
                enableSemesterFields();
            }
            else
            {
                cmboEditSem.setDisable(true);
                cmboEditSem.setVisible(false);
                txtPeriod.setDisable(true);
                txtYear.setDisable(true);
            }
        });
        
        // Course tab
        HBox hCrsPane = new HBox();
        hCrsPane.getChildren().addAll(crsDropDown, cmboEditCourse);
        // add to course tab
        gCoursePane.add(hCrsPane, 2, 1);
        
        cmboEditCourse.setDisable(true);
        cmboEditCourse.setVisible(false);
        
        // disable all textfields until a choice is picked
        txtCoursePrefix.setDisable(true);
        txtCourseNum.setDisable(true);
        txtCourseName.setDisable(true);
        txtCourseDays.setDisable(true);
        txtStartTime.setDisable(true);
        txtEndTime.setDisable(true);
        txtCreditHours.setDisable(true);
   //   txtCourseInst.setDisable(true);
        
        crsDropDown.setOnAction(e -> {
            String selectOption = (String)crsDropDown.getValue();
            if(selectOption.equals("Edit Course"))
            {
                cmboEditCourse.setDisable(false);
                cmboEditCourse.setVisible(true);
                
                // clear previous items
                cmboEditCourse.getItems().clear();
                
                // repopulate
                for(Course c : courses)
                {
                    cmboEditCourse.getItems().add(c.getPrefix() + c.getNum());
                }
                
                cmboEditCourse.setOnAction(event -> {
                    String selectedOption = (String)cmboEditCourse.getValue();
                    
                    for (Course c : courses)
                    {
                        if(selectedOption.trim().equals(c.getPrefix() + c.getNum()))
                        {
                            txtCoursePrefix.setText(c.getPrefix());
                            txtCourseNum.setText(String.valueOf(c.getNum()));
                            txtCourseName.setText(c.getName());
                            txtCourseDays.setText(c.getDaysTaught());
                            txtStartTime.setText(c.getStartTime());
                            txtEndTime.setText(c.getEndTime());
                            txtCreditHours.setText(String.valueOf(c.getCredits()));
                            // course instructor???
                        }
                    }
                });
                clearCourseFields();
            }
            else if(selectOption.equals("Create Course"))
            {
                cmboEditCourse.setDisable(true);
                cmboEditCourse.setVisible(false);
                enableCourseFields();
            }
            else
            {
                cmboEditCourse.setDisable(true);
                cmboEditCourse.setVisible(false);
                txtCoursePrefix.setDisable(true);
                txtCourseNum.setDisable(true);
                txtCourseName.setDisable(true);
                txtCourseDays.setDisable(true);
                txtStartTime.setDisable(true);
                txtEndTime.setDisable(true);
                txtCreditHours.setDisable(true);
           //   txtCourseInst.setDisable(true);
            }
        });
        
        // Enroll tab - student
        HBox hEnrollStudPane = new HBox();
        hEnrollStudPane.getChildren().add(cmboEnrollStud);
        // arrange on main grid pane
        gEnrollPane.add(hEnrollStudPane, 3, 2);
        
        // Enroll tab - semester
        HBox hEnrollSemPane = new HBox();
        hEnrollSemPane.getChildren().add(cmboEnrollSem);
        // arrange on main grid pane
        gEnrollPane.add(hEnrollSemPane, 3, 5);
        
        // Enroll tab - course
        HBox hEnrollCrsPane = new HBox();
        hEnrollCrsPane.getChildren().add(cmboEnrollCrs);
        // arrange on main grid pane
        gEnrollPane.add(hEnrollCrsPane, 3, 8);
        
        // Assign tab - course
        HBox hAssignCrs = new HBox();
        hAssignCrs.getChildren().add(cmboAssignCrs);
        // arrange on main grid pane
        gAssignPane.add(hAssignCrs, 3, 2);
        
        // Assign tab - semester
        HBox hAssignSem = new HBox();
        hAssignSem.getChildren().add(cmboAssignSem);
        gAssignPane.add(hAssignSem, 3, 5);
        
        // Assign tab - faculty
        HBox hAssignFac = new HBox();
        hAssignFac.getChildren().add(cmboAssignFac);
        gAssignPane.add(hAssignFac, 3, 8);
        
         //DROPDOWN
          cmboAssignCrs.setOnAction(e -> {
          //code in here
          Object selection = cmboAssignCrs.getSelectionModel().getSelectedItem(); //grab selection
          if (selection != null){
              for (Course c : courses){
                if ((c.getPrefix() + c.getNum()).equals(selection.toString())){
                currCourse = c;   
                System.out.println(currCourse.getName());
                }
                
              }
          }
          });
          
          cmboAssignSem.setOnAction(e -> {
          //code in here
          Object selection = cmboAssignSem.getSelectionModel().getSelectedItem(); //grab selection
          if (selection != null){
              for (Semester s : semesters){
                if ((s.getPeriod() + s.getYear()).equals(selection.toString())){
                currSemester = s;    
                }
                    
                
              }
          }
          });
          
          cmboAssignFac.setOnAction(e -> {
          //code in here
          Object selection = cmboAssignFac.getSelectionModel().getSelectedItem(); //grab selection
          if (selection != null){
              for (Faculty f : facultyList){
                if ((f.getFullName() + " ID: " + f.getfacultyID()).equals(selection.toString())){
                currFaculty = f;    
                }
                    
                
              }
          }
          });
     
        
        
        
        // add menu to overall pane
        overallVPane.getChildren().add(mbarMenu);
        
        // position everything
        gStudPane.add(lblStudName, 0, 1);
        gStudPane.add(txtStudName, 1, 1);
        gStudPane.add(lblStudID, 0, 2);
        gStudPane.add(txtStudID, 1, 2);
        gStudPane.add(lblSSN, 0, 3);
        gStudPane.add(txtSSN, 1, 3);
        gStudPane.add(lblHomeAddress, 0, 4);
        gStudPane.add(txtHomeAddress, 1, 4);
        gStudPane.add(lblEmail, 0, 5);
        gStudPane.add(txtEmail, 1, 5);
        gStudPane.add(lblGPA, 0, 6);
        gStudPane.add(txtGPA, 1, 6);
        gStudPane.add(lblEmergName, 0, 7);
        gStudPane.add(txtEmergName, 1, 7);
        gStudPane.add(lblEmergEmail, 0, 8);
        gStudPane.add(txtEmergEmail, 1, 8);
        gStudPane.add(lblEmergPhone, 0, 9);
        gStudPane.add(txtEmergPhone, 1, 9);
        gStudPane.add(txtaStudent, 1, 11, 6, 3);
        
        gFacultyPane.add(txtFacID, 0, 1);
        gFacultyPane.add(lblFacID, 1, 1);
        gFacultyPane.add(txtFacName, 0, 2);
        gFacultyPane.add(lblFacName, 1, 2);
        gFacultyPane.add(txtFEmail, 0, 3);
        gFacultyPane.add(lblFEmail, 1, 3);
        gFacultyPane.add(txtBuilding, 0, 4);
        gFacultyPane.add(lblBuilding, 1, 4);
        gFacultyPane.add(txtOffice, 0, 5);
        gFacultyPane.add(lblOffice, 1, 5);
        gFacultyPane.add(txtFacPhone, 0, 6);
        gFacultyPane.add(lblFacPhone, 1, 6);
        gFacultyPane.add(txtDept, 0, 7);
        gFacultyPane.add(lblDept, 1, 7);
        gFacultyPane.add(txtPosition, 0, 8);
        gFacultyPane.add(lblPosition, 1, 8);
        gFacultyPane.add(txtaFaculty, 1, 10, 6, 3);
        
        
        gSemPane.add(lblPeriod, 0, 1);
        gSemPane.add(txtPeriod, 1, 1);
        gSemPane.add(lblYear, 0, 2);
        gSemPane.add(txtYear, 1, 2);
        gSemPane.add(txtaSem, 1, 4, 2, 3);
        
        gCoursePane.add(lblCoursePrefix, 0, 1);
        gCoursePane.add(txtCoursePrefix, 1, 1);
        gCoursePane.add(lblCourseNum, 0, 2);
        gCoursePane.add(txtCourseNum, 1, 2);
        gCoursePane.add(lblCourseName, 0, 3);
        gCoursePane.add(txtCourseName, 1, 3);
        gCoursePane.add(lblCourseDays, 0, 4);
        gCoursePane.add(txtCourseDays, 1, 4);
        gCoursePane.add(lblStartTime, 0, 5);
        gCoursePane.add(txtStartTime, 1, 5);
        gCoursePane.add(lblEndTime, 0, 6);
        gCoursePane.add(txtEndTime, 1, 6);
        gCoursePane.add(lblCreditHours, 0, 7);
        gCoursePane.add(txtCreditHours, 1, 7);
        // gCoursePane.add(lblCourseInst, 0, 8);
        // gCoursePane.add(txtCourseInst, 1, 8);
        gCoursePane.add(txtaCourse, 1, 10, 4, 3);
        
        gEnrollPane.add(lblEnrollID, 0, 1);
        gEnrollPane.add(txtEnrollID, 1, 1);
        gEnrollPane.add(lblSelectStud, 0, 2);
        gEnrollPane.add(lblSelectSem, 0, 5);
        gEnrollPane.add(lblSelectCrs, 0, 8);
        gEnrollPane.add(txtaEnroll, 1, 10, 4, 1);
        
        gAssignPane.add(courseLbl, 0, 2);
        gAssignPane.add(semesterLbl, 0, 5);
        gAssignPane.add(facultyLbl, 0, 8);
        gAssignPane.add(txtaAssign, 1, 10, 4, 1);

        
        // add quit option to app menu 
        mApp.getItems().add(miQuit);
        mbarMenu.getMenus().addAll(mApp);
        
        // set save button to its own anchorPane/layout container
        AnchorPane aStudPane = new AnchorPane();
        aStudPane.getChildren().add(btnSaveStud);
        
        AnchorPane aFacPane = new AnchorPane();
        aFacPane.getChildren().add(btnSaveFac);
        
        AnchorPane aSemPane = new AnchorPane();
        aSemPane.getChildren().add(btnSaveSem);
        
        AnchorPane aCrsPane = new AnchorPane();
        aCrsPane.getChildren().add(btnSaveCourse);
        
        AnchorPane aEnrollPane = new AnchorPane();
        aEnrollPane.getChildren().add(btnEnroll);
        
        AnchorPane aAssignPane = new AnchorPane();
        aAssignPane.getChildren().add(assignBtn);
        
       
        
        // add to grids
        gStudPane.add(aStudPane, 1, 10);
        gFacultyPane.add(aFacPane, 1, 9);
        gSemPane.add(aSemPane, 1, 3);
        gCoursePane.add(aCrsPane, 1, 9);
        gEnrollPane.add(aEnrollPane, 1, 9);
        gAssignPane.add(aAssignPane, 1, 9);
        
        // position the window and where it will pop up
        gStudPane.setAlignment(Pos.CENTER);
        gFacultyPane.setAlignment(Pos.CENTER);
        gSemPane.setAlignment(Pos.CENTER);
        gCoursePane.setAlignment(Pos.CENTER);
        gEnrollPane.setAlignment(Pos.CENTER);
        gAssignPane.setAlignment(Pos.CENTER);
        
        gStudPane.setHgap(15);
        gStudPane.setVgap(15);
        
        gFacultyPane.setHgap(15);
        gFacultyPane.setVgap(15);
        
        gSemPane.setHgap(15);
        gSemPane.setVgap(15);
        
        gCoursePane.setHgap(15);
        gCoursePane.setVgap(15);
        
        gEnrollPane.setHgap(15);
        gEnrollPane.setVgap(15);
        
        gAssignPane.setHgap(15);
        gAssignPane.setVgap(15);
        
        // add built gridPane to tab
        tbStudent.setContent(gStudPane);
        tbFaculty.setContent(gFacultyPane);
        tbSemester.setContent(gSemPane);
        tbCourse.setContent(gCoursePane);
        tbEnroll.setContent(gEnrollPane);
        tbAssign.setContent(gAssignPane);
        tbReport.setContent(gReportPane);
        
        // padding??? idk
        gStudPane.setPadding(new Insets(20, 0, 0, 0));
        gFacultyPane.setPadding(new Insets(20, 0, 0, 0));
        gSemPane.setPadding(new Insets(20, 0 , 0 ,0));
        gCoursePane.setPadding(new Insets(20, 0, 0, 0));
        gEnrollPane.setPadding(new Insets(20, 0, 0, 0));
        gAssignPane.setPadding(new Insets(20, 0, 0, 0));
        
        // add both tabs to tab pane
        tPane.getTabs().addAll(tbStudent, tbFaculty, tbSemester, tbCourse, tbEnroll, tbAssign, tbReport);
        
        // add tab pane to VBox (overall pane)
        overallVPane.getChildren().add(tPane);
        
        
        // format textAreas
        txtaStudent.setMaxWidth(400);
        txtaStudent.setMinWidth(400);
        
        txtaFaculty.setMaxWidth(400);
        txtaFaculty.setMinWidth(400);
        
        txtaSem.setMaxWidth(400);
        txtaSem.setMinWidth(400);
        
        txtaCourse.setMaxWidth(400);
        txtaCourse.setMinWidth(400);
        
        txtaEnroll.setMaxWidth(400);
        txtaEnroll.setMinWidth(400);
        
        txtaAssign.setMaxWidth(400);
        txtaAssign.setMinWidth(400);
        
        
        
        // so that format specifiers work in textAreas
        txtaStudent.setStyle("-fx-font-family: monospace");
        txtaFaculty.setStyle("-fx-font-family: monospace");
        txtaSem.setStyle("-fx-font-family: monospace");
        txtaCourse.setStyle("-fx-font-family: monospace");
        txtaEnroll.setStyle("-fx-font-family: monospace");
        txtaAssign.setStyle("-fx-font-family: monospace");
        
        // FOR REPORT
        dropdownSemester.setVisible(false);
        dropdownCourse.setVisible(false);
        dropdownStudent.setVisible(false);
        dropdownFaculty.setVisible(false);
        dropdownSchedule.setVisible(false);
        dropdownEnroll.setVisible(false);
        
        // set everything up on the main window!
        Scene primaryScene = new Scene(overallVPane, 700, 750);
        stage.setScene(primaryScene);
        stage.setTitle("University Management");
        stage.show();
        
        //EVENT HANDLING
        
        // FOR REPORT
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
          for (Semester s : semesters){
                  if((s.getPeriod() + s.getYear()).equals(selection.toString())){
                    currSemester = s;                 
                    System.out.println(currSemester.getPeriod() + currSemester.getYear());
                    
                  }
              }
           });
          
          dropdownCourse.setOnAction(e -> {
          //code in here
          Object selection = dropdownCourse.getSelectionModel().getSelectedItem(); //grab selection
          if (selection != null){
              for (Course c : courses){
                if ((c.getPrefix() + c.getNum()).equals(selection.toString())){
                currCourse = c; 
                System.out.println(c.getPrefix() + c.getNum());
                
                }
                    
                
              }
          }
          });
          
          dropdownSchedule.setOnAction(e -> {
          //code in here
          Object selection = dropdownSchedule.getSelectionModel().getSelectedItem(); //grab selection
          //dropdownSemester
          for (Schedule sched : schedules){
                  if(selection.toString().equals(String.valueOf(sched.getScheduleID()))){
                    currSchedule = sched;                 
                    
                  }
              }
           });
          
          dropdownFaculty.setOnAction(e -> {
          //code in here
          Object selection = dropdownFaculty.getSelectionModel().getSelectedItem(); //grab selection
          //dropdownSemester
          for (Faculty f : facultyList){
                  if(f.getFullName().equals(selection.toString())){
                    currFaculty = f;
                    System.out.println(selection.toString());
                    
                  }
              }
           });
          
          dropdownStudent.setOnAction(e -> {
          //code in here
          Object selection = dropdownStudent.getSelectionModel().getSelectedItem(); //grab selection
          //dropdownSemester
          for (Student s : students){
                  if(s.getFullName().equals(selection.toString())){
                    currStudent = s;
                    System.out.println(selection.toString());
                    
                  }
              }
           });
          
          dropdownEnroll.setOnAction(e -> {
          //code in here
          Object selection = dropdownEnroll.getSelectionModel().getSelectedItem(); //grab selection
          //dropdownSemester
          for (Enrollment enroll : enrollments){
                  if(selection.toString().equals(String.valueOf(enroll.getEnrollID()))){
                    currEnroll = enroll;
                    System.out.println(selection.toString());
                    
                  }
              }
           });
          
          //Generate button
          generate.setOnAction(e -> {
              //System.out.println(currSem.getPeriod() + currCourse.getPrefix());
              switch(choice){
                  case 1:
                    //code in here
                          
                    output.setText(currSemester.listAssignedCourses()); //test
                    break;
                    
                  case 2:
                      // courses taught by faculty in a semester
                                    
                    output.setText(currSchedule.getAllInSemester(currSemester, 
                            currFaculty));
                    break;
                    
                  case 3:
                      output.setText(currEnroll.listStudentSchedule(currStudent, 
                                            currSemester));
                      break;
                  case 4:
                    String result = "";
                    for (Course course : currSemester.coursesTaught) {
                        if (course != null && course.equals(currCourse)){
                        for (int i = 0; i < course.assignedStudents.size(); i++){
                           result += course.assignedStudents.get(i).getFullName() + "\n";

                        }
                        
                        output.setText(result);
            break;
                    
                }
            }
                    
                         
              }
          
              
          
          });

         
         //END FOR REPORT
         
        btnSaveStud.setOnAction(e -> {
            // Gather TextField Information
            String selectedOption = (String)studDropDown.getValue();
            
            String fullName = txtStudName.getText();
            int studID = Integer.valueOf(txtStudID.getText());
            int ssn = Integer.valueOf(txtSSN.getText());
            String homeAddress = txtHomeAddress.getText();
            String email = txtEmail.getText();
            double gpa = Double.valueOf(txtGPA.getText());
            String emergName = txtEmergName.getText();
            String emergEmail = txtEmergEmail.getText();
            String emergPhone = txtEmergPhone.getText();
            
            if(selectedOption.equals("Create Student"))
            {
                String sqlQuery = "INSERT INTO STUDENT (fullName, studID, ssn, homeAddress,"
                + "email, gpa, emergName, emergEmail, emergPhone) VALUES ( " + "'" 
                        + fullName + "','" + studID + "'," + ssn + "," + homeAddress + "," + email
                        + "," + gpa + "," + emergName + "," + emergEmail + "," + emergPhone + ")";
                // make student object
                Student student = new Student(fullName, studID, ssn, homeAddress, email, gpa,
                    emergName, emergEmail, emergPhone);

                // add to edit student comboBox 
                cmboEditStud.getItems().add(student.getFullName());
                // add to enroll student comboBox
                cmboEnrollStud.getItems().add(student.getFullName());
                // add student object to arrayList
                students.add(student);
//                sqlQuery +="'" + fullName + "','" + studID + "'," + ssn + "," + homeAddress + "," + email
//                        + "," + gpa + "," + emergName + "," + emergEmail + "," + emergPhone + ")";
        
                //insert
                runDBQuery(sqlQuery, 'c');
                
                //see insertion
                printInventory();
            }
            // for editing
            else if(selectedOption.equals("Edit Student")) 
            {
                String selectStud = (String)cmboEditStud.getValue();
                
                // find corresponding student object in the list
                for(Student s : students) {
                    if(s != null && selectStud != null &&
                            s.getFullName().equals(selectStud)) {
                        // update student information
                        s.setFullName(fullName);
                        s.setID(studID);
                        s.setSSN(ssn);
                        s.setEmail(email);
                        s.setAddress(homeAddress);
                        s.setGPA(gpa);
                        s.setEmergencyName(emergName);
                        s.setEmergencyEmail(emergEmail);
                        s.setEmergencyPhone(emergPhone);
                        break;
                    }
                }
            }
            // cmboEditStud.setValue(null);
            clearStudentFields();
            updateStudent();
            // refresh the textArea with the new/updated student
            refreshStudent();
        });
        
        
       btnSaveFac.setOnAction(e -> {
           // gather textField information
           String selectedOption = (String)facDropDown.getValue();
           
           int facID = Integer.valueOf(txtFacID.getText());
           String facName = txtFacName.getText();
           String FEmail = txtFEmail.getText();
           String building = txtBuilding.getText();
           int officeNum = Integer.valueOf(txtOffice.getText());
           String phoneNum = txtFacPhone.getText();
           String dept = txtDept.getText();
           String position = txtPosition.getText();
           
           if(selectedOption.equals("Create Faculty"))
           {
               Faculty faculty = new Faculty(facID, facName, FEmail, building,
                       officeNum, phoneNum, dept, position);
               // add to faculty array list
               facultyList.add(faculty);
               // add to edit faculty comboBox
               cmboEditFac.getItems().add(faculty.getFullName());
               // add to faculty drop down...
               cmboAssignFac.getItems().add(faculty.getFullName());
               //for report
               dropdownFaculty.getItems().add(faculty.getFullName());
           }
           // for editing
           else if(selectedOption.equals("Edit Faculty"))
           {
               String selectFac = (String)cmboEditFac.getValue();
               
               // find corresponding faculty in list
               for(Faculty f : facultyList)
               {
                   if(f != null && f.getFullName().equals(selectFac))
                   {
                      // update faculty info
                       f.setID(facID);
                       f.setFullName(facName);
                       f.setEmail(FEmail);
                       f.setBuilding(building);
                       f.setOfficeNum(officeNum);
                       f.setPhoneNum(phoneNum);
                       f.setDept(dept);
                       f.setPosition(position);
                       break;
                   }
               }
           }
           clearFacultyFields();
           updateFaculty();
           refreshFaculty();
           
       });
        
        btnSaveSem.setOnAction(e -> {
            // gather textField information
            String selectedOption = (String)semDropDown.getValue();
            
            String period = txtPeriod.getText();
            String year = txtYear.getText();
            
            if(selectedOption.equals("Create Semester"))
            {
                Semester semester = new Semester(period, year);
                
                // add to semester array
                semesters.add(semester);
                // add to edit semester comboBox
                cmboEditSem.getItems().add(semester.getPeriod() + semester.getYear());
                // add to enroll semester comboBox
                cmboEnrollSem.getItems().add(semester.getPeriod() + semester.getYear());
                // add to assign semester comboBox
                cmboAssignSem.getItems().add(semester.getPeriod() + semester.getYear());
                
                //report
                dropdownSemester.getItems().add(semester.getPeriod() + semester.getYear());
            }
            else if(selectedOption.equals("Edit Semester"))
            {
                String selectSem = cmboEditSem.getSelectionModel().getSelectedItem().toString();
                
                // find corresponding semester object in array
                for(Semester s : semesters)
                {
                    if(s != null && selectSem != null && 
                            selectSem.equals(s.getPeriod() + s.getYear()))
                    {
                        s.setPeriod(period);
                        s.setYear(year);
                        break;
                    }
                }
            }
            // cmboEditSem.setValue(null);
            clearSemesterFields();
            updateSemester();
            // refresh text area
            refreshSemester();
        });
        
        btnSaveCourse.setOnAction(e -> {
            // gather textfield information
            String selectedOption = (String)crsDropDown.getValue();
            
            String coursePrefix = txtCoursePrefix.getText();
            int courseNum = Integer.valueOf(txtCourseNum.getText());
            String courseName = txtCourseName.getText();
            String courseDays = txtCourseDays.getText();
            String startTime = txtStartTime.getText();
            String endTime = txtEndTime.getText();
            int creditHours = Integer.valueOf(txtCreditHours.getText());
            
            if(selectedOption.equals("Create Course"))
            {
                Course course = new Course(coursePrefix, courseNum, courseDays,
                        startTime, endTime, creditHours, courseName);
                
                // add to edit course comboBox
                cmboEditCourse.getItems().add(course.getPrefix() + course.getNum());
                // add to enroll course comboBox
                cmboEnrollCrs.getItems().add(course.getPrefix() + course.getNum());
                // add to assign course combobox
                cmboAssignCrs.getItems().add(course.getPrefix() + course.getNum());
                
                dropdownCourse.getItems().add(course.getPrefix() + course.getNum());
                // add course to array
                courses.add(course);
            }
            else if(selectedOption.equals("Edit Course"))
            {
                String selectCourse = (String)cmboEditCourse.getValue();
                
                // find corresponding course object in list
                for (Course c : courses)
                {
                    if(c != null && selectCourse != null &&
                            selectCourse.equals(c.getPrefix() + c.getNum()))
                    {
                        c.setPrefix(coursePrefix);
                        c.setNum(courseNum);
                        c.setName(courseName);
                        c.setDaysTaught(courseDays);
                        c.setStartTime(startTime);
                        c.setEndTime(endTime);
                        c.setCredits(creditHours);
                        break;
                    }
                }
            }
            // cmboEditCourse.setValue(null);
            clearCourseFields();
            updateCourse();
            // refresh text area
            refreshCourse();
        });
        
        btnEnroll.setOnAction(e -> {
            String studObj = (String)cmboEnrollStud.getValue();
            String semObj = (String)cmboEnrollSem.getValue();
            String crsObj = (String)cmboEnrollCrs.getValue();
            
            System.out.println(studObj);
            
            if(studObj != null && semObj != null && crsObj != null)
            {
//                Student selectStud = studObj;
//                Semester selectSem = semObj;
//                Course selectCrs = crsObj;
                
                // create objects to find
                Student stud = null;
                Semester sem = null;
                Course crs = null;

                // make the selectStud a student object
                for(Student s : students)
                {
                    if(studObj.equals(s.getFullName()))
                    {
                        // create the student object if they match
                        stud = s;
                    }
                }
                for(Semester sm : semesters)
                {
                    if(semObj.equals(sm.getPeriod() + sm.getYear()))
                    {
                        // create semester object
                        sem = sm;
                    }       
                }
                for(Course c : courses)
                {
                    if(crsObj.equals(c.getPrefix() + c.getNum()))
                    {
                        // create course object if they match
                        crs = c;
                    }
                }
                
                // System.out.println(stud.getFullName() + sem.getPeriod() + sem.getYear() + crs.getPrefix() +
                    //    crs.getNum());

                // create enrollment object based off chosen 
                Enrollment enroll = new Enrollment(stud, sem, crs);
                

                // catch the enrollment id
                int enrollID = Integer.valueOf(txtEnrollID.getText());
                // attach to enrollment object
                enroll.setEnrollID(enrollID);

                // add to enrollment array
                enrollments.add(enroll);
                dropdownEnroll.getItems().add(enroll.getEnrollID());

                // add student to course roster
                enroll.courseEnrollment(crs);
                refreshEnroll();
                // clear id textfield
                txtEnrollID.clear();
                }
            else 
            {
                txtaEnroll.appendText("Error. Please try again later.");
            }
            
        });
        
        assignBtn.setOnAction(e -> {
          //code in here
          Schedule schedule1 = new Schedule();
          //System.out.println("Faculty: " + currFaculty.getFullName() + " Semester: " + currSemester.getPeriod() 
                //  + currSemester.getYear() + " Course: " + currCourse.getPrefix() + currCourse.getNum()); //for testing
          schedule1.assignSemester(currFaculty, currSemester);
          schedule1.addCourse(currCourse);
          currSemester.assignCourses(currCourse);
          for (Course c: currSemester.coursesTaught){
              if(c != null)
          System.out.println(currCourse.getPrefix()+ currCourse.getName());
          }
          schedules.add(schedule1);
          dropdownSchedule.getItems().add(schedule1.getScheduleID());
          refreshAssign();
          });
                
    }

    public static void main(String[] args) {
        launch();
    }
    
    public void clearStudentFields() {
        // clear inputs to get ready for next user input
            txtStudName.clear();
            txtStudID.clear();
            txtSSN.clear();
            txtHomeAddress.clear();
            txtEmail.clear();
            txtGPA.clear();
            txtEmergName.clear();
            txtEmergEmail.clear();
            txtEmergPhone.clear();
    }
    
    public void enableStudentFields() {
        
        txtStudName.setDisable(false);
        txtStudID.setDisable(false);
        txtSSN.setDisable(false);
        txtHomeAddress.setDisable(false);
        txtEmail.setDisable(false);
        txtGPA.setDisable(false);
        txtEmergName.setDisable(false);
        txtEmergEmail.setDisable(false);
        txtEmergPhone.setDisable(false);
    }
    
    public void enableSemesterFields() {
        txtPeriod.setDisable(false);
        txtYear.setDisable(false);
    }
    
    public void clearSemesterFields() {
        txtPeriod.clear();
        txtYear.clear();
    }
    
    public void enableCourseFields() {
        txtCoursePrefix.setDisable(false);
        txtCourseNum.setDisable(false);
        txtCourseName.setDisable(false);
        txtCourseDays.setDisable(false);
        txtStartTime.setDisable(false);
        txtEndTime.setDisable(false);
        txtCreditHours.setDisable(false);
        // txtCourseInst.setDisable(false);
    }
    
    public void clearCourseFields() {
        txtCoursePrefix.clear();
        txtCourseNum.clear();
        txtCourseName.clear();
        txtCourseDays.clear();
        txtStartTime.clear();
        txtEndTime.clear();
        txtCreditHours.clear();
        // txtCourseInst.clear();
    }
    
    public void enableFacultyFields() {
        txtFacID.setDisable(false);
        txtFacName.setDisable(false);
        txtFEmail.setDisable(false);
        txtBuilding.setDisable(false);
        txtOffice.setDisable(false);
        txtFacPhone.setDisable(false);
        txtDept.setDisable(false);
        txtPosition.setDisable(false);
    }
    
    public void clearFacultyFields() {
        txtFacID.clear();
        txtFacName.clear();
        txtFEmail.clear();
        txtBuilding.clear();;
        txtOffice.clear();
        txtFacPhone.clear();
        txtDept.clear();
        txtPosition.clear();
    }
    
    public void updateStudent() {
        cmboEditStud.getItems().clear();
        cmboEnrollStud.getItems().clear();
        for (Student s : students) {
            cmboEditStud.getItems().add(s.getFullName());
            cmboEnrollStud.getItems().add(s.getFullName());
        }
    }
    
    public void updateFaculty() {
        cmboEditFac.getItems().clear();
        cmboAssignFac.getItems().clear();
        for(Faculty f : facultyList) {
            cmboEditFac.getItems().add(f.getFullName());
            cmboAssignFac.getItems().add(f.getFullName());
        }
    }
    
    public void updateSemester() {
        cmboEditSem.getItems().clear();
        cmboEnrollSem.getItems().clear();
        cmboAssignSem.getItems().clear();
        for(Semester s : semesters) {
            cmboEditSem.getItems().add(s.getPeriod() + s.getYear());
            cmboEnrollSem.getItems().add(s.getPeriod() + s.getYear());
            cmboAssignSem.getItems().add(s.getPeriod() + s.getYear());
        }
    }
    
    public void updateCourse() {
        cmboEditCourse.getItems().clear();
        cmboEnrollCrs.getItems().clear();
        cmboAssignCrs.getItems().clear();
        for(Course c : courses) {
            cmboEditCourse.getItems().add(c.getPrefix() + c.getNum());
            cmboEnrollCrs.getItems().add(c.getPrefix() + c.getNum());
            cmboAssignCrs.getItems().add(c.getPrefix() + c.getNum());
        }
    }
    
    public void refreshStudent() {
        // clear text area
        txtaStudent.clear();
        
        for(Student s : students) {
            // add the text of the student to textArea
            txtaStudent.appendText(s.toString() + "\n");
        }
    }
    
    public void refreshFaculty() {
        // clear text area
        txtaFaculty.clear();
        
        for(Faculty f : facultyList) {
            txtaFaculty.appendText(f.toString() + "\n");
        }
    }
    
    public void refreshCourse() {
        // clear text area
        txtaCourse.clear();
        
        for (Course c : courses) {
            // add the text of the course to textArea
            txtaCourse.appendText(c.toString() +  "\n");
        }
    }
    
    public void refreshSemester() {
        // clear text area
        txtaSem.clear();
        
        for(Semester sm : semesters) {
            // add the text to the semester textArea
            txtaSem.appendText(sm.toString() + "\n");
        }
    }
    
    public void refreshEnroll() {
        // clear text area
        txtaEnroll.clear();
        
        for(Enrollment e : enrollments) {
            // add text to enrollment textArea
            txtaEnroll.appendText(e.toString() + "\n");
        }
    }
    
    public void refreshAssign() {
        // clear text area
        txtaAssign.clear();
        
        for(Schedule sch : schedules)
        {
            // add text to assign textArea
            txtaAssign.appendText(sch.toString() + "\n");
        }
    }
    
    public static void printInventory()
    {
        String sqlQuery = "SELECT * FROM STUDENT";
        runDBQuery(sqlQuery, 'r');
        
        try
        {
            while (jsqlResults.next()){
            System.out.println(String.format("%-15s%-15d%-15s%-15s%-15s%-7d%-15s%-15s%-15s", 
                    jsqlResults.getString(1), 
                    jsqlResults.getInt(2),
                    jsqlResults.getString(3),
                    jsqlResults.getString(4),
                    jsqlResults.getString(5),
                    jsqlResults.getInt(6),
                    jsqlResults.getString(7),
                    jsqlResults.getString(8),
                    jsqlResults.getString(9)));
            }
        } catch (SQLException ex){
            System.out.println(ex.toString());
        }
    }
    
    public static void runDBQuery(String query, char queryType)
    {
        // queryType - Using the C.R.U.D. acronym
        // 'r' - SELECT
        // 'c', 'u', or 'd' - UPDATE, INSERT, DELETE
        
        try
        {
            String URL = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
            String user = "javauser"; // From setup instructions
            String pass = "javapass"; // From setup instructions

            oDS = new OracleDataSource();
            oDS.setURL(URL);
            
            jsqlConn = oDS.getConnection(user, pass);
            jsqlStmt = jsqlConn.prepareStatement(
                    query, 
                    ResultSet.TYPE_SCROLL_INSENSITIVE, 
                    ResultSet.CONCUR_READ_ONLY);
            
            if (queryType == 'r')
                jsqlResults = jsqlStmt.executeQuery();
            else
                jsqlStmt.executeUpdate();
        }
        catch (SQLException sqlex)
        {
            System.out.println(sqlex.toString());
        }
    } // End of runDBQuery() method
    

}

/* where i left off:
basically enroll is being a bitch and keep coming up
with ClassCastException specifically with Student

gonna give it a rest for now and move to the second bullet -->
printing all courses a student is taking in a semester
*/
