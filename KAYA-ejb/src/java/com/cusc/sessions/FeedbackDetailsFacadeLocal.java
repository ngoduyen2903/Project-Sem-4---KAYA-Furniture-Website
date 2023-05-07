/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cusc.sessions;

import com.cusc.entities.FeedbackDetails;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author huynh
 */
@Local
public interface FeedbackDetailsFacadeLocal {

    void create(FeedbackDetails feedbackDetails);

    void edit(FeedbackDetails feedbackDetails);

    void remove(FeedbackDetails feedbackDetails);

    FeedbackDetails find(Object id);

    List<FeedbackDetails> findAll();

    List<FeedbackDetails> findRange(int[] range);

    int count();
    
    List<FeedbackDetails> findAllByDESC();
    
    List<FeedbackDetails> findAll2();
    
}
