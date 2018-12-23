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

    public Cafe(boolean espaceFumeur, boolean tresseDispo, int id, double longitude, double latitude, String libelle, int score, Ville ville, Adresse adresse, double prix, boolean wifiDsipo, boolean toiletteDispo) {
        super(id, longitude, latitude, libelle, score, ville, adresse, prix, wifiDsipo, toiletteDispo);
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
