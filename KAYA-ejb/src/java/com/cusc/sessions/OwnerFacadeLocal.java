/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cusc.sessions;

import com.cusc.entities.Owner;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author huynh
 */
@Local
public interface OwnerFacadeLocal {

    void create(Owner owner);

    void edit(Owner owner);

    void remove(Owner owner);

    Owner find(Object id);

    List<Owner> findAll();

    List<Owner> findRange(int[] range);

    int count();

    Owner loadByUsername(String username, String password);

    long getCountByUsernamePassword(String username, String password);

    Owner findByUsername(String username);
}
