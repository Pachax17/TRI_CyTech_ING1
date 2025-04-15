package dao;

import modele.Contrat;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContratDAO {
    private Connection connection;

    public ContratDAO(Connection connection) {
        this.connection = connection;
    }


    public void insertContrat(Contrat contrat) throws SQLException {
        String sql = "INSERT INTO contrat_partenariat (id, date_debut, date_fin, regles_utilisation) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, contrat.getId());
            stmt.setDate(2, new Date(contrat.getDateDebut().getTime()));
            stmt.setDate(3, new Date(contrat.getDateFin().getTime()));
            stmt.setString(4, contrat.getReglesUtilisation());
            stmt.executeUpdate();
            System.out.println(" Contrat inséré avec succès.");
        }
    }


    public Contrat getContratById(int id) throws SQLException {
        String sql = "SELECT * FROM contrat_partenariat WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Date dateDebut = rs.getDate("date_debut");
                Date dateFin = rs.getDate("date_fin");
                String reglesUtilisation = rs.getString("regles_utilisation");

                return new Contrat(dateDebut, dateFin, reglesUtilisation, id);
            }
        }
        return null;
    }


    public List<Contrat> getAllContrats() throws SQLException {
        String sql = "SELECT * FROM contrat_partenariat";
        List<Contrat> contrats = new ArrayList<>();

        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                Date dateDebut = rs.getDate("date_debut");
                Date dateFin = rs.getDate("date_fin");
                String reglesUtilisation = rs.getString("regles_utilisation");

                contrats.add(new Contrat(dateDebut, dateFin, reglesUtilisation, id));
            }
        }
        return contrats;
    }


    public void updateContrat(Contrat contrat) throws SQLException {
        String sql = "UPDATE contrat_partenariat SET date_debut = ?, date_fin = ?, regles_utilisation = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setDate(1, new Date(contrat.getDateDebut().getTime()));
            stmt.setDate(2, new Date(contrat.getDateFin().getTime()));
            stmt.setString(3, contrat.getReglesUtilisation());
            stmt.setInt(4, contrat.getId());
            stmt.executeUpdate();
            System.out.println(" Contrat mis à jour avec succès.");
        }
    }


    public void deleteContrat(int id) throws SQLException {
        String sql = "DELETE FROM contrat_partenariat WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println(" Contrat supprimé avec succès.");
        }
    }
}