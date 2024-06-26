package com.mycompany.db2;
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
import java.util.logging.Level;
import java.util.logging.Logger;
// Lia Hil, Sequoia Lawson, Valerie Hernandez


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
//        TextField txtStudID;
        TextField txtSSN;
        TextField txtHomeAddress;
        TextField txtEmail;
        TextField txtGPA;
        TextField txtEmergName;
        TextField txtEmergEmail;
        TextField txtEmergPhone;
        Label lblStudName;
        Label lblStudID;
        Label lblRanStudID;
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
//        TextField txtFacID;
        TextField txtFacName;
        TextField txtFEmail;
        TextField txtBuilding;
        TextField txtOffice;
        TextField txtFacPhone;
        TextField txtDept;
        TextField txtPosition;
        
        Label lblFacID;
        Label lblRanFacID;
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
        Label lblRanEnrollID;
        Label lblSelectStud;
        Label lblSelectSem;
        Label lblSelectCrs;
        
//        TextField txtEnrollID;
        
        TextArea txtaEnroll;
        
        // titles of window kind of
        Label lblEntryStud;
        Label lblEntrySem;
        Label lblEntryCourse;
        Label lblEntryEnroll;
        Label lblEntryFaculty;
        Label lblEntryAssign;
        Label lblEntryGenerate; 
        
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
        Button assignBtn;
        Button generateBtn;
        
        // for Editing
        ComboBox cmboEditStud;
        ComboBox cmboEditSem;
        ComboBox cmboEditCourse;
        ComboBox cmboEditFac;
        
        // comboBoxes for enroll
        ComboBox cmboEnrollStud;
        ComboBox cmboEnrollSem;
        ComboBox cmboEnrollCrs;
        
        // for assign
        Label lblAssignID;
        Label lblRanAssignID;
        ComboBox cmboAssignCrs;
        ComboBox cmboAssignFac;
        ComboBox cmboAssignSem;
        
        TextArea txtaAssign;
        
        // for generate reports
        ChoiceBox reportDropDown;
        Label lblRepSem;
        Label lblRepCrs;
        Label lblRepFac;
        Label lblRepStud;
        Label lblRepSched;
        Label lblRepEnroll;
        Label lblReport;

        ComboBox cmboRepSem;
        ComboBox cmboRepCrs;
        ComboBox cmboRepFac;
        ComboBox cmboRepStud;
        ComboBox cmboRepSched;
        ComboBox cmboRepEnroll;
        
        TextArea txtaReport;
        
              
        // IDs
        
        public static int studID = 10000;
        public static int facID = 20000;
        public static int enrollID = 30000;
        public static int schedID = 40000;
        
        // for editing enroll tab - same student and semester, just add a course
        ChoiceBox enrollDropDown;
        // for editing a schedule tab - same faculty and semester, just add a course
        ChoiceBox schedDropDown;
        
        // to list all previously made IDs
        ComboBox cmboEnrollIDs;
        ComboBox cmboSchedIDs;
        

        
        
        
        // identify selected objects
//        Course currCourse = new Course();
//        Semester currSemester = new Semester();
//        Faculty currFaculty = new Faculty();
        
        
        // lists to store object creations
        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Course> courses = new ArrayList<>();
        ArrayList<Faculty> facultyList = new ArrayList<>();
        ArrayList<Semester> semesters = new ArrayList<>();
        ArrayList<Enrollment> enrollments = new ArrayList<>();
        ArrayList<Schedule> schedules = new ArrayList<>();
        
        
        //testers
