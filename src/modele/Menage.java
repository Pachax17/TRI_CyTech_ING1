import java.util.ArrayList;
import java.util.List;

public class Menage {
    private int id;
    private int codeAcces;
    private int nombrePointsFidelite;
    private List<Depot> historiqueDepots;

    public Menage(int id, int codeAcces) {
        this.id = id;
        this.codeAcces = codeAcces;
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
}
