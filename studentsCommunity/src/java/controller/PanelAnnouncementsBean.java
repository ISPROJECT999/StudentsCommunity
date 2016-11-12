/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import common.Authorization;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Announcements;
import models.Students;
import queries.AnnouncementsQR;
import queries.StudentsQR;

/**
 *
 * @author Mohammed
 */
public class PanelAnnouncementsBean {

        List<Announcements> announc;
    Announcements selected;
    int studentid;
    /**
     * Creates a new instance of PanelAnnouncementsBean
     */
    public PanelAnnouncementsBean() {
    }
    
   @PostConstruct
    public void init() {
                       FacesContext context = FacesContext.getCurrentInstance();
               HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
               HttpServletResponse response=(HttpServletResponse) context.getExternalContext().getResponse();
               Authorization auth=(Authorization)request.getSession().getAttribute("auth");
               int type=auth.getUserOB().getUserType();
               
               if(type==1){
                  Students s= StudentsQR.getById(auth.getUserOB().getUserId());

                   studentid=s.getStudentId();

               
                    announc=AnnouncementsQR.getByStudentId(s.getStudentId());
               }
    }

    public void delete(int id ,int sid){
            AnnouncementsQR.delete(AnnouncementsQR.getById(id));
    announc=AnnouncementsQR.getByStudentId(sid);
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

    public int getStudentid() {
        return studentid;
    }

    public void setStudentid(int studentid) {
        this.studentid = studentid;
    }
    
    
}
