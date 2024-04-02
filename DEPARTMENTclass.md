
package Project1;


public class Department {
    
    // Data Fields
    public String name;
    public int deptID;
    public int deptPop;
    private Faculty[] members;
    
    // Constructors
    
    public Department() {
        
        this.name = "n/a";
        this.deptID = 0;
        this.deptPop = 0;
        this.members = new Faculty[300];
    }
    
    public Department(String name, int deptID, int deptPop) {
        
        this.name = name;
        this.deptID = deptID;
        this.deptPop = deptPop;
        this.members = new Faculty[300];
        
    }
    
    
    // Member Methods
    
    public int countFaculty(Faculty[] facultyArray, Department dept) {
        // initiliaze counter
        int counter = 0;
        for (Faculty member: facultyArray) {
            if (member.getDepartment().equals(dept))
            {
                counter++;
            }
        }
        return counter;
    }
    
    public void addMembers(Faculty faculty) {
        for (int i = 0; i < members.length; i++)
        {
            if (members[i] == null)
                members[i] = faculty;
        }
    }
}
