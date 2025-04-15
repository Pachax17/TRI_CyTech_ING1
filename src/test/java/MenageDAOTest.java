import dao.MenageDAO;
import modele.Menage;

public class MenageDAOTest {
    public static void main(String[] args) {
        System.out.println(" Début des tests de MenageDAO...");

        //  Test 1 : Ajouter un ménage
        Menage menage = new Menage(1, "Durand", "XYZ123");
        MenageDAO.ajouterMenage(menage);

        //  Test 2 : Récupération depuis MySQL
        Menage recupere = MenageDAO.recupererMenageById(1);
        if (recupere != null) {
            System.out.println(" Ménage trouvé : " + recupere.getNom() + ", Code Accès : " + recupere.getCodeAcces());
        } else {
            System.out.println(" Aucune correspondance trouvée.");
        }
    }
}
