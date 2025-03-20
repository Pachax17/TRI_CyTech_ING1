package modele;

import java.util.ArrayList;
import java.util.List;

public class CentreDeTri {
    private String nom;
    private String adresse;
    private int id;
    private double latitude;
    private double longitude;
    private List<PoubelleIntelligente> poubelles;

    public CentreDeTri(String nom, String adresse, int id, double latitude, double longitude) {
        this.nom = nom;
        this.adresse = adresse;
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.poubelles = new ArrayList<>();
    }

    public void placerPoubelle(PoubelleIntelligente poubelle) {
        poubelles.add(poubelle);
    }

    public void retirerPoubelle(PoubelleIntelligente poubelle) {
        poubelles.remove(poubelle);
    }

    public void collecterDechets() {
        System.out.println("Collecte en cours...");
    }

    public void genererStatistiques() {
        System.out.println("Génération des statistiques de tri...");
    }

    public String getNom() {
        return nom;
    }
}
