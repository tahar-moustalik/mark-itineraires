package dao.utilisateur;

import dao.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import metier.Utilisateur;

/**
 *
 * @author tahar
 */
public class UtilisateurDaoImpl implements UtilisateurDao{
      @Override
    public Utilisateur getUtilisateur(int id) {
        Connection connection = ConnectionFactory.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM utilisateur WHERE idUser=" + id);
            if(rs.next())
            {
                Utilisateur utilisateur = new Utilisateur(rs.getString("login"),
                        rs.getString("password"));
                return utilisateur;
            }
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return null;
    }

    @Override
    public List<Utilisateur> getAllUtilisateurs() {
         Connection connection = ConnectionFactory.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM utilisateur");
            List<Utilisateur> utilisateurs = new LinkedList<>();
            while(rs.next())
            {
             Utilisateur utilisateur = new Utilisateur(rs.getString("login"),
                        rs.getString("password"));
             utilisateurs.add(utilisateur);
            }
            return utilisateurs;
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return null;
    }

    @Override
    public boolean insertUtilisateur(Utilisateur utilisateur) {
        Connection connection = ConnectionFactory.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO utilisateur VALUES (0, ?, ?)");
            ps.setString(1,utilisateur.getLogin());
            ps.setString(2,utilisateur.getPassword());
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
    public boolean updateUtilisateur(Utilisateur utilisateur) {
      Connection connection = ConnectionFactory.getConnection();
        try {
   PreparedStatement ps = connection.prepareStatement("UPDATE utilisateur SET login=?, password=? WHERE idUser=?");
           
             ps.setString(1,utilisateur.getLogin());
            ps.setString(2,utilisateur.getPassword());
            ps.setInt(3, utilisateur.getIdUser());
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
    public boolean deleteUtilisateur(int id) {
            Connection connection = ConnectionFactory.getConnection();
        try {
            Statement stmt = connection.createStatement();
            int i = stmt.executeUpdate("DELETE FROM utilisateur WHERE idUser=" + id);
            if(i == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return false;    }

    @Override
    public boolean chercherUtilisateur(String login, String password) {
        Connection connection = ConnectionFactory.getConnection();
        try {
   PreparedStatement ps = connection.prepareStatement("SELECT * from utilisateur WHERE login=? and password=?");
           
             ps.setString(1,login);
            ps.setString(2,password);
            ResultSet rs = ps.executeQuery();
            if(rs.next() == false) {
                return false;
            }
            else{
                return true;
            }
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return false;
    }
}
