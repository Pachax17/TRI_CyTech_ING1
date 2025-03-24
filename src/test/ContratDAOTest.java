package test;

import dao.ConnexionBDD;
import dao.ContratDAO;
import modele.Contrat;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.List;

public class ContratDAOTest {
    public static void main(String[] args) {
        System.out.println("🚀 Début des tests de la classe ContratDAO...");

        try (Connection connection = ConnexionBDD.getConnexion()) {
            // Nettoyer les tables avant les tests
            try (Statement stmt = connection.createStatement()) {
                stmt.executeUpdate("DELETE FROM contrat_partenariat");
                System.out.println("✅ Données de test supprimées.");
            } catch (SQLException e) {
                System.err.println("❌ Erreur lors du nettoyage des données : " + e.getMessage());
            }

            ContratDAO contratDAO = new ContratDAO(connection);

            // Création d'un contrat de test
            Date dateDebut = new Date();
            Date dateFin = new Date(dateDebut.getTime() + 365L * 24 * 60 * 60 * 1000); // 1 an plus tard
            Contrat contrat = new Contrat(dateDebut, dateFin, "Règles d'utilisation standard", 1);

            // 🔹 Test 1 : Insérer un contrat
            System.out.println("\n🔹 Test 1 : Insérer un contrat...");
            contratDAO.insertContrat(contrat);
            System.out.println("✅ Contrat inséré avec succès.");

            // 🔹 Test 2 : Récupérer un contrat par son ID
            System.out.println("\n🔹 Test 2 : Récupérer un contrat par son ID...");
            Contrat contratRecupere = contratDAO.getContratById(1);
            if (contratRecupere != null) {
                System.out.println("✅ Contrat récupéré : " + contratRecupere.getReglesUtilisation());
            } else {
                System.out.println("❌ Aucun contrat trouvé.");
            }

            // 🔹 Test 3 : Récupérer tous les contrats
            System.out.println("\n🔹 Test 3 : Récupérer tous les contrats...");
            List<Contrat> contrats = contratDAO.getAllContrats();
            contrats.forEach(c -> System.out.println("Contrat ID : " + c.getId() + ", Règles : " + c.getReglesUtilisation()));

            // 🔹 Test 4 : Mettre à jour un contrat
            System.out.println("\n🔹 Test 4 : Mettre à jour un contrat...");
            contrat.setReglesUtilisation("Nouvelles règles d'utilisation");
            contratDAO.updateContrat(contrat);
            System.out.println("✅ Contrat mis à jour.");

            // 🔹 Test 5 : Supprimer un contrat
            System.out.println("\n🔹 Test 5 : Supprimer un contrat...");
            contratDAO.deleteContrat(1);
            System.out.println("✅ Contrat supprimé.");

            System.out.println("\n✅ Fin des tests.");
        } catch (SQLException e) {
            System.err.println("❌ Erreur lors de la connexion à la base de données : " + e.getMessage());
        }
    }
}