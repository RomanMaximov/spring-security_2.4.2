package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;
import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //@GetMapping("/userpage")
    @GetMapping("/page")
    public String getPrincipal(@CurrentSecurityContext(expression = "authentication.principal")
                               Principal principal,
                               Model model) {
        User tmp = userService.getUserByUsername(principal.getName());
        model.addAttribute("showUser", tmp);
        return "userpage";
    }
}
