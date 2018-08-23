package gmo.cashregister.entity.market;

import javax.persistence.*;
import javax.persistence.Table;

@Entity
@Table(name = "cash_register_composition")
public class Composition {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @OneToOne
    @JoinColumn(name = "composition_id")
    private Product composition;

    @Column
    private boolean active;

    @Column
    private double price;

    public long getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Product getComposition() {
        return composition;
    }

    public void setComposition(Product composition) {
        this.composition = composition;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
