/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package common;

/**
 *
 * @author Mohammed
 */
public class ChatUsers {
    private String fullName;
    private String userName;
    private int userId;
    private int type;
    private String pic;

    public ChatUsers() {
    }

    public ChatUsers(String fullName, String userName, int userId, int type, String pic) {
        this.fullName = fullName;
        this.userName = userName;
        this.userId = userId;
        this.type = type;
        this.pic = pic;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }
    
    
    
    
}
