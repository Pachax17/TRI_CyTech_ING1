package modele;

import java.util.ArrayList;
import java.util.List;

public class CentreDeTri {
    private String nom;
    private String adresse;
    private int id;
    private double latitude;
    private double longitude;
    private double rayonSecteur;
    private List<PoubelleIntelligente> poubelles;

    public CentreDeTri(String nom, String adresse, int id, double latitude, double longitude, double rayonSecteur) {
        this.nom = nom;
        this.adresse = adresse;
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.rayonSecteur = rayonSecteur;
        this.poubelles = new ArrayList<>();
    }

    public boolean estDansSecteur(PoubelleIntelligente poubelle) {
        double lat = poubelle.getLatitude();
        double lon = poubelle.getLongitude();

        return (lat >= latitude - rayonSecteur && lat <= latitude + rayonSecteur) &&
                (lon >= longitude - rayonSecteur && lon <= longitude + rayonSecteur);
    }

    // Ajouter une poubelle si elle est dans le secteur
    public boolean ajouterPoubelle(PoubelleIntelligente poubelle) {
        if (estDansSecteur(poubelle)) {
            poubelles.add(poubelle);
            System.out.println("Poubelle affectée au Centre de Tri : " + nom);
            return true;
        } else {
            System.out.println(" Poubelle hors du secteur de " + nom);
            return false;
        }
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





    // GET SET

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public List<PoubelleIntelligente> getPoubelles() {
        return poubelles;
    }

    public void setPoubelles(List<PoubelleIntelligente> poubelles) {
        this.poubelles = poubelles;
    }
}
