package gmo.cashregister.repositry.admin;

import gmo.cashregister.entity.security.Right;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RightRepositoryImpl implements RightRepository {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Right> getRights() {
        List<Right> rights = new ArrayList<>();
        try {
            Session session = sessionFactory.getCurrentSession();
            Query<Right> query = session.createQuery("From Right r", Right.class);
            rights = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rights;
    }

    @Override
    public Right getRight(long id) {
        Right right = new Right();
        try {
            Session session = sessionFactory.getCurrentSession();
            right = session.get(Right.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return right;
    }

    @Override
    public boolean save(Right right) {
        try {
            Session session = sessionFactory.getCurrentSession();
            session.save(right);
            // right = session.get(Right.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean update(Right right) {
        try {
            Session session = sessionFactory.getCurrentSession();
            session.update(right);
            // right = session.get(Right.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean delete(Right right) {
        try {
            Session session = sessionFactory.getCurrentSession();
            session.delete(right);
            // right = session.get(Right.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
