
package moduls;

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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
@Entity
@Table(name = "doctors")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Doctors.findAll", query = "SELECT d FROM Doctors d")
    , @NamedQuery(name = "Doctors.findById", query = "SELECT d FROM Doctors d WHERE d.id = :id")
    , @NamedQuery(name = "Doctors.findByName", query = "SELECT d FROM Doctors d WHERE d.name = :name")
    , @NamedQuery(name = "Doctors.findByLocation", query = "SELECT d FROM Doctors d WHERE d.location = :location")
    , @NamedQuery(name = "Doctors.findByOpens", query = "SELECT d FROM Doctors d WHERE d.opens = :opens")
    , @NamedQuery(name = "Doctors.findByCloses", query = "SELECT d FROM Doctors d WHERE d.closes = :closes")
    , @NamedQuery(name = "Doctors.findByContact", query = "SELECT d FROM Doctors d WHERE d.contact = :contact")})
public class Doctors implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @Size(max = 45)
    @Column(name = "location")
    private String location;
    @Column(name = "opens")
    private Integer opens;
    @Column(name = "closes")
    private Integer closes;
    @Size(max = 45)
    @Column(name = "contact")
    private String contact;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "doctorId")
    private List<Appointments> appointmentsList;

    public Doctors() {
    }

    public Doctors(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getOpens() {
        return opens;
    }

    public void setOpens(Integer opens) {
        this.opens = opens;
    }

    public Integer getCloses() {
        return closes;
    }

    public void setCloses(Integer closes) {
        this.closes = closes;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @XmlTransient
    public List<Appointments> getAppointmentsList() {
        return appointmentsList;
    }

    public void setAppointmentsList(List<Appointments> appointmentsList) {
        this.appointmentsList = appointmentsList;
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
        if (!(object instanceof Doctors)) {
            return false;
        }
        Doctors other = (Doctors) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "moduls.Doctors[ id=" + id + " ]";
    }
    
}
