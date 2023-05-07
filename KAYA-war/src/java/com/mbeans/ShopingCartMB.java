/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbeans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author odieng
 */
@Named(value = "shopingCartMB")
@SessionScoped
public class ShopingCartMB implements Serializable {


    
    
    public ShopingCartMB() {
    }
    
    
}
