/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package common;

import java.util.Hashtable;
import java.util.List;
import models.Users;
import queries.UsersQR;

/**
 *
 * @author Admin
 */
public class Authorization {
    private boolean login;
    private String username;
    private Users userOB;
    private Hashtable privileges;

    public Authorization(Users userOB) {
        this.username = userOB.getUserName();
        this.userOB = userOB;
       
        
        this.login=true;
    }

    public boolean isLogin() {
        return login;
    }

    public String getUsername() {
        return username;
    }

    public void setIsLogin(boolean login) {
        this.login = login;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setUserOB(Users userOB) {
        this.userOB = userOB;
    }

    public Users getUserOB() {
        return userOB;
    }

    public Hashtable getPrivileges() {
        return privileges;
    }

    public void setLogin(boolean login) {
        this.login = login;
    }

    public void setPrivileges(Hashtable privileges) {
        this.privileges = privileges;
    }


    
}
