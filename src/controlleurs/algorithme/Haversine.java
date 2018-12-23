package controlleurs.algorithme;

public class Haversine {
    private static final int RAYON_TERRE = 6371; // rayon approximatif de la terre

    public static double distance(double debLat, double debLong,
                                  double finLat, double finLong) {

        double dLat  = Math.toRadians((finLat - debLat));
        double dLong = Math.toRadians((finLong - debLong));

        debLat = Math.toRadians(debLat);
        finLat   = Math.toRadians(finLat);

        double a = haversin(dLat) + Math.cos(debLat) * Math.cos(finLat) * haversin(dLong);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return RAYON_TERRE * c; // <-- d
    }

    private static double haversin(double val) {
        return Math.pow(Math.sin(val / 2), 2);
    }
}