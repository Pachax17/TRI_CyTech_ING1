package modele;

public class PoubelleIntelligente {
    private int identifiantUnique;
    private int capaciteMaximale;
    private TypePoubelle typePoubelle;
    private double latitude;
    private double longitude;
    private Menage idMenage;

    public PoubelleIntelligente(int id, int capacite, TypePoubelle type, double lat, double lon) {
        this.identifiantUnique = id;
        this.capaciteMaximale = capacite;
        this.typePoubelle = type;
        this.latitude = lat;
        this.longitude = lon;
    }

    public void identifierMenage(Menage menage) {
        this.idMenage = menage;
    }

    public int calculerQuantiteDechet(Depot depot) {
        return depot.calculerPoidsTotal();
    }

    public void attribuerPointsFidelite(Menage menage, int points) {
        menage.ajouterPoints(points);
    }

    public void notifierCentreTri(CentreDeTri centre) {
        System.out.println("Notification envoyée au centre de tri : " + centre.getNom());
    }

    public boolean verifierContrainteDechets(Depot depot) {
        return depot.calculerPoidsTotal() <= this.capaciteMaximale;
    }
}
