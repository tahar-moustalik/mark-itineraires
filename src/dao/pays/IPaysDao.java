package dao.pays;

import java.util.List;
import metier.Pays;

/**
 *
 * @author tahar
 */
public interface IPaysDao {
    Pays getPays(int id);
    List<Pays> getAllPayss();
    boolean insertPays(Pays pays);
    boolean updatePays(Pays pays);
    boolean deletePays(int id);
}
