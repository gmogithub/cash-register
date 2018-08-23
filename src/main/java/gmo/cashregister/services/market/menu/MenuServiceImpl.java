package gmo.cashregister.services.market.menu;

import gmo.cashregister.entity.market.menu.Menu;
import gmo.cashregister.repositry.market.menu.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    MenuRepository menuRepository;


    @Override
    @Transactional
    public List<Menu> getMenus() {
        return menuRepository.getMenus();
    }

    @Override
    @Transactional
    public Menu getMenu(long id) {
        return menuRepository.getMenu(id);
    }

    @Override
    @Transactional
    public List<Menu> save(Menu menu) {
        menuRepository.save(menu);
        return menuRepository.getMenus();
    }

    @Override
    @Transactional
    public List<Menu> update(Menu menu) {
        menuRepository.update(menu);
        return menuRepository.getMenus();
    }

    @Override
    @Transactional
    public List<Menu> delete(long id) {
        Menu menu = menuRepository.getMenu(id);
        menuRepository.delete(menu);
        return menuRepository.getMenus();
    }
}
