/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queries;

import common.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import models.Training;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Yoosuf
 */
public class TrainingQR {

    public static List<Training> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction().begin();
        Query q = session.createQuery("select s from Training s left join fetch s.students");
        List<Training> l = q.list();
         session.close();
        if (l.size() > 0) {
            return l;
        }

        return new ArrayList<Training>();

    }
    public static Training getById(int trainId) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction().begin();
        Query q = session.createQuery("select s from Training s where s.trainId=:id").setParameter("id", trainId);
        List<Training> l = q.list();
         session.close();
        if (l.size() > 0) {
            return l.get(0);
        }

        return null;

    }
        public static List<Training> getByStudentId(int studentId) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction().begin();
        Query q = session.createQuery("select s from Training s where s.students.studentId=:id");
        q.setParameter("id", studentId);
        List<Training> l = q.list();
         session.close();
        if (l.size() > 0) {
            return l;
        }

        return new ArrayList<Training>();

    }
        
            
        
    
           public static List<Training> getByPlace(String title) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction().begin();
        Query q = session.createQuery("select s from Training s where s.trainPlace like :title").setParameter("title", "%"+title+"%");
        List<Training> l = q.list();
         session.close();
        if (l.size() > 0) {
            return l;
        }

        return new ArrayList<Training>();

    }        
    
           public static List<Training> getByTitle(String title) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction().begin();
        Query q = session.createQuery("select s from Training s where s.trainTitle like %:title%").setParameter("title", title);
        List<Training> l = q.list();
         session.close();
        if (l.size() > 0) {
            return l;
        }

        return new ArrayList<Training>();

    }     
    public static void flush(Training obj) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.saveOrUpdate(obj);
        session.getTransaction().commit();
        session.close();
    }

    public static void delete(Training obj) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.delete(obj);
        session.getTransaction().commit();
        session.close();
    }

}
