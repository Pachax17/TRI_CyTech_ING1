package service;

import modele.Depot;
import modele.Menage;
import modele.Poubelle;

public class DepotService {
    public static int calculerPoints(String typeDechet, double quantite) {
        switch (typeDechet) {
            case "Plastique": return (int) (quantite * 2);
            case "Verre": return (int) (quantite * 3);
            case "Carton": return (int) (quantite * 1);
            case "Métal": return (int) (quantite * 4);
            default: return 0;
        }
    }

    public static void enregistrerDepot(Menage menage, Poubelle poubelle, String typeDechet, double quantite) {
        int points = calculerPoints(typeDechet, quantite);
        System.out.println("Dépôt enregistré : " + quantite + " kg de " + typeDechet + " -> " + points + " points gagnés.");
        // Mise à jour en base de données
    }
}
