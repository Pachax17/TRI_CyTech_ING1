package dao;

import modele.Poubelle;
import modele.CentreDeTri;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class PoubelleDAO {

    // Affecte une poubelle au bon centre de tri
    public static void affecterPoubelle(Poubelle poubelle, List<CentreDeTri> centres) {
        for (CentreDeTri centre : centres) {
            if (centre.estDansSecteur(poubelle)) {
                Connection conn = ConnexionBDD.getConnexion();
                String sql = "UPDATE poubelle SET idCentreTri = ? WHERE id = ?";

                try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                    stmt.setInt(1, centre.getId());
                    stmt.setInt(2, poubelle.getId());
                    stmt.executeUpdate();
                    System.out.println("Poubelle " + poubelle.getId() + " affectée au Centre " + centre.getNom());
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return; // Sortir dès qu'un centre est trouvé
            }
        }
        System.out.println("Aucune affectation possible pour la poubelle " + poubelle.getId());
    }
}
