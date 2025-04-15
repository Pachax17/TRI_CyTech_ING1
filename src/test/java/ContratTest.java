import modele.Contrat;
import java.util.Calendar;
import java.util.Date;

public class ContratTest {
    public static void main(String[] args) {
        // Création d'un contrat avec une date de fin dans 3 mois
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, 3);
        Date dateFin = cal.getTime();

        Contrat contrat = new Contrat(new Date(), dateFin, "Règles initiales", 1);

        // Tester le renouvellement
        contrat.renouvelerContrat();
    }
}
