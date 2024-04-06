switch (optionChoice)
                            {
                                case 1: 
                                    // editStudent;
                                    System.out.println("Please select a student (#): ");
                                    for (int i = 0;i < allStudents.length; i++) 
                                    {
                                        System.out.println(i + ": " + allStudents[i].fullName);
                                    }
                                    
                                    int selectStudent = in.nextInt();
                                    in.nextLine();
                                    
                                    Student student = allStudents[selectStudent];
                                    
                                    System.out.println("What would you like to edit?");
                                    System.out.println("Options: \nName \nStudent ID \nSSN \nHome Addres \nEmail \nGPA"
                                            + " \nEmergency Contact Name \nEmergency Contact Email \nEmergency Contact Phone Number");
                                    String editChoice = in.nextLine();
                                    String lowerCaseChoice = editChoice.toLowerCase();
                                    
                                    
                                    switch (editChoice)
                                    {
                                        case "name":
                                        {
                                            System.out.println("Enter updated Name: ");
                                            student.setFullName(in.nextLine());
                                            System.out.println("Successfully Updated! New Name is: "
                                                    + "\n" + student.getFullName());
                                            break;
                                        }
                                        case "studentid":
                                        {
                                            System.out.println("Enter updated Student ID");
                                            student.setStudentID(in.nextLine());
                                            System.out.println("Successfully Updated! New Student ID is: "
                                                    + "\n" + student.getStudentID());
                                            break;
                                        }
                                        case "ssn":
                                        {
                                            System.out.println("Enter updated SSN: ");
                                            student.setSSN(in.nextInt());
                                            in.nextLine();
                                            System.out.println("Successfully Updated! New SSN is: "
                                                    + "\n" + student.getSSN());
                                            break;
                                        }
                                        case "home address":
                                        {
                                            System.out.println("Enter updated Home Address: ");
                                            student.setAddress(in.nextLine());
                                            System.out.println("Successfully Updated! New Home Address is: "
                                                    + "\n" + student.getAddress());
                                            break;
                                        }
                                        case "email":
                                        {
                                            System.out.println("Enter updated Email: ");
                                            student.setEmail(in.nextLine());
                                            System.out.println("Successfully Updated! New Email is: "
                                                    + "\n" + student.getEmail());
                                            break;
                                        }
                                        case "gpa":
                                        {
                                            System.out.println("Enter updated GPA: ");
                                            student.setGPA(in.nextDouble());
                                            in.nextLine();
                                            System.out.println("Successfully Updated! New GPA is: "
                                                    + "\n" + student.getGPA());
                                            break;
                                        }
                                        case "emergency contact name":
                                        {
                                            System.out.println("Enter updated Emergency Contact Name: ");
                                            student.setEmergencyName(in.nextLine());
                                            System.out.println("Successfully Updated! New Emergency Contact Name is: "
                                                    + "\n" + student.getEmergencyName());
                                            break;
                                        }
                                        case "emergency contact email":
                                        {
                                            System.out.println("Enter updated Emergency Contact Email: ");
                                            student.setEmergencyEmail(in.nextLine());
                                            System.out.println("Successfully Updated! New Emergency Contact Phone Email is: "
                                                    + "\n" + student.getEmergencyEmail());
                                            break;
                                        }
                                        case "emergency contact phone number":
                                        {
                                            System.out.println("Enter updated Emergency Contact Phone Number: ");
                                            student.setEmergencyPhone(in.nextLine());
                                            System.out.println("Successfully Updated! New Emergency Contact Phone Number is: "
                                                    + "\n" + student.getEmergencyPhone());
                                            break;
                                        }
                                    }
                                    break;
                                case 2:
                                    // editFaculty
                                    System.out.println("Please select a faculty member (#): ");
                                    for (int i = 0;i < facultyArray.size(); i++) 
                                    {
                                        System.out.println(i + ": " + facultyArray.get(i).fullName);
                                    }
                                    int selectFac = in.nextInt();
                                    in.nextLine();
                                    Faculty faculty = facultyArray.get(selectFac);
                                    
                                    System.out.println("What would you like to update? ");
                                    System.out.println("Options: \nName \nEmail \nBuilding Name \nOffice Number \nPhone Number "
                                            + "\nDepartment Name" + " \nPosition");
                                    String choice1 = in.nextLine();
                                    String facChoice = choice1.toLowerCase();
                                    
                                    switch (facChoice) {
                                        case "name": 
                                        {
                                            System.out.println("Enter updated Name: ");
                                            faculty.setFullName(in.nextLine());
                                            System.out.println("Successfully Updated! New Name is: "
                                                    + "\n" + faculty.getFullName());
                                            break;
                                        }
                                        case "email":
                                        {
                                            System.out.println("Enter updated Email: ");
                                            faculty.setEmail(in.nextLine());
                                            System.out.println("Successfully Updated! New Email is: "
                                            + "\n" + faculty.getEmail());
                                            break;
                                        }
                                        case "building name":
                                        {
                                            System.out.println("Enter updated Building Name: ");
                                            faculty.setBuildingName(in.nextLine());
                                            System.out.println("Successfully Updated! New Building Name is: "
                                                    + "\n" + faculty.getBuildingName());
                                            break;
                                        }
                                        case "office number":
                                        {
                                            System.out.println("Enter updated Office Number: ");
                                            faculty.setOfficeNumber(in.nextLine());
                                            System.out.println("Successfully Updated! New Office Number is: "
                                                    + "\n" + faculty.getOfficeNumber());
                                            break;
                                        }
                                        case "phone number":
                                        {
                                            System.out.println("Enter updated Phone Number: ");
                                            faculty.setPhoneNum(in.nextLine());
                                            System.out.println("Successfully Updated! New Phone Number is:"
                                                    + "\n" + faculty.getPhoneNum());
                                            break;
                                        }
                                        case "department name":
                                        {
                                            System.out.println("Enter updated Department Name: ");
                                            faculty.setDepartmentName(in.nextLine());
                                            System.out.println("Successfully Updated! New Department Name is: "
                                                    + "\n" + faculty.getDepartmentName());
                                            break;
                                        }
                                        case "position":
                                        {
                                            System.out.println("Enter updated Position: ");
                                            faculty.setPosition(in.nextLine());
                                            System.out.println("Successfully Updated! New Position is: "
                                                    + "\n" + faculty.getPosition());
                                            break;
                                        }
                                    }
                                    break;
                                case 3:
                                    // editCourse
                                    System.out.println("Please select a Course (#): ");
                                    for (int i = 0;i < courseArray.size(); i++) 
                                    {
                                        System.out.println(i + ": " + courseArray.get(i).fullName);
                                    }
                                    int selectCrs = in.nextInt();
                                    in.nextLine();
                                    Course course = courseArray.get(selectCrs);
                                    
                                    System.out.println("What would you like to update? ");
                                    System.out.println("Options: \nCourse Prefix \nCourse Number \nDays Taught \nStart Time \nEnd Time "
                                            + "\nCredits" + "\nSemester");
                                    String choiceCrs = in.nextLine();
                                    String crsChoice = choiceCrs.toLowerCase();
                                    
                                    switch (crsChoice) {
                                        case "course prefix":
                                        {
                                            System.out.println("Enter updated Course Prefix: ");
                                            course.setCoursePrefix(in.nextLine());
                                            System.out.println("Successfully Updated! New Course Prefix is: "
                                                    + "\n" + course.getCoursePrefix());
                                            break;
                                        }
                                        case "course number":
                                        {
                                            System.out.println("Enter updated Course Number: ");
                                            course.setCourseNum(in.nextInt());
                                            in.nextLine();
                                            System.out.println("Successfully Updated! New Course Number is: "
                                                    + "\n" + course.getCourseNum());
                                            break;
                                        }
                                        case "days taught":
                                        {
                                            System.out.println("Enter updated Days Taught: ");
                                            course.setDaysTaught(in.nextLine());
                                            System.out.println("Successfully Updated! New Days Taught is: "
                                                    + "\n" + course.getDaysTaught());
                                            break;
                                        }
                                        case "start time":
                                        {
                                            System.out.println("Enter updated Start Time");
                                            course.setStartTime(in.nextLine());
                                            System.out.println("Successfully Updated! New Start Time is: "
                                                    + "\n" + course.getStartTime());
                                            break;
                                        }
                                        case "end time":
                                        {
                                            System.out.println("Enter updated End Time: ");
                                            course.setEndTime(in.nextLine());
                                            System.out.println("Successfully Updated! New End Time is: "
                                                    + "\n" + course.getEndTime());
                                            break;
                                        }
                                        case "credits":
                                        {
                                            System.out.println("Enter updated Credits: ");
                                            course.setCredits(in.nextInt());
                                            in.nextLine();
                                            System.out.println("Successfully Updated! New Credits is: "
                                                    + "\n" + course.getCredits());
                                            break;
                                        }
                                        case "semester":
                                        {
                                            System.out.println("Enter updated Semester: ");
                                            String period = in.next();
                                            String year = in.next();
                                            course.setSemester(period, year);
                                            System.out.println("Successfully Updated! New Semester is: "
                                                    + "\n" + course.getSemester());
                                            break;
                                        }
                                        
                                        
                                    }
                                    break;
