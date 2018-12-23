package controlleurs;

import controlleurs.algorithme.MinSpanningTree;
import dao.boitenuit.BoiteNuitDaoImpl;
import dao.cafe.CafeDaoImpl;
import dao.lieupublic.LieuPublicDaoImpl;
import dao.musee.MuseeDaoImpl;
import dao.restaurant.RestaurantDaoImpl;
import java.util.LinkedList;
import java.util.List;
import metier.BoiteNuit;
import metier.Cafe;
import metier.Itinerary;
import metier.LieuPublic;
import metier.Local;
import metier.Musee;
import metier.Restaurant;

/**
 *
 * @author tahar
 */
public class ItineraireControlleur {
    private final double DUREE_JOUR = 1.5;
    
    private MinSpanningTree mst;
    
    public ItineraireControlleur(){
         List<Local> locaux = new LinkedList<>();
         locaux.clear();
        mst = new MinSpanningTree();
        List<Restaurant> restaurants = new RestaurantDaoImpl().getAllRestaurants();
        restaurants.forEach((r)->{locaux.add(r);});
        List<Cafe> cafes = new CafeDaoImpl().getAllCafes();
        cafes.forEach((c)->{locaux.add(c);});
        List<LieuPublic> lieuPublics = new LieuPublicDaoImpl().getAllLieuPublics();
        lieuPublics.forEach((lp)->{locaux.add(lp);});
        List<Musee> musees = new MuseeDaoImpl().getAllMusees();
        musees.forEach((m)->{locaux.add(m);});
        List<BoiteNuit> boiteNuits = new BoiteNuitDaoImpl().getAllBoiteNuits();
        boiteNuits.forEach((bn)->{locaux.add(bn);});
        mst.setLocals(locaux);
       mst.pertuberListeLocaux();
         
    }
    
    public  LinkedList<Itinerary> getItineraires(int nbreJours){
        LinkedList<Itinerary> itinerairesGeneres = new LinkedList<>();
        LinkedList<Local> locauxTotal = mst.getMinSpanningTree();
        int cptJour = 1;
        int cptItineray = 0;
        while(cptJour < nbreJours & cptItineray < locauxTotal.size() -2){
            double dureeJourAccumule = 0;
            Itinerary itineray = new Itinerary(cptJour);
            while(dureeJourAccumule < DUREE_JOUR){
                itineray.ajoutLocal(locauxTotal.get(cptItineray));
                dureeJourAccumule += Local.getDuree(locauxTotal.get(cptItineray), locauxTotal.get(cptItineray+1))
                        + 0.2;
                cptItineray++;
            }
            itinerairesGeneres.add(itineray);
            cptJour++;
       
              }
        return itinerairesGeneres;
    }
    
}
