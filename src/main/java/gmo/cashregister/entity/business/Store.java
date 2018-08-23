package gmo.cashregister.entity.business;

import gmo.cashregister.entity.Address;

import javax.persistence.*;
//

/**
 * @description Boutique/Restaurant qui est lié à la société / Shop/Restaurant that is related to society
 */

@Entity
@Table(name = "cash_register_store")
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "name", length = 200)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "active")
    private boolean active = false;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @ManyToOne
    @JoinColumn(name = "society_id")
    private Society society;


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

    public Society getSociety() {
        return society;
    }

    public void setSociety(Society society) {
        this.society = society;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
