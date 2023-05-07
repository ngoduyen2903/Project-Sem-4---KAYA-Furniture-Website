/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbeans;

import com.cusc.sessions.CategoriesFacadeLocal;
import com.cusc.entities.Categories;
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
 * @author hung PC
 */
@Named(value = "categoryMB")
@RequestScoped
public class CategoryMB {

    @EJB
    private CategoriesFacadeLocal categoriesFacade;
    private Long cateID;
    private String categoryName;
    private String description;
    private Categories categories;

    /**
     * Creates a new instance of CategoryMB
     */
    public CategoryMB() {
        categories = new Categories();
    }

    public String showUpdate(Long id) {
        categories = categoriesFacade.find(id);
        return "editCategory";
    }

    public void saveUpdateCategory() {
        categoriesFacade.edit(categories);
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("categoriesList.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(CategoryMB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String saveUpdateCategoryy() {
        categories = new Categories();
        return "addCategory";
    }

    public List<Categories> showAllCategory() {
        return categoriesFacade.findAll();
    }

    public String deleteCategory(Long id) {
        categoriesFacade.remove(categoriesFacade.find(id));
        return "categoriesList";
    }

    public void createCategory() {
        categoriesFacade.create(categories);
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("categoriesList.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(CategoryMB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Categories getCategory() {
        return categories;
    }

    public void setCategory(Categories category) {
        this.categories = category;
    }

    public CategoriesFacadeLocal getCategoriesFacade() {
        return categoriesFacade;
    }

    public void setCategoriesFacade(CategoriesFacadeLocal categoriesFacade) {
        this.categoriesFacade = categoriesFacade;
    }

    public Long getCateID() {
        return cateID;
    }

    public void setCateID(Long cateID) {
        this.cateID = cateID;
    }

    public Categories getCategories() {
        return categories;
    }

    public void setCategories(Categories categories) {
        this.categories = categories;
    }

}
