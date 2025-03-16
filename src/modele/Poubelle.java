package modele;

public class Poubelle {
    private int id;
    private String type;  // Verre, Plastique, Carton, Métal, Classique
    private double capaciteMax;
    private double remplissage;
    private double latitude;
    private double longitude;

    public Poubelle(int id, String type, double capaciteMax, double latitude, double longitude) {
        this.id = id;
        this.type = type;
        this.capaciteMax = capaciteMax;
        this.latitude = latitude;
        this.longitude = longitude;
        this.remplissage = 0;  // Initialisation vide
    }

    // Getters et setters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getCapaciteMax() {
        return capaciteMax;
    }

    public void setCapaciteMax(double capaciteMax) {
        this.capaciteMax = capaciteMax;
    }

    public double getRemplissage() {
        return remplissage;
    }

    public void setRemplissage(double remplissage) {
        this.remplissage = remplissage;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
