/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import common.Encryption;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import models.Departments;
import models.Students;
import models.Users;
import queries.DepartmentsQR;
import queries.StudentsQR;
import queries.UsersQR;

/**
 *
 * @author Yoosuf
 */
public class StudentRegBean implements java.io.Serializable{

    /**
     * Creates a new instance of StudentRegBean
     */
    
    private String password;
    private String username;
    private String fname;
    private String lname;
   private int deptid;
   private List<Departments> depts;
    
    public StudentRegBean() {
    }
        @PostConstruct
    public void init() {
        depts=DepartmentsQR.getAll();
        
    }

    public void register(){
            int userid;
      
            
         Users us= UsersQR.getByUsername(username);
            if(us!=null){
              FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Username exist !",""));
            return;
            }
            
      try{
            userid=Integer.parseInt(username);
       }catch(NumberFormatException e){
            
             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Username must be your University ID",""));
            return;
       }
        
       if(!username.startsWith("4"))
       {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Username must be your University ID",""));
            return;
       }
       
       for(int i=0;i<10;i++)
       {
           if(fname.contains(i+""))
           {
                 
             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"First Name can't contain any digit numbers ",""));
             return;
           }
          if(lname.contains(i+""))
           {
                 
             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Last Name can't contain any digit numbers",""));
             return;
           }
       
       }
        
            Users u=new Users();
            u.setPassword(Encryption.createMd5(password));
            u.setUserName(username);
            u.setUserType(1);
            u.setUserId(Integer.parseInt(username));
            u.setIsActive(1);
            Students s=new Students();
            s.setFirstName(fname);
            s.setLastName(lname);
            s.setStudentId(Integer.parseInt(username));
            s.setEmail(username+"@student.ksu.edu.sa");
            
            Departments dept=DepartmentsQR.getById(deptid);
            
            
            s.setDepartments(dept);
            
            
            UsersQR.flush(u);
            StudentsQR.flush(s);
            
             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Registration Complete",""));
            
            System.out.println("########################################################3 data saved");
            
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public int getDeptid() {
        return deptid;
    }

    public void setDeptid(int deptid) {
        this.deptid = deptid;
    }

    public List<Departments> getDepts() {
        return depts;
    }

    public void setDepts(List<Departments> depts) {
        this.depts = depts;
    }
    
    
}
