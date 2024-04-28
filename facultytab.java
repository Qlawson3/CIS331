package com.mycompany.db2;

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
     Faculty currFaculty = new Faculty();
     boolean isEditing = false;
     
     
    @Override
    public void start(Stage stage) {

          //Controls
          Label header = new Label("What would you like to do? : ");
          ChoiceBox dropdown = new ChoiceBox(); // Create dropdown menu
          ChoiceBox dropdownMembers = new ChoiceBox(); // Create dropdown menu of members
          dropdown.getItems().add("Create Faculty"); //Choice 1
          dropdown.getItems().add("Edit Faculty"); //Choice 2
          Label fullName = new Label("Full Name: ");
          Label email = new Label("Email: ");
          Label buildingName = new Label("Building Name: ");
          Label officeNum = new Label("Office Number: ");
          Label phoneNum = new Label("Phone Number: ");
          Label dept = new Label("Department Name: ");
          Label position = new Label("Position: ");
          TextField txtFullName = new TextField();
          TextField txtEmail = new TextField();
          TextField txtBuilding = new TextField();
          TextField txtOffice = new TextField();
          TextField txtPhone = new TextField();
          TextField txtDept = new TextField();
          TextField txtPosition = new TextField();
          Button saveBtn = new Button("Save");
          Label editLbl = new Label("Click on Student to Edit:");
          
          TextArea output = new TextArea();
          //Label output = new Label();
          
          //Pane
          GridPane primePane = new GridPane();
          primePane.add(header, 0, 0);
          primePane.add(dropdown, 1, 0);
          primePane.add(fullName, 0, 1);
          primePane.add(txtFullName, 1, 1);
          primePane.add(email, 0, 2);
          primePane.add(txtEmail, 1, 2);
          primePane.add(buildingName, 0, 3);
          primePane.add(txtBuilding, 1, 3);
          primePane.add(officeNum, 0, 4);
          primePane.add(txtOffice, 1, 4);
          primePane.add(phoneNum, 0, 5);
          primePane.add(txtPhone, 1, 5);
          primePane.add(dept, 0, 6);
          primePane.add(txtDept, 1, 6);
          primePane.add(position, 0, 7);
          primePane.add(txtPosition, 1, 7);
          primePane.add(saveBtn, 1, 8);
          //label
          primePane.add(editLbl, 1, 10);
          //Invisible until edit is chosen
          primePane.add(dropdownMembers, 0, 10, 1, 2);
          

          primePane.setHgap(10);
          primePane.setVgap(10);
          primePane.setAlignment(Pos.CENTER);
          
          //Scene
          Scene primeScene = new Scene(primePane, 500, 300);

          
          //Stage
          dropdownMembers.setVisible(false);
          editLbl.setVisible(false);
          stage.setScene(primeScene);
          stage.setTitle("Faculty Tab");
          stage.show();
          
          //Event Handle
          
          //DROPDOWN
          dropdown.setOnAction(e -> {
          //code in here
          Object selection = dropdown.getSelectionModel().getSelectedItem(); //grab selection
          if (selection.toString().equals("Edit Faculty")){
              isEditing = true;
              
              dropdownMembers.setVisible(true); 
              editLbl.setVisible(true);
              System.out.println(selection);
          } else{
              isEditing = false;
              dropdownMembers.setVisible(false);
              editLbl.setVisible(false);
              txtFullName.setPromptText("");;
              txtEmail.setPromptText("");
              txtBuilding.setPromptText("");
              txtOffice.setPromptText("");
              txtPhone.setPromptText("");
              txtDept.setPromptText("");
              txtPosition.setPromptText("");
          }
          });
          
          //DROPDOWN MEMBERS
          dropdownMembers.setOnAction(e -> {
          //code in here
          Object selection = dropdownMembers.getSelectionModel().getSelectedItem(); //grab selection
          if(selection != null){ //null pointer exception to handle updates
              
          
          //System.out.println(selection.toString()); Testing purposes
          for (Faculty f : facultyArray){  
              if(selection.toString().equals(f.getFullName())){
              currFaculty = f;
              break;
              }
          }
          //If selection isn't null fill boxes with saved information
          txtFullName.setPromptText("Last saved: " + currFaculty.getFullName());
          txtEmail.setPromptText("Last saved: " + currFaculty.getEmail());
          txtBuilding.setPromptText("Last saved: " + currFaculty.getBuilding());
          txtOffice.setPromptText("Last saved: " + (String.valueOf(currFaculty.getOfficeNum())));
          txtPhone.setPromptText("Last saved: " + currFaculty.getPhoneNum());
          txtDept.setPromptText("Last saved: " + currFaculty.getDept());
          txtPosition.setPromptText("Last saved: " + currFaculty.getPosition());
            editLbl.setText("You have chosen " + currFaculty.getFullName() + "\n"
            + "Please enter new information for this faculty member.\n"
                    + "Then hit 'Save'.");
          }
          
          });
          
          
          
          //SAVE BUTTON
          saveBtn.setOnAction(e -> {
          //code in here
          if (!isEditing){
          String varName = txtFullName.getText();
          String varEmail = txtEmail.getText();
          String varBuilding = txtBuilding.getText();
          int varOffice = Integer.valueOf(txtOffice.getText());
          String varPhone = txtPhone.getText();
          String varDept = txtDept.getText();
          String varPosition = txtPosition.getText();
          
          Faculty faculty = new Faculty(0, varName, varEmail, varBuilding, varOffice, 
                  varPhone, varDept, varPosition);
          facultyArray.add(faculty);
          } else{ //if we are editing
          Faculty newFaculty = new Faculty(); //hold a temp faculty member
          
          newFaculty.setFullName(txtFullName.getText());
          newFaculty.setEmail(txtEmail.getText());
          newFaculty.setBuilding(txtBuilding.getText());
          newFaculty.setOfficeNum(Integer.valueOf(txtOffice.getText()));
          newFaculty.setPhoneNum(txtPhone.getText());
          newFaculty.setDept(txtDept.getText());
          newFaculty.setPosition(txtPosition.getText());
          for (int i = 0; i < facultyArray.size(); i++){
            if(currFaculty.getFullName().equals(facultyArray.get(i).getFullName())){
               facultyArray.set(i, newFaculty);
               currFaculty = newFaculty;
               break;
            }
          }
          }
          txtFullName.clear();
          txtEmail.clear();
          txtBuilding.clear();
          txtOffice.clear();
          txtPhone.clear();
          txtDept.clear();
          txtPosition.clear();
          
          dropdownMembers.getItems().clear();
          // Populate dropdown with updated faculty list
          for (Faculty f : facultyArray) {
            dropdownMembers.getItems().add(f.getFullName());
            }
          });
    }

    public static void main(String[] args) {
        
        launch();
    }
    
    

}
