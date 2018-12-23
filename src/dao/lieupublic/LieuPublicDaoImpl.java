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
    public LinkedList<LieuPublic> getAllLieuPublics() {
         Connection connection = ConnectionFactory.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM lieupublic");
            LinkedList<LieuPublic> lieuPublics = new LinkedList<>();
            while(rs.next())
            {
                Ville ville = new VilleDaoImpl().getVille(rs.getInt("idVille"));
                Adresse adresse = new AdresseDaoImpl().getAdresse(rs.getInt("idAdr"));
                LieuPublic lieuPublic = new LieuPublic(rs.getBoolean("activites"),rs.getBoolean("animalAccepte"),
                rs.getString("typeLieuPublic"),rs.getInt("idLieuPublic"),
                rs.getDouble("longitude"), rs.getDouble("latitude"),rs.getString("libelle"),rs.getInt("score"),ville,adresse,
                rs.getDouble("prix"),rs.getBoolean("wifiDispo"),rs.getBoolean("toiletteDispo"));
                lieuPublics.add(lieuPublic);
            }
            return lieuPublics;
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return null;
    }
    
}
