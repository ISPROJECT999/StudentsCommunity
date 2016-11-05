package models;
// Generated Nov 5, 2016 3:27:17 PM by Hibernate Tools 3.6.0



/**
 * FacultyGroupsId generated by hbm2java
 */
public class FacultyGroupsId  implements java.io.Serializable {


     private int facultyId;
     private int groupId;

    public FacultyGroupsId() {
    }

    public FacultyGroupsId(int facultyId, int groupId) {
       this.facultyId = facultyId;
       this.groupId = groupId;
    }
   
    public int getFacultyId() {
        return this.facultyId;
    }
    
    public void setFacultyId(int facultyId) {
        this.facultyId = facultyId;
    }
    public int getGroupId() {
        return this.groupId;
    }
    
    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof FacultyGroupsId) ) return false;
		 FacultyGroupsId castOther = ( FacultyGroupsId ) other; 
         
		 return (this.getFacultyId()==castOther.getFacultyId())
 && (this.getGroupId()==castOther.getGroupId());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getFacultyId();
         result = 37 * result + this.getGroupId();
         return result;
   }   


}


