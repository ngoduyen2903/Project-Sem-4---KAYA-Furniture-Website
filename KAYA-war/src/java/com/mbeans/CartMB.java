/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbeans;

import com.cusc.customssbean.CustomCartLocal;
import com.cusc.entities.Customers;
import com.cusc.entities.Employees;
import com.cusc.entities.OrderDetails;
import com.cusc.entities.OrderDetailsPK;
import com.cusc.entities.Orders;
import com.cusc.entities.Products;
import com.cusc.entities.Promotions;
import com.cusc.sessions.CartSessionBeanLocal;
import com.cusc.sessions.CustomersFacadeLocal;
import com.cusc.sessions.EmployeesFacadeLocal;
import com.cusc.sessions.OrderDetailsFacadeLocal;
import com.cusc.sessions.OrdersFacadeLocal;
import com.cusc.sessions.ProductsFacadeLocal;
import com.modals.CartShopping;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.ejb.EJB;
import javax.inject.Inject;

/**
 *
 * @author odieng
 */
@Named(value = "cartMB")
@SessionScoped
public class CartMB implements Serializable {

    @EJB
    private OrderDetailsFacadeLocal orderDetailsFacade;

    @EJB
    private OrdersFacadeLocal ordersFacade;

    @EJB
    private EmployeesFacadeLocal employeesFacade;

    @EJB
    private CustomersFacadeLocal customersFacade;

    @EJB
    private CustomCartLocal cartSessionBean;

    @EJB
    private ProductsFacadeLocal productsFacade;

    private static List<CartShopping> listShopingCart = new ArrayList<>();

    private String note;

    private int num;
    private List<Integer> numCart = new ArrayList<>();
    private double totalMoneyCart;
    private int totalProCart;
    private String message = "";
    private int quantity;

    /**
     * Creates a new instance of CartMB
     */
    public CartMB() {

    }

    public String addCartProduct(Long idPro) {
        Long a = idPro;
        cartSessionBean.addCart(idPro, 1);
        System.out.println("===" + a);
        message = "Product added to cart successfully!";
        return "cart";
    }

    public List<CartShopping> showCartMB() {
        List<CartShopping> listCart = new ArrayList<>();
        Set<Map.Entry<Long, Integer>> setCart = cartSessionBean.showCartMap().entrySet();
        totalMoneyCart = 0;
        totalProCart = 0;
        for (Map.Entry<Long, Integer> e : setCart) {
            Long id = e.getKey();
            Integer quality = e.getValue();
            CartShopping cShop;
            Products pro = productsFacade.find(id);
            double uprice = pro.getUnitPrice().doubleValue();
            //CartShopping cShop = new CartShopping(id, pro.getProductName(), quality, uprice, quality * uprice, pro.getImage());
            if (pro.getPromotionStatus() == 1) {
                List<Promotions> listPromotion = new ArrayList<>(pro.getPromotionsCollection());
                double priceAfterDiscount = pro.getUnitPrice() - (pro.getUnitPrice() * listPromotion.get(0).getDiscount() / 100);
                cShop = new CartShopping(id, pro.getProductName(), quality, uprice, quality * priceAfterDiscount, pro.getImage());
                cShop.setSale(true);
                cShop.setPriceAfterSale(priceAfterDiscount);
                totalMoneyCart += quality * priceAfterDiscount;
            } else {
                cShop = new CartShopping(id, pro.getProductName(), quality, uprice, quality * uprice, pro.getImage());
                cShop.setSale(false);
                cShop.setPriceAfterSale(pro.getUnitPrice());
                totalMoneyCart += quality * uprice;
            }
            listCart.add(cShop);
            numCart.add(quality);

            totalProCart += quality;
        }
        listShopingCart = listCart;
        return listCart;
    }

    public void updateCart(Long id) {
        cartSessionBean.updateCart(id, quantity);
    }

    public String tangSl(Long id) {
        cartSessionBean.plusCart(id);
        return "cart";
    }

    public String giamSl(Long id) {
        cartSessionBean.deCart(id);
        return "cart";
    }

    public void plusCart(Long id) {
        cartSessionBean.plusCart(id);
    }

    public String removeCart(Long id) {
        cartSessionBean.removeCart(id);
        message = "Removed a product from the cart!";
        return "cart";
    }

    public String checkOutCart(String username) {
        Customers cus = customersFacade.findByUsername(username);
        Employees emp = employeesFacade.findAll().get(0);
        List<CartShopping> cartList = listShopingCart;
        LocalDate date = LocalDate.now();
        Date today = Date.valueOf(date);
        Orders order = new Orders();
        order.setCustomerID(cus);
        order.setEmployeeID(emp);
        order.setTotalAmount(listShopingCart.size());
        order.setTotalPrice(BigDecimal.valueOf(totalMoneyCart));
        order.setNote(note);
        order.setPaymentMethod("Cash");
        order.setOrderDate(today);
        order.setStatus(0);
        ordersFacade.create(order);
        for (CartShopping cartShopping : listShopingCart) {
            OrderDetails orderDetail = new OrderDetails();
            OrderDetailsPK orderDetailsPK = new OrderDetailsPK();
            orderDetailsPK.setOrderID(order.getOrderID());
            Products products = productsFacade.find(cartShopping.getProID());
            if (products.getPromotionStatus() == 1) {
                List<Promotions> listPromotion = new ArrayList<>(products.getPromotionsCollection());
                double priceAfterDiscount = products.getUnitPrice() - (products.getUnitPrice() * listPromotion.get(0).getDiscount() / 100);
                orderDetail.setUnitPrice(BigDecimal.valueOf(priceAfterDiscount));
            } else {
                orderDetail.setUnitPrice(BigDecimal.valueOf(cartShopping.getUnitPrice()));
            }
            orderDetailsPK.setProductID(products.getProductID());
            orderDetail.setOrders(order);
            orderDetail.setQuantity(cartShopping.getQuantity());

            orderDetail.setProducts(products);
            orderDetail.setOrderDetailsPK(orderDetailsPK);
            orderDetailsFacade.create(orderDetail);
            products.setQuantity(products.getQuantity() - cartShopping.getQuantity());
            productsFacade.edit(products);
        }
        cartSessionBean.clearCart();
        return "confirmation";
    }

    public String emptyCart() {
        cartSessionBean.emptyCart();
        return "cart";
    }

    public int countCart() {
        return cartSessionBean.countCart();
    }

    public List<Integer> getNumCart() {
        return numCart;
    }

    public void setNumCart(List<Integer> numCart) {
        this.numCart = numCart;
    }

    public ProductsFacadeLocal getProductsFacade() {
        return productsFacade;
    }

    public void setProductsFacade(ProductsFacadeLocal productsFacade) {
        this.productsFacade = productsFacade;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public double getTotalMoneyCart() {
        return totalMoneyCart;
    }

    public void setTotalMoneyCart(double totalMoneyCart) {
        this.totalMoneyCart = totalMoneyCart;
    }

    public int getTotalProCart() {
        return totalProCart;
    }

    public void setTotalProCart(int totalProCart) {
        this.totalProCart = totalProCart;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

}
