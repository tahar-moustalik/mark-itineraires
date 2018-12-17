/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author tahar
 */
public class Itineraire {
    private  final int id;
    private LocalDate dateSauvegarde;
    private List<Local> locaux = new LinkedList<>();
    private Utilisateur utilisateur;
    private List<Choix> choixList = new LinkedList<>();

    public Itineraire(int id, LocalDate dateSauvegarde, Utilisateur utilisateur) {
        this.id = id;
        this.dateSauvegarde = dateSauvegarde;
        this.utilisateur = utilisateur;
    }

    public LocalDate getDateSauvegarde() {
        return dateSauvegarde;
    }

    public void setDateSauvegarde(LocalDate dateSauvegarde) {
        this.dateSauvegarde = dateSauvegarde;
    }

    public List<Local> getLocaux() {
        return locaux;
    }

    public int getId() {
        return id;
    }


    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public List<Choix> getChoix() {
        return choixList;
    }

   public void ajouterChoix(Choix choix){
       choixList.add(choix);
   }
    
    
    
}
