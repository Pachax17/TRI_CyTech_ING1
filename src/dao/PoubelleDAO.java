package dao;

import modele.PoubelleIntelligente;
import modele.TypePoubelle;

import java.sql.*;

public class PoubelleDAO {

    private final Connection connection;

    public PoubelleDAO(Connection connection) {
        this.connection = connection;
    }

    public void ajouterPoubelle(PoubelleIntelligente poubelle) throws SQLException {
        String sql = "INSERT INTO poubelle_intelligente (id, capaciteMax, type_poubelle, latitude, longitude) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, poubelle.getId());
            stmt.setInt(2, poubelle.getCapaciteMaximale());
            stmt.setString(3, poubelle.getTypePoubelle().name());
            stmt.setDouble(4, poubelle.getLatitude());
            stmt.setDouble(5, poubelle.getLongitude());
            stmt.executeUpdate();
        }
    }

    public PoubelleIntelligente recupererParId(int id) throws SQLException {
        String sql = "SELECT * FROM poubelle_intelligente  WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int capacite = rs.getInt("capaciteMax");
                TypePoubelle type = TypePoubelle.valueOf(rs.getString("type_poubelle"));
                double latitude = rs.getDouble("latitude");
                double longitude = rs.getDouble("longitude");

                return new PoubelleIntelligente(id, capacite, type, latitude, longitude);
            }
        }
        return null;
    }

    // ✅ Ajout d'une méthode pour supprimer une poubelle
    public void supprimerPoubelle(int id) throws SQLException {
        String sql = "DELETE FROM poubelle_intelligente  WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
