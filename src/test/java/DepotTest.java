import modele.Depot;
import modele.TypeDechets;

import java.util.Date;

public class DepotTest {
    public static void main(String[] args) {
        // Utilisation de l'enum
        TypeDechets plastique = TypeDechets.PLASTIQUE;
        TypeDechets verre = TypeDechets.VERRE;

        Depot depot = new Depot(1, new Date(), verre, 5);
        System.out.println("Points initiaux : " + depot.getPointsParDepot()); // 5 * 2 = 10

        depot.ajouterDechet(plastique, 3); // 8 * 2 = 16
        System.out.println("Après ajout plastique (3 unités) : " + depot.getPointsParDepot());

        depot.ajouterDechet(verre, 2); // 10 * 4 = 40 (⚠️ car type remplacé)
        System.out.println("Après ajout métal (2 unités) : " + depot.getPointsParDepot());
    }
}
