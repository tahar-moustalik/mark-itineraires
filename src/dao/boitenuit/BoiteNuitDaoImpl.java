package dao.boitenuit;

import dao.ConnectionFactory;
import dao.adresse.AdresseDaoImpl;
import dao.ville.VilleDaoImpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import metier.Adresse;
import metier.BoiteNuit;
import metier.Ville;

/**
 *
 * @author tahar
 */
public class BoiteNuitDaoImpl implements IBoiteNuit{
     @Override
    public BoiteNuit getBoiteNuit(int id) {
        Connection connection = ConnectionFactory.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM boiteNuit WHERE idBoiteNuit=" + id);
            if(rs.next())
            {
                Ville ville = new VilleDaoImpl().getVille(rs.getInt("idVille"));
                Adresse adresse = new AdresseDaoImpl().getAdresse(rs.getInt("idAdr"));
                BoiteNuit boiteNuit = new BoiteNuit(rs.getString("style"),rs.getInt("capacite"),
                rs.getString("libLocal"),rs.getInt("nbStars"),
                rs.getDouble("prix"),rs.getString("numTel"),
                rs.getBoolean("wifiDispo"),rs.getBoolean("toiletteDispo"),ville,adresse,rs.getInt("idVille"));
                return boiteNuit;
            }
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return null;
    }

    @Override
    public List<BoiteNuit> getAllBoiteNuits() {
         Connection connection = ConnectionFactory.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM boiteNuit");
            List<BoiteNuit> boiteNuits = new LinkedList<>();
            while(rs.next())
            {
                Ville ville = new VilleDaoImpl().getVille(rs.getInt("idVille"));
                Adresse adresse = new AdresseDaoImpl().getAdresse(rs.getInt("idAdr"));
                BoiteNuit boiteNuit = new BoiteNuit(rs.getString("style"),rs.getInt("capacite"),
                rs.getString("libLocal"),rs.getInt("nbStars"),
                rs.getDouble("prix"),rs.getString("numTel"),
                rs.getBoolean("wifiDispo"),rs.getBoolean("toiletteDispo"),ville,adresse,rs.getInt("idVille"));
                boiteNuits.add(boiteNuit);
            }
            return boiteNuits;
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return null;
    }

    @Override
    public boolean insertBoiteNuit(BoiteNuit boiteNuit) {
        Connection connection = ConnectionFactory.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO boiteNuit VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?,"
             + "?)");
            ps.setString(1, boiteNuit.getStyle());
            ps.setInt(2, boiteNuit.getCapacite());
            ps.setString(3,boiteNuit.getLibLocal());
            ps.setInt(4, boiteNuit.getNbStars());
            ps.setDouble(5, boiteNuit.getPrix());
            ps.setString(6,boiteNuit.getNumTel());
            ps.setBoolean(7, boiteNuit.isWifiDispo());
            ps.setBoolean(8, boiteNuit.isToiletteDispo());
            ps.setInt(9, boiteNuit.getVille().getId());
            ps.setInt(10, boiteNuit.getAdresse().getId());
            int i = ps.executeUpdate();
            if(i == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return false;
    }

    @Override
    public boolean updateBoiteNuit(BoiteNuit boiteNuit) {
      Connection connection = ConnectionFactory.getConnection();
        try {
   PreparedStatement ps = connection.prepareStatement("UPDATE boiteNuit SET style=?, capacite=?,"
           + " reservation=?, libLocal=? nbStars=? prix=? numTel=? wifiDispo=? toiletteDispo=?"
           + "idVille=? idAdr=? WHERE idBoiteNuit=?");
           
           ps.setString(1, boiteNuit.getStyle());
            ps.setInt(2, boiteNuit.getCapacite());
            ps.setString(3,boiteNuit.getLibLocal());
            ps.setInt(4, boiteNuit.getNbStars());
            ps.setDouble(5, boiteNuit.getPrix());
            ps.setString(6,boiteNuit.getNumTel());
            ps.setBoolean(7, boiteNuit.isWifiDispo());
            ps.setBoolean(8, boiteNuit.isToiletteDispo());
            ps.setInt(9, boiteNuit.getVille().getId());
            ps.setInt(10, boiteNuit.getAdresse().getId());
            ps.setInt(11, boiteNuit.getId());
            int i = ps.executeUpdate();
            if(i == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return false;
    }

    @Override
    public boolean deleteBoiteNuit(int id) {
            Connection connection = ConnectionFactory.getConnection();
        try {
            Statement stmt = connection.createStatement();
            int i = stmt.executeUpdate("DELETE FROM boiteNuit WHERE idBoiteNuit=" + id);
            if(i == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return false;    }
    
}
