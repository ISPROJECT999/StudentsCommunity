/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queries;

import common.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import models.Messages;
import models.Users;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Mohammed
 */
public class MessagesQR {

    public static List<Users> getAllOneUsers(int u) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction().begin();
        Query q = session.createQuery("select s from Users s,Messages m where (m.usersByReceiver.userId=:u or m.usersBySender.userId=:u) and (m.usersByReceiver.userId=s.userId or m.usersBySender.userId=s.userId) and s.userId!=:u and m.groups is null group by s.userId")
                .setParameter("u", u);
        List<Users> l = q.list();
        session.close();
        if (l.size() > 0) {
            return l;
        }

        return new ArrayList<Users>();

    }

    public static List<Messages> getAllChat(int user1, int user2) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction().begin();
        Query q = session.createQuery("select m from Messages m where (m.usersByReceiver.userId=:u1 or m.usersBySender.userId=:u1) and (m.usersByReceiver.userId=:u2 or m.usersBySender.userId=:u2) and m.groups is null order by m.sendTime")
                .setParameter("u1", user1)
                .setParameter("u2", user2);
        List<Messages> l = q.list();
        session.close();
        if (l.size() > 0) {
            return l;
        }

        return new ArrayList<Messages>();

    }

}
