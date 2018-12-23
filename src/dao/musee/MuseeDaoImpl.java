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
                  Musee musee = new Musee(rs.getBoolean("cameraAccepte"),rs.getInt("idMusee"),
                rs.getDouble("longitude"), rs.getDouble("latitude"),rs.getString("libelle"),rs.getInt("score"),ville,adresse,
                rs.getDouble("prix"),rs.getBoolean("wifiDispo"),rs.getBoolean("toiletteDispo"));
                musees.add(musee);
            }
            return musees;
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return null;
    }

  
}
