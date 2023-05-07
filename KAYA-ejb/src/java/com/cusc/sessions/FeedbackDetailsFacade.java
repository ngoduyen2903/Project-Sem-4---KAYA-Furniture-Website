/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cusc.sessions;

import com.cusc.entities.Customers;
import com.cusc.entities.FeedbackDetails;
import com.cusc.entities.OrderDetails;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author huynh
 */
@Stateless
public class FeedbackDetailsFacade extends AbstractFacade<FeedbackDetails> implements FeedbackDetailsFacadeLocal {

    @PersistenceContext(unitName = "KAYA-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FeedbackDetailsFacade() {
        super(FeedbackDetails.class);
    }

    @Override
    public List<FeedbackDetails> findAllByDESC() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root root = cq.from(FeedbackDetails.class);
        cq.select(root);
        cq.where(cb.equal(root.get("feedbacks").get("status"), 1));
        cq.orderBy(cb.desc(root.get("feedbacks").get("feedbackID")));
        Query query = em.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public List<FeedbackDetails> findAll2() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root root = cq.from(FeedbackDetails.class);
        cq.select(root);
        Query query = em.createQuery(cq);
        return query.getResultList();
    }

}
