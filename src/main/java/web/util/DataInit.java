package web.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import web.model.Role;
import web.model.User;
import web.service.RoleService;
import web.service.UserService;
import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class DataInit {

    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public DataInit(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    public void startProject() {
        User user1 = new User();
        user1.setName("Bob");
        user1.setSurname("Smith");
        user1.setEmail("smith_b@gmail.com");
        user1.setLogin("admin");
        user1.setPassword("100");
        User user2 = new User();
        user2.setName("Jimm");
        user2.setSurname("Simmons");
        user2.setEmail("simmons_j@gmail.com");
        user2.setLogin("user");
        user2.setPassword("101");

        Role role1 = new Role("ROLE_USER");
        Role role2 = new Role("ROLE_ADMIN");
        Set<Role> setStartRoles = new HashSet<>();
        setStartRoles.add(role1);
        setStartRoles.add(role2);
        roleService.saveRole(setStartRoles);
        userService.addUser(user1, setStartRoles);
        setStartRoles = setStartRoles.stream().filter(r -> r.getName() == "ROLE_USER").collect(Collectors.toSet());
        userService.addUser(user2, setStartRoles);
    }
}
