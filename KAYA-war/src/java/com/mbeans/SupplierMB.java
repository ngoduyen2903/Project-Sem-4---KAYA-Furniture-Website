/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbeans;

import com.cusc.entities.Suppliers;
import com.cusc.sessions.SuppliersFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author hung
 */
@Named(value = "supplierMB")
@RequestScoped
public class SupplierMB {

    @EJB
    private SuppliersFacadeLocal suppliersFacade;
    private Long supID;
    private String companyName;
    private String phone;
    private String address;
    private String email;
    private String webpage;
    private int status;
    private Suppliers supplier;

    /**
     * Creates a new instance of supplierMB
     */
    public SupplierMB() {
        supplier = new Suppliers();
    }

    public List<Suppliers> showAllSupplier() {
        return suppliersFacade.findAll();
    }

    public String showAddForm() {
        supplier = new Suppliers();
        return "addSupplier";
    }

    public String createSupplier() {
        suppliersFacade.create(supplier);
        return "supplierList";
    }

    public String showUpdate(Long id) {
        supplier = suppliersFacade.find(id);
        return "editSupplier";
    }

    public String saveUpdate() {
        suppliersFacade.edit(supplier);
        return "supplierList";
    }

    public String deleteSupplier(Long id) {
        suppliersFacade.remove(suppliersFacade.find(id));
//        supplier = suppliersFacade.find(id);
//        suppliersFacade.remove(supplier);
        return "supplierList";
    }

    public SuppliersFacadeLocal getSuppliersFacade() {
        return suppliersFacade;
    }

    public void setSuppliersFacade(SuppliersFacadeLocal suppliersFacade) {
        this.suppliersFacade = suppliersFacade;
    }

    public Long getSupID() {
        return supID;
    }

    public void setSupID(Long supID) {
        this.supID = supID;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebpage() {
        return webpage;
    }

    public void setWebpage(String webpage) {
        this.webpage = webpage;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Suppliers getSupplier() {
        return supplier;
    }

    public void setSupplier(Suppliers supplier) {
        this.supplier = supplier;
    }

}
