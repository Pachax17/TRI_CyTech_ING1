package test;

import modele.*;

import java.util.Date;

public class MenageTest {
    public static void main(String[] args) {
        Menage menage = new Menage(1, "Durand", "XYZ123");

        PoubelleIntelligente poubelleJaune = new PoubelleIntelligente(1, 100, TypePoubelle.JAUNE, 48.8566, 2.3522);
        Depot depotPlastique = new Depot(101, new Date(), TypeDechets.PLASTIQUE, 3);

        // Compatible : JAUNE <-> PLASTIQUE
        menage.deposerDechets(poubelleJaune, depotPlastique);

        System.out.println("Points acquis : " + menage.consulterPointsFidelite()); // devrait être 3

        PoubelleIntelligente poubelleVerte = new PoubelleIntelligente(2, 100, TypePoubelle.VERTE, 48.8566, 2.3522);
        Depot depotPapier = new Depot(102, new Date(), TypeDechets.PAPIER, 2);

        // Incompatible : VERTE != BLEUE
        menage.deposerDechets(poubelleVerte, depotPapier);

        System.out.println("Points après second dépôt : " + menage.consulterPointsFidelite()); // doit rester 3
    }
}
