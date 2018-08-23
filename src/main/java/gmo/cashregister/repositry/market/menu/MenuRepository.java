package gmo.cashregister.repositry.market.menu;

import gmo.cashregister.entity.market.menu.Menu;

import java.util.List;

public interface MenuRepository {

    public List<Menu> getMenus();

    public Menu getMenu(long id);

    public boolean save(Menu menu);

    public boolean update(Menu menu);

    public boolean delete(Menu menu);
}
