package modele;

import java.util.Date;

public class Contrat {
    private int id;
    private int idCommerce;
    private int idCentreTri;
    private Date dateDebut;
    private Date dateFin;

    public Contrat(int id, int idCommerce, int idCentreTri, Date dateDebut, Date dateFin) {
        this.id = id;
        this.idCommerce = idCommerce;
        this.idCentreTri = idCentreTri;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    // Getters et Setters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCommerce() {
        return idCommerce;
    }

    public void setIdCommerce(int idCommerce) {
        this.idCommerce = idCommerce;
    }

    public int getIdCentreTri() {
        return idCentreTri;
    }

    public void setIdCentreTri(int idCentreTri) {
        this.idCentreTri = idCentreTri;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }
}
