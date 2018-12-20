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
import metier.Ville;

/**
 *
 * @author tahar
 */
public class RestaurantDaoImpl implements IRestaurantDao{
     @Override
    public Restaurant getRestaurant(int id) {
        Connection connection = ConnectionFactory.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM restaurant WHERE idRestau=" + id);
            if(rs.next())
            {
                Ville ville = new VilleDaoImpl().getVille(rs.getInt("idVille"));
                Adresse adresse = new AdresseDaoImpl().getAdresse(rs.getInt("idAdr"));
                Restaurant restaurant = new Restaurant(rs.getInt("starMichelin"),rs.getBoolean("carteAccepte"),
                rs.getBoolean("reservation"),rs.getString("libLocal"),rs.getInt("nbStars"),
                rs.getDouble("prix"),rs.getString("numTel"),
                rs.getBoolean("wifiDispo"),rs.getBoolean("toiletteDispo"),ville,adresse,rs.getInt("idRestau"));
                return restaurant;
            }
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return null;
    }

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
                Restaurant restaurant = new Restaurant(rs.getInt("starMichelin"),rs.getBoolean("carteAccepte"),
                rs.getBoolean("reservation"),rs.getString("libLocal"),rs.getInt("nbStars"),
                rs.getDouble("prix"),rs.getString("numTel"),
                rs.getBoolean("wifiDispo"),rs.getBoolean("toiletteDispo"),ville,adresse,rs.getInt("idRestau"));
                restaurants.add(restaurant);
            }
            return restaurants;
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return null;
    }

    @Override
    public boolean insertRestaurant(Restaurant restaurant) {
        Connection connection = ConnectionFactory.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO restaurant VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?,"
             + "?,?)");
            ps.setInt(1, restaurant.getStarMichelin());
            ps.setBoolean(2, restaurant.isCarteAccepte());
            ps.setBoolean(3, restaurant.isReservation());
            ps.setString(4,restaurant.getLibLocal());
            ps.setInt(5, restaurant.getNbStars());
            ps.setDouble(6, restaurant.getPrix());
            ps.setString(7,restaurant.getNumTel());
            ps.setBoolean(8, restaurant.isWifiDispo());
            ps.setBoolean(9, restaurant.isToiletteDispo());
            ps.setInt(10, restaurant.getVille().getId());
            ps.setInt(11, restaurant.getAdresse().getId());
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
    public boolean updateRestaurant(Restaurant restaurant) {
      Connection connection = ConnectionFactory.getConnection();
        try {
   PreparedStatement ps = connection.prepareStatement("UPDATE restaurant SET starMichellin=?, carteAccepte=?,"
           + " reservation=?, libLocal=? nbStars=? prix=? numTel=? wifiDispo=? toiletteDispo=?"
           + "idVille=? idAdr=? WHERE idRestau=?");
           
            ps.setInt(1, restaurant.getStarMichelin());
            ps.setBoolean(2, restaurant.isCarteAccepte());
            ps.setBoolean(3, restaurant.isReservation());
            ps.setString(4,restaurant.getLibLocal());
            ps.setInt(5, restaurant.getNbStars());
            ps.setDouble(6, restaurant.getPrix());
            ps.setString(7,restaurant.getNumTel());
            ps.setBoolean(8, restaurant.isWifiDispo());
            ps.setBoolean(9, restaurant.isToiletteDispo());
            ps.setInt(10, restaurant.getVille().getId());
            ps.setInt(11, restaurant.getAdresse().getId());
            ps.setInt(12, restaurant.getId());
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
    public boolean deleteRestaurant(int id) {
            Connection connection = ConnectionFactory.getConnection();
        try {
            Statement stmt = connection.createStatement();
            int i = stmt.executeUpdate("DELETE FROM restaurant WHERE idRestau=" + id);
            if(i == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return false;    }
}
