package dao;

import modele.Depot;
import modele.TypeDechets;

import java.sql.*;
import java.util.Date;

public class DepotDAO {
    private Connection connection;

    public DepotDAO(Connection connection) {
        this.connection = connection;
    }

    public void insertDepot(Depot depot) throws SQLException {
        String sql = "INSERT INTO depot (id_poubelle, heure_depot, type_dechets, quantite_dechets, points_par_depot) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, depot.getIdPoubelle());
            stmt.setTimestamp(2, new Timestamp(depot.getHeureDepot().getTime()));
            stmt.setInt(4, depot.getQuantiteDechets());
            stmt.setInt(5, depot.getPointsParDepot());
            stmt.executeUpdate();
        }
    }

    public Depot getDepotById(int id) throws SQLException {
        String sql = "SELECT * FROM depot WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int idPoubelle = rs.getInt("id_poubelle");
                Date heureDepot = rs.getTimestamp("heure_depot");
                String nomDechet = rs.getString("type_dechets");
                TypeDechets type = TypeDechets.fromNom(nomDechet);
                int quantite = rs.getInt("quantite_dechets");

                return new Depot(idPoubelle, heureDepot, type, quantite);
            }
        }
        return null;
    }
}
