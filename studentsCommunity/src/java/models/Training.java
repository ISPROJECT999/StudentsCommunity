package models;
// Generated Nov 14, 2016 9:44:25 PM by Hibernate Tools 3.6.0


import java.util.Date;

/**
 * Training generated by hbm2java
 */
public class Training  implements java.io.Serializable {


     private Integer trainId;
     private Students students;
     private String trainDesc;
     private String trainTitle;
     private String trainPlace;
     private Date trainDate;
     private int evaluation;

    public Training() {
    }

    public Training(Students students, String trainDesc, String trainTitle, String trainPlace, Date trainDate, int evaluation) {
       this.students = students;
       this.trainDesc = trainDesc;
       this.trainTitle = trainTitle;
       this.trainPlace = trainPlace;
       this.trainDate = trainDate;
       this.evaluation = evaluation;
    }
   
    public Integer getTrainId() {
        return this.trainId;
    }
    
    public void setTrainId(Integer trainId) {
        this.trainId = trainId;
    }
    public Students getStudents() {
        return this.students;
    }
    
    public void setStudents(Students students) {
        this.students = students;
    }
    public String getTrainDesc() {
        return this.trainDesc;
    }
    
    public void setTrainDesc(String trainDesc) {
        this.trainDesc = trainDesc;
    }
    public String getTrainTitle() {
        return this.trainTitle;
    }
    
    public void setTrainTitle(String trainTitle) {
        this.trainTitle = trainTitle;
    }
    public String getTrainPlace() {
        return this.trainPlace;
    }
    
    public void setTrainPlace(String trainPlace) {
        this.trainPlace = trainPlace;
    }
    public Date getTrainDate() {
        return this.trainDate;
    }
    
    public void setTrainDate(Date trainDate) {
        this.trainDate = trainDate;
    }
    public int getEvaluation() {
        return this.evaluation;
    }
    
    public void setEvaluation(int evaluation) {
        this.evaluation = evaluation;
    }




}


