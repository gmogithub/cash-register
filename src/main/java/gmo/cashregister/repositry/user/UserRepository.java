package gmo.cashregister.repositry.user;

import gmo.cashregister.entity.person.User;

import java.util.List;

public interface UserRepository {
    public boolean save(User user);

    public boolean update(User user);

    public List<User> getUsers();

    public User getUser(String username);

    void delete(User user);

    void delete(String username);

    public User findUserByUsername(String username);
}
