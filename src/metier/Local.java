package metier;

import controlleurs.algorithme.Haversine;

public abstract class Local {
    private int id;
    private double longitude;
    private double latitude;
    private String libelle;
    private int score;
    private Ville ville;
    private Adresse adresse;
    private double prix;
    private boolean wifiDsipo;
    private boolean toiletteDispo;

    public Local(int id, double longitude, double latitude, String libelle, int score, Ville ville, Adresse adresse, double prix, boolean wifiDsipo, boolean toiletteDispo) {
        this.id = id;
        this.longitude = longitude;
        this.latitude = latitude;
        this.libelle = libelle;
        this.score = score;
        this.ville = ville;
        this.adresse = adresse;
        this.prix = prix;
        this.wifiDsipo = wifiDsipo;
        this.toiletteDispo = toiletteDispo;
    }

    
    

    

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
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

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public boolean isWifiDsipo() {
        return wifiDsipo;
    }

    public void setWifiDsipo(boolean wifiDsipo) {
        this.wifiDsipo = wifiDsipo;
    }

    public boolean isToiletteDispo() {
        return toiletteDispo;
    }

    public void setToiletteDispo(boolean toiletteDispo) {
        this.toiletteDispo = toiletteDispo;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
    public static double getDuree(Local local1,Local local2){
        double distanceEntreLocaux = Haversine.distance(local1.getLatitude(),
                local1.getLongitude(), local2.getLatitude(), local2.getLongitude());
        double vitesseMoyenne ;
        if(distanceEntreLocaux < 4){
            vitesseMoyenne = 5;
        }
        else if(distanceEntreLocaux > 4 && distanceEntreLocaux < 35){
            vitesseMoyenne = 30;
        }
        else if(distanceEntreLocaux > 35 && distanceEntreLocaux < 300){
            vitesseMoyenne = 120;
        }
        else{
            vitesseMoyenne = 885;
        }
        return distanceEntreLocaux / vitesseMoyenne;

    }
}
