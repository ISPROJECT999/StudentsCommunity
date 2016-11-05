/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import models.Announcements;
import models.Training;
import queries.AnnouncementsQR;
import queries.DegreesQR;
import queries.TrainingQR;

/**
 *
 * @author Yoosuf
 */
public class TrainingDetailsBean implements java.io.Serializable{

    List<Training> training;
    String title;

    /**
     * Creates a new instance of AnnouncementsBean
     */
              
    public void onLoad(String id){
         System.out.println("66666666666666666666666666 "+id);
      try{
        training=new ArrayList();
       Training a= TrainingQR.getById(Integer.parseInt(id));
       if(a!=null){
           training.add(a);
           title=a.getTrainTitle();
       }
     }catch(NumberFormatException e){
           System.out.println("EEEEEEEEEEEEEEEEEEEEEEE");
           training=new ArrayList();
           title="";
      }
    }
                
                

    
    public TrainingDetailsBean() {
    }

    public List<Training> getTraining() {
        return training;
    }

    public void setTraining(List<Training> training) {
        this.training = training;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

   
    
}
