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
public class LieuPublic extends Local{
    private boolean activites;
    private boolean animalAccepte;
    private String typeLieuPublic;

    public LieuPublic(boolean activites, boolean animalAccepte, String typeLieuPublic, String libLocal, int nbStars, double prix, String numTel, boolean wifiDispo, boolean toiletteDispo, Ville ville, Adresse adresse, int id) {
        super(libLocal, nbStars, prix, numTel, wifiDispo, toiletteDispo, ville, adresse, id);
        this.activites = activites;
        this.animalAccepte = animalAccepte;
        this.typeLieuPublic = typeLieuPublic;
    }

    

    public boolean isActivites() {
        return activites;
    }

    public void setActivites(boolean activites) {
        this.activites = activites;
    }

    public boolean isAnimalAccepte() {
        return animalAccepte;
    }

    public void setAnimalAccepte(boolean animalAccepte) {
        this.animalAccepte = animalAccepte;
    }

    public String getTypeLieuPublic() {
        return typeLieuPublic;
    }

    public void setTypeLieuPublic(String typeLieuPublic) {
        this.typeLieuPublic = typeLieuPublic;
    }
    
    
}
