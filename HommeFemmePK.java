/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.Test;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Embeddable;
/**
 *
 * @author s
 */
@ Embeddable
public class HommeFemmePK implements Serializable{
    
    private int homme;
    private int femme;
    private Date dateDebut;
    public  HommeFemmePK (){}

    public HommeFemmePK(int homme, int femme, Date dateDebut) {
        this.homme = homme;
        this.femme = femme;
        this.dateDebut = dateDebut;
    }

    public int getHomme() {
        return homme;
    }

    public void setHomme(int homme) {
        this.homme = homme;
    }

    public int getFemme() {
        return femme;
    }

    public void setFemme(int femme) {
        this.femme = femme;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }
    
}
