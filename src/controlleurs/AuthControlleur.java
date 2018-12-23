package controlleurs;

import dao.utilisateur.UtilisateurDaoImpl;
import metier.Utilisateur;

/**
 *
 * @author tahar
 */
public class AuthControlleur {
    
    
    public static boolean authentifierUtilisateur(Utilisateur utilisateur){
        return new UtilisateurDaoImpl().chercherUtilisateur(utilisateur.getLogin(),
                utilisateur.getPassword());
    }
    
    public static boolean inscireUtilisateur(Utilisateur utilisateur){
        return new UtilisateurDaoImpl().insertUtilisateur(utilisateur);
                
    }
}
