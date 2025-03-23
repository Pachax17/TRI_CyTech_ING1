package dao;

import modele.Menage;
import java.sql.*;

public class MenageDAO {
    public static void ajouterMenage(Menage menage) {
        Connection conn = ConnexionBDD.getConnexion();
        if (conn == null) {
            System.out.println("❌ Impossible d'ajouter le ménage, connexion échouée.");
            return;
        }

        String sql = "INSERT INTO menage (nom, code_acces, nombre_points_fidelite) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, menage.getNom());
            stmt.setString(2, menage.getCodeAcces());
            stmt.setInt(3, menage.getNombrePointsFidelite());
            stmt.executeUpdate();
            System.out.println("✅ Ménage ajouté avec succès !");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Menage recupererMenageById(int id) {
        Connection conn = ConnexionBDD.getConnexion();
        if (conn == null) {
            System.out.println("❌ Impossible de récupérer le ménage, connexion échouée.");
            return null;
        }

        String sql = "SELECT * FROM menage WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Menage(
                        rs.getInt("id"),
                        rs.getString("nom"),
                        rs.getString("code_acces")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
