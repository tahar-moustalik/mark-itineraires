package metier;

import gestionstock.PassWordUtils;

/**
 *
 * @author tahar
 */

public class Utilisateur {
    private int idUser;
    private String login;
    private String password;
    private  final String salt= "7DIQnquYWGs3s1va8JOXinzDehhQoA";

    public String getSalt() {
        return salt;
    }

    

    public int getIdUser() {
        return idUser;
    }

    public void setId_user(int idUser) {
        this.idUser = idUser;
    }
    

    public Utilisateur() {
    }

    public Utilisateur(String login, String password) {
        this.login = login;
        this.password = PassWordUtils.generateSecurePassword(password, salt);
    }
    

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password, String salt) {
        this.password = PassWordUtils.generateSecurePassword(password, salt);
        
    }
    
    
    
}
