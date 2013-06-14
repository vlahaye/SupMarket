/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supmarket.entity;

import java.io.Serializable;
import java.util.Collection;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Vincent
 */
@Entity
@Table(name = "countries")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Countries.findAll", query = "SELECT c FROM Countries c"),
    @NamedQuery(name = "Countries.findByCountryId", query = "SELECT c FROM Countries c WHERE c.countryId = :countryId"),
    @NamedQuery(name = "Countries.findByCountryIsoCode", query = "SELECT c FROM Countries c WHERE c.countryIsoCode = :countryIsoCode"),
    @NamedQuery(name = "Countries.findByCountryName", query = "SELECT c FROM Countries c WHERE c.countryName = :countryName"),
    @NamedQuery(name = "Countries.findByCountrySubregion", query = "SELECT c FROM Countries c WHERE c.countrySubregion = :countrySubregion"),
    @NamedQuery(name = "Countries.findByCountrySubregionId", query = "SELECT c FROM Countries c WHERE c.countrySubregionId = :countrySubregionId"),
    @NamedQuery(name = "Countries.findByCountryRegion", query = "SELECT c FROM Countries c WHERE c.countryRegion = :countryRegion"),
    @NamedQuery(name = "Countries.findByCountryRegionId", query = "SELECT c FROM Countries c WHERE c.countryRegionId = :countryRegionId"),
    @NamedQuery(name = "Countries.findByCountryTotal", query = "SELECT c FROM Countries c WHERE c.countryTotal = :countryTotal"),
    @NamedQuery(name = "Countries.findByCountryTotalId", query = "SELECT c FROM Countries c WHERE c.countryTotalId = :countryTotalId"),
    @NamedQuery(name = "Countries.findByCountryNameHist", query = "SELECT c FROM Countries c WHERE c.countryNameHist = :countryNameHist")})
public class Countries implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "COUNTRY_ID")
    private Integer countryId;
    @Size(max = 2)
    @Column(name = "COUNTRY_ISO_CODE")
    private String countryIsoCode;
    @Size(max = 40)
    @Column(name = "COUNTRY_NAME")
    private String countryName;
    @Size(max = 30)
    @Column(name = "COUNTRY_SUBREGION")
    private String countrySubregion;
    @Column(name = "COUNTRY_SUBREGION_ID")
    private Integer countrySubregionId;
    @Size(max = 20)
    @Column(name = "COUNTRY_REGION")
    private String countryRegion;
    @Column(name = "COUNTRY_REGION_ID")
    private Integer countryRegionId;
    @Size(max = 11)
    @Column(name = "COUNTRY_TOTAL")
    private String countryTotal;
    @Column(name = "COUNTRY_TOTAL_ID")
    private Integer countryTotalId;
    @Size(max = 40)
    @Column(name = "COUNTRY_NAME_HIST")
    private String countryNameHist;
    @OneToMany(mappedBy = "countryId")
    private Collection<Customers> customersCollection;

    public Countries() {
    }

    public Countries(Integer countryId) {
        this.countryId = countryId;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public String getCountryIsoCode() {
        return countryIsoCode;
    }

    public void setCountryIsoCode(String countryIsoCode) {
        this.countryIsoCode = countryIsoCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountrySubregion() {
        return countrySubregion;
    }

    public void setCountrySubregion(String countrySubregion) {
        this.countrySubregion = countrySubregion;
    }

    public Integer getCountrySubregionId() {
        return countrySubregionId;
    }

    public void setCountrySubregionId(Integer countrySubregionId) {
        this.countrySubregionId = countrySubregionId;
    }

    public String getCountryRegion() {
        return countryRegion;
    }

    public void setCountryRegion(String countryRegion) {
        this.countryRegion = countryRegion;
    }

    public Integer getCountryRegionId() {
        return countryRegionId;
    }

    public void setCountryRegionId(Integer countryRegionId) {
        this.countryRegionId = countryRegionId;
    }

    public String getCountryTotal() {
        return countryTotal;
    }

    public void setCountryTotal(String countryTotal) {
        this.countryTotal = countryTotal;
    }

    public Integer getCountryTotalId() {
        return countryTotalId;
    }

    public void setCountryTotalId(Integer countryTotalId) {
        this.countryTotalId = countryTotalId;
    }

    public String getCountryNameHist() {
        return countryNameHist;
    }

    public void setCountryNameHist(String countryNameHist) {
        this.countryNameHist = countryNameHist;
    }

    @XmlTransient
    public Collection<Customers> getCustomersCollection() {
        return customersCollection;
    }

    public void setCustomersCollection(Collection<Customers> customersCollection) {
        this.customersCollection = customersCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (countryId != null ? countryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Countries)) {
            return false;
        }
        Countries other = (Countries) object;
        if ((this.countryId == null && other.countryId != null) || (this.countryId != null && !this.countryId.equals(other.countryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.supinfo.supmarket.entity.Countries[ countryId=" + countryId + " ]";
    }
    
}
