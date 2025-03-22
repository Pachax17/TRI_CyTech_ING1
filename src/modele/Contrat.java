package modele;

import java.util.Date;

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
}
