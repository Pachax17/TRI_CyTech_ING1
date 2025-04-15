import modele.*;

import java.util.Date;

public class PoubelleTest {
    public static void main(String[] args) {

        System.out.println("🚀 Début des tests de la classe PoubelleIntelligente...");

        // Création d'une poubelle intelligente
        PoubelleIntelligente poubelle = new PoubelleIntelligente(101, 50, TypePoubelle.BLEUE, 48.8566, 2.3522);

        // Création d'un ménage
        Menage menage = new Menage(1, "Dupont", "ABC123");

        // Création d'un dépôt de déchets
        Depot depot = new Depot(101, new Date(), TypeDechets.PLASTIQUE, 5);

        // 🔹 Test 1 : Identifier un ménage
        System.out.println("\n🔹 Test 1 : Identifier un ménage...");
        poubelle.identifierMenage(menage);
        System.out.println("✅ Ménage identifié : " + poubelle.getIdMenage().getNom());

        // 🔹 Test 2 : Vérifier la contrainte de déchets
        System.out.println("\n🔹 Test 2 : Vérifier la contrainte de déchets...");
        boolean contrainteRespectee = poubelle.verifierContrainteDechets(depot);
        System.out.println("Contrainte respectée ? " + contrainteRespectee);

        // 🔹 Test 3 : Calculer la quantité de déchets
        System.out.println("\n🔹 Test 3 : Calculer la quantité de déchets...");
        int quantiteDechets = poubelle.calculerQuantiteDechet(depot);
        System.out.println("Quantité de déchets calculée : " + quantiteDechets);

        // 🔹 Test 4 : Attribuer des points de fidélité
        System.out.println("\n🔹 Test 4 : Attribuer des points de fidélité...");
        poubelle.attribuerPointsFidelite(menage, 10);
        System.out.println("Points de fidélité attribués : " + menage.consulterPointsFidelite());

        // 🔹 Test 5 : Vérifier si la poubelle est pleine
        System.out.println("\n🔹 Test 5 : Vérifier si la poubelle est pleine...");
        boolean estPleine = poubelle.estPleine();
        System.out.println("La poubelle est pleine ? " + estPleine);

        // 🔹 Test 6 : Vider la poubelle
        System.out.println("\n🔹 Test 6 : Vider la poubelle...");
        poubelle.viderPoubelle();
        System.out.println("✅ Poubelle vidée. Contenu actuel : " + poubelle.getContenu());

        System.out.println("\n✅ Fin des tests.");

        // Création d'une poubelle intelligente
         poubelle = new PoubelleIntelligente(1, 100, TypePoubelle.JAUNE, 48.85, 2.35);
        System.out.println("✅ Poubelle créée avec ID : " + poubelle.getId());

        // Vérification des getters
        System.out.println("Capacité max : " + poubelle.getCapaciteMaximale());
        System.out.println("Type : " + poubelle.getTypePoubelle());
        System.out.println("Position : (" + poubelle.getLatitude() + ", " + poubelle.getLongitude() + ")");

        // Création d'un ménage
         menage = new Menage(10, "Famille Martin", "XYZ123");
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
        CentreDeTri centre = new CentreDeTri("Centre Ouest", "6 rue de Mars", 48, 45.2, 36, 50);
        poubelle.notifierCentreTri(centre);

    }
}
