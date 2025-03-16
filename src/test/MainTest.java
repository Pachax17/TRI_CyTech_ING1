package test;

import modele.*;
import service.DepotService;

public class MainTest {
    public static void main(String[] args) {
        Menage menage = new Menage(1, "Dupont", "Jean", "jean.dupont@email.com", "1234", 0);
        Poubelle poubelle = new Poubelle(1, "Plastique", 50, 48.8566, 2.3522);

        DepotService.enregistrerDepot(menage, poubelle, "Plastique", 5.0);
        System.out.println("Test : dépôt de 5kg de plastique");

    }
}


