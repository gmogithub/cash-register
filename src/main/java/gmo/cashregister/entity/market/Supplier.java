package gmo.cashregister.entity.market;

import gmo.cashregister.entity.Address;

import javax.persistence.*;
import javax.persistence.Table;

@Entity
@Table(name = "cash_register_supplier")
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(length = 50)
    private String name;

    @Column
    private String description;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
