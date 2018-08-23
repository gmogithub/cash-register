package gmo.cashregister.repositry.user;

import gmo.cashregister.entity.person.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public boolean save(User user) {
        return false;
    }

    @Override
    public boolean update(User user) {
        return false;
    }

    @Override
    public List<User> getUsers() {
        return null;
    }

    @Override
    public User getUser(String username) {
        return null;
    }

    @Override
    public void delete(User user) {

    }

    @Override
    public void delete(String username) {

    }

    @Override
    public User findUserByUsername(String username) {
        User user = null;
        try {
//            Session session = sessionFactory.getCurrentSession().getEntityManagerFactory().createEntityManager(); recuperer entity manager a partir du sesion factory de hibernate
            Session session = sessionFactory.getCurrentSession();
            user = session.get(User.class, username);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }
}
