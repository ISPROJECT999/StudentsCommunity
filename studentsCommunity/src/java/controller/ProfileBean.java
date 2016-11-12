/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import common.Authorization;
import common.Encryption;
import common.Uploader;
import java.io.IOException;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Students;
import models.Users;
import org.primefaces.model.UploadedFile;
import queries.StudentsQR;
import queries.UsersQR;

/**
 *
 * @author Mohammed
 */
public class ProfileBean implements java.io.Serializable{

    private int type;
    private String fname;
    private String lname;
    private String password;
    private UploadedFile pic;
    private Object user;
    
    /**
     * Creates a new instance of ProfileBean
     */
    public ProfileBean() {
    }
    
    
        @PostConstruct
    public void init() {
               FacesContext context = FacesContext.getCurrentInstance();
               HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
               HttpServletResponse response=(HttpServletResponse) context.getExternalContext().getResponse();
               Authorization auth=(Authorization)request.getSession().getAttribute("auth");
                type=auth.getUserOB().getUserType();
             
               if(type==1){
                  Students s= StudentsQR.getById(auth.getUserOB().getUserId());
                  user=s;
                  lname=s.getLastName();
                  fname=s.getFirstName();

                  
                  
               }else{
               
               
               }               
    }
    
    
    
    public void save() {
        
        
        
                System.out.println("################################################");
    
             if(fname.equals(""))
             {
                 return;
             }
             if(lname.equals(""))
             { return;}

          
       for(int i=0;i<10;i++)
       {
           if(fname.contains(i+""))
           {
                 
                     return;
           }
          if(lname.contains(i+""))
           {
                   return;
           }
       }
   
        if(type==1){
            Students s=(Students)user;
            s.setFirstName(fname);
            s.setLastName(lname);
            
             
            
            
            if(!password.equals("")){
                Users u= UsersQR.getById(s.getStudentId());
                 u.setPassword(Encryption.createMd5(password));
                 UsersQR.flush(u);
            }
            
            
            StudentsQR.flush(s);
            
        }
       
       
        
        
    String up_path="C:\\Users\\Mohammed\\Downloads\\5112016\\studentsCommunity\\web\\userPic\\";
    

//          try{
//                    if(pic.getSize()>0){
//                           String fname=((Students)user).getStudentId()+"-"+pic.getFileName();
//                           Uploader.copyFile(up_path,fname , pic.getInputstream());
//                          // obj.setAnswerIcon(fname);
//                       }
//            }catch(IOException e){
//                e.printStackTrace();
//            }
    }
    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public UploadedFile getPic() {
        return pic;
    }

    public void setPic(UploadedFile pic) {
        this.pic = pic;
    }

    public Object getUser() {
        return user;
    }

    public void setUser(Object user) {
        this.user = user;
    }
 
    
    
    
}
