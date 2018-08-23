package gmo.cashregister.entity.test;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import gmo.cashregister.entity.test.listener.TestListener;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

//@Entity
//@JsonIgnoreProperties(value = {"date"})
//@EntityListeners(TestListener.class)
public class Test {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(length = 50)
    private String code;

    @Column
//    @CreatedDate
    @CreatedDate
    private LocalDate date;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "test", targetEntity = Test2.class)
    private Set<Test2> test2s;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "test3_id")
    private Test3 test3;

    @Column
    private boolean active;

    @Column
    private int count;

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Test3 getTest3() {
        return test3;
    }

    public void setTest3(Test3 test3) {
        this.test3 = test3;
    }

    public Set<Test2> getTest2s() {
        return test2s;
    }

    public void setTest2s(Set<Test2> test2s) {
        this.test2s = test2s;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public long getId() {
        return id;
    }

//    public void setId(long id) {
//        this.id = id;
//    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


}
