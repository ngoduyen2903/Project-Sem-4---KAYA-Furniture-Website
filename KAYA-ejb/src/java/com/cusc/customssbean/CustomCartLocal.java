/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cusc.customssbean;

import java.util.Map;
import javax.ejb.Local;

/**
 *
 * @author odieng
 */
@Local
public interface CustomCartLocal {

    void addCart(Long id, Integer qual);

    public Map<Long, Integer> showCartMap();

    public int countCart();

    public void removeCart(Long id);

    public void emptyCart();

    public void updateCart(Long id, int quantity);
    
    void plusCart(Long id);
    
    void deCart(Long id);
    
    void clearCart();
}
