import dao.ConnexionBDD;
import dao.DepotDAO;
import modele.Depot;
import modele.TypeDechets;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

public class DepotDAOTest {
    public static void main(String[] args) {
        System.out.println("Début des tests de la classe DepotDAO...");

        // Connexion à la base de données
        try (Connection connection = ConnexionBDD.getConnexion()) {
            DepotDAO depotDAO = new DepotDAO(connection);

            // Création d'un dépôt de test
            Depot depot = new Depot(101, new Date(), TypeDechets.PLASTIQUE, 5);

            //  Test 1 : Insérer un dépôt
            System.out.println("\n Test 1 : Insérer un dépôt...");
            depotDAO.insertDepot(depot);
            System.out.println(" Dépôt inséré avec succès.");

            //  Test 2 : Récupérer un dépôt par son ID
            System.out.println("\n Test 2 : Récupérer un dépôt par son ID...");
            Depot depotRecupere = depotDAO.getDepotById(depot.getIdPoubelle());
            if (depotRecupere != null) {
                System.out.println(" Dépôt récupéré : " + depotRecupere);
            } else {
                System.out.println(" Aucun dépôt trouvé.");
            }

            //  Test 3 : Mettre à jour les points de fidélité d'un ménage
            System.out.println("\n Test 3 : Mettre à jour les points de fidélité d'un ménage...");
            int idMenage = 1; // ID du ménage à mettre à jour
            int points = depot.getPointsParDepot(); // Points à ajouter
            depotDAO.mettreAJourPointsMenage(idMenage, points);
            System.out.println(" Points de fidélité mis à jour pour le ménage ID : " + idMenage);

            System.out.println("\n Fin des tests.");
        } catch (SQLException e) {
            System.err.println(" Erreur lors de la connexion à la base de données : " + e.getMessage());
        }
    }
}