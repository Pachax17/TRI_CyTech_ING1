package dao;

import modele.BonAchat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet; // Import manquant
import java.sql.SQLException;
import java.sql.Statement;

public class BonAchatDAO {
    private Connection connection;

    public BonAchatDAO(Connection connection) {
        this.connection = connection;
    }

    /**
     * Insère un bon d'achat dans la base de données.
     *
     * @param bon Le bon d'achat à insérer.
     * @return L'ID généré pour le bon d'achat.
     * @throws SQLException Si une erreur SQL survient.
     */
    public int insertBonAchat(BonAchat bon) throws SQLException {
        String sql = "INSERT INTO bon_achat (valeur, id_menage) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, bon.getValeur());
            stmt.setInt(2, bon.getMenage().getId()); // Référence au ménage
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
}