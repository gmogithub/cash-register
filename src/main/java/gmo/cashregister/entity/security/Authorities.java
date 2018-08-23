package gmo.cashregister.entity.security;

import gmo.cashregister.entity.person.User;

import javax.persistence.*;

@Entity
@Table(name = "cash_register_authorities")
public class Authorities {
    @Id
    @Column(name = "authority")
    private String authority;

    @ManyToOne
    @JoinColumn(name = "username")
    private User user;

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
