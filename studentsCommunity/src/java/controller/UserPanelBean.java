/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import common.Authorization;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Students;
import queries.StudentsQR;
import queries.TrainingQR;

/**
 *
 * @author Mohammed
 */
public class UserPanelBean implements java.io.Serializable{

    /**
     * Creates a new instance of UserPanelBean
     */
    
    
    private String name;
    private String pic;
    
    
    @PostConstruct
    public void init() {
                                    
               FacesContext context = FacesContext.getCurrentInstance();
               HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
               HttpServletResponse response=(HttpServletResponse) context.getExternalContext().getResponse();
               Authorization auth=(Authorization)request.getSession().getAttribute("auth");
               int type=auth.getUserOB().getUserType();
               
               if(type==1){
                  Students s= StudentsQR.getById(auth.getUserOB().getUserId());
                  name=s.getFirstName()+" "+s.getLastName();
                  pic=s.getStudentPic();
                   
               }else{
               
               
               }
               
               

    }
    public UserPanelBean() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }
    
    
    
    
}
