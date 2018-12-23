/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author tahar
 */
public class Itinerary { 
    private  final int id;
    private List<Local> locaux = new LinkedList<>();

    public Itinerary(int id) {
        this.id = id;
    }

    public List<Local> getLocaux() {
        return locaux;
    }

    public int getId() {
        return id;
    }

    public void setLocaux(List<Local> locaux) {
        this.locaux = locaux;
    }
    
    public void ajoutLocal(Local local){
        locaux.add(local);
    }
}
