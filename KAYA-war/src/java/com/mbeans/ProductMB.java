/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbeans;

import com.cusc.entities.Brands;
import com.cusc.entities.Categories;
import com.cusc.entities.Products;
import com.cusc.entities.Suppliers;
import com.cusc.sessions.BrandsFacadeLocal;
import com.cusc.sessions.CategoriesFacadeLocal;
import com.cusc.sessions.CustomersFacadeLocal;
import com.cusc.sessions.EmployeesFacadeLocal;
import com.cusc.sessions.ProductsFacadeLocal;
import com.cusc.sessions.SuppliersFacadeLocal;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import com.cloudinary.Cloudinary;
import com.cusc.entities.Employees;
import com.cusc.sessions.PromotionsFacadeLocal;
import java.util.ArrayList;
import javax.annotation.PostConstruct;

/**
 *
 * @author odieng
 */
@Named(value = "productMB")
@RequestScoped
public class ProductMB {
    
    @EJB
    private SuppliersFacadeLocal suppliersFacade;
    
    @EJB
    private CategoriesFacadeLocal categoriesFacade;
    
    @EJB
    private BrandsFacadeLocal brandsFacade;
    
    @EJB
    private EmployeesFacadeLocal employeesFacade;
    
    @EJB
    private CustomersFacadeLocal customersFacade;
    
    @EJB
    private ProductsFacadeLocal productsFacade;
    private Long proID;
    private String productName;
    private String description;
    private Long categoryID;
    private Long supplierID;
    private Long brandsID;
    private String unitPrice;
    private String image;
    private String quantity;
    private String promotionStatus;
    private String status;
    private Products products;
    private long selectedCategory;
    private long selecteSupplier;
    private long selectBrands;
    private Part file;
    private String imgurl;
    private List<Products> listProducts = new ArrayList<>();
    private boolean enablePromotion = true;
    private long totalProduct;
    
    @PostConstruct
    public void init() {
        totalProduct = productsFacade.findAll().size();
    }
    
    public ProductMB() {
        products = new Products();
    }
    
    public String toggleEnabledPromotion(long id) {
        Products pro = productsFacade.find(id);
        if (pro.getPromotionStatus() == 0) {
            pro.setPromotionStatus(1);
        } else { 
            pro.setPromotionStatus(0);
        }
        productsFacade.edit(pro);
        return "promotionList";
    }
    
    public String showProductDetails(Long id) {
        products = productsFacade.find(id);
        return "productDetail";
    }
    
    public void uploadFile() {
        if (file != null) {
            Map config = new HashMap<>();
            config.put("cloud_name", "dh5kp6ex1");
            config.put("api_key", "556764214986387");
            config.put("api_secret", "DHvHY8VZRYtavp2th1-BpFlhKs8");
            Cloudinary cloudinary = new Cloudinary(config);
            Map url = new HashMap();
            url.put("public_id", "");
            url.put("overwrite", true);
            url.put("resource_type", "image");
            try {
                Map r = cloudinary.uploader().upload(changeFile(file), url);
                imgurl = (String) r.get("secure_url");
                System.out.println(imgurl);
            } catch (IOException ex) {
                ex.getMessage();
            }
        }
    }
    
