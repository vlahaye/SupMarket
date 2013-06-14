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
@Table(name = "products")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Products.findAll", query = "SELECT p FROM Products p"),
    @NamedQuery(name = "Products.findByProdId", query = "SELECT p FROM Products p WHERE p.prodId = :prodId"),
    @NamedQuery(name = "Products.findByProdName", query = "SELECT p FROM Products p WHERE p.prodName = :prodName"),
    @NamedQuery(name = "Products.findByProdDesc", query = "SELECT p FROM Products p WHERE p.prodDesc = :prodDesc"),
    @NamedQuery(name = "Products.findByProdSubcategory", query = "SELECT p FROM Products p WHERE p.prodSubcategory = :prodSubcategory"),
    @NamedQuery(name = "Products.findByProdSubcategoryId", query = "SELECT p FROM Products p WHERE p.prodSubcategoryId = :prodSubcategoryId"),
    @NamedQuery(name = "Products.findByProdSubcategoryDesc", query = "SELECT p FROM Products p WHERE p.prodSubcategoryDesc = :prodSubcategoryDesc"),
    @NamedQuery(name = "Products.findByProdCategory", query = "SELECT p FROM Products p WHERE p.prodCategory = :prodCategory"),
    @NamedQuery(name = "Products.findByProdCategoryId", query = "SELECT p FROM Products p WHERE p.prodCategoryId = :prodCategoryId"),
    @NamedQuery(name = "Products.findByProdCategoryDesc", query = "SELECT p FROM Products p WHERE p.prodCategoryDesc = :prodCategoryDesc"),
    @NamedQuery(name = "Products.findByProdWeightClass", query = "SELECT p FROM Products p WHERE p.prodWeightClass = :prodWeightClass"),
    @NamedQuery(name = "Products.findByProdUnitOfMeasure", query = "SELECT p FROM Products p WHERE p.prodUnitOfMeasure = :prodUnitOfMeasure"),
    @NamedQuery(name = "Products.findByProdPackSize", query = "SELECT p FROM Products p WHERE p.prodPackSize = :prodPackSize"),
    @NamedQuery(name = "Products.findBySupplierId", query = "SELECT p FROM Products p WHERE p.supplierId = :supplierId"),
    @NamedQuery(name = "Products.findByProdStatus", query = "SELECT p FROM Products p WHERE p.prodStatus = :prodStatus"),
    @NamedQuery(name = "Products.findByProdListPrice", query = "SELECT p FROM Products p WHERE p.prodListPrice = :prodListPrice"),
    @NamedQuery(name = "Products.findByProdMinPrice", query = "SELECT p FROM Products p WHERE p.prodMinPrice = :prodMinPrice"),
    @NamedQuery(name = "Products.findByProdTotal", query = "SELECT p FROM Products p WHERE p.prodTotal = :prodTotal"),
    @NamedQuery(name = "Products.findByProdTotalId", query = "SELECT p FROM Products p WHERE p.prodTotalId = :prodTotalId"),
    @NamedQuery(name = "Products.findByProdSrcId", query = "SELECT p FROM Products p WHERE p.prodSrcId = :prodSrcId"),
    @NamedQuery(name = "Products.findByProdEffFrom", query = "SELECT p FROM Products p WHERE p.prodEffFrom = :prodEffFrom"),
    @NamedQuery(name = "Products.findByProdEffTo", query = "SELECT p FROM Products p WHERE p.prodEffTo = :prodEffTo"),
    @NamedQuery(name = "Products.findByProdValid", query = "SELECT p FROM Products p WHERE p.prodValid = :prodValid")})
