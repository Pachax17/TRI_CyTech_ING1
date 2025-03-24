package test;

public class MainTest {
    public static void main(String[] args) {
        System.out.println(" DÉBUT DES TESTS RÉGRESSIFS \n");

        try {
            // 🔹 Test des classes métier (sans base SQL)
            System.out.println(" Test 1 : PoubelleTest");
            PoubelleTest.main(args);
            System.out.println("\n Test PoubelleTest terminé.\n");

            System.out.println("Test 2 : MenageTest");
            MenageTest.main(args);
            System.out.println("\n Test MenageTest terminé.\n");

            System.out.println(" Test 3 : CentreDeTriTest");
            CentreDeTriTest.main(args);
            System.out.println("\n Test CentreDeTriTest terminé.\n");

            System.out.println(" Test 4 : DepotTest");
            DepotTest.main(args);
            System.out.println("\n Test DepotTest terminé.\n");

            System.out.println(" Test 5 : ContratTest");
            ContratTest.main(args);
            System.out.println("\n Test ContratTest terminé.\n");

            System.out.println(" Test 6 : CommerceTest");
            CommerceTest.main(args);
            System.out.println("\n Test CommerceTest terminé.\n");

            System.out.println(" Test 7 : BonAchatTest");
            BonAchatTest.main(args);
            System.out.println("\n Test BonAchatTest terminé.\n");

            System.out.println(" Test 8 : CategorieProduitTest");
            CategorieProduitTest.main(args);
            System.out.println("\n Test CategorieProduitTest terminé.\n");



            // 🔹 Test des DAO (avec base SQL)
            System.out.println(" Test 9 : PoubelleDAOTest");
            PoubelleDAOTest.main(args);
            System.out.println("\n Test PoubelleDAOTest terminé.\n");

            System.out.println(" Test 10 : MenageDAOTest");
            MenageDAOTest.main(args);
            System.out.println("\nTest MenageDAOTest terminé.\n");

            System.out.println(" Test 11 : CentreDeTriDAOTest");
            CentreDeTriDAOTest.main(args);
            System.out.println("\nTest CentreDeTriDAOTest terminé.\n");

            System.out.println(" Test 12 : DepotDAOTest");
            DepotDAOTest.main(args);
            System.out.println("\nTest DepotDAOTest terminé.\n");

            System.out.println(" Test 13 : ContratDAOTest");
            ContratDAOTest.main(args);
            System.out.println("\n Test ContratDAOTest terminé.\n");

            System.out.println(" Test 14 : CommerceDAOTest");
            CommerceDAOTest.main(args);
            System.out.println("\n Test CommerceDAOTest terminé.\n");

            System.out.println(" Test 15 : BonAchatDAOTest");
            BonAchatDAOTest.main(args);
            System.out.println("\n Test BonAchatDAOTest terminé.\n");

            System.out.println(" Test 16 : CategorieProduitDAOTest");
            CategorieProduitDAOTest.main(args);
            System.out.println("\n Test CategorieProduitDAOTestno terminé.\n");

        } catch (Exception e) {
            System.err.println(" Une erreur s'est produite lors des tests : " + e.getMessage());
            e.printStackTrace();
        }

        System.out.println("\n TOUS LES TESTS SONT TERMINÉS ");
    }
}
