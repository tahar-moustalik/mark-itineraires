package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private static final String  CHEMIN = "jdbc:mysql://localhost:3306/mini-projet-java";
    private static final String UTILISATEUR = "root";
    private static final String  PASS = "";

    public static Connection getConnection()
    {
        try {

            return DriverManager.getConnection(CHEMIN, UTILISATEUR, PASS);
        } catch (SQLException ex) {
            throw new RuntimeException("Erreur de connexion a la base de donnes", ex);
        }
    }

}
