package gmo.cashregister.entity.market.order.status;

import javax.persistence.*;

@Entity
@Table(name = "cash_register_order_status")
public class OrderStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(length = 50)
    private String name;

    @Column(length = 50)
    private String nameAlt;

    @Column
    private String description;

    @Column(length = 75)
    private String color;

    @Column
    private String action;

    public long getId() {
        return id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameAlt() {
        return nameAlt;
    }

    public void setNameAlt(String nameAlt) {
        this.nameAlt = nameAlt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
