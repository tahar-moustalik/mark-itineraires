package dao.musee;

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
import metier.Musee;
import metier.Ville;

/**
 *
 * @author tahar
 */
public class MuseeDaoImpl implements IMuseeDao{
     @Override
    public Musee getMusee(int id) {
        Connection connection = ConnectionFactory.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM musee WHERE idMusee=" + id);
            if(rs.next())
            {
                Ville ville = new VilleDaoImpl().getVille(rs.getInt("idVille"));
                Adresse adresse = new AdresseDaoImpl().getAdresse(rs.getInt("idAdr"));
                Musee musee = new Musee(rs.getBoolean("cameraAccepte"),rs.getString("libLocal"),rs.getInt("nbStars"),
                rs.getDouble("prix"),rs.getString("numTel"),
                rs.getBoolean("wifiDispo"),rs.getBoolean("toiletteDispo"),ville,adresse,rs.getInt("idVille"));
                return musee;
            }
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return null;
    }

    @Override
    public List<Musee> getAllMusees() {
         Connection connection = ConnectionFactory.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM musee");
            List<Musee> musees = new LinkedList<>();
            while(rs.next())
            {
                Ville ville = new VilleDaoImpl().getVille(rs.getInt("idVille"));
                Adresse adresse = new AdresseDaoImpl().getAdresse(rs.getInt("idAdr"));
                 Musee musee = new Musee(rs.getBoolean("cameraAccepte"),rs.getString("libLocal"),rs.getInt("nbStars"),
                rs.getDouble("prix"),rs.getString("numTel"),
                rs.getBoolean("wifiDispo"),rs.getBoolean("toiletteDispo"),ville,adresse,rs.getInt("idVille"));
                musees.add(musee);
            }
            return musees;
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return null;
    }

    @Override
    public boolean insertMusee(Musee musee) {
        Connection connection = ConnectionFactory.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO musee VALUES (?, ?, ?, ?, ?, ?, ?,"
             + "?, ?)");
            ps.setBoolean(1, musee.isCameraAccepte());
            ps.setString(2,musee.getLibLocal());
            ps.setInt(3, musee.getNbStars());
            ps.setDouble(4, musee.getPrix());
            ps.setString(5,musee.getNumTel());
            ps.setBoolean(6, musee.isWifiDispo());
            ps.setBoolean(7, musee.isToiletteDispo());
            ps.setInt(8, musee.getVille().getId());
            ps.setInt(9, musee.getAdresse().getId());
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
    public boolean updateMusee(Musee musee) {
      Connection connection = ConnectionFactory.getConnection();
        try {
   PreparedStatement ps = connection.prepareStatement("UPDATE musee SET cameraAccepte=?,libLocal=? nbStars=? prix=? numTel=? wifiDispo=? toiletteDispo=?"
           + "idVille=? idAdr=? WHERE idMusee=?");
           
            ps.setBoolean(1, musee.isCameraAccepte());
            ps.setString(2,musee.getLibLocal());
            ps.setInt(3, musee.getNbStars());
            ps.setDouble(4, musee.getPrix());
            ps.setString(5,musee.getNumTel());
            ps.setBoolean(6, musee.isWifiDispo());
            ps.setBoolean(7, musee.isToiletteDispo());
            ps.setInt(8, musee.getVille().getId());
            ps.setInt(9, musee.getAdresse().getId());
            ps.setInt(10, musee.getId());
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
    public boolean deleteMusee(int id) {
            Connection connection = ConnectionFactory.getConnection();
        try {
            Statement stmt = connection.createStatement();
            int i = stmt.executeUpdate("DELETE FROM musee WHERE idMusee=" + id);
            if(i == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return false;    }
}
