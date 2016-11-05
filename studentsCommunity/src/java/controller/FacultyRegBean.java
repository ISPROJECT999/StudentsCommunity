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
import models.Degrees;
import models.Departments;
import models.FacultyMembers;
import models.Students;
import models.Users;
import queries.DegreesQR;
import queries.DepartmentsQR;
import queries.FacultyMembersQR;
import queries.StudentsQR;
import queries.UsersQR;

/**
 *
 * @author Yoosuf
 */
public class FacultyRegBean {

    private String password;
    private String username;
    private String facultyid;
    private String fname;
    private String lname;
    private int degreeid;
    private List<Degrees> degrees;

    /**
     * Creates a new instance of FacultyRegBean
     */
    
            @PostConstruct
    public void init() {
        degrees=DegreesQR.getAll();
        
    }
    
    public FacultyRegBean() {
    }

    public void register() {

        
        int fid;
        Users us = UsersQR.getByUsername(username);
        if (us != null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Username exist !", ""));
            return;
        }

        try {
            fid = Integer.parseInt(facultyid);
        } catch (NumberFormatException e) {

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Faculty number must be your Employee ID", ""));
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (fname.contains(i + "")) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "First Name can't contain any digit numbers ", ""));
                return;
            }
            if (lname.contains(i + "")) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Last Name can't contain any digit numbers", ""));
                return;
            }
        }

            Users u = new Users();
            u.setPassword(Encryption.createMd5(password));
            u.setUserName(username);
            u.setUserType(2);
            u.setUserId(fid);
            u.setIsActive(0);

            FacultyMembers s = new FacultyMembers();
            s.setFirstName(fname);
            s.setLastName(lname);
            s.setFacultyId(fid);
            s.setEmail(username + "@ksu.edu.sa");

            Degrees degree = DegreesQR.getById(degreeid);

            s.setDegrees(degree);

            UsersQR.flush(u);
            FacultyMembersQR.flush(s);

             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registration Complete  wait for approval", ""));

            
        }

    

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public String getFacultyid() {
        return facultyid;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public int getDegreeid() {
        return degreeid;
    }

    public List<Degrees> getDegrees() {
        return degrees;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setFacultyid(String facultyid) {
        this.facultyid = facultyid;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public void setDegreeid(int degreeid) {
        this.degreeid = degreeid;
    }

    public void setDegrees(List<Degrees> degrees) {
        this.degrees = degrees;
    }

}
