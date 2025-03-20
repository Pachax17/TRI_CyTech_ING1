package modele;

public enum TypeDechets {
    PLASTIQUE(200),
    VERRE(500),
    CARTON(150),
    METAL(300),
    PAPIER(100),
    AUTRES(250);

    private final int poids; // Poids en grammes

    TypeDechets(int poids) {
        this.poids = poids;
    }

    public int getPoids() {
        return poids;
    }
}
