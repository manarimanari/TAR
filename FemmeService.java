/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

 
 
package ma.projet.service;

import java.util.Date;
import ma.projet.dao.IDao;

import java.util.List;
import ma.projet.beans.Femme;
import org.hibernate.Session;
import ma.projet.util.HibernateUtil;
import org.hibernate.Query;

/**
 *
 * @author a
 */
public class FemmeService implements IDao<Femme> {

    @Override
    public boolean create(Femme o) {
        Session session ;
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(o);
            session.getTransaction().commit();
            return true;
       
    }

    
    
    

    @Override
    public Femme findById(int id) {
        Session session ;
        Femme e  ;
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            e = (Femme) session.get(Femme.class, id);
            session.getTransaction().commit();
            return e;
        
    }

    @Override
    public List<Femme> findAll() {
        Session session ;
        List<Femme>  femmes ;
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            femmes = session.createQuery("from Femme").list();
            session.getTransaction().commit();
            return femmes;
        
    }
    //une requête native nommée permettant de renvoyer le nombre d’enfants d’une femme donnée entre deux dates
    String hql1=" SELECT COUNT(*) FROM Personne P WHERE P.femme_id = :femmeId AND P.date_naissance BETWEEN :dateDebut AND :dateFin";
    //une méthode dans la classe FemmeService permettant de faire appel à la requêtede la question 4
    public Long findNombreEnfantsFemmeEntreDates(Femme femme, Date dateDebut, Date dateFin) {
    Session session ;
    Long nombreEnfants = null;
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Query query =  session.createQuery(hql1);
                                     query  .setParameter("femmeId", femme.getId());
                                      query .setParameter("dateDebut", dateDebut);
                                     query  .setParameter("dateFin", dateFin);
                                  List results =query.list();

        session.getTransaction().commit();
        return nombreEnfants;
    
}
    //une requête nommée permettant de renvoyer les femmes mariées deux fois ou plus
String hql2="SELECT f.* \n" +
"FROM Femme f \n" +
"JOIN Mariage m ON f.id = m.femme_id \n" +
"GROUP BY f.id \n" +
"HAVING COUNT(m.id) >= 2;";

    public Femme findPlusAgee() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
//une méthode dans permettant de faire appel à la requête de la question 6

 public List<Femme> findFemmesMarieesDeuxFoisOuPlus() {
    Session session = null;
    List<Femme> femmes = null;
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Query query = session.createQuery(hql2);
                     List results2 = query.list();
        session.getTransaction().commit();
        return femmes;
    
}}
