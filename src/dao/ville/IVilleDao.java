/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.ville;

import java.util.List;
import metier.Ville;

/**
 *
 * @author tahar
 */
public interface IVilleDao {
    Ville getVille(int id);
    List<Ville> getAllVilles();
    boolean insertVille(Ville ville);
    boolean updateVille(Ville ville);
    boolean deleteVille(int id);
}
