import modele.Commerce;
import modele.Contrat;
import modele.Menage;

import java.util.Date;
import java.util.Calendar;

public class CommerceTest {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        Date debut = cal.getTime();
        cal.add(Calendar.YEAR, 1);
        Date fin = cal.getTime();

        Contrat contrat = new Contrat(debut, fin, "10% sur produits bio", 101);
        Commerce commerce = new Commerce("BioMag", 1, contrat);

        Menage menage = new Menage(1, "Famille Durand", "1234");
        menage.ajouterPoints(120);

        commerce.appliquerReduction(menage, 20);
    }
}
