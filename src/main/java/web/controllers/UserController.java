package web.controllers;

import org.springframework.ui.ModelMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

//    private final Service<User> userService;
//
//    public UserController(Service<User> userService) {
//        this.userService = userService;
//    }

//    @RequestMapping("/")
//    public String startPage() {
//
//        return "welcome";
//    }

//    @RequestMapping("/all")
//    public String showAllUsers(Model model) {
//        List<User> usersList = userService.getList();
//        model.addAttribute("allUsers", usersList);
//        return "all-users";
//    }
//
//    @RequestMapping("/addNewUser")
//    public String addNewUser(Model model) {
//        User user = new User();
//        model.addAttribute("user", user);
//        return "user-info";
//    }
//
//    @RequestMapping("/saveUser")
//    public String saveUser(@ModelAttribute("user") User user) {
//        userService.save(user);
//        return "redirect:/all";
//    }
//
//    @RequestMapping("/updateUser/{id}")
//    public String updateUser(@PathVariable(value = "id") Long id, Model model) {
//        User user = userService.getById(id);
//        model.addAttribute("user", user);
//
//        return "user-info";
//    }
//
//    @RequestMapping("/deleteUser/{id}")
//     public String deleteUser(@PathVariable(value = "id") Long id) {
//        userService.remove(id);
//        return "redirect:/all";
//     }
//
//     @GetMapping("/authenticated")
//    public String authenticatedUsersPage(Principal principal) {
//        User user = userService.getByName(principal.getName());
//        return "secured part of web service" + principal.getName() + " " + user.getEmail();
//     }
//
//     @GetMapping("/read_profile")
//    public String pageForReadProfile() {
//        return "read prrofile page";
//     }

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        List<String> messages = new ArrayList<>();
        messages.add("Hello!");
        messages.add("I'm Spring MVC-SECURITY application");
        messages.add("5.2.0 version by sep'19 ");
        model.addAttribute("messages", messages);
        return "hello";
    }

//    @RequestMapping(value = "login", method = RequestMethod.GET)
//    public String loginPage() {
//        return "login";
//    }
}
