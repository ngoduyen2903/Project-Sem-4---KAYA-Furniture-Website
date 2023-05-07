/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbeans;

import com.cusc.entities.Customers;
import com.cusc.entities.FeedbackDetails;
import com.cusc.entities.FeedbackDetailsPK;
import com.cusc.entities.Feedbacks;
import com.cusc.entities.Products;
import com.cusc.sessions.CustomersFacadeLocal;
import com.cusc.sessions.FeedbackDetailsFacadeLocal;
import com.cusc.sessions.FeedbacksFacadeLocal;
import com.cusc.sessions.ProductsFacadeLocal;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *
 * @author odieng
 */
@Named(value = "feedbackMB")
@RequestScoped
public class FeedbackMB {

    @EJB
    private CustomersFacadeLocal customersFacade;

    @EJB
    private FeedbackDetailsFacadeLocal feedbackDetailsFacade;

    @EJB
    private ProductsFacadeLocal productsFacade;

    @EJB
    private FeedbacksFacadeLocal feedbacksFacade;

    @Inject
    private LoginMB loginMB;

    private FeedbackDetails fdtt = new FeedbackDetails();

    private Long feedbackID;
    private String dateFeedback;
    private Long productID;
    private Feedbacks feedback;
    private Products product;
    private String content;
    private String star;
    private Products products;

    public FeedbackMB() {
        product = new Products();
        feedback = new Feedbacks();
    }

    public String viewRelated(long productid) {
        System.out.println("---10==" + productid);
        product = productsFacade.find(productid);
        return "viewFeedback";
    }

    public String addFeedback(long proid) throws IOException {
        if (loginMB.getUsername() == null) {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/KAYA-war/faces/client/login.xhtml");
        } else {

            Customers customer = customersFacade.findByUsername(loginMB.getUsername());
            Products products = productsFacade.find(proid);
            Feedbacks feedbacks = new Feedbacks();
            feedbacks.setCreationDate(Date.valueOf(LocalDate.now()));
            feedbacks.setCustomerID(customer);
            feedbacks.setStatus(0);
            feedbacksFacade.create(feedbacks);
            FeedbackDetailsPK fk = new FeedbackDetailsPK();
            fk.setFeedbackID(feedbacks.getFeedbackID());
            fk.setProductID(products.getProductID());
            FeedbackDetails feedbackDetails = new FeedbackDetails();
            feedbackDetails.setFeedbacks(feedbacks);
            feedbackDetails.setFeedbackContent(content);
            feedbackDetails.setProducts(products);
            feedbackDetails.setReviews("5");
            feedbackDetails.setFeedbackDetailsPK(fk);
            feedbackDetailsFacade.create(feedbackDetails);
        }

        return "product";
    }

    public List<FeedbackDetails> showListClient() {
        return feedbackDetailsFacade.findAllByDESC();
    }

    public List<FeedbackDetails> showAllFeedbacks() {
        return feedbackDetailsFacade.findAll2();
    }

    public String changeStatus(long feedbackID) {
        Feedbacks feedbacks = feedbacksFacade.find(feedbackID);
        if (feedbacks.getStatus() == 0) {
            feedbacks.setStatus(1);
        } else {
            feedbacks.setStatus(0);
        }
        feedbacksFacade.edit(feedbacks);
        return "feedbackList";
    }

    public String createFeedback() {
        product = productsFacade.find(productID);
        feedbacksFacade.create(feedback);
        return "productDetail";
    }

    public String loadFeedbacks() {

        return "productList";
    }

    public FeedbacksFacadeLocal getFeedbacksFacade() {
        return feedbacksFacade;
    }

    public void setFeedbacksFacade(FeedbacksFacadeLocal feedbacksFacade) {
        this.feedbacksFacade = feedbacksFacade;
    }

    public Long getFeedbackID() {
        return feedbackID;
    }

    public void setFeedbackID(Long feedbackID) {
        this.feedbackID = feedbackID;
    }

    public String getDateFeedback() {
        return dateFeedback;
    }

    public void setDateFeedback(String dateFeedback) {
        this.dateFeedback = dateFeedback;
    }

    public Long getProductID() {
        return productID;
    }

    public void setProductID(Long productID) {
        this.productID = productID;
    }

    public Feedbacks getFeedback() {
        return feedback;
    }

    public void setFeedback(Feedbacks feedback) {
        this.feedback = feedback;
    }

    public ProductsFacadeLocal getProductsFacade() {
        return productsFacade;
    }

    public void setProductsFacade(ProductsFacadeLocal productsFacade) {
        this.productsFacade = productsFacade;
    }

    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }

    public FeedbackDetailsFacadeLocal getFeedbackDetailsFacade() {
        return feedbackDetailsFacade;
    }

    public void setFeedbackDetailsFacade(FeedbackDetailsFacadeLocal feedbackDetailsFacade) {
        this.feedbackDetailsFacade = feedbackDetailsFacade;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star;
    }

    public LoginMB getLoginMB() {
        return loginMB;
    }

    public void setLoginMB(LoginMB loginMB) {
        this.loginMB = loginMB;
    }

    public FeedbackDetails getFdtt() {
        return fdtt;
    }

    public void setFdtt(FeedbackDetails fdtt) {
        this.fdtt = fdtt;
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;

    }

}
