/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.service;

/**
 *
 * @author s
 */


import ma.projet.dao.IDao;

import java.util.List;
import ma.projet.beans.Mariage;
import org.hibernate.Session;
import ma.projet.util.HibernateUtil;

/**
 *
 * @author a
 */
public class MariageService implements IDao<Mariage> {

    @Override
    public boolean create(Mariage o) {
        Session session ;
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(o);
            session.getTransaction().commit();
            return true;
        
    }

    
    
    

    @Override
    public Mariage findById(int id) {
        Session session ;
        Mariage e  ;
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            e = (Mariage) session.get(Mariage.class, id);
            session.getTransaction().commit();
            return e;
        
    }

    @Override
    public List<Mariage> findAll() {
        Session session ;
        List<Mariage>  mariages ;
       
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            mariages = session.createQuery("from Mariage").list();
            session.getTransaction().commit();
            return mariages;
        
    }
}   

