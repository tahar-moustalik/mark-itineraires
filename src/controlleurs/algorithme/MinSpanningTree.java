package controlleurs.algorithme;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import metier.Local;
// L'arbre Couvrant  de poids minimal
// Algo de Prim
public class MinSpanningTree {
    private static List<Local> locals = new LinkedList<>();

    public MinSpanningTree(){}

    public  LinkedList<Local> getMinSpanningTree(){
        LinkedList<Local> locauxVisites = new LinkedList<>();
        LinkedList<Local> locauxNonVisites = new LinkedList<>(locals);
       locauxVisites.add(locauxNonVisites.get(0));// choisir le point de debut ici toujours le local 0
       locauxNonVisites.remove(0);
       while(!locauxNonVisites.isEmpty()){
           double record = Double.POSITIVE_INFINITY;
           int indiceVisite = 0;
           int indiceNonVisite = 0;
           for(int i=0;i<locauxVisites.size();i++){
               for(int j=0;j<locauxNonVisites.size();j++){
                 double poidsSommetAdj = getPoidsArrete(locauxVisites.get(i), locauxNonVisites.get(j));
                 if(poidsSommetAdj < record){
                     record = poidsSommetAdj;
                     indiceVisite = i;
                     indiceNonVisite = j;
                 }
               }
           }
           locauxVisites.add(locauxNonVisites.get(indiceNonVisite));// choisir le point de debut ici toujours le local 0
           locauxNonVisites.remove(indiceNonVisite);
       }
return locauxVisites;
    }

    public static void setLocals(List<Local> locals) {
        MinSpanningTree.locals = locals;
    }

    public  void ajoutLocal(Local local){
        locals.add(local);
    }

  // calculer distance entre deux locaux  en KM avec la formule Haversine -> voir Class Haversine
    private static double getDistanceEntreLocaux(Local local1,Local local2){
        return Haversine.distance(local1.getLatitude(), local1.getLongitude(),
                local2.getLatitude(), local2.getLongitude());
    }
  // le poids d'arrete est calcule
    private static double getPoidsArrete(Local local1,Local local2){
        double distanceEntreLocaux = getDistanceEntreLocaux(local1, local2);
        double scoreLocaux = (double)1 / (local1.getScore() + local2.getScore());
        final double  vitesseMoy = 25; // vitesse moyenne de voyage entre deux locaux
        double tempsVoyageEntreLocaux = distanceEntreLocaux / vitesseMoy;
        return (distanceEntreLocaux + scoreLocaux + tempsVoyageEntreLocaux) / 3;
    }

    public static double[][] getMatriceAdjascence(){
        final double infinity = Double.POSITIVE_INFINITY;
        int nbreLocals = locals.size();
        double[][] matriceAdjascence = new double[nbreLocals][nbreLocals];
        for(int i=0;i<nbreLocals;i++){
            for(int j=0;j<nbreLocals;j++){
                if(i==j) matriceAdjascence[i][j] = infinity;
                else
                    matriceAdjascence[i][j] = getPoidsArrete(locals.get(i), locals.get(j));
            }
        }
        return matriceAdjascence;
    }
    
    public void pertuberListeLocaux(){
        Random r = new Random();
        int nbreIteration = locals.size();
        int cpt = 0;
        while(cpt < nbreIteration){
            int i =  r.ints(0, locals.size()).findFirst().getAsInt();
            int j =  r.ints(0,locals.size()).findFirst().getAsInt();
            if(i != j){
            Local temp;
            Local locali = locals.get(i);
            temp = locali;
            Local localj = locals.get(j);
            locals.set(i, localj);
            locals.set(j, temp);
            }
            ++cpt;
        }
    }



}
