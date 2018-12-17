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
public class JourOuverture {
    private  final int id;
    private String libelle;
    private boolean etatOuvert;
    private int hrOuvDeb;
    private int hrOuvFin;

    public JourOuverture(String libelle, boolean etatOuvert, int hrOuvDeb, int hrOuvFin,int id) {
        this.libelle = libelle;
        this.etatOuvert = etatOuvert;
        this.hrOuvDeb = hrOuvDeb;
        this.hrOuvFin = hrOuvFin;
        this.id = id;
    }

    public int getId() {
        return id;
    }



    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public boolean isEtatOuvert() {
        return etatOuvert;
    }

    public void setEtatOuvert(boolean etatOuvert) {
        this.etatOuvert = etatOuvert;
    }

    public int getHrOuvDeb() {
        return hrOuvDeb;
    }

    public void setHrOuvDeb(int hrOuvDeb) {
        this.hrOuvDeb = hrOuvDeb;
    }

    public int getHrOuvFin() {
        return hrOuvFin;
    }

    public void setHrOuvFin(int hrOuvFin) {
        this.hrOuvFin = hrOuvFin;
    }
    
    
}
