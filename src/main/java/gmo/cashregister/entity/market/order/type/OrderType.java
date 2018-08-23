package gmo.cashregister.entity.market.order.type;

import gmo.cashregister.entity.market.Tax;
import gmo.cashregister.entity.market.order.status.OrderStatus;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "cash_register_order_type")
public class OrderType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private Type type;

    @Column(length = 50)
    private String name;

    @OneToMany(mappedBy = "type")
    private Set<PositionStatus> statuses;

    @OneToOne
    @JoinColumn(name = "tax_id")
    private Tax tax;

    public long getId() {
        return id;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<PositionStatus> getStatuses() {
        return statuses;
    }

    public void setStatuses(Set<PositionStatus> statuses) {
        this.statuses = statuses;
    }

    public Tax getTax() {
        return tax;
    }

    public void setTax(Tax tax) {
        this.tax = tax;
    }
}