public class Products implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PROD_ID")
    private Integer prodId;
    @Size(max = 50)
    @Column(name = "PROD_NAME")
    private String prodName;
    @Size(max = 4000)
    @Column(name = "PROD_DESC")
    private String prodDesc;
    @Size(max = 50)
    @Column(name = "PROD_SUBCATEGORY")
    private String prodSubcategory;
    @Column(name = "PROD_SUBCATEGORY_ID")
    private Integer prodSubcategoryId;
    @Size(max = 2000)
    @Column(name = "PROD_SUBCATEGORY_DESC")
    private String prodSubcategoryDesc;
    @Size(max = 50)
    @Column(name = "PROD_CATEGORY")
    private String prodCategory;
    @Column(name = "PROD_CATEGORY_ID")
    private Integer prodCategoryId;
    @Size(max = 2000)
    @Column(name = "PROD_CATEGORY_DESC")
    private String prodCategoryDesc;
    @Column(name = "PROD_WEIGHT_CLASS")
    private Short prodWeightClass;
    @Size(max = 20)
    @Column(name = "PROD_UNIT_OF_MEASURE")
    private String prodUnitOfMeasure;
    @Size(max = 30)
    @Column(name = "PROD_PACK_SIZE")
    private String prodPackSize;
    @Column(name = "SUPPLIER_ID")
    private Integer supplierId;
    @Size(max = 20)
    @Column(name = "PROD_STATUS")
    private String prodStatus;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PROD_LIST_PRICE")
    private BigDecimal prodListPrice;
    @Column(name = "PROD_MIN_PRICE")
    private BigDecimal prodMinPrice;
    @Size(max = 13)
    @Column(name = "PROD_TOTAL")
    private String prodTotal;
    @Column(name = "PROD_TOTAL_ID")
    private Integer prodTotalId;
    @Column(name = "PROD_SRC_ID")
    private Integer prodSrcId;
    @Column(name = "PROD_EFF_FROM")
    @Temporal(TemporalType.DATE)
    private Date prodEffFrom;
    @Column(name = "PROD_EFF_TO")
    @Temporal(TemporalType.DATE)
    private Date prodEffTo;
    @Size(max = 1)
    @Column(name = "PROD_VALID")
    private String prodValid;
    @OneToMany(mappedBy = "prodId")
    private Collection<Sales> salesCollection;
    @OneToMany(mappedBy = "prodId")
    private Collection<Costs> costsCollection;

    public Products() {
    }

    public Products(Integer prodId) {
        this.prodId = prodId;
    }

    public Integer getProdId() {
        return prodId;
    }

    public void setProdId(Integer prodId) {
        this.prodId = prodId;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public String getProdDesc() {
        return prodDesc;
    }

    public void setProdDesc(String prodDesc) {
        this.prodDesc = prodDesc;
    }

    public String getProdSubcategory() {
        return prodSubcategory;
    }

    public void setProdSubcategory(String prodSubcategory) {
        this.prodSubcategory = prodSubcategory;
    }

    public Integer getProdSubcategoryId() {
        return prodSubcategoryId;
    }

    public void setProdSubcategoryId(Integer prodSubcategoryId) {
        this.prodSubcategoryId = prodSubcategoryId;
    }

    public String getProdSubcategoryDesc() {
        return prodSubcategoryDesc;
    }

    public void setProdSubcategoryDesc(String prodSubcategoryDesc) {
        this.prodSubcategoryDesc = prodSubcategoryDesc;
    }

    public String getProdCategory() {
        return prodCategory;
    }

    public void setProdCategory(String prodCategory) {
        this.prodCategory = prodCategory;
    }

    public Integer getProdCategoryId() {
        return prodCategoryId;
    }

    public void setProdCategoryId(Integer prodCategoryId) {
        this.prodCategoryId = prodCategoryId;
    }

    public String getProdCategoryDesc() {
        return prodCategoryDesc;
    }

    public void setProdCategoryDesc(String prodCategoryDesc) {
        this.prodCategoryDesc = prodCategoryDesc;
    }

    public Short getProdWeightClass() {
        return prodWeightClass;
    }

    public void setProdWeightClass(Short prodWeightClass) {
        this.prodWeightClass = prodWeightClass;
    }

    public String getProdUnitOfMeasure() {
        return prodUnitOfMeasure;
    }

    public void setProdUnitOfMeasure(String prodUnitOfMeasure) {
        this.prodUnitOfMeasure = prodUnitOfMeasure;
    }

    public String getProdPackSize() {
        return prodPackSize;
    }

    public void setProdPackSize(String prodPackSize) {
        this.prodPackSize = prodPackSize;
    }

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public String getProdStatus() {
        return prodStatus;
    }

    public void setProdStatus(String prodStatus) {
        this.prodStatus = prodStatus;
    }

    public BigDecimal getProdListPrice() {
        return prodListPrice;
    }

    public void setProdListPrice(BigDecimal prodListPrice) {
        this.prodListPrice = prodListPrice;
    }

    public BigDecimal getProdMinPrice() {
        return prodMinPrice;
    }

    public void setProdMinPrice(BigDecimal prodMinPrice) {
        this.prodMinPrice = prodMinPrice;
    }

    public String getProdTotal() {
        return prodTotal;
    }

    public void setProdTotal(String prodTotal) {
        this.prodTotal = prodTotal;
    }

    public Integer getProdTotalId() {
        return prodTotalId;
    }

    public void setProdTotalId(Integer prodTotalId) {
        this.prodTotalId = prodTotalId;
    }

    public Integer getProdSrcId() {
        return prodSrcId;
    }

    public void setProdSrcId(Integer prodSrcId) {
        this.prodSrcId = prodSrcId;
    }

    public Date getProdEffFrom() {
        return prodEffFrom;
    }

    public void setProdEffFrom(Date prodEffFrom) {
        this.prodEffFrom = prodEffFrom;
    }

    public Date getProdEffTo() {
        return prodEffTo;
    }

    public void setProdEffTo(Date prodEffTo) {
        this.prodEffTo = prodEffTo;
    }

    public String getProdValid() {
        return prodValid;
    }

    public void setProdValid(String prodValid) {
        this.prodValid = prodValid;
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
        hash += (prodId != null ? prodId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Products)) {
            return false;
        }
        Products other = (Products) object;
        if ((this.prodId == null && other.prodId != null) || (this.prodId != null && !this.prodId.equals(other.prodId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.supinfo.supmarket.entity.Products[ prodId=" + prodId + " ]";
    }
    
}
