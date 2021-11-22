package web.service;

import web.model.Role;
import web.model.User;
import java.util.List;
import java.util.Set;

public interface UserService {

    User getUserByUsername(String userName);

    User getUserById(int id);

    void addUser(User user, Set<Role> roles);

    void delete(int id);

    List<User> getAllUsers();

    void update(User user);
}
