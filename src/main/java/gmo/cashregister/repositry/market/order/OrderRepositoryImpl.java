package gmo.cashregister.repositry.market.order;

import gmo.cashregister.entity.market.order.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepositoryImpl implements OrderRepository {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Order getOrder(long id) {
        Order order = new Order();
        try {
            Session session = sessionFactory.getCurrentSession();
            session.get(Order.class, id);
        } catch (Exception e) {
            throw e;
        }
        return order;
    }
}
