package web.controllers;


import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sun.security.acl.PrincipalImpl;
import web.model.User;
import web.services.Services;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    private final Services<User> userService;

    public UserController(Services<User> userService) {
        this.userService = userService;
    }


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String startPage() {

        return "welcome";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String printWelcome(Model model, Principal principal) {
        User user = userService.getByName(principal.getName());
        model.addAttribute("user", user);
        return "user/hellouser";
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }

    @RequestMapping(value = "error")
    public String errorPage() {
        return "denied";
    }
}
