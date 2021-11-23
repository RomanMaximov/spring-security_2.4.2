package web.dao;

import web.model.Role;
import web.model.User;
import java.util.List;
import java.util.Set;

public interface UserDao {

    User getUserById(int id);
    User getUserByUsername(String userName);
    void delete(int id);
    List<User> getAllUsers();
    void addUser(User user, Set<Role> roles);
    void update(User user);
}
