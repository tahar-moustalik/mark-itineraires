package dao.cafe;

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
import metier.Cafe;
import metier.Ville;

/**
 *
 * @author tahar
 */
public class CafeDaoImpl implements ICafeDao{
     @Override
    public Cafe getCafe(int id) {
        Connection connection = ConnectionFactory.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM cafe WHERE idCafe=" + id);
            if(rs.next())
            {
                Ville ville = new VilleDaoImpl().getVille(rs.getInt("idVille"));
                Adresse adresse = new AdresseDaoImpl().getAdresse(rs.getInt("idAdr"));
                Cafe cafe = new Cafe(rs.getBoolean("espaceFumeur"),rs.getBoolean("tresseDispo"),
                rs.getString("libLocal"),rs.getInt("nbStars"),
                rs.getDouble("prix"),rs.getString("numTel"),
                rs.getBoolean("wifiDispo"),rs.getBoolean("toiletteDispo"),ville,adresse,rs.getInt("idVille"));
                return cafe;
            }
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return null;
    }

    @Override
    public List<Cafe> getAllCafes() {
         Connection connection = ConnectionFactory.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM cafe");
            List<Cafe> cafes = new LinkedList<>();
            while(rs.next())
            {
                Ville ville = new VilleDaoImpl().getVille(rs.getInt("idVille"));
                Adresse adresse = new AdresseDaoImpl().getAdresse(rs.getInt("idAdr"));
                Cafe cafe = new Cafe(rs.getBoolean("espaceFumeur"),rs.getBoolean("tresseDispo"),
                rs.getString("libLocal"),rs.getInt("nbStars"),
                rs.getDouble("prix"),rs.getString("numTel"),
                rs.getBoolean("wifiDispo"),rs.getBoolean("toiletteDispo"),ville,adresse,rs.getInt("idVille"));
                cafes.add(cafe);
            }
            return cafes;
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return null;
    }

    @Override
    public boolean insertCafe(Cafe cafe) {
        Connection connection = ConnectionFactory.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO cafe VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?,"
             + "?)");
            ps.setBoolean(1, cafe.isEspaceFumeur());
            ps.setBoolean(2, cafe.isTresseDispo());
            ps.setString(3,cafe.getLibLocal());
            ps.setInt(4, cafe.getNbStars());
            ps.setDouble(5, cafe.getPrix());
            ps.setString(6,cafe.getNumTel());
            ps.setBoolean(7, cafe.isWifiDispo());
            ps.setBoolean(8, cafe.isToiletteDispo());
            ps.setInt(9, cafe.getVille().getId());
            ps.setInt(10, cafe.getAdresse().getId());
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
    public boolean updateCafe(Cafe cafe) {
      Connection connection = ConnectionFactory.getConnection();
        try {
   PreparedStatement ps = connection.prepareStatement("UPDATE cafe SET espaceFumeur=?, terasseDispo=?,"
           + " reservation=?, libLocal=? nbStars=? prix=? numTel=? wifiDispo=? toiletteDispo=?"
           + "idVille=? idAdr=? WHERE idCafe=?");
           
           ps.setBoolean(1, cafe.isEspaceFumeur());
            ps.setBoolean(2, cafe.isTresseDispo());
            ps.setString(3,cafe.getLibLocal());
            ps.setInt(4, cafe.getNbStars());
            ps.setDouble(5, cafe.getPrix());
            ps.setString(6,cafe.getNumTel());
            ps.setBoolean(7, cafe.isWifiDispo());
            ps.setBoolean(8, cafe.isToiletteDispo());
            ps.setInt(9, cafe.getVille().getId());
            ps.setInt(10, cafe.getAdresse().getId());
            ps.setInt(11, cafe.getId());
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
    public boolean deleteCafe(int id) {
            Connection connection = ConnectionFactory.getConnection();
        try {
            Statement stmt = connection.createStatement();
            int i = stmt.executeUpdate("DELETE FROM cafe WHERE idCafe=" + id);
            if(i == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return false;    }
    
}
