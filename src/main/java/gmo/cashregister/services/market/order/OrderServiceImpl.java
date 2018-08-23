package gmo.cashregister.services.market.order;

import gmo.cashregister.entity.market.order.Order;
import gmo.cashregister.repositry.market.order.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    @Transactional
    public Order getOrder(long id) {
        return null;
    }
}
