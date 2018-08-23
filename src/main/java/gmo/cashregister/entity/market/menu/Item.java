package gmo.cashregister.entity.market.menu;

import gmo.cashregister.entity.market.Category;
import gmo.cashregister.entity.market.Product;

import javax.persistence.*;
import javax.persistence.Table;

@Entity
@Table(name = "cash_register_item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(length = 50)
    private String name;

    @Column(length = 50)
    private String color;

    @Column(length = 50)
    private String background;

    @Column(name = "nb_column")
    private int nbColumn;

    @Column(name = "nb_row")
    private int nbRow;

    @ManyToOne
    @JoinColumn(name = "page_id")
    private Page page;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @OneToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToOne
    @JoinColumn(name = "target_id")
    private Page target;

    @OneToOne
    @JoinColumn(name = "include_id")
    private Page include;

    @Column
    private double realPrice;

    @Column
    private double price;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public int getNbColumn() {
        return nbColumn;
    }

    public void setNbColumn(int nbColumn) {
        this.nbColumn = nbColumn;
    }

    public int getNbRow() {
        return nbRow;
    }

    public void setNbRow(int nbRow) {
        this.nbRow = nbRow;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Page getTarget() {
        return target;
    }

    public void setTarget(Page target) {
        this.target = target;
    }

    public Page getInclude() {
        return include;
    }

    public void setInclude(Page include) {
        this.include = include;
    }

    public double getRealPrice() {
        return realPrice;
    }

    public void setRealPrice(double realPrice) {
        this.realPrice = realPrice;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
