package modele;

import java.util.ArrayList;
import java.util.List;

public class CentreDeTri {
    private int id;
    private String nom;
    private String adresse;
    private double latitude;
    private double longitude;
    private double rayonSecteur; // Demi-longueur du carré en degrés (ex: 0.02 ≈ 2.2 km)
    private List<Poubelle> poubelles;

    public CentreDeTri(int id, String nom, String adresse, double latitude, double longitude, double rayonSecteur) {
        this.id = id;
        this.nom = nom;
        this.adresse = adresse;
        this.latitude = latitude;
        this.longitude = longitude;
        this.rayonSecteur = rayonSecteur;
        this.poubelles = new ArrayList<>();
    }

    // Vérifie si une poubelle est dans le secteur carré du centre
    public boolean estDansSecteur(Poubelle poubelle) {
        double lat = poubelle.getLatitude();
        double lon = poubelle.getLongitude();

        return (lat >= latitude - rayonSecteur && lat <= latitude + rayonSecteur) &&
                (lon >= longitude - rayonSecteur && lon <= longitude + rayonSecteur);
    }

    // Ajouter une poubelle si elle est dans le secteur
    public boolean ajouterPoubelle(Poubelle poubelle) {
        if (estDansSecteur(poubelle)) {
            poubelles.add(poubelle);
            System.out.println("Poubelle affectée au Centre de Tri : " + nom);
            return true;
        } else {
            System.out.println(" Poubelle hors du secteur de " + nom);
            return false;
        }
    }

    // Getters et Setters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
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

    public double getRayonSecteur() {
        return rayonSecteur;
    }

    public void setRayonSecteur(double rayonSecteur) {
        this.rayonSecteur = rayonSecteur;
    }

    public List<Poubelle> getPoubelles() {
        return poubelles;
    }

    public void setPoubelles(List<Poubelle> poubelles) {
        this.poubelles = poubelles;
    }
}
