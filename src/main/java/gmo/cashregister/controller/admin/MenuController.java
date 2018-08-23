package gmo.cashregister.controller.admin;

import gmo.cashregister.entity.market.menu.Menu;
import org.hibernate.validator.constraints.URL;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("admin/menus")
public class MenuController {
    public List<Menu> save() {
        List<Menu> menus = null;
        return menus;
    }
}
