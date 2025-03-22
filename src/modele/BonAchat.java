package modele;

public class BonAchat {
    private int valeur;

    public BonAchat(int valeur) {
        this.valeur = valeur;
    }

    public void creerBonAchat() {
        System.out.println("Bon d'achat de " + valeur + " points créé !");
    }

    public int getValeur() {
        return valeur;
    }

    public void setValeur(int valeur) {
        this.valeur = valeur;
    }
}
