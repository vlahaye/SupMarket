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
@Table(name = "sales")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sales.findAll", query = "SELECT s FROM Sales s"),
    @NamedQuery(name = "Sales.findByTimeId", query = "SELECT s FROM Sales s WHERE s.timeId = :timeId"),
    @NamedQuery(name = "Sales.findByQuantitySold", query = "SELECT s FROM Sales s WHERE s.quantitySold = :quantitySold"),
    @NamedQuery(name = "Sales.findByAmountSold", query = "SELECT s FROM Sales s WHERE s.amountSold = :amountSold"),
    @NamedQuery(name = "Sales.findBySaleId", query = "SELECT s FROM Sales s WHERE s.saleId = :saleId")})
public class Sales implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "TIME_ID")
    @Temporal(TemporalType.DATE)
    private Date timeId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "QUANTITY_SOLD")
    private BigDecimal quantitySold;
    @Column(name = "AMOUNT_SOLD")
    private BigDecimal amountSold;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SALE_ID")
    private Integer saleId;
    @JoinColumn(name = "PROD_ID", referencedColumnName = "PROD_ID")
    @ManyToOne
    private Products prodId;
    @JoinColumn(name = "CUST_ID", referencedColumnName = "CUST_ID")
    @ManyToOne
    private Customers custId;
    @JoinColumn(name = "CHANNEL_ID", referencedColumnName = "CHANNEL_ID")
    @ManyToOne
    private Channels channelId;
    @JoinColumn(name = "PROMO_ID", referencedColumnName = "PROMO_ID")
    @ManyToOne
    private Promotions promoId;

    public Sales() {
    }

    public Sales(Integer saleId) {
        this.saleId = saleId;
    }

    public Date getTimeId() {
        return timeId;
    }

    public void setTimeId(Date timeId) {
        this.timeId = timeId;
    }

    public BigDecimal getQuantitySold() {
        return quantitySold;
    }

    public void setQuantitySold(BigDecimal quantitySold) {
        this.quantitySold = quantitySold;
    }

    public BigDecimal getAmountSold() {
        return amountSold;
    }

    public void setAmountSold(BigDecimal amountSold) {
        this.amountSold = amountSold;
    }

    public Integer getSaleId() {
        return saleId;
    }

    public void setSaleId(Integer saleId) {
        this.saleId = saleId;
    }

    public Products getProdId() {
        return prodId;
    }

    public void setProdId(Products prodId) {
        this.prodId = prodId;
    }

    public Customers getCustId() {
        return custId;
    }

    public void setCustId(Customers custId) {
        this.custId = custId;
    }

    public Channels getChannelId() {
        return channelId;
    }

    public void setChannelId(Channels channelId) {
        this.channelId = channelId;
    }

    public Promotions getPromoId() {
        return promoId;
    }

    public void setPromoId(Promotions promoId) {
        this.promoId = promoId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (saleId != null ? saleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sales)) {
            return false;
        }
        Sales other = (Sales) object;
        if ((this.saleId == null && other.saleId != null) || (this.saleId != null && !this.saleId.equals(other.saleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.supinfo.supmarket.entity.Sales[ saleId=" + saleId + " ]";
    }
    
}
