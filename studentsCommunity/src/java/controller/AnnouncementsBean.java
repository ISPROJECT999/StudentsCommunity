/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.util.List;
import javax.annotation.PostConstruct;
import models.Announcements;
import queries.AnnouncementsQR;
import queries.DegreesQR;

/**
 *
 * @author Yoosuf
 */
public class AnnouncementsBean {

    List<Announcements> announc;
    Announcements selected;
    /**
     * Creates a new instance of AnnouncementsBean
     */
                @PostConstruct
    public void init() {
        announc=AnnouncementsQR.getAll();
        
    }
    
    
    public AnnouncementsBean() {
    }
    public void onRowSelect(){
        System.out.println("Go to desc ###################################3");
    }
    public void onRowUnselect(){
    
    }

    public List<Announcements> getAnnounc() {
        return announc;
    }

    public void setAnnounc(List<Announcements> announc) {
        this.announc = announc;
    }

    public Announcements getSelected() {
        return selected;
    }

    public void setSelected(Announcements selected) {
        this.selected = selected;
    }
    
}
