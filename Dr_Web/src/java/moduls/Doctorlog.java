
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
@Table(name = "doctorlog")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Doctorlog.findAll", query = "SELECT d FROM Doctorlog d")
    , @NamedQuery(name = "Doctorlog.findById", query = "SELECT d FROM Doctorlog d WHERE d.id = :id")
    , @NamedQuery(name = "Doctorlog.findByUsername", query = "SELECT d FROM Doctorlog d WHERE d.username = :username")
    , @NamedQuery(name = "Doctorlog.findByPass", query = "SELECT d FROM Doctorlog d WHERE d.pass = :pass")
    , @NamedQuery(name ="Doctorlog.Auth", query = "SELECT u FROM Doctorlog u WHERE u.username=:username and u.pass = :pass")})
public class Doctorlog implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "username")
    private String username;
    @Size(max = 45)
    @Column(name = "pass")
    private String pass;

    public Doctorlog() {
    }

    public Doctorlog(Integer id) {
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
        if (!(object instanceof Doctorlog)) {
            return false;
        }
        Doctorlog other = (Doctorlog) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "moduls.Doctorlog[ id=" + id + " ]";
    }
    
}
