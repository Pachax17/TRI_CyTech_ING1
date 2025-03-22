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

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Map<Integer, Double> getReductionPourPoints() {
        return reductionPourPoints;
    }

    public void setReductionPourPoints(Map<Integer, Double> reductionPourPoints) {
        this.reductionPourPoints = reductionPourPoints;
    }
}
