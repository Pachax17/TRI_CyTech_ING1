package test;

import dao.ConnexionBDD;
import dao.CategorieProduitDAO;
import modele.CategorieProduit;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class CategorieProduitDAOTest {
    public static void main(String[] args) {
        System.out.println("Début des tests de la classe CategorieProduitDAO...");

        try (Connection connection = ConnexionBDD.getConnexion()) {
            if (connection == null) {
                System.err.println("❌ Impossible de se connecter à la base de données.");
                return;
            }

            // Nettoyer les tables avant les tests
            try (Statement stmt = connection.createStatement()) {
                stmt.executeUpdate("DELETE FROM reduction");
                stmt.executeUpdate("DELETE FROM categorie_produit");
                System.out.println("✅ Données de test supprimées.");
            } catch (SQLException e) {
                System.err.println("❌ Erreur lors du nettoyage des données : " + e.getMessage());
            }

            CategorieProduitDAO dao = new CategorieProduitDAO(connection);

            // 🔹 Création d'une catégorie de produit de test
            CategorieProduit categorie = new CategorieProduit("Électronique");

            // 🔹 Ajout des réductions
            Map<Integer, Double> reductions = new HashMap<>();
            reductions.put(100, 10.0); // 10% de réduction pour 100 points
            reductions.put(200, 20.0); // 20% de réduction pour 200 points
            categorie.setReductionPourPoints(reductions);

            // 🔹 Test 1 : Insérer une catégorie de produit et ses réductions
            System.out.println("\n🔹 Test 1 : Insérer une catégorie de produit et ses réductions...");
            dao.insertCategorie(categorie); // ✅ Correction ici !
            System.out.println("✅ Catégorie de produit et réductions insérées avec succès.");

            System.out.println("\n✅ Fin des tests.");
        } catch (SQLException e) {
            System.err.println("❌ Erreur lors de la connexion à la base de données : " + e.getMessage());
        }
    }
}
