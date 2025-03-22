package dao;

import modele.CategorieProduit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

public class CategorieProduitDAO {
    private Connection connection;

    public CategorieProduitDAO(Connection connection) {
        this.connection = connection;
    }

    public void insertCategorie(CategorieProduit categorie) throws SQLException {
        String sql = "INSERT INTO categorie_produit (nom) VALUES (?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, categorie.getNom());
            stmt.executeUpdate();
        }

        // Insérer les réductions associées
        for (Map.Entry<Integer, Double> entry : categorie.getReductionPourPoints().entrySet()) {
            String sqlReduction = "INSERT INTO reduction (categorie_nom, points, pourcentage) VALUES (?, ?, ?)";
            try (PreparedStatement stmt = connection.prepareStatement(sqlReduction)) {
                stmt.setString(1, categorie.getNom());
                stmt.setInt(2, entry.getKey());
                stmt.setDouble(3, entry.getValue());
                stmt.executeUpdate();
            }
        }
    }
}
