package test;

import dao.PoubelleDAO;
import modele.PoubelleIntelligente;
import modele.TypePoubelle;
import dao.ConnexionBDD;

import java.sql.Connection;
import java.sql.SQLException;

public class PoubelleDAOTest {
    public static void main(String[] args) {
        System.out.println("🚀 Début des tests de PoubelleDAO...");

        // Connexion à la base de données
        Connection conn = ConnexionBDD.getConnexion();
        if (conn == null) {
            System.out.println("❌ Connexion à MySQL échouée.");
            return;
        }

        PoubelleDAO poubelleDAO = new PoubelleDAO(conn);

        try {
            // 🔹 Test 1 : Insertion d'une poubelle
            System.out.println("\n🔹 Test 1 : Ajout d'une poubelle...");
            PoubelleIntelligente poubelle = new PoubelleIntelligente(101, 10000, TypePoubelle.BLEUE, 48.8566, 2.3522);
            poubelleDAO.ajouterPoubelle(poubelle);
            System.out.println(" Poubelle ajoutée avec succès !");

            // 🔹 Test 2 : Récupération depuis la base
            System.out.println("\n Test 2 : Récupération de la poubelle...");
            PoubelleIntelligente recuperee = poubelleDAO.recupererParId(101);
            if (recuperee != null) {
                System.out.println(" Poubelle trouvée : " + recuperee.getId() + ", Type : " + recuperee.getTypePoubelle());
            } else {
                System.out.println(" Aucune poubelle trouvée avec cet ID.");
            }

            //🔹 Test 3 : Suppression de la poubelle
            //System.out.println("\n🔹 Test 3 : Suppression de la poubelle...");
            //poubelleDAO.supprimerPoubelle(101);
            //System.out.println(" Poubelle supprimée.");

            // Vérification après suppression
            PoubelleIntelligente apresSuppression = poubelleDAO.recupererParId(101);
            if (apresSuppression == null) {
                System.out.println(" Suppression confirmée, la poubelle n'existe plus.");
            } else {
                System.out.println(" La poubelle est toujours présente après suppression !");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
