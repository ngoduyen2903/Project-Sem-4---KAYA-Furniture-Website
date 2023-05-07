/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cusc.sessions;

import com.cusc.entities.Customers;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
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
public class CustomersFacade extends AbstractFacade<Customers> implements CustomersFacadeLocal {

    @PersistenceContext(unitName = "KAYA-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CustomersFacade() {
        super(Customers.class);
    }

    @Override
    public Customers loadByUsername(String username, String password) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root root = cq.from(Customers.class);
        cq.select(root);
        cq.where(cb.and(cb.equal(root.get("username"), username), cb.equal(root.get("password"), password)));
        Query query = em.createQuery(cq);
        return (Customers) query.getSingleResult();
    }

    @Override
    public long getCountByUsernamePassword(String username, String password) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root root = cq.from(Customers.class);
        cq.select(cb.count(root.get("username")));
        cq.where(cb.and(cb.equal(root.get("username"), username), cb.equal(root.get("password"), password)));
        Query query = em.createQuery(cq);
        return (long) query.getSingleResult();
    }

    @Override
    public Customers findByUsername(String username) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root root = cq.from(Customers.class);
        cq.select(root);
        cq.where(cb.equal(root.get("username"), username));
        Query query = em.createQuery(cq);
        return (Customers) query.getSingleResult();
    }

    @Override
    public Customers login(String username) {
        Query query = em.createQuery("SELECT c FROM Customers c WHERE c.username = :username");
        query.setParameter("username", username);
        try {
            return (Customers) query.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
    }

}
