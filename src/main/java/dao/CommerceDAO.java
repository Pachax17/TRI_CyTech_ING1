package dao;

import modele.Commerce;
import modele.Contrat;
import  java.sql.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CommerceDAO {
    private Connection connection;

    public CommerceDAO(Connection connection) {
        this.connection = connection;
    }


    public void insertCommerce(Commerce commerce) throws SQLException {
        // Insérer le contrat et récupérer l'ID généré
        int contratId = insertContrat(commerce.getContrat());
        commerce.getContrat().setId(contratId); // Mettre à jour l'ID du contrat dans l'objet

        // Insérer le commerce
        String sql = "INSERT INTO commerce (nom, id_contrat) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, commerce.getNom());
            stmt.setInt(2, commerce.getContrat().getId());
            stmt.executeUpdate();

            // Récupérer l'ID généré pour le commerce
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    commerce.setId(generatedKeys.getInt(1)); // Mettre à jour l'ID du commerce
                } else {
                    throw new SQLException("Échec de la récupération de l'ID généré pour le commerce.");
                }
            }
        }
    }


    private int insertContrat(Contrat contrat) throws SQLException {
        String sql = "INSERT INTO contrat_partenariat (date_debut, date_fin, regles_utilisation) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setDate(1, new Date(contrat.getDateDebut().getTime()));
            stmt.setDate(2, new Date(contrat.getDateFin().getTime()));
            stmt.setString(3, contrat.getReglesUtilisation());
            stmt.executeUpdate();

            // Récupérer l'ID généré
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1); // Retourne l'ID généré
                } else {
                    throw new SQLException("Échec de la récupération de l'ID généré.");
                }
            }
        }
    }

    public int generateUniqueId() throws SQLException {
        String sql = "SELECT MAX(id) FROM contrat_partenariat";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            if (rs.next()) {
                return rs.getInt(1) + 1; // Retourne l'ID maximum + 1
            } else {
                return 1; // Si la table est vide, commence à 1
            }
        }
    }

}
