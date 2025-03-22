package test;

import modele.Menage;
import modele.PoubelleIntelligente;
import modele.Depot;
import modele.TypePoubelle;
import modele.BonAchat;

import java.util.Date;

public class MenageTest {
    public static void main(String[] args) {
        System.out.println("🚀 Début des tests de la classe Menage...");

        // Création d'un ménage
        Menage menage = new Menage(1, "Dupont", "ABC123");

        // Création d'une poubelle intelligente
        PoubelleIntelligente poubelle = new PoubelleIntelligente(101, 50, TypePoubelle.BLEUE, 48.8566, 2.3522);

        // Création d'un dépôt de déchets
        Depot depot = new Depot(101, new Date(), modele.TypeDechets.PLASTIQUE, 5);

        // 🔹 Test 1 : Déposer des déchets
        System.out.println("\n🔹 Test 1 : Déposer des déchets...");
        menage.deposerDechets(poubelle, depot);
        System.out.println("✅ Dépôt ajouté, points actuels : " + menage.consulterPointsFidelite());

        // 🔹 Test 2 : Vérification des points fidélité
        System.out.println("\n🔹 Test 2 : Consultation des points fidélité...");
        System.out.println("Points actuels : " + menage.consulterPointsFidelite());

        // 🔹 Test 3 : Conversion en bon d'achat
        System.out.println("\n🔹 Test 3 : Conversion des points en bon d'achat...");
        BonAchat bon = menage.convertirPointsEnBonAchat();
        System.out.println("Bon d'achat obtenu de valeur : " + bon.getValeur());

        System.out.println("\n✅ Fin des tests.");
    }
}
