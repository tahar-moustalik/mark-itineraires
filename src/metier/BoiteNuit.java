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
public class BoiteNuit extends Local{
    private String style;
    private int capacite;

    public BoiteNuit(String style, int capacite, String libLocal, int nbStars, double prix, String numTel, boolean wifiDispo, boolean toiletteDispo, Ville ville, Adresse adresse, int id) {
        super(libLocal, nbStars, prix, numTel, wifiDispo, toiletteDispo, ville, adresse, id);
        this.style = style;
        this.capacite = capacite;
    }

    

    public String getStyle() {
        return style;
    }

    

    public void setStyle(String style) {
        this.style = style;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }
    
    
}
