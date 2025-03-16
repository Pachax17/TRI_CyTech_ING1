package modele;

import java.util.Date;

public class Depot {
    private int id;
    private Menage menage;
    private Poubelle poubelle;
    private Date dateDepot;
    private String typeDechet;
    private double quantite;
    private int pointsGagnes;

    public Depot(int id, Menage menage, Poubelle poubelle, Date dateDepot, String typeDechet, double quantite, int pointsGagnes) {
        this.id = id;
        this.menage = menage;
        this.poubelle = poubelle;
        this.dateDepot = dateDepot;
        this.typeDechet = typeDechet;
        this.quantite = quantite;
        this.pointsGagnes = pointsGagnes;
    }

    // Getters et setters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Menage getMenage() {
        return menage;
    }

    public void setMenage(Menage menage) {
        this.menage = menage;
    }

    public Poubelle getPoubelle() {
        return poubelle;
    }

    public void setPoubelle(Poubelle poubelle) {
        this.poubelle = poubelle;
    }

    public Date getDateDepot() {
        return dateDepot;
    }

    public void setDateDepot(Date dateDepot) {
        this.dateDepot = dateDepot;
    }

    public String getTypeDechet() {
        return typeDechet;
    }

    public void setTypeDechet(String typeDechet) {
        this.typeDechet = typeDechet;
    }

    public double getQuantite() {
        return quantite;
    }

    public void setQuantite(double quantite) {
        this.quantite = quantite;
    }

    public int getPointsGagnes() {
        return pointsGagnes;
    }

    public void setPointsGagnes(int pointsGagnes) {
        this.pointsGagnes = pointsGagnes;
    }
}
