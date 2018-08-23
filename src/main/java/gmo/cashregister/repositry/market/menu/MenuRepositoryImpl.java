package gmo.cashregister.repositry.market.menu;

import gmo.cashregister.entity.market.menu.Menu;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MenuRepositoryImpl implements MenuRepository {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Menu> getMenus() {
        List<Menu> menus = new ArrayList<>();
        try {
            Session session = sessionFactory.getCurrentSession();
            Query<Menu> query = session.createQuery("From Menu m", Menu.class);
            menus = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return menus;
    }

    @Override
    public Menu getMenu(long id) {
        Menu menu = new Menu();
        try {
            Session session = sessionFactory.getCurrentSession();
            menu = session.get(Menu.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return menu;
    }

    @Override
    public boolean save(Menu menu) {
        boolean hasSave = true;
        try {
            Session session = sessionFactory.getCurrentSession();
            session.save(menu);
        } catch (Exception e) {
            e.printStackTrace();
            hasSave = false;
        }
        return hasSave;
    }

    @Override
    public boolean update(Menu menu) {
        boolean hasUpdate = true;
        try {
            Session session = sessionFactory.getCurrentSession();
            session.update(menu);
        } catch (Exception e) {
            e.printStackTrace();
            hasUpdate = false;
        }
        return hasUpdate;
    }

    @Override
    public boolean delete(Menu menu) {
        boolean hasDelete = true;
        try {
            Session session = sessionFactory.getCurrentSession();
            session.delete(menu);
        } catch (Exception e) {
            e.printStackTrace();
            hasDelete = false;
        }
        return hasDelete;
    }
}
