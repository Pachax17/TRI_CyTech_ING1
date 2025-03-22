package modele;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class CentreDeTri {
    private String nom;
    private String adresse;
    private int id;
    private double latitude;
    private double longitude;
    private double rayonSecteur;
    private Map<Date, Map<String, Double>> historiqueDechets = new HashMap<>();
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
        System.out.println("Poubelle retirée du Centre de Tri : " + nom);
    }

    public void collecterDechets() {
        for (PoubelleIntelligente poubelle : poubelles) {
            if (poubelle.estPleine()) {
                Map<String, Double> dechetsCollectes = poubelle.viderPoubelle();
                System.out.println("Déchets collectés de la poubelle " + poubelle.getId() + " : " + dechetsCollectes);
            }
        }
    }

    public void genererStatistiques(Date dateDebut, Date dateFin) {
        Map<String, Double> statistiques = new HashMap<>();

        for (Map.Entry<Date, Map<String, Double>> entry : historiqueDechets.entrySet()) {
            Date dateCollecte = entry.getKey();
            if (dateCollecte.after(dateDebut) && dateCollecte.before(dateFin)) {
                Map<String, Double> dechetsCollectes = entry.getValue();
                for (Map.Entry<String, Double> dechet : dechetsCollectes.entrySet()) {
                    String typeDechet = dechet.getKey();
                    double quantite = dechet.getValue();
                    statistiques.put(typeDechet, statistiques.getOrDefault(typeDechet, 0.0) + quantite);
                }
            }
        }

        System.out.println("Statistiques de production/récupération de déchets du " + dateDebut + " au " + dateFin + " :");
        for (Map.Entry<String, Double> stat : statistiques.entrySet()) {
            System.out.println("Type de déchet: " + stat.getKey() + ", Quantité: " + stat.getValue());
        }
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
