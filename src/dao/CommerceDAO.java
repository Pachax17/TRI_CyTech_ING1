package dao;

import modele.Commerce;
import modele.Contrat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CommerceDAO {
    private Connection connection;

    public CommerceDAO(Connection connection) {
        this.connection = connection;
    }

    public void insertCommerce(Commerce commerce) throws SQLException {
        insertContrat(commerce.getContrat());

        String sql = "INSERT INTO commerce (id, nom, id_contrat) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, commerce.getId());
            stmt.setString(2, commerce.getNom());
            stmt.setInt(3, commerce.getContrat().getId());
            stmt.executeUpdate();
        }
    }

    private void insertContrat(Contrat contrat) throws SQLException {
        String sql = "INSERT INTO contrat (id, date_debut, date_fin, regles_utilisation) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, contrat.getId());
            stmt.setDate(2, new java.sql.Date(contrat.getDateDebut().getTime()));
            stmt.setDate(3, new java.sql.Date(contrat.getDateFin().getTime()));
            stmt.setString(4, contrat.getReglesUtilisation());
            stmt.executeUpdate();
        }
    }
}
