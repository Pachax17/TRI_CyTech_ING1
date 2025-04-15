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

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Contrat getContrat() {
        return contrat;
    }

    public void setContrat(Contrat contrat) {
        this.contrat = contrat;
    }
}
