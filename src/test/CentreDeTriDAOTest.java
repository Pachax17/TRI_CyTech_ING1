package test;

import dao.CentreDeTriDAO;
import modele.CentreDeTri;

public class CentreDeTriDAOTest {
    public static void main(String[] args) {
        System.out.println("🚀 Début des tests de la classe CentreDeTriDAO...");

        // Création d'une instance de CentreDeTriDAO
        CentreDeTriDAO centreDeTriDAO = new CentreDeTriDAO();

        // Création d'un centre de tri de test
        CentreDeTri centreDeTri = new CentreDeTri("Centre 1", "123 Rue Test", 1, 48.8566, 2.3522, 10.0);

        // 🔹 Test 1 : Ajouter un centre de tri
        System.out.println("\n🔹 Test 1 : Ajouter un centre de tri...");
        centreDeTriDAO.ajouterCentreDeTri(centreDeTri);
        System.out.println("✅ Centre de tri ajouté.");

        // 🔹 Test 2 : Trouver un centre de tri par son ID
        System.out.println("\n🔹 Test 2 : Trouver un centre de tri par son ID...");
        CentreDeTri centreTrouve = centreDeTriDAO.trouverCentreDeTriParId(1);
        if (centreTrouve != null) {
            System.out.println("✅ Centre de tri trouvé : " + centreTrouve.getNom());
        } else {
            System.out.println("❌ Aucun centre de tri trouvé.");
        }

        // 🔹 Test 3 : Mettre à jour un centre de tri
        System.out.println("\n🔹 Test 3 : Mettre à jour un centre de tri...");
        centreDeTri.setNom("Centre 1 Modifié");
        centreDeTriDAO.mettreAJourCentreDeTri(centreDeTri);
        System.out.println("✅ Centre de tri mis à jour.");

        // 🔹 Test 4 : Récupérer tous les centres de tri
        System.out.println("\n🔹 Test 4 : Récupérer tous les centres de tri...");
        centreDeTriDAO.trouverTousLesCentresDeTri().forEach(c -> System.out.println("Centre de tri : " + c.getNom()));

        // 🔹 Test 5 : Supprimer un centre de tri
        System.out.println("\n🔹 Test 5 : Supprimer un centre de tri...");
        centreDeTriDAO.supprimerCentreDeTri(1);
        System.out.println("✅ Centre de tri supprimé.");

        System.out.println("\n✅ Fin des tests.");
    }
}