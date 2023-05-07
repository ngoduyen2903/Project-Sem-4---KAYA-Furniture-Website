/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cusc.sessions;

import com.cusc.entities.Promotions;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author huynh
 */
@Local
public interface PromotionsFacadeLocal {

    void create(Promotions promotions);

    void edit(Promotions promotions);

    void remove(Promotions promotions);

    Promotions find(Object id);

    List<Promotions> findAll();

    List<Promotions> findRange(int[] range);

    int count();
    
}
