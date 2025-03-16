package modele;

import java.util.ArrayList;
import java.util.List;

public class Corbeille {
    private int id;
    private int idMenage;
    private List<Dechet> dechets;

    public Corbeille(int id, int idMenage) {
        this.id = id;
        this.idMenage = idMenage;
        this.dechets = new ArrayList<>();
    }

    // Ajouter un déchet dans la corbeille
    public void ajouterDechet(Dechet dechet) {
        this.dechets.add(dechet);
        System.out.println("Déchet ajouté : " + dechet.getTypeDechet() + " (" + dechet.getPoids() + " kg)");
    }

    // Calculer le poids total des déchets
    public double calculerPoidsTotal() {
        double poidsTotal = 0;
        for (Dechet dechet : dechets) {
            poidsTotal += dechet.getPoids();
        }
        return poidsTotal;
    }

    // Getters et Setters
}
