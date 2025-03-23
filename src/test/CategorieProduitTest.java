package test;

import modele.CategorieProduit;

public class CategorieProduitTest {
    public static void main(String[] args) {
        CategorieProduit produit = new CategorieProduit("Électroménager");
        produit.ajouterReduction(100, 10.0);
        produit.ajouterReduction(200, 20.0);
        System.out.println("Réductions ajoutées pour : " + produit.getNom());
    }
}
