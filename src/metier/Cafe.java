/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

/**
 *
 * @author tahar
 */
public class Cafe  extends Local{
    private boolean espaceFumeur;
    private boolean tresseDispo;

    public Cafe(boolean espaceFumeur, boolean tresseDispo, String libLocal, int nbStars, double prix, String numTel, boolean wifiDispo, boolean toiletteDispo, Ville ville, Adresse adresse, int id) {
        super(libLocal, nbStars, prix, numTel, wifiDispo, toiletteDispo, ville, adresse, id);
        this.espaceFumeur = espaceFumeur;
        this.tresseDispo = tresseDispo;
    }

    

    public boolean isEspaceFumeur() {
        return espaceFumeur;
    }

    public void setEspaceFumeur(boolean espaceFumeur) {
        this.espaceFumeur = espaceFumeur;
    }

    public boolean isTresseDispo() {
        return tresseDispo;
    }

    public void setTresseDispo(boolean tresseDispo) {
        this.tresseDispo = tresseDispo;
    }
    
    
    
}
