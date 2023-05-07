/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbeans;

import com.cloudinary.Cloudinary;
import com.cusc.entities.Customers;
import com.cusc.sessions.CustomersFacadeLocal;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.ejb.EJB;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

/**
 *
 * @author This PC
 */
@Named(value = "customerMB")
@SessionScoped
public class CustomerMB implements Serializable {

    @EJB
    private CustomersFacadeLocal customersFacade;

    private Customers customers;

    private Long customersID;

    private String fullname;

    private String username;

    private String password;

    private String address;

    private String phoneNumber;

    private String email;

    private String confirmPassword;

    private String nameMessage;

    private String usernameMessage;

    private String phoneMessage;

    private String addressMessage;

    private String emailMessage;

    private String passwordMessage;

    private String cfPasswordMessage;

    private boolean showAlert = false;

    private Part file;

    private String imgurl;

    public CustomerMB() {
        customers = new Customers();
    }

    public String showProfileCustomer(String username) {
        customers = customersFacade.findByUsername(username);
        Long id = customers.getCustomerID();
        customers = customersFacade.find(id);
        customersID = customers.getCustomerID();
        return "checkout";
    }

    public void showCustomerProfile(Long id) {
        customers = customersFacade.find(id);
        System.out.println(id);
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("myprofile.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(CustomerMB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void showCustome(Long id) {
        customers = customersFacade.find(id);
        System.out.println(id);
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

    public String upProfileCustomer() {
        uploadFile();
        customers.setAvatar(imgurl);
        customersFacade.edit(customers);
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("myprofile.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(CustomerMB.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public List<Customers> showAllCustomers() {
        return customersFacade.findAll();
    }

    public void confirmCustomer(Long id) {
        Customers c = customersFacade.find(id);
        if (c.getStatus() == 1) {
            c.setStatus(0);
        } else {
            c.setStatus(1);
        }

        customersFacade.edit(c);
    }

    public String showCustomerDetails(Long id) {
        customers = customersFacade.find(id);
        return "customerDetail";
    }

    public String showCustomerList() {
        return "customerList";
    }

    public String registerCustomer() {
        customers.setStatus(1);
        resetMessage();

        if (!checkSignUpForm()) {
            return "register";
        }
        customers.setFullname(fullname);
        customers.setUsername(username);
        customers.setAddress(address);
        customers.setEmail(email);
        customers.setPassword(password);
        customers.setPhoneNumber(phoneNumber);

        customersFacade.create(customers);
        showAlert = true;
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(CustomerMB.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public boolean checkSignUpForm() {
        boolean valid = true;
        if (fullname.equals("")) {
            nameMessage = "This field is required";
            valid = false;
        } else if (!Pattern.matches("^\\s*([A-Za-z]{1,}([\\.,] |[-']| ))+[A-Za-z]+\\.?\\s*$", fullname)) {
            nameMessage = "Must contain only letters, whitespace and must be fullname";
            valid = false;
        } else {
            nameMessage = "";
        }

        if (username.equals("")) {
            usernameMessage = "This field is required";
            valid = false;
        } else if (!Pattern.matches("^[A-Za-z]{1,9}\\d{1,9}", username)) {
            usernameMessage = "UserName is incorrect. Ex: information123";
            valid = false;
        } else {
            Customers c = customersFacade.login(username);
            if (c != null) {
                usernameMessage = "This username is connected to another account";
                valid = false;
            } else {
                usernameMessage = "";
            }
        }

        if (phoneNumber.equals("")) {
            phoneMessage = "This field is required";
            valid = false;
        } else if (!Pattern.matches("^(\\(0\\d{1,3}\\)\\d{7})|(0\\d{9,10})$", phoneNumber)) {
            phoneMessage = "Must be a 10 to 11 digit number. Ex: 0358283336";
            valid = false;
        } else {
            phoneMessage = "";
        }

        if (address.equals("")) {
            addressMessage = "This field is required";
            valid = false;
        } else {
            addressMessage = "";
        }
        if (email.equals("")) {
            emailMessage = "This field is required";
            valid = false;
        } else if (!Pattern.matches("^[a-zA-Z]\\w*(\\.\\w+)*\\@\\w+(\\.\\w{2,3})+$", email)) {
            emailMessage = "Email is incorrect. Ex: info1234@gmail.com";
            valid = false;
        } else {
            emailMessage = "";
        }

        if (password.equals("")) {
            passwordMessage = "This field is required";
            valid = false;
        } else if (!Pattern.matches("(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,}", password)) {
            passwordMessage = "Password must contain at least 1 number, 1 uppercase letter, 1 lowercase letter, and at least 8 characters";
            valid = false;
        } else {
            passwordMessage = "";
        }

        if (confirmPassword.equals("")) {
            cfPasswordMessage = "This field is required";
            valid = false;
        } else if (!confirmPassword.equals(password)) {
            cfPasswordMessage = "Passwords don't match";
            valid = false;
        } else {
            cfPasswordMessage = "";
        }

        return valid;
    }

    public void resetMessage() {
        nameMessage = "";
        usernameMessage = "";
        phoneMessage = "";
        addressMessage = "";
        emailMessage = "";
        passwordMessage = "";
        cfPasswordMessage = "";
    }

    public String loadSignUpForm() {
        showAlert = false;
        resetMessage();
        customers = new Customers();
        fullname = "";
        address = "";
        email = "";
        username = "";
        password = "";
        confirmPassword = "";
        phoneNumber = "";
        customers.setAvatar("https://res.cloudinary.com/dh5kp6ex1/image/upload/v1681924035/shat6jnocnlulfh5snvy.jpg");
        return "register";
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public CustomersFacadeLocal getCustomersFacade() {
        return customersFacade;
    }

    public void setCustomersFacade(CustomersFacadeLocal customersFacade) {
        this.customersFacade = customersFacade;
    }

    public Customers getCustomers() {
        return customers;
    }

    public void setCustomers(Customers customers) {
        this.customers = customers;
    }

    public Long getCustomersID() {
        return customersID;
    }

    public void setCustomersID(Long customersID) {
        this.customersID = customersID;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getNameMessage() {
        return nameMessage;
    }

    public void setNameMessage(String nameMessage) {
        this.nameMessage = nameMessage;
    }

    public String getUsernameMessage() {
        return usernameMessage;
    }

    public void setUsernameMessage(String usernameMessage) {
        this.usernameMessage = usernameMessage;
    }

    public String getPhoneMessage() {
        return phoneMessage;
    }

    public void setPhoneMessage(String phoneMessage) {
        this.phoneMessage = phoneMessage;
    }

    public String getAddressMessage() {
        return addressMessage;
    }

    public void setAddressMessage(String addressMessage) {
        this.addressMessage = addressMessage;
    }

    public String getEmailMessage() {
        return emailMessage;
    }

    public void setEmailMessage(String emailMessage) {
        this.emailMessage = emailMessage;
    }

    public String getPasswordMessage() {
        return passwordMessage;
    }

    public void setPasswordMessage(String passwordMessage) {
        this.passwordMessage = passwordMessage;
    }

    public String getCfPasswordMessage() {
        return cfPasswordMessage;
    }

    public void setCfPasswordMessage(String cfPasswordMessage) {
        this.cfPasswordMessage = cfPasswordMessage;
    }

    public boolean isShowAlert() {
        return showAlert;
    }

    public void setShowAlert(boolean showAlert) {
        this.showAlert = showAlert;
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

}
