package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionBDD {
    private static final String URL = "jdbc:mysql://localhost:3306/tri_selectif";
    private static final String USER = "student-laptop"; // Remplace par ton utilisateur MySQL
    private static final String PASSWORD = "cytech001"; // Remplace par ton mot de passe MySQL

    public static Connection getConnexion() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println(" Connexion réussie à la base de données !");
        } catch (SQLException e) {
            System.err.println(" Erreur de connexion : " + e.getMessage());
        }
        return conn;
    }
}
