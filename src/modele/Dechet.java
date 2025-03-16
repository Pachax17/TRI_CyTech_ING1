package modele;

public class Dechet {
    private int id;
    private int idCorbeille;
    private String typeDechet; // "Plastique", "Verre", "Carton", "Métal"
    private double poids;

    public Dechet(int id, int idCorbeille, String typeDechet, double poids) {
        this.id = id;
        this.idCorbeille = idCorbeille;
        this.typeDechet = typeDechet;
        this.poids = poids;
    }

    // Getters et Setters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCorbeille() {
        return idCorbeille;
    }

    public void setIdCorbeille(int idCorbeille) {
        this.idCorbeille = idCorbeille;
    }

    public String getTypeDechet() {
        return typeDechet;
    }

    public void setTypeDechet(String typeDechet) {
        this.typeDechet = typeDechet;
    }

    public double getPoids() {
        return poids;
    }

    public void setPoids(double poids) {
        this.poids = poids;
    }
}
