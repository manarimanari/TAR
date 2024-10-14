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

 
 

import java.util.Date;
import ma.projet.dao.IDao;

import ma.projet.beans.Femme;
import ma.projet.beans.Homme;
import ma.projet.util.HibernateUtil;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.Predicate;
import java.time.LocalDate;
import ma.projet.beans.Mariage;
import org.hibernate.Session;
import java.util.List;
import org.hibernate.Query;
/**
 *
 * @author a
 */
public class HommeService implements IDao<Homme> {
private Mariage mariageRepository;
    @Override
    public boolean create(Homme o) {
        Session session ;
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(o);
            session.getTransaction().commit();
            return true;
        
    }

    
    
    

    @Override
    public Homme findById(int id) {
        Session session ;
        Homme e  ;
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            e = (Homme) session.get(Homme.class, id);
            session.getTransaction().commit();
            return e;
        
    }

    @Override
    public List<Homme> findAll() {
        Session session ;
        List<Homme>  hommes ;
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            hommes = session.createQuery("from Homme").list();
            session.getTransaction().commit();
            return hommes;
        
    }
    public List<Femme> findEpousesHommeEntreDates(Homme homme, Date dateDebut, Date dateFin) {
    Session session ;
    List<Femme> epouses = null;
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Query query = session.createQuery("SELECT f.* \n" +
"FROM Femme f \n" +
"JOIN Mariage m ON f.id = m.femme_id \n" +
"WHERE m.homme_id = :hommeId \n" +
"AND m.date_mariage BETWEEN :dateDebut AND :dateFin;");
                         query .setParameter("hommeId", homme.getId());
                         query .setParameter("dateDebut", dateDebut);
                         query .setParameter("dateFin", dateFin);
                       List results =  query .list();

        session.getTransaction().commit();
        return epouses;
    
}

// une méthode permettant de renvoyer le nombre des hommes qui sont mariés par 4 femmes entre deux dates en utilisant l’API CRITERIA. 

    @PersistenceContext
    private EntityManager entityManager;

    public long countHommesMarieParQuatreFemmesEntreDates(LocalDate dateDebut, LocalDate dateFin) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> query = cb.createQuery(Long.class);
        Root<Homme> hommeRoot = query.from(Homme.class);
        
        // Jointure avec Mariage
        Join<Homme, Mariage> mariageJoin = hommeRoot.join("Mariage");
        // Définir les prédicats
        Predicate datePredicate = cb.between(mariageJoin.get("dateMariage"), dateDebut, dateFin);
        
        // Compter les mariages
        query.select(cb.count(hommeRoot))
             .where(datePredicate)
             .groupBy(hommeRoot.get("id"))
             .having(cb.equal(cb.count(mariageJoin.get("femme")), 4)); // Nombre de femmes

        return entityManager.createQuery(query).getSingleResult();
        
//une méthode permettant de renvoyer les mariages d’un homme donné
    

   public void afficherMariagesHommes(Long hommeId) {
       List<Femme> femmes =null;
       Mariage mariage=null;
       Session session = null;
       Femme femme=null;
        // Récupérer les mariages en cours
       
        List<Mariage> mariagesEnCours = mariage.findMariagesEnCours( session,hommeId);

        System.out.println("Mariages En Cours :");
        int index = 1;
        for (Mariage m : mariagesEnCours) {
            System.out.println(index + ". Femme : " + femme.getNom() + 
                               " Date Début : " + mariage.getPk() + 
                               " Nbr Enfants : " + mariage.getNbrEnfant());
            index++;
        }

        // Récupérer les mariages échoués
        List<Mariage> mariagesEchoues = mariage.findMariagesEchoues(session,hommeId);

        System.out.println("Mariages Échoués :");
        index = 1;
        for (Mariage m : mariagesEchoues) {
            System.out.println(index + ". Femme : " + femme.getNom() + 
                               " Date Début : " + mariage.getPk() + 
                               " Date Fin : " + mariage.getDateFin() + 
                               " Nbr Enfants : " + mariage.getNbrEnfant());
            index++;
    
}
   }
}
   

        
    






