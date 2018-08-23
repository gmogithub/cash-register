package gmo.cashregister.entity.market;

import gmo.cashregister.entity.business.Store;

import javax.persistence.*;
import java.util.Set;

@Entity
@javax.persistence.Table(name = "cash_register_room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(length = 100)
    private String name;

    @OneToMany(mappedBy = "room")
    private Set<Table> tables;

    @OneToOne
    @JoinColumn(name = "store_id")
    private Store store;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Table> getTables() {
        return tables;
    }

    public void setTables(Set<Table> tables) {
        this.tables = tables;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }
}
