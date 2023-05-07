/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cusc.sessions;

import com.cusc.entities.Owner;
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
public class OwnerFacade extends AbstractFacade<Owner> implements OwnerFacadeLocal {

    @PersistenceContext(unitName = "KAYA-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OwnerFacade() {
        super(Owner.class);
    }

    @Override
    public Owner loadByUsername(String username, String password) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root root = cq.from(Owner.class);
        cq.select(root);
        cq.where(cb.and(cb.equal(root.get("username"), username), cb.equal(root.get("password"), password)));
        Query query = em.createQuery(cq);
        return (Owner) query.getSingleResult();
    }

    @Override
    public long getCountByUsernamePassword(String username, String password) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root root = cq.from(Owner.class);
        cq.select(cb.count(root.get("username")));
        cq.where(cb.and(cb.equal(root.get("username"), username), cb.equal(root.get("password"), password)));
        Query query = em.createQuery(cq);
        return (long) query.getSingleResult();
    }

    @Override
    public Owner findByUsername(String username) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root root = cq.from(Owner.class);
        cq.select(root);
        cq.where(cb.equal(root.get("username"), username));
        Query query = em.createQuery(cq);
        return (Owner) query.getSingleResult();
    }

}
