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
            BoiteNuit boiteNuit = new BoiteNuit(rs.getString("style"),rs.getInt("capacite"),rs.getInt("idBoiteNuit"),
                rs.getDouble("longitude"), rs.getDouble("latitude"),rs.getString("libelle"),rs.getInt("score"),ville,adresse,
                rs.getDouble("prix"),rs.getBoolean("wifiDispo"),rs.getBoolean("toiletteDispo"));
                boiteNuits.add(boiteNuit);
            }
        
            return boiteNuits;
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return null;
    }

 


    
}
