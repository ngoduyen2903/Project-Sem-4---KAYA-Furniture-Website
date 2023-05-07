/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbeans;

import com.cusc.entities.Orders;
import com.cusc.entities.Products;
import com.cusc.sessions.CustomersFacadeLocal;
import com.cusc.sessions.OrdersFacadeLocal;
import com.cusc.sessions.ProductsFacadeLocal;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author odieng
 */
@Named(value = "adminHomeMB")
@RequestScoped
public class AdminHomeMB {

    @EJB
    private OrdersFacadeLocal ordersFacade;

    @EJB
    private ProductsFacadeLocal productsFacade;

    @EJB
    private CustomersFacadeLocal customersFacade;

    /**
     * Creates a new instance of AdminHomeMB
     */
    private long totalOfProduct;
    private long totalOfCustomer;
    private long totalProductSold = 0;
    private double totalOrder = 0;

    @PostConstruct
    public void init() {
        totalOfCustomer = customersFacade.count();
        totalOfProduct = customersFacade.count();
        for (Orders orders : ordersFacade.findAll()) {
            totalOrder += orders.getTotalPrice().doubleValue();
        }
        for (Products products : productsFacade.findAll()) {
            if (!products.getOrderDetailsCollection().isEmpty()) {
                totalProductSold += products.getOrderDetailsCollection().size();
            }
        }

    }

    public AdminHomeMB() {
    }

    public long getTotalOfProduct() {
        return totalOfProduct;
    }

    public void setTotalOfProduct(long totalOfProduct) {
        this.totalOfProduct = totalOfProduct;
    }

    public long getTotalOfCustomer() {
        return totalOfCustomer;
    }

    public void setTotalOfCustomer(long totalOfCustomer) {
        this.totalOfCustomer = totalOfCustomer;
    }

    public double getTotalOrder() {
        return totalOrder;
    }

    public void setTotalOrder(double totalOrder) {
        this.totalOrder = totalOrder;
    }

    public long getTotalProductSold() {
        return totalProductSold;
    }

    public void setTotalProductSold(long totalProductSold) {
        this.totalProductSold = totalProductSold;
    }

}
