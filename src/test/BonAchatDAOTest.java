package test;

import dao.ConnexionBDD;
import dao.BonAchatDAO;
import modele.BonAchat;
import modele.Menage;

import java.sql.Connection;
import java.sql.SQLException;

public class BonAchatDAOTest {
    public static void main(String[] args) {
        System.out.println("🚀 Début des tests de la classe BonAchatDAO...");

        // Connexion à la base de données
        try (Connection connection = ConnexionBDD.getConnexion()) {
            // Création d'un ménage de test
            Menage menage = new Menage(1, "Durand", "100"); // Ménage avec 100 points de fidélité

            // 🔹 Test 1 : Convertir les points en bon d'achat
            System.out.println("\n🔹 Test 1 : Convertir les points en bon d'achat...");
            BonAchat bonAchat = menage.convertirPointsEnBonAchat(connection);
            System.out.println("✅ Bon d'achat créé : " + bonAchat.getValeur() + " points pour le ménage : " + menage.getNom());

            System.out.println("\n✅ Fin des tests.");
        } catch (SQLException e) {
            System.err.println("❌ Erreur lors de la connexion à la base de données : " + e.getMessage());
        }
    }
}