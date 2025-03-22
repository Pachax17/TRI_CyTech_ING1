package test;

import modele.PoubelleIntelligente;
import modele.TypePoubelle;
import modele.Menage;
import modele.Depot;
import modele.TypeDechets;

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
    }
}
