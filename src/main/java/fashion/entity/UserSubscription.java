/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fashion.entity;

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
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 *
 * @author User
 */
@Entity
@Table(name = "user_subscriptions")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserSubscription.findAll", query = "SELECT u FROM UserSubscription u")})
public class UserSubscription implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    @ManyToOne
    private SubscriptionStatu status;
    @JoinColumn(name = "subscriptions_id", referencedColumnName = "id")
    @ManyToOne
    @Cascade(CascadeType.SAVE_UPDATE)
    private Subscription subscriptions;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne
    private User user;

    public UserSubscription() {
    }

    public UserSubscription(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public SubscriptionStatu getStatusId() {
        return status;
    }

    public void setStatusId(SubscriptionStatu status) {
        this.status = status;
    }

    public Subscription getSubscriptionsId() {
        return subscriptions;
    }

    public void setSubscriptionsId(Subscription subscriptionsId) {
        this.subscriptions = subscriptionsId;
    }

    public User getUserId() {
        return user;
    }

    public void setUserId(User user) {
        this.user = user;
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
        if (!(object instanceof UserSubscription)) {
            return false;
        }
        UserSubscription other = (UserSubscription) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fashion.entity.UserSubscription[ id=" + id + " ]";
    }
    
}
