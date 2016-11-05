/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queries;

import common.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import models.Students;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Yoosuf
 */
public class StudentsQR {

    public static List<Students> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction().begin();
        Query q = session.createQuery("select s from Students s");
        List<Students> l = q.list();
         session.close();
        if (l.size() > 0) {
            return l;
        }

        return new ArrayList<Students>();

    }
    public static Students getById(int studentId) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction().begin();
        Query q = session.createQuery("select s from Students s where s.studentId=:id").setParameter("id", studentId);
        List<Students> l = q.list();
         session.close();
        if (l.size() > 0) {
            return l.get(0);
        }

        return null;

    }
    public static void flush(Students obj) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.saveOrUpdate(obj);
        session.getTransaction().commit();
        session.close();
    }

    public static void delete(Students obj) {

        Session session = HibernateUtil.getSessionFactory().openSession();
       session.getTransaction().begin();
        session.delete(obj);
        session.getTransaction().commit();
        session.close();
    }

}
