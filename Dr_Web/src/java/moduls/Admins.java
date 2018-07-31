
package moduls;

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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "admins")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Admins.findAll", query = "SELECT a FROM Admins a")
    , @NamedQuery(name = "Admins.findById", query = "SELECT a FROM Admins a WHERE a.id = :id")
    , @NamedQuery(name = "Admins.findByUsername", query = "SELECT a FROM Admins a WHERE a.username = :username")
    , @NamedQuery(name = "Admins.findByPass", query = "SELECT a FROM Admins a WHERE a.pass = :pass")
    , @NamedQuery(name = "Admins.Auth", query = "SELECT a FROM Admins a WHERE a.username = :username and a.pass = :pass")})
public class Admins implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 15)
    @Column(name = "username")
    private String username;
    @Size(max = 15)
    @Column(name = "pass")
    private String pass;

    public Admins() {
    }

    public Admins(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
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
        if (!(object instanceof Admins)) {
            return false;
        }
        Admins other = (Admins) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "moduls.Admins[ id=" + id + " ]";
    }
    
}
