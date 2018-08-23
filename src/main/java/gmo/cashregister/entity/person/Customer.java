package gmo.cashregister.entity.person;

import gmo.cashregister.entity.Address;

//import javax.persistence.ManyToOne;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Set;

//
@Entity
//@Table(name = "customer")
@Table(name = "cash_register_customer")
public class Customer extends Person {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    Set<Address> addresses;

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }
}
