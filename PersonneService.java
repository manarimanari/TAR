/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.service;

import java.util.List;
import ma.projet.beans.Personne;
import ma.projet.util.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author s
 */
public class PersonneService {
    public boolean create(Personne o) {
        Session session ;
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(o);
            session.getTransaction().commit();
            return true;
        
    }

    
    
     public Personne findById(int id) {
        Session session ;
        Personne e  ;
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            e = (Personne) session.get(Personne.class, id);
            session.getTransaction().commit();
            return e;
        
    }

    public List<Personne> findAll() {
        Session session;
        List<Personne>  personnes ;
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            personnes = session.createQuery("from Personne").list();
            session.getTransaction().commit();
            return personnes;
        
    }
}
    
    
    

    