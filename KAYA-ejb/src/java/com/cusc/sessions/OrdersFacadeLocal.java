/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cusc.sessions;

import com.cusc.entities.Customers;
import com.cusc.entities.Orders;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author huynh
 */
@Local
public interface OrdersFacadeLocal {

    void create(Orders orders);

    void edit(Orders orders);

    void remove(Orders orders);

    Orders find(Object id);

    List<Orders> findAll();

    List<Orders> findRange(int[] range);

    int count();

    public List<Orders> getCustomerOrders(Customers c);
    
    List<Orders> findAllByDate(Date startDate,Date endDate);
    
}
