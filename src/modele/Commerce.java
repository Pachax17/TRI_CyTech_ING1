package modele;

public class Commerce {
    private String nom;
    private int id;
    private Contrat contrat;

    public Commerce(String nom, int id, Contrat contrat) {
        this.nom = nom;
        this.id = id;
        this.contrat = contrat;
    }

    public void appliquerReduction(Menage menage, int points) {
        System.out.println("Réduction appliquée de " + points + " points pour " + menage.consulterPointsFidelite() + " points.");
    }
}
