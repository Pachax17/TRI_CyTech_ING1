package test;

import dao.ConnexionBDD;
import dao.CommerceDAO;
import modele.Commerce;
import modele.Contrat;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

public class CommerceDAOTest {
    public static void main(String[] args) {
        System.out.println("🚀 Début des tests de la classe CommerceDAO...");

        // Connexion à la base de données
        try (Connection connection = ConnexionBDD.getConnexion()) {
            CommerceDAO commerceDAO = new CommerceDAO(connection);


            // 🔹 Test 1 : Insérer un commerce et son contrat
            System.out.println("\n🔹 Test 1 : Insérer un commerce et son contrat...");

            // Création d'un nouveau contrat de test
            Date dateDebut = new Date();
            Date dateFin = new Date(dateDebut.getTime() + 365L * 24 * 60 * 60 * 1000); // 1 an plus tard
            Contrat contrat = new Contrat(dateDebut, dateFin, "Règles d'utilisation standard", commerceDAO.generateUniqueId());

            // Création d'un commerce de test
            Commerce commerce = new Commerce("Boulangerie du Coin",1, contrat);

            // Insérer le commerce et son contrat
            commerceDAO.insertCommerce(commerce);
            System.out.println("✅ Commerce et contrat insérés avec succès.");
            System.out.println("ID du commerce généré : " + commerce.getId());

            System.out.println("\n✅ Fin des tests.");
        } catch (SQLException e) {
            System.err.println("❌ Erreur lors de la connexion à la base de données : " + e.getMessage());
        }
    }
}