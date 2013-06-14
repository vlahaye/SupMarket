/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supmarket.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Vincent
 */
@Entity
@Table(name = "promotions")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Promotions.findAll", query = "SELECT p FROM Promotions p"),
    @NamedQuery(name = "Promotions.findByPromoId", query = "SELECT p FROM Promotions p WHERE p.promoId = :promoId"),
    @NamedQuery(name = "Promotions.findByPromoName", query = "SELECT p FROM Promotions p WHERE p.promoName = :promoName"),
    @NamedQuery(name = "Promotions.findByPromoSubcategory", query = "SELECT p FROM Promotions p WHERE p.promoSubcategory = :promoSubcategory"),
    @NamedQuery(name = "Promotions.findByPromoSubcategoryId", query = "SELECT p FROM Promotions p WHERE p.promoSubcategoryId = :promoSubcategoryId"),
    @NamedQuery(name = "Promotions.findByPromoCategory", query = "SELECT p FROM Promotions p WHERE p.promoCategory = :promoCategory"),
    @NamedQuery(name = "Promotions.findByPromoCategoryId", query = "SELECT p FROM Promotions p WHERE p.promoCategoryId = :promoCategoryId"),
    @NamedQuery(name = "Promotions.findByPromoCost", query = "SELECT p FROM Promotions p WHERE p.promoCost = :promoCost"),
    @NamedQuery(name = "Promotions.findByPromoBeginDate", query = "SELECT p FROM Promotions p WHERE p.promoBeginDate = :promoBeginDate"),
    @NamedQuery(name = "Promotions.findByPromoEndDate", query = "SELECT p FROM Promotions p WHERE p.promoEndDate = :promoEndDate"),
    @NamedQuery(name = "Promotions.findByPromoTotal", query = "SELECT p FROM Promotions p WHERE p.promoTotal = :promoTotal"),
    @NamedQuery(name = "Promotions.findByPromoTotalId", query = "SELECT p FROM Promotions p WHERE p.promoTotalId = :promoTotalId")})
public class Promotions implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PROMO_ID")
    private Integer promoId;
    @Size(max = 30)
    @Column(name = "PROMO_NAME")
    private String promoName;
    @Size(max = 30)
    @Column(name = "PROMO_SUBCATEGORY")
    private String promoSubcategory;
    @Column(name = "PROMO_SUBCATEGORY_ID")
    private Integer promoSubcategoryId;
    @Size(max = 30)
    @Column(name = "PROMO_CATEGORY")
    private String promoCategory;
    @Column(name = "PROMO_CATEGORY_ID")
    private Integer promoCategoryId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PROMO_COST")
    private BigDecimal promoCost;
    @Column(name = "PROMO_BEGIN_DATE")
    @Temporal(TemporalType.DATE)
    private Date promoBeginDate;
    @Column(name = "PROMO_END_DATE")
    @Temporal(TemporalType.DATE)
    private Date promoEndDate;
    @Size(max = 15)
    @Column(name = "PROMO_TOTAL")
    private String promoTotal;
    @Column(name = "PROMO_TOTAL_ID")
    private Long promoTotalId;
    @OneToMany(mappedBy = "promoId")
    private Collection<Sales> salesCollection;
    @OneToMany(mappedBy = "promoId")
    private Collection<Costs> costsCollection;

    public Promotions() {
    }

    public Promotions(Integer promoId) {
        this.promoId = promoId;
    }

    public Integer getPromoId() {
        return promoId;
    }

    public void setPromoId(Integer promoId) {
        this.promoId = promoId;
    }

    public String getPromoName() {
        return promoName;
    }

    public void setPromoName(String promoName) {
        this.promoName = promoName;
    }

    public String getPromoSubcategory() {
        return promoSubcategory;
    }

    public void setPromoSubcategory(String promoSubcategory) {
        this.promoSubcategory = promoSubcategory;
    }

    public Integer getPromoSubcategoryId() {
        return promoSubcategoryId;
    }

    public void setPromoSubcategoryId(Integer promoSubcategoryId) {
        this.promoSubcategoryId = promoSubcategoryId;
    }

    public String getPromoCategory() {
        return promoCategory;
    }

    public void setPromoCategory(String promoCategory) {
        this.promoCategory = promoCategory;
    }

    public Integer getPromoCategoryId() {
        return promoCategoryId;
    }

    public void setPromoCategoryId(Integer promoCategoryId) {
        this.promoCategoryId = promoCategoryId;
    }

    public BigDecimal getPromoCost() {
        return promoCost;
    }

    public void setPromoCost(BigDecimal promoCost) {
        this.promoCost = promoCost;
    }

    public Date getPromoBeginDate() {
        return promoBeginDate;
    }

    public void setPromoBeginDate(Date promoBeginDate) {
        this.promoBeginDate = promoBeginDate;
    }

    public Date getPromoEndDate() {
        return promoEndDate;
    }

    public void setPromoEndDate(Date promoEndDate) {
        this.promoEndDate = promoEndDate;
    }

    public String getPromoTotal() {
        return promoTotal;
    }

    public void setPromoTotal(String promoTotal) {
        this.promoTotal = promoTotal;
    }

    public Long getPromoTotalId() {
        return promoTotalId;
    }

    public void setPromoTotalId(Long promoTotalId) {
        this.promoTotalId = promoTotalId;
    }

    @XmlTransient
    public Collection<Sales> getSalesCollection() {
        return salesCollection;
    }

    public void setSalesCollection(Collection<Sales> salesCollection) {
        this.salesCollection = salesCollection;
    }

    @XmlTransient
    public Collection<Costs> getCostsCollection() {
        return costsCollection;
    }

    public void setCostsCollection(Collection<Costs> costsCollection) {
        this.costsCollection = costsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (promoId != null ? promoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Promotions)) {
            return false;
        }
        Promotions other = (Promotions) object;
        if ((this.promoId == null && other.promoId != null) || (this.promoId != null && !this.promoId.equals(other.promoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.supinfo.supmarket.entity.Promotions[ promoId=" + promoId + " ]";
    }
    
}
