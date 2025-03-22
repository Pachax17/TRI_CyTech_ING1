package test;

import modele.PoubelleIntelligente;
import modele.TypePoubelle;
import modele.Menage;
import modele.Depot;
import modele.TypeDechets;


public class PoubelleTest {
    public static void main(String[] args) {
        System.out.println("Début du test PoubelleIntelligente...");

        // Création d'une poubelle intelligente
        PoubelleIntelligente poubelle = new PoubelleIntelligente(1, 50, TypePoubelle.JAUNE, 48.8566, 2.3522);
        System.out.println("✅ Poubelle créée : " + poubelle.getTypePoubelle());

        // Identification d'un ménage
        Menage menage = new Menage(1, "MOMO", "1234");
        poubelle.identifierMenage(menage);
        System.out.println("✅ Ménage identifié : " + poubelle.getIdMenage().getId());

        // Vérification de la contrainte de déchets
        Depot depot = new Depot(1, null, TypeDechets.PAPIER, 55); // Simule un dépôt
        boolean contrainteRespectee = poubelle.verifierContrainteDechets(depot);
        System.out.println("✅ Vérification de la contrainte de déchets : " + contrainteRespectee);

        // Attribution de points fidélité
        poubelle.attribuerPointsFidelite(menage, 10);
        System.out.println("✅ Points fidélité attribués. Nouveau total : " + menage.consulterPointsFidelite());

        // Notification du centre de tri
        // CentreDeTri centre = new CentreDeTri(1, "Centre Paris", 48.8566, 2.3522, 0.02);
        // poubelle.notifierCentreTri(centre);

        System.out.println("Test terminé.");
    }
}
