package gmo.cashregister.entity.market;

import javax.persistence.*;
import javax.persistence.Table;

/**
 *
 * @description Marque d'un produit / Brand of product
 */
@Entity
@Table(name = "cash_register_brand")
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name", length = 200)
    private String name;

    @Column(name = "code", length = 50)
    private String code;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
