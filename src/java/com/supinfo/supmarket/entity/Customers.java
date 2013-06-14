/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supmarket.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Vincent
 */
@Entity
@Table(name = "customers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Customers.findAll", query = "SELECT c FROM Customers c"),
    @NamedQuery(name = "Customers.findByCustId", query = "SELECT c FROM Customers c WHERE c.custId = :custId"),
    @NamedQuery(name = "Customers.findByCustFirstName", query = "SELECT c FROM Customers c WHERE c.custFirstName = :custFirstName"),
    @NamedQuery(name = "Customers.findByCustLastName", query = "SELECT c FROM Customers c WHERE c.custLastName = :custLastName"),
    @NamedQuery(name = "Customers.findByCustGender", query = "SELECT c FROM Customers c WHERE c.custGender = :custGender"),
    @NamedQuery(name = "Customers.findByCustYearOfBirth", query = "SELECT c FROM Customers c WHERE c.custYearOfBirth = :custYearOfBirth"),
    @NamedQuery(name = "Customers.findByCustMaritalStatus", query = "SELECT c FROM Customers c WHERE c.custMaritalStatus = :custMaritalStatus"),
    @NamedQuery(name = "Customers.findByCustStreetAddress", query = "SELECT c FROM Customers c WHERE c.custStreetAddress = :custStreetAddress"),
    @NamedQuery(name = "Customers.findByCustPostalCode", query = "SELECT c FROM Customers c WHERE c.custPostalCode = :custPostalCode"),
    @NamedQuery(name = "Customers.findByCustCity", query = "SELECT c FROM Customers c WHERE c.custCity = :custCity"),
    @NamedQuery(name = "Customers.findByCustCityId", query = "SELECT c FROM Customers c WHERE c.custCityId = :custCityId"),
    @NamedQuery(name = "Customers.findByCustStateProvince", query = "SELECT c FROM Customers c WHERE c.custStateProvince = :custStateProvince"),
    @NamedQuery(name = "Customers.findByCustStateProvinceId", query = "SELECT c FROM Customers c WHERE c.custStateProvinceId = :custStateProvinceId"),
    @NamedQuery(name = "Customers.findByCustMainPhoneNumber", query = "SELECT c FROM Customers c WHERE c.custMainPhoneNumber = :custMainPhoneNumber"),
    @NamedQuery(name = "Customers.findByCustIncomeLevel", query = "SELECT c FROM Customers c WHERE c.custIncomeLevel = :custIncomeLevel"),
    @NamedQuery(name = "Customers.findByCustCreditLimit", query = "SELECT c FROM Customers c WHERE c.custCreditLimit = :custCreditLimit"),
    @NamedQuery(name = "Customers.findByCustEmail", query = "SELECT c FROM Customers c WHERE c.custEmail = :custEmail"),
    @NamedQuery(name = "Customers.findByCustTotal", query = "SELECT c FROM Customers c WHERE c.custTotal = :custTotal"),
    @NamedQuery(name = "Customers.findByCustTotalId", query = "SELECT c FROM Customers c WHERE c.custTotalId = :custTotalId"),
    @NamedQuery(name = "Customers.findByCustSrcId", query = "SELECT c FROM Customers c WHERE c.custSrcId = :custSrcId"),
    @NamedQuery(name = "Customers.findByCustEffFrom", query = "SELECT c FROM Customers c WHERE c.custEffFrom = :custEffFrom"),
    @NamedQuery(name = "Customers.findByCustEffTo", query = "SELECT c FROM Customers c WHERE c.custEffTo = :custEffTo"),
    @NamedQuery(name = "Customers.findByCustValid", query = "SELECT c FROM Customers c WHERE c.custValid = :custValid")})
