package gmo.cashregister.services.market.menu;

import gmo.cashregister.entity.market.menu.Menu;
//import gmo.cashregister.entity.security.Menu;

import java.util.List;

public interface MenuService {
    public List<Menu> getMenus();

    public Menu getMenu(long id);

    public List<Menu> save(Menu menu);

    public List<Menu> update(Menu menu);

    public List<Menu> delete(long id);
}
