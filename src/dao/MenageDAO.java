package dao;

import modele.Menage;
import java.sql.*;

public class MenageDAO {
    public static void ajouterMenage(Menage menage) {
        Connection conn = ConnexionBDD.getConnexion();
        String sql = "INSERT INTO menage (nom, motDePasse, pointsFidelite) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, menage.getNom());
            //stmt.setString(2, menage.getPrenom());
            //stmt.setString(3, menage.getEmail());
            stmt.setString(4, menage.getCodeAcces());
            stmt.setInt(5, menage.getNombrePointsFidelite());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
