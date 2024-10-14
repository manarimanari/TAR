/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.Test;

import ma.projet.beans.Femme;
import ma.projet.beans.Homme;
import ma.projet.service.HommeService;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import ma.projet.service.FemmeService;


public class TestProgramme {

    public static void main(String[] args) {
        FemmeService femmeService = new FemmeService();
        HommeService hommeService = new HommeService();

LocalDate dateDebut = LocalDate.of(2000, 1, 1);
        LocalDate dateFin = LocalDate.of(2024, 12, 31);        

       
            // Créer 10 femmes
            Femme femme1 = new Femme("SALIMA", "RAMI","09090234","lklkl1", new Date(01,01,1975));
            Femme femme2 = new Femme("AMAL", "ALI","09090834","lklkl2", new Date(15,06,1980));
            Femme femme3 = new Femme("WAFA", "ALAOUI","09050234","lklkl3", new Date(20,03,1985));
            Femme femme4 = new Femme("KARIMA", "ALAMI", "08890234","lklkl4",new Date(03,17,1965));
            Femme femme5 = new Femme("NAIMA", "BENALI","09097234","lklkl5", new Date(22,11,1978));
            Femme femme6 = new Femme("FATIMA", "ELHOUSSAINE", "06090234","lklkl6",new Date(05,04,1970));
            Femme femme7 = new Femme("AYMANE", "TOUISSI", "09095234","lklkl7",new Date(10,11,1977));
            Femme femme8 = new Femme("IMANE", "OUARDA","09090236","lklkl8", new Date(13,10,1982));
            Femme femme9 = new Femme("HANA", "KADOUSSI", "09090334","lklkl9",new Date(25,12,1975));
            Femme femme10 = new Femme("LAYLA", "MAHMOUDI", "09030234","lklkl10",new Date(14,02,1971));

            femmeService.create(femme1);
            femmeService.create(femme2);
            femmeService.create(femme3);
            femmeService.create(femme4);
            femmeService.create(femme5);
            femmeService.create(femme6);
            femmeService.create(femme7);
            femmeService.create(femme8);
            femmeService.create(femme9);
            femmeService.create(femme10);

            // Créer 5 hommes
            Homme homme1 = new Homme("SAID", "SAFI","09090234","lklkl1", new Date(01,11,1975 ));
            Homme homme2 = new Homme("MOHAMED", "LAHLOU", "09090234","lklkl1", new Date(02,01,1975));
            Homme homme3 = new Homme("AHMED", "BENJELLOUN", "09090234","lklkl1", new Date(02,11,1975));
            Homme homme4 = new Homme("YASSINE", "ZARHOUNI","09090234","lklkl1", new Date(12,01,1975 ));
            Homme homme5 = new Homme("OMAR", "BAKKALI","09090234","lklkl1", new Date(13,01,1975));

            hommeService.create(homme1);
            hommeService.create(homme2);
            hommeService.create(homme3);
            hommeService.create(homme4);
            hommeService.create(homme5);

            // 1. Afficher la liste des femmes
            List<Femme> femmes = femmeService.findAll();
            System.out.println("Liste des femmes :");
            for (Femme f : femmes) {
                System.out.println(f);
            }

            // 2. Afficher la femme la plus âgée
            Femme plusAgee = femmeService.findPlusAgee();
            System.out.println("La femme la plus âgée : " + plusAgee);

            // 3. Afficher les épouses d’un homme passé en paramètre
            List<Femme> epouses = hommeService.findEpousesHommeEntreDates(homme1, new Date(01,01,1990),new Date(01,01,2020));
            System.out.println("Les épouses de " + homme1.getNom() + " entre deux dates :");
            for (Femme f : epouses) {
                System.out.println(f);
            }

            // 4. Afficher le nombre d’enfants d’une femme passée en paramètre entre deux dates
            int nombreEnfants = femmeService.findNombreEnfantsFemmeEntreDates(femme1, new Date(11,01,1990),new Date(11,10,2020));
            System.out.println("Nombre d'enfants de " + femme1.getNom() + " entre deux dates : " + nombreEnfants);

            // 5. Afficher la liste des femmes mariées deux fois ou plus
            List<Femme> femmesMarieesDeuxFois = femmeService.findFemmesMarieesDeuxFoisOuPlus();
            System.out.println("Femmes mariées deux fois ou plus :");
            for (Femme f : femmesMarieesDeuxFois) {
                System.out.println(f);
            }

            
        

        // Appeler la méthode qui retourne la liste des hommes mariés à 4 femmes ou plus
        
        long hommesMarieesPar4Femmes = hommeService.countHommesMarieParQuatreFemmesEntreDates(dateDebut, dateFin);
        
        System.out.println("Hommes mariés par 4 femmes entre deux dates :");
        for (Homme h : hommesMarieesPar4Femmes) {
            System.out.println(h); // Assurez-vous que la classe Homme a une méthode toString() appropriée
        }
    


             

            // 7. Afficher les mariages d’un homme passé en paramètre
            hommeService.afficherMariagesHommes(3L);

    }}





