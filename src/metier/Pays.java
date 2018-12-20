package metier;

/**
 *
 * @author tahar
 */
public class Pays {
    private  final int id;
    private final String libPays;

    public Pays(String libPays,int id) {
        this.libPays = libPays;
        this.id = id;
    }
    
    public String getLibPays() {
        return libPays;
    }

    public int getId() {
        return id;
    }
    
    
}
