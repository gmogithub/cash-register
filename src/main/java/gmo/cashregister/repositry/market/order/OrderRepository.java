package gmo.cashregister.repositry.market.order;

import gmo.cashregister.entity.market.order.Order;


public interface OrderRepository {

    public Order getOrder(long id);
}
