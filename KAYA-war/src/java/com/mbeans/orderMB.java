/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbeans;

import com.cusc.customssbean.CustomCartLocal;
import com.cusc.entities.Customers;
import com.cusc.entities.OrderDetails;
import com.cusc.entities.Orders;
import com.cusc.sessions.CustomersFacadeLocal;
import com.cusc.sessions.OrderDetailsFacadeLocal;
import com.cusc.sessions.OrdersFacadeLocal;
import com.cusc.sessions.ProductsFacadeLocal;
import java.util.ArrayList;
import javax.inject.Named;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author This PC
 */
@Named(value = "orderMB")
@RequestScoped
public class orderMB {

    @EJB
    private ProductsFacadeLocal productsFacade;

    @EJB
    private OrderDetailsFacadeLocal orderDetailsFacade;

    @EJB
    private CustomersFacadeLocal customersFacade;

    @EJB
    private OrdersFacadeLocal ordersFacade;

    private Orders orders;
    private Integer orderID;
    private Long customerID;
    private Long employeeID;
    private Long totalAmount;
    private Long totalPrice;
    private String pay;
    private String note;
    private Long status;

    public orderMB() {
        orders = new Orders();
    }

    public List<Orders> showAllOrders() {
        return ordersFacade.findAll();
    }

    public void confirmOrder(Integer id) {
        Orders o = ordersFacade.find(id);
        o.setStatus(1);
        ordersFacade.edit(o);
    }

    public List<Orders> showCustomerOrders(Long userID) {
        Customers c = customersFacade.find(userID);
        List<Orders> listOrder = ordersFacade.getCustomerOrders(c);
        return listOrder;
    }

    public double calculateTotalAmount(int id) {
        List<OrderDetails> listOrderDetails = orderDetailsFacade.findAll();
        double totalAmount = 0;

        for (int i = 0; i < listOrderDetails.size(); i++) {
            OrderDetails o = listOrderDetails.get(i);
            if (o.getOrderDetailsPK().getOrderID() == id) {
                totalAmount = totalAmount + (o.getQuantity() * o.getUnitPrice().doubleValue());
            }
        }

        return totalAmount;
    }

    public void cancelOrder(Integer id) {
        Orders o = ordersFacade.find(id);
        o.setStatus(3);
        ordersFacade.edit(o);
    }

    public void receiveOrder(Integer id) {
        Orders o = ordersFacade.find(id);
        o.setStatus(2);
        ordersFacade.edit(o);
    }

    public String view() {
        return "orders";
    }

    public List<OrderDetails> listOrderDetail(int id) {

        List<OrderDetails> listOrderDetails = orderDetailsFacade.findAll();
        List<OrderDetails> list = new ArrayList<>();
        Orders o = ordersFacade.find(id);
        if (o != null) {
            for (int i = 0; i < listOrderDetails.size(); i++) {
                OrderDetails od = listOrderDetails.get(i);
                if (od.getOrderDetailsPK().getOrderID() == id) {
                    list.add(od);
                }
            }
        }
        return list;
    }

    public String findProductImg(Long id) {
        return productsFacade.find(id).getImage();
    }

    public String findProductName(Long id) {
        return productsFacade.find(id).getProductName();
    }

    public void viewOrder(Integer id) {
        orders = ordersFacade.find(id);
        List<OrderDetails> list = new ArrayList<>();
        Orders o = ordersFacade.find(id);
        if (o != null) {
            list = (List<OrderDetails>) o.getOrderDetailsCollection();
        }
    }

    public OrdersFacadeLocal getOrdersFacade() {
        return ordersFacade;
    }

    public void setOrdersFacade(OrdersFacadeLocal ordersFacade) {
        this.ordersFacade = ordersFacade;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public Integer getOrderID() {
        return orderID;
    }

    public void setOrderID(Integer orderID) {
        this.orderID = orderID;
    }

    public Long getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Long customerID) {
        this.customerID = customerID;
    }

    public Long getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Long employeeID) {
        this.employeeID = employeeID;
    }

    public Long getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Long totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getPay() {
        return pay;
    }

    public void setPay(String pay) {
        this.pay = pay;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public ProductsFacadeLocal getProductsFacade() {
        return productsFacade;
    }

    public void setProductsFacade(ProductsFacadeLocal productsFacade) {
        this.productsFacade = productsFacade;
    }

    public OrderDetailsFacadeLocal getOrderDetailsFacade() {
        return orderDetailsFacade;
    }

    public void setOrderDetailsFacade(OrderDetailsFacadeLocal orderDetailsFacade) {
        this.orderDetailsFacade = orderDetailsFacade;
    }

    public CustomersFacadeLocal getCustomersFacade() {
        return customersFacade;
    }

    public void setCustomersFacade(CustomersFacadeLocal customersFacade) {
        this.customersFacade = customersFacade;
    }

}
