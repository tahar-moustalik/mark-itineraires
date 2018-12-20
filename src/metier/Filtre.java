package metier;

/**
 *
 * @author tahar
 */
public class Filtre {
    private  final int id;
    private String libelle;

    public Filtre(int id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public int getId() {
        return id;
    }
    
    
}
