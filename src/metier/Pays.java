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
