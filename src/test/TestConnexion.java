package test;

import dao.ConnexionBDD;
import java.sql.Connection;

public class TestConnexion {
    public static void main(String[] args) {
        Connection conn = ConnexionBDD.getConnexion();
        if (conn != null) {
            System.out.println("🎉 Connexion réussie !");
        } else {
            System.out.println("⚠️ Échec de connexion !");
        }
    }
}
