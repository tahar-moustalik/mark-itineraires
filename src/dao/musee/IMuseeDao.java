package dao.musee;

import java.util.List;
import metier.Musee;

/**
 *
 * @author tahar
 */
public interface IMuseeDao {
    Musee getMusee(int id);
    List<Musee> getAllMusees();
    boolean insertMusee(Musee musee);
    boolean updateMusee(Musee musee);
    boolean deleteMusee(int id);
}
