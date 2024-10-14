/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.beans;




import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;



@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Personne {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   
    protected int id;

    
    protected String nom;

    
   
    protected String prenom;

    protected String telephon;

    protected String adresse;

    protected Date dateNaissance ;


    // Constructeurs, getters et setters

    public Personne () {}

    public Personne (String nom, String prenom, String telephon,String adresse, Date dateNaissance ) {
        this.nom=nom;
        
        this.prenom =prenom;
       this.telephon = telephon;
   this.adresse=adresse;
   this.dateNaissance=dateNaissance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom ) {
        this.nom = nom ;
    }
    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom ) {
        this.prenom = prenom ;
    }
    public String getTelephon() {
        return telephon;
    }

    public void setTelephon(String telephon ) {
        this.telephon = telephon ;
    }
     public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse ) {
        this.adresse = adresse ;
    }
    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance ) {
        this.dateNaissance = dateNaissance ;
    }

}

  



   

