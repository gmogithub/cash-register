package gmo.cashregister.controller.market;

import gmo.cashregister.entity.market.order.Order;
import gmo.cashregister.services.market.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("/{id}")
    public Order order(@PathVariable(value = "id") long id) {
        return orderService.getOrder(id);
    }
}
