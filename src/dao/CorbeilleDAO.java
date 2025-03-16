package dao;

import modele.Corbeille;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CorbeilleDAO {
    public static void ajouterCorbeille(int idMenage) {
        Connection conn = ConnexionBDD.getConnexion();
        String sql = "INSERT INTO corbeille (idMenage) VALUES (?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idMenage);
            stmt.executeUpdate();
            System.out.println("Corbeille ajoutée !");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
