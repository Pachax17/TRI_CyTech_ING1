package modele;

import java.util.Date;

public class Depot {
    private int idPoubelle;
    private Date heureDepot;
    private TypeDechets dechets;
    private int quantiteDechets;
    private int pointsParDepot;

    public Depot(int idPoubelle, Date heureDepot, TypeDechets dechets, int quantiteDechets) {
        this.idPoubelle = idPoubelle;
        this.heureDepot = heureDepot;
        this.dechets = dechets;
        this.quantiteDechets = quantiteDechets;
        this.pointsParDepot = calculerPoidsTotal();
    }

    public void ajouterDechet(TypeDechets dechet, int quantite) {
        this.dechets = dechet;
        this.quantiteDechets += quantite;
        this.pointsParDepot = calculerPoidsTotal();
    }

    public int calculerPoidsTotal() {
        return this.dechets.getPoids() * this.quantiteDechets;
    }

    public int getPointsParDepot() {
        return pointsParDepot;
    }


    // GET SET
    public int getIdPoubelle() {
        return idPoubelle;
    }

    public void setIdPoubelle(int idPoubelle) {
        this.idPoubelle = idPoubelle;
    }

    public Date getHeureDepot() {
        return heureDepot;
    }

    public void setHeureDepot(Date heureDepot) {
        this.heureDepot = heureDepot;
    }

    public TypeDechets getDechets() {
        return dechets;
    }

    public void setDechets(TypeDechets dechets) {
        this.dechets = dechets;
    }

    public int getQuantiteDechets() {
        return quantiteDechets;
    }

    public void setQuantiteDechets(int quantiteDechets) {
        this.quantiteDechets = quantiteDechets;
    }

    public void setPointsParDepot(int pointsParDepot) {
        this.pointsParDepot = pointsParDepot;
    }
}
