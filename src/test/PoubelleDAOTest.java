package test;

import dao.PoubelleDAO;
import modele.PoubelleIntelligente;
import modele.TypePoubelle;

public class PoubelleDAOTest {
    public static void main(String[] args) {
        System.out.println("🚀 Début des tests de PoubelleDAO...");

        // Création d'une poubelle
        PoubelleIntelligente poubelle = new PoubelleIntelligente(101, 50, TypePoubelle.BLEUE, 48.8566, 2.3522);

        // 🔹 Test 1 : Insertion dans la base
        System.out.println("\n🔹 Test 1 : Ajout d'une poubelle...");
        PoubelleDAO.ajouterPoubelle(poubelle);

        // 🔹 Test 2 : Récupération depuis la base
        //System.out.println("\n🔹 Test 2 : Récupération de la poubelle...");
        //PoubelleIntelligente recuperee = PoubelleDAO.getPoubelleById(101);
        //if (recuperee != null) {
         //   System.out.println("✅ Poubelle trouvée : " + recuperee.getId() + ", Type : " + recuperee.getTypePoubelle());
        //} else {
        //    System.out.println("❌ Aucune poubelle trouvée avec cet ID.");
       // }

        // 🔹 Test 3 : Suppression de la poubelle
        //System.out.println("\n🔹 Test 3 : Suppression de la poubelle...");
       // PoubelleDAO.supprimerPoubelle(101);

        // Vérification après suppression
        //PoubelleIntelligente apresSuppression = PoubelleDAO.getPoubelleById(101);
       // if (apresSuppression == null) {
        //    System.out.println("✅ Suppression confirmée, la poubelle n'existe plus.");
       // } else {
        //    System.out.println("❌ La poubelle est toujours présente après suppression !");
        //}

        System.out.println("\n✅ Fin des tests.");
    }
}
