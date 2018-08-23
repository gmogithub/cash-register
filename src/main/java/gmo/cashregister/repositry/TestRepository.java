package gmo.cashregister.repositry;

import gmo.cashregister.entity.test.Test;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class TestRepository {
    @Autowired
    SessionFactory sessionFactory;
    @Transactional
    public boolean save (Test test) {
        boolean hasSave = true;
        try {
            sessionFactory.getCurrentSession().save(test);
        } catch (Exception e) {
            e.printStackTrace();
            hasSave = false;
        }

        return hasSave;
    }
}
