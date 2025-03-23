package modele;

public class BonAchat {
    private int valeur;
    private Menage menage; // Référence au ménage propriétaire du bon d'achat

    public BonAchat(int valeur, Menage menage) {
        this.valeur = valeur;
        this.menage = menage;
    }

    public void creerBonAchat() {
        System.out.println("Bon d'achat de " + valeur + " points créé pour le ménage : " + menage.getNom());
    }

    public int getValeur() {
        return valeur;
    }

    public void setValeur(int valeur) {
        this.valeur = valeur;
    }

    public Menage getMenage() {
        return menage;
    }

    public void setMenage(Menage menage) {
        this.menage = menage;
    }
}