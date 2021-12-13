package web.controllers;


import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import web.model.User;
import web.services.Services;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final Services<User> userService;

    public AdminController(Services<User> userService) {
        this.userService = userService;
    }

    @RequestMapping("/all")
    public String showAllUsers(Model model) {
        List<User> usersList = userService.getList();
        model.addAttribute("allUsers", usersList);
        return "admin/all-users";
    }

    @RequestMapping("/addNewUser")
    public String addNewUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "admin/user-info";
    }

    @RequestMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/admin/all";
    }

    @RequestMapping("/updateUser/{id}")
    public String updateUser(@PathVariable(value = "id") Long id, Model model) {
        User user = userService.getById(id);
        model.addAttribute("user", user);

        return "admin/user-info";
    }

    @RequestMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable(value = "id") Long id) {
        userService.remove(id);
        return "redirect:/admin/all";
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String adminRoom(Model model) {
        User user = userService.getByName(SecurityContextHolder.getContext()
                .getAuthentication().getName());
        model.addAttribute("user", user);
        return "admin/helloadmin";
    }
}
