/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.beans;

import java.util.Date;
import java.util.List;
import javax.persistence.EmbeddedId;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import ma.projet.Test.HommeFemmePK;
import org.hibernate.Query;


import org.hibernate.Session;

/**
 *
 * @author s
 */
@Entity
public class Mariage {

   @EmbeddedId
  private HommeFemmePK pk; 
   @ManyToOne
        @JoinColumn(name = "homme",insertable=false,updatable= false)
private Homme homme;
   @ManyToOne
        @JoinColumn(name = "femme",insertable=false,updatable= false)
private Femme femme;
   private Date dateFin;

private int nbrEnfant;

    // Constructeurs, getters et setters

    public Mariage() {}

    public Mariage(Homme homme, Femme femme, Date dateFin, int nbrEnfant) {
        this.homme = homme;
        this.femme = femme;
        this.dateFin = dateFin;
        this.nbrEnfant = nbrEnfant;
    }

    public HommeFemmePK getPk() {
        return pk;
    }

    public void setPk(HommeFemmePK pk) {
        this.pk = pk;
    }

    public Homme getHomme() {
        return homme;
    }

    public void setHomme(Homme homme) {
        this.homme = homme;
    }

    public Femme getFemme() {
        return femme;
    }

    public void setFemme(Femme femme) {
        this.femme = femme;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public int getNbrEnfant() {
        return nbrEnfant;
    }

    public void setNbrEnfant(int nbrEnfant) {
        this.nbrEnfant = nbrEnfant;
    }

    
// Méthodes pour récupérer les mariages
    public static List<Mariage> findMariagesEnCours(Long hommeId) {
        Session session =null;
        Query query = session.createQuery("SELECT m FROM Mariage m WHERE m.homme.id = :hommeId AND m.dateFin IS NULL");
                 query .setParameter("hommeId", hommeId);
               List results= query  .list();
               return results;
    }

    public static List<Mariage> findMariagesEchoues( Long hommeId) {
        Session session =null;
         Query query = session.createQuery("SELECT m FROM Mariage m WHERE m.homme.id = :hommeId AND m.dateFin IS NOT NULL");
                 query .setParameter("hommeId", hommeId);
               List results= query .list();
return results;}    

   
}
  

