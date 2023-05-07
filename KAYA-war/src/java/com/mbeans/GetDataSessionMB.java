/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbeans;

import com.cusc.entities.FeedbackDetails;
import com.cusc.sessions.FeedbackDetailsFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author odieng
 */
@Named(value = "getDataSessionMB")
@SessionScoped
public class GetDataSessionMB implements Serializable {

    @EJB
    private FeedbackDetailsFacadeLocal feedbackDetailsFacade;

    public GetDataSessionMB() {
    }

    public List<FeedbackDetails> showFeedBackForCustomer() {
        return feedbackDetailsFacade.findAll();
    }

}
