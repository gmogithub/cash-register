package gmo.cashregister.entity.market;

import javax.persistence.*;

@Entity
@javax.persistence.Table(name = "cash_register_table")
public class Table {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(length = 100)
    private String name;

    @Column
    private int numberOfPlaces;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    public long getId() {
        return id;
    }

    public int getNumberOfPlaces() {
        return numberOfPlaces;
    }

    public void setNumberOfPlaces(int numberOfPlaces) {
        this.numberOfPlaces = numberOfPlaces;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
