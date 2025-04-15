package modele;

import java.util.Date;

public class Depot {
    private int idPoubelle;
    private Date heureDepot;
    private TypeDechets typeDechets;
    private int quantiteDechets;
    private int pointsParDepot;

    public Depot(int idPoubelle, Date heureDepot, TypeDechets typeDechets, int quantiteDechets) {
        this.idPoubelle = idPoubelle;
        this.heureDepot = heureDepot != null ? heureDepot : new Date();
        this.typeDechets = (typeDechets != null) ? typeDechets : TypeDechets.AUTRES;
        this.quantiteDechets = quantiteDechets;
        this.pointsParDepot = calculerPoidsTotal();
    }

    public void ajouterDechet(TypeDechets dechet, int quantite) {
        this.typeDechets = dechet;
        this.quantiteDechets += quantite;
        this.pointsParDepot = calculerPoidsTotal();
    }

    public int calculerPoidsTotal() {
        if (typeDechets == null) { // Évite l'erreur en cas de `null` ADD via GPT car pb lors des test(tjrs null)
            throw new IllegalArgumentException("Type de déchet non défini !");
        }
        return quantiteDechets * typeDechets.getPoids();
    }

    public int getPointsParDepot() {
        return pointsParDepot;
    }

    public TypeDechets getTypeDechet() {
        return typeDechets;
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
        return typeDechets;
    }

    public void setDechets(TypeDechets dechets) {
        this.typeDechets = dechets;
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
