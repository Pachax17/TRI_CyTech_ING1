package dao;

import modele.Dechet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DechetDAO {
    public static void ajouterDechet(Dechet dechet) {
        Connection conn = ConnexionBDD.getConnexion();
        String sql = "INSERT INTO dechet (idCorbeille, typeDechet, poids) VALUES (?, ?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, dechet.getIdCorbeille());
            stmt.setString(2, dechet.getTypeDechet());
            stmt.setDouble(3, dechet.getPoids());
            stmt.executeUpdate();
            System.out.println("Déchet ajouté !");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

