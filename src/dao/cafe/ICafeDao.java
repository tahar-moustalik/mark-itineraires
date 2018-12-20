package dao.cafe;

import java.util.List;
import metier.Cafe;

/**
 *
 * @author tahar
 */
public interface ICafeDao {
    Cafe getCafe(int id);
    List<Cafe> getAllCafes();
    boolean insertCafe(Cafe cafe);
    boolean updateCafe(Cafe cafe);
    boolean deleteCafe(int id);
}
