/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fashion.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 *
 * @author User
 */
@Entity
@Table(name = "subscriptions")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Subscription.findAll", query = "SELECT s FROM Subscription s")})
public class Subscription implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "start_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "end_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    @JoinColumn(name = "pay_method_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    @Cascade(CascadeType.SAVE_UPDATE)
    private PayMethod payMethod;
    @JoinColumn(name = "plan_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    @Cascade(CascadeType.SAVE_UPDATE)
    private Plan plan;
    @OneToMany(mappedBy = "subscriptions")
    private List<UserSubscription> userSubscriptionList;

    public Subscription() {
    }

    public Subscription(Integer id) {
        this.id = id;
    }

    public Subscription(Integer id, Date startDate, Date endDate) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public PayMethod getPayMethodId() {
        return payMethod;
    }

    public void setPayMethodId(PayMethod payMethod) {
        this.payMethod = payMethod;
    }

    public Plan getPlanId() {
        return plan;
    }

    public void setPlanId(Plan plan) {
        this.plan = plan;
    }

    @XmlTransient
    public List<UserSubscription> getUserSubscriptionList() {
        return userSubscriptionList;
    }

    public void setUserSubscriptionList(List<UserSubscription> userSubscriptionList) {
        this.userSubscriptionList = userSubscriptionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Subscription)) {
            return false;
        }
        Subscription other = (Subscription) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fashion.entity.Subscription[ id=" + id + " ]";
    }
    
}
