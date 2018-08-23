package gmo.cashregister.services.admin;

import gmo.cashregister.entity.security.Right;

import java.util.List;

public interface RightService {
    public List<Right> getRights();

    public Right getRight(long id);

    public List<Right> save(Right right);

    public List<Right> update(Right right);

    public List<Right> delete(long id);
}
