package gmo.cashregister.entity.market.menu;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "cash_register_page")
public class Page {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(length = 50)
    private String code;

    @Column(length = 50)
    private String name;

    @Column
    private int columns;

    @Column
    private int rows;

    @OneToOne
    @JoinColumn(name="parent_id")
    private Page parent;

    @ManyToOne()
    @JoinColumn(name = "menu_id")
    private Menu menu;

    @OneToMany(mappedBy = "page")
    private Set<Item> items;

    public long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public Page getParent() {
        return parent;
    }

    public void setParent(Page parent) {
        this.parent = parent;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }
}
