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
    private String capacite;

    public BoiteNuit(String style, String capacite, String libLocal, int nbStars, double prix, String numTel, boolean wifiDispo, boolean toiletteDispo, Ville ville, Adresse adresse, int id) {
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

    public String getCapacite() {
        return capacite;
    }

    public void setCapacite(String capacite) {
        this.capacite = capacite;
    }
    
    
}
