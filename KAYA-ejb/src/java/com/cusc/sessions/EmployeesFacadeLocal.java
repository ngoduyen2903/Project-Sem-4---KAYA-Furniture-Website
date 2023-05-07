/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cusc.sessions;

import com.cusc.entities.Employees;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author odieng
 */
@Local
public interface EmployeesFacadeLocal {

    void create(Employees employees);

    void edit(Employees employees);

    void remove(Employees employees);

    Employees find(Object id);

    List<Employees> findAll();

    List<Employees> findRange(int[] range);

    int count();

    public boolean checkLoginEmployee(String username, String password);

    Employees findByUsername(String username);

    Long loginEmployee(String username, String password);

    Employees loadByUsername(String username, String password);

    long getCountByUsernamePassword(String username, String password);

    public Employees checkExistLogin(String username);
    
    long getCountByUsername(String username);

}
