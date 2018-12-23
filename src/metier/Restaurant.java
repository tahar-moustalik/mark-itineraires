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
public class Restaurant  extends Local{
    
    private int starMichelin;
    private boolean carteAccepte;
    private boolean reservation;

    public Restaurant(int starMichelin, boolean carteAccepte, boolean reservation, int id, double longitude, double latitude, String libelle, int score, Ville ville, Adresse adresse, double prix, boolean wifiDsipo, boolean toiletteDispo) {
        super(id, longitude, latitude, libelle, score, ville, adresse, prix, wifiDsipo, toiletteDispo);
        this.starMichelin = starMichelin;
        this.carteAccepte = carteAccepte;
        this.reservation = reservation;
    }

    

    

    

    public int getStarMichelin() {
        return starMichelin;
    }

    public void setStarMichelin(int starMichelin) {
        this.starMichelin = starMichelin;
    }

    public boolean isCarteAccepte() {
        return carteAccepte;
    }

    public void setCarteAccepte(boolean carteAccepte) {
        this.carteAccepte = carteAccepte;
    }

    public boolean isReservation() {
        return reservation;
    }

    public void setReservation(boolean reservation) {
        this.reservation = reservation;
    }
    
    
}