public class Customers implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CUST_ID")
    private Integer custId;
    @Size(max = 20)
    @Column(name = "CUST_FIRST_NAME")
    private String custFirstName;
    @Size(max = 40)
    @Column(name = "CUST_LAST_NAME")
    private String custLastName;
    @Column(name = "CUST_GENDER")
    private Character custGender;
    @Column(name = "CUST_YEAR_OF_BIRTH")
    private Short custYearOfBirth;
    @Size(max = 20)
    @Column(name = "CUST_MARITAL_STATUS")
    private String custMaritalStatus;
    @Size(max = 40)
    @Column(name = "CUST_STREET_ADDRESS")
    private String custStreetAddress;
    @Size(max = 10)
    @Column(name = "CUST_POSTAL_CODE")
    private String custPostalCode;
    @Size(max = 30)
    @Column(name = "CUST_CITY")
    private String custCity;
    @Column(name = "CUST_CITY_ID")
    private Integer custCityId;
    @Size(max = 40)
    @Column(name = "CUST_STATE_PROVINCE")
    private String custStateProvince;
    @Column(name = "CUST_STATE_PROVINCE_ID")
    private Integer custStateProvinceId;
    @Size(max = 25)
    @Column(name = "CUST_MAIN_PHONE_NUMBER")
    private String custMainPhoneNumber;
    @Size(max = 30)
    @Column(name = "CUST_INCOME_LEVEL")
    private String custIncomeLevel;
    @Column(name = "CUST_CREDIT_LIMIT")
    private Integer custCreditLimit;
    @Size(max = 30)
    @Column(name = "CUST_EMAIL")
    private String custEmail;
    @Size(max = 14)
    @Column(name = "CUST_TOTAL")
    private String custTotal;
    @Column(name = "CUST_TOTAL_ID")
    private Integer custTotalId;
    @Column(name = "CUST_SRC_ID")
    private Integer custSrcId;
    @Column(name = "CUST_EFF_FROM")
    @Temporal(TemporalType.DATE)
    private Date custEffFrom;
    @Column(name = "CUST_EFF_TO")
    @Temporal(TemporalType.DATE)
    private Date custEffTo;
    @Size(max = 1)
    @Column(name = "CUST_VALID")
    private String custValid;
    @OneToMany(mappedBy = "custId")
    private Collection<Sales> salesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "custId")
    private Collection<SupplementaryDemographics> supplementaryDemographicsCollection;
    @JoinColumn(name = "COUNTRY_ID", referencedColumnName = "COUNTRY_ID")
    @ManyToOne
    private Countries countryId;

    public Customers() {
    }

    public Customers(Integer custId) {
        this.custId = custId;
    }

    public Integer getCustId() {
        return custId;
    }

    public void setCustId(Integer custId) {
        this.custId = custId;
    }

    public String getCustFirstName() {
        return custFirstName;
    }

    public void setCustFirstName(String custFirstName) {
        this.custFirstName = custFirstName;
    }

    public String getCustLastName() {
        return custLastName;
    }

    public void setCustLastName(String custLastName) {
        this.custLastName = custLastName;
    }

    public Character getCustGender() {
        return custGender;
    }

    public void setCustGender(Character custGender) {
        this.custGender = custGender;
    }

    public Short getCustYearOfBirth() {
        return custYearOfBirth;
    }

    public void setCustYearOfBirth(Short custYearOfBirth) {
        this.custYearOfBirth = custYearOfBirth;
    }

    public String getCustMaritalStatus() {
        return custMaritalStatus;
    }

    public void setCustMaritalStatus(String custMaritalStatus) {
        this.custMaritalStatus = custMaritalStatus;
    }

    public String getCustStreetAddress() {
        return custStreetAddress;
    }

    public void setCustStreetAddress(String custStreetAddress) {
        this.custStreetAddress = custStreetAddress;
    }

    public String getCustPostalCode() {
        return custPostalCode;
    }

    public void setCustPostalCode(String custPostalCode) {
        this.custPostalCode = custPostalCode;
    }

    public String getCustCity() {
        return custCity;
    }

    public void setCustCity(String custCity) {
        this.custCity = custCity;
    }

    public Integer getCustCityId() {
        return custCityId;
    }

    public void setCustCityId(Integer custCityId) {
        this.custCityId = custCityId;
    }

    public String getCustStateProvince() {
        return custStateProvince;
    }

    public void setCustStateProvince(String custStateProvince) {
        this.custStateProvince = custStateProvince;
    }

    public Integer getCustStateProvinceId() {
        return custStateProvinceId;
    }

    public void setCustStateProvinceId(Integer custStateProvinceId) {
        this.custStateProvinceId = custStateProvinceId;
    }

    public String getCustMainPhoneNumber() {
        return custMainPhoneNumber;
    }

    public void setCustMainPhoneNumber(String custMainPhoneNumber) {
        this.custMainPhoneNumber = custMainPhoneNumber;
    }

    public String getCustIncomeLevel() {
        return custIncomeLevel;
    }

    public void setCustIncomeLevel(String custIncomeLevel) {
        this.custIncomeLevel = custIncomeLevel;
    }

    public Integer getCustCreditLimit() {
        return custCreditLimit;
    }

    public void setCustCreditLimit(Integer custCreditLimit) {
        this.custCreditLimit = custCreditLimit;
    }

    public String getCustEmail() {
        return custEmail;
    }

    public void setCustEmail(String custEmail) {
        this.custEmail = custEmail;
    }

    public String getCustTotal() {
        return custTotal;
    }

    public void setCustTotal(String custTotal) {
        this.custTotal = custTotal;
    }

    public Integer getCustTotalId() {
        return custTotalId;
    }

    public void setCustTotalId(Integer custTotalId) {
        this.custTotalId = custTotalId;
    }

    public Integer getCustSrcId() {
        return custSrcId;
    }

    public void setCustSrcId(Integer custSrcId) {
        this.custSrcId = custSrcId;
    }

    public Date getCustEffFrom() {
        return custEffFrom;
    }

    public void setCustEffFrom(Date custEffFrom) {
        this.custEffFrom = custEffFrom;
    }

    public Date getCustEffTo() {
        return custEffTo;
    }

    public void setCustEffTo(Date custEffTo) {
        this.custEffTo = custEffTo;
    }

    public String getCustValid() {
        return custValid;
    }

    public void setCustValid(String custValid) {
        this.custValid = custValid;
    }

    @XmlTransient
    public Collection<Sales> getSalesCollection() {
        return salesCollection;
    }

    public void setSalesCollection(Collection<Sales> salesCollection) {
        this.salesCollection = salesCollection;
    }

    @XmlTransient
    public Collection<SupplementaryDemographics> getSupplementaryDemographicsCollection() {
        return supplementaryDemographicsCollection;
    }

    public void setSupplementaryDemographicsCollection(Collection<SupplementaryDemographics> supplementaryDemographicsCollection) {
        this.supplementaryDemographicsCollection = supplementaryDemographicsCollection;
    }

    public Countries getCountryId() {
        return countryId;
    }

    public void setCountryId(Countries countryId) {
        this.countryId = countryId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (custId != null ? custId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customers)) {
            return false;
        }
        Customers other = (Customers) object;
        if ((this.custId == null && other.custId != null) || (this.custId != null && !this.custId.equals(other.custId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.supinfo.supmarket.entity.Customers[ custId=" + custId + " ]";
    }
    
}
