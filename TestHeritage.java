/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.Test;

import java.util.Date;
import ma.projet.beans.Femme;
import ma.projet.beans.Homme;
import ma.projet.beans.Personne;
import ma.projet.service.FemmeService;
import ma.projet.service.HommeService;
import ma.projet.service.PersonneService;

/**
 *
 * @author s
 */
public class TestHeritage {
  /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author s
 */
   public static void main(String[] args) {
        HommeService hs = new HommeService();
        FemmeService fs = new FemmeService();
        PersonneService ps =new PersonneService();
        
       
         
         fs.create(new Femme("laila","lili","02345678","AE34",new Date (12,12,20)));
         hs.create(new Homme("omar","oku","02365678","AE34",new Date (12,12,20)));
         
         for(Personne p : ps.findAll())
             System.out.println(p.getId()+" "+p.getNom()+""+p.getPrenom()+""+p.getTelephon()+""+p.getAdresse()+""+p.getDateNaissance());
    }
            
            
    
} 

  

