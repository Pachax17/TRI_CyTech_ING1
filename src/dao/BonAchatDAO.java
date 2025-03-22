package dao;

import modele.BonAchat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BonAchatDAO {
    private Connection connection;

    public BonAchatDAO(Connection connection) {
        this.connection = connection;
    }

    public void insertBonAchat(BonAchat bon) throws SQLException {
        String sql = "INSERT INTO bon_achat (valeur) VALUES (?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, bon.getValeur());
            stmt.executeUpdate();
        }
    }
}
