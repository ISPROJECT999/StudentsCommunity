package models;
// Generated Nov 14, 2016 9:44:25 PM by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;

/**
 * Officehours generated by hbm2java
 */
public class Officehours  implements java.io.Serializable {


     private OfficehoursId id;
     private FacultyMembers facultyMembers;
     private Set requestses = new HashSet(0);

    public Officehours() {
    }

	
    public Officehours(OfficehoursId id, FacultyMembers facultyMembers) {
        this.id = id;
        this.facultyMembers = facultyMembers;
    }
    public Officehours(OfficehoursId id, FacultyMembers facultyMembers, Set requestses) {
       this.id = id;
       this.facultyMembers = facultyMembers;
       this.requestses = requestses;
    }
   
    public OfficehoursId getId() {
        return this.id;
    }
    
    public void setId(OfficehoursId id) {
        this.id = id;
    }
    public FacultyMembers getFacultyMembers() {
        return this.facultyMembers;
    }
    
    public void setFacultyMembers(FacultyMembers facultyMembers) {
        this.facultyMembers = facultyMembers;
    }
    public Set getRequestses() {
        return this.requestses;
    }
    
    public void setRequestses(Set requestses) {
        this.requestses = requestses;
    }




}


