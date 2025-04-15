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

    /**
     * Insère un dépôt dans la base de données.
     *
     * @param depot Le dépôt à insérer.
     * @throws SQLException Si une erreur SQL survient.
     */
    public void insertDepot(Depot depot) throws SQLException {
        String sql = "INSERT INTO depot (id_poubelle, heure_depot, type_dechet, quantite_dechets, points_par_depot) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, depot.getIdPoubelle());
            stmt.setTimestamp(2, new Timestamp(depot.getHeureDepot().getTime()));
            stmt.setString(3, depot.getDechets().name()); // Utilisation de l'énumération
            stmt.setInt(4, depot.getQuantiteDechets());
            stmt.setInt(5, depot.getPointsParDepot());
            stmt.executeUpdate();
            System.out.println("Dépôt inséré avec succès.");
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
                TypeDechets typeDechet = TypeDechets.valueOf(rs.getString("type_dechet")); // Conversion de l'énumération
                int quantiteDechets = rs.getInt("quantite_dechets");
                int pointsParDepot = rs.getInt("points_par_depot");

                return new Depot(idPoubelle, heureDepot, typeDechet, quantiteDechets);
            }
        }
        return null;
    }


    public void mettreAJourPointsMenage(int idMenage, int points) throws SQLException {
        String sql = "UPDATE menage SET nombre_points_fidelite = nombre_points_fidelite + ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, points);
            stmt.setInt(2, idMenage);
            stmt.executeUpdate();
            System.out.println(" Points de fidélité mis à jour pour le ménage ID : " + idMenage);
        }
    }
}