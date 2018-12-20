package metier;

/**
 *
 * @author tahar
 */
public class Ville {
    private  final int id;
    private String libVille;
    private Pays pays;

    public Ville(String libVille, Pays pays,int id) {
        this.libVille = libVille;
        this.pays = pays;
        this.id = id;
    }

    public String getLibVille() {
        return libVille;
    }

    public int getId() {
        return id;
    }
    

    public void setLibVille(String libVille) {
        this.libVille = libVille;
    }

    public Pays getPays() {
        return pays;
    }

    public void setPays(Pays pays) {
        this.pays = pays;
    }
    
    
}
