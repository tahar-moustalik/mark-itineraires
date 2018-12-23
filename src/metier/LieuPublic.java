package metier;

/**
 *
 * @author tahar
 */
public class LieuPublic extends Local{
    private boolean activites;
    private boolean animalAccepte;
    private String typeLieuPublic;

    public LieuPublic(boolean activites, boolean animalAccepte, String typeLieuPublic, int id, double longitude, double latitude, String libelle, int score, Ville ville, Adresse adresse, double prix, boolean wifiDsipo, boolean toiletteDispo) {
        super(id, longitude, latitude, libelle, score, ville, adresse, prix, wifiDsipo, toiletteDispo);
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
