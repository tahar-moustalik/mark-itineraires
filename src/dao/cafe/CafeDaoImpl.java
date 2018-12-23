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
import metier.BoiteNuit;
import metier.Cafe;
import metier.Ville;

/**
 *
 * @author tahar
 */
public class CafeDaoImpl implements ICafeDao{


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
                  Cafe cafe = new Cafe(rs.getBoolean("espaceFumeur"),rs.getBoolean("terrasseDispo"),rs.getInt("idCafe"),
                rs.getDouble("longitude"), rs.getDouble("latitude"),rs.getString("libelle"),rs.getInt("score"),ville,adresse,
                rs.getDouble("prix"),rs.getBoolean("wifiDispo"),rs.getBoolean("toiletteDispo"));
                cafes.add(cafe);
            }
            return cafes;
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return null;
    }

    
}
