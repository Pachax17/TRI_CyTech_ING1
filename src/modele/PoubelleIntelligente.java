package modele;

import java.util.HashMap;
import java.util.Map;

public class PoubelleIntelligente {
    private int identifiantUnique;
    private int capaciteMaximale;
    private TypePoubelle typePoubelle;
    private double latitude;
    private double longitude;
    private Menage idMenage;
    private Map<String, Double> contenu; // Stocke les déchets par type


    public PoubelleIntelligente(int id, int capacite, TypePoubelle type, double lat, double lon) {
        this.identifiantUnique = id;
        this.capaciteMaximale = capacite;
        this.typePoubelle = type;
        this.latitude = lat;
        this.longitude = lon;
        this.contenu = new HashMap<>();
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

    //PAUL ADD FONCTION estDansSecteur ETC POUR VERIF

    // add donction estPleine  / viderPoubelle

    public boolean estPleine() {
        int totalDechets = 0;
        for (Double quantite : contenu.values()) {
            totalDechets += quantite;
        }
        return totalDechets >= capaciteMaximale;
    }

    public Map<String, Double> viderPoubelle() {
        Map<String, Double> dechetsCollectes = new HashMap<>(contenu);
        contenu.clear();
        return dechetsCollectes;
    }


// GET STE

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public int getId() {
        return identifiantUnique;
    }

    public void setId(int identifiantUnique) {
        this.identifiantUnique = identifiantUnique;
    }

    public int getCapaciteMaximale() {
        return capaciteMaximale;
    }

    public void setCapaciteMaximale(int capaciteMaximale) {
        this.capaciteMaximale = capaciteMaximale;
    }

    public TypePoubelle getTypePoubelle() {
        return typePoubelle;
    }

    public void setTypePoubelle(TypePoubelle typePoubelle) {
        this.typePoubelle = typePoubelle;
    }

    public Menage getIdMenage() {
        return idMenage;
    }

    public void setIdMenage(Menage idMenage) {
        this.idMenage = idMenage;
    }

    public int getIdentifiantUnique() {
        return identifiantUnique;
    }

    public void setIdentifiantUnique(int identifiantUnique) {
        this.identifiantUnique = identifiantUnique;
    }

    public Map<String, Double> getContenu() {
        return contenu;
    }

    public void setContenu(Map<String, Double> contenu) {
        this.contenu = contenu;
    }
}
