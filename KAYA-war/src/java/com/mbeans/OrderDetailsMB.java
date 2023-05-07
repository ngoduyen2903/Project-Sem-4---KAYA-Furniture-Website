/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbeans;

import com.cusc.entities.Customers;
import com.cusc.entities.OrderDetails;
import com.cusc.sessions.CustomersFacadeLocal;
import com.cusc.sessions.OrderDetailsFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author odieng
 */
@Named(value = "orderDetailsMB")
@RequestScoped
public class OrderDetailsMB {

    @EJB
    private CustomersFacadeLocal customersFacade;
    @EJB
    private OrderDetailsFacadeLocal orderDetailsFacade;

    private Long id;
    private Double priceEach;
    private int quantityOrdered;
    private Double totalPrice;
    private Long orderID;
    private Integer idCus;

    /**
     * Creates a new instance of OrderDetailsMB
     */
    public OrderDetailsMB() {
        
    }

//    public List<OrderDetails> showAllOrderDetails() {
//        Customers cus = customersFacade.findByUsername();
//        return orderDetailsFacade.findByAllCustomerId(customer.getCustomerID());
//    }
}
