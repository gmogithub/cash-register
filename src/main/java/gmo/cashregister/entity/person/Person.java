package gmo.cashregister.entity.person;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import gmo.cashregister.entity.security.Authorities;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@JsonIgnoreProperties(value = {"dtCreate", "dtUpdate"}, allowGetters = true)
//@EntityListeners(AuditingEntityListener.class)
public abstract class Person {

    @Id
    @Column(name = "username", length = 100, nullable = false)
    protected String username;

    @Column(name = "lastname", length = 150)
    protected String lastName;

    @Column(name = "firstname", length = 150)
    protected String firstName;

    @Column(name = "email", length = 200, nullable = false)
    protected String email;

    @Column(name = "password", length = 100, nullable = false)
    protected String password;

    @Column(name = "dt_create", nullable = false)
//    @Temporal(TemporalType.TIMESTAMP)
//    @CreatedDate
    protected LocalDate dtCreate;

    @Column(name = "dt_update", nullable = false)
//    @Temporal(TemporalType.TIMESTAMP)
//    @LastModifiedDate
    protected LocalDate dtUpdate;

    @Column(name = "valid")
    protected boolean valid = false;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private Set<Authorities> authorities = new HashSet<>();

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalDate getDtCreate() {
        return dtCreate;
    }

    public void setDtCreate(LocalDate dtCreate) {
        this.dtCreate = dtCreate;
    }

    public LocalDate getDtUpdate() {
        return dtUpdate;
    }

    public void setDtUpdate(LocalDate dtUpdate) {
        this.dtUpdate = dtUpdate;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public Set<Authorities> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<Authorities> authorities) {
        this.authorities = authorities;
    }
}
