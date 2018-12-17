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

    public Musee(boolean cameraAccepte, String libLocal, int nbStars, double prix, String numTel, boolean wifiDispo, boolean toiletteDispo, Ville ville, Adresse adresse, int id) {
        super(libLocal, nbStars, prix, numTel, wifiDispo, toiletteDispo, ville, adresse, id);
        this.cameraAccepte = cameraAccepte;
    }

    

    public boolean isCameraAccepte() {
        return cameraAccepte;
    }

    public void setCameraAccepte(boolean cameraAccepte) {
        this.cameraAccepte = cameraAccepte;
    }
    
    
}
