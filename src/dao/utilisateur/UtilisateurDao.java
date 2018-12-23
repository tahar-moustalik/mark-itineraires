package dao.utilisateur;

import java.util.List;
import metier.Utilisateur;

/**
 *
 * @author tahar
 */
public interface UtilisateurDao {
    Utilisateur getUtilisateur(int id);
    boolean chercherUtilisateur(String login , String password);
    List<Utilisateur> getAllUtilisateurs();
    boolean insertUtilisateur(Utilisateur utilisateur);
    boolean updateUtilisateur(Utilisateur utilisateur);
    boolean deleteUtilisateur(int id);
    
}
