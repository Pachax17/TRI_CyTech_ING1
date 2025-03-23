package test;

import modele.*;
import dao.ConnexionBDD;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

public class MenageTest {
    public static void main(String[] args) {
        System.out.println("🚀 Début des tests de la classe Menage...");

        // 🔹 Création d'un ménage
        Menage menage = new Menage(1, "Dupont", "ABC123");

        // 🔹 Création d'une poubelle intelligente
        PoubelleIntelligente poubelle = new PoubelleIntelligente(101, 5000, TypePoubelle.BLEUE, 48.8566, 2.3522);

        // 🔹 Création d'un dépôt de déchets avec un type valide
        Depot depotPlastique = new Depot(102, new Date(), TypeDechets.PLASTIQUE, 5);

        // 🔹 Test 1 : Déposer des déchets (Cas valide)
        System.out.println("\n🔹 Test 1 : Déposer des déchets...");
        menage.deposerDechets(poubelle, depotPlastique);
        System.out.println("✅ Dépôt ajouté, points actuels : " + menage.consulterPointsFidelite());

        // 🔹 Test 2 : Consultation des points fidélité
        System.out.println("\n🔹 Test 2 : Consultation des points fidélité...");
        System.out.println("Points actuels : " + menage.consulterPointsFidelite());

        // Connexion à la base de données
        try (Connection connection = ConnexionBDD.getConnexion()) {
            // 🔹 Test 3 : Conversion en bon d'achat
            System.out.println("\n🔹 Test 3 : Conversion des points en bon d'achat...");
            BonAchat bon = menage.convertirPointsEnBonAchat(connection); // Passer la connexion
            System.out.println("Bon d'achat obtenu de valeur : " + bon.getValeur());
        } catch (SQLException e) {
            System.err.println("❌ Erreur lors de la connexion à la base de données : " + e.getMessage());
        }

        // 🔹 Test 4 : Dépôt sans type de déchet (doit prendre `AUTRES`)
        System.out.println("\n🔹 Test 4 : Dépôt sans type de déchet...");
        Depot depotInvalide = new Depot(102, new Date(), null, 5);
        menage.deposerDechets(poubelle, depotInvalide);
        System.out.println("✅ Dépôt ajouté avec type par défaut : " + depotInvalide.getTypeDechet());
    }
}