    private String changeFile(Part f) {
        String imagePath = null;
        if (f != null) {
            InputStream content = null;
            try {
                content = f.getInputStream();
                FacesContext context = FacesContext.getCurrentInstance();
                ExternalContext ec = context.getExternalContext();
                HttpServletRequest request = (HttpServletRequest) ec.getRequest();
                String applicationPath = request.getServletContext().getRealPath("");
                String uploadFilePath = applicationPath + File.separator + "resources";
                File fileSaveDir = new File(uploadFilePath);
                if (!fileSaveDir.exists()) {
                    fileSaveDir.mkdirs();
                }
                OutputStream outputStream = null;
                try {
                    File outputFilePath = new File(uploadFilePath + File.separator + f.getSubmittedFileName());
                    imagePath = uploadFilePath + File.separator + f.getSubmittedFileName();
                    content = f.getInputStream();
                    outputStream = new FileOutputStream(outputFilePath);
                    int read = 0;
                    final byte[] bytes = new byte[1024];
                    while ((read = content.read(bytes)) != -1) {
                        outputStream.write(bytes, 0, read);
                    }
                    System.out.println("File uploaded successfully!");
                } catch (Exception ex) {
                    ex.toString();
                } finally {
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    if (content != null) {
                        content.close();
                    }
                }
            } catch (IOException ex) {
                Logger.getLogger(imagePath).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    content.close();
                } catch (IOException ex) {
                    Logger.getLogger(imagePath).log(Level.SEVERE, null, ex);
                }
            }
        }
        System.out.println(imagePath);
        return imagePath;
    }
    
    public List<Categories> showAllCategories() {
        return categoriesFacade.findAll();
    }
    
    public List<Brands> showAllBrands() {
        return brandsFacade.findAll();
    }
    
    public List<Suppliers> showAllSuppliers() {
        return suppliersFacade.findAll();
    }
    
    public String showUpdate(Long id) {
        products = productsFacade.find(id);
        return "editProduct";
    }
    
    public String showAddForm() {
        products = new Products();
        return "addProduct";
    }
    
    public String saveUpdateProducts() {
        uploadFile();
        products.setBrandID(brandsFacade.find(selectBrands));
        products.setCategoryID(categoriesFacade.find(selectedCategory));
        products.setSupplierID(suppliersFacade.find(selecteSupplier));
        products.setImage(imgurl);
        productsFacade.edit(products);
        return "productList";
    }
    
    public List<Products> showFindProduct() {
        return listProducts;
    }
    
    public String deleteProducts(Long id) {
        productsFacade.remove(productsFacade.find(id));
        return "productList";
    }
    
    public String createProduct() {
        uploadFile();
        products.setBrandID(brandsFacade.find(selectBrands));
        products.setCategoryID(categoriesFacade.find(selectedCategory));
        products.setSupplierID(suppliersFacade.find(selecteSupplier));
        products.setImage(imgurl);
        productsFacade.create(products);
        return "productList";
    }
    
    public List<Products> showAllProduct() {
        return productsFacade.findAll();
    }
    
    public Long getProID() {
        return proID;
    }
    
    public void setProID(Long proID) {
        this.proID = proID;
    }
    
    public String getProductName() {
        return productName;
    }
    
    public void setProductName(String productName) {
        this.productName = productName;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public Long getCategoryID() {
        return categoryID;
    }
    
    public void setCategoryID(Long categoryID) {
        this.categoryID = categoryID;
    }
    
    public Long getsupplierID() {
        return supplierID;
    }
    
    public void setsupplierID(Long supplierID) {
        this.supplierID = supplierID;
    }
    
    public Long getbrandsID() {
        return brandsID;
    }
    
    public void setbrandsID(Long brandsID) {
        this.brandsID = brandsID;
    }
    
    public String getUnitPrice() {
        return unitPrice;
    }
    
    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }
    
    public String getImage() {
        return image;
    }
    
    public void setImage(String image) {
        this.image = image;
    }
    
    public String getQuantity() {
        return quantity;
    }
    
    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
    
    public String getPromotionStatus() {
        return promotionStatus;
    }
    
    public void setPromotionStatus(String promotionStatus) {
        this.promotionStatus = promotionStatus;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public Products getProducts() {
        return products;
    }
    
    public void setProducts(Products products) {
        this.products = products;
    }
    
    public ProductsFacadeLocal getProductsFacade() {
        return productsFacade;
    }
    
    public void setProductsFacade(ProductsFacadeLocal productsFacade) {
        this.productsFacade = productsFacade;
    }
    
    public long getSelectedCategory() {
        return selectedCategory;
    }
    
    public void setSelectedCategory(long selectedCategory) {
        this.selectedCategory = selectedCategory;
    }
    
    public SuppliersFacadeLocal getSuppliersFacade() {
        return suppliersFacade;
    }
    
    public void setSuppliersFacade(SuppliersFacadeLocal suppliersFacade) {
        this.suppliersFacade = suppliersFacade;
    }
    
    public CategoriesFacadeLocal getCategoriesFacade() {
        return categoriesFacade;
    }
    
    public void setCategoriesFacade(CategoriesFacadeLocal categoriesFacade) {
        this.categoriesFacade = categoriesFacade;
    }
    
    public BrandsFacadeLocal getBrandsFacade() {
        return brandsFacade;
    }
    
    public void setBrandsFacade(BrandsFacadeLocal brandsFacade) {
        this.brandsFacade = brandsFacade;
    }
    
    public EmployeesFacadeLocal getEmployeesFacade() {
        return employeesFacade;
    }
    
    public void setEmployeesFacade(EmployeesFacadeLocal employeesFacade) {
        this.employeesFacade = employeesFacade;
    }
    
    public CustomersFacadeLocal getCustomersFacade() {
        return customersFacade;
    }
    
    public void setCustomersFacade(CustomersFacadeLocal customersFacade) {
        this.customersFacade = customersFacade;
    }
    
    public Long getSupplierID() {
        return supplierID;
    }
    
    public void setSupplierID(Long supplierID) {
        this.supplierID = supplierID;
    }
    
    public Long getBrandsID() {
        return brandsID;
    }
    
    public void setBrandsID(Long brandsID) {
        this.brandsID = brandsID;
    }
    
    public long getSelecteSupplier() {
        return selecteSupplier;
    }
    
    public void setSelecteSupplier(long selecteSupplier) {
        this.selecteSupplier = selecteSupplier;
    }
    
    public long getSelectBrands() {
        return selectBrands;
    }
    
    public void setSelectBrands(long selectBrands) {
        this.selectBrands = selectBrands;
    }
    
    public Part getFile() {
        return file;
    }
    
    public void setFile(Part file) {
        this.file = file;
    }
    
    public String getImgurl() {
        return imgurl;
    }
    
    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }
    
    public List<Products> getListProducts() {
        return listProducts;
    }
    
    public void setListProducts(List<Products> listProducts) {
        this.listProducts = listProducts;
    }
    
    public boolean isEnablePromotion() {
        return enablePromotion;
    }
    
    public void setEnablePromotion(boolean enablePromotion) {
        this.enablePromotion = enablePromotion;
    }
    
    public long getTotalProduct() {
        return totalProduct;
    }
    
    public void setTotalProduct(long totalProduct) {
        this.totalProduct = totalProduct;
    }
}
