package dao.restaurant;
import metier.Restaurant;
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
public class RestaurantDaoImpl implements IRestaurantDao{
    @Override
    public List<Restaurant> getAllRestaurants() {
         Connection connection = ConnectionFactory.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM restaurant");
            List<Restaurant> restaurants = new LinkedList<>();
            while(rs.next())
            {
                Ville ville = new VilleDaoImpl().getVille(rs.getInt("idVille"));
                Adresse adresse = new AdresseDaoImpl().getAdresse(rs.getInt("idAdr"));
    
              Restaurant restaurant = new Restaurant(rs.getInt("starMichellin"),rs.getBoolean("carteDispo"),
                rs.getBoolean("reservation"),rs.getInt("idRestau"),
                rs.getDouble("longitude"), rs.getDouble("latitude"),rs.getString("libelle"),rs.getInt("score"),ville,adresse,
                rs.getDouble("prix"),rs.getBoolean("wifiDispo"),rs.getBoolean("toiletteDispo"));
                restaurants.add(restaurant);
            }
            return restaurants;
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return null;
    }

}
