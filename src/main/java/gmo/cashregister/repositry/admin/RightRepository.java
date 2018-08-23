package gmo.cashregister.repositry.admin;

import gmo.cashregister.entity.security.Right;

import java.util.List;

public interface RightRepository {

    public List<Right> getRights();

    public Right getRight(long id);

    public boolean save(Right right);

    public boolean update(Right right);

    public boolean delete(Right right);
}
