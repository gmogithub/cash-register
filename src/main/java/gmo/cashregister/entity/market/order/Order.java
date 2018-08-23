package gmo.cashregister.entity.market.order;

import gmo.cashregister.entity.Address;
import gmo.cashregister.entity.market.Invoice;
import gmo.cashregister.entity.market.Table;
import gmo.cashregister.entity.market.order.status.OrderStatus;
import gmo.cashregister.entity.market.order.type.OrderType;
import gmo.cashregister.entity.person.Customer;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@javax.persistence.Table(name = "cash_register_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(unique = true, nullable = false)
    private String code;

    @Column
    private LocalDateTime date;

    @Column(name = "dt_start")
    private LocalDateTime dtStart;

    @Column(name = "dt_end")
    private LocalDateTime dtEnd;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToOne
    @JoinColumn(name = "table_id")
    private Table table;

    @OneToOne
    @JoinColumn(name = "status_id")
    private OrderStatus status;

    @OneToOne
    @JoinColumn(name = "type_id")
    private OrderType type;

    @OneToOne(mappedBy = "order")
    private Invoice invoice;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private Set<OrderPayment> payments;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    Set<LineOrder> lineOrders;

    @Column
    private double reduction;

    public long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public LocalDateTime getDtStart() {
        return dtStart;
    }

    public void setDtStart(LocalDateTime dtStart) {
        this.dtStart = dtStart;
    }

    public LocalDateTime getDtEnd() {
        return dtEnd;
    }

    public void setDtEnd(LocalDateTime dtEnd) {
        this.dtEnd = dtEnd;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public OrderType getType() {
        return type;
    }

    public void setType(OrderType type) {
        this.type = type;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public Set<OrderPayment> getPayments() {
        return payments;
    }

    public void setPayments(Set<OrderPayment> payments) {
        this.payments = payments;
    }

    public Set<LineOrder> getLineOrders() {
        return lineOrders;
    }

    public void setLineOrders(Set<LineOrder> lineOrders) {
        this.lineOrders = lineOrders;
    }

    public double getReduction() {
        return reduction;
    }

    public void setReduction(double reduction) {
        this.reduction = reduction;
    }
}
