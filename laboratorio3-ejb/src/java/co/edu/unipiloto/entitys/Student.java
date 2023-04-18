/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.entitys;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "STUDENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s"),
    @NamedQuery(name = "Student.findByStudenId", query = "SELECT s FROM Student s WHERE s.studenId = :studenId"),
    @NamedQuery(name = "Student.findByFirstname", query = "SELECT s FROM Student s WHERE s.firstname = :firstname"),
    @NamedQuery(name = "Student.findByLastname", query = "SELECT s FROM Student s WHERE s.lastname = :lastname"),
    @NamedQuery(name = "Student.findByYearlevel", query = "SELECT s FROM Student s WHERE s.yearlevel = :yearlevel")})
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "STUDEN_ID")
    private Integer studenId;
    @Size(max = 50)
    @Column(name = "FIRSTNAME")
    private String firstname;
    @Size(max = 50)
    @Column(name = "LASTNAME")
    private String lastname;
    @Column(name = "YEARLEVEL")
    private Integer yearlevel;

    public Student() {
        
    }

    public Student(Integer studenId, String firstname, String lastname, Integer yearlevel) {
        this.studenId = studenId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.yearlevel = yearlevel;
    }
    

    public Student(Integer studenId) {
        this.studenId = studenId;
    }

    public Integer getStudenId() {
        return studenId;
    }

    public void setStudenId(Integer studenId) {
        this.studenId = studenId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getYearlevel() {
        return yearlevel;
    }

    public void setYearlevel(Integer yearlevel) {
        this.yearlevel = yearlevel;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (studenId != null ? studenId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Student)) {
            return false;
        }
        Student other = (Student) object;
        if ((this.studenId == null && other.studenId != null) || (this.studenId != null && !this.studenId.equals(other.studenId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unipiloto.entitys.Student[ studenId=" + studenId + " ]";
    }
    
}
