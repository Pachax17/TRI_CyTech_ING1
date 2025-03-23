package test;

import modele.BonAchat;
import modele.Menage;

public class BonAchatTest {
    public static void main(String[] args) {
        // Création d'un ménage de test
        Menage menage = new Menage(1, "Dupont", "100");

        // Création d'un bon d'achat avec les arguments requis
        BonAchat bon = new BonAchat(50, menage); // Valeur : 50, Ménage : Dupont
        bon.creerBonAchat(); // Affiche le message de création
    }
}