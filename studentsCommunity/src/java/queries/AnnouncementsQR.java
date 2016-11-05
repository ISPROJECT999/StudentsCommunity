/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queries;

import common.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import models.Announcements;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Yoosuf
 */
public class AnnouncementsQR {

    public static List<Announcements> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction().begin();
        Query q = session.createQuery("select s from Announcements s left join fetch s.students");
        List<Announcements> l = q.list();
         session.close();
        if (l.size() > 0) {
            return l;
        }

        return new ArrayList<Announcements>();

    }
    public static Announcements getById(int annId) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction().begin();
        Query q = session.createQuery("select s from Announcements s where s.annId=:id").setParameter("id", annId);
        List<Announcements> l = q.list();
         session.close();
        if (l.size() > 0) {
            return l.get(0);
        }

        return null;

    }
        public static List<Announcements> getByStudentId(int studentId) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction().begin();
        Query q = session.createQuery("select s from Announcements s where s.students.studentId=:id");
        q.setParameter("id", studentId);
        List<Announcements> l = q.list();
         session.close();
        if (l.size() > 0) {
            return l;
        }

        return new ArrayList<Announcements>();

    }
    
           public static List<Announcements> getByTitle(String title) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction().begin();
        Query q = session.createQuery("select s from Announcements s where s.title like %:title%").setParameter("title", title);
        List<Announcements> l = q.list();
         session.close();
        if (l.size() > 0) {
            return l;
        }

        return new ArrayList<Announcements>();

    }     
    public static void flush(Announcements obj) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.saveOrUpdate(obj);
        session.getTransaction().commit();
        session.close();
    }

    public static void delete(Announcements obj) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.delete(obj);
        session.getTransaction().commit();
        session.close();
    }

}
