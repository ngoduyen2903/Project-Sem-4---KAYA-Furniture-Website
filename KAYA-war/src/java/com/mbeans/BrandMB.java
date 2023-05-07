/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbeans;

import com.cusc.entities.Brands;
import com.cusc.sessions.BrandsFacadeLocal;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author huynh
 */
@Named(value = "brandMB")
@RequestScoped
public class BrandMB {
    
    @EJB
    private BrandsFacadeLocal brandsFacade;
    private Long brandID;
    private String brandName;
    private String description;
    private String website;
    private Brands brands;
    
    public BrandMB() {
        brands = new Brands();
    }
    
    public List<Brands> showAllBrands() {
        return brandsFacade.findAll();
    }
    
    public void createBrands() {
        brandsFacade.create(brands);
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("brandList.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(BrandMB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String deleteBrands(Long id) {
        brands = brandsFacade.find(id);
        brandsFacade.remove(brands);
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("brandList.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(BrandMB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public String editBrands(Long id) {
        brands = brandsFacade.find(id);
        brandsFacade.edit(brands);
        return "editBrand";
    }
    
    public void saveBrands() {
        brandsFacade.edit(brands);
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("brandList.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(BrandMB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String showAddForm() {
        brands = new Brands();
        return "addBrand";
    }
    
    public Long getBrandID() {
        return brandID;
    }
    
    public void setBrandID(Long brandID) {
        this.brandID = brandID;
    }
    
    public String getBrandName() {
        return brandName;
    }
    
    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getWebsite() {
        return website;
    }
    
    public void setWebsite(String website) {
        this.website = website;
    }
    
    public Brands getBrands() {
        return brands;
    }
    
    public void setBrands(Brands brands) {
        this.brands = brands;
    }
    
    public BrandsFacadeLocal getBrandsFacade() {
        return brandsFacade;
    }
    
    public void setBrandsFacade(BrandsFacadeLocal brandsFacade) {
        this.brandsFacade = brandsFacade;
    }
        
}
