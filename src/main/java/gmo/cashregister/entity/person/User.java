package gmo.cashregister.entity.person;

import gmo.cashregister.entity.Address;

import javax.persistence.*;

@Entity
//@Table(name = "user")
@Table(name = "cash_register_user")
public class User extends Person {

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
