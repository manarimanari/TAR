/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.beans;


/**
 *
 * @author s
 */
import java.util.Date;
import javax.persistence.Entity;


@Entity


public class Femme extends Personne {
    public Femme(){
    super();
    }
    public Femme(String nom, String prenom, String telephon,String adresse,Date dateNaissance ) {
        super("lala", "lili", "090901234","a14hj",new Date(2023,10,12));
    
}
}
