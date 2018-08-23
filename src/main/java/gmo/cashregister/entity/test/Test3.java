package gmo.cashregister.entity.test;

import javax.persistence.*;
import java.time.LocalDate;

//@Entity
//@Table(name = "test3")
public class Test3 {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(length = 50)
    private String code;

    @Column
    private LocalDate date;

    public long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
