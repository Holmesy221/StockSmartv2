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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Holmesy
 */
@Entity
@Table(name = "STOCK")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Stock.findAll", query = "SELECT s FROM Stock s"),
    @NamedQuery(name = "Stock.findById", query = "SELECT s FROM Stock s WHERE s.id = :id"),
    @NamedQuery(name = "Stock.findByItemcode", query = "SELECT s FROM Stock s WHERE s.itemcode = :itemcode"),
    @NamedQuery(name = "Stock.findByItemname", query = "SELECT s FROM Stock s WHERE s.itemname = :itemname"),
    @NamedQuery(name = "Stock.findByItemprice", query = "SELECT s FROM Stock s WHERE s.itemprice = :itemprice"),
    @NamedQuery(name = "Stock.findByItemquant", query = "SELECT s FROM Stock s WHERE s.itemquant = :itemquant"),
    @NamedQuery(name = "Stock.findByMinitemrequired", query = "SELECT s FROM Stock s WHERE s.minitemrequired = :minitemrequired"),
    @NamedQuery(name = "Stock.findByStockarrival", query = "SELECT s FROM Stock s WHERE s.stockarrival = :stockarrival")})
public class Stock implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "ITEMCODE")
    private String itemcode;
    @Column(name = "ITEMNAME")
    private String itemname;
    @Column(name = "ITEMPRICE")
    private String itemprice;
    @Column(name = "ITEMQUANT")
    private String itemquant;
    @Column(name = "MINITEMREQUIRED")
    private String minitemrequired;
    @Column(name = "STOCKARRIVAL")
    private String stockarrival;

    public Stock() {
    }

    public Stock(Integer id) {
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

    public String getItemcode() {
        return itemcode;
    }

    public void setItemcode(String itemcode) {
        String oldItemcode = this.itemcode;
        this.itemcode = itemcode;
        changeSupport.firePropertyChange("itemcode", oldItemcode, itemcode);
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        String oldItemname = this.itemname;
        this.itemname = itemname;
        changeSupport.firePropertyChange("itemname", oldItemname, itemname);
    }

    public String getItemprice() {
        return itemprice;
    }

    public void setItemprice(String itemprice) {
        String oldItemprice = this.itemprice;
        this.itemprice = itemprice;
        changeSupport.firePropertyChange("itemprice", oldItemprice, itemprice);
    }

    public String getItemquant() {
        return itemquant;
    }

    public void setItemquant(String itemquant) {
        String oldItemquant = this.itemquant;
        this.itemquant = itemquant;
        changeSupport.firePropertyChange("itemquant", oldItemquant, itemquant);
    }

    public String getMinitemrequired() {
        return minitemrequired;
    }

    public void setMinitemrequired(String minitemrequired) {
        String oldMinitemrequired = this.minitemrequired;
        this.minitemrequired = minitemrequired;
        changeSupport.firePropertyChange("minitemrequired", oldMinitemrequired, minitemrequired);
    }

    public String getStockarrival() {
        return stockarrival;
    }

    public void setStockarrival(String stockarrival) {
        String oldStockarrival = this.stockarrival;
        this.stockarrival = stockarrival;
        changeSupport.firePropertyChange("stockarrival", oldStockarrival, stockarrival);
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
        if (!(object instanceof Stock)) {
            return false;
        }
        Stock other = (Stock) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "stocksmart.Stock[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
