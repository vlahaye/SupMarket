/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supmarket.entity;

import java.io.Serializable;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Vincent
 */
@Entity
@Table(name = "supplementary_demographics")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SupplementaryDemographics.findAll", query = "SELECT s FROM SupplementaryDemographics s"),
    @NamedQuery(name = "SupplementaryDemographics.findByEducation", query = "SELECT s FROM SupplementaryDemographics s WHERE s.education = :education"),
    @NamedQuery(name = "SupplementaryDemographics.findByOccupation", query = "SELECT s FROM SupplementaryDemographics s WHERE s.occupation = :occupation"),
    @NamedQuery(name = "SupplementaryDemographics.findByHouseholdSize", query = "SELECT s FROM SupplementaryDemographics s WHERE s.householdSize = :householdSize"),
    @NamedQuery(name = "SupplementaryDemographics.findByYrsResidence", query = "SELECT s FROM SupplementaryDemographics s WHERE s.yrsResidence = :yrsResidence"),
    @NamedQuery(name = "SupplementaryDemographics.findByAffinityCard", query = "SELECT s FROM SupplementaryDemographics s WHERE s.affinityCard = :affinityCard"),
    @NamedQuery(name = "SupplementaryDemographics.findByBulkPackDiskettes", query = "SELECT s FROM SupplementaryDemographics s WHERE s.bulkPackDiskettes = :bulkPackDiskettes"),
    @NamedQuery(name = "SupplementaryDemographics.findByFlatPanelMonitor", query = "SELECT s FROM SupplementaryDemographics s WHERE s.flatPanelMonitor = :flatPanelMonitor"),
    @NamedQuery(name = "SupplementaryDemographics.findByHomeTheaterPackage", query = "SELECT s FROM SupplementaryDemographics s WHERE s.homeTheaterPackage = :homeTheaterPackage"),
    @NamedQuery(name = "SupplementaryDemographics.findByBookkeepingApplication", query = "SELECT s FROM SupplementaryDemographics s WHERE s.bookkeepingApplication = :bookkeepingApplication"),
    @NamedQuery(name = "SupplementaryDemographics.findByPrinterSupplies", query = "SELECT s FROM SupplementaryDemographics s WHERE s.printerSupplies = :printerSupplies"),
    @NamedQuery(name = "SupplementaryDemographics.findByYBoxGames", query = "SELECT s FROM SupplementaryDemographics s WHERE s.yBoxGames = :yBoxGames"),
    @NamedQuery(name = "SupplementaryDemographics.findByOsDocSetKanji", query = "SELECT s FROM SupplementaryDemographics s WHERE s.osDocSetKanji = :osDocSetKanji"),
    @NamedQuery(name = "SupplementaryDemographics.findByComments", query = "SELECT s FROM SupplementaryDemographics s WHERE s.comments = :comments"),
    @NamedQuery(name = "SupplementaryDemographics.findByDemographId", query = "SELECT s FROM SupplementaryDemographics s WHERE s.demographId = :demographId")})
public class SupplementaryDemographics implements Serializable {
    private static final long serialVersionUID = 1L;
    @Size(max = 21)
    @Column(name = "EDUCATION")
    private String education;
    @Size(max = 21)
    @Column(name = "OCCUPATION")
    private String occupation;
    @Size(max = 21)
    @Column(name = "HOUSEHOLD_SIZE")
    private String householdSize;
    @Column(name = "YRS_RESIDENCE")
    private Integer yrsResidence;
    @Column(name = "AFFINITY_CARD")
    private Long affinityCard;
    @Column(name = "BULK_PACK_DISKETTES")
    private Long bulkPackDiskettes;
    @Column(name = "FLAT_PANEL_MONITOR")
    private Long flatPanelMonitor;
    @Column(name = "HOME_THEATER_PACKAGE")
    private Long homeTheaterPackage;
    @Column(name = "BOOKKEEPING_APPLICATION")
    private Long bookkeepingApplication;
    @Column(name = "PRINTER_SUPPLIES")
    private Long printerSupplies;
    @Column(name = "Y_BOX_GAMES")
    private Long yBoxGames;
    @Column(name = "OS_DOC_SET_KANJI")
    private Long osDocSetKanji;
    @Size(max = 4000)
    @Column(name = "COMMENTS")
    private String comments;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "DEMOGRAPH_ID")
    private Integer demographId;
    @JoinColumn(name = "CUST_ID", referencedColumnName = "CUST_ID")
    @ManyToOne(optional = false)
    private Customers custId;

    public SupplementaryDemographics() {
    }

    public SupplementaryDemographics(Integer demographId) {
        this.demographId = demographId;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getHouseholdSize() {
        return householdSize;
    }

    public void setHouseholdSize(String householdSize) {
        this.householdSize = householdSize;
    }

    public Integer getYrsResidence() {
        return yrsResidence;
    }

    public void setYrsResidence(Integer yrsResidence) {
        this.yrsResidence = yrsResidence;
    }

    public Long getAffinityCard() {
        return affinityCard;
    }

    public void setAffinityCard(Long affinityCard) {
        this.affinityCard = affinityCard;
    }

    public Long getBulkPackDiskettes() {
        return bulkPackDiskettes;
    }

    public void setBulkPackDiskettes(Long bulkPackDiskettes) {
        this.bulkPackDiskettes = bulkPackDiskettes;
    }

    public Long getFlatPanelMonitor() {
        return flatPanelMonitor;
    }

    public void setFlatPanelMonitor(Long flatPanelMonitor) {
        this.flatPanelMonitor = flatPanelMonitor;
    }

    public Long getHomeTheaterPackage() {
        return homeTheaterPackage;
    }

    public void setHomeTheaterPackage(Long homeTheaterPackage) {
        this.homeTheaterPackage = homeTheaterPackage;
    }

    public Long getBookkeepingApplication() {
        return bookkeepingApplication;
    }

    public void setBookkeepingApplication(Long bookkeepingApplication) {
        this.bookkeepingApplication = bookkeepingApplication;
    }

    public Long getPrinterSupplies() {
        return printerSupplies;
    }

    public void setPrinterSupplies(Long printerSupplies) {
        this.printerSupplies = printerSupplies;
    }

    public Long getYBoxGames() {
        return yBoxGames;
    }

    public void setYBoxGames(Long yBoxGames) {
        this.yBoxGames = yBoxGames;
    }

    public Long getOsDocSetKanji() {
        return osDocSetKanji;
    }

    public void setOsDocSetKanji(Long osDocSetKanji) {
        this.osDocSetKanji = osDocSetKanji;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Integer getDemographId() {
        return demographId;
    }

    public void setDemographId(Integer demographId) {
        this.demographId = demographId;
    }

    public Customers getCustId() {
        return custId;
    }

    public void setCustId(Customers custId) {
        this.custId = custId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (demographId != null ? demographId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SupplementaryDemographics)) {
            return false;
        }
        SupplementaryDemographics other = (SupplementaryDemographics) object;
        if ((this.demographId == null && other.demographId != null) || (this.demographId != null && !this.demographId.equals(other.demographId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.supinfo.supmarket.entity.SupplementaryDemographics[ demographId=" + demographId + " ]";
    }
    
}
