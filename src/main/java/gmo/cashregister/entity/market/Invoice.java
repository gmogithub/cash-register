package gmo.cashregister.entity.market;

import gmo.cashregister.entity.market.order.Order;

import javax.persistence.*;
import javax.persistence.Table;

@Entity
@Table(name = "cash_register_invoice")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false, unique = true)
    private String code;

    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;

    public long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
