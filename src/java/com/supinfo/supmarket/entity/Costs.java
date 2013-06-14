/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supmarket.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Vincent
 */
@Entity
@Table(name = "costs")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Costs.findAll", query = "SELECT c FROM Costs c"),
    @NamedQuery(name = "Costs.findByTimeId", query = "SELECT c FROM Costs c WHERE c.timeId = :timeId"),
    @NamedQuery(name = "Costs.findByUnitCost", query = "SELECT c FROM Costs c WHERE c.unitCost = :unitCost"),
    @NamedQuery(name = "Costs.findByUnitPrice", query = "SELECT c FROM Costs c WHERE c.unitPrice = :unitPrice"),
    @NamedQuery(name = "Costs.findByCostId", query = "SELECT c FROM Costs c WHERE c.costId = :costId")})
public class Costs implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "TIME_ID")
    @Temporal(TemporalType.DATE)
    private Date timeId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "UNIT_COST")
    private BigDecimal unitCost;
    @Column(name = "UNIT_PRICE")
    private BigDecimal unitPrice;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "COST_ID")
    private Integer costId;
    @JoinColumn(name = "PROMO_ID", referencedColumnName = "PROMO_ID")
    @ManyToOne
    private Promotions promoId;
    @JoinColumn(name = "PROD_ID", referencedColumnName = "PROD_ID")
    @ManyToOne
    private Products prodId;
    @JoinColumn(name = "CHANNEL_ID", referencedColumnName = "CHANNEL_ID")
    @ManyToOne
    private Channels channelId;

    public Costs() {
    }

    public Costs(Integer costId) {
        this.costId = costId;
    }

    public Date getTimeId() {
        return timeId;
    }

    public void setTimeId(Date timeId) {
        this.timeId = timeId;
    }

    public BigDecimal getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(BigDecimal unitCost) {
        this.unitCost = unitCost;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getCostId() {
        return costId;
    }

    public void setCostId(Integer costId) {
        this.costId = costId;
    }

    public Promotions getPromoId() {
        return promoId;
    }

    public void setPromoId(Promotions promoId) {
        this.promoId = promoId;
    }

    public Products getProdId() {
        return prodId;
    }

    public void setProdId(Products prodId) {
        this.prodId = prodId;
    }

    public Channels getChannelId() {
        return channelId;
    }

    public void setChannelId(Channels channelId) {
        this.channelId = channelId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (costId != null ? costId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Costs)) {
            return false;
        }
        Costs other = (Costs) object;
        if ((this.costId == null && other.costId != null) || (this.costId != null && !this.costId.equals(other.costId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.supinfo.supmarket.entity.Costs[ costId=" + costId + " ]";
    }
    
}
