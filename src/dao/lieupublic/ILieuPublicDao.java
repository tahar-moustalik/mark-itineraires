package dao.lieupublic;

import java.util.List;
import metier.LieuPublic;

/**
 *
 * @author tahar
 */
public interface ILieuPublicDao {
    LieuPublic getLieuPublic(int id);
    List<LieuPublic> getAllLieuPublics();
    boolean insertLieuPublic(LieuPublic lieuPublic);
    boolean updateLieuPublic(LieuPublic lieuPublic);
    boolean deleteLieuPublic(int id);
    
}
