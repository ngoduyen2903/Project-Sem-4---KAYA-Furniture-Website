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
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author huynh
 */
@Stateless
public class OrdersFacade extends AbstractFacade<Orders> implements OrdersFacadeLocal {

    @PersistenceContext(unitName = "KAYA-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OrdersFacade() {
        super(Orders.class);
    }

    public List<Orders> getCustomerOrders(Customers c) {
        Query query = em.createQuery("SELECT o FROM Orders o WHERE o.customerID = :customerID");
        query.setParameter("customerID", c);
        return (List<Orders>) query.getResultList();
    }

    @Override
    public List<Orders> findAllByDate(Date startDate, Date endDate) {
        Query query = em.createQuery("SELECT o FROM Orders o WHERE o.orderDate between  :dateStart and  :endDate");
        query.setParameter("dateStart", startDate);
        query.setParameter("endDate", endDate);
        return (List<Orders>) query.getResultList();
    }

}
