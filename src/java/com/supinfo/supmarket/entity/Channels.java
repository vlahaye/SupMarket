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
@Table(name = "channels")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Channels.findAll", query = "SELECT c FROM Channels c"),
    @NamedQuery(name = "Channels.findByChannelId", query = "SELECT c FROM Channels c WHERE c.channelId = :channelId"),
    @NamedQuery(name = "Channels.findByChannelDesc", query = "SELECT c FROM Channels c WHERE c.channelDesc = :channelDesc"),
    @NamedQuery(name = "Channels.findByChannelClass", query = "SELECT c FROM Channels c WHERE c.channelClass = :channelClass"),
    @NamedQuery(name = "Channels.findByChannelClassId", query = "SELECT c FROM Channels c WHERE c.channelClassId = :channelClassId"),
    @NamedQuery(name = "Channels.findByChannelTotal", query = "SELECT c FROM Channels c WHERE c.channelTotal = :channelTotal"),
    @NamedQuery(name = "Channels.findByChannelTotalId", query = "SELECT c FROM Channels c WHERE c.channelTotalId = :channelTotalId")})
public class Channels implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CHANNEL_ID")
    private Integer channelId;
    @Size(max = 20)
    @Column(name = "CHANNEL_DESC")
    private String channelDesc;
    @Size(max = 20)
    @Column(name = "CHANNEL_CLASS")
    private String channelClass;
    @Column(name = "CHANNEL_CLASS_ID")
    private Integer channelClassId;
    @Size(max = 13)
    @Column(name = "CHANNEL_TOTAL")
    private String channelTotal;
    @Column(name = "CHANNEL_TOTAL_ID")
    private Integer channelTotalId;
    @OneToMany(mappedBy = "channelId")
    private Collection<Sales> salesCollection;
    @OneToMany(mappedBy = "channelId")
    private Collection<Costs> costsCollection;

    public Channels() {
    }

    public Channels(Integer channelId) {
        this.channelId = channelId;
    }

    public Integer getChannelId() {
        return channelId;
    }

    public void setChannelId(Integer channelId) {
        this.channelId = channelId;
    }

    public String getChannelDesc() {
        return channelDesc;
    }

    public void setChannelDesc(String channelDesc) {
        this.channelDesc = channelDesc;
    }

    public String getChannelClass() {
        return channelClass;
    }

    public void setChannelClass(String channelClass) {
        this.channelClass = channelClass;
    }

    public Integer getChannelClassId() {
        return channelClassId;
    }

    public void setChannelClassId(Integer channelClassId) {
        this.channelClassId = channelClassId;
    }

    public String getChannelTotal() {
        return channelTotal;
    }

    public void setChannelTotal(String channelTotal) {
        this.channelTotal = channelTotal;
    }

    public Integer getChannelTotalId() {
        return channelTotalId;
    }

    public void setChannelTotalId(Integer channelTotalId) {
        this.channelTotalId = channelTotalId;
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
        hash += (channelId != null ? channelId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Channels)) {
            return false;
        }
        Channels other = (Channels) object;
        if ((this.channelId == null && other.channelId != null) || (this.channelId != null && !this.channelId.equals(other.channelId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.supinfo.supmarket.entity.Channels[ channelId=" + channelId + " ]";
    }
    
}
