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
public class Choix {
    private  final int id;
    private boolean coche;
    private Filtre filtre;

    public Choix(int id, boolean coche, Filtre filtre) {
        this.id = id;
        this.coche = coche;
        this.filtre = filtre;
    }

    public int getId() {
        return id;
    }
    

    public boolean isCoche() {
        return coche;
    }

    public void setCoche(boolean coche) {
        this.coche = coche;
    }

    public Filtre getFiltre() {
        return filtre;
    }

    public void setFiltre(Filtre filtre) {
        this.filtre = filtre;
    }
    
    
    
    
}
