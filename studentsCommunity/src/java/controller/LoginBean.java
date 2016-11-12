/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import com.sun.xml.ws.security.impl.policy.Constants;
import common.Authorization;
import common.Encryption;
import java.io.IOException;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Users;
import queries.UsersQR;

/**
 *
 * @author Yoosuf
 */
public class LoginBean {

    /**
     * Creates a new instance of LoginBean
     */
    private String username;
    private String password;
    
    public LoginBean() {
    }
    
    public void login() throws IOException{
//        
//                  Users us= UsersQR.getById(433101070);
//                 us.setPassword(Encryption.createMd5("123456"));
//                 UsersQR.flush(us);
                 
            if(username.equals("") || password.equals(""))
            {
            }else{
                Users u=UsersQR.userAuth(username,Encryption.createMd5(password));
                if(u!=null){
                   
                               
                FacesContext context = FacesContext.getCurrentInstance();
                HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
               HttpServletResponse response=(HttpServletResponse) context.getExternalContext().getResponse();
                request.getSession().setAttribute("auth", new Authorization(u));

                 response.sendRedirect(request.getContextPath()+"/faces/panel/index.xhtml");   
            }else{
            
            }
 
                
            
            
            }
    }
       public void logout() throws IOException{
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        HttpServletResponse response=(HttpServletResponse) context.getExternalContext().getResponse();
        request.getSession().removeAttribute("auth");
        response.sendRedirect(request.getContextPath()+"/faces/index.xhtml");
    
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
