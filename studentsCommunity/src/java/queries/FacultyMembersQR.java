/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queries;

import common.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import models.FacultyMembers;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Yoosuf
 */
public class FacultyMembersQR {

    public static List<FacultyMembers> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction().begin();
        Query q = session.createQuery("select s from FacultyMembers s");
        List<FacultyMembers> l = q.list();
         session.close();
        if (l.size() > 0) {
            return l;
        }

        return new ArrayList<FacultyMembers>();

    }
    public static FacultyMembers getById(int facultyId) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction().begin();
        Query q = session.createQuery("select s from FacultyMembers s where s.facultyId=:id").setParameter("id", facultyId);
        List<FacultyMembers> l = q.list();
         session.close();
        if (l.size() > 0) {
            return l.get(0);
        }

        return null;

    }
    public static List<FacultyMembers> getByName(String name ) {
        name=name.trim().toLowerCase();
        String[] names=name.split(" ");
        String query1="";
        String query2="";
        for(int i=0;i<names.length;i++){
                query1+="lower(s.firstName) like %"+names[i]+"% or ";
                query2+="lower(s.lastName) like %"+names[i]+"% or ";
        }
        
        if(query2.length()>0)
            query2=query2.substring(0,query2.length()-5);
       
       
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction().begin();
        Query q = session.createQuery("select s from FacultyMembers s where "+query1+query2);
        List<FacultyMembers> l = q.list();
         session.close();
        if (l.size() > 0) {
            return l;
        }

        return new ArrayList<FacultyMembers>();

    }
    public static void flush(FacultyMembers obj) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.saveOrUpdate(obj);
        session.getTransaction().commit();
        session.close();
    }

    public static void delete(FacultyMembers obj) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.delete(obj);
        session.getTransaction().commit();
        session.close();
    }

}
