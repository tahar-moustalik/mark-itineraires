/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.adresse;
import metier.Adresse;
import dao.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author tahar
 */
public class AdresseDaoImpl implements IAdresseDao{
     @Override
    public Adresse getAdresse(int id) {
        Connection connection = ConnectionFactory.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM adresse WHERE idAdr=" + id);
            if(rs.next())
            {
                Adresse adresse = new Adresse(rs.getString("ligneAdr"),rs.getString("codePostale"),rs.getInt("idAdr"));
                return adresse;
            }
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return null;
    }

    @Override
    public List<Adresse> getAllAdresses() {
         Connection connection = ConnectionFactory.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM adresse");
            List<Adresse> adresses = new LinkedList<>();
            while(rs.next())
            {
             Adresse adresse = new Adresse(rs.getString("ligneAdr"),rs.getString("codePostale"),rs.getInt("id"));
             adresses.add(adresse);
            }
            return adresses;
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return null;
    }

    @Override
    public boolean insertAdresse(Adresse adresse) {
        Connection connection = ConnectionFactory.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO adresse VALUES (?, ?)");
            ps.setString(2,adresse.getLigneAdr());
            ps.setString(3,adresse.getCodePostale());
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
    public boolean updateAdresse(Adresse adresse) {
      Connection connection = ConnectionFactory.getConnection();
        try {
   PreparedStatement ps = connection.prepareStatement("UPDATE adresse SET ligneAdr=?, codePostale=? WHERE idAdr=?");
           
            ps.setString(1, adresse.getLigneAdr());
            ps.setString(2, adresse.getCodePostale());
            ps.setInt(3, adresse.getId());
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
    public boolean deleteAdresse(int id) {
            Connection connection = ConnectionFactory.getConnection();
        try {
            Statement stmt = connection.createStatement();
            int i = stmt.executeUpdate("DELETE FROM adresse WHERE idAdr=" + id);
            if(i == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return false;    }
}
