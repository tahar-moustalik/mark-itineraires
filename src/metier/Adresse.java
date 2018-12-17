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
public class Adresse {
    private  final int id;
    private String ligneAdr;
    private String codePostale;

    public Adresse(String ligneAdr, String codePostale,int id) {
        this.ligneAdr = ligneAdr;
        this.codePostale = codePostale;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getLigneAdr() {
        return ligneAdr;
    }

    public void setLigneAdr(String ligneAdr) {
        this.ligneAdr = ligneAdr;
    }

    public String getCodePostale() {
        return codePostale;
    }

    public void setCodePostale(String codePostale) {
        this.codePostale = codePostale;
    }
    
}
