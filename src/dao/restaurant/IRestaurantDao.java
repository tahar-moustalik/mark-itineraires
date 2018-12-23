/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.restaurant;

import java.util.List;
import metier.Restaurant;

/**
 *
 * @author tahar
 */
public interface IRestaurantDao {
    List<Restaurant> getAllRestaurants();
}
