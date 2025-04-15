package modele;

import java.util.Date;
import java.util.Scanner;
import java.util.Calendar;

public class Contrat {
    private Date dateDebut;
    private Date dateFin;
    private String reglesUtilisation;
    private int id;

    public Contrat(Date debut, Date fin, String regles, int id) {
        this.dateDebut = debut;
        this.dateFin = fin;
        this.reglesUtilisation = regles;
        this.id = id;
    }

    // Méthode pour renouveler le contrat manuellement
    public void renouvelerContrat() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Le contrat actuel expire le : " + dateFin);
        System.out.print("Voulez-vous le renouveler ? (oui/non) : ");
        String choix = scanner.nextLine().trim().toLowerCase();

        if (choix.equals("oui")) {
            System.out.print("Entrez la durée du renouvellement en mois : ");
            int mois = scanner.nextInt();
            scanner.nextLine(); // Consommer la ligne restante

            Calendar cal = Calendar.getInstance();
            cal.setTime(dateFin);
            cal.add(Calendar.MONTH, mois);
            this.dateFin = cal.getTime();

            System.out.println("✅ Contrat renouvelé jusqu'au : " + dateFin);
        } else {
            System.out.println("❌ Renouvellement annulé.");
        }
    }



    // GET SET


    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public String getReglesUtilisation() {
        return reglesUtilisation;
    }

    public void setReglesUtilisation(String reglesUtilisation) {
        this.reglesUtilisation = reglesUtilisation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
