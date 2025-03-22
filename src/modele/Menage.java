package modele;

import java.util.ArrayList;
import java.util.List;

public class Menage {
    private int id;
    private String Nom;
    private String codeAcces;
    private int nombrePointsFidelite;
    private List<Depot> historiqueDepots;

    public Menage(int id,String Nom, String codeAcces) {
        this.id = id;
        this.codeAcces = codeAcces;
        this.Nom = Nom;
        this.nombrePointsFidelite = 0;
        this.historiqueDepots = new ArrayList<>();
    }

    public void deposerDechets(PoubelleIntelligente poubelle, Depot depot) {
        if (poubelle.verifierContrainteDechets(depot)) {
            historiqueDepots.add(depot);
            int points = depot.getPointsParDepot();
            ajouterPoints(points);
        }
    }

    public int consulterPointsFidelite() {
        return nombrePointsFidelite;
    }

    public void ajouterPoints(int points) {
        this.nombrePointsFidelite += points;
    }

    public BonAchat convertirPointsEnBonAchat() {
        int valeurBon = nombrePointsFidelite / 10; // Exemple : 10 points = 1 unité de bon d'achat
        nombrePointsFidelite -= valeurBon * 10;
        return new BonAchat(valeurBon);
    }

    // GET SET


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public String getCodeAcces() {
        return codeAcces;
    }

    public void setCodeAcces(String codeAcces) {
        this.codeAcces = codeAcces;
    }

    public List<Depot> getHistoriqueDepots() {
        return historiqueDepots;
    }

    public void setHistoriqueDepots(List<Depot> historiqueDepots) {
        this.historiqueDepots = historiqueDepots;
    }

    public int getNombrePointsFidelite() {
        return nombrePointsFidelite;
    }

    public void setNombrePointsFidelite(int nombrePointsFidelite) {
        this.nombrePointsFidelite = nombrePointsFidelite;
    }


}
