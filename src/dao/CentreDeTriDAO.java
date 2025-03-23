package dao;

import modele.CentreDeTri;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CentreDeTriDAO {

    // Méthode pour insérer un centre de tri dans la base de données
    public void ajouterCentreDeTri(CentreDeTri centreDeTri) {
        String sql = "INSERT INTO Centre_De_Tri (nom, adresse, id, latitude, longitude, rayon_secteur) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConnexionBDD.getConnexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, centreDeTri.getNom());
            pstmt.setString(2, centreDeTri.getAdresse());
            pstmt.setInt(3, centreDeTri.getId());
            pstmt.setDouble(4, centreDeTri.getLatitude());
            pstmt.setDouble(5, centreDeTri.getLongitude());
            pstmt.setDouble(6, centreDeTri.getRayonSecteur());

            pstmt.executeUpdate();
            System.out.println("✅ Centre de tri ajouté avec succès !");
        } catch (SQLException e) {
            System.err.println("❌ Erreur lors de l'ajout du centre de tri : " + e.getMessage());
        }
    }

    // Méthode pour récupérer un centre de tri par son ID
    public CentreDeTri trouverCentreDeTriParId(int id) {
        String sql = "SELECT * FROM Centre_De_Tri WHERE id = ?";
        CentreDeTri centreDeTri = null;

        try (Connection conn = ConnexionBDD.getConnexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                centreDeTri = new CentreDeTri(
                        rs.getString("nom"),
                        rs.getString("adresse"),
                        rs.getInt("id"),
                        rs.getDouble("latitude"),
                        rs.getDouble("longitude"),
                        rs.getDouble("rayon_secteur")
                );
                System.out.println("✅ Centre de tri trouvé : " + centreDeTri.getNom());
            } else {
                System.out.println("❌ Aucun centre de tri trouvé avec l'ID : " + id);
            }
        } catch (SQLException e) {
            System.err.println("❌ Erreur lors de la recherche du centre de tri : " + e.getMessage());
        }
        return centreDeTri;
    }

    // Méthode pour récupérer tous les centres de tri
    public List<CentreDeTri> trouverTousLesCentresDeTri() {
        String sql = "SELECT * FROM Centre_De_Tri";
        List<CentreDeTri> centresDeTri = new ArrayList<>();

        try (Connection conn = ConnexionBDD.getConnexion();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                CentreDeTri centreDeTri = new CentreDeTri(
                        rs.getString("nom"),
                        rs.getString("adresse"),
                        rs.getInt("id"),
                        rs.getDouble("latitude"),
                        rs.getDouble("longitude"),
                        rs.getDouble("rayon_secteur")
                );
                centresDeTri.add(centreDeTri);
            }
            System.out.println("✅ Liste des centres de tri récupérée avec succès !");
        } catch (SQLException e) {
            System.err.println("❌ Erreur lors de la récupération des centres de tri : " + e.getMessage());
        }
        return centresDeTri;
    }

    // Méthode pour mettre à jour un centre de tri
    public void mettreAJourCentreDeTri(CentreDeTri centreDeTri) {
        String sql = "UPDATE Centre_De_Tri SET nom = ?, adresse = ?, latitude = ?, longitude = ?, rayon_secteur = ? WHERE id = ?";
        try (Connection conn = ConnexionBDD.getConnexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, centreDeTri.getNom());
            pstmt.setString(2, centreDeTri.getAdresse());
            pstmt.setDouble(3, centreDeTri.getLatitude());
            pstmt.setDouble(4, centreDeTri.getLongitude());
            pstmt.setDouble(5, centreDeTri.getRayonSecteur());
            pstmt.setInt(6, centreDeTri.getId());

            pstmt.executeUpdate();
            System.out.println("✅ Centre de tri mis à jour avec succès !");
        } catch (SQLException e) {
            System.err.println("❌ Erreur lors de la mise à jour du centre de tri : " + e.getMessage());
        }
    }

    // Méthode pour supprimer un centre de tri par son ID
    public void supprimerCentreDeTri(int id) {
        String sql = "DELETE FROM Centre_De_Tri WHERE id = ?";
        try (Connection conn = ConnexionBDD.getConnexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("✅ Centre de tri supprimé avec succès !");
        } catch (SQLException e) {
            System.err.println("❌ Erreur lors de la suppression du centre de tri : " + e.getMessage());
        }
    }
}