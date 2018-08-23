package gmo.cashregister.entity.market.order.type;

import gmo.cashregister.entity.market.order.status.OrderStatus;
import gmo.cashregister.entity.market.order.type.OrderType;

import javax.persistence.*;

@Entity
@Table(name = "cash_register_position_status")
public class PositionStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name= "type_id")
    private OrderType type;


    @OneToOne
    @JoinColumn(name = "status_id")
    private OrderStatus status;

    @Column(columnDefinition = "smallint unsigned")
    private int pos;

    public long getId() {
        return id;
    }

    public OrderType getType() {
        return type;
    }

    public void setType(OrderType type) {
        this.type = type;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }
}
