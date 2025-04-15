import modele.CentreDeTri;
import modele.PoubelleIntelligente;
import modele.TypePoubelle;

import java.util.Date;

public class CentreDeTriTest {
    public static void main(String[] args) {
        System.out.println("🚀 Début des tests de la classe CentreDeTri...");

        // Création d'un centre de tri
        CentreDeTri centreDeTri = new CentreDeTri("Centre 1", "123 Rue Test", 1, 48.8566, 2.3522, 10.0);

        // Création de poubelles intelligentes
        PoubelleIntelligente poubelle1 = new PoubelleIntelligente(101, 50, TypePoubelle.BLEUE, 48.8566, 2.3522);
        PoubelleIntelligente poubelle2 = new PoubelleIntelligente(102, 100, TypePoubelle.VERTE, 48.8566, 2.3522);

        //  Test 1 : Ajouter des poubelles au centre de tri
        System.out.println("\n Test 1 : Ajouter des poubelles au centre de tri...");
        boolean ajout1 = centreDeTri.ajouterPoubelle(poubelle1);
        boolean ajout2 = centreDeTri.ajouterPoubelle(poubelle2);
        System.out.println("Poubelle 1 ajoutée ? " + ajout1);
        System.out.println("Poubelle 2 ajoutée ? " + ajout2);

        //  Test 2 : Collecter les déchets des poubelles pleines
        System.out.println("\n Test 2 : Collecter les déchets des poubelles pleines...");
        poubelle1.getContenu().put("Plastique", 50.0); // Remplir la poubelle 1
        centreDeTri.collecterDechets();

        //  Test 3 : Générer des statistiques
        System.out.println("\n Test 3 : Générer des statistiques...");
        Date dateDebut = new Date(System.currentTimeMillis() - 86400000); // Hier
        Date dateFin = new Date(); // Aujourd'hui
        centreDeTri.genererStatistiques(dateDebut, dateFin);

        System.out.println("\n Fin des tests.");
    }
}