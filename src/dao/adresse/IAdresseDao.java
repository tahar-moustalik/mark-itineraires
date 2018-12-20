/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.adresse;

import java.util.List;
import metier.Adresse;

/**
 *
 * @author tahar
 */
public interface IAdresseDao {
    Adresse getAdresse(int id);
    List<Adresse> getAllAdresses();
    boolean insertAdresse(Adresse adresse);
    boolean updateAdresse(Adresse adresse);
    boolean deleteAdresse(int id);
}
