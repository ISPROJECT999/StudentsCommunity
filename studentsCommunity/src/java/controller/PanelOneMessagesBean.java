/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import common.Authorization;
import common.ChatUsers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.FacultyMembers;
import models.Messages;
import models.Students;
import models.Users;
import org.primefaces.context.RequestContext;
import queries.AnnouncementsQR;
import queries.FacultyMembersQR;
import queries.MessagesQR;
import queries.StudentsQR;
import queries.UsersQR;

/**
 *
 * @author Yooos
 */
public class PanelOneMessagesBean implements java.io.Serializable {

    private List<ChatUsers> usersList;
    private List<Messages> chats;
    private Hashtable<Integer, ChatUsers> usersPic = new Hashtable<Integer, ChatUsers>();
    private int userId;
    public PanelOneMessagesBean() {
    }

    @PostConstruct
    public void init() {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
        Authorization auth = (Authorization) request.getSession().getAttribute("auth");
        int type = auth.getUserOB().getUserType();

        List<Users> users = MessagesQR.getAllOneUsers(auth.getUserOB().getUserId());
        usersList = new ArrayList<ChatUsers>();
        Iterator<Users> uit = users.iterator();

        while (uit.hasNext()) {
            Users u = uit.next();
            ChatUsers cu = new ChatUsers();
            String name = "";
            String pic = "";
            if (u.getUserType() == 1) {
                Students s = StudentsQR.getById(u.getUserId());
                name = s.getFirstName() + " " + s.getLastName();
                pic = s.getStudentPic();
            }
            if (u.getUserType() == 2) {
                FacultyMembers f = FacultyMembersQR.getById(u.getUserId());
                name = f.getFirstName() + " " + f.getLastName();
                //pic=f.getStudentPic();
            }
            cu.setFullName(name);
            cu.setUserId(u.getUserId());
            cu.setUserName(u.getUserName());
            cu.setType(u.getUserType());
            cu.setPic(pic);
            usersList.add(cu);

        }

    }

    public void onLoad(String id) {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
        Authorization auth = (Authorization) request.getSession().getAttribute("auth");
        Users u1 = auth.getUserOB();
        String name = "";
        String pic = "";

        if (u1.getUserType() == 1) {
            Students s = StudentsQR.getById(u1.getUserId());
            name = s.getFirstName() + " " + s.getLastName();
            pic = s.getStudentPic();
        }
        if (u1.getUserType() == 2) {
            FacultyMembers f = FacultyMembersQR.getById(u1.getUserId());
            name = f.getFirstName() + " " + f.getLastName();
            //pic=f.getStudentPic();
        }

        usersPic.put(u1.getUserId(), new ChatUsers(name, u1.getUserName(), u1.getUserId(), u1.getUserType(), pic));

        name = "";
        pic = "";
        Users u2 = UsersQR.getById(Integer.parseInt(id));
        if (u2.getUserType() == 1) {
            Students s = StudentsQR.getById(u2.getUserId());
            name = s.getFirstName() + " " + s.getLastName();
            pic = s.getStudentPic();
        }
        if (u2.getUserType() == 2) {
            FacultyMembers f = FacultyMembersQR.getById(u2.getUserId());
            name = f.getFirstName() + " " + f.getLastName();
            //pic=f.getStudentPic();
        }

        usersPic.put(u2.getUserId(), new ChatUsers(name, u2.getUserName(), u2.getUserId(), u2.getUserType(), pic));
        userId=u2.getUserId();
        chats = MessagesQR.getAllChat(u1.getUserId(), u2.getUserId());
    }
    public String getChatName(int uid){
        return usersPic.get(uid).getFullName();
    }
        public String getChatPic(int uid){
        return usersPic.get(uid).getPic();
    }
    public List<ChatUsers> getUsersList() {
        return usersList;
    }

    public void setUsersList(List<ChatUsers> usersList) {
        this.usersList = usersList;
    }

    public List<Messages> getChats() {
        return chats;
    }

    public void setChats(List<Messages> chats) {
        this.chats = chats;
    }

    public Hashtable<Integer, ChatUsers> getUsersPic() {
        return usersPic;
    }

    public void setUsersPic(Hashtable<Integer, ChatUsers> usersPic) {
        this.usersPic = usersPic;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

}
