package gmo.cashregister.entity.test.listener;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

public class TestListener {
    @PrePersist
    public void onPrePersist() {
        System.out.println("persis =============");
    }


    @PreUpdate
    public void onPreUpdate() {
        System.out.println("update =============");
    }
}
