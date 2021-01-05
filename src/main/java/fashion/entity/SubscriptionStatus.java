/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fashion.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author User
 */
@Entity
@Table(name = "subscription_status")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SubscriptionStatus.findAll", query = "SELECT s FROM SubscriptionStatus s"),
    @NamedQuery(name = "SubscriptionStatus.findById", query = "SELECT s FROM SubscriptionStatus s WHERE s.id = :id"),
    @NamedQuery(name = "SubscriptionStatus.findByStatus", query = "SELECT s FROM SubscriptionStatus s WHERE s.status = :status")})
public class SubscriptionStatus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Short id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "status")
    private String status;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "statusId")
//    private List<Subscription> subscriptionList;

    public SubscriptionStatus() {
    }

    public SubscriptionStatus(Short id) {
        this.id = id;
    }

    public SubscriptionStatus(Short id, String status) {
        this.id = id;
        this.status = status;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

//    @XmlTransient
//    public List<Subscription> getSubscriptionList() {
//        return subscriptionList;
//    }
//
//    public void setSubscriptionList(List<Subscription> subscriptionList) {
//        this.subscriptionList = subscriptionList;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SubscriptionStatus)) {
            return false;
        }
        SubscriptionStatus other = (SubscriptionStatus) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fashion.entity.SubscriptionStatus[ id=" + id + " ]";
    }
    
}
