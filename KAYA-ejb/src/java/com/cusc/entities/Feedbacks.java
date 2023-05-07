/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cusc.entities;

import java.io.Serializable;
import java.util.Collection;
import java.sql.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author huynh
 */
@Entity
@Table(name = "Feedbacks")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Feedbacks.findAll", query = "SELECT f FROM Feedbacks f")
    , @NamedQuery(name = "Feedbacks.findByFeedbackID", query = "SELECT f FROM Feedbacks f WHERE f.feedbackID = :feedbackID")
    , @NamedQuery(name = "Feedbacks.findByCreationDate", query = "SELECT f FROM Feedbacks f WHERE f.creationDate = :creationDate")})
public class Feedbacks implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "FeedbackID")
    private Long feedbackID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CreationDate")
    private Date creationDate;
    @Column(name = "Status")
    private int status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "feedbacks",fetch = FetchType.EAGER)
    private Collection<FeedbackDetails> feedbackDetailsCollection;
    @JoinColumn(name = "CustomerID", referencedColumnName = "CustomerID")
    @ManyToOne(optional = false)
    private Customers customerID;

    public Feedbacks() {
    }

    public Feedbacks(Long feedbackID) {
        this.feedbackID = feedbackID;
    }

    public Feedbacks(Long feedbackID, Date creationDate) {
        this.feedbackID = feedbackID;
        this.creationDate = creationDate;
    }

    public Long getFeedbackID() {
        return feedbackID;
    }

    public void setFeedbackID(Long feedbackID) {
        this.feedbackID = feedbackID;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @XmlTransient
    public Collection<FeedbackDetails> getFeedbackDetailsCollection() {
        return feedbackDetailsCollection;
    }

    public void setFeedbackDetailsCollection(Collection<FeedbackDetails> feedbackDetailsCollection) {
        this.feedbackDetailsCollection = feedbackDetailsCollection;
    }

    public Customers getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Customers customerID) {
        this.customerID = customerID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (feedbackID != null ? feedbackID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Feedbacks)) {
            return false;
        }
        Feedbacks other = (Feedbacks) object;
        if ((this.feedbackID == null && other.feedbackID != null) || (this.feedbackID != null && !this.feedbackID.equals(other.feedbackID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cusc.entities.Feedbacks[ feedbackID=" + feedbackID + " ]";
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

}
