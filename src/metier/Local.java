/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tahar
 */
public abstract class Local {
    private  final int id;
    private String libLocal;
    private int nbStars;
    private double prix;
    private String numTel;
    private boolean wifiDispo;
    private boolean toiletteDispo;
    private Ville ville;
    private Adresse adresse;
    private List<JourOuverture> joursOuvertures = new ArrayList<>();

    public Local(String libLocal, int nbStars, double prix, String numTel, boolean wifiDispo, boolean toiletteDispo, Ville ville, Adresse adresse,int id) {
        this.libLocal = libLocal;
        this.nbStars = nbStars;
        this.prix = prix;
        this.numTel = numTel;
        this.wifiDispo = wifiDispo;
        this.toiletteDispo = toiletteDispo;
        this.ville = ville;
        this.adresse = adresse;
        this.id = id;
    }

    public String getLibLocal() {
        return libLocal;
    }

    public int getId() {
        return id;
    }

    public void setLibLocal(String libLocal) {
        this.libLocal = libLocal;
    }

    public int getNbStars() {
        return nbStars;
    }

    public void setNbStars(int nbStars) {
        this.nbStars = nbStars;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getNumTel() {
        return numTel;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }

    public boolean isWifiDispo() {
        return wifiDispo;
    }

    public void setWifiDispo(boolean wifiDispo) {
        this.wifiDispo = wifiDispo;
    }

    public boolean isToiletteDispo() {
        return toiletteDispo;
    }

    public void setToiletteDispo(boolean toiletteDispo) {
        this.toiletteDispo = toiletteDispo;
    }

    public Ville getVille() {
        return ville;
    }

    public void setVille(Ville ville) {
        this.ville = ville;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public List<JourOuverture> getJoursOuvertures() {
        return joursOuvertures;
    }

    public void setJoursOuvertures(List<JourOuverture> joursOuvertures) {
        this.joursOuvertures = joursOuvertures;
    }
    
    public void ajouterJourOuverture(JourOuverture jourOuv){
        joursOuvertures.add(jourOuv);
    }
    
    
    
}