//        Course c1 = new Course("CIS", 331, "Tues/Thurs", "3:55pm", "5:10pm", 3, "Java");
//        Semester s1 = new Semester("Fall", "2024");
//        Student stud1 = new Student("Lia Hill", "11223344", "123 Address Ln", "liahill.com",
//                4.6, "Cathy Mercil", "cmercil.com", "703-483-3849");
//        Faculty f1 = new Faculty(1, "Consuela Valentina", "valentina@dukes.jmu.edu", "Gibbons", 4495, 
//                "540-039-4844", "Italian", "Professor");
        
     

    @Override
    public void start(Stage stage) {
        
        // Instantiate the above data fields within the start() method
        
        btnSaveStud = new Button("Save ->");
        btnSaveSem = new Button("Save ->");
        btnSaveCourse = new Button("Save ->");
        btnEnroll = new Button("Enroll ->");
        btnSaveFac = new Button("Save ->");
        assignBtn = new Button("Assign ->");
        generateBtn = new Button("Generate ->");
        
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
        
        cmboRepSem = new ComboBox();
        cmboRepCrs = new ComboBox();
        cmboRepFac = new ComboBox();
        cmboRepStud = new ComboBox();
        cmboRepSched = new ComboBox();
        cmboRepEnroll = new ComboBox();
        
//        //testers
//        cmboEnrollCrs.getItems().add(c1.getPrefix() + c1.getNum());
//        cmboEnrollSem.getItems().add(s1.getPeriod() + s1.getYear());
//        cmboEnrollStud.getItems().add(stud1.getFullName());
//
//        courses.add(c1);
//        students.add(stud1);
//        semesters.add(s1);
        
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
        
        reportDropDown = new ChoiceBox();
        reportDropDown.getItems().add("All Courses in a Semester");
        reportDropDown.getItems().add("All Courses in a Semester by Faculty");
        reportDropDown.getItems().add("All Courses in a Semester by Student");
        reportDropDown.getItems().add("All Students Enrolled in a Single Course by Semester");
        
        
        lblStudName = new Label("First and Last Name");
        lblStudID = new Label("Student ID");
        lblRanStudID = new Label();
        lblSSN = new Label("Social Security Number");
        lblHomeAddress = new Label("Home Address");
        lblEmail = new Label("Email Address");
        lblGPA = new Label("GPA");
        lblEmergName = new Label("Emergency Contact Name");
        lblEmergEmail = new Label("Emergency Contact Email Address");
        lblEmergPhone = new Label("Emergency Contact Phone");
        
        txtStudName = new TextField();
//        txtStudID = new TextField();
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
        lblRanFacID = new Label();
        lblFacName = new Label("First and Last Name");
        lblFEmail = new Label("Email");
        lblBuilding = new Label("Building Name");
        lblOffice= new Label("Office Number");
        lblFacPhone = new Label("Phone Number");
        lblDept = new Label("Department Name");
        lblPosition = new Label("Position");
        
//        txtFacID = new TextField();
        txtFacName = new TextField();
        txtFEmail = new TextField();
        txtBuilding = new TextField();
        txtOffice = new TextField();
        txtFacPhone = new TextField();
        txtDept = new TextField();
        txtPosition = new TextField();
        
        txtaFaculty = new TextArea();
        
        
        lblEnrollID = new Label("Create Enrollment or Edit Existing?");
        lblRanEnrollID = new Label();
        lblSelectStud = new Label("Select a Student");
        lblSelectSem = new Label("Select a Semester");
        lblSelectCrs = new Label("Select a Course");
        
//        txtEnrollID = new TextField();
        
        txtaEnroll = new TextArea();
        
        Label lblAssignID = new Label("Schedule ID");
        Label lblRanAssignID = new Label();
        txtaAssign = new TextArea();
        
        txtaReport = new TextArea();
        
        lblEntryStud = new Label("Manage Students");
        lblEntrySem = new Label("Manage Semesters");
        lblEntryCourse = new Label("Manage Courses");
        lblEntryEnroll = new Label("Enroll a Student");
        lblEntryFaculty = new Label("Manage Faculty");
        lblEntryAssign = new Label("Assign Faculty to Courses");
        lblEntryGenerate = new Label("Generate Various Reports");

        Label courseLbl = new Label("Choose a course");
        Label semesterLbl = new Label("Choose a semester");
        Label facultyLbl = new Label("Choose a faculty member");
        
        lblRepSem = new Label("Choose a Semester");
        lblRepCrs = new Label("Choose a Course");
        lblRepFac = new Label("Choose a Faculty Member");
        lblRepStud = new Label("Choose a Student");
        lblRepSched = new Label("Choose a Schedule");
        lblRepEnroll = new Label("Choose an Enrollment");
        lblReport = new Label("Please Choose a Report");
        
          
        enrollDropDown = new ChoiceBox();
        enrollDropDown.getItems().addAll("Create Enrollment", "Add Course to Existing Enrollment");
        
        schedDropDown = new ChoiceBox();
        schedDropDown.getItems().addAll("Create Schedule", "Add Course to Existing Schedule");
        
        cmboEnrollIDs = new ComboBox();
        cmboSchedIDs = new ComboBox();
        
       
        // for Tabs
        VBox overallVPane = new VBox();
        TabPane tPane = new TabPane();
        Tab tbStudent = new Tab("Student");
        Tab tbFaculty = new Tab("Faculty");
        Tab tbSemester = new Tab("Semester");
        Tab tbCourse = new Tab("Course");
        Tab tbEnroll = new Tab("Enroll a Student");
        Tab tbAssign = new Tab("Assign Faculty to Course");
        Tab tbGenerate = new Tab("Generate Reports");
        
        
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
        
        
        // prompt getting of inforrmation
        txtStudName.setPromptText("First and Last Name");
//        txtStudID.setPromptText("Student ID");
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
       
//       txtFacID.setPromptText("Faculty ID");
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
        lblEntryGenerate.setWrapText(true);
        
//        txtEnrollID.setPromptText("Enrollment ID");
        
        // add the titles to the appropriate tab 
        gStudPane.add(lblEntryStud, 0, 0);
        gFacultyPane.add(lblEntryFaculty, 0, 0);
        gSemPane.add(lblEntrySem, 0, 0);
        gCoursePane.add(lblEntryCourse, 0, 0);
        gEnrollPane.add(lblEntryEnroll, 0, 0);
        gAssignPane.add(lblEntryAssign, 0, 0);
        gReportPane.add(lblEntryGenerate, 0, 0);
        
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
//        txtStudID.setDisable(true);
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
                            //txtStudID.setText(String.valueOf(s.getID()));
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
                
                //lblRanStudID.setText(String.valueOf(studID));
                enableStudentFields();
            }
            else if (!selectedOption.equals("Edit Student"))
            {
                txtStudName.setDisable(true);
//                txtStudID.setDisable(true);
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
        
//        txtFacID.setDisable(true);
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
//                            txtFacID.setText(String.valueOf(f.getfacultyID()));
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
//                txtFacID.setDisable(true);
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
       HBox hEnroll = new HBox();
       hEnroll.getChildren().addAll(enrollDropDown, cmboEnrollIDs);
       gEnrollPane.add(hEnroll, 3, 1);
      
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
        
//        cmboEnrollIDs.getItems().add(getEnrollID());
        
        lblRanEnrollID.setDisable(true);
        cmboEnrollIDs.setDisable(true);
        cmboEnrollStud.setDisable(true);
        cmboEnrollSem.setDisable(true);
        cmboEnrollCrs.setDisable(true);
        
        lblRanEnrollID.setVisible(false);
        cmboEnrollIDs.setVisible(false);
        cmboEnrollStud.setVisible(false);
        cmboEnrollSem.setVisible(false);
        cmboEnrollCrs.setVisible(false);
        
        enrollDropDown.setOnAction(e -> {
           String selection = (String)enrollDropDown.getValue();
           if(selection.equals("Add Course to Existing Enrollment"))
           {
               // make enrollment ID list available
               cmboEnrollIDs.setDisable(false);
               cmboEnrollIDs.setVisible(true);
               
               // clear list then repopulate it
               cmboEnrollIDs.getItems().clear();
               for(Enrollment enrl : enrollments)
               {
                   cmboEnrollIDs.getItems().add(enrl.getEnrollID());
               }
               
               cmboEnrollStud.setDisable(true);
               cmboEnrollSem.setDisable(true);
               cmboEnrollStud.setVisible(false);
               cmboEnrollSem.setVisible(false);
       
               // make courses available
               cmboEnrollCrs.setDisable(false);
               cmboEnrollCrs.setVisible(true);  
               
               // clear list then repopulate it
               cmboEnrollCrs.getItems().clear();
               for(Course c : courses)
               {
                   cmboEnrollCrs.getItems().add(c.getPrefix() + c.getNum());
               }
           }
           else if(selection.equals("Create Enrollment"))
           {
               lblRanEnrollID.setText(String.valueOf(enrollID));
               
               lblRanEnrollID.setDisable(false);
               cmboEnrollStud.setDisable(false);
               cmboEnrollSem.setDisable(false);
               cmboEnrollCrs.setDisable(false);
        
               lblRanEnrollID.setVisible(true);
               cmboEnrollStud.setVisible(true);
               cmboEnrollSem.setVisible(true);
               cmboEnrollCrs.setVisible(true);
               
               cmboEnrollIDs.setVisible(false);
               cmboEnrollIDs.setDisable(true);
               
               // refresh student list
               cmboEnrollStud.getItems().clear();
               for(Student st : students)
               {
                   cmboEnrollStud.getItems().add(st.getFullName());
               }
               // refresh semester list
               cmboEnrollSem.getItems().clear();
               for(Semester sem : semesters)
               {
                   cmboEnrollSem.getItems().add(sem.getPeriod() + sem.getYear());
               }
               // refresh course list
               cmboEnrollCrs.getItems().clear();
               for(Course c : courses)
               {
                   cmboEnrollCrs.getItems().add(c.getPrefix() + c.getNum());
               }
           }
       });
        
        
        
        // Assign tab - course
        HBox hAssign = new HBox();
        hAssign.getChildren().addAll(schedDropDown, cmboSchedIDs);
        gAssignPane.add(hAssign, 3, 1);
        
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
        
        lblRanAssignID.setDisable(true);
        lblRanAssignID.setVisible(false);
        
        cmboSchedIDs.setDisable(true);
        cmboSchedIDs.setVisible(false);
        cmboAssignCrs.setDisable(true);
        cmboAssignCrs.setVisible(false);
        cmboAssignSem.setDisable(true);
        cmboAssignSem.setVisible(false);
        cmboAssignFac.setDisable(true);
        cmboAssignFac.setVisible(false);
        
        schedDropDown.setOnAction(e -> {
            String selection = (String)schedDropDown.getValue();
            if(selection.equals("Add Course to Existing Schedule"))
            {
                lblRanAssignID.setDisable(true);
                lblRanAssignID.setVisible(false);
                
                cmboSchedIDs.setDisable(false);
                cmboSchedIDs.setVisible(true);
                
                // refresh schedIDs
                cmboSchedIDs.getItems().clear();
                for(Schedule sched : schedules)
                {
                    cmboSchedIDs.getItems().add(sched.getScheduleID());
                }
                
                
                cmboAssignCrs.setDisable(false);
                cmboAssignCrs.setVisible(true);
                
                // refresh courses
                cmboAssignCrs.getItems().clear();
                for(Course c : courses) 
                {
                    cmboAssignCrs.getItems().add(c.getPrefix() + c.getNum());
                }
                
                cmboAssignSem.setDisable(true);
                cmboAssignSem.setVisible(false);
                cmboAssignFac.setDisable(true);
                cmboAssignFac.setVisible(false);
            }
            else if(selection.equals("Create Schedule"))
            {
                lblRanAssignID.setText(String.valueOf(schedID));
                
                lblRanAssignID.setDisable(false);
                lblRanAssignID.setVisible(true);
        
                cmboSchedIDs.setDisable(true);
                cmboSchedIDs.setVisible(false);
                
                cmboAssignCrs.setDisable(false);
                cmboAssignCrs.setVisible(true);
                cmboAssignSem.setDisable(false);
                cmboAssignSem.setVisible(true);
                cmboAssignFac.setDisable(false);
                cmboAssignFac.setVisible(true);
                
                // refresh courses
                cmboAssignCrs.getItems().clear();
                for(Course c : courses) 
                {
                    cmboAssignCrs.getItems().add(c.getPrefix() + c.getNum());
                }
                
                // refresh semesters
                cmboAssignSem.getItems().clear();
                for(Semester s : semesters) 
                {
                    cmboAssignSem.getItems().add(s.getPeriod() + s.getYear());
                }
                
                // refresh faculty
                cmboAssignFac.getItems().clear();
                for(Faculty f : facultyList) 
                {
                    cmboAssignFac.getItems().add(f.getFullName());
                }
            }
        });
        
        
        
        
        // Generate Reports tab - initial ask
        HBox hRep = new HBox();
        hRep.getChildren().add(reportDropDown);
        gReportPane.add(hRep, 3, 1);
        
        // Generate Reports tab - semester
        HBox hRepSem = new HBox();
        hRepSem.getChildren().add(cmboRepSem);
        gReportPane.add(hRepSem, 3, 2);
        
        cmboRepSem.setDisable(true);
        cmboRepSem.setVisible(false);
        
        // Generate Reports tab - course
        HBox hRepCrs = new HBox();
        hRepCrs.getChildren().add(cmboRepCrs);
        gReportPane.add(hRepCrs, 3, 4);
        
        cmboRepCrs.setDisable(true);
        cmboRepCrs.setVisible(false);
        
        // Generate Reports tab - faculty
        HBox hRepFac = new HBox();
        hRepFac.getChildren().add(cmboRepFac);
        gReportPane.add(hRepFac, 3, 6);
        
        cmboRepFac.setDisable(true);
        cmboRepFac.setVisible(false);
        
        // Generate Reports tab - student
        HBox hRepStud = new HBox();
        hRepStud.getChildren().add(cmboRepStud);
        gReportPane.add(hRepStud, 3, 8);
        
        cmboRepStud.setDisable(true);
        cmboRepStud.setVisible(false);
        
        // Generate Reports tab - schedule
        HBox hRepSched = new HBox();
        hRepSched.getChildren().add(cmboRepSched);
        gReportPane.add(hRepSched, 3, 10);
        
        cmboRepSched.setDisable(true);
        cmboRepSched.setVisible(false);
        
        // Generate Reports tab - enrollment
        HBox hRepEnroll = new HBox();
        hRepEnroll.getChildren().add(cmboRepEnroll);
        gReportPane.add(hRepEnroll, 3, 12);
        
        cmboRepEnroll.setDisable(true);
        cmboRepEnroll.setVisible(false);
        
        reportDropDown.setOnAction(event -> {
            String selection = (String)reportDropDown.getValue();
            if(selection.equals("All Courses in a Semester"))
            {
                
                // make semester choice available
                cmboRepSem.setDisable(false);
                cmboRepSem.setVisible(true);
            }
            else if(selection.equals("All Courses in a Semester by Faculty"))
            {
                
                // make schedule choice available
                cmboRepSched.setDisable(false);
                cmboRepSched.setVisible(true);
                
                // make semester available
                    cmboRepSem.setDisable(false);
                    cmboRepSem.setVisible(true);
                    
                  
                        // make faculty available 
                        cmboRepFac.setDisable(false);
                        cmboRepFac.setVisible(true);
                    
                
            }
            else if(selection.equals("All Courses in a Semester by Student"))
            {
               
                // make students available
                cmboRepStud.setDisable(false);
                cmboRepStud.setVisible(true);
                
                    // make semester available
                    cmboRepSem.setDisable(false);
                    cmboRepSem.setVisible(true);
                    
                    
                        // make enrollment available
                        cmboRepEnroll.setDisable(false);
                        cmboRepEnroll.setVisible(true);
                    
                
            }
            else if(selection.equals("All Students Enrolled in a Single Course by Semester"))
            {
                
                // make course available
                cmboRepCrs.setDisable(false);
                cmboRepCrs.setVisible(true);
                
                    // make semester available
                    cmboRepSem.setDisable(false);
                    cmboRepSem.setVisible(true);
                
            }
        });
        
        
        
        
        // add menu to overall pane
        overallVPane.getChildren().add(mbarMenu);
        
        // position everything
        gStudPane.add(lblStudName, 0, 1);
        gStudPane.add(txtStudName, 1, 1);
        gStudPane.add(lblStudID, 0, 2);
        gStudPane.add(lblRanStudID, 1, 2);
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
        
        gFacultyPane.add(lblFacID, 0, 1);
        gFacultyPane.add(lblRanFacID, 1, 1);
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
        gEnrollPane.add(lblRanEnrollID, 1, 1);
        gEnrollPane.add(lblSelectStud, 0, 2);
        gEnrollPane.add(lblSelectSem, 0, 5);
        gEnrollPane.add(lblSelectCrs, 0, 8);
        gEnrollPane.add(txtaEnroll, 1, 10, 4, 1);
        
        gAssignPane.add(courseLbl, 0, 3);
        gAssignPane.add(semesterLbl, 0, 6);
        gAssignPane.add(facultyLbl, 0, 9);
        gAssignPane.add(txtaAssign, 1, 11, 4, 1);
        gAssignPane.add(lblAssignID, 0, 1);
        gAssignPane.add(lblRanAssignID, 1, 1);
        
        
        gReportPane.add(lblReport, 0, 1);
        gReportPane.add(lblRepSem, 0, 2);
        gReportPane.add(lblRepCrs, 0, 4);
        gReportPane.add(lblRepFac, 0, 6);
        gReportPane.add(lblRepStud, 0, 8);
        gReportPane.add(lblRepSched, 0, 10);
        gReportPane.add(lblRepEnroll, 0, 12);
        gReportPane.add(txtaReport, 1, 14, 4, 1);
        

        
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
        
        AnchorPane aReportPane = new AnchorPane();
        aReportPane.getChildren().add(generateBtn);
        
       
        
        // add to grids
        gStudPane.add(aStudPane, 1, 10);
        gFacultyPane.add(aFacPane, 1, 9);
        gSemPane.add(aSemPane, 1, 3);
        gCoursePane.add(aCrsPane, 1, 9);
        gEnrollPane.add(aEnrollPane, 1, 9);
        gAssignPane.add(aAssignPane, 1, 10);
        gReportPane.add(aReportPane, 1, 13);
        
        // position the window and where it will pop up
        gStudPane.setAlignment(Pos.CENTER);
        gFacultyPane.setAlignment(Pos.CENTER);
        gSemPane.setAlignment(Pos.CENTER);
        gCoursePane.setAlignment(Pos.CENTER);
        gEnrollPane.setAlignment(Pos.CENTER);
        gAssignPane.setAlignment(Pos.CENTER);
        gReportPane.setAlignment(Pos.CENTER);
        
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
        
        gReportPane.setHgap(15);
        gReportPane.setVgap(15);
        
        // add built gridPane to tab
        tbStudent.setContent(gStudPane);
        tbFaculty.setContent(gFacultyPane);
        tbSemester.setContent(gSemPane);
        tbCourse.setContent(gCoursePane);
        tbEnroll.setContent(gEnrollPane);
        tbAssign.setContent(gAssignPane);
        tbGenerate.setContent(gReportPane);
        
        // padding??? idk
        gStudPane.setPadding(new Insets(20, 0, 0, 0));
        gFacultyPane.setPadding(new Insets(20, 0, 0, 0));
        gSemPane.setPadding(new Insets(20, 0 , 0 ,0));
        gCoursePane.setPadding(new Insets(20, 0, 0, 0));
        gEnrollPane.setPadding(new Insets(20, 0, 0, 0));
        gAssignPane.setPadding(new Insets(20, 0, 0, 0));
        gReportPane.setPadding(new Insets(20, 0 , 0 , 0));
        
        // add both tabs to tab pane
        tPane.getTabs().addAll(tbStudent, tbFaculty, tbSemester, tbCourse, tbEnroll, tbAssign, tbGenerate);
        
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
        
        txtaReport.setMaxWidth(400);
        txtaReport.setMinWidth(400);
        
        
        
        // so that format specifiers work in textAreas
        txtaStudent.setStyle("-fx-font-family: monospace");
        txtaFaculty.setStyle("-fx-font-family: monospace");
        txtaSem.setStyle("-fx-font-family: monospace");
        txtaCourse.setStyle("-fx-font-family: monospace");
        txtaEnroll.setStyle("-fx-font-family: monospace");
        txtaAssign.setStyle("-fx-font-family: monospace");
        txtaReport.setStyle("-fx-font-family: monospace");
        
        //Show all IDs upon application start
        lblRanStudID.setText(String.valueOf(studID));
        lblRanFacID.setText(String.valueOf(facID));
        lblRanEnrollID.setText(String.valueOf(enrollID));
        

        
        
        // set everything up on the main window!
        Scene primaryScene = new Scene(overallVPane, 700, 850);
        stage.setScene(primaryScene);
        stage.setTitle("University Management");
        stage.show();
        
        btnSaveStud.setOnAction(e -> {
            // Gather TextField Information
            String selectedOption = (String)studDropDown.getValue();
            
            String fullName = txtStudName.getText();
//            int studID = Integer.valueOf(txtStudID.getText());
            String ssn = txtSSN.getText();
            String homeAddress = txtHomeAddress.getText();
            String email = txtEmail.getText();
            double gpa = Double.valueOf(txtGPA.getText());
            String emergName = txtEmergName.getText();
            String emergEmail = txtEmergEmail.getText();
            String emergPhone = txtEmergPhone.getText();
            
            if(selectedOption.equals("Create Student"))
            {
                //for database
              String sqlQuery = "INSERT INTO STUDENT (fullName, studID, ssn, homeAddress,"
                + "email, gpa, emergName, emergEmail, emergPhone) VALUES ( " + "'" 
                        + fullName + "'," + studID + ", '" + ssn + "', '" + homeAddress + "', '" + email
                        + "', '" + gpa + "', '" + emergName + "', '" + emergEmail + "', '" + emergPhone + "')";
                
                // make student object
                Student student = new Student(fullName, Integer.valueOf(ssn), homeAddress, email, gpa,
                    emergName, emergEmail, emergPhone);

                // add to edit student comboBox 
                cmboEditStud.getItems().add(student.getFullName());
                // add to enroll student comboBox
                cmboEnrollStud.getItems().add(student.getFullName());
                // add to report student comboBox
                cmboRepStud.getItems().add(student.getFullName());
                // add student object to arrayList
                students.add(student);
                txtaStudent.setText(student.getFullName());
                System.out.println(student.getFullName());
                studID++;
                lblRanStudID.setText(String.valueOf(studID));
                System.out.println(studID);
                //insert
                runDBQuery(sqlQuery, 'c');
            }
            // for editing
            else if(selectedOption.equals("Edit Student")) 
            {
                String selectStud = (String)cmboEditStud.getValue();
                
                // find corresponding student object in the list
                for(Student s : students) {
                    if(s != null && selectStud != null &&
                            s.getFullName().equals(selectStud)) {
                                                //update in database
                        String sqlQuery = "UPDATE STUDENT SET fullName = '" +fullName + "', studID = " + studID +
                                ", ssn = '" + ssn + "', homeAddress = '" + homeAddress +
                                "', email = '" + email + "', gpa = " + gpa + ", emergName = '" + emergName + 
                                "', emergEmail = '" + emergEmail + "', emergPhone = '" + emergPhone + "' WHERE studID = " + s.getID();
                        
                        // update student information
                        s.setFullName(fullName);
//                        s.setID(studID);
                        s.setSSN(Integer.valueOf(ssn));
                        s.setEmail(email);
                        s.setAddress(homeAddress);
                        s.setGPA(gpa);
                        s.setEmergencyName(emergName);
                        s.setEmergencyEmail(emergEmail);
                        s.setEmergencyPhone(emergPhone);
                        
                        runDBQuery(sqlQuery, 'u');
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
           
//           int facID = Integer.valueOf(txtFacID.getText());
           String facName = txtFacName.getText();
           String FEmail = txtFEmail.getText();
           String building = txtBuilding.getText();
           int officeNum = Integer.valueOf(txtOffice.getText());
           String phoneNum = txtFacPhone.getText();
           String dept = txtDept.getText();
           String position = txtPosition.getText();
           
           if(selectedOption.equals("Create Faculty"))
           {
                         String sqlQuery = "INSERT INTO FACULTY (facID, facName, FEmail, building,"
                + "officeNum, phoneNum, dept, position) VALUES ( " + 
                        + facID + ",'" + facName + "'," + FEmail + "," + building + "," + officeNum
                        + "," + phoneNum + "," + dept + "," + position + ")";
               Faculty faculty = new Faculty(facName, FEmail, building,
                       officeNum, phoneNum, dept, position);
               // add to faculty array list
               facultyList.add(faculty);
               // add to edit faculty comboBox
               cmboEditFac.getItems().add(faculty.getFullName());
               // add to assign faculty comboBox
               cmboAssignFac.getItems().add(faculty.getFullName());
               // add to report faculty comboBox
               cmboRepFac.getItems().add(faculty.getFullName());
               txtaFaculty.setText(faculty.getFullName());
                   //insert
           runDBQuery(sqlQuery, 'c');
               facID++;
               lblRanFacID.setText(String.valueOf(facID));
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
                                        String sqlQuery = "UPDATE FACULTY SET facID = " +facID + ", facName = " + facName +
                                ", FEmail = '" + FEmail + "', building = '" + building +
                                "', officeNum = '" + officeNum + "', phoneNum = " + phoneNum + ", dept = '" + dept + 
                                "', position = '" + position + "' WHERE facID = " + facID;
                      // update faculty info
                       f.setID(facID);
                       f.setFullName(facName);
                       f.setEmail(FEmail);
                       f.setBuilding(building);
                       f.setOfficeNum(officeNum);
                       f.setPhoneNum(phoneNum);
                       f.setDept(dept);
                       f.setPosition(position);
                       //insert
                       runDBQuery(sqlQuery, 'u');
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
                           String sqlQuery = "INSERT INTO SEMESTER (semPeriod, semYear) VALUES ( " + "'" 
                        + semester.getPeriod() + "','" + semester.getYear() + "')";
                   //insert
                   runDBQuery(sqlQuery, 'c');        
                // add to semester array
                semesters.add(semester);
                // add to edit semester comboBox
                cmboEditSem.getItems().add(semester.getPeriod() + semester.getYear());
                // add to enroll semester comboBox
                cmboEnrollSem.getItems().add(semester.getPeriod() + semester.getYear());
                // add to assign semester comboBox
                cmboAssignSem.getItems().add(semester.getPeriod() + semester.getYear());
                // addd to report semester comboBox
                cmboRepSem.getItems().add(semester.getPeriod() + semester.getYear());
                txtaSem.setText(semester.getPeriod() + semester.getYear());
                
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
                        String tempPeriod = s.getPeriod();
                        String tempYear = s.getYear();
                        
                        s.setPeriod(period);
                        s.setYear(year);
                        String sqlQuery = "UPDATE SEMESTER SET semPeriod = '" + s.getPeriod() + "', semYear = '" 
                                + s.getYear() + "' WHERE semPeriod = '" + tempPeriod + "' AND semYear = '" + tempYear + "'";
                        runDBQuery(sqlQuery, 'u');
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
                      String sqlQuery = "INSERT INTO COURSE (coursePrefix, courseNum, courseName, courseDays,"
                + "startTime, endTime, creditHours) VALUES ( " + "'" 
                        + coursePrefix + "'," + courseNum + ",'" + courseName + "', '" + courseDays + "', '" 
                              + startTime + "', '" + endTime + "', " + creditHours + ")";
                Course course = new Course(coursePrefix, courseNum, courseDays,
                        startTime, endTime, creditHours, courseName);
                
                // add to edit course comboBox
                cmboEditCourse.getItems().add(course.getPrefix() + course.getNum());
                // add to enroll course comboBox
                cmboEnrollCrs.getItems().add(course.getPrefix() + course.getNum());
                // add to assign course combobox
                cmboAssignCrs.getItems().add(course.getPrefix() + course.getNum());
                // add to report course comboBox
                cmboRepCrs.getItems().add(course.getPrefix() + course.getNum());
                // add course to array
                courses.add(course);
                txtaCourse.setText(course.getPrefix() + course.getNum());
                //insert
                runDBQuery(sqlQuery, 'c');
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
                       String tempPrefix = c.getPrefix();
                       int tempNum = c.getNum();
                       
                        c.setPrefix(coursePrefix);
                        c.setNum(courseNum);
                        c.setName(courseName);
                        c.setDaysTaught(courseDays);
                        c.setStartTime(startTime);
                        c.setEndTime(endTime);
                        c.setCredits(creditHours);
                        String sqlQuery = "UPDATE COURSE SET coursePrefix = '" +coursePrefix + "', courseNum = '" + courseNum +
                                "', courseName = '" + courseName + "', courseDays = '" + courseDays +
                               "', startTime = '" + startTime + "', endTime = '" + endTime + "', courseHours = '" + creditHours + 
                                "' WHERE coursePrefix = '" + tempPrefix + "' AND courseNum = " + tempNum;
                        //insert
                        runDBQuery(sqlQuery, 'u');
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
            
            String select = (String)enrollDropDown.getValue();
            if(select.equals("Create Enrollment"))
            {
            
                String studObj = (String)cmboEnrollStud.getValue();
                String semObj = (String)cmboEnrollSem.getValue();
                String crsObj = (String)cmboEnrollCrs.getValue();

                System.out.println(studObj);

                if(studObj != null && semObj != null && crsObj != null)
                {

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
                    

                    // create enrollment object based off chosen 
                    Enrollment enroll = new Enrollment(stud, sem, crs);
                    enroll.incEnrolled();
                String sqlQuery = "INSERT INTO ENROLLMENT (enrollID, student, enrolledIn, semPeriod, semYear) VALUES (" 
               + enrollID + ",'" + stud.getFullName() + "'," + enroll.numEnrolled()  + ", '" + sem.getPeriod()
               + "', '" + sem.getYear() + "')";

                    // add to enrollment array
                    enrollments.add(enroll);

                    // incremement enrollmentID
                    lblRanEnrollID.setText(String.valueOf(enrollID));
                    System.out.println(enrollID);
                    txtaEnroll.setText(String.valueOf(enrollID));
                    enroll.setID(enrollID);
                    // add to enrollment comboBox
                    cmboRepEnroll.getItems().add(enroll.getEnrollID());
                    cmboEnrollIDs.getItems().add(enroll.getEnrollID());
                    //enrollID++;

                    // add student to course
                    if(crs != null)
                    {
                        crs.addStudent(stud);
                    }

                    // adds course
                    enroll.courseEnrollment(crs);
                    updateEnroll();

                    refreshEnroll();
                    //insert
                    runDBQuery(sqlQuery, 'c');

                    // clear id textfield
    //                txtEnrollID.clear();
                    }
            }
            else if(select.equals("Add Course to Existing Enrollment"))
            {
                lblRanEnrollID.setVisible(false);
                lblRanEnrollID.setDisable(true);
                
                int selectID = (int)cmboEnrollIDs.getValue();
                String selectCrs = (String)cmboEnrollCrs.getValue();
                
                // course to find??
                Course c1 = null;
                
                for(Course crs : courses)
                {
                    if(crs != null && selectCrs.equals(crs.getPrefix() + crs.getNum()))
                    {
                        c1 = crs;
                        break;
                    }
                }
                
                for(Enrollment enrl : enrollments)
                {
                    if(enrl != null && selectID == enrl.getEnrollID())
                    {
                      enrl.incEnrolled();
                      String sqlQuery = "UPDATE ENROLLMENT SET enrolledIn = " + enrl.numEnrolled()  + " WHERE enrollID = " 
                      + enrl.getEnrollID();
                        enrl.courseEnrollment(c1);
                        updateEnroll();
                        refreshEnroll();
                        //insert
                        runDBQuery(sqlQuery, 'u');                      
                    }
                        
                }
            }
            else
            {
                txtaEnroll.appendText("Error. Please try again later.");
            }
            
        });
        
        assignBtn.setOnAction(e -> {
          String facObj = (String)cmboAssignFac.getValue();
          String crsObj = (String)cmboAssignCrs.getValue();
          String semObj = (String)cmboAssignSem.getValue();
          
          // create objects to find
          Faculty fac = null;
          Course crs = null;
          Semester sem = null;
          
          for(Faculty f : facultyList)
          {
              if(f != null && facObj.equals(f.getFullName()))
              {
                  fac = f;
              }
          }
          for(Course c : courses)
          {
              if(c != null && crsObj.equals(c.getPrefix() + c.getNum()))
              {
                  crs = c;
              }
          }
          for(Semester sm : semesters)
          {
              if(sm != null && semObj.equals(sm.getPeriod() + sm.getYear()))
              {
                  sem = sm;
              }
          }
          // create schedule object based off found items
          Schedule schedule = new Schedule();
         String sqlQuery = "INSERT INTO SCHEDULE (scheduleID, faculty, semPeriod, semYear) VALUES ( " + 
                        + schedID + ",'" + fac.getFullName() + "', '" + sem.getPeriod() + "', '" + sem.getYear() + "')";

          // assign semester to faculty
          schedule.assignSemester(fac, sem);
          // add course to schedule
          schedule.addCourse(crs);
          // add course to semester
          if(sem != null && crs != null) {
            sem.assignCourses(crs);
          }
          // add schedule to schedule array
          schedules.add(schedule);
          
          // update schedule ID
          lblRanAssignID.setText(String.valueOf(schedID));
          schedule.setScheduleID(schedID);
          // add to schedule comboBox
          cmboRepSched.getItems().add(schedule.getScheduleID());
          cmboSchedIDs.getItems().add(schedule.getScheduleID());
          schedID++;
          
          
          updateSchedule();
          refreshAssign();
          //insert
          runDBQuery(sqlQuery, 'c');
          });
        
        generateBtn.setOnAction(e -> {
            
            String select = (String)reportDropDown.getValue();
            if(select.equals("All Courses in a Semester"))
            {
                    String selectSem = (String)cmboRepSem.getValue();
                    if(selectSem != null)
                    {
                        for(Semester sm : semesters)
                        {
                            if(sm != null && selectSem.trim().equals(sm.getPeriod() + sm.getYear()))
                            {
                                // display in textArea
                                txtaReport.clear();
                                txtaReport.appendText(sm.listAssignedCourses());
                                
                            }
                            
                        }
                    }
                } else if(select.equals("All Courses in a Semester by Faculty"))
                {
                
                // make objects to find
                Schedule sched = null;
                Semester sem = null;
                Faculty fac = null;
                
                // find schedule
                int selectSched = (int)cmboRepSched.getValue();
                
                if(selectSched != -1)
                {   
                    for(Schedule sch : schedules)
                    {
                        if(sch != null && selectSched == sch.getScheduleID())
                        {
                            sched = sch;
                        }
                    }
                }
                    
                // find semester
                String selectSem = (String)cmboRepSem.getValue();
                
                if(selectSem != null) 
                {
                    for(Semester s : semesters)
                    {
                        if(s != null && selectSem.trim().equals(s.getPeriod() + s.getYear()))
                        {
                            sem = s;
                        }
                    }
                }
                // find faculty        
                String selectFac = (String)cmboRepFac.getValue();
                
                if(selectFac != null)
                {
                    for(Faculty f : facultyList)
                    {
                        if(f != null && selectFac.trim().equals(f.getFullName()))
                        {
                            fac = f;
                        }
                    }
                }
                // once everything is found...
                
                // clear text area
                txtaReport.clear();
                if(sched != null && fac != null) 
                {
                  txtaReport.appendText(sched.getAllInSemester(sem, fac));  
                }
            }
            else if(select.equals("All Courses in a Semester by Student"))
            {
                // make objects to find
                Student stud = null;
                Semester sem = null;
                Enrollment enroll = null;
                
                // find student
                String selectStud = (String)cmboRepStud.getValue();
                
                if(selectStud != null)
                {
                    for(Student s : students)
                    {
                        if(s != null && selectStud.trim().equals(s.getFullName()))
                        {
                            stud = s;
                        }
                    }
                }

                // find semester
                String selectSem = (String)cmboRepSem.getValue();

                if(selectSem != null)
                {
                    for(Semester sm : semesters)
                    {
                        if(sm != null && selectSem.trim().equals(sm.getPeriod() + sm.getYear()))
                        {
                            sem = sm;
                        }
                    }
                }

                // find enrollment
                int selectEnroll = (int)cmboRepEnroll.getValue();

                if(selectEnroll != -1)
                {
                    for(Enrollment en : enrollments)
                    {
                        if(en != null && selectEnroll == (en.getEnrollID()))
                        {
                            enroll = en;
                        }
                    }
                }

                // once everything is found
                txtaReport.clear();
                if(enroll != null)
                {
                   txtaReport.appendText(enroll.listStudentSchedule(stud, sem)); 
                }
            }
            else if(select.equals("All Students Enrolled in a Single Course by Semester"))
            {
                // define objects to find
                Course crs = null;
                Semester sem = null;
                
                String selectCrs = (String)cmboRepCrs.getValue();
                
                if(selectCrs != null)
                {
                    // find course
                    for(Course c : courses)
                    {
                        if(c != null && selectCrs.trim().equals(c.getPrefix() + c.getNum()))
                        {
                            crs = c;
                        }
                    }
                }
                
                String selectSem = (String)cmboRepSem.getValue();
                    
                    if(selectSem != null)
                    {
                        // find semesters
                        for(Semester sm : semesters)
                        {
                            if(sm != null && selectSem.trim().equals(sm.getPeriod() + sm.getYear()))
                            {
                                sem = sm;
                            }
                        }
                    }
                
                // once everything is found
                for(Enrollment enroll : enrollments)
                {
                    if(enroll.getSemester().equals(sem) && enroll.getCourse().equals(crs))
                    {
                        if(crs != null)
                        {
                            if(crs.assignedStudents != null)
                                    {
                                        for(int i = 0; i < crs.assignedStudents.size(); i++)
                                        {
                                            String sqlQuery = "INSERT INTO REPORT4 (student) VALUES ( " + "'" 
                                     + crs.assignedStudents.get(i).getFullName() + "')";
                                            
                                            runDBQuery(sqlQuery, 'c');
                                            txtaReport.clear();
                                            // print to text area
                                            txtaReport.appendText(crs.assignedStudents.get(i).getFullName() + "\n");
                                        }
                                    }
                            }
                        }
                    
                }
          
            }
            // reset comboBoxes after generating one report
            cmboRepSem.setDisable(true);
            cmboRepSem.setVisible(false);
            cmboRepCrs.setDisable(true);
            cmboRepCrs.setVisible(false);
            cmboRepFac.setDisable(true);
            cmboRepFac.setVisible(false);
            cmboRepStud.setDisable(true);
            cmboRepStud.setVisible(false);
            cmboRepSched.setDisable(true);
            cmboRepSched.setVisible(false);
            cmboRepEnroll.setDisable(true);
            cmboRepEnroll.setVisible(false);
            
            cmboRepSem.setValue(null);
            cmboRepCrs.setValue(null);
            cmboRepStud.setValue(null);
            cmboRepSched.setValue(null);
            cmboRepEnroll.setValue(null);
        });
    }
             
    

    public static void main(String[] args) {
        
        launch();
    }
    
    public void clearStudentFields() {
        // clear inputs to get ready for next user input
            txtStudName.clear();
//            txtStudID.clear();
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
//        txtStudID.setDisable(false);
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
//        txtFacID.setDisable(false);
        txtFacName.setDisable(false);
        txtFEmail.setDisable(false);
        txtBuilding.setDisable(false);
        txtOffice.setDisable(false);
        txtFacPhone.setDisable(false);
        txtDept.setDisable(false);
        txtPosition.setDisable(false);
    }
    
    public void clearFacultyFields() {
//        txtFacID.clear();
        txtFacName.clear();
        txtFEmail.clear();
        txtBuilding.clear();
        txtOffice.clear();
        txtFacPhone.clear();
        txtDept.clear();
        txtPosition.clear();
    }
    
    public void updateStudent() {
        cmboEditStud.getItems().clear();
        cmboEnrollStud.getItems().clear();
        cmboRepStud.getItems().clear();
        for (Student s : students) {
            cmboEditStud.getItems().add(s.getFullName());
            cmboEnrollStud.getItems().add(s.getFullName());
            cmboRepStud.getItems().add(s.getFullName());
        }
    }
    
    public void updateFaculty() {
        cmboEditFac.getItems().clear();
        cmboAssignFac.getItems().clear();
        cmboRepFac.getItems().clear();
        for(Faculty f : facultyList) {
            cmboEditFac.getItems().add(f.getFullName());
            cmboAssignFac.getItems().add(f.getFullName());
            cmboRepFac.getItems().add(f.getFullName());
        }
    }
    
    public void updateSemester() {
        cmboEditSem.getItems().clear();
        cmboEnrollSem.getItems().clear();
        cmboAssignSem.getItems().clear();
        cmboRepSem.getItems().clear();
        for(Semester s : semesters) {
            cmboEditSem.getItems().add(s.getPeriod() + s.getYear());
            cmboEnrollSem.getItems().add(s.getPeriod() + s.getYear());
            cmboAssignSem.getItems().add(s.getPeriod() + s.getYear());
            cmboRepSem.getItems().add(s.getPeriod() + s.getYear());
        }
    }
    
    public void updateCourse() {
        cmboEditCourse.getItems().clear();
        cmboEnrollCrs.getItems().clear();
        cmboAssignCrs.getItems().clear();
        cmboRepCrs.getItems().clear();
        for(Course c : courses) {
            cmboEditCourse.getItems().add(c.getPrefix() + c.getNum());
            cmboEnrollCrs.getItems().add(c.getPrefix() + c.getNum());
            cmboAssignCrs.getItems().add(c.getPrefix() + c.getNum());
            cmboRepCrs.getItems().add(c.getPrefix() + c.getNum());
        }
    }
    
    public void updateSchedule() {
        cmboRepSched.getItems().clear();
        cmboSchedIDs.getItems().clear();
        for(Schedule sch : schedules)
        {
            cmboRepSched.getItems().add(sch.getScheduleID());
            cmboSchedIDs.getItems().clear();
        }
    }
    
    public void updateEnroll() {
        cmboRepEnroll.getItems().clear();
        cmboEnrollIDs.getItems().clear();
        for(Enrollment e : enrollments)
        {
            cmboRepEnroll.getItems().add(e.getEnrollID());
            cmboEnrollIDs.getItems().add(e.getEnrollID());
        }
    }
    
    public void refreshStudent() {
        // clear text area
        txtaStudent.clear();
        
        for(Student s : students) {
            // add the text of the student to textArea
            txtaStudent.appendText(s.getFullName() + "\n");
        }
    }
    
    public void refreshFaculty() {
        // clear text area
        txtaFaculty.clear();
        
        for(Faculty f : facultyList) {
            txtaFaculty.appendText(f.getFullName() + "\n");
        }
    }
    
    public void refreshCourse() {
        // clear text area
        txtaCourse.clear();
        
        for (Course c : courses) {
            // add the text of the course to textArea
            txtaCourse.appendText(c.getPrefix() + c.getNum() +  "\n");
        }
    }
    
    public void refreshSemester() {
        // clear text area
        txtaSem.clear();
        
        for(Semester sm : semesters) {
            // add the text to the semester textArea
            txtaSem.appendText(sm.getPeriod() + sm.getYear() + "\n");
        }
        
    }
    
    public void refreshEnroll() {
        // clear text area
        txtaEnroll.clear();
        
        for(Enrollment e : enrollments) {
            // add text to enrollment textArea
            txtaEnroll.setText(enrollID + "\n");
        }
        enrollID++;
    }
    
    public void refreshAssign() {
        // clear text area
        txtaAssign.clear();
        
        for(Schedule sch : schedules)
        {
            // add text to assign textArea
            txtaAssign.appendText(schedID + "\n");
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

/*
where i left off: working on the generate tabs, specifically getting the courses per faculty 
by semester to work --> says fac is null --> playing with the tabs and getting them to show up correctly
*/
