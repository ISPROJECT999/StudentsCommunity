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
import queries.AnnouncementsQR;
import queries.DegreesQR;

/**
 *
 * @author Yoosuf
 */
public class AnnouncementsDetailsBean implements java.io.Serializable{

    List<Announcements> announc;
    String title;

    /**
     * Creates a new instance of AnnouncementsBean
     */
              
    public void onLoad(String id){
         System.out.println("66666666666666666666666666 "+id);
      try{
        announc=new ArrayList();
       Announcements a= AnnouncementsQR.getById(Integer.parseInt(id));
       if(a!=null){
           announc.add(a);
           title=a.getTitle();
       }
     }catch(NumberFormatException e){
           System.out.println("EEEEEEEEEEEEEEEEEEEEEEE");
           announc=new ArrayList();
           title="";
      }
    }
                
                

    
    public AnnouncementsDetailsBean() {
    }

    public List<Announcements> getAnnounc() {
        return announc;
    }

    public void setAnnounc(List<Announcements> announc) {
        this.announc = announc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    
}
