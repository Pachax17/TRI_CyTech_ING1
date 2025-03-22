package dao;

import modele.PoubelleIntelligente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modele.TypePoubelle;

public class PoubelleDAO {

    // Ajouter une poubelle en base de données
    public static void ajouterPoubelle(PoubelleIntelligente poubelle) {
        Connection conn = ConnexionBDD.getConnexion();
        String sql = "INSERT INTO poubelle_intelligente (id, capaciteMax, latitude, longitude) VALUES (?, ?, ?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, poubelle.getId());
            stmt.setDouble(2, poubelle.getCapaciteMaximale());
            stmt.setDouble(3, poubelle.getLatitude());
            stmt.setDouble(4, poubelle.getLongitude());
            stmt.executeUpdate();
            System.out.println("✅ Poubelle ajoutée en base !");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Récupérer une poubelle par son ID
    public static PoubelleIntelligente getPoubelleById(int id) {
        Connection conn = ConnexionBDD.getConnexion();
        String sql = "SELECT * FROM poubelle_intelligente WHERE id = ?";
        PoubelleIntelligente poubelle = null;

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                poubelle = new PoubelleIntelligente(
                        rs.getInt("id"),
                        rs.getInt("capaciteMax"),
                        TypePoubelle.valueOf(rs.getString("TypePoubelle")),

                        rs.getDouble("latitude"),
                        rs.getDouble("longitude")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return poubelle;
    }

    // Supprimer une poubelle
    public static void supprimerPoubelle(int id) {
        Connection conn = ConnexionBDD.getConnexion();
        String sql = "DELETE FROM poubelle_intelligente WHERE id = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("✅ Poubelle supprimée de la base !");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

