/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbeans;

import com.cusc.entities.Customers;
import com.cusc.entities.Orders;
import com.cusc.entities.Products;
import com.cusc.sessions.CustomersFacadeLocal;
import com.cusc.sessions.OrdersFacadeLocal;
import com.cusc.sessions.ProductsFacadeLocal;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author odieng
 */
@Named(value = "statiticMB")
@RequestScoped
public class StatiticMB {

    @EJB
    private CustomersFacadeLocal customersFacade;

    @EJB
    private ProductsFacadeLocal productsFacade;

    @EJB
    private OrdersFacadeLocal ordersFacade;

    private int typeStatistic;
    private Date startDate;
    private Date endDate;
    private double totalPrice;
    private int quantitySoldProduct;
    private int quantitySoldCustomerPurchased;

    public StatiticMB() {
    }

    public void exportData() {

    }

    @PostConstruct
    public void init() {
        typeStatistic = 0;
        quantitySoldProduct = 0;
        quantitySoldCustomerPurchased = 0;
    }

    public String statisticDate() {
        System.out.println("---->" + startDate + " " + endDate + " " + typeStatistic);
        if (typeStatistic == 1) {
            getRevenu();
        }
        if (typeStatistic == 2) {
            getProductSold();
        }
        if (typeStatistic == 3) {
            getCustomerPurchased();
        }
        return "statistic";
    }

    private void getRevenu() {
        List<Orders> list = ordersFacade.findAllByDate(startDate, endDate);
        for (Orders orders : list) {
            totalPrice += orders.getTotalPrice().doubleValue();
        }
    }

    private void getProductSold() {
        List<Products> listPro = productsFacade.findAll();
        for (Products products : listPro) {
            if (!products.getOrderDetailsCollection().isEmpty()) {
                quantitySoldProduct += products.getOrderDetailsCollection().size();
            }
        }
    }

    private void getCustomerPurchased() {
        List<Customers> listCus = customersFacade.findAll();
        for (Customers cus : listCus) {
            if (!cus.getOrdersCollection().isEmpty()) {
                quantitySoldCustomerPurchased += cus.getOrdersCollection().size();
            }
        }
    }

    public int getQuantitySoldCustomerPurchased() {
        return quantitySoldCustomerPurchased;
    }

    public void setQuantitySoldCustomerPurchased(int quantitySoldCustomerPurchased) {
        this.quantitySoldCustomerPurchased = quantitySoldCustomerPurchased;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getTypeStatistic() {
        return typeStatistic;
    }

    public void setTypeStatistic(int typeStatistic) {
        this.typeStatistic = typeStatistic;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getQuantitySoldProduct() {
        return quantitySoldProduct;
    }

    public void setQuantitySoldProduct(int quantitySoldProduct) {
        this.quantitySoldProduct = quantitySoldProduct;
    }

}
