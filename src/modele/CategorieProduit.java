package modele;

import java.util.HashMap;
import java.util.Map;

public class CategorieProduit {
    private String nom;
    private Map<Integer, Double> reductionPourPoints;

    public CategorieProduit(String nom) {
        this.nom = nom;
        this.reductionPourPoints = new HashMap<>();
    }

    public void ajouterReduction(int points, double pourcentage) {
        reductionPourPoints.put(points, pourcentage);
    }
}
