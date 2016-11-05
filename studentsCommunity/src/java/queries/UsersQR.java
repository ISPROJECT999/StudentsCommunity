/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queries;

import common.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import models.Users;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Yoosuf
 */
public class UsersQR {

    public static List<Users> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction().begin();
        Query q = session.createQuery("select s from Users s");
        List<Users> l = q.list();
        session.close();
        if (l.size() > 0) {
            return l;
        }

        return new ArrayList<Users>();

    }

    public static Users getById(int userId) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction().begin();
        Query q = session.createQuery("select s from Users s where s.userId=:id").setParameter("id", userId);
        List<Users> l = q.list();
        session.close();
        if (l.size() > 0) {
            return l.get(0);
        }

        return null;

    }

    public static Users getByUsername(String userName) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction().begin();
        Query q = session.createQuery("select s from Users s where s.userName=:u").setParameter("u", userName);
        List<Users> l = q.list();
        session.close();
        if (l.size() > 0) {
            return l.get(0);
        }

        return null;

    }

    public static Users userAuth(String userName,String pass) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        
        Query q = session.createQuery("select s from Users s where s.userName=:u and s.password=:p and s.isActive=1")
                .setParameter("u", userName)
                .setParameter("p", pass);
        List<Users> l = q.list();
        session.close();
        if (l.size() > 0) {
            return l.get(0);
        }

        return null;

    }

    public static void flush(Users obj) {

        Session session = HibernateUtil.getSessionFactory().openSession();
       session.getTransaction().begin();
        session.saveOrUpdate(obj);
       session.getTransaction().commit();
        session.close();
    }

    public static void delete(Users obj) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.delete(obj);
        session.getTransaction().commit();
        session.close();
    }

}
