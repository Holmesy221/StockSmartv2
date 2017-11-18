/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stocksmart;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Holmesy
 */
@Entity
@Table(name = "ORDERSUGGESTIONS", catalog = "", schema = "APP")
@NamedQueries({
    @NamedQuery(name = "Ordersuggestions.findAll", query = "SELECT o FROM Ordersuggestions o"),
    @NamedQuery(name = "Ordersuggestions.findById", query = "SELECT o FROM Ordersuggestions o WHERE o.id = :id"),
    @NamedQuery(name = "Ordersuggestions.findByItemname", query = "SELECT o FROM Ordersuggestions o WHERE o.itemname = :itemname"),
    @NamedQuery(name = "Ordersuggestions.findByMinitemrequired", query = "SELECT o FROM Ordersuggestions o WHERE o.minitemrequired = :minitemrequired")})
public class Ordersuggestions implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "ITEMNAME")
    private String itemname;
    @Column(name = "MINITEMREQUIRED")
    private String minitemrequired;

    public Ordersuggestions() {
    }

    public Ordersuggestions(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        String oldItemname = this.itemname;
        this.itemname = itemname;
        changeSupport.firePropertyChange("itemname", oldItemname, itemname);
    }

    public String getMinitemrequired() {
        return minitemrequired;
    }

    public void setMinitemrequired(String minitemrequired) {
        String oldMinitemrequired = this.minitemrequired;
        this.minitemrequired = minitemrequired;
        changeSupport.firePropertyChange("minitemrequired", oldMinitemrequired, minitemrequired);
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
        if (!(object instanceof Ordersuggestions)) {
            return false;
        }
        Ordersuggestions other = (Ordersuggestions) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "stocksmart.Ordersuggestions[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
