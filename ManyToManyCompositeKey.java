/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.Test;

/**
 *
 * @author s
 */
import java.util.Date;
import ma.projet.beans.Homme;
import ma.projet.beans.Femme;
import ma.projet.beans.Mariage;
import ma.projet.service.HommeService;
import ma.projet.service.MariageService;
import ma.projet.service.FemmeService;


public class ManyToManyCompositeKey {
public static void main(String[] args) {
        HommeService hs = new HommeService();
       FemmeService fs = new FemmeService();
       MariageService ms = new MariageService();
       
       hs.create(new Homme("tom","olus","02349678","Ar34",new Date (18,12,20)));
       hs.create(new Homme("omar","lili","02345478","Ap34",new Date (12,12,20)));

       fs.create(new Femme("laila","lali","08345678","Ad34",new Date (13,12,20)));
       fs.create(new Femme("kaila","kyli","02645678","Al34",new Date (15,12,20)));
        
       Mariage m = new Mariage(hs.findById(1),fs.findById(3),new Date (13,22,20),4);
       m.setPk(new HommeFemmePK(1,2,new Date(12,03,12)));
       ms.create(m);
        



}}

    


   

