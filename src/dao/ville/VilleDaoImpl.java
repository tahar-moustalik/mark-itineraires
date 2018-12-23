
package dao.ville;
import metier.Ville;
import dao.ConnectionFactory;
import dao.pays.PaysDaoImpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import metier.Pays;

/**
 *
 * @author tahar
 */
public class VilleDaoImpl implements IVilleDao{
     @Override
    public Ville getVille(int id) {
        Connection connection = ConnectionFactory.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM ville WHERE idVille=" + id);
            if(rs.next())
            {
                Pays pays = new PaysDaoImpl().getPays(rs.getInt("idPays"));
                Ville ville = new Ville(rs.getString("libVille"),pays,rs.getInt("idVille"));
                return ville;
            }
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return null;
    }

    @Override
    public List<Ville> getAllVilles() {
         Connection connection = ConnectionFactory.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM ville");
            List<Ville> villes = new LinkedList<>();
            while(rs.next())
            {
            Pays pays = new PaysDaoImpl().getPays(rs.getInt("idPays"));
             Ville ville = new Ville(rs.getString("libVille"),pays,rs.getInt("id"));
                villes.add(ville);
            }
            return villes;
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return null;
    }

    @Override
    public boolean insertVille(Ville ville) {
        Connection connection = ConnectionFactory.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO ville VALUES (?, ?)");
            ps.setString(2,ville.getLibVille());
            ps.setInt(3,ville.getPays().getId());
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
    public boolean updateVille(Ville ville) {
      Connection connection = ConnectionFactory.getConnection();
        try {
   PreparedStatement ps = connection.prepareStatement("UPDATE ville SET libVille=? WHERE idVille=?");
           
            ps.setString(1, ville.getLibVille());
            ps.setInt(2, ville.getId());
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
    public boolean deleteVille(int id) {
            Connection connection = ConnectionFactory.getConnection();
        try {
            Statement stmt = connection.createStatement();
            int i = stmt.executeUpdate("DELETE FROM ville WHERE idVille=" + id);
            if(i == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return false;    }
}
