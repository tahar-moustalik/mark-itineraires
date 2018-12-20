package dao.boitenuit;

import java.util.List;
import metier.BoiteNuit;

/**
 *
 * @author tahar
 */
public interface IBoiteNuit {
     BoiteNuit getBoiteNuit(int id);
    List<BoiteNuit> getAllBoiteNuits();
    boolean insertBoiteNuit(BoiteNuit boiteNuit);
    boolean updateBoiteNuit(BoiteNuit boiteNuit);
    boolean deleteBoiteNuit(int id);
}
