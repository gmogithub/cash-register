package gmo.cashregister.entity.market.order;

import gmo.cashregister.entity.market.Payment;

import javax.persistence.*;

@Entity
@Table(name = "cash_register_order_payment")
public class OrderPayment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;


    @OneToOne
    @JoinColumn(name = "payment_id")
    private Payment payment;

    @Column
    private Double amount;

    public long getId() {
        return id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
