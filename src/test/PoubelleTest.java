package test;

import modele.*;

import java.util.Date;

public class PoubelleTest {
    public static void main(String[] args) {
        // Création d'une poubelle intelligente
        PoubelleIntelligente poubelle = new PoubelleIntelligente(1, 100, TypePoubelle.JAUNE, 48.85, 2.35);
        System.out.println("✅ Poubelle créée avec ID : " + poubelle.getId());

        // Vérification des getters
        System.out.println("Capacité max : " + poubelle.getCapaciteMaximale());
        System.out.println("Type : " + poubelle.getTypePoubelle());
        System.out.println("Position : (" + poubelle.getLatitude() + ", " + poubelle.getLongitude() + ")");

        // Création d'un ménage
        Menage menage = new Menage(10, "Famille Martin", "XYZ123");
        poubelle.identifierMenage(menage);
        System.out.println("Ménage identifié : " + poubelle.getIdMenage().getNom());

        // Création d’un dépôt conforme
        TypeDechets plastique = TypeDechets.PLASTIQUE; // doit correspondre à JAUNE
        Depot depotConforme = new Depot(poubelle.getId(), new Date(), plastique, 12);
        boolean estConforme = poubelle.verifierConformite(depotConforme);
        System.out.println("✅ Vérification conformité (attendu: true) : " + estConforme);

        // Calcul du poids du dépôt
        int poids = poubelle.calculerQuantiteDechet(depotConforme);
        System.out.println("Poids du dépôt : " + poids + "kg");

        // Attribution de points
        int pointsAttribues = 8;
        poubelle.attribuerPointsFidelite(menage, pointsAttribues);
        System.out.println("Points fidélité après attribution : " + menage.consulterPointsFidelite());

        // Création et notification d’un centre de tri
        CentreDeTri centre = new CentreDeTri("Centre Ouest", 2.35, 48.85);
        poubelle.notifierCentreTri(centre);
    }
}
