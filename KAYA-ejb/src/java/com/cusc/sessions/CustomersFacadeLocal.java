/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cusc.sessions;

import com.cusc.entities.Customers;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author huynh
 */
@Local
public interface CustomersFacadeLocal {

    void create(Customers customers);

    void edit(Customers customers);

    void remove(Customers customers);

    Customers find(Object id);

    List<Customers> findAll();

    List<Customers> findRange(int[] range);

    int count();

    Customers loadByUsername(String username,String password);

    long getCountByUsernamePassword(String username, String password);
    
    Customers findByUsername(String username);
      public Customers login(String username);

}
