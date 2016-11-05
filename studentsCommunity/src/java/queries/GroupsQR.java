/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queries;

import common.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import models.Groups;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Yoosuf
 */
public class GroupsQR {

    public static List<Groups> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction().begin();
        Query q = session.createQuery("select s from Groups s");
        List<Groups> l = q.list();
         session.close();
        if (l.size() > 0) {
            return l;
        }

        return new ArrayList<Groups>();

    }
    public static Groups getById(int studentId) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction().begin();
        Query q = session.createQuery("select s from Groups s where s.groupId=:id").setParameter("id", studentId);
        List<Groups> l = q.list();
         session.close();
        if (l.size() > 0) {
            return l.get(0);
        }

        return null;

    }
        public static Groups getByName(String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction().begin();
        Query q = session.createQuery("select s from Groups s where s.name=:name").setParameter("name", name);
        List<Groups> l = q.list();
         session.close();
        if (l.size() > 0) {
            return l.get(0);
        }

        return null;

    }
    public static void flush(Groups obj) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.saveOrUpdate(obj);
        session.getTransaction().commit();
        session.close();
    }

    public static void delete(Groups obj) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.delete(obj);
        session.getTransaction().commit();
        session.close();
    }

}
