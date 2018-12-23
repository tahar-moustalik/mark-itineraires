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
public class Musee  extends Local{
    private boolean cameraAccepte;

    public Musee(boolean cameraAccepte, int id, double longitude, double latitude, String libelle, int score, Ville ville, Adresse adresse, double prix, boolean wifiDsipo, boolean toiletteDispo) {
        super(id, longitude, latitude, libelle, score, ville, adresse, prix, wifiDsipo, toiletteDispo);
        this.cameraAccepte = cameraAccepte;
    }

    

    

    

    public boolean isCameraAccepte() {
        return cameraAccepte;
    }

    public void setCameraAccepte(boolean cameraAccepte) {
        this.cameraAccepte = cameraAccepte;
    }
    
    
}
