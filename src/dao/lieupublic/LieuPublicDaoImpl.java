package dao.lieupublic;

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
import metier.LieuPublic;
import metier.Ville;

/**
 *
 * @author tahar
 */
public class LieuPublicDaoImpl implements ILieuPublicDao{
      @Override
    public LieuPublic getLieuPublic(int id) {
        Connection connection = ConnectionFactory.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM lieuPublic WHERE idLieuPublic=" + id);
            if(rs.next())
            {
                Ville ville = new VilleDaoImpl().getVille(rs.getInt("idVille"));
                Adresse adresse = new AdresseDaoImpl().getAdresse(rs.getInt("idAdr"));
                LieuPublic lieuPublic = new LieuPublic(rs.getBoolean("activites"),rs.getBoolean("animalAccepte"),
                rs.getString("typeLieuPublic"),rs.getString("libLocal"),rs.getInt("nbStars"),
                rs.getDouble("prix"),rs.getString("numTel"),
                rs.getBoolean("wifiDispo"),rs.getBoolean("toiletteDispo"),ville,adresse,rs.getInt("idVille"));
                return lieuPublic;
            }
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return null;
    }

    @Override
    public List<LieuPublic> getAllLieuPublics() {
         Connection connection = ConnectionFactory.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM lieuPublic");
            List<LieuPublic> lieuPublics = new LinkedList<>();
            while(rs.next())
            {
                Ville ville = new VilleDaoImpl().getVille(rs.getInt("idVille"));
                Adresse adresse = new AdresseDaoImpl().getAdresse(rs.getInt("idAdr"));
                LieuPublic lieuPublic = new LieuPublic(rs.getBoolean("activites"),rs.getBoolean("animalAccepte"),
                rs.getString("typeLieuPublic"),rs.getString("libLocal"),rs.getInt("nbStars"),
                rs.getDouble("prix"),rs.getString("numTel"),
                rs.getBoolean("wifiDispo"),rs.getBoolean("toiletteDispo"),ville,adresse,rs.getInt("idVille"));
                lieuPublics.add(lieuPublic);
            }
            return lieuPublics;
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return null;
    }

    @Override
    public boolean insertLieuPublic(LieuPublic lieuPublic) {
        Connection connection = ConnectionFactory.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO lieuPublic VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?,"
             + "?, ?)");
            ps.setBoolean(1, lieuPublic.isActivites());
            ps.setBoolean(2, lieuPublic.isAnimalAccepte());
            ps.setString(3,lieuPublic.getTypeLieuPublic());
            ps.setString(4,lieuPublic.getLibLocal());
            ps.setInt(5, lieuPublic.getNbStars());
            ps.setDouble(6, lieuPublic.getPrix());
            ps.setString(7,lieuPublic.getNumTel());
            ps.setBoolean(8, lieuPublic.isWifiDispo());
            ps.setBoolean(9, lieuPublic.isToiletteDispo());
            ps.setInt(10, lieuPublic.getVille().getId());
            ps.setInt(11, lieuPublic.getAdresse().getId());
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
    public boolean updateLieuPublic(LieuPublic lieuPublic) {
      Connection connection = ConnectionFactory.getConnection();
        try {
   PreparedStatement ps = connection.prepareStatement("UPDATE lieuPublic SET activites=?, animalAccepte=?,"
           + " typeLieuPublic=?, libLocal=? nbStars=? prix=? numTel=? wifiDispo=? toiletteDispo=?"
           + "idVille=? idAdr=? WHERE idLieuPublic=?");
           
           ps.setBoolean(1, lieuPublic.isActivites());
            ps.setBoolean(2, lieuPublic.isAnimalAccepte());
            ps.setString(3,lieuPublic.getTypeLieuPublic());
            ps.setString(4,lieuPublic.getLibLocal());
            ps.setInt(5, lieuPublic.getNbStars());
            ps.setDouble(6, lieuPublic.getPrix());
            ps.setString(7,lieuPublic.getNumTel());
            ps.setBoolean(8, lieuPublic.isWifiDispo());
            ps.setBoolean(9, lieuPublic.isToiletteDispo());
            ps.setInt(10, lieuPublic.getVille().getId());
            ps.setInt(11, lieuPublic.getAdresse().getId());
            ps.setInt(12, lieuPublic.getId());
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
    public boolean deleteLieuPublic(int id) {
            Connection connection = ConnectionFactory.getConnection();
        try {
            Statement stmt = connection.createStatement();
            int i = stmt.executeUpdate("DELETE FROM lieuPublic WHERE idLieuPublic=" + id);
            if(i == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return false;    }
    
}